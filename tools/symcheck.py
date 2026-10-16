#!/usr/bin/env python3
"""symcheck.py - bulk correctness checker for the decompiled AltarSMP sources.

Three independent checks, all pure-text so it runs in seconds:

  (1) unresolved-reference check
      Resolves `recv.meth(` by inferring recv's *type* (local var, field,
      `this.x`, class name) and walking the super/interface chain.
      Only reports when the receiver type is a project class, which kills
      false positives like `this.<prefix>u.accept()` (u is a BiConsumer
      field, not a class).

  (2) prefix-truncation check
      Every obfuscated class/method/field in this project carries the long
      prefix. A short `P`-ish identifier used as a type that is not a real
      class and not an import is almost certainly a truncated reference
      (e.g. `Pb4.Pa()` for `<prefix>b4.<prefix>a()`).

  (3) concat duplication check
      Finds concat chains with a repeated non-literal operand, classified by
      inferred type, to locate the String-typed corruption sites.

Usage:
    python3 symcheck.py [srcdir] [--only=1,2,3] [--verbose]
"""
import os
import re
import sys
import collections

JAVA_LANG = set("""
Object String Integer Long Short Byte Character Float Double Boolean Void
Class Math System Thread Runnable Exception RuntimeException Error StringBuilder
StringBuffer Number Iterable Comparable Cloneable AutoCloseable Process
Package Deprecated Override SafeVarargs SuppressWarnings FunctionalInterface
""".split())

# ---------------------------------------------------------------- helpers

def strip_comments(line):
    out = []
    i, n = 0, len(line)
    instr = False
    while i < n:
        c = line[i]
        if instr:
            if c == '\\':
                out.append('  ')
                i += 2
                continue
            if c == '"':
                instr = False
            out.append(' ')
        else:
            if c == '"':
                instr = True
                out.append(' ')
            elif c == '/' and i + 1 < n and line[i + 1] == '/':
                out.append(' ' * (n - i))
                break
            elif c == '/' and i + 1 < n and line[i + 1] == '*':
                out.append('  ')
                i += 2
                continue
            else:
                out.append(c)
        i += 1
    return ''.join(out)


def strip_comments_keep_strings(line):
    """Remove comments but preserve string literal contents."""
    out = []
    i, n = 0, len(line)
    instr = False
    while i < n:
        c = line[i]
        if instr:
            if c == '\\' and i + 1 < n:
                out.append(line[i:i + 2])
                i += 2
                continue
            if c == '"':
                instr = False
            out.append(c)
        else:
            if c == '"':
                instr = True
                out.append(c)
            elif c == '/' and i + 1 < n and line[i + 1] == '/':
                out.append(' ' * (n - i))
                break
            elif c == '/' and i + 1 < n and line[i + 1] == '*':
                out.append('  ')
                i += 2
                continue
            else:
                out.append(c)
        i += 1
    return ''.join(out)


TYPE = r'[A-Za-z_$][\w$]*(?:\s*<[^;={}]*?>)?(?:\s*\[\s*\])*'
RE_CLASS = re.compile(
    r'^\s*(?:public\s+|final\s+|abstract\s+|static\s+)*'
    r'(class|enum|interface|record)\s+([A-Za-z_$][\w$]*)'
    r'(?:\s*<[^>]*>)?'
    r'(?:\s*extends\s+([A-Za-z_$][\w$.]*))?'
    r'(?:\s*implements\s+([^{]+))?')
RE_METHOD = re.compile(
    r'^\s*(?:public|protected|private)?\s*'
    r'(?:static\s+|final\s+|synchronized\s+|abstract\s+|native\s+)*'
    r'(' + TYPE + r')\s+([A-Za-z_$][\w$]*)\s*\(')
RE_FIELD = re.compile(
    r'^\s*(?:public|protected|private)?\s*'
    r'(?:static\s+|final\s+|volatile\s+|transient\s+)*'
    r'(' + TYPE + r')\s+([A-Za-z_$][\w$]*)\s*[;=]')
RE_LOCAL = re.compile(
    r'^\s*(?:final\s+)?(' + TYPE + r')\s+([A-Za-z_$][\w$]*)\s*(?:=|;|:)')
RE_FOR = re.compile(
    r'\bfor\s*\(\s*(?:final\s+)?(' + TYPE + r')\s+([A-Za-z_$][\w$]*)\s*(?::|=)')
RE_CATCH = re.compile(r'\bcatch\s*\(\s*(' + TYPE + r')\s+([A-Za-z_$][\w$]*)\s*\)')
RE_RECORD_COMP = re.compile(
    r'^\s*(?:public\s+|final\s+|static\s+)*record\s+[A-Za-z_$][\w$]*\s*'
    r'\(([^)]*)\)')
RE_CALL = re.compile(
    r'((?:[A-Za-z_$][\w$]*\s*\.\s*)*[A-Za-z_$][\w$]*)\s*\.\s*'
    r'([A-Za-z_$][\w$]*)\s*\(')
RE_THIS = re.compile(r'\bthis\s*\.\s*([A-Za-z_$][\w$]*)')
RE_NEW = re.compile(r'\bnew\s+([A-Za-z_$][\w$.]*)')
RE_SUSPECT = re.compile(r'^(?:P|Pa|Pb|Pc|Pd|Pe|Pf|Pg|Ph|Pi|Pj|Pk|Pl|Pm|Pn|Po|Pp|Pq|Pr|Ps|Pt|Pu|Pv|Pw|Px|Py|Pz)[A-Za-z0-9_]{0,4}$')
RE_SIG = re.compile(r'[A-Za-z_$][\w$]*\s*\((.*)\)\s*(?:\{|throws|$)')


def split_top(s, sep=','):
    """Split on a separator at paren/brace depth 0, string aware."""
    out, cur, depth, instr, i = [], '', 0, False, 0
    while i < len(s):
        c = s[i]
        if instr:
            cur += c
            if c == '\\':
                if i + 1 < len(s):
                    cur += s[i + 1]
                i += 2
                continue
            if c == '"':
                instr = False
            i += 1
            continue
        if c == '"':
            instr = True
            cur += c
        elif c in '([{':
            depth += 1
            cur += c
        elif c in ')]}':
            depth -= 1
            cur += c
        elif c == sep and depth == 0:
            out.append(cur.strip())
            cur = ''
        else:
            cur += c
        i += 1
    if cur.strip():
        out.append(cur.strip())
    return out


def add_params(sig, scope):
    """Record `Type name` parameters from a method signature into scope."""
    m = re.search(r'\(([^()]*(?:\([^()]*\)[^()]*)*)\)', sig)
    if not m:
        return
    for part in split_top(m.group(1)):
        mm = re.match(r'^(?:final\s+)?(' + TYPE + r')\s+([A-Za-z_$][\w$]*)$',
                      part.strip())
        if mm:
            scope.setdefault(mm.group(2), simple(mm.group(1)))


RE_ASSIGN_PREFIX = re.compile(
    r'^\s*(?:final\s+)?(?:[\w$.]+\s*<[^<>]*>\s*|[\w$.]+(?:\s*\[\s*\])*\s+)'
    r'[A-Za-z_$][\w$]*\s*=\s*')


def strip_assign_prefix(expr):
    """`String str = a + b` -> `a + b`; `str = a + b` -> `a + b`."""
    return RE_ASSIGN_PREFIX.sub('', expr, count=1)


def strip_outer_call(expr):
    """`foo.sendMessage(a, B + C);` -> `a, B + C`  (keeps concat chain flat)."""
    e = expr.strip().rstrip(';').strip()
    m = re.match(r'^(?:new\s+)?[A-Za-z_$][\w$.]*\s*\(', e)
    if not m:
        return e
    depth = 0
    instr = False
    for i in range(m.end() - 1, len(e)):
        c = e[i]
        if instr:
            if c == '\\':
                continue
            if c == '"':
                instr = False
            continue
        if c == '"':
            instr = True
        elif c == '(':
            depth += 1
        elif c == ')':
            depth -= 1
            if depth == 0:
                # only unwrap a genuine enclosing call, not the first
                # operand of the concat chain itself
                if e[i + 1:].strip().rstrip(';').strip() == '':
                    return e[m.end():i]
                return e
    return e


def simple(t):
    """Reduce a declared type to its simple name."""
    t = t.strip()
    t = re.sub(r'<.*>', '', t, flags=re.S).strip()
    t = t.replace('[]', '').strip()
    if '.' in t:
        t = t.rsplit('.', 1)[-1]
    return t


# ---------------------------------------------------------------- indexing

def index_project(srcdir):
    files = {}
    classes = {}
    imported = set()

    for dp, dn, fn in os.walk(srcdir):
        for f in fn:
            if not f.endswith('.java'):
                continue
            path = os.path.join(dp, f)
            raw = open(path, encoding='utf-8', errors='replace').read()
            files[path] = raw
            for m in re.finditer(r'^\s*import\s+(?:static\s+)?([\w$.]+)\s*;',
                                 raw, re.M):
                imported.add(m.group(1).rsplit('.', 1)[-1])

            name = sup = ifaces = kind = None
            methods, fields = set(), {}
            for line in raw.split('\n'):
                if name is None:
                    m = RE_CLASS.match(line)
                    if m:
                        kind = m.group(1)
                        name = m.group(2)
                        sup = simple(m.group(3)) if m.group(3) else None
                        ifaces = [simple(x) for x in
                                  re.findall(r'[A-Za-z_$][\w$]*',
                                             m.group(4) or '')]
                        classes[name] = {
                            'methods': methods, 'fields': fields,
                            'sup': sup, 'ifaces': ifaces, 'file': path,
                            'kind': kind}
                        if kind == 'record':
                            rc = RE_RECORD_COMP.match(line)
                            if rc:
                                for comp in split_top(rc.group(1), ','):
                                    cm = re.match(
                                        r'\s*(?:final\s+)?' + TYPE +
                                        r'\s+([A-Za-z_$][\w$]*)', comp)
                                    if cm:
                                        methods.add(cm.group(1))
                                        fields[cm.group(1)] = simple(
                                            cm.group(0).split()[-2]
                                            if len(cm.group(0).split()) > 1
                                            else '')
                    continue
                m = RE_METHOD.match(line)
                if m:
                    methods.add(m.group(2))
                    continue
                m = RE_FIELD.match(line)
                if m:
                    fields[m.group(2)] = simple(m.group(1))
            if name is None:
                name = f[:-5]
                classes.setdefault(name, {'methods': methods, 'fields': fields,
                                          'sup': None, 'ifaces': [],
                                          'file': path, 'kind': 'class'})
    return files, classes, imported


def all_supers(classes, cname, seen=None):
    """Yield cname plus every ancestor and interface.

    Stops descending at any type that is not a project class; the caller
    uses the None marker to mean "reached an unverifiable external type".
    """
    if seen is None:
        seen = set()
    stack = [cname]
    while stack:
        c = stack.pop()
        if c in seen:
            continue
        seen.add(c)
        info = classes.get(c)
        if not info:
            yield c, False          # external: cannot verify
            continue
        yield c, True
        if info['sup']:
            stack.append(info['sup'])
        stack.extend(info['ifaces'] or [])


ENUM_IMPLICIT = {'values', 'valueOf', 'name', 'ordinal', 'compareTo',
                 'getDeclaringClass', 'describeConstable'}


def resolves(classes, rtype, meth):
    """True if rtype has/inherits meth, or if the chain leaves the project."""
    for c, is_project in all_supers(classes, rtype):
        if not is_project:
            return True              # external ancestor -> unverifiable
        info = classes[c]
        if info.get('kind') == 'enum' and meth in ENUM_IMPLICIT:
            return True
        if meth in info['methods'] or meth in info['fields']:
            return True
    return False


# ---------------------------------------------------------------- checks

def field_type(classes, rtype, name, fieldmap):
    """Resolve field `name` on rtype, walking supers, then globally."""
    for c, is_project in all_supers(classes, rtype):
        if not is_project:
            return None
        info = classes[c]
        if name in info['fields']:
            return info['fields'][name]
    return fieldmap.get(name)


def resolve_chain(segstr, scope, cls, classes, fieldmap):
    """Resolve a dotted receiver like `a.b.c` to a type name, or None."""
    segs = [s for s in re.split(r'\.', segstr.strip()) if s]
    if not segs:
        return None
    head = segs[0]
    if head == 'this':
        cur = cls
    elif head in scope:
        cur = scope[head]
    elif head in classes:
        cur = head
    else:
        cur = fieldmap.get(head)
    if cur is None:
        return None
    for seg in segs[1:]:
        seg = seg.strip()
        nxt = field_type(classes, cur, seg, fieldmap)
        if nxt is not None:
            cur = nxt
            continue
        if seg in classes:
            cur = seg
            continue
        return None
    return cur


def check_refs(files, classes, imported, verbose=False):
    fieldmap = {}
    for info in classes.values():
        for fname, ftype in info['fields'].items():
            fieldmap.setdefault(fname, ftype)
    unresolved = []
    for path, raw in files.items():
        cls = None
        for line in raw.split('\n'):
            m = RE_CLASS.match(line)
            if m:
                cls = m.group(2)
                break
        if cls is None:
            continue
        cdecl = classes.get(cls, {'methods': set(), 'fields': {}})

        # method-body scope: locals, params, fields
        scope = dict(cdecl['fields'])
        for line in raw.split('\n'):
            code = strip_comments(line)
            if not code.strip():
                continue
            if RE_SIG.search(code):
                add_params(code, scope)
            for rx in (RE_LOCAL, RE_FOR, RE_CATCH):
                mm = rx.search(code)
                if mm:
                    scope.setdefault(mm.group(2), simple(mm.group(1)))
            for mm in RE_CALL.finditer(code):
                recv, meth = mm.group(1), mm.group(2)
                rtype = resolve_chain(recv, scope, cls, classes, fieldmap)
                if rtype is None or rtype not in classes:
                    continue
                if resolves(classes, rtype, meth):
                    continue
                if meth in JAVA_LANG or meth in ('equals', 'hashCode',
                                                'toString', 'clone',
                                                'getClass', 'notify', 'wait'):
                    continue
                unresolved.append((os.path.relpath(path), meth, rtype,
                                   line.strip()[:100]))
    return unresolved


def check_truncation(files, classes, imported, verbose=False):
    known = set(classes) | imported | JAVA_LANG
    hits = []
    for path, raw in files.items():
        for ln, line in enumerate(raw.split('\n'), 1):
            code = strip_comments(line)
            if not code.strip():
                continue
            seen = set()
            cands = []
            for m in RE_CALL.finditer(code):
                cands.append(m.group(1))
            for m in RE_NEW.finditer(code):
                cands.append(simple(m.group(1)))
            for m in re.finditer(r'\b(?:List|Set|Map|Optional|'
                                 r'Collection|HashMap|HashSet|ArrayList)\s*<\s*'
                                 r'([A-Za-z_$][\w$]*)', code):
                cands.append(m.group(1))
            for tok in cands:
                if tok in known or tok in seen:
                    continue
                seen.add(tok)
                if RE_SUSPECT.match(tok) and len(tok) <= 6:
                    hits.append((os.path.relpath(path), ln, tok,
                                 line.strip()[:100]))
    return hits


def split_operands(line):
    ops, cur, depth, instr, i = [], '', 0, False, 0
    while i < len(line):
        c = line[i]
        if instr:
            cur += c
            if c == '\\':
                if i + 1 < len(line):
                    cur += line[i + 1]
                i += 2
                continue
            if c == '"':
                instr = False
            i += 1
            continue
        if c == '"':
            instr = True
            cur += c
        elif c in '([':
            depth += 1
            cur += c
        elif c in ')]':
            depth -= 1
            cur += c
        elif c == '+' and depth == 0:
            ops.append(cur.strip())
            cur = ''
        else:
            cur += c
        i += 1
    if cur.strip():
        ops.append(cur.strip())
    return [o for o in ops if o]


STRING_RET = re.compile(
    r'^(?:String\.valueOf\(|\w+\.toString\(\)|String\.format\(|String\.join\(|'
    r'\w+\.getName\(\)|\w+\.getMessage\(\)|\w+\.name\(\))')


def check_concat(files, classes, imported, verbose=False):
    dups = []
    for path, raw in files.items():
        scope = {}
        for ln, line in enumerate(raw.split('\n'), 1):
            code = strip_comments_keep_strings(line)
            if not code.strip():
                continue
            if RE_SIG.search(code):
                add_params(code, scope)
            for rx in (RE_LOCAL, RE_FOR, RE_CATCH):
                mm = rx.search(code)
                if mm:
                    scope.setdefault(mm.group(2), simple(mm.group(1)))
            if code.count('+') < 2:
                continue
            flat = strip_outer_call(strip_assign_prefix(code))
            ops = [o.strip() for o in split_top(flat, '+')]
            ops = [o for o in ops if o]
            if len(ops) < 3:
                continue
            types = []
            for o in ops:
                if re.fullmatch(r'"(?:[^"\\]|\\.)*"', o):
                    types.append('literal')
                elif STRING_RET.match(o):
                    types.append('String')
                elif o in scope and scope[o] == 'String':
                    types.append('String')
                elif o in scope and scope[o] in ('int', 'long', 'double',
                                                'float', 'short', 'byte'):
                    types.append(scope[o])
                elif re.fullmatch(r'[A-Za-z_$][\w$]*', o):
                    types.append('var')
                else:
                    types.append('other')
            # index of last occurrence, so we can grade the gap between them
            seen = {}
            for idx, (o, t) in enumerate(zip(ops, types)):
                if t in ('literal', 'other', 'var'):
                    continue
                key = re.sub(r'\s+', '', o)
                if key in seen:
                    prev = seen[key]
                    between = types[prev + 1:idx]
                    strong = all(b == 'literal' for b in between)
                    dups.append((os.path.relpath(path), ln,
                                 'strong' if strong else 'weak', t,
                                 o[:70], prev + 1))
                seen[key] = idx
    return dups


# ---------------------------------------------------------------- report

def main():
    args = [a for a in sys.argv[1:]]
    only = None
    verbose = '--verbose' in args
    args = [a for a in args if not a.startswith('--')]
    srcdir = args[0] if args else 'src/main/java/pl'
    for a in sys.argv[1:]:
        if a.startswith('--only='):
            only = set(a.split('=', 1)[1].split(','))

    files, classes, imported = index_project(srcdir)
    print('indexed %d files, %d classes, %d imported simple names'
          % (len(files), len(classes), len(imported)))

    if only is None or '1' in only:
        u = check_refs(files, classes, imported, verbose)
        print('\n=== (1) unresolved call on a project class: %d ===' % len(u))
        for rel, meth, rtype, line in u[:40]:
            print('  %s  %s.%s()' % (rel, rtype, meth))
            print('      %s' % line)

    if only is None or '2' in only:
        t = check_truncation(files, classes, imported, verbose)
        print('\n=== (2) truncated-prefix type references: %d ===' % len(t))
        for rel, ln, tok, line in t[:40]:
            print('  %s:%d  <%s>' % (rel, ln, tok))
            print('      %s' % line)

    if only is None or '3' in only:
        d = check_concat(files, classes, imported, verbose)
        strong = [x for x in d if x[2] == 'strong']
        weak = [x for x in d if x[2] == 'weak']
        print('\n=== (3) repeated non-literal concat operands: %d ===' % len(d))
        print('  strong (only literals between): %d   weak: %d'
              % (len(strong), len(weak)))
        print('  strong by type: %s'
              % dict(collections.Counter(x[3] for x in strong)))
        for rel, ln, conf, t_, expr, first in strong:
            print('  STRONG %s:%d  [%s] %s   (first seen col %d)'
                  % (rel, ln, t_, expr, first))
        for rel, ln, conf, t_, expr, first in weak[:20]:
            print('  weak   %s:%d  [%s] %s   (first seen col %d)'
                  % (rel, ln, t_, expr, first))


if __name__ == '__main__':
    main()
