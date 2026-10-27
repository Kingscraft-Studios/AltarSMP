package net.kingscraft.zenixmc.altarsmp.weapon.gauntlet;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

public class EarthShatterDisplayTeleportSlowTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public EarthShatterDisplayTeleportSlowTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }

  public void run() {
    this.itemDisplay.setTeleportDuration(7);
  }
}
