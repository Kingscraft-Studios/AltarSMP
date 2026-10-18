package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class EarthShatterDisplayRiseTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;
  
  public final int radius;
  
  public EarthShatterDisplayRiseTask(ItemDisplay paramItemDisplay, int paramInt) {
        this.itemDisplay = paramItemDisplay;
        this.radius = paramInt;
    }
  
  public void run() {
    this.itemDisplay.teleport(this.itemDisplay.getLocation().add(0.0D, (this.radius / 2), 0.0D));
    this.itemDisplay.setRotation(0.0F, 0.0F);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ep.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */