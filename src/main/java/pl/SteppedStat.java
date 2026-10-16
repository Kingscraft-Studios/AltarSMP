package pl;

import net.kyori.adventure.text.Component;

record SteppedStat(Component label, String key, float min, float max, float step) implements ItemStat {
}
