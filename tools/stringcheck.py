#!/usr/bin/env python3
"""Phase 1 checker: find decompiler-damaged concat/string sites by comparing the
ORIGINAL jar's true concat expressions against the recompiled current source.

Inputs:
  tools/classmap.tsv          source-file -> jar-class
  /tmp/opencode/truth_orig.tsv  ConcatTruth --orig (class, method, desc, ord, line, recipe, expr)
  /tmp/opencode/truth_new.tsv   ConcatTruth --new  (same, with real line numbers)
  src/main/java/pl/*.java       current source (for the line text)

Sites are keyed by (jar-class, descriptor-normalized method descriptor) so that
the remap's method renames do not break alignment; within a key they are matched
by ordinal. Any expression mismatch is a candidate decompiler bug.
"""
import os, re, sys, collections

ROOT = "/Projects/AltarSMP"
SRC = os.path.join(ROOT, "src/main/java/pl")
CLASSMAP = os.path.join(ROOT, "tools/classmap.tsv")
ORIG = "/tmp/opencode/truth_orig.tsv"
NEW = "/tmp/opencode/truth_new.tsv"
OUT = "/tmp/opencode/stringcheck.tsv"

PREFIX = "You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764"


def load_classmap():
    src2obf = {}
    for line in open(CLASSMAP, encoding="utf-8").read().splitlines()[1:]:
        a = line.split("\t")
        if len(a) >= 2 and a[1] != "?":
            src2obf[a[0]] = a[1]
    return src2obf


def norm_desc(d, src2obf):
    out, i = [], 0
    while i < len(d):
        if d.startswith("Lpl/", i):
            j = d.index(";", i)
            name = d[i + 4:j]
            out.append("Lpl/" + src2obf.get(name, name) + ";")
            i = j + 1
        else:
            out.append(d[i])
            i += 1
    return "".join(out)


def load_truth(path, src2obf, is_new):
    rows = []
    for line in open(path, encoding="utf-8", errors="replace"):
        f = line.rstrip("\n").split("\t")
        if len(f) < 7 or f[0].startswith("#"):
            continue
        cls = f[0]
        if cls.startswith("pl."):
            cls = cls[3:]
        if is_new:
            obf = src2obf.get(cls, cls)
            desc = norm_desc(f[2], src2obf)
        else:
            obf, desc = cls, f[2]
        rows.append({
            "cls": obf, "srccls": cm_rev.get(obf, cls) if is_new else cls,
            "method": f[1], "desc": desc, "ord": int(f[3]),
            "line": int(f[4]), "recipe": f[5], "expr": f[6],
        })
    return rows


cm_rev = {}


def noperands(expr):
    """top-level '+' operand list of a rendered expression"""
    parts, depth, cur, i, n, instr = [], 0, [], 0, len(expr), None
    while i < n:
        c = expr[i]
        if instr:
            cur.append(c)
            if c == "\\":
                if i + 1 < n:
                    cur.append(expr[i + 1])
                i += 2
                continue
            if c == instr:
                instr = None
            i += 1
            continue
        if c in "\"'":
            instr = c
            cur.append(c)
        elif c in "([{":
            depth += 1
            cur.append(c)
        elif c in ")]}":
            depth -= 1
            cur.append(c)
        elif c == "+" and depth == 0:
            parts.append("".join(cur).strip())
            cur = []
        else:
            cur.append(c)
        i += 1
    parts.append("".join(cur).strip())
    return [p for p in parts if p != ""]


_CC_ENUM = re.compile(r"ChatColor\.[A-Z_]+$")


def shape(p):
    """Canonical token for one operand, erasing obf<->readable name differences.

    Literal content is preserved (so duplicate literals still stand out), but
    class/member/call/param identity is collapsed to a structural token."""
    p = p.strip()
    if not p:
        return "@EMPTY"
    # string literal
    if p[0] == '"' and p[-1] == '"':
        inner = p[1:-1]
        inner = re.sub(r"\\u([0-9a-fA-F]{4})", lambda m: chr(int(m.group(1), 16)), inner)
        return "L:" + inner
    if p.startswith("@DEC("):
        return "@DEC"
    m = re.match(r"String\.valueOf\((.*)\)$", p)
    if m:
        return "VO(" + shape(m.group(1)) + ")"
    if _CC_ENUM.match(p):
        return p
    if p.startswith("ChatColor.of("):
        return "CCOF"
    if p.startswith("@"):
        if re.match(r"@P\d+$", p):
            return "@P"
        if re.match(r"@V\d+$", p):
            return "@V"
        if p in ("@F", "@THIS", "@O", "@UF", "@W", "@N", "@C"):
            return p
        if p.startswith("@INDY"):
            return "@INDY"
        m = re.match(r"@O\d+$", p)
        if m:
            return "@O"
        return "@CALL" if "." in p else "@VAR"
    if re.match(r"^-?\d+$", p):
        return "NUM"
    return p


def shapes(expr):
    return [shape(p) for p in noperands(expr)]


def classify(oexpr, nexpr):
    """Heuristic verdict for a differing pair."""
    oo, no = noperands(oexpr), noperands(nexpr)
    oset, nset = collections.Counter(oo), collections.Counter(no)
    if oset == nset:
        return "ORDER-ONLY"
    # duplicated operand in one side
    dupn = [k for k, v in nset.items() if v > oset[k]]
    dupo = [k for k, v in oset.items() if v > nset[k]]
    if dupn:
        return "NEW-DUP:" + "|".join(sorted(dupn)[:3])
    if dupo:
        return "ORIG-DUP:" + "|".join(sorted(dupo)[:3])
    if len(oo) != len(no):
        return f"COUNT({len(oo)}->{len(no)})"
    return "DIFF"


RE_UNICODE_ESC = re.compile(r"\\u[0-9a-fA-F]{4}")
RE_CLASS_A = re.compile(r'=\s*""\s*\+')
RE_CHAR_LITERAL = re.compile(r"'([^'\\])'")


def scan_source():
    """Source-level lint for the two artifact classes the bytecode-vs-bytecode
    truth comparison cannot see:

      Class A  - a folded empty-string concat, e.g. `s = "" + "lit"` or the
                 damaged self-accumulator `s = "" + ...` inside a loop.
      Class C  - a `\\uXXXX` text escape (the tree convention is UTF-8 literals)
                 or a char literal that is really a numeric constant.

    Returns a list of (verdict, file, line, text)."""
    out = []
    for root, _, files in os.walk(SRC):
        for fn in files:
            if not fn.endswith(".java"):
                continue
            path = os.path.join(root, fn)
            rel = os.path.relpath(path, SRC)
            for i, line in enumerate(open(path, encoding="utf-8", errors="replace"), 1):
                if RE_UNICODE_ESC.search(line):
                    out.append(("SOURCE-UNICODE-ESCAPE", rel, i, line.rstrip()))
                if RE_CLASS_A.search(line):
                    out.append(("SOURCE-CLASS-A-EMPTY", rel, i, line.rstrip()))
                for m in RE_CHAR_LITERAL.finditer(line):
                    if ord(m.group(1)) > 0x7f and "append(" not in line:
                        out.append(("SOURCE-CHAR-LITERAL", rel, i, line.rstrip()))
                        break
    return out


def main():
    global cm_rev
    src2obf = load_classmap()
    for s, o in src2obf.items():
        cm_rev.setdefault(o, s)
    orig = load_truth(ORIG, src2obf, False)
    new = load_truth(NEW, src2obf, True)

    ok = collections.defaultdict(list)
    nk = collections.defaultdict(list)
    for r in orig:
        ok[(r["cls"], r["desc"])].append(r)
    for r in new:
        nk[(r["cls"], r["desc"])].append(r)
    for d in (ok, nk):
        for k in d:
            d[k].sort(key=lambda r: r["ord"])

    out = []
    for k in sorted(set(ok) | set(nk)):
        ov, nv = ok.get(k, []), nk.get(k, [])
        if not nv:
            for r in ov:
                if "@DEC(" in r["expr"]:
                    continue
                out.append(("ORIG-ONLY", k, r["method"], r["line"], r["expr"], ""))
            continue
        if not ov:
            # only report classes that actually exist in the jar (skip vendored libs)
            if not k[0].startswith(PREFIX) and k[0] not in cm_rev:
                continue
            for r in nv:
                if "@DEC(" in r["expr"]:
                    continue
                out.append(("NEW-ONLY", k, r["method"], r["line"], "", r["expr"]))
            continue
        for i in range(min(len(ov), len(nv))):
            o, n = ov[i], nv[i]
            if o["expr"] == n["expr"]:
                continue
            if "@DEC(" in o["expr"] or "@DEC(" in n["expr"]:
                continue
            # name-only rendering difference: identical structure -> benign
            if shapes(o["expr"]) == shapes(n["expr"]):
                continue
            out.append((classify(o["expr"], n["expr"]), k, n["method"],
                        n["line"], o["expr"], n["expr"]))
        if len(ov) != len(nv):
            out.append((f"COUNT-MISMATCH({len(ov)} vs {len(nv)})", k,
                        nv[0]["method"], -1, "", ""))

    with open(OUT, "w", encoding="utf-8") as f:
        f.write("verdict\tclass\tmethod\tdesc\tline\torig_expr\tnew_expr\n")
        for v, k, m, line, oe, ne in out:
            f.write(f"{v}\t{k[0]}\t{m}\t{k[1]}\t{line}\t{oe}\t{ne}\n")

    cnt = collections.Counter(v.split(":")[0].split("(")[0] for v, *_ in out)
    print("findings:", len(out), dict(cnt), file=sys.stderr)
    print(f"wrote {OUT}", file=sys.stderr)
    # print the interesting ones
    for v, k, m, line, oe, ne in out:
        tag = k[0].replace(PREFIX, "").replace("pl.", "")
        print(f"[{v}] {tag}::{m}{k[1]} line={line}")
        print(f"    orig: {oe}")
        print(f"    new : {ne}")

    src = scan_source()
    scnt = collections.Counter(v for v, *_ in src)
    print(f"source-scan findings: {len(src)} {dict(scnt)}", file=sys.stderr)
    for v, rel, line, text in src:
        print(f"[{v}] {rel}:{line}")
        print(f"    {text}")


if __name__ == "__main__":
    main()
