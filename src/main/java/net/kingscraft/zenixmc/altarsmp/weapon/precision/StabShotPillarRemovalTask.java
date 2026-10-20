package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class StabShotPillarRemovalTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public StabShotPillarRemovalTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }

  public void run() {
    this.itemDisplay.remove();
  }
}
