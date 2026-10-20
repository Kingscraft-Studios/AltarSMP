package net.kingscraft.zenixmc.altarsmp.armor.copper;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class CopperBootsFlameParticleTask extends BukkitRunnable {
  public final CopperBootsSpeedAbility ability;

  public CopperBootsFlameParticleTask(CopperBootsSpeedAbility copperBootsSpeedAbility) {
        this.ability = copperBootsSpeedAbility;
    }

  public void run() {
    if (!this.ability.enableFireResistance)
      return; 

    for (Player player : this.ability.copperBootsPlayers) {
      if (player != null) {
        if (!player.isOnline())
          continue; 

        Location location = player.getLocation();
        player.getWorld().spawnParticle(Particle.FLAME, location.getX(), location.getY() + 0.2D, location.getZ(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
      } 
    } 
  }

}
