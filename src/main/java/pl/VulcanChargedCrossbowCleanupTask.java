package pl;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class VulcanChargedCrossbowCleanupTask extends BukkitRunnable {
  final Player player;
  
  final VulcanGauntletAbility ability;
  
  VulcanChargedCrossbowCleanupTask(VulcanGauntletAbility vulcanGauntletAbility, Player paramPlayer) {
        this.ability = vulcanGauntletAbility;
        this.player = paramPlayer;
    }
  
  public void run() {
    this.ability.chargedCrossbowUsers.remove(this.player);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dm.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */