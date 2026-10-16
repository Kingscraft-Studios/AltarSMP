#!/usr/bin/env python3
"""Classify duplicated-literal concat sites: is the doubled literal real, or a decompiler artifact?

For each site, locate the enclosing method in the jar, find the relevant invokedynamic,
and compare (a) the recipe's placeholder count against (b) the number of operand pushes.
If the recipe has fewer placeholders than the decompiler emitted operands, the duplicate
is fabricated and the source needs fixing.
"""
import re
import subprocess
import sys

JAR = "/home/kingscrafts/Documents/AltarSMP.jar"
PREFIX = "You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764"
SRC = "/Projects/AltarSMP/src/main/java/pl"


def javap(cls):
    full = f"pl.{PREFIX}{cls}"
    out = subprocess.run(["javap", "-v", "-p", "-c", "-cp", JAR, full],
                         capture_output=True, text=True).stdout
    return out.replace(PREFIX, "P").replace(f"pl/{PREFIX}", "P")


def recipes(text):
    """return {bsm_index: (n_placeholders, recipe_string)}"""
    out = {}
    m = re.search(r"^BootstrapMethods:\n(.*)", text, re.S | re.M)
    if not m:
        return out
    body = m.group(1)
    # entries look like:  "  12: #52 REF_invokeStatic ..." then "    Method arguments:" then args
    cur = None
    pending = False
    for line in body.splitlines():
        em = re.match(r"^  (\d+): #", line)
        if em:
            cur = int(em.group(1))
            pending = True
            continue
        if "Method arguments:" in line:
            continue
        am = re.match(r"^      #\d+\s+(.*)$", line)
        if am and pending and cur is not None:
            recipe = am.group(1).rstrip()
            n = recipe.count("\\u0001")
            out[cur] = (n, recipe)
            pending = False
    return out


def methods(text):
    """return [(sig, start, end, lines)] over the -c body, de-obfuscated for matching"""
    lines = text.splitlines()
    idx = [i for i, L in enumerate(lines) if re.match(r"^  \S.*\);$", L)]
    res = []
    for n, i in enumerate(idx):
        end = idx[n + 1] if n + 1 < len(idx) else len(lines)
        res.append((lines[i].strip(), i, end, lines))
    return res


def short(sig):
    """normalize an obfuscated sig to a comparable short form"""
    return re.sub(r"You_are_an_idiot\w*?(?=[a-z0-9_]*\()", "", sig)


def sig_key(sig):
    m = re.search(r"([A-Za-z0-9_$]+)\(", sig)
    if not m:
        return None
    n = m.group(1)
    # de-obfuscated names end with the real short name: ...239764ab -> ab
    if n.startswith("P") and re.fullmatch(r"P[a-z0-9_]+", n) and len(n) > 3:
        return n
    return n


def norm(n):
    """Pabcdef -> abcdef (strip the obf prefix marker), else identity"""
    if n and n.startswith("P") and len(n) > 1:
        return n[1:]
    return n


def site_line_context(cls, lineno):
    """Return the source line and the method sig containing it."""
    path = f"{SRC}/{PREFIX}{cls}.java"
    with open(path) as f:
        lines = f.readlines()
    # walk backwards to method header
    hdr = None
    for i in range(lineno - 1, -1, -1):
        if re.match(r"^  (public|private|protected|static|\w).*\)\s*\{", lines[i]):
            hdr = lines[i].strip()
            break
        if re.match(r"^  (public|private|protected|static).*;", lines[i]):
            hdr = lines[i].strip()
            break
    return lines[lineno - 1].strip(), hdr


def main():
    sites = sys.argv[1:]
    for spec in sites:
        cls, lineno = spec.split(":")
        lineno = int(lineno)
        text = javap(cls)
        rs = recipes(text)
        srcline, hdr = site_line_context(cls, lineno)
        # find matching method by simple name token
        key = None
        if hdr:
            m = re.search(r"(\w+)\(", hdr.replace("P", ""))
            key = m.group(1) if m else None
        jm = methods(text)
        # source header carries the full obf identifier; jar carries the truncated short
        # form. Both end in the same short name, so match on the final alphabetic token.
        want = None
        if hdr:
            m = re.search(r"(\w+)\(", hdr)
            want = m.group(1) if m else None
            if want and want.startswith("You_are_an_idiot"):
                want = want[-2:] if len(want) > 2 else want

        def tail(n):
            n = str(n)
            return n[-2:] if n.startswith("Pa") and len(n) > 2 else n

        cands = [m for m in jm if tail(sig_key(m[0])) == tail(want)]
        key = want
        if not cands:
            print(f"--- {cls}:{lineno}  [{key}]")
            print(f"    src : {srcline[:100]}")
            print("    !! no method match; jar short names: "
                  + ", ".join(sorted({str(sig_key(m[0])) for m in jm})[:14]))
            continue
        target = cands[0]
        print(f"--- {cls}:{lineno}  [{key}]  ({len(cands)} overloads)")
        print(f"    src : {srcline[:100]}")
        print(f"    jar : {target[0][:100]}")
        # find indy sites and their placeholder counts within the method
        found = []
        for L in target[3][target[1]:target[2]]:
            im = re.search(r"InvokeDynamic #(\d+):makeConcatWithConstants", L)
            if im:
                bsm = int(im.group(1))
                n, rec = rs.get(bsm, (None, "?"))
                found.append((bsm, n, rec))
        for bsm, n, rec in found:
            print(f"    indy #{bsm}: {n} placeholders  recipe={rec[:60]}")


if __name__ == "__main__":
    main()
