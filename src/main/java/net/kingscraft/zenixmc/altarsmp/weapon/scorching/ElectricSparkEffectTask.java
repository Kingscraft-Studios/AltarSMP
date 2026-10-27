package net.kingscraft.zenixmc.altarsmp.weapon.scorching;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ElectricSparkEffectTask extends BukkitRunnable {
  public int sparkTicks;

  public final Player player;

  public ElectricSparkEffectTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.sparkTicks = 0;
    }

  public void run() {
    if (this.sparkTicks < 25)
      {
        if (this.player.isOnline()) {
          Location location = this.player.getLocation().add(0.0D, 2.5D, 0.0D);
          this.player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, location, 8, 0.0D, 0.0D, 0.0D, 0.3D);
          this.sparkTicks++;
          return;
        } 
        cancel();
        return;
      }  

    cancel();
  }

}
