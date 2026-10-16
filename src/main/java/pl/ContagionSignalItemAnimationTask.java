package pl;

import org.bukkit.Location;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class ContagionSignalItemAnimationTask extends BukkitRunnable {
  int ticksLived;
  
  final ItemDisplay itemDisplay;
  
  final Location location;
  
  ContagionSignalItemAnimationTask(ItemDisplay paramItemDisplay, Location paramLocation) {
        this.itemDisplay = paramItemDisplay;
        this.location = paramLocation;
        this.ticksLived = 0;
    }
  
  public void run() {
    try {
      if (this.ticksLived == 2) {
        this.itemDisplay.teleport(this.location.clone().add(0.0D, 0.5D, 0.0D));
      } else {
        try {
          if (this.ticksLived == 20) {
            this.itemDisplay.setTeleportDuration(5);
          } else {
            try {
              if (this.ticksLived == 22)
                this.itemDisplay.teleport(this.location);
            } catch (MatchException matchException) {
              throw a(null);
            } 
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.ticksLived++;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gk.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */