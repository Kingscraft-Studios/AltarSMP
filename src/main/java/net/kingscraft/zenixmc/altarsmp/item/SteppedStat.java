package net.kingscraft.zenixmc.altarsmp.item;

import net.kyori.adventure.text.Component;

public record SteppedStat(Component label, String key, float min, float max, float step) implements ItemStat {
}
