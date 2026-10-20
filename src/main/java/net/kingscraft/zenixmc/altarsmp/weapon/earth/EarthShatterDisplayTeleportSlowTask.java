package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

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
