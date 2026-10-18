package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import java.util.List;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Item;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BoneBladeParticleTrailTask extends BukkitRunnable {
  public final List boneItems;
  
  public BoneBladeParticleTrailTask(List paramList) {
        this.boneItems = paramList;
    }
  
  public void run() {
    for (Item item : (Iterable<Item>)(Iterable<?>)this.boneItems)
      item.getLocation().getWorld().spawnParticle(Particle.DUST, item.getLocation(), 0, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.fromRGB(204, 176, 143), 1.0F)); 
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c4.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */