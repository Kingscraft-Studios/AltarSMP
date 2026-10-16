"""Reconstruct the true operand order of a makeConcatWithConstants chain
directly from the jar bytecode, so concat reordering can be detected.

For a class, parse every `invokedynamic makeConcatWithConstants`, walk the
instruction stream backwards to recover the pushed arguments, and render each
argument as a normalised token (CC:#rrggbb, CC:BOLD, ALOAD n, ILOAD n, ...).
Those tokens can then be compared against the source chain to show exactly
where the order differs.
"""
import os
import re
import subprocess
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
import symcheck

JAR = '/home/kingscrafts/Documents/AltarSMP.jar'
P = ('You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha'
     '8654395799992919999999vdsgjhfvs239764')

RE_INSN = re.compile(r'^\s*(\d+):\s+(\S+)(?:\s+(.*))?$')
RE_COMMENT = re.compile(r'//\s*(.*)$')
RE_DESC = re.compile(r'\((.*?)\)(.*)$')
RE_BSM = re.compile(
    r'^\s*(\d+): #\d+ REF_invokeStatic .*'
    r'StringConcatFactory\.makeConcatWithConstants')
RE_RECIPE = re.compile(r'^\s*#(\d+) (.*)$')

RET_VOID = 'V'


def dump(cls):
    return subprocess.run(
        ['javap', '-v', '-p', '-c', '-cp', JAR, f'pl.{P}{cls}'],
        capture_output=True, text=True).stdout


def count_params(s):
    """Count params in a JVM descriptor param list.

    Primitives are single chars with no separator, so '(II)' is two params
    and '(Ljava/lang/String;I)' is two as well.
    """
    n = 0
    i = 0
    while i < len(s):
        c = s[i]
        if c == 'L':
            j = s.find(';', i)
            if j < 0:
                break
            i = j + 1
        elif c == '[':
            i += 1
            continue
        else:
            i += 1
        n += 1
    return n


def arity(comment):
    """(consumes, produces) for an instruction given its javap comment."""
    if not comment:
        return 0, 1
    # params contain no ')' so anchor on \([^)]*\); a non-greedy match would
    # truncate multi-arg descriptors such as (II) to a single param
    m = re.search(r':\(([^)]*)\)(.*)$', comment)
    if m:
        produces = 0 if m.group(2).strip() == RET_VOID else 1
        return count_params(m.group(1)), produces
    return 0, 1


class Ins:
    __slots__ = ('off', 'mn', 'rest', 'cmt', 'cons', 'prod')

    def __init__(self, off, mn, rest, cmt):
        self.off, self.mn, self.rest, self.cmt = off, mn, rest, cmt
        self.cons, self.prod = self._shape()

    def _shape(self):
        mn = self.mn
        if mn in ('getstatic',):
            return 0, 1
        if mn in ('getfield',):
            return 1, 1
        if mn in ('invokestatic',):
            return arity(self.cmt)
        if mn in ('invokevirtual', 'invokespecial', 'invokeinterface'):
            c, p = arity(self.cmt)
            return c + 1, p
        if mn == 'invokedynamic':
            c, p = arity(self.cmt)
            return c, p
        if mn in ('aload', 'iload', 'lload', 'fload', 'dload', 'aload_0',
                  'aload_1', 'aload_2', 'aload_3', 'iload_0', 'iload_1',
                  'iload_2', 'iload_3', 'lload_0', 'lload_1', 'fload_0',
                  'fload_1', 'dload_0', 'dload_1',                   'ldc', 'ldc_w', 'new',
                  'newarray', 'anewarray', 'dup', 'aconst_null',
                  'bipush', 'sipush', 'iconst_m1', 'iconst_0', 'iconst_1',
                  'iconst_2', 'iconst_3', 'iconst_4', 'iconst_5', 'lconst_0',
                  'lconst_1', 'fconst_0', 'fconst_1', 'fconst_2', 'dconst_0',
                  'dconst_1'):
            return 0, 1
        if mn == 'checkcast':
            return 1, 1
        return 0, 1


def parse_instructions(txt):
    """-> list of Ins (methods are separated but we keep a flat stream)."""
    out = []
    for ln in txt.split('\n'):
        m = RE_INSN.match(ln)
        if not m:
            continue
        off, mn, rest = int(m.group(1)), m.group(2), m.group(3) or ''
        c = RE_COMMENT.search(rest)
        cmt = c.group(1).strip() if c else ''
        out.append(Ins(off, mn, rest, cmt))
    return out


def recipes(txt):
    out = {}
    parts = txt.split('BootstrapMethods:')
    if len(parts) < 2:
        return out
    cur = None
    for ln in parts[1].split('\n'):
        m = RE_BSM.match(ln)
        if m:
            cur = int(m.group(1))
            continue
        if cur is not None:
            m = RE_RECIPE.match(ln)
            if m:
                out[cur] = m.group(2)
                cur = None
    return out


def norm(ins, kids):
    """Normalised token for the value produced by `ins` (with its children)."""
    mn, cmt = ins.mn, ins.cmt
    kid = kids[0] if kids else None
    if mn == 'ldc':
        if 'String' in cmt:
            return 'LDC-STR'
        return 'LDC:' + cmt.split()[-1]
    if mn in ('getstatic', 'getfield'):
        m = re.search(r'Field ([\w/$]+)\.([\w$]+):', cmt)
        if m:
            owner, fld = m.group(1).rsplit('/', 1)[-1], m.group(2)
            return f'CC:{fld}' if owner == 'ChatColor' else f'{owner}.{fld}'
        return 'FIELD'
    if mn == 'invokestatic':
        m = re.search(r'Method ([\w/$]+)\.([\w$]+):', cmt)
        if m:
            owner, meth = m.group(1).rsplit('/', 1)[-1], m.group(2)
            if owner == 'ChatColor':
                return f'CC:of({kid})' if kid else 'CC:of(?)'
            if owner == 'String':
                return f'STR.valueOf({kid})'
            return f'{owner}.{meth}({kid})'
        return 'INVOKESTATIC'
    if mn in ('invokevirtual', 'invokespecial', 'invokeinterface'):
        m = re.search(r'Method ([\w/$]+)\.([\w$]+):', cmt)
        if m:
            owner, meth = m.group(1).rsplit('/', 1)[-1], m.group(2)
            if owner == 'String' and meth == 'valueOf':
                return f'STR.valueOf({kid})'
            if ins.cons == 1:
                return f'{owner}.{meth}()'
            return f'{owner}.{meth}({kid})'
        return 'INVOKE'
    if mn == 'checkcast':
        return f'CAST({kid})' if kid else 'CAST'
    if mn.startswith('aload'):
        return 'ALOAD'
    if mn.startswith('iload'):
        return 'ILOAD'
    if mn.startswith('lload'):
        return 'LLOAD'
    if mn.startswith('fload'):
        return 'FLOAD'
    if mn.startswith('dload'):
        return 'DLOAD'
    if mn in ('bipush', 'sipush') or mn.startswith('iconst') \
            or mn.startswith('lconst'):
        return 'CONST'
    return mn.upper()


def take(insts, j):
    """Consume one value from the stack at or below j.

    -> (instruction, children, new_j)
    """
    while j >= 0 and insts[j].prod == 0:
        j -= 1
    if j < 0:
        return None, [], j
    p = insts[j]
    kids = []
    jj = j - 1
    for _ in range(p.cons):
        k, c, jj = take(insts, jj)
        if k is None:
            break
        kids.append((k, c))
    kids.reverse()
    return p, kids, jj


def render(node):
    ins, kids = node
    return norm(ins, [render(k) for k in kids])


def reconstruct(txt):
    """-> {bsm_index: [arg tokens]} for every makeConcatWithConstants."""
    insts = parse_instructions(txt)
    recs = recipes(txt)
    out = {}
    for i, ins in enumerate(insts):
        if ins.mn != 'invokedynamic' or 'makeConcatWithConstants' not in ins.cmt:
            continue
        m = re.search(r'InvokeDynamic #(\d+):', ins.cmt)
        if not m:
            continue
        bsm = int(m.group(1))
        recipe = recs.get(bsm)
        if recipe is None:
            continue
        need = recipe.count('\\u0001')
        if need == 0:
            continue
        toks = []
        j = i - 1
        for _ in range(need):
            node, kids, j = take(insts, j)
            if node is None:
                break
            toks.append(render((node, kids)))
        toks.reverse()
        out.setdefault(bsm, []).append(toks)
    return out, recs


RE_SRC_SVO = re.compile(r'^String\.valueOf\(ChatColor\.of\("([^"]*)"\)\)$')
RE_SRC_SVC = re.compile(r'^String\.valueOf\(ChatColor\.([A-Z_]+)\)$')
RE_LIT = re.compile(r'"(?:[^"\\]|\\.)*"')


def norm_src(op):
    """Normalise a source concat operand to the bytecode token vocabulary."""
    o = re.sub(r'\s+', '', op)
    m = RE_SRC_SVO.match(o)
    if m:
        return 'STR.valueOf(CC:of(HEX))'
    m = RE_SRC_SVC.match(o)
    if m:
        return f'STR.valueOf(CC:{m.group(1)})'
    if o.startswith('String.valueOf('):
        return 'STR.valueOf(OTHER)'
    if re.fullmatch(r'[A-Za-z_$][\w$]*', o):
        return 'VAR'
    if o.startswith('ChatColor'):
        return 'CC:OTHER'
    return 'OTHER'


def norm_tok(t):
    """Blur encrypt-decoded and unspecified details so vocabularies line up."""
    t = re.sub(r'CC:of\([^()]*\)', 'CC:of(HEX)', t)
    t = re.sub(r'CC:of\(CC:of\(HEX\)\)', 'CC:of(HEX)', t)
    t = re.sub(r'STR\.valueOf\(CC:of\(HEX\)\)', 'STR.valueOf(CC:of(HEX))', t)
    return t


def recipe_sig(recipe):
    parts = recipe.split('\\u0001')
    sig = []
    for i, p in enumerate(parts):
        if i:
            sig.append(('a',))
        if p:
            sig.append(('l', p))
    return tuple(sig)


def site_sig(ops):
    sig = []
    for o in ops:
        m = RE_LIT.fullmatch(o.strip())
        if m:
            sig.append(('l', o.strip()[1:-1]))
        else:
            sig.append(('a',))
    return tuple(sig)


def report():
    root = 'src/main/java/pl'
    files, classes, imported = symcheck.index_project(root)
    cache = {}
    findings = []
    checked = 0
    for rel, raw in files.items():
        base = os.path.basename(rel)[:-5]
        suffix = base[len(P):]
        for ln, line in enumerate(raw.split('\n'), 1):
            code = symcheck.strip_comments_keep_strings(line)
            if code.count('+') < 2:
                continue
            flat = symcheck.strip_outer_call(symcheck.strip_assign_prefix(code))
            ops = [o.strip() for o in symcheck.split_top(flat, '+') if o.strip()]
            if len(ops) < 3:
                continue
            if suffix not in cache:
                cache[suffix] = reconstruct(dump(suffix))
            chains, recs = cache[suffix]
            sig = site_sig(ops)
            n_args = sum(1 for o in ops if not RE_LIT.fullmatch(o))
            cands = []
            for bsm, lst in chains.items():
                if recipe_sig(recs[bsm]) == sig and any(
                        len(c) == n_args for c in lst):
                    cands.append((bsm, lst))
            if len(cands) != 1:
                continue
            bsm, lst = cands[0]
            chain = next(c for c in lst if len(c) == n_args)
            src = [norm_tok(norm_src(o)) for o in ops if not RE_LIT.fullmatch(o)]
            jar = [norm_tok(t) for t in chain]
            checked += 1
            if src != jar:
                first = next((i for i, (a, b) in enumerate(zip(src, jar))
                              if a != b), min(len(src), len(jar)))
                findings.append((suffix, ln, src, jar, first))
    print(f'chains compared: {checked}   order mismatches: {len(findings)}')
    for suffix, ln, src, jar, first in findings:
        print(f'\n--- {P}{suffix}.java:{ln}  first difference at arg #{first}')
        print(f'    jar: {jar}')
        print(f'    src: {src}')


if __name__ == '__main__':
    report()


def fixes():
    """For each mismatched chain, find single-operand edits that reproduce the
    jar operand order exactly."""
    root = 'src/main/java/pl'
    files, classes, imported = symcheck.index_project(root)
    cache = {}
    out = []
    checked = 0
    for rel, raw in files.items():
        base = os.path.basename(rel)[:-5]
        suffix = base[len(P):]
        for ln, line in enumerate(raw.split('\n'), 1):
            code = symcheck.strip_comments_keep_strings(line)
            if code.count('+') < 2:
                continue
            flat = symcheck.strip_outer_call(symcheck.strip_assign_prefix(code))
            ops = [o.strip() for o in symcheck.split_top(flat, '+') if o.strip()]
            if len(ops) < 3:
                continue
            if suffix not in cache:
                cache[suffix] = reconstruct(dump(suffix))
            chains, recs = cache[suffix]
            sig = site_sig(ops)
            args = [o for o in ops if not RE_LIT.fullmatch(o)]
            cands = []
            for bsm, lst in chains.items():
                if recipe_sig(recs[bsm]) == sig and any(
                        len(c) == len(args) for c in lst):
                    cands.append((bsm, lst))
            if len(cands) != 1:
                continue
            bsm, lst = cands[0]
            chain = next(c for c in lst if len(c) == len(args))
            src = [norm_tok(norm_src(o)) for o in args]
            jar = [norm_tok(t) for t in chain]
            checked += 1
            if src == jar:
                continue
            for k in range(len(src)):
                if src[:k] + src[k + 1:] == jar:
                    out.append((suffix, ln, ops, args[k], 'DELETE'))
                    break
            else:
                for k in range(len(src)):
                    for j in range(len(src)):
                        if k == j:
                            continue
                        trial = list(src)
                        trial[k] = src[j]
                        if trial == jar:
                            out.append((suffix, ln, ops, args[k],
                                        f'SUBSTITUTE with {args[j][:40]}'))
                            break
                    else:
                        continue
                    break
    print(f'chains compared: {checked}   exactly repairable: {len(out)}')
    for suffix, ln, ops, operand, how in out:
        print(f'\n=== {P}{suffix}.java:{ln}   -> {how}')
        print(f'    operand to remove/replace: {operand[:150]}')
    return out


if __name__ == '__main__':
    fixes()


def plan(max_del=3):
    """Minimal set of source operands to delete so the chain matches the jar."""
    root = 'src/main/java/pl'
    files, classes, imported = symcheck.index_project(root)
    cache = {}
    import itertools
    out = []
    checked = 0
    for rel, raw in files.items():
        suffix = os.path.basename(rel)[:-5][len(P):]
        for ln, line in enumerate(raw.split('\n'), 1):
            code = symcheck.strip_comments_keep_strings(line)
            if code.count('+') < 2:
                continue
            flat = symcheck.strip_outer_call(symcheck.strip_assign_prefix(code))
            ops = [o.strip() for o in symcheck.split_top(flat, '+') if o.strip()]
            if len(ops) < 3:
                continue
            if suffix not in cache:
                cache[suffix] = reconstruct(dump(suffix))
            chains, recs = cache[suffix]
            sig = site_sig(ops)
            idxs = [k for k, o in enumerate(ops) if not RE_LIT.fullmatch(o)]
            cands = []
            for bsm, lst in chains.items():
                if recipe_sig(recs[bsm]) == sig and any(
                        len(c) == len(idxs) for c in lst):
                    cands.append((bsm, lst))
            if len(cands) != 1:
                continue
            bsm, lst = cands[0]
            chain = next(c for c in lst if len(c) == len(idxs))
            src = [norm_tok(norm_src(ops[k])) for k in idxs]
            jar = [norm_tok(t) for t in chain]
            checked += 1
            if src == jar:
                continue
            found = None
            for d in range(1, max_del + 1):
                for combo in itertools.combinations(range(len(src)), d):
                    if [v for i, v in enumerate(src) if i not in combo] == jar:
                        found = combo
                        break
                if found:
                    break
            out.append((suffix, ln, idxs, src, jar, found))
    print(f'chains compared: {checked}   mismatched: {len(out)}   '
          f'repairable by deletion: {sum(1 for o in out if o[5] is not None)}')
    for suffix, ln, idxs, src, jar, found in out:
        print(f'\n=== {P}{suffix}.java:{ln}  args={len(src)} jar={len(jar)}')
        if found is None:
            print('    NO pure-deletion repair')
            continue
        print(f'    delete source operand index(es) {[idxs[i] for i in found]}')
        for i in found:
            print(f'      -> remove: {ops_text(idxs[i])[:120]}')


def ops_text(i):
    return _OPS_CTX.get(i, '')


_OPS_CTX = {}
