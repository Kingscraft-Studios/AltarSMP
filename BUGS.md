# Original-Author Defects

Defects confirmed to exist in the original compiled plugin
(`/home/kingscrafts/Documents/AltarSMP.jar`), not introduced by decompilation.
Each entry is backed by matching bytecode in the original jar.

## `y.onCommand(CommandSender, Command, String, String[])`

The method always returns `true`, and it discards the boolean result of both
ability calls.

- If the sender is not a `Player`, the method returns `true` without doing
  anything (bytecode `0: instanceof Player`, `4: ifeq 75`, `75: iconst_1`,
  `76: ireturn`). Console therefore silently "handles" `/ability1` and
  `/ability2`.
- Unknown subcommands also return `true`, which suppresses Bukkit's unknown
  usage message.
- Both ability invocations push a boolean that is immediately popped
  (`32..37`, `63..68`), so neither failure path is reported to the player.

Behavior is intentional as compiled; source was preserved as-is.

## `at.c(EntityDamageByEntityEvent)`

Cloak effect chance is gated on a fall-distance check that can never be
satisfied for the triggering attacker.

Bytecode order:

```
94: aload_1
95: EntityDamageByEntityEvent.getEntity()
98: instanceof LivingEntity
101: ifeq 151
104: random.nextInt(100)
111: iload_3          // cloakChances
112: if_icmpge 151
115: goto 122
122: player.getFallDistance()
     iflt  <apply cloak>
151: return
```

The handler inspects `getFallDistance()` on the attacker (`player`) while the
`LivingEntity` guard tests the *victim*. A cloak only applies when the
attacker has fallen 2 blocks or more, and no victim-side condition gates it.
The original bytecode was preserved unchanged.

## `at.a(PlayerDeathEvent)`

> **Corrected 2026-09-30.** An earlier entry here claimed the original
> concatenated `String.valueOf(ChatColor.RED)` twice, citing offset `149`.
> That was wrong: offset `149` is `aload_3` (the `ItemStack` local) and the
> method contains exactly one `getstatic ChatColor.RED` (offset `50`).
> The duplicated prefix was a decompilation defect in the rebuild, not an
> original-author quirk, and has been removed along with a missing
> `" kills"` suffix that the original decodes at `(28556, 27958)`.
> The message is now `§cKnightfall is now at <n> kills`.

## `bx` anti-tamper guards

The constructor and plugin-enable paths verify class-file integrity and abort
the plugin when it fails. The checks are intentionally retained as commented
source in `bx.java`; the surrounding bytecode cannot be reproduced from
readable source without reimplementing the hash walk, so the constructor shows
a large instruction-count difference against the original. Not a defect.