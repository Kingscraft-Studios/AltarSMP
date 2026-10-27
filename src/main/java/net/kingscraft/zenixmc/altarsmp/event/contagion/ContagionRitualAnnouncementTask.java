package net.kingscraft.zenixmc.altarsmp.event.contagion;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class ContagionRitualAnnouncementTask extends BukkitRunnable {
  public final String winnerType;


  public ContagionRitualAnnouncementTask(String paramString) {
        this.winnerType = paramString;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.sendMessage(Component.text(" "));
      player.sendMessage(Component.text()
          .append(Component.text(">> ", NamedTextColor.DARK_GRAY))
          .append(Component.text("# CONTAGION RITUAL CALIBRATED TO", NamedTextColor.GREEN))
          .build());
      player.sendMessage(Component.text(this.winnerType.toUpperCase(), NamedTextColor.WHITE, TextDecoration.UNDERLINED));
      player.sendMessage(Component.text(" "));
    } 
  }


}
