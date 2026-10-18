package net.kingscraft.zenixmc.altarsmp.weapon.witherbone;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class CleansingBlockEffectTask extends BukkitRunnable {
  public int ticksLived;

  final double knockbackStrength = 1.5D;

  public boolean hasReachedLanding;

  public final ItemDisplay outerBlockDisplay;

  public final ItemDisplay innerBlockDisplay;

  public final int cleansingDuration;

  public final int landingDelay;

  public final World world;

  public final Player player;

  public final Vector knockbackDirection;

  public CleansingBlockEffectTask(ItemDisplay paramItemDisplay1, ItemDisplay paramItemDisplay2, int paramInt1, int paramInt2, World paramWorld, Player paramPlayer, Vector paramVector) {
        this.outerBlockDisplay = paramItemDisplay1;
        this.innerBlockDisplay = paramItemDisplay2;
        this.cleansingDuration = paramInt1;
        this.landingDelay = paramInt2;
        this.world = paramWorld;
        this.player = paramPlayer;
        this.knockbackDirection = paramVector;
        this.ticksLived = 0;
        this.hasReachedLanding = false;
    }

  public void run() {
    if (!(this.outerBlockDisplay.isValid() && this.innerBlockDisplay.isValid() && this.ticksLived < this.cleansingDuration * 20)) {
      if (this.outerBlockDisplay.isValid() && this.innerBlockDisplay.isValid()) {
        this.outerBlockDisplay.setInterpolationDelay(0);
        this.outerBlockDisplay.setInterpolationDuration(20);
        Transformation transformation = this.outerBlockDisplay.getTransformation();
        transformation.getScale().set(0.0F, 0.0F, 0.0F);
        this.outerBlockDisplay.setTransformation(transformation);
        this.innerBlockDisplay.setInterpolationDelay(0);
        this.innerBlockDisplay.setInterpolationDuration(20);
        Transformation transformation1 = this.innerBlockDisplay.getTransformation();
        transformation1.getScale().set(0.0F, 0.0F, 0.0F);
        this.innerBlockDisplay.setTransformation(transformation1);
        new CleansingBlockCleanupTask(this).runTaskLater(AltarSMP.getInstance(), 21L);
      } 
      cancel();
      return;
    } 
    Location location = this.outerBlockDisplay.getLocation();
    if (!this.hasReachedLanding && this.ticksLived >= this.landingDelay + 2) {
      this.hasReachedLanding = true;
    } 
    if (this.ticksLived % 5 == 0) {
      for (Entity entity : this.world.getNearbyEntities(location, 1.5D, 1.5D, 1.5D)) {
        if (entity instanceof LivingEntity && entity != this.player && entity.getType() != EntityType.ARMOR_STAND) {
          LivingEntity livingEntity = (LivingEntity)entity;
          livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20, 4, false, true, true));
          if (!this.hasReachedLanding) {
            Vector vector = this.knockbackDirection.clone().normalize();
            if (livingEntity.getWorld() != location.getWorld())
              continue; 
            double d = livingEntity.getLocation().distance(location);
            double d1 = (1.0D - d / 1.5D) * 0.45D;
            vector.multiply(d1);
            vector.setY(1.0E-7D);
            livingEntity.setVelocity(livingEntity.getVelocity().add(vector));
          } 
        } 
      } 
      if (!this.hasReachedLanding && this.ticksLived % 3 == 0) {
        this.world.spawnParticle(Particle.SQUID_INK, location, 2, 0.15D, 0.06D, 0.15D, 0.01D);
      } 
    } 
    this.ticksLived++;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fm.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */