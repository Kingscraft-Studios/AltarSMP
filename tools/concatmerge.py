#!/usr/bin/env python3
"""Second-stage concat repair.

concatfix.py handles sites whose original expression is fully constant. This
handles the rest: the original expression contains `@...` placeholders for
operands that are runtime values (a Player, a ChatColor.toString(), ...).

Those operands already exist in the current source line - the decompiler just
placed them wrongly. So for each site we:

  1. split the ORIGINAL expression  -> want  (literals + `@` placeholders)
  2. split the RECOMPILED expression -> new   (same placeholders, current order)
  3. split the current source line    -> src   (placeholders written as real code)

then rebuild the expression from `want`, substituting each `@` placeholder with
the source operand sitting at the same index in `new`/`src`. Anything that does
not line up cleanly is reported instead of patched.
"""
import sys, os, re, collections

SRC_ROOT = os.environ.get('CONCATFIX_SRC', '/Projects/AltarSMP/src/main/java')
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from concatfix import load, chain_span, top_split, plus_positions, _chain_bounds  # noqa: E402

PLACEHOLDER = re.compile(r'^@[A-Za-z0-9_$.]+(?:\(\))?$')


def merge(want, new, src):
    """Return the corrected expression, or None if it cannot be aligned safely."""
    ow, on, os_ = top_split(want), top_split(new), top_split(src)
    if len(on) != len(os_):
        return None
    # map placeholder text -> list of source operand indices where it occurs in `new`
    idx = collections.defaultdict(list)
    for i, o in enumerate(on):
        if PLACEHOLDER.match(o):
            idx[o].append(i)
    if not idx:
        return None
    used = collections.defaultdict(int)
    out = []
    for o in ow:
        m = PLACEHOLDER.match(o)
        if not m:
            out.append(o)
            continue
        cands = idx.get(o) or []
        if not cands:
            return None
        k = used[o]
        if k >= len(cands):
            return None
        used[o] = k + 1
        out.append(os_[cands[k]])
    # every source placeholder must have been consumed, else we would drop code
    total = sum(len(v) for v in idx.values())
    if total != sum(used.values()):
        return None
    return ' + '.join(out)


def main():
    o = load(sys.argv[1]); n = load(sys.argv[2])
    dry = '--apply' not in sys.argv
    todo, done, report = [], [], []
    for k in sorted(set(o) | set(n)):
        ov, nv = o.get(k, []), n.get(k, [])
        if not ov or not nv:
            continue
        for i in range(min(len(ov), len(nv))):
            want, cur = ov[i][2], nv[i][2]
            if want == cur or '@' not in want:
                continue
            ln = int(nv[i][1])
            if ln < 1:
                report.append(('NO-LINE', k, i, want))
                continue
            cls = k[0].split('.')[-1]
            f = os.path.join(SRC_ROOT, 'pl', cls + '.java')
            if not os.path.exists(f):
                continue
            lines = open(f, encoding='utf-8').read().split('\n')
            if ln - 1 >= len(lines):
                continue
            # chain as it currently stands in the source
            probe = chain_span(lines[ln - 1], len(top_split(cur)))
            if probe is None:
                report.append(('NO-CHAIN', k, i, want))
                continue
            _, _, body, _ = probe
            f0, l0 = first_last(body)
            s2, e2 = _chain_bounds(body, f0[0], l0[0], f0[1])
            src_chain = body[s2:e2]
            fixed = merge(want, cur, src_chain)
            if fixed is None or '@' in fixed:
                # never emit an expression that still carries a placeholder
                report.append(('UNALIGNED', k, i, want))
                continue
            todo.append((f, ln, s2, e2, fixed, '%s.%s#%d' % (cls, k[1], i), want))

    if not dry:
        byfile = collections.defaultdict(list)
        for (f, ln, s2, e2, fixed, note, want) in todo:
            byfile[f].append((ln, s2, e2, fixed, note))
        for f, items in byfile.items():
            lines = open(f, encoding='utf-8').read().split('\n')
            for (ln, s2, e2, fixed, note) in sorted(items, key=lambda t: t[0]):
                body = lines[ln - 1]
                # recompute the span on the current text
                pl = plus_positions(body.rstrip().rstrip(';'))
                if not pl:
                    print('!! no plus on %s:%d' % (f, ln)); continue
                d = depth_of(body.rstrip().rstrip(';'), pl[0][0])
                s2, e2 = _chain_bounds(body.rstrip().rstrip(';'), pl[0][0], pl[-1][0], d)
                lines[ln - 1] = body[:s2] + fixed + body[e2:]
            open(f, 'w', encoding='utf-8').write('\n'.join(lines))
    for (f, ln, s2, e2, fixed, note, want) in todo:
        done.append((note, ln, fixed))
    print(('DRY-RUN ' if dry else 'APPLIED ') + 'merged: %d, unresolved: %d' % (len(done), len(report)))
    for (note, ln, fixed) in done:
        print('  OK  %-46s line %-5d %s' % (note, ln, fixed[:110]))
    c = collections.Counter(r[0] for r in report)
    if c:
        print('unresolved kinds:', dict(c))
        for r in report[:40]:
            print('  %-10s %s.%s#%d  %s' % (r[0], r[1][0].split('vdsgjhfvs')[-1],
                                             r[1][1].split('vdsgjhfvs')[-1], r[2], r[3][:130]))


def depth_of(body, idx):
    d = 0
    for i, ch in enumerate(body):
        if i == idx:
            return d
        if ch in '([{':
            d += 1
        elif ch in ')]}':
            d -= 1
    return d


def first_last(body):
    pl = plus_positions(body)
    return pl[0], pl[-1]


if __name__ == '__main__':
    main()
