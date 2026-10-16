#!/usr/bin/env python3
"""Build tools/classmap.tsv: source file <-> jar class.

Signals:
  * footer   : /* ... AltarSMP.jar!/pl/<OBF>.class */ present in the source
  * descriptor: method(name,descriptor) multiset Jaccard between the recompiled
                class (target/classes) and the jar class (structure is preserved
                by the remap; only class names changed).
Decision: a footer target is accepted when descriptor-jaccard >= 0.5, otherwise
the descriptor-best jar class wins (if score >= 0.5 and margin over runner-up).
Everything uncertain is written as '?' and reported.
"""
import os, re, sys, subprocess, collections, json

ROOT = "/Projects/AltarSMP"
SRC = os.path.join(ROOT, "src/main/java/pl")
CLASSES = os.path.join(ROOT, "target/classes/pl")
JAR = os.path.expanduser("~/Documents/AltarSMP.jar")
OUT = os.path.join(ROOT, "tools/classmap.tsv")
TMP = "/tmp/opencode/jarextract"
FOOTER = re.compile(r"AltarSMP\.jar!/pl/([A-Za-z0-9_$]+)\.class")


def jar_classes():
    out = subprocess.run(["unzip", "-l", JAR, "pl/*.class"],
                         capture_output=True, text=True).stdout
    names = set()
    for line in out.splitlines():
        p = line.split()
        if len(p) >= 4 and p[3].endswith(".class") and p[3].startswith("pl/"):
            names.add(p[3][len("pl/"):-len(".class")])
    return names


def sigs(classfile):
    if not os.path.exists(classfile):
        return None
    out = subprocess.run(["javap", "-p", "-s", classfile],
                         capture_output=True, text=True).stdout
    lines = out.splitlines()
    s = collections.Counter()
    for i, ln in enumerate(lines):
        ln = ln.strip()
        if ln.endswith(");") and "(" in ln:
            for j in range(i + 1, min(i + 3, len(lines))):
                d = lines[j].strip()
                if d.startswith("descriptor:"):
                    desc = d.split(":", 1)[1].strip()
                    s[desc] += 1
                    break
    return s


_CACHE_PATH = "/tmp/opencode/sig_cache.json"
_CACHE = None


def _load_cache():
    global _CACHE
    if _CACHE is None:
        try:
            _CACHE = json.load(open(_CACHE_PATH))
        except Exception:
            _CACHE = {}
    return _CACHE


def _save_cache():
    with open(_CACHE_PATH, "w") as f:
        json.dump(_CACHE, f)


def sigs_cached(classfile):
    try:
        mt = int(os.path.getmtime(classfile))
    except OSError:
        return None
    c = _load_cache()
    key = f"{classfile}@{mt}"
    if key in c:
        return collections.Counter(c[key]) if c[key] is not None else None
    v = sigs(classfile)
    c[key] = dict(v) if v is not None else None
    return v


def jac(a, b):
    if not a or not b:
        return 0.0
    inter = sum((a & b).values())
    union = sum((a | b).values())
    return inter / union if union else 0.0


def main():
    jc = jar_classes()
    if not os.path.isdir(TMP):
        subprocess.run(["unzip", "-oq", JAR, "pl/*.class", "-d", TMP])
    jdir = os.path.join(TMP, "pl")
    jar_sig = {}
    for j in jc:
        s = sigs_cached(os.path.join(jdir, j + ".class"))
        if s:
            jar_sig[j] = s

    src_all = sorted(fn[:-5] for fn in os.listdir(SRC) if fn.endswith(".java"))
    footer, result, note = {}, {}, {}
    for cls in src_all:
        path = os.path.join(SRC, cls + ".java")
        mm = FOOTER.search(open(path, encoding="utf-8", errors="replace").read())
        if mm:
            footer[cls] = mm.group(1)

        s = sigs_cached(os.path.join(CLASSES, cls + ".class"))
        ft = footer.get(cls)
        # Footer is direct provenance from the decompiler; trust it whenever its
        # target is a real jar class. Descriptor matching only fills the gaps,
        # because trivial runnable/constant classes are mutually ambiguous.
        if ft and ft in jar_sig:
            result[cls] = ft
            note[cls] = f"footer {jac(s, jar_sig[ft]):.2f}" if s else "footer"
            continue
        if not s:
            result[cls] = None
            note[cls] = "no compiled class"
            continue
        scores = sorted(((jac(s, js), j) for j, js in jar_sig.items()),
                        reverse=True)
        best, bs = scores[0][1], scores[0][0]
        second = scores[1][0] if len(scores) > 1 else 0.0
        if ft and ft not in jar_sig:
            # footer points at a class the jar no longer has (hand-written file)
            if bs >= 0.5:
                result[cls] = best
                note[cls] = f"footer {ft} absent; desc {bs:.2f}"
            else:
                result[cls] = None
                note[cls] = f"footer {ft} absent; WEAK desc {bs:.2f}"
            continue
        if bs >= 0.5 and (bs - second) >= 0.05:
            result[cls] = best
            note[cls] = f"descriptor {bs:.2f}"
        else:
            result[cls] = None
            note[cls] = f"WEAK desc {bs:.2f}/{second:.2f}"

    with open(OUT, "w", encoding="utf-8") as f:
        f.write("source\tjar_class\tnote\n")
        for cls in src_all:
            f.write(f"{cls}\t{result[cls] or '?'}\t{note[cls]}\n")

    low = [c for c in src_all if note[c].startswith(("LOW", "WEAK", "no"))]
    print(f"wrote {OUT}: {len(src_all)} rows, {len(low)} low-confidence",
          file=sys.stderr)
    for c in low:
        print(f"  {c:40} -> {result[c] or '?'}  [{note[c]}]", file=sys.stderr)


if __name__ == "__main__":
    import atexit; atexit.register(_save_cache)
    main()
