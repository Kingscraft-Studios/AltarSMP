# AltarSMP: Full Experience

A Paper plugin that combines **Season 1** and **Season 2** AltarSMP content into a single
installable package — custom abilities, equipment, altars, events, and a bundled resource
pack all wired through one configuration.

> **Season 1 + Season 2. One plugin. One installation. One complete experience.**

## Features

- **Season 1 content** — classic altars, abilities, equipment, and event systems.
- **Season 2 content** — legendary weapons, reworked abilities, and supporting mechanics.
- **Custom abilities** — triggerable via keybinds and commands with cooldown handling.
- **Custom items & equipment** — weapons, armor, tools, and utility items with unique behavior.
- **Custom textures, 3D models & sounds** — delivered through an embedded resource pack.
- **Immersive gameplay systems** — events, kill tracking, trust relationships, and more.
- **Configurable** — gameplay values exposed through `config.yml`.
- **Performance-focused** — async-safe tasks, re-entrance guards, and sorted/BFS routines for bulk operations.
- **Built-in resource pack** — no separate download, hosting, or server config required.

### Bugs

- AltarManager; Contains Bugs Related to Map<here>
- Check Proper KnightFallKillTracker Usage from KillTracker Ensure we are Using KnightFallKillTracker NOT KillTracker for KnightFall Weapon
- AncientBladeAbility.java method "presence", "unyieldingDarkness" always returns true
- TidebreakerAbility.java method "stormcall", "risingTide" always returns true
- WitherSymbioteAbility.java method "infection", "rampage"
- CopperBootsSpeedAbility.java method "hasCustomNetheriteBoots" always returns false
- CopperLeggingsEventManager.java check why startEventCooldown method isnt being called
- KnightfallListener.java method startCloak isnt being called why?
- NetheriteHelmetAbilityListener.java method stopEffectTask isnt being called why?
- BossBarManager.java method removeBarFromAll, addPlayerToEventBar isnt being called why?
- CustomItemRegistry.java Review Warnings
- LegendaryItemConfigMenu method showConfigDialog not being called why?
- VampireEventManager.java method updatePlayerDisplay not being called why?

- Next: weapon/* folder check for Bugs

## Requirements

| Component | Version                            |
|-----------|------------------------------------|
| Server    | Paper 1.21.11 (or compatible fork) |
| Java      | 21                                 |
| Build     | Maven 3.9+ (compile only)          |

`WorldEdit` / `WorldGuard` are optional soft dependencies and are only needed for region-aware behavior.

## Installation

1. Download `AltarSMP-1.2.jar`.
2. Place it in your server's `plugins/` directory.
3. Restart the server.
4. Adjust values in `plugins/AltarSMP/config.yml` as needed.

The required resource pack is **bundled inside the plugin**. You do **not** need to download,
install, host, or configure a separate resource pack.

## Building from Source

```bash
mvn clean package
```

The shaded plugin is produced at `target/AltarSMP-1.2.jar`. Dependencies (`org.json`) are
bundled by the Maven Shade plugin; Paper API and WorldEdit/WorldGuard are `provided` and
resolved from the configured repositories.

## Configuration

All gameplay values live in `config.yml`. Ability keys are namespaced per section
(e.g. `tidebreaker.*`, `ancientblade.*`, `omen.*`), and most cooldowns/durations are
expressed in ticks unless noted otherwise.

## Commands

| Command                                                             | Description                         |
|---------------------------------------------------------------------|-------------------------------------|
| `/altar`                                                            | Altar management and administration |
| `/legendaries`                                                      | Open the legendary items menu       |
| `/controls`                                                         | View available ability controls     |
| `/cooldown`                                                         | Check remaining cooldowns           |
| `/ability1`                                                         | Trigger the main-hand ability       |
| `/ability2`                                                         | Trigger the off-hand ability        |
| `/trust`, `/untrust`                                                | Manage player trust relationships   |
| `/bingo`, `/startbingo`                                             | Bingo event control                 |
| `/startleggingsevent`, `/starthelmetevent`, `/startchestplateevent` | Armor events                        |
| `/vampire`                                                          | Vampire event control               |
| `/setkills`                                                         | Set a player's kill count           |
| `/checklegendary`                                                   | Inspect legendary ownership         |

## Project Layout

```
src/main/java/net/kingscraft/zenixmc/altarsmp/
├── ability/     Season 1 abilities
├── altars2/     Season 2 abilities, listeners, and systems
├── altar/       Altar structure handling and display
├── armor/       Custom armor (e.g. copper)
├── item/        Item types, IDs, and registry
├── legendary/   Legendary weapon menus and configuration dialogs
├── menu/        Dialog and inventory framework
├── event/       Server-side events (e.g. bingo)
├── vampire/     Vampire event logic
├── weapon/      Custom weapons (e.g. witherbone)
└── util/, trust/, bossbar/, core/, illusion/, command/, listener/
src/main/resources/   plugin.yml, config.yml, embedded resource pack
```

## Notes

- Season 2 legendary items use item models (no `CustomModelData`); item similarity checks
  resolve via item-model matching in `AltarSMP#areSimilar`.
- Resource pack format targets 1.21.11 (`pack_format` 75, data pack 94.1).

## License

All rights reserved unless otherwise stated.
