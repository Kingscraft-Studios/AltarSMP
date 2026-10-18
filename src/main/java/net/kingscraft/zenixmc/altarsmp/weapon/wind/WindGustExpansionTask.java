package net.kingscraft.zenixmc.altarsmp.weapon.wind;

import java.util.HashSet;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class WindGustExpansionTask extends BukkitRunnable {
  public double radius;

  HashSet<UUID> affectedEntities = new HashSet<>();

  public final int durationTicks;

  public final Location center;

  public final Particle particle;

  public final Player player;

  public final int gustStrength;

  public WindGustExpansionTask(int paramInt1, Location paramLocation, Particle paramParticle, Player paramPlayer, int paramInt2) {
        this.durationTicks = paramInt1;
        this.center = paramLocation;
        this.particle = paramParticle;
        this.player = paramPlayer;
        this.gustStrength = paramInt2;
        this.radius = 0.0;
        this.affectedEntities = new HashSet();
    }

  public void run() {
    if (this.radius >= this.durationTicks) {
      cancel();
      return;
    } 

    for (double d = 0.0D; d < 6.283185307179586D; d += 0.09817477042468103D) {
      double d1 = this.radius * Math.cos(d);
      double d2 = this.radius * Math.sin(d);
      Location location = this.center.clone().add(d1, 0.0D, d2);
      this.center.getWorld().spawnParticle(this.particle, location, 1, 0.0D, 0.0D, 0.0D, 0.0D);
    } 
    for (Entity entity : this.center.getWorld().getNearbyEntities(this.center, this.radius + 1.0D, 3.0D, this.radius + 1.0D)) {
      if (entity instanceof LivingEntity)
        {
          if (entity != this.player && !this.affectedEntities.contains(entity.getUniqueId())) {
            LivingEntity livingEntity = (LivingEntity)entity;
            if (livingEntity.getWorld() != this.center.getWorld())
              continue; 

            double d1 = livingEntity.getLocation().distance(this.center);
            if (d1 <= this.radius + 0.5D && d1 >= this.radius - 0.5D) {
              Vector vector = livingEntity.getLocation().toVector().subtract(this.center.toVector()).normalize();
              vector.setY(0.5D);
              vector.multiply(1.5D + this.gustStrength * 0.2D);
              livingEntity.setVelocity(vector);
              livingEntity.damage(2.0D + this.gustStrength * 0.5D, (Entity)this.player);
              this.affectedEntities.add(entity.getUniqueId());
            } 

          } 
        }  

    } 
    this.radius += 0.5D;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fe.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */