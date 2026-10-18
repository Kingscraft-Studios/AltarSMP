package net.kingscraft.zenixmc.altarsmp.weapon.witherbone;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fn.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */