package net.kingscraft.zenixmc.altarsmp.weapon.wind;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

public class CycloneSlashSpinTask extends BukkitRunnable {
  double scale;

  public int ticks;

  public final ItemDisplay display;

  public CycloneSlashSpinTask(ItemDisplay paramItemDisplay) {
        this.display = paramItemDisplay;
        this.scale = 7.5;
        this.ticks = 0;
    }

  public void run() {
    if (this.display.isDead()) {
      cancel();
      return;
    }

    this.display.setInterpolationDelay(0);
    this.display.setInterpolationDuration(2);
    Transformation transformation = this.display.getTransformation();
    transformation.getLeftRotation().rotateY(45.0F);
    if (this.ticks >= 10)
      if (this.ticks <= 30) {
        transformation.getTranslation().sub(0.0F, 0.04F, 0.0F);
        transformation.getScale().set(this.scale, 1.0D, this.scale);
      }

    this.display.setTransformation(transformation);
    this.scale -= 0.1D;
    this.ticks++;
  }
}
