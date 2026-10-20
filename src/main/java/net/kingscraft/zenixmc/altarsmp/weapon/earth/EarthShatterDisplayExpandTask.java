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
