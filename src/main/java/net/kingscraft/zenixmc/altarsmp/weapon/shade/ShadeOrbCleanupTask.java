package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class ShadeOrbCleanupTask extends BukkitRunnable {
  public final ShadeOrbInterpolateTask parent;

  public ShadeOrbCleanupTask(ShadeOrbInterpolateTask parent) {
        this.parent = parent;
    }

  public void run() {
    for (ItemDisplay itemDisplay : this.parent.orbs)
      itemDisplay.remove(); 
    this.parent.orbs.clear();
  }
}
