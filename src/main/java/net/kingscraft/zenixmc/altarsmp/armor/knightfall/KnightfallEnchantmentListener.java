package net.kingscraft.zenixmc.altarsmp.armor.knightfall;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

public class KnightfallEnchantmentListener implements Listener {
  public static boolean areMatchingItems(ItemStack paramItemStack1, ItemStack paramItemStack2) {
    if (paramItemStack1 != null) {
      if (paramItemStack2 == null)
        return false; 

    } else {
      return false;
    } 

    if (paramItemStack1.getType() != paramItemStack2.getType())
      return false; 

    ItemMeta itemMeta1 = paramItemStack1.getItemMeta();
    ItemMeta itemMeta2 = paramItemStack2.getItemMeta();
    if (itemMeta1 == null)
      {
        if (itemMeta2 == null)
          return true; 
      }  

    if (itemMeta1 != null) {
      if (itemMeta2 == null)
        return false; 

    } else {
      return false;
    } 

    if (!paramItemStack1.getItemMeta().getDisplayName().equals(paramItemStack2.getItemMeta().getDisplayName()))
      return false; 

    if (itemMeta1.hasCustomModelData())
      {
        if (itemMeta2.hasCustomModelData()) {


          return (itemMeta1.getCustomModelData() == itemMeta2.getCustomModelData());
        } 
      }  

    if (!itemMeta1.hasCustomModelData())
      {
        if (!itemMeta2.hasCustomModelData());
      }  

    return false;
  }

  @EventHandler
  public void onEnchantItem(EnchantItemEvent paramEnchantItemEvent) {
    ItemStack itemStack = paramEnchantItemEvent.getItem();
    Player player = paramEnchantItemEvent.getEnchanter();
    if (!areMatchingItems(itemStack, CustomItemRegistry.getKnightfall(player, false))) {
      return;
    }
    if (paramEnchantItemEvent.getEnchantsToAdd().containsKey(Enchantment.DENSITY) || paramEnchantItemEvent.getEnchantsToAdd().containsKey(Enchantment.BREACH)) {
      if (AltarSMP.getInstance().knightFallKillTracker.getKillCount(player) < 8) {
        paramEnchantItemEvent.setCancelled(true);
      }
    }
    if (paramEnchantItemEvent.getEnchantsToAdd().containsKey(Enchantment.WIND_BURST) && AltarSMP.getInstance().knightFallKillTracker.getKillCount(player) < 2) {
      paramEnchantItemEvent.setCancelled(true);
    }
  }

  @EventHandler
  public void onPrepareAnvil(PrepareAnvilEvent paramPrepareAnvilEvent) {
    ItemStack itemStack = paramPrepareAnvilEvent.getResult();
    Player player = (Player)paramPrepareAnvilEvent.getView().getPlayer();
    if (itemStack == null) {
      return;
    }
    if (!areMatchingItems(itemStack, CustomItemRegistry.getKnightfall(player, false))) {
      return;
    }
    if (itemStack.containsEnchantment(Enchantment.DENSITY) || itemStack.containsEnchantment(Enchantment.BREACH)) {
      if (AltarSMP.getInstance().knightFallKillTracker.getKillCount(player) < 8) {
        itemStack.removeEnchantment(Enchantment.DENSITY);
        itemStack.removeEnchantment(Enchantment.BREACH);
        paramPrepareAnvilEvent.setResult(itemStack);
      }
    }
    if (itemStack.containsEnchantment(Enchantment.WIND_BURST) && AltarSMP.getInstance().knightFallKillTracker.getKillCount(player) < 2) {
      itemStack.removeEnchantment(Enchantment.WIND_BURST);
      paramPrepareAnvilEvent.setResult(itemStack);
    }
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764as.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */