package net.kingscraft.zenixmc.altarsmp.item;

import net.kyori.adventure.text.Component;

public record RangedStat(Component label, String key, float min, float max) implements ItemStat {
}
