#!/usr/bin/env python3
"""Batch: for each (class, target-callee), print the operand stack feeding the
indy that immediately precedes the call to that callee, plus decoded strings.

Usage: batch_ops.py <class>:<calleeRegex> [...]
"""
import re
import subprocess
import sys

JAR = "/home/kingscrafts/Documents/AltarSMP.jar"
PREFIX = "You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764"


def javap(cls):
    return subprocess.run(
        ["javap", "-v", "-p", "-c", "-cp", JAR, f"pl.{PREFIX}{cls}"],
        capture_output=True, text=True).stdout.replace(PREFIX, "P")


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
            out[cur] = am.group(1).rstrip()
            pending = False
    return out


def collect(cls, callee_rx):
    text = javap(cls)
    rs = recipe_map(text)
    lines = text.splitlines()
    idx = [i for i, L in enumerate(lines) if re.match(r"^  \S.*\);$", L)]
    for n, i in enumerate(idx):
        end = idx[n + 1] if n + 1 < len(idx) else len(lines)
        body = lines[i:end]
        # find the callee line, then the nearest preceding indy
        for k, L in enumerate(body):
            if callee_rx in L and ("invoke" in L):
                for j in range(k - 1, -1, -1):
                    if "invokedynamic" in body[j] and "makeConcat" in body[j]:
                        b = int(re.search(r"InvokeDynamic #(\d+):", body[j]).group(1))
                        rec = rs.get(b, "?")
                        # operand pushes just before the indy
                        ops = []
                        for j2 in range(j - 1, -1, -1):
                            c = body[j2].strip()
                            mm = re.match(r"^(\d+):\s+(\S+)(.*)$", c)
                            if not mm:
                                break
                            op = mm.group(2)
                            note = body[j2].split("//", 1)[1].strip() if "//" in body[j2] else ""
                            if op in ("aload", "aload_0", "aload_1", "aload_2",
                                      "aload_3", "iload", "iload_0", "iload_1",
                                      "iload_2", "iload_3", "lload"):
                                ops.append(f"{op} {note}".strip())
                            elif op in ("getfield", "invokevirtual", "getstatic",
                                         "invokestatic", "ldc", "ldc2_w",
                                         "checkcast", "dup", "pop", "swap",
                                         "dup_x2", "sipush", "bipush", "new",
                                         "anewarray", "iconst_0", "iconst_1",
                                         "aconst_null", "lconst_0", "lconst_1",
                                         "dconst_0", "dconst_1", "fconst_0"):
                                ops.append(f"[{op}] {note}"[:60])
                            else:
                                break
                        print(f"### {cls} :: {lines[i].strip()[:58]}")
                        print(f"  callee: {note[:60]}")
                        print(f"  recipe: {rec!r} ({rec.count(chr(92)+'u0001')} ph)")
                        print("  ops (innermost last):")
                        for o in reversed(ops):
                            print(f"    {o}")
                        print()
                        break
                break


if __name__ == "__main__":
    for spec in sys.argv[1:]:
        cls, rx = spec.split("|", 1)
        collect(cls, rx)
