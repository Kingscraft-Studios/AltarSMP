package net.kingscraft.zenixmc.altarsmp.weapon.witherbone;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.scheduler.BukkitRunnable;

class CleansingBlockLandingTask extends BukkitRunnable {
  public final CleansingBlockAnimationTask animationTask;

  public CleansingBlockLandingTask(CleansingBlockAnimationTask cleansingBlockAnimationTask) {
        this.animationTask = cleansingBlockAnimationTask;
    }

  public void run() {
    this.animationTask.outerBlockDisplay.teleport(this.animationTask.landingLocation);
    this.animationTask.innerBlockDisplay.teleport(this.animationTask.landingLocation);
  }
}
