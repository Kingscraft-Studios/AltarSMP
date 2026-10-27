package net.kingscraft.zenixmc.altarsmp.weapon.witherbone;

import org.bukkit.scheduler.BukkitRunnable;

class CleansingBlockCleanupTask extends BukkitRunnable {
  public final CleansingBlockEffectTask animationTask;

  public CleansingBlockCleanupTask(CleansingBlockEffectTask cleansingBlockEffectTask) {
        this.animationTask = cleansingBlockEffectTask;
    }

  public void run() {
    if (this.animationTask.outerBlockDisplay.isValid())
      this.animationTask.outerBlockDisplay.remove();

    if (this.animationTask.innerBlockDisplay.isValid())
      this.animationTask.innerBlockDisplay.remove();

  }

}
