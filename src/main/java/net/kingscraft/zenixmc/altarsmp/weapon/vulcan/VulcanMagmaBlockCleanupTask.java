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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dp.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */