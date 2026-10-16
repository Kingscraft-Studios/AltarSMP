package pl;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

class KnightfallItemRestoreTask extends BukkitRunnable {
  final Player player;
  
  KnightfallItemRestoreTask(KnightFallKillTracker knightFallKillTracker, Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    for (byte b = 0; b < this.player.getInventory().getSize(); b++) {
      ItemStack itemStack = this.player.getInventory().getItem(b);
      if (itemStack != null && KnightfallListener.isKnightfall(itemStack)) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setLore(CustomItemRegistry.getKnightfall(this.player, false).getItemMeta().getLore());
        itemMeta.setCustomModelData(Integer.valueOf(CustomItemRegistry.getKnightfall(this.player, false).getItemMeta().getCustomModelData()));
        itemStack.setItemMeta(itemMeta);
        this.player.getInventory().setItem(b, itemStack);
      }
    } 
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fz.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */