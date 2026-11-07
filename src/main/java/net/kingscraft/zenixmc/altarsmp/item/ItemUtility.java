package net.kingscraft.zenixmc.altarsmp.item;

import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import io.papermc.paper.datacomponent.item.consumable.ItemUseAnimation;
import net.kyori.adventure.key.Key;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class ItemUtility {

  private static int getMinorVersion() {
    String version = Bukkit.getMinecraftVersion();
    String[] parts = version.split("\\.");

    return parts.length > 1 ? Integer.parseInt(parts[1]) : 0;
  }

  public static void spawnFlashParticle(Location location) {
    location.getWorld().spawnParticle(Particle.FLASH, location, 1, 0.0D, 0.0D, 0.0D, 0.0D, Color.WHITE);
  }

  public static Material getChainMaterial() {
    if (getMinorVersion() >= 10) {
      return Material.IRON_CHAIN;
    }

    return Material.valueOf("CHAIN");
  }

  public static void setConsumableData(ItemStack itemStack, String configKey) {
    setConsumableData(itemStack, AltarSMP.getInstance().getConfig().getDouble(configKey, 3.0D));
  }

  public static void setConsumableData(ItemStack itemStack, double seconds) {
    setConsumableData(itemStack, seconds, "");
  }

  public static void setConsumableData(ItemStack itemStack, double seconds, String soundKey) {
    float consumeSeconds = (float) seconds;
    Key consumeSound = Key.key(soundKey);

    ItemUseAnimation animation = getMinorVersion() >= 11 ? ItemUseAnimation.TRIDENT : ItemUseAnimation.BOW;

    itemStack.setData(DataComponentTypes.CONSUMABLE, Consumable.consumable().consumeSeconds(consumeSeconds).animation(animation).hasConsumeParticles(false).sound(consumeSound));
  }
}
