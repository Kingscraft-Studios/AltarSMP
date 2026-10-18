package net.kingscraft.zenixmc.altarsmp.armor.copper;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CopperBootsEffectRefreshTask extends BukkitRunnable {
  public final CopperBootsSpeedAbility ability;

  public CopperBootsEffectRefreshTask(CopperBootsSpeedAbility copperBootsSpeedAbility) {
        this.ability = copperBootsSpeedAbility;
    }

  public void run() {
    for (Player player : this.ability.copperBootsPlayers) {
      if (player != null) {
        if (!player.isOnline())
          continue; 

        this.ability.updatePlayerEffects(player, false);
      } 
    } 
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f7.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */