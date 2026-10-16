#!/usr/bin/env python3
"""Repair damaged makeConcatWithConstants expressions in the decompiled sources.

For each concat site we have:
  - the ORIGINAL's correct expression (built from the recipe + resolved args)
  - the RECOMPILED site's source line (from javac's LineNumberTable)
We replace the damaged operand chain on that line with the original expression.

Only sites whose original expression contains no placeholder (no '$', '<uf>',
'<MISSING>') are auto-repaired; anything else is reported for manual handling.
"""
import sys, os, re, collections

import os as _os
SRC = _os.environ.get('CONCATFIX_SRC', '/Projects/AltarSMP/src/main/java')
PREFIX = 'You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764'

def load(p):
    d = collections.defaultdict(list)
    for line in open(p, encoding='utf-8', errors='replace'):
        line = line.rstrip('\n')
        if not line:
            continue
        f = line.split('\t')
        if len(f) < 7:
            continue
        d[(f[0], f[1], f[2])].append((int(f[3]), f[4], f[6]))
    for k in d:
        d[k].sort()
    return d

def plus_positions(s):
    """(index, depth) of every '+' outside string/char literals."""
    out, depth, i, n = [], 0, 0, len(s)
    instr = None
    while i < n:
        c = s[i]
        if instr:
            if c == '\\':
                i += 2
                continue
            if c == instr:
                instr = None
            i += 1
            continue
        if c in '"\'':
            instr = c
            i += 1
            continue
        if c in '([{':
            depth += 1
        elif c in ')]}':
            depth -= 1
        elif c == '+':
            out.append((i, depth))
        i += 1
    return out

STOP = set('=;,({}:?')

def _chain_bounds(body, first, last, d):
    """Operand span of the '+' run [first..last] all at nesting depth d."""
    n = len(body)
    # ---- start: walk left from the first '+' to the head of its operand
    i, depth = first, 0
    start = 0
    while i > 0:
        ch = body[i - 1]
        if depth == 0 and ch in STOP:
            start = i
            while start < n and body[start] in ' \t':
                start += 1
            break
        if ch in ')]}':
            depth += 1
        elif ch in '([{':
            if depth == 0:
                start = i
                break
            depth -= 1
        i -= 1
    else:
        start = 0
    # ---- end: walk right from the last '+' to the tail of its operand
    j, depth = last + 1, 0
    end = n
    while j < n:
        ch = body[j]
        if depth == 0 and ch == ';':
            end = j
            break
        if depth == 0 and ch == ',':
            end = j
            break
        if ch in '([{':
            depth += 1
        elif ch in ')]}':
            if depth == 0:
                end = j
                break
            depth -= 1
        j += 1
    return start, end

def chain_span(line, want_ops):
    """Return (start,end,body) for the '+' chain with `want_ops` operands."""
    full = line
    body = line.rstrip()
    tail = ''
    while body and body[-1] in '; \t':
        tail = body[-1] + tail
        body = body[:-1]
    pls = plus_positions(body)
    if not pls:
        return None
    # group '+' into chains: same depth, and no argument/statement separator between
    groups, cur = [], []
    for (idx, d) in pls:
        if cur and d == cur[-1][1]:
            between = body[cur[-1][0] + 1:idx]
            if (',' in between) or (';' in between):
                groups.append(cur)
                cur = [(idx, d)]
            else:
                cur.append((idx, d))
        else:
            if cur:
                groups.append(cur)
            cur = [(idx, d)]
    if cur:
        groups.append(cur)
    cands = []
    for g in groups:
        d = g[0][1]
        s, e = _chain_bounds(body, g[0][0], g[-1][0], d)
        ops = len([x for x in body[s:e].split('+')])
        cands.append((ops == want_ops, e - s, s, e, ops))
    if not cands:
        return None
    # exact operand-count match wins; otherwise the widest chain covering the RHS
    ex = [c for c in cands if c[0]]
    pick = max(ex, key=lambda c: c[1]) if ex else max(cands, key=lambda c: c[1])
    return pick[2], pick[3], body + tail, pick[4]

def nops(expr):
    """operand count of a rendered '+' expression (top level only)"""
    return len(top_split(expr))

def top_split(expr):
    parts, depth, cur, i, n, instr = [], 0, [], 0, len(expr), None
    while i < n:
        c = expr[i]
        if instr:
            cur.append(c)
            if c == '\\':
                if i + 1 < n:
                    cur.append(expr[i + 1])
                i += 2
                continue
            if c == instr:
                instr = None
            i += 1
            continue
        if c in '"\'':
            instr = c
            cur.append(c)
        elif c in '([{':
            depth += 1
            cur.append(c)
        elif c in ')]}':
            depth -= 1
            cur.append(c)
        elif c == '+' and depth == 0:
            parts.append(''.join(cur).strip())
            cur = []
        else:
            cur.append(c)
        i += 1
    parts.append(''.join(cur).strip())
    return [p for p in parts if p != '']

def java_ident_for(bsym):
    return None

def main():
    o = load(sys.argv[1]); n = load(sys.argv[2])
    dry = '--apply' not in sys.argv
    edits = collections.defaultdict(list)   # file -> [(line, old, new, note)]
    report = []
    for k in sorted(set(o) | set(n)):
        ov, nv = o.get(k, []), n.get(k, [])
        if not ov:
            continue
        if not nv:
            for ordi, _, e in ov:
                report.append(('MISSING-IN-NEW', k, ordi, '', e))
            continue
        for i in range(min(len(ov), len(nv))):
            ordi, line, cur = nv[i]
            want = ov[i][2]
            if want == cur:
                continue
            if '@' in want or '$' in want or '<uf>' in want or '<MISSING>' in want:
                report.append(('NEEDS-OPERANDS', k, ordi, line, want))
                continue
            if line == '-1':
                report.append(('NO-LINE', k, ordi, line, want))
                continue
            cls = k[0].split('.')[-1]
            f = os.path.join(SRC, 'pl', cls + '.java')
            edits[f].append((int(line), cur, want, '%s.%s#%d' % (cls, k[1], ordi)))
    fixed = skipped = 0
    unresolved = []
    for f, items in sorted(edits.items()):
        if not os.path.exists(f):
            print('!! missing source', f)
            continue
        lines = open(f, encoding='utf-8').read().split('\n')
        for (ln, cur, want, note) in sorted(items, key=lambda t: -t[0]):
            want_ops = nops(cur)
            done = False
            # javac attributes a wrapped expression to the statement's first line,
            # so allow a small forward window.
            for off in (0, 1, 2, 3, 4, -1, -2):
                idx = ln - 1 + off
                if idx < 0 or idx >= len(lines):
                    continue
                sp = chain_span(lines[idx], want_ops)
                if sp is None:
                    continue
                start, end, body, got = sp
                lines[idx] = body[:start] + want + body[end:]
                fixed += 1
                done = True
                if off:
                    print('   note: %s moved line %d -> %d' % (note, ln, idx + 1))
                break
            if not done:
                unresolved.append((f, ln, cur, want, note))
                skipped += 1
        if not dry:
            open(f, 'w', encoding='utf-8').write('\n'.join(lines))
    print(('DRY-RUN ' if dry else 'APPLIED ') + 'replacements: %d, skipped: %d' % (fixed, skipped))
    by = collections.Counter(r[0] for r in report)
    print('remaining:', dict(by))
    for (f, ln, cur, want, note) in unresolved:
        print('  UNRESOLVED %s:%d (%s)' % (os.path.basename(f), ln, note))
        print('        cur : %s' % cur[:200])
        print('        want: %s' % want[:200])
    for r in report:
        if r[0] != 'MISSING-IN-NEW':
            print('  %-14s %s.%s#%s line=%s' % (r[0], r[1][0].split('vdsgjhfvs')[-1], r[1][1], r[2], r[3]))
            print('        want: %s' % r[4][:220])

if __name__ == '__main__':
    main()
