package pl;

import org.bukkit.scheduler.BukkitRunnable;

class CleansingBlockLandingTask extends BukkitRunnable {
  final CleansingBlockAnimationTask animationTask;
  
  CleansingBlockLandingTask(CleansingBlockAnimationTask paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fj) {
        this.animationTask = paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fj;
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