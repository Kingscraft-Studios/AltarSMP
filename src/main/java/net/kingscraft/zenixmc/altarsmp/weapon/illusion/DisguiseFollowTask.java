package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class DisguiseFollowTask extends BukkitRunnable {

  private final Player player;
  private final Entity targetEntity;
  private int ticks;

  DisguiseFollowTask(Player player, Entity targetEntity) {
    this.player = player;
    this.targetEntity = targetEntity;
  }

  @Override
  public void run() {
    if (!this.player.isOnline()
            || this.player.isDead()
            || !IllusionDisguiseManager.isDisguised(this.player)
            || this.targetEntity == null
            || this.targetEntity.isDead()) {
      IllusionDisguiseManager.revealPlayer(this.player, false);
      cancel();
      return;
    }

    this.targetEntity.teleport(this.player);
    this.ticks++;
    // The client re-sends real equipment whenever a slot changes, so mask it
    // again a few times per second instead of using a packet library.
    if (this.ticks % 5 == 0) {
      IllusionDisguiseManager.hideEquipment(this.player);
    }
    if (this.ticks % 20 == 0) {
      // Aggro is re-cleared twice per second so a mob cannot lock on for long.
      IllusionDisguiseManager.maintainDisguiseState(this.player);
    }
    if (this.ticks % 40 == 0) {
      IllusionDisguiseManager.sendDisguiseBar(this.player);
    }
  }
}
