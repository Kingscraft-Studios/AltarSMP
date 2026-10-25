package net.kingscraft.zenixmc.altarsmp.armor.copper;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.altar.AltarRitualListener;

class CopperHelmetFragmentAnnouncementTask extends BukkitRunnable {
  public final CopperHelmetEventManager eventManager;

  public CopperHelmetFragmentAnnouncementTask(CopperHelmetEventManager copperHelmetEventManager) {
        this.eventManager = copperHelmetEventManager;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (AltarRitualListener.isCopperHelmetPlayer(player)) {
          cancel();
          return;
        } 
      }boolean bool = false;
      for (ItemStack itemStack : player.getInventory().getContents()) {
        if (this.eventManager.isHelmetFragment(itemStack)) {
          bool = true;
          break;
        } 
      } 
      if (bool) {
        Bukkit.broadcastMessage(ChatColor.of("#B06736") + ChatColor.BOLD.toString() + player.getName() + " §rhas a " + ChatColor.of("#B06736") + "§lHelmet Fragment§r in the " + this.eventManager.getWorldDisplayName(player.getWorld()) + " at (" + player.getLocation().getBlockX() + ", " + player.getLocation().getBlockY() + ", " + player.getLocation().getBlockZ() + ")");
      } 
    } 
  }



}
