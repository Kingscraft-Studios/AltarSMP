package net.kingscraft.zenixmc.altarsmp.weapon.crazy;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class CrazyRandomizerDisplayRemovalTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public CrazyRandomizerDisplayRemovalTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }

  public void run() {
    this.itemDisplay.remove();
  }
}
