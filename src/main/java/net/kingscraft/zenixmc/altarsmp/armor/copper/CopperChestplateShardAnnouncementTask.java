package net.kingscraft.zenixmc.altarsmp.armor.copper;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.altar.AltarRitualListener;

class CopperChestplateShardAnnouncementTask extends BukkitRunnable {
  public final CopperChestplateEventManager eventManager;

  public CopperChestplateShardAnnouncementTask(CopperChestplateEventManager copperChestplateEventManager) {
        this.eventManager = copperChestplateEventManager;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (AltarRitualListener.isCopperChestplatePlayer(player)) {
          cancel();
          return;
        } 
      }boolean bool = false;
      for (ItemStack itemStack : player.getInventory().getContents()) {
        if (this.eventManager.isChestplateShard(itemStack)) {
          bool = true;
          break;
        } 
      } 
      if (bool) {
        Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + ChatColor.BOLD.toString() + player.getName() + " §rhas the " + String.valueOf(ChatColor.of("#B06736")) + "§lChestplate Shard§r in the " + this.eventManager.getWorldDisplayName(player.getWorld()) + " at (" + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ() + ")");
      } 
    } 
  }



}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gd.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */