package net.kingscraft.zenixmc.altarsmp.weapon.vulcan;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.scheduler.BukkitRunnable;

class VulcanMagmaBlockCleanupTask extends BukkitRunnable {
  public final VulcanMagmaBlockShrinkTask shrinkTask;

  public VulcanMagmaBlockCleanupTask(VulcanMagmaBlockShrinkTask vulcanMagmaBlockShrinkTask) {
        this.shrinkTask = vulcanMagmaBlockShrinkTask;
    }

  public void run() {
    this.shrinkTask.blockDisplay.remove();
  }
}
