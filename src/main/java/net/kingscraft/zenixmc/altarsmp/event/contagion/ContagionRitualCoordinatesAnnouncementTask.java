package net.kingscraft.zenixmc.altarsmp.event.contagion;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class ContagionRitualCoordinatesAnnouncementTask extends BukkitRunnable {
  public final Location location;


  public ContagionRitualCoordinatesAnnouncementTask(Location paramLocation) {
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
