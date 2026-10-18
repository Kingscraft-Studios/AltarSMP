package net.kingscraft.zenixmc.altarsmp.item;

import net.kyori.adventure.text.Component;

public record ToggleStat(Component label, String key) implements ItemStat {
}
