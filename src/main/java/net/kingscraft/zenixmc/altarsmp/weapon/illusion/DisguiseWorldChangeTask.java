package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.scheduler.BukkitRunnable;

class DisguiseWorldChangeTask extends BukkitRunnable {

  private final PlayerChangedWorldEvent event;

  DisguiseWorldChangeTask(PlayerChangedWorldEvent event) {
    this.event = event;
  }

  @Override
  public void run() {
    Player player = this.event.getPlayer();
    if (!IllusionDisguiseManager.isDisguised(player)) {
      return;
    }
    IllusionDisguiseManager.rebuildDisguise(player);
  }
}
