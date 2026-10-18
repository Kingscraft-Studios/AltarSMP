package net.kingscraft.zenixmc.altarsmp.task;

import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class FloatingTextShrinkTask extends BukkitRunnable {
  public final TextDisplay textDisplay;
  
  public final int interpolationDuration;
  
  public FloatingTextShrinkTask(TextDisplay paramTextDisplay, int paramInt) {
        this.textDisplay = paramTextDisplay;
        this.interpolationDuration = paramInt;
    }
  
  public void run() {
    this.textDisplay.setInterpolationDelay(0);
    this.textDisplay.setInterpolationDuration(this.interpolationDuration);
    Transformation transformation = this.textDisplay.getTransformation();
    transformation.getScale().set(0.0F, 0.0F, 0.0F);
    this.textDisplay.setTransformation(transformation);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hk.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */