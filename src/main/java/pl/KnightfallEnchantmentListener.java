package pl;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KnightfallEnchantmentListener implements Listener {
  public static boolean areMatchingItems(ItemStack paramItemStack1, ItemStack paramItemStack2) {
    try {
      if (paramItemStack1 != null) {
        try {
          if (paramItemStack2 == null)
            return false; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } else {
        return false;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramItemStack1.getType() != paramItemStack2.getType())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ItemMeta itemMeta1 = paramItemStack1.getItemMeta();
    ItemMeta itemMeta2 = paramItemStack2.getItemMeta();
    try {
      if (itemMeta1 == null)
        try {
          if (itemMeta2 == null)
            return true; 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemMeta1 != null) {
        try {
          if (itemMeta2 == null)
            return false; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } else {
        return false;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!paramItemStack1.getItemMeta().getDisplayName().equals(paramItemStack2.getItemMeta().getDisplayName()))
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemMeta1.hasCustomModelData())
        try {
          if (itemMeta2.hasCustomModelData()) {
            try {
            
            } catch (MatchException matchException) {
              throw a(null);
            } 
            return (itemMeta1.getCustomModelData() == itemMeta2.getCustomModelData());
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!itemMeta1.hasCustomModelData())
        try {
          if (!itemMeta2.hasCustomModelData());
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
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
      if (Main.getInstance().knightFallKillTracker.getKillCount(player) < 8) {
        paramEnchantItemEvent.setCancelled(true);
      }
    }
    if (paramEnchantItemEvent.getEnchantsToAdd().containsKey(Enchantment.WIND_BURST) && Main.getInstance().knightFallKillTracker.getKillCount(player) < 2) {
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
      if (Main.getInstance().knightFallKillTracker.getKillCount(player) < 8) {
        itemStack.removeEnchantment(Enchantment.DENSITY);
        itemStack.removeEnchantment(Enchantment.BREACH);
        paramPrepareAnvilEvent.setResult(itemStack);
      }
    }
    if (itemStack.containsEnchantment(Enchantment.WIND_BURST) && Main.getInstance().knightFallKillTracker.getKillCount(player) < 2) {
      itemStack.removeEnchantment(Enchantment.WIND_BURST);
      paramPrepareAnvilEvent.setResult(itemStack);
    }
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764as.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */