package net.kingscraft.zenixmc.altarsmp.weapon.wind;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class WindLeapParticleTask extends BukkitRunnable {
  public int ticks;
  
  public final Player player;
  
  public WindLeapParticleTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.ticks = 0;
    }
  
  public void run() {
    try {
      this.player.getWorld().spawnParticle(Particle.CLOUD, this.player.getLocation(), 2, 0.0D, 0.0D, 0.0D, 0.0D);
      this.ticks++;
      if (this.ticks < 20) {
        try {
          if (this.player.isOnGround()) {
            cancel();
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    cancel();
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fd.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */