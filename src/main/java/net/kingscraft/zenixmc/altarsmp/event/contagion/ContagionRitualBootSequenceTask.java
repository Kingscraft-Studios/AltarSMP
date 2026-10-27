package net.kingscraft.zenixmc.altarsmp.event.contagion;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;

public class ContagionRitualBootSequenceTask extends BukkitRunnable {


  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.sendMessage(Component.text(" "));
      player.sendMessage(Component.text()
          .append(Component.text(">> ", NamedTextColor.DARK_GRAY))
          .append(Component.text("# BOOT SEQUENCE COMPLETE", NamedTextColor.GREEN))
          .build());
      player.sendMessage(Component.text("COMMENCING CONTAGION RITUAL...", NamedTextColor.RED));
      player.sendMessage(Component.text(" "));
    } 
  }


}
