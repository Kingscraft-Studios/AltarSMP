package pl;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;

class BloodHookTrailParticleTask extends BukkitRunnable {
  int ticksElapsed;
  
  final int duration = 100;
  
  final Location startLocation;
  
  final Location endLocation;
  
  final BloodHookTargetingTask targetingTask;
  
  BloodHookTrailParticleTask(BloodHookTargetingTask bloodHookTargetingTask, Location paramLocation1, Location paramLocation2) {
        this.targetingTask = bloodHookTargetingTask;
        this.startLocation = paramLocation1;
        this.endLocation = paramLocation2;
        this.ticksElapsed = 0;
    }
  
  public void run() {
    try {
      if (this.ticksElapsed < 100)
        try {
          if (this.targetingTask.player.isOnline()) {
            byte b = 0;
            while (true) {
              try {
                if (b < 5 && this.ticksElapsed < 100) {
                  double d = this.ticksElapsed / 100.0D;
                  Location location = this.startLocation.clone().add((this.endLocation.getX() - this.startLocation.getX()) * d, (this.endLocation.getY() - this.startLocation.getY()) * d, (this.endLocation.getZ() - this.startLocation.getZ()) * d);
                  try {
                    if (this.ticksElapsed % 10 == 0)
                      this.targetingTask.player.spawnParticle(Particle.DUST, location, 0, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.RED, 0.75F));
                  } catch (MatchException matchException) {
                    throw a(null);
                  } 
                  try {
                    if (this.ticksElapsed % 20 == 0)
                      this.targetingTask.player.spawnParticle(Particle.ELECTRIC_SPARK, location, 0, 0.0D, 0.0D, 0.0D, 0.0D);
                  } catch (MatchException matchException) {
                    throw a(null);
                  } 
                  this.ticksElapsed++;
                  b++;
                  continue;
                } 
              } catch (MatchException matchException) {
                throw a(null);
              } 
              break;
            } 
            return;
          } 
          this.targetingTask.abilityListener.bloodInfectionTasks.remove(this.targetingTask.player.getUniqueId());
          cancel();
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.targetingTask.abilityListener.bloodInfectionTasks.remove(this.targetingTask.player.getUniqueId());
    cancel();
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cx.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */