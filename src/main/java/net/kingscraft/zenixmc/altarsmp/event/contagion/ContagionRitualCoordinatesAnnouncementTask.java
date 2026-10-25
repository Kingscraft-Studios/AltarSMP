package net.kingscraft.zenixmc.altarsmp.event.contagion;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

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
      player.sendMessage("§aX: §f" + i + " §8| §aY: §f" + j + " §8| §aZ: §f" + k);
      player.sendMessage(" ");
    } 
  }


}
