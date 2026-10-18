package net.kingscraft.zenixmc.altarsmp.weapon.wind;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.armor.knightfall.KnightfallListener;
import net.kingscraft.zenixmc.altarsmp.core.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class HammerProjectileTask extends BukkitRunnable {
  public double distanceTravelled;
  
  public Location currentLocation;
  
  public boolean hit;
  
  public final Location origin;
  
  public final double maxDistance;
  
  public final Player thrower;
  
  public final ItemDisplay display;
  
  public final Vector direction;
  
  public final double speed;
  
  public final World world;
  
  public final boolean stunShield;
  
  public final int shieldStunTicks;
  
  public final double damage;
  
  public HammerProjectileTask(Location paramLocation, double paramDouble1, Player paramPlayer, ItemDisplay paramItemDisplay, Vector paramVector, double paramDouble2, World paramWorld, boolean paramBoolean, int paramInt, double paramDouble3) {
        this.origin = paramLocation;
        this.maxDistance = paramDouble1;
        this.thrower = paramPlayer;
        this.display = paramItemDisplay;
        this.direction = paramVector;
        this.speed = paramDouble2;
        this.world = paramWorld;
        this.stunShield = paramBoolean;
        this.shieldStunTicks = paramInt;
        this.damage = paramDouble3;
        this.distanceTravelled = 0.0;
        this.currentLocation = this.origin.clone();
        this.hit = false;
    }
  
  public void run() {
    if (this.distanceTravelled >= this.maxDistance || this.hit || !this.thrower.isOnline()) {
      this.display.remove();
      cancel();
      return;
    } 
    this.direction.normalize();
    this.currentLocation.add(this.direction.clone().multiply(this.speed));
    this.distanceTravelled += this.speed;
    this.display.setTeleportDuration(2);
    this.display.teleport(this.currentLocation);
    this.display.setInterpolationDelay(0);
    this.display.setInterpolationDuration(2);
    Transformation transformation = this.display.getTransformation();
    transformation.getScale().set(1.0F, 1.0F, 1.0F);
    transformation.getLeftRotation().rotateZ((float)Math.toRadians(this.speed * 20.0D));
    this.display.setTransformation(transformation);
    this.world.spawnParticle(Particle.DUST, this.currentLocation, 3, 0.1D, 0.1D, 0.1D, new Particle.DustOptions(Color.BLACK, 1.0F));
    this.world.spawnParticle(Particle.ELECTRIC_SPARK, this.currentLocation, 3, 0.1D, 0.1D, 0.1D, 0.0D);
    for (Entity entity : this.world.getNearbyEntities(this.currentLocation, 1.0D, 1.0D, 1.0D)) {
      if (entity instanceof LivingEntity && entity != this.thrower) {
        LivingEntity livingEntity = (LivingEntity)entity;
        if (livingEntity instanceof Player) {
          Player player = (Player)livingEntity;
          if (AltarSMP.isTrusted(this.thrower, player))
            continue; 
          if (this.stunShield) {
            player.setCooldown(Material.SHIELD, this.shieldStunTicks);
            player.clearActiveItem();
            player.updateInventory();
          } 
        } 
        this.hit = true;
        TrueDamage.apply(livingEntity, this.damage, this.thrower);
        this.world.spawnParticle(Particle.DUST, this.currentLocation, 100, 0.5D, 0.5D, 0.5D, new Particle.DustOptions(Color.BLACK, 1.0F));
        this.world.spawnParticle(Particle.ELECTRIC_SPARK, this.currentLocation, 100, 1.0D, 1.0D, 1.0D, 0.0D);
        this.world.spawnParticle(Particle.END_ROD, this.currentLocation, 10, 0.5D, 0.5D, 0.5D, 0.0D);
        KnightfallListener.chainEntity(livingEntity, this.thrower);
        break;
      } 
    } 
    if (this.currentLocation.getBlock().getType().isSolid() || WorldGuardHook.isBlocked(this.currentLocation)) {
      cancel();
      this.display.remove();
    } 
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fv.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */