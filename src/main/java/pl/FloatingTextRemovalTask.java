package pl;

import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class FloatingTextRemovalTask extends BukkitRunnable {
  final TextDisplay textDisplay;
  
  FloatingTextRemovalTask(TextDisplay paramTextDisplay) {
        this.textDisplay = paramTextDisplay;
    }
  
  public void run() {
    this.textDisplay.remove();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hl.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */