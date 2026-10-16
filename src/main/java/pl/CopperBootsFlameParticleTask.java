package pl;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CopperBootsFlameParticleTask extends BukkitRunnable {
  final CopperBootsSpeedAbility ability;
  
  CopperBootsFlameParticleTask(CopperBootsSpeedAbility copperBootsSpeedAbility) {
        this.ability = copperBootsSpeedAbility;
    }
  
  public void run() {
    try {
      if (!this.ability.enableFireResistance)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    for (Player player : this.ability.copperBootsPlayers) {
      if (player != null) {
        try {
          if (!player.isOnline())
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        Location location = player.getLocation();
        player.getWorld().spawnParticle(Particle.FLAME, location.getX(), location.getY() + 0.2D, location.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
      } 
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f6.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */