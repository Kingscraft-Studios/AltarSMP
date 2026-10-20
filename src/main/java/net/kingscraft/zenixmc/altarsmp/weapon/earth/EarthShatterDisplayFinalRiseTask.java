package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

public class EarthShatterDisplayFinalRiseTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public final int riseHeight;

  public EarthShatterDisplayFinalRiseTask(ItemDisplay paramItemDisplay, int paramInt) {
        this.itemDisplay = paramItemDisplay;
        this.riseHeight = paramInt;
    }

  public void run() {
    this.itemDisplay.teleport(this.itemDisplay.getLocation().add(0.0D, this.riseHeight, 0.0D));
  }
}
