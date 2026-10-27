package net.kingscraft.zenixmc.altarsmp.event.contagion;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

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
      player.sendMessage(Component.text(" "));
      player.sendMessage(Component.text()
          .append(Component.text(">> ", NamedTextColor.DARK_GRAY))
          .append(Component.text("# INPUTTING COORDINATES...", NamedTextColor.GREEN))
          .build());
      player.sendMessage(Component.text()
          .append(Component.text("X: ", NamedTextColor.GREEN))
          .append(Component.text(String.valueOf(i), NamedTextColor.WHITE))
          .append(Component.text(" | ", NamedTextColor.DARK_GRAY))
          .append(Component.text("Y: ", NamedTextColor.GREEN))
          .append(Component.text(String.valueOf(j), NamedTextColor.WHITE))
          .append(Component.text(" | ", NamedTextColor.DARK_GRAY))
          .append(Component.text("Z: ", NamedTextColor.GREEN))
          .append(Component.text(String.valueOf(k), NamedTextColor.WHITE))
          .build());
      player.sendMessage(Component.text(" "));
    } 
  }


}
