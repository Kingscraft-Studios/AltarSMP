package net.kingscraft.zenixmc.altarsmp.weapon.gauntlet;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

public class EarthShatterDisplayDescendTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public final int descentHeight;

  public EarthShatterDisplayDescendTask(ItemDisplay paramItemDisplay, int paramInt) {
        this.itemDisplay = paramItemDisplay;
        this.descentHeight = paramInt;
    }

  public void run() {
    this.itemDisplay.teleport(this.itemDisplay.getLocation().subtract(0.0D, this.descentHeight, 0.0D));
  }
}
