package pl;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

class SlashHideTask extends BukkitRunnable {
  final ItemDisplay display;
  
  SlashHideTask(ItemDisplay paramItemDisplay) {
        this.display = paramItemDisplay;
    }
  
  public void run() {
    Transformation transformation = this.display.getTransformation();
    transformation.getScale().set(0.0F, 0.0F, 0.0F);
    this.display.setTransformation(transformation);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e2.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */