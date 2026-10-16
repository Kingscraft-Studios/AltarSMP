package pl;

import java.util.List;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

class ShadeOrbTeleportTask extends BukkitRunnable {
  final List orbs;
  
  final Player player;
  
  ShadeOrbTeleportTask(List paramList, Player paramPlayer) {
        this.orbs = paramList;
        this.player = paramPlayer;
    }
  
  public void run() {
    for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.orbs)
      itemDisplay.setTeleportDuration(20); 
    (new ShadeOrbRecoilTask(this)).runTaskLater((Plugin)Main.getInstance(), 3L);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ev.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */