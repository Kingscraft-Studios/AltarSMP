package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class EarthShatterRisingAnimationTask extends BukkitRunnable {
  final int MAX_TICKS = 40;

  public int ticks;

  public final ItemDisplay itemDisplay;

  public final int radius;

  public final Location origin;

  public EarthShatterRisingAnimationTask(ItemDisplay paramItemDisplay, int paramInt, Location paramLocation) {
        this.itemDisplay = paramItemDisplay;
        this.radius = paramInt;
        this.origin = paramLocation;
        this.ticks = 0;
    }

  public void run() {
    if (this.ticks >= 40) {
      cancel();
      return;
    } 

    Location location = this.itemDisplay.getLocation();
    this.itemDisplay.getWorld().spawnParticle(Particle.DUST, location.clone().subtract(0.0D, this.radius / 2.0D, 0.0D), 20, 0.5D, 1.0D, 0.5D, new Particle.DustOptions(Color.fromRGB(200, 165, 100), 1.5F));
    for (double d = 0.0D; d < 2.0D; d += 0.1D) {
      Location location1 = this.origin.clone().add(0.0D, d, 0.0D);
      location1.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, location1, 1, 0.0D, 0.0D, 0.0D, 0.0D);
    } 
    this.ticks++;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764el.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */