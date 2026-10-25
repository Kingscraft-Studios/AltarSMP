package net.kingscraft.zenixmc.altarsmp.armor.copper;

import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CopperOreVeinMinerStatusTask extends BukkitRunnable {
  public final CopperOreVeinMinerListener veinMinerListener;

  public CopperOreVeinMinerStatusTask(CopperOreVeinMinerListener copperOreVeinMinerListener) {
        this.veinMinerListener = copperOreVeinMinerListener;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (CopperOreVeinMinerListener.isCopperPickaxe(player)) {
        UUID uUID = player.getUniqueId();
        boolean bool = this.veinMinerListener.veinMinerEnabled.getOrDefault(uUID, Boolean.TRUE);
        {
          if (bool) {
            player.sendActionBar(ChatColor.GOLD + "3x3 Mining: " + ChatColor.GREEN + "Enabled");
            continue;
          } 
        }player.sendActionBar(ChatColor.GOLD + "3x3 Mining: " + ChatColor.RED + "Disabled");
      } 
    } 
  }



}
