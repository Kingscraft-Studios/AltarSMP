package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadeOrbRecoilTask extends BukkitRunnable {
  public final ShadeOrbTeleportTask parent;

  public ShadeOrbRecoilTask(ShadeOrbTeleportTask parent) {
        this.parent = parent;
    }

  public void run() {
    for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.parent.orbs) {
      double d = (Math.random() - 0.5D) * 4.0D;
      Vector vector = this.parent.player.getLocation().getDirection().normalize().multiply(-3);
      itemDisplay.teleport(itemDisplay.getLocation().add(vector).add(0.0D, d, 0.0D));
    } 
  }
}
