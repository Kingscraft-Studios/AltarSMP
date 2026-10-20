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
