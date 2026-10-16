package pl;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class SolarLeapParticleTask extends BukkitRunnable {
  int ticks;
  
  final Player player;
  
  SolarLeapParticleTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.ticks = 0;
    }
  
  public void run() {
    try {
      if (!this.player.isOnGround())
        try {
          if (!this.player.isInWater())
            try {
              if (!this.player.isInLava()) {
                Location location = this.player.getLocation();
                FloatingTextEffectUtils.spawnAnimatedTextEffect(location, 1, Color.YELLOW, Color.YELLOW, 0.0D, 1, 20, 0, true, "⭐", 10, 20);
                this.ticks++;
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
    } catch (MatchException matchException) {
      throw a(null);
    } 
    cancel();
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fq.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */