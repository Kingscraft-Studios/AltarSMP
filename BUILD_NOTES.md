# AltarSMP — recompile status

Source: `AltarSMP-final/` (300 `pl` classes, JD-Core based + selected CFR/Procyon)
Target: Paper `1.21.11-R0.1-SNAPSHOT`

## Build command
```bash
CP=$(cat /tmp/opencode/cpabs.txt)
javac -J-Xmx2g -nowarn -proc:none -Xmaxerrs 100000 \
      -d /tmp/opencode/classes -cp "$CP" \
      $(find . -name '*.java' ! -name "*239764ae.java" ! -name "*239764bl.java")
```

## Progress
| | errors | bad files | clean files |
|---|---|---|---|
| start | 570 | 124 | 171 |
| now | **436** | **109** | **189** |

(of 300 files; 2 excluded for syntax — see below)

## Fixes applied
1. **10 classes `enum` -> `class`** — JD-Core emitted `enum` for static holders (suffixes b..k).
2. **Removed invalid `this;` statements** (2 files).
3. **Classpath completed** — joml, bungee-chat, adventure (+key, 3 serializers),
   examination, option, jetbrains annotations, WorldEdit, WorldGuard (15 jars total).
4. **ChatColor ambiguity** — 3 files imported both `org.bukkit.ChatColor` and
   `net.md_5.bungee.api.ChatColor`. Removed the bungee import; kept
   `net.md_5.bungee.api.ChatColor.of(...)` fully qualified (bungee-only method).
5. **15 lambda bodies recovered** from bytecode via CFR `--methodname` and spliced in.
6. **1 dropped method recovered** (class `...cm`, a record's canonical constructor).
7. **private -> public widening** on ~20 methods/fields/constructors
   (classes aj, ax, an, ag, be, bi, br, bh, bk, bo, z, bj, bg, cm).

## Remaining, by cause
| count | cause | automated? |
|---|---|---|
| 108 | duplicate method signatures (same erasure) | NO - needs manual rename + call-site updates |
| 98 | cannot find symbol (obfuscated var/class refs) | mostly per-case |
| 39 | private access (record accessors, field/method name reuse) | per-case |
| 53 | void where a value is expected | per-case |
| 50 | raw types (generic signatures lost) | yes, from bytecode `Signature` attrs |
| 29 | other incompatible types | per-case |
| ~59 | arity, non-static refs, deref, missing pkgs | mixed |

## Key structural findings
- `...cm` is a **record** in bytecode (`extends java.lang.Record`) with accessors
  `f()`, `g()`, `h()`. JD-Core emitted it as `extends Record` with public fields and
  **no accessors**. Should be rewritten as a real `record cm(Entity, BukkitTask, BossBar)`.
- 4 errors are `classes cannot directly extend Record` — same root cause.
- Obfuscator overloads dozens of methods under one name, differing only in erasure.
  **Java cannot express this** - this is the hard floor.

## Files needing syntax repair (excluded from build)
- `...239764ae.java` — truncated statement `(uniqueId);`, split identifier, 2 unclosed braces
- `...239764bl.java` — unterminated `catch`, 2 unclosed braces

## Path forward
1. **12 worst files hold 49% of errors** (be 33, bm 30, br 26, bu 26, bb 21, y 18,
   bj 14, bd 11, cb 10, bk 10, bi 8, dv 7). Fix by hand.
2. **77 files have only 1-3 errors** — long tail, largely mechanical.
3. Convert `...cm` to a proper `record`.
4. Generify fields from bytecode `Signature` attributes (~50 errors).
5. Repair `ae` / `bl`.
6. Only then attempt duplicate-signature renames (last, most invasive).
