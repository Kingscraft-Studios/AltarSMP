package pl;

import java.util.List;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

class ShadeOrbInterpolateTask extends BukkitRunnable {
  final List orbs;
  
  ShadeOrbInterpolateTask(List paramList) {
        this.orbs = paramList;
    }
  
  public void run() {
    for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.orbs) {
      itemDisplay.setInterpolationDelay(0);
      itemDisplay.setInterpolationDuration(10);
    } 
    (new ShadeOrbShrinkTask(this)).runTaskLater((Plugin)Main.getInstance(), 2L);
    (new ShadeOrbCleanupTask(this)).runTaskLater((Plugin)Main.getInstance(), 10L);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ex.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */