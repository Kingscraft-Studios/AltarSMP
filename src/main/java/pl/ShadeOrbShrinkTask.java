package pl;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

class ShadeOrbShrinkTask extends BukkitRunnable {
  final ShadeOrbInterpolateTask parent;
  
  ShadeOrbShrinkTask(ShadeOrbInterpolateTask parent) {
        this.parent = parent;
    }
  
  public void run() {
    for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.parent.orbs) {
      Transformation transformation = itemDisplay.getTransformation();
      transformation.getScale().set(0.0F, 0.0F, 0.0F);
      itemDisplay.setTransformation(transformation);
    } 
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ey.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */