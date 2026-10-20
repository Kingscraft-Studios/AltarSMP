package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import java.util.List;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadeOrbInterpolateTask extends BukkitRunnable {
  public final List orbs;

  public ShadeOrbInterpolateTask(List paramList) {
        this.orbs = paramList;
    }

  public void run() {
    for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.orbs) {
      itemDisplay.setInterpolationDelay(0);
      itemDisplay.setInterpolationDuration(10);
    } 
    (new ShadeOrbShrinkTask(this)).runTaskLater((Plugin)AltarSMP.getInstance(), 2L);
    (new ShadeOrbCleanupTask(this)).runTaskLater((Plugin)AltarSMP.getInstance(), 10L);
  }
}
