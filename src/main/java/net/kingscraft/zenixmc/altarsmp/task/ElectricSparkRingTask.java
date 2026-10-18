package net.kingscraft.zenixmc.altarsmp.task;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class ElectricSparkRingTask extends BukkitRunnable {
  public int ticks;
  
  public final double radius;
  
  public final Location center;
  
  public ElectricSparkRingTask(double paramDouble, Location paramLocation) {
        this.radius = paramDouble;
        this.center = paramLocation;
        this.ticks = 0;
    }
  
  public void run() {
    try {
      if (this.ticks >= 40) {
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    int i = (int)(this.radius * 32.0D);
    for (int b = 0; b < i; b++) {
      double d1 = 6.283185307179586D * b / i;
      double d2 = this.center.getX() + this.radius * Math.cos(d1);
      double d3 = this.center.getZ() + this.radius * Math.sin(d1);
      Location location = new Location(this.center.getWorld(), d2, this.center.getY() + 0.5D, d3);
      this.center.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, location, 1, 0.0D, 0.0D, 0.0D, 0.0D);
    } 
    this.ticks++;
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dt.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */