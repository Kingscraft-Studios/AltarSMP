package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import org.bukkit.Bukkit;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class EarthShatterRisingBlockAnimationTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public EarthShatterRisingBlockAnimationTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }

  public void run() {
    double d = 0.5D;
    this.itemDisplay.teleport(this.itemDisplay.getLocation().add(0.0D, d, 0.0D));
    this.itemDisplay.setTeleportDuration(10);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
        this.itemDisplay.teleport(this.itemDisplay.getLocation().subtract(0.0D, d, 0.0D));
        (new EarthShatterRisingBlockRemovalTask(this.itemDisplay)).runTaskLater(AltarSMP.getInstance(), 10L);
      }, 10L);
  }
}
