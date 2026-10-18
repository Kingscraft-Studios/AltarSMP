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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fk.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */