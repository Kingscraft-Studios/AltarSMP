package pl;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class CrazyRandomizerDisplayRemovalTask extends BukkitRunnable {
  final ItemDisplay itemDisplay;
  
  CrazyRandomizerDisplayRemovalTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }
  
  public void run() {
    this.itemDisplay.remove();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hh.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */