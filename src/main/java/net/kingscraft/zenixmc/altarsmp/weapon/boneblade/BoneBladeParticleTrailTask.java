package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import java.util.List;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Item;
import org.bukkit.scheduler.BukkitRunnable;

class BoneBladeParticleTrailTask extends BukkitRunnable {
  public final List<Item> boneItems;

  public BoneBladeParticleTrailTask(List<Item> paramList) {
        this.boneItems = paramList;
    }

  public void run() {
    for (Item item : this.boneItems)
      item.getLocation().getWorld().spawnParticle(Particle.DUST, item.getLocation(), 0, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.fromRGB(204, 176, 143), 1.0F)); 
  }
}
