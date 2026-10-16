package pl;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class MudslideParticleTask extends BukkitRunnable {
  final double particleYOffset = 0.5D;
  
  int ticksLived;
  
  final Player player;
  
  MudslideParticleTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.ticksLived = 0;
    }
  
  public void run() {
    try {
      if (this.ticksLived >= 10.0D) {
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.player.getWorld().spawnParticle(Particle.BLOCK_CRUMBLE, this.player.getLocation().clone().add(0.0D, 1.0D, 0.0D), 20, 0.2D, 0.5D, 0.2D, 0.0D, Material.PACKED_MUD.createBlockData());
    this.ticksLived++;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d9.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */