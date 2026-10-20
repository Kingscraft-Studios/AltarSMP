package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.scheduler.BukkitRunnable;

class EarthShatterDisplayRemovalTask extends BukkitRunnable {
  public final EarthShatterDisplayShrinkTask shrinkTask;

  public EarthShatterDisplayRemovalTask(EarthShatterDisplayShrinkTask earthShatterDisplayShrinkTask) {
        this.shrinkTask = earthShatterDisplayShrinkTask;
    }

  public void run() {
    this.shrinkTask.detonationTask.itemDisplay.remove();
  }
}
