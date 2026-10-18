package net.kingscraft.zenixmc.altarsmp.event.contagion;

import org.bukkit.Location;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class ContagionSignalItemAnimationTask extends BukkitRunnable {
  public int ticksLived;

  public final ItemDisplay itemDisplay;

  public final Location location;

  public ContagionSignalItemAnimationTask(ItemDisplay paramItemDisplay, Location paramLocation) {
        this.itemDisplay = paramItemDisplay;
        this.location = paramLocation;
        this.ticksLived = 0;
    }

  public void run() {
    if (this.ticksLived == 2) {
      this.itemDisplay.teleport(this.location.clone().add(0.0D, 0.5D, 0.0D));
    } else {
      if (this.ticksLived == 20) {
        this.itemDisplay.setTeleportDuration(5);
      } else {
        if (this.ticksLived == 22)
          this.itemDisplay.teleport(this.location);

      } 

    } 

    this.ticksLived++;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gk.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */