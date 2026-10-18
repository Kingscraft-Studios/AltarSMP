package net.kingscraft.zenixmc.altarsmp.armor.copper;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class CopperBootsEffectRefreshTask extends BukkitRunnable {
  public final CopperBootsSpeedAbility ability;
  
  public CopperBootsEffectRefreshTask(CopperBootsSpeedAbility copperBootsSpeedAbility) {
        this.ability = copperBootsSpeedAbility;
    }
  
  public void run() {
    for (Player player : this.ability.copperBootsPlayers) {
      if (player != null) {
        try {
          if (!player.isOnline())
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        this.ability.updatePlayerEffects(player, false);
      } 
    } 
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f7.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */