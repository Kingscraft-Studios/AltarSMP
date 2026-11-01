package net.kingscraft.zenixmc.altarsmp.weapon.illusion.util;

import java.util.Locale;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * The three Piglin capture outcomes. Vanilla Piglins either carry a golden
 * sword, a crossbow, or nothing useful, and the captured disguise keeps that
 * choice.
 */
public enum PiglinVariant {
  SWORD,
  CROSSBOW,
  NONE;

  public static PiglinVariant fromItem(ItemStack item) {
    if (item == null || item.getType().isAir()) {
      return NONE;
    }
    Material type = item.getType();
    if (type == Material.CROSSBOW) {
      return CROSSBOW;
    }
    if (type.name().endsWith("_SWORD")) {
      return SWORD;
    }
    return NONE;
  }

  public static PiglinVariant fromName(String name) {
    if (name == null || name.isEmpty()) {
      return NONE;
    }
    try {
      return valueOf(name.toUpperCase(Locale.ROOT));
    } catch (IllegalArgumentException exception) {
      return NONE;
    }
  }
}
