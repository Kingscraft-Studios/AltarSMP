package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.scheduler.BukkitRunnable;

class DisguiseWorldChangeTask extends BukkitRunnable {
  public final PlayerChangedWorldEvent event;

  public DisguiseWorldChangeTask(PlayerChangedWorldEvent paramPlayerChangedWorldEvent) {
        this.event = paramPlayerChangedWorldEvent;
    }

  public void run() {
    IllusionDisguiseManager.revealPlayer(this.event.getPlayer());
  }
}
