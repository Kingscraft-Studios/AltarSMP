package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import org.bukkit.Location;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class SlashStreakTask extends BukkitRunnable {
  public final Location origin;

  public final ItemDisplay display;

  public SlashStreakTask(Location paramLocation, ItemDisplay paramItemDisplay) {
        this.origin = paramLocation;
        this.display = paramItemDisplay;
    }

  public void run() {
    double d1 = 0;
    Location location1 = this.origin.clone().add(0.0D, 0.0D, 0.0D);
    if (Math.random() < 0.5D) {
      d1 = -1.0D + Math.random();
    } else {
      d1 = 1.0D + Math.random();
    } 
    Vector vector1 = location1.getDirection().normalize().multiply(d1);
    double d2 = (Math.random() - 0.5D) * 6.0D;
    double d3 = (Math.random() - 0.5D) * 6.0D;
    double d4 = (Math.random() - 0.5D) * 6.0D;
    Vector vector2 = new Vector(d2, d3, d4);
    Location location2 = location1.clone().add(vector1).add(vector2);
    this.display.teleport(location2);
  }
}
