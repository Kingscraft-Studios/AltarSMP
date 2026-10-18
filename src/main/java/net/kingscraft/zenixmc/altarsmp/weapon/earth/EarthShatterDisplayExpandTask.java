package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class EarthShatterDisplayExpandTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public EarthShatterDisplayExpandTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }

  public void run() {
    this.itemDisplay.setInterpolationDelay(-1);
    this.itemDisplay.setInterpolationDuration(5);
    Transformation transformation = this.itemDisplay.getTransformation();
    transformation.getScale().set(7.5D, 7.5D, 7.5D);
    this.itemDisplay.setTransformation(transformation);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764en.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */