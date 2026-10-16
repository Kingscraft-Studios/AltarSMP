package pl;

import org.bukkit.Bukkit;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

class EarthShatterRisingBlockAnimationTask extends BukkitRunnable {
  final ItemDisplay itemDisplay;
  
  EarthShatterRisingBlockAnimationTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }
  
  public void run() {
    double d = 0.5D;
    this.itemDisplay.teleport(this.itemDisplay.getLocation().add(0.0D, d, 0.0D));
    this.itemDisplay.setTeleportDuration(10);
    Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
        this.itemDisplay.teleport(this.itemDisplay.getLocation().subtract(0.0D, d, 0.0D));
        (new EarthShatterRisingBlockRemovalTask(this, this.itemDisplay)).runTaskLater(Main.getInstance(), 10L);
      }, 10L);
  }
}
