package pl;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class ContagionRitualCoordinatesAnnouncementTask extends BukkitRunnable {
  final Location location;
  
  
  
  ContagionRitualCoordinatesAnnouncementTask(Location paramLocation) {
        this.location = paramLocation;
    }
  
  public void run() {
    int i = this.location.getBlockX();
    int j = this.location.getBlockY();
    int k = this.location.getBlockZ();
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.sendMessage(" ");
      player.sendMessage("§8>> §a# INPUTTING COORDINATES...");
      int m = k;
      int n = j;
      int i1 = i;
      player.sendMessage("§aX: §f" + i1 + " §8| §aY: §f" + n + " §8| §aZ: §f" + k);
      player.sendMessage(" ");
    } 
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gm.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */