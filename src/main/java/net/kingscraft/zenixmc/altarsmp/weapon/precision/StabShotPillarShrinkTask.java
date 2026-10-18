package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class StabShotPillarShrinkTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;
  
  public final int verticalScale;
  
  public StabShotPillarShrinkTask(ItemDisplay paramItemDisplay, int paramInt) {
        this.itemDisplay = paramItemDisplay;
        this.verticalScale = paramInt;
    }
  
  public void run() {
    this.itemDisplay.setInterpolationDelay(0);
    this.itemDisplay.setInterpolationDuration(10);
    Transformation transformation = this.itemDisplay.getTransformation();
    transformation.getScale().set(0.0F, this.verticalScale, 0.0F);
    this.itemDisplay.setTransformation(transformation);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f3.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */