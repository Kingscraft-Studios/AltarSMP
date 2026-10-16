#!/usr/bin/env python3
"""Bulk-fix decompiler duplicated-literal artifacts, using the jar's indy recipe as truth.

Logic per site:
  - locate the enclosing method in the jar
  - find every makeConcatWithConstants in it, read its BootstrapMethod recipe
  - n_placeholders = number of \u0001 in the recipe = TRUE operand count
  - if the source emits more operands than the recipe has placeholders, the
    decompiler fabricated duplicates -> collapse to the recipe's operand count
  - a site is only rewritten when exactly ONE recipe in the method is a candidate,
    so we never guess among several concats
Reports every decision; touches nothing it is not sure about.
"""
import re
import subprocess
import sys

JAR = "/home/kingscrafts/Documents/AltarSMP.jar"
PREFIX = "You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764"
SRC = "/Projects/AltarSMP/src/main/java/pl"
DRY = "--apply" not in sys.argv


def javap(cls, verbose=True):
    full = f"pl.{PREFIX}{cls}"
    args = ["javap"] + (["-v"] if verbose else ["-p", "-c"]) + ["-p", "-cp", JAR, full]
    return subprocess.run(args, capture_output=True, text=True).stdout.replace(
        PREFIX, "P").replace(f"pl/{PREFIX}", "P")


def recipe_map(text):
    out = {}
    m = re.search(r"^BootstrapMethods:\n(.*)", text, re.S | re.M)
    if not m:
        return out
    cur, pending = None, False
    for line in m.group(1).splitlines():
        em = re.match(r"^  (\d+): #", line)
        if em:
            cur, pending = int(em.group(1)), True
            continue
        if "Method arguments:" in line:
            continue
        am = re.match(r"^      #\d+\s+(.*)$", line)
        if am and pending and cur is not None:
            rec = am.group(1).rstrip()
            out[cur] = (rec.count("\\u0001"), rec)
            pending = False
    return out


def method_spans(text):
    lines = text.splitlines()
    idx = [i for i, L in enumerate(lines) if re.match(r"^  \S.*\);$", L)]
    spans = []
    for n, i in enumerate(idx):
        end = idx[n + 1] if n + 1 < len(idx) else len(lines)
        spans.append((lines[i].strip(), i, end, lines))
    return spans


DUP = re.compile(r'"([^"]{1,80})" \+ "\1"')


def process(cls, lineno):
    path = f"{SRC}/{PREFIX}{cls}.java"
    with open(path) as f:
        src = f.readlines()
    i = lineno - 1
    line = src[i]
    hits = list(DUP.finditer(line))
    if not hits:
        return f"{cls}:{lineno}  no dup-literal on this line"

    # enclosing method header: walk back to a line ending in ") {" or ");"
    hdr = None
    for j in range(i, -1, -1):
        s = src[j].rstrip()
        if re.match(r"^  \S.*\)\s*\{\s*$", s):
            hdr = s
            break
        if re.match(r"^  \S.*\)\s*;?\s*$", s) and "=" not in s:
            hdr = s
            break
        if re.match(r"^  \}", s):
            break

    text = javap(cls)
    rs = recipe_map(text)
    spans = method_spans(text)
    want = None
    if hdr:
        m = re.search(r"([A-Za-z0-9_$]+)\(", hdr)
        if m:
            nm = m.group(1)
            if nm.startswith("You_are_an_idiot"):
                # full obf identifier: strip the constant prefix, keep the tail
                want = nm[len(PREFIX):]
            else:
                want = nm

    def tail(n):
        n = str(n)
        # jar renders short method names as P<short>; source has the bare <short>
        return n[1:] if n.startswith("P") and len(n) > 1 else n

    cands = []
    for sig, s, e, lines in spans:
        mn = re.search(r"([A-Za-z0-9_$]+)\(", sig)
        if not mn:
            continue
        if tail(mn.group(1)) != tail(want):
            continue
        cands.append((sig, s, e, lines))

    if not cands:
        return f"{cls}:{lineno}  !! could not locate method [{want}]"
    if len(cands) > 1:
        # disambiguate overloads: pick the one whose body invokes the call that
        # appears on the decompiled source line (e.g. sendMessage / warning / setLore)
        m = re.search(r"\.(\w+)\(", line)
        callee = m.group(1) if m else None
        if callee:
            narrowed = [c for c in cands
                        if any(f".{callee}:" in L for L in c[3][c[1]:c[2]])]
            if len(narrowed) == 1:
                cands = narrowed
    if len(cands) != 1:
        return f"{cls}:{lineno}  !! {len(cands)} method overloads match, refusing"
    sig, ms, me, mlines = cands[0]
    indys = []
    for L in mlines[ms:me]:
        im = re.search(r"InvokeDynamic #(\d+):makeConcatWithConstants", L)
        if im:
            bsm = int(im.group(1))
            if bsm in rs:
                indys.append((bsm, rs[bsm][0], rs[bsm][1]))
    if len(indys) != 1:
        return f"{cls}:{lineno}  !! {len(indys)} concat sites in method, refusing"
    bsm, n, rec = indys[0]
    return (f"{cls}:{lineno}  recipe={n}ph {rec[:28]!r}  dups={len(hits)}  "
            f"{sig[:60]}")


if __name__ == "__main__":
    for spec in sys.argv[1:]:
        if spec.startswith("--"):
            continue
        c, l = spec.split(":")
        print(process(c, int(l)))
