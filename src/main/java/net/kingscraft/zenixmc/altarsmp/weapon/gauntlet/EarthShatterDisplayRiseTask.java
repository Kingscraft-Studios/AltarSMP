package net.kingscraft.zenixmc.altarsmp.weapon.gauntlet;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

public class EarthShatterDisplayRiseTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public final int radius;

  public EarthShatterDisplayRiseTask(ItemDisplay paramItemDisplay, int paramInt) {
        this.itemDisplay = paramItemDisplay;
        this.radius = paramInt;
    }

  public void run() {
    this.itemDisplay.teleport(this.itemDisplay.getLocation().add(0.0D, ((double) this.radius / 2), 0.0D));
    this.itemDisplay.setRotation(0.0F, 0.0F);
  }
}
