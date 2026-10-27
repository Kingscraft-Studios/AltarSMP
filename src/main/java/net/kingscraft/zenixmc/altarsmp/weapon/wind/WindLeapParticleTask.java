package net.kingscraft.zenixmc.altarsmp.weapon.wind;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class WindLeapParticleTask extends BukkitRunnable {
  public int ticks;

  public final Player player;

  public WindLeapParticleTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.ticks = 0;
    }

  public void run() {
    this.player.getWorld().spawnParticle(Particle.CLOUD, this.player.getLocation(), 2, 0.0D, 0.0D, 0.0D, 0.0D);
    this.ticks++;
    if (this.ticks < 20) {
      if (this.player.isOnGround()) {
        cancel();
        return;
      } 

      return;
    } 

    cancel();
  }

}
