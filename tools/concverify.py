"""Verify concat sites in source against the authoritative jar bytecode.

For each candidate source line, find the invokedynamic that the original
classfile associates with that line (via LineNumberTable), then compare the
number of source operands against the recipe's argument count.  A source
chain with MORE operands than its recipe is real corruption.
"""
import collections
import os
import re
import subprocess
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import symcheck

JAR = '/home/kingscrafts/Documents/AltarSMP.jar'
P = ('You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha'
     '8654395799992919999999vdsgjhfvs239764')

RE_INDY = re.compile(
    r'^\s*(\d+): invokedynamic\s+#\d+,\s*\d+\s*//\s*InvokeDynamic #(\d+):'
    r'makeConcatWithConstants:(.*)$')
RE_LNT = re.compile(r'line (\d+): (\d+)')
RE_BSM_RECIPE = re.compile(r'^\s*#(\d+) (.*)$')


def dump(cls):
    out = subprocess.run(
        ['javap', '-v', '-p', '-c', '-l', '-cp', JAR, f'pl.{P}{cls}'],
        capture_output=True, text=True).stdout
    return out


def parse(txt):
    """-> (line_to_indy[(line, indy_index)], recipes{bsm_idx: (text, nargs)})"""
    recipes = {}
    bsm = txt.split('BootstrapMethods:')
    if len(bsm) > 1:
        cur = None
        for ln in bsm[1].split('\n'):
            m = re.match(r'\s*(\d+): #\d+ REF_invokeStatic .*'
                         r'StringConcatFactory\.makeConcatWithConstants', ln)
            if m:
                cur = int(m.group(1))
                continue
            if cur is not None:
                m = RE_BSM_RECIPE.match(ln)
                if m:
                    recipes[cur] = m.group(2)
                    cur = None
    # line -> indy bsm index
    line_to_indy = {}
    pending = {}
    for ln in txt.split('\n'):
        m = RE_LNT.search(ln)
        if m:
            pending.setdefault(int(m.group(1)), int(m.group(2)))
            continue
        m = RE_INDY.match(ln)
        if m:
            off, bsm_idx = int(m.group(1)), int(m.group(2))
            # attribute this indy to the nearest preceding line entry
            best = None
            for L, off0 in pending.items():
                if off0 <= off and (best is None or off0 > best[1]):
                    best = (L, off0)
            if best:
                line_to_indy.setdefault(best[0], bsm_idx)
    return line_to_indy, recipes


def nargs(recipe):
    return recipe.count('\\u0001')


def recipe_sig(recipe):
    """Token signature of a recipe: ('a',) per placeholder, ('l', text) per literal."""
    parts = recipe.split('\\u0001')
    sig = []
    for i, p in enumerate(parts):
        if i:
            sig.append(('a',))
        if p:
            sig.append(('l', p))
    return tuple(sig)


def site_sig(ops):
    """Token signature of a source concat chain."""
    sig = []
    for o in ops:
        m = re.fullmatch(r'"((?:[^"\\]|\\.)*)"', o)
        if m:
            sig.append(('l', m.group(1)))
        else:
            sig.append(('a',))
    return tuple(sig)


def main():
    root = 'src/main/java/pl'
    files, classes, imported = symcheck.index_project(root)
    d = symcheck.check_concat(files, classes, imported)
    strong = [x for x in d if x[2] == 'strong']
    sites = {}
    for rel, ln, conf, t, expr, first in strong:
        sites.setdefault(rel, set()).add(ln)

    cache = {}
    verdicts = []
    for rel in sorted(sites):
        cls = os.path.basename(rel)[:-5]
        suffix = cls[len(P):]
        if suffix not in cache:
            _, recipes = cache.setdefault(
                suffix, parse(dump(suffix)))
        recipes = cache[suffix][1]
        bylit = {}
        for idx, rec in recipes.items():
            bylit.setdefault(recipe_sig(rec), []).append(
                (idx, rec.count('\\u0001')))
        raw = open(rel).read().split('\n')
        for ln in sorted(sites[rel]):
            code = symcheck.strip_comments_keep_strings(raw[ln - 1])
            flat = symcheck.strip_outer_call(
                symcheck.strip_assign_prefix(code))
            ops = [o.strip() for o in symcheck.split_top(flat, '+') if o.strip()]
            n_src = len(ops)
            cands = bylit.get(site_sig(ops), [])
            n_args_src = sum(1 for o in ops
                             if not re.fullmatch(r'"(?:[^"\\]|\\.)*"', o))
            counts = {c[1] for c in cands}
            if len(counts) == 1:
                n_jar = counts.pop()
                verdicts.append((rel, ln, n_args_src, n_jar,
                                 'ARGCOUNT-MISMATCH' if n_args_src != n_jar
                                 else 'ORDER?', len(cands)))
            elif not cands:
                allc = {r.count('\\u0001') for r in recipes.values()}
                verdicts.append((rel, ln, n_args_src, None,
                                 'ARGCOUNT-MISMATCH' if n_args_src not in allc
                                 else 'ORDER?', len(allc)))
            else:
                verdicts.append((rel, ln, n_args_src, None, 'AMBIGUOUS',
                                 len(cands)))
    cnt = collections.Counter(v[4] for v in verdicts)
    print('sites: %d  %s' % (len(verdicts), dict(cnt)))
    for rel, ln, n_src, n_jar, verdict, nc in verdicts:
        if verdict != 'ORDER?':
            print(f'  {verdict:18s} {os.path.basename(rel)[len(P):]}:{ln}  '
                  f'source args={n_src}  recipe args={n_jar}') 


if __name__ == '__main__':
    main()
