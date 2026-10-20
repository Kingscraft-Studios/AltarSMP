package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadeOrbShrinkTask extends BukkitRunnable {
  public final ShadeOrbInterpolateTask parent;

  public ShadeOrbShrinkTask(ShadeOrbInterpolateTask parent) {
        this.parent = parent;
    }

  public void run() {
    for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.parent.orbs) {
      Transformation transformation = itemDisplay.getTransformation();
      transformation.getScale().set(0.0F, 0.0F, 0.0F);
      itemDisplay.setTransformation(transformation);
    } 
  }
}
