package pl;

import io.papermc.paper.datacomponent.DataComponentBuilder;
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

public class ItemUtility {
  
  
  public static void spawnFlashParticle(Location paramLocation) {
    String str = Bukkit.getMinecraftVersion();
    {
      if (Integer.parseInt(str.split("\\.")[2]) >= 9) {
        paramLocation.getWorld().spawnParticle(Particle.FLASH, paramLocation, 1, 0.0D, 0.0D, 0.0D, 0.0D, Color.WHITE);
      } else {
        paramLocation.getWorld().spawnParticle(Particle.FLASH, paramLocation, 1, 0.0D, 0.0D, 0.0D, 0.0D);
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
    String str = Bukkit.getMinecraftVersion();
    {
      if (Integer.parseInt(str.split("\\.")[2]) >= 11) {
        paramItemStack.setData(DataComponentTypes.CONSUMABLE, (DataComponentBuilder)Consumable.consumable().consumeSeconds((float)Main.getInstance().getConfig().getDouble(paramString, 3.0D)).animation(ItemUseAnimation.TRIDENT).hasConsumeParticles(false).sound(Key.key("")));
      } else {
        paramItemStack.setData(DataComponentTypes.CONSUMABLE, (DataComponentBuilder)Consumable.consumable().consumeSeconds((float)Main.getInstance().getConfig().getDouble(paramString, 3.0D)).animation(ItemUseAnimation.BOW).hasConsumeParticles(false).sound(Key.key("")));
      } 
    }}
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a6.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */