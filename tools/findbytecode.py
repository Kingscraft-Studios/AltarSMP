#!/usr/bin/env python3
"""Locate a decompiled source line's method in the original jar and print its bytecode.

Usage: findbytecode.py <ClassShort> <methodPattern> [window]
Prints the javap region for the first method whose header matches.
"""
import re
import subprocess
import sys

JAR = "/home/kingscrafts/Documents/AltarSMP.jar"
P = "You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764"


def main():
    cls, pat = sys.argv[1], sys.argv[2]
    window = int(sys.argv[3]) if len(sys.argv) > 3 else 200
    full = f"pl.{P}{cls}"
    out = subprocess.run(
        ["javap", "-p", "-c", "-cp", JAR, full],
        capture_output=True, text=True,
    ).stdout.replace(P, "P").replace(f"pl/{P}", "P")
    lines = out.splitlines()
    starts = [i for i, L in enumerate(lines) if re.match(r"^  \S.*\);$", L)]
    for idx, s in enumerate(starts):
        if re.search(pat, lines[s]):
            end = starts[idx + 1] if idx + 1 < len(starts) else len(lines)
            body = lines[s:min(end, s + window)]
            print(f"### {lines[s].strip()}")
            print("\n".join(l for l in body[1:] if l.strip()))
            return
    print(f"NOT FOUND: {pat} in {full}")


if __name__ == "__main__":
    main()
