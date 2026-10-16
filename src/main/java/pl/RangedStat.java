package pl;

import net.kyori.adventure.text.Component;

record RangedStat(Component label, String key, float min, float max) implements ItemStat {
}
