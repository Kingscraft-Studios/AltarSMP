package net.kingscraft.zenixmc.altarsmp.weapon.shadow;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadowDaggerPullTask extends BukkitRunnable {
  public int ticksLived;

  final int MAX_TICKS = 10;

  public final Entity target;

  public final Player player;

  public ShadowDaggerPullTask(Entity paramEntity, Player paramPlayer) {
        this.target = paramEntity;
        this.player = paramPlayer;
        this.ticksLived = 0;
    }

  public void run() {
    if (this.ticksLived < 10)
      {
        if (this.target.isValid())
          {
            if (this.player.isOnline()) {
              if (this.player.getWorld() != this.target.getWorld())
                return; 

              if (this.player.getLocation().distance(this.target.getLocation()) <= 2.0D) {
                this.target.setVelocity(new Vector(0, 0, 0));
                cancel();
                return;
              } 

              Location location1 = this.target.getLocation().clone().add(0.0D, 1.0D, 0.0D);
              Location location2 = this.player.getLocation().clone().add(0.0D, 1.0D, 0.0D);
              Vector vector1 = location2.toVector().subtract(location1.toVector());
              double d = vector1.length();
              Vector vector2 = vector1.normalize().multiply(1);
              if (this.ticksLived % 2 == 0) {
                double d1 = 0;
                for (d1 = 0.0D; d1 < d; d1++) {
                  Location location = location1.clone().add(vector2.clone().multiply(d1));
                  location1.getWorld().spawnParticle(Particle.ITEM, location, 0, 0.0D, 0.0D, 0.0D, 0.0D, new ItemStack(Material.BLACK_CONCRETE));
                  location1.getWorld().spawnParticle(Particle.CRIT, location, 0, 0.0D, 0.0D, 0.0D, 0.0D);
                } 
              } 
              Vector vector3 = this.player.getLocation().toVector().subtract(this.target.getLocation().toVector()).normalize();
              this.target.setVelocity(vector3.multiply(1.5D));
              this.ticksLived++;
              return;
            } 
            cancel();
            return;
          }  
      }  

    cancel();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fc.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */