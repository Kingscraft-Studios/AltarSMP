# AltarSMP: Full Experience

A Paper plugin that combines **Season 1** and **Season 2** AltarSMP content into a single
installable package — custom abilities, equipment, altars, events, and external resource pack integration all wired through one configuration.

> **Season 1 + Season 2. One plugin. One installation. One complete experience.**

## Features

- **Season 1 content** — classic altars, abilities, equipment, and event systems.
- **Season 2 content** — legendary weapons, reworked abilities, and supporting mechanics.
- **Custom abilities** — triggerable via keybinds and commands with cooldown handling.
- **Custom items & equipment** — weapons, armor, tools, and utility items with unique behavior.
- **Custom textures, 3D models & sounds** — dynamically delivered to joining players via hosted resource pack.
- **Immersive gameplay systems** — events, kill tracking, trust relationships, and more.
- **Configurable** — gameplay values exposed through `config.yml`.
- **Performance-focused** — async-safe tasks, re-entrance guards, and sorted/BFS routines for bulk operations.
- **Automated resource pack Delivery** — external hosting via MCPacks with auto-prompt on join.

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

## Resource Pack

The required resource pack is automatically handled by the plugin:
- **Author & Assets:** Created by **[Doomwen](https://modrinth.com/user/Doomwen)**. All custom textures, 3D models, and audio assets remain the property of their respective creator.
- **Hosting & Delivery:** Hosted externally via **MCPacks**. When players join the server, the plugin automatically prompts and applies the pack without requiring manual server hosting or player downloads.
## Installation

1. Download `AltarSMP-X.X.X.jar`.
2. Place it in your server's `plugins/` directory.
3. Restart the server.
4. Adjust values in `plugins/AltarSMP/config.yml` as needed.

## Building from Source

```bash
mvn clean package