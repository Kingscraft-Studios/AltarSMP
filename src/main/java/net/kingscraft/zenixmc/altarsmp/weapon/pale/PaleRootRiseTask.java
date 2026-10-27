package net.kingscraft.zenixmc.altarsmp.weapon.pale;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

class PaleRootRiseTask extends BukkitRunnable {
  public final ItemDisplay rootDisplay;

  public PaleRootRiseTask(ItemDisplay paramItemDisplay) {
        this.rootDisplay = paramItemDisplay;
    }

  public void run() {
    Transformation transformation = this.rootDisplay.getTransformation();
    transformation.getTranslation().set(0.0D, 1.5D, 0.0D);
    transformation.getLeftRotation().rotateX((float)Math.toRadians(180.0D));
    this.rootDisplay.setTransformation(transformation);
  }
}
