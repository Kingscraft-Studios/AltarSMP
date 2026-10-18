package net.kingscraft.zenixmc.altarsmp.armor.copper;

import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class CopperOreVeinMinerStatusTask extends BukkitRunnable {
  public final CopperOreVeinMinerListener veinMinerListener;

  public CopperOreVeinMinerStatusTask(CopperOreVeinMinerListener copperOreVeinMinerListener) {
        this.veinMinerListener = copperOreVeinMinerListener;
    }
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (CopperOreVeinMinerListener.isCopperPickaxe(player)) {
        UUID uUID = player.getUniqueId();
        boolean bool = ((Boolean)this.veinMinerListener.veinMinerEnabled.getOrDefault(uUID, Boolean.valueOf(true))).booleanValue();
        {
          if (bool) {
            player.sendActionBar(String.valueOf(ChatColor.GOLD) + "3x3 Mining: " + String.valueOf(ChatColor.GREEN) + "Enabled");
            continue;
          } 
        }player.sendActionBar(String.valueOf(ChatColor.GOLD) + "3x3 Mining: " + String.valueOf(ChatColor.RED) + "Disabled");
      } 
    } 
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gb.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */