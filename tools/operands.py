#!/usr/bin/env python3
"""Print the true operand stack feeding each makeConcatWithConstants in a method.

Walks the bytecode backwards from each indy, collecting the pushes (aload / ldc /
a(II) decrypt calls), and reports them alongside the recipe so the correct source
form can be reconstructed.
"""
import re
import subprocess
import sys

JAR = "/home/kingscrafts/Documents/AltarSMP.jar"
PREFIX = "You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764"


def javap(cls):
    return subprocess.run(
        ["javap", "-v", "-p", "-c", "-cp", JAR, f"pl.{PREFIX}{cls}"],
        capture_output=True, text=True,
    ).stdout.replace(PREFIX, "P").replace(f"pl/{PREFIX}", "P")


def recipe_map(text):
    out, cur, pending = {}, None, False
    m = re.search(r"^BootstrapMethods:\n(.*)", text, re.S | re.M)
    if not m:
        return out
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
            out[cur] = rec
            pending = False
    return out


def run(cls, sigpat):
    text = javap(cls)
    rs = recipe_map(text)
    lines = text.splitlines()
    idx = [i for i, L in enumerate(lines) if re.match(r"^  \S.*\);$", L)]
    for n, i in enumerate(idx):
        sig = lines[i]
        if sigpat and sigpat not in sig.strip():
            continue
        end = idx[n + 1] if n + 1 < len(idx) else len(lines)
        body = lines[i:end]
        print(f"### {sig.strip()}")
        # walk, buffering pushes; on indy, dump the buffer
        buf = []
        for L in body:
            code = L.strip()
            m = re.match(r"^(\d+):\s+(\S+)(.*)$", code)
            if not m:
                continue
            off, op, rest = int(m.group(1)), m.group(2), m.group(3)
            tail = L.split("//", 1)[1].strip() if "//" in L else ""
            cm = re.search(r"// (?:Method|Field|String|int|class|double|long) (.*)$", L)
            note = cm.group(1) if cm else ""
            if op in ("aload", "aload_0", "aload_1", "aload_2", "aload_3"):
                buf.append(("var", f"{op} {note}".strip()))
            elif op == "ldc":
                buf.append(("const", note))
            elif op in ("sipush", "bipush", "iconst_0", "iconst_1", "iconst_2"):
                buf.append(("push", code))
            elif op == "invokestatic" and re.search(r"// Method \w*:\(II\)Ljava/lang/String;", L):
                # decrypt call: the two preceding pushes are its args
                buf.append(("decrypt", "decrypt(" + " ".join(
                    f"{k}={v}" for k, v in buf[-2:]) + ")"))
                buf = buf[:-2]
            elif op in ("dup_x2", "swap", "dup", "pop"):
                buf.append(("op", op))
            elif op == "invokedynamic" and "makeConcatWithConstants" in L:
                im = re.search(r"InvokeDynamic #(\d+):", L)
                bsm = int(im.group(1))
                rec = rs.get(bsm, "?")
                nph = rec.count("\\u0001")
                print(f"  -- indy #{bsm} @off{off}: recipe={rec!r} ({nph} placeholders)")
                # print only operand-ish entries
                for kind, val in buf:
                    if kind in ("var", "const", "decrypt"):
                        print(f"       {kind:8} {val}")
                buf = []
        print()
        return


if __name__ == "__main__":
    run(sys.argv[1], sys.argv[2] if len(sys.argv) > 2 else "")
