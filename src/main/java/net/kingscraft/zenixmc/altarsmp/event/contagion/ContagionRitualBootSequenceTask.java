package net.kingscraft.zenixmc.altarsmp.event.contagion;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ContagionRitualBootSequenceTask extends BukkitRunnable {


  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.sendMessage(" ");
      player.sendMessage("§8>> §a# BOOT SEQUENCE COMPLETE");
      player.sendMessage("§cCOMMENCING CONTAGION RITUAL...");
      player.sendMessage(" ");
    } 
  }


}
