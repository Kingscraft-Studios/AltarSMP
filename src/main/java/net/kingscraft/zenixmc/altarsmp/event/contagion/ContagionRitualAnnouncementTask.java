package net.kingscraft.zenixmc.altarsmp.event.contagion;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class ContagionRitualAnnouncementTask extends BukkitRunnable {
  public final String winnerType;


  public ContagionRitualAnnouncementTask(String paramString) {
        this.winnerType = paramString;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.sendMessage(" ");
      player.sendMessage("§8>> §a# CONTAGION RITUAL CALIBRATED TO");
      player.sendMessage("§n" + this.winnerType.toUpperCase());
      player.sendMessage(" ");
    } 
  }


}
