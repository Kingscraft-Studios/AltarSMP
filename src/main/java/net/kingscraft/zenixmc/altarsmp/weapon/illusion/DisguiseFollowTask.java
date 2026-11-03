package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
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
    if (!this.player.isOnline() || this.player.isDead() || !IllusionDisguiseManager.isDisguised(this.player) || this.targetEntity == null || this.targetEntity.isDead()) {
      IllusionDisguiseManager.revealPlayer(this.player, false);
      cancel();
      return;
    }

    // Never chase the player into a different world. The shell is rebuilt by
    // DisguiseWorldChangeTask once the client has loaded the new world.
    boolean sameWorld = this.targetEntity.getWorld().equals(this.player.getWorld());
    if (sameWorld) {
      this.targetEntity.teleport(this.player);
      if (this.targetEntity instanceof LivingEntity living) {
        // Keep the shell's damage state in lock-step with the real player so
        // i-frames and follow-up hits behave like a single entity.
        if (living.getMaximumNoDamageTicks() != this.player.getMaximumNoDamageTicks()) {
          living.setMaximumNoDamageTicks(this.player.getMaximumNoDamageTicks());
        }
        if (living.getNoDamageTicks() != this.player.getNoDamageTicks()) {
          living.setNoDamageTicks(this.player.getNoDamageTicks());
        }
        if (Math.abs(living.getLastDamage() - this.player.getLastDamage()) > 1.0E-4D) {
          living.setLastDamage(this.player.getLastDamage());
        }
        IllusionDisguiseManager.restoreShell(living);
      }
    }
    this.ticks++;
    // The client re-sends real equipment whenever a slot changes, so mask it
    // again a few times per second instead of using a packet library.
    if (this.ticks % 5 == 0) {
      IllusionDisguiseManager.hideEquipment(this.player);
      IllusionDisguiseManager.rehideShell(this.player);
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
