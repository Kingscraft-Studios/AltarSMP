package pl;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class ElectricSparkEffectTask extends BukkitRunnable {
  int sparkTicks;
  
  final Player player;
  
  ElectricSparkEffectTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.sparkTicks = 0;
    }
  
  public void run() {
    try {
      if (this.sparkTicks < 25)
        try {
          if (this.player.isOnline()) {
            Location location = this.player.getLocation().add(0.0D, 2.5D, 0.0D);
            this.player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, location, 8, 0.0D, 0.0D, 0.0D, 0.3D);
            this.sparkTicks++;
            return;
          } 
          cancel();
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    cancel();
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ds.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */