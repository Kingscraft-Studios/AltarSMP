package pl;

import org.bukkit.scheduler.BukkitRunnable;

class EarthShatterDisplayRemovalTask extends BukkitRunnable {
  final EarthShatterDisplayShrinkTask shrinkTask;
  
  EarthShatterDisplayRemovalTask(EarthShatterDisplayShrinkTask earthShatterDisplayShrinkTask) {
        this.shrinkTask = earthShatterDisplayShrinkTask;
    }
  
  public void run() {
    this.shrinkTask.detonationTask.itemDisplay.remove();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ei.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */