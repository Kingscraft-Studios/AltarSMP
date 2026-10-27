package net.kingscraft.zenixmc.altarsmp.item;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.NamespacedKey;
import net.kyori.adventure.text.object.ObjectContents;

public final class StatIcons {
  public static Component ICON_COOLDOWN;

  public static Component ICON_DAMAGE;

  public static Component ICON_DISTANCE;

  public static Component ICON_BOLT;

  public static Component ICON_SNOWFLAKE;

  public static Component ICON_EXPLOSION;

  public static Component ICON_TOGGLE;

  public static Component ICON_STOPWATCH;

  public static Component ICON_PROJECTILE;

  static {
    ICON_COOLDOWN = Component.object(ObjectContents.sprite(new NamespacedKey("minecraft", "items"), new NamespacedKey("minecraft", "item/clock_00")));
    ICON_DAMAGE = Component.object(ObjectContents.sprite(new NamespacedKey("minecraft", "items"), new NamespacedKey("minecraft", "item/diamond_sword")));
    ICON_DISTANCE = Component.object(ObjectContents.sprite(new NamespacedKey("minecraft", "items"), new NamespacedKey("minecraft", "item/bow_pulling_2")));
    ICON_BOLT = Component.text()
        .append(Component.text("⚡", NamedTextColor.AQUA))
        .append(Component.text(" ", NamedTextColor.WHITE))
        .build();
    ICON_SNOWFLAKE = Component.text()
        .append(Component.text("❄", NamedTextColor.LIGHT_PURPLE))
        .append(Component.text(" ", NamedTextColor.WHITE))
        .build();
    ICON_EXPLOSION = Component.text()
        .append(Component.text("💥", NamedTextColor.GOLD))
        .append(Component.text(" ", NamedTextColor.WHITE))
        .build();
    ICON_TOGGLE = Component.object(ObjectContents.sprite(new NamespacedKey("minecraft", "items"), new NamespacedKey("minecraft", "item/barrier")));
    ICON_STOPWATCH = Component.text()
        .append(Component.text("⏱", NamedTextColor.YELLOW))
        .append(Component.text(" ", NamedTextColor.WHITE))
        .build();
    ICON_PROJECTILE = Component.object(ObjectContents.sprite(new NamespacedKey("minecraft", "items"), new NamespacedKey("minecraft", "item/blaze_powder")));
  }
}
