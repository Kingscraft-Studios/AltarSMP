package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

class BloodHookProjectileTask extends BukkitRunnable {
  public double travelDistance;

  public Location currentLocation;

  public boolean hasHitTarget;

  public final Location startLocation;

  public final double maxDistance;

  public final Player player;

  public final ItemDisplay projectileDisplay;

  public final Vector direction;

  public final double gravity;

  public final World world;

  public final double damage;

  public BloodHookProjectileTask(Location paramLocation, double paramDouble1, Player paramPlayer, ItemDisplay paramItemDisplay, Vector paramVector, double paramDouble2, World paramWorld, double paramDouble3) {
        this.startLocation = paramLocation;
        this.maxDistance = paramDouble1;
        this.player = paramPlayer;
        this.projectileDisplay = paramItemDisplay;
        this.direction = paramVector;
        this.gravity = paramDouble2;
        this.world = paramWorld;
        this.damage = paramDouble3;
        this.travelDistance = 0.0;
        this.currentLocation = this.startLocation.clone();
        this.hasHitTarget = false;
    }

  public void run() {
    if (this.travelDistance >= this.maxDistance || this.hasHitTarget || !this.player.isOnline()) {
      this.projectileDisplay.remove();
      cancel();
      return;
    }
    this.direction.setY(this.direction.getY() - this.gravity);
    this.direction.normalize();
    this.currentLocation.add(this.direction.clone().multiply(2));
    this.travelDistance += 2.0D;
    this.projectileDisplay.setTeleportDuration(2);
    this.projectileDisplay.setInterpolationDelay(0);
    this.projectileDisplay.setInterpolationDuration(2);
    this.projectileDisplay.teleport(this.currentLocation);
    Transformation transformation = this.projectileDisplay.getTransformation();
    transformation.getLeftRotation().rotateX((float)Math.toRadians(20.0D));
    this.projectileDisplay.setTransformation(transformation);
    this.world.spawnParticle(Particle.ITEM, this.currentLocation, 5, 0.1D, 0.1D, 0.1D, 0.0D, new ItemStack(Material.REDSTONE_BLOCK));
    this.world.spawnParticle(Particle.DUST, this.currentLocation, 3, 0.1D, 0.1D, 0.1D, new Particle.DustOptions(Color.RED, 1.0F));
    for (Entity entity : this.world.getNearbyEntities(this.currentLocation, 1.0D, 1.0D, 1.0D)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        if (entity != this.player) {
          this.hasHitTarget = true;
          TrueDamage.apply(livingEntity, this.damage, this.player, true);
          BloodLustAbilityListener.infectEntity(livingEntity, this.player);
          this.world.spawnParticle(Particle.ITEM, livingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 400, 0.3D, 0.5D, 0.3D, 0.5D, new ItemStack(Material.REDSTONE_BLOCK));
          break;
        }
      }
    }
    if (this.currentLocation.getBlock().getType().isSolid() || WorldGuardHook.isBlocked(this.currentLocation)) {
      this.projectileDisplay.remove();
      cancel();
    }
  }

  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cz.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */