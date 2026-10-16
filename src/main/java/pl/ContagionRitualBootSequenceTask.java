package pl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class ContagionRitualBootSequenceTask extends BukkitRunnable {
  
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.sendMessage(" ");
      player.sendMessage("§8>> §a# BOOT SEQUENCE COMPLETE");
      player.sendMessage("§cCOMMENCING CONTAGION RITUAL...");
      player.sendMessage(" ");
    } 
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gn.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */