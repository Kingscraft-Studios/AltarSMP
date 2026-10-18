package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import java.util.List;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BoneCageAnimationTask extends BukkitRunnable {
  public int ticks;

  public final int durationTicks;

  public double rotationAngle;

  public final int durationSeconds;

  public final List cageDisplays;

  public final LivingEntity target;

  public BoneCageAnimationTask(int paramInt, List paramList, LivingEntity paramLivingEntity) {
    this.durationSeconds = paramInt;
    this.durationTicks = this.durationSeconds * 20;
    this.cageDisplays = paramList;
    this.target = paramLivingEntity;
    this.ticks = 0;
    this.rotationAngle = 0.0;
  }

  public void run() {
    this.ticks++;
    if (this.ticks >= this.durationTicks) {
      ((List<ItemDisplay>)(List<?>)this.cageDisplays).forEach(Entity::remove);
      BoneBladeAbility.boneCageDisplays.remove(this.target);
      cancel();
      return;
    } 

    Location location = this.target.getLocation().add(0.0D, 1.0D, 0.0D);
    double d1 = this.ticks / this.durationTicks;
    double d2 = 2.0D * (1.0D - d1);
    for (int b = 0; b < this.cageDisplays.size(); b++) {
      double d3 = this.rotationAngle + 6.283185307179586D * b / this.cageDisplays.size();
      double d4 = Math.cos(d3) * d2;
      double d5 = Math.sin(d3) * d2;
      ItemDisplay itemDisplay = (ItemDisplay)this.cageDisplays.get(b);
      Location location1 = location.clone().add(d4, 0.0D, d5);
      itemDisplay.setTeleportDuration(3);
      itemDisplay.setInterpolationDelay(0);
      itemDisplay.setInterpolationDuration(3);
      Transformation transformation = itemDisplay.getTransformation();
      transformation.getLeftRotation().rotateY((float)Math.toRadians(5.0D));
      transformation.getLeftRotation().rotateX((float)Math.toRadians(5.0D));
      itemDisplay.setTransformation(transformation);
      itemDisplay.teleport(location1);
      location1.getWorld().spawnParticle(Particle.DUST, location1, 0, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.fromRGB(220, 184, 138), 1.0F));
    } 
    this.rotationAngle += 0.1D;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c8.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */