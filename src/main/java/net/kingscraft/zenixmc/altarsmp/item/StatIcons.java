package net.kingscraft.zenixmc.altarsmp.item;

import net.kyori.adventure.text.Component;
import org.bukkit.NamespacedKey;
import net.kyori.adventure.text.object.ObjectContents;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

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
    ICON_BOLT = Component.text("§b⚡§f ");
    ICON_SNOWFLAKE = Component.text("§d❄§f ");
    ICON_EXPLOSION = Component.text("§6💥§f ");
    ICON_TOGGLE = Component.object(ObjectContents.sprite(new NamespacedKey("minecraft", "items"), new NamespacedKey("minecraft", "item/barrier")));
    ICON_STOPWATCH = Component.text("§e⏱§f ");
    ICON_PROJECTILE = Component.object(ObjectContents.sprite(new NamespacedKey("minecraft", "items"), new NamespacedKey("minecraft", "item/blaze_powder")));
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bc.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */