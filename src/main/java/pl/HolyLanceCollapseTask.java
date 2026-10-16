package pl;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

class HolyLanceCollapseTask extends BukkitRunnable {
  final HolyLanceTask parent;
  
  HolyLanceCollapseTask(HolyLanceTask parent) {
        this.parent = parent;
    }
  
  public void run() {
    Transformation transformation = this.parent.display.getTransformation();
    transformation.getScale().set(0.0F, 1.0F, 0.0F);
    this.parent.display.setTransformation(transformation);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e5.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */