package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BloodHookTrailParticleTask extends BukkitRunnable {
  public int ticksElapsed;

  final int duration = 100;

  public final Location startLocation;

  public final Location endLocation;

  public final BloodHookTargetingTask targetingTask;

  public BloodHookTrailParticleTask(BloodHookTargetingTask bloodHookTargetingTask, Location paramLocation1, Location paramLocation2) {
        this.targetingTask = bloodHookTargetingTask;
        this.startLocation = paramLocation1;
        this.endLocation = paramLocation2;
        this.ticksElapsed = 0;
    }

  public void run() {
    if (this.ticksElapsed < 100)
      {
        if (this.targetingTask.player.isOnline()) {
          int b = 0;
          while (true) {
            if (b < 5 && this.ticksElapsed < 100) {
              double d = this.ticksElapsed / 100.0D;
              Location location = this.startLocation.clone().add((this.endLocation.getX() - this.startLocation.getX()) * d, (this.endLocation.getY() - this.startLocation.getY()) * d, (this.endLocation.getZ() - this.startLocation.getZ()) * d);
              if (this.ticksElapsed % 10 == 0)
                this.targetingTask.player.spawnParticle(Particle.DUST, location, 0, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.RED, 0.75F));

              if (this.ticksElapsed % 20 == 0)
                this.targetingTask.player.spawnParticle(Particle.ELECTRIC_SPARK, location, 0, 0.0D, 0.0D, 0.0D, 0.0D);

              this.ticksElapsed++;
              b++;
              continue;
            } 

            break;
          } 
          return;
        } 
        this.targetingTask.abilityListener.bloodInfectionTasks.remove(this.targetingTask.player.getUniqueId());
        cancel();
        return;
      }  

    this.targetingTask.abilityListener.bloodInfectionTasks.remove(this.targetingTask.player.getUniqueId());
    cancel();
  }

}
