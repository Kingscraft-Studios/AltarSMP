package pl;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

class CutlassParryLaunchTask extends BukkitRunnable {
  final Player player;
  
  CutlassParryLaunchTask(Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    this.player.setVelocity(this.player.getLocation().getDirection().multiply(2).setY(0.2D));
    (new CutlassParryEffectTask(this)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d7.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */