package net.kingscraft.zenixmc.altarsmp.util;

import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

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
