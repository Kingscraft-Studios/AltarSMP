package pl;

import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

class EarthShatterDisplayShrinkTask extends BukkitRunnable {
  final EarthShatterDetonationTask detonationTask;

  EarthShatterDisplayShrinkTask(EarthShatterDetonationTask earthShatterDetonationTask) {
        this.detonationTask = earthShatterDetonationTask;
    }

  public void run() {
    this.detonationTask.itemDisplay.setInterpolationDelay(5);
    Transformation transformation = this.detonationTask.itemDisplay.getTransformation();
    transformation.getScale().set(0.0F, 0.0F, 0.0F);
    this.detonationTask.itemDisplay.setTransformation(transformation);
    (new EarthShatterDisplayRemovalTask(this)).runTaskLater((Plugin)Main.getInstance(), 10L);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764eh.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */