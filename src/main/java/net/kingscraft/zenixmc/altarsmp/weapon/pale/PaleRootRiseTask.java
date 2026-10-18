package net.kingscraft.zenixmc.altarsmp.weapon.pale;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class PaleRootRiseTask extends BukkitRunnable {
  public final ItemDisplay rootDisplay;
  
  public PaleRootRiseTask(PaleRootsGrowthTask paleRootsGrowthTask, ItemDisplay paramItemDisplay) {
        this.rootDisplay = paramItemDisplay;
    }
  
  public void run() {
    Transformation transformation = this.rootDisplay.getTransformation();
    transformation.getTranslation().set(0.0D, 1.5D, 0.0D);
    transformation.getLeftRotation().rotateX((float)Math.toRadians(180.0D));
    this.rootDisplay.setTransformation(transformation);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d4.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */