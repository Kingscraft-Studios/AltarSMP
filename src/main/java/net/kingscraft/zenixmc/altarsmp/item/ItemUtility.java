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


  public static void spawnFlashParticle(Location paramLocation) {
    String str = Bukkit.getMinecraftVersion();
    {
      if (Integer.parseInt(str.split("\\.")[2]) >= 9) {
        paramLocation.getWorld().spawnParticle(Particle.FLASH, paramLocation, 1, 0.0D, 0.0D, 0.0D, 0.0D, Color.WHITE);
      } else {
        paramLocation.getWorld().spawnParticle(Particle.FLASH, paramLocation, 1, 0.0D, 0.0D, 0.0D, 0.0D, Color.WHITE);
      } 
    }}

  public static Material getChainMaterial() {
    String str = Bukkit.getMinecraftVersion();
    {
      if (Integer.parseInt(str.split("\\.")[2]) >= 10)
        return Material.IRON_CHAIN; 
    }return Material.valueOf("CHAIN");
  }

  public static void setConsumableData(ItemStack paramItemStack, String paramString) {
    setConsumableData(paramItemStack, AltarSMP.getInstance().getConfig().getDouble(paramString, 3.0D));
  }

  public static void setConsumableData(ItemStack paramItemStack, double seconds) {
    setConsumableData(paramItemStack, seconds, "");
  }

  public static void setConsumableData(ItemStack paramItemStack, double seconds, String soundKey) {
    String str = Bukkit.getMinecraftVersion();
    float consumeSeconds = (float) seconds;
    Key consumeSound = Key.key(soundKey);
    {
      if (Integer.parseInt(str.split("\\.")[2]) >= 11) {
        paramItemStack.setData(DataComponentTypes.CONSUMABLE, Consumable.consumable().consumeSeconds(consumeSeconds).animation(ItemUseAnimation.TRIDENT).hasConsumeParticles(false).sound(consumeSound));
      } else {
        paramItemStack.setData(DataComponentTypes.CONSUMABLE, Consumable.consumable().consumeSeconds(consumeSeconds).animation(ItemUseAnimation.BOW).hasConsumeParticles(false).sound(consumeSound));
      } 
    }}



}
