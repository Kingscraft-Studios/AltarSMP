package net.kingscraft.zenixmc.altarsmp.weapon.vulcan;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class VulcanChargedCrossbowCleanupTask extends BukkitRunnable {
  public final Player player;
  
  public final VulcanGauntletAbility ability;
  
  public VulcanChargedCrossbowCleanupTask(VulcanGauntletAbility vulcanGauntletAbility, Player paramPlayer) {
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