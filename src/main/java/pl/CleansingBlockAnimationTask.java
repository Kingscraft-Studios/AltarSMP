package pl;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

class CleansingBlockAnimationTask extends BukkitRunnable {
  final ItemDisplay outerBlockDisplay;
  
  final ItemDisplay innerBlockDisplay;
  
  final int animationDuration;
  
  final Location landingLocation;
  
  final World world;
  
  final Location originLocation;
  
  final float outerBlockScale;
  
  final float innerBlockScale;
  
  CleansingBlockAnimationTask(ItemDisplay paramItemDisplay1, ItemDisplay paramItemDisplay2, int paramInt, Location paramLocation1, World paramWorld, Location paramLocation2, float paramFloat1, float paramFloat2) {
        this.outerBlockDisplay = paramItemDisplay1;
        this.innerBlockDisplay = paramItemDisplay2;
        this.animationDuration = paramInt;
        this.landingLocation = paramLocation1;
        this.world = paramWorld;
        this.originLocation = paramLocation2;
        this.outerBlockScale = paramFloat1;
        this.innerBlockScale = paramFloat2;
    }
  
  public void run() {
    try {
      if (this.outerBlockDisplay.isValid())
        try {
          if (this.innerBlockDisplay.isValid()) {
            this.outerBlockDisplay.setTeleportDuration(this.animationDuration);
            this.innerBlockDisplay.setTeleportDuration(this.animationDuration);
            (new CleansingBlockLandingTask(this)).runTaskLater((Plugin)Main.getInstance(), 2L);
            this.world.spawnParticle(Particle.SQUID_INK, this.originLocation, 20, 0.2D, 0.2D, 0.2D, 0.05D);
            (new CleansingBlockShrinkTask(this)).runTaskLater((Plugin)Main.getInstance(), this.animationDuration + 2L);
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fj.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */