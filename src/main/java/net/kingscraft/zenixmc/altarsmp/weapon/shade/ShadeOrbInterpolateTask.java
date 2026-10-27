package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import java.util.List;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadeOrbInterpolateTask extends BukkitRunnable {
  public final List<ItemDisplay> orbs;

  public ShadeOrbInterpolateTask(List<ItemDisplay> paramList) {
        this.orbs = paramList;
    }

  public void run() {
    for (ItemDisplay itemDisplay : this.orbs) {
      itemDisplay.setInterpolationDelay(0);
      itemDisplay.setInterpolationDuration(10);
    } 
    (new ShadeOrbShrinkTask(this)).runTaskLater(AltarSMP.getInstance(), 2L);
    (new ShadeOrbCleanupTask(this)).runTaskLater(AltarSMP.getInstance(), 10L);
  }
}
