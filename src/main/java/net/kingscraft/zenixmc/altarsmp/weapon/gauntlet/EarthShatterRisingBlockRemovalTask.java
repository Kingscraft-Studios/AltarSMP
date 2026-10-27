package net.kingscraft.zenixmc.altarsmp.weapon.gauntlet;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class EarthShatterRisingBlockRemovalTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public EarthShatterRisingBlockRemovalTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }

  public void run() {
    this.itemDisplay.remove();
  }
}
