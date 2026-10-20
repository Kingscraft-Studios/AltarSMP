package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class ShadeOrbCleanupTask extends BukkitRunnable {
  public final ShadeOrbInterpolateTask parent;

  public ShadeOrbCleanupTask(ShadeOrbInterpolateTask parent) {
        this.parent = parent;
    }

  public void run() {
    for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.parent.orbs)
      itemDisplay.remove(); 
    this.parent.orbs.clear();
  }
}
