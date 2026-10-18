package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.weapon.meteor.MeteorStrikeCleanupTask;
import net.kingscraft.zenixmc.altarsmp.weapon.vulcan.VulcanGauntletAbility;

public class MudslideProjectileAnimationTask extends BukkitRunnable {
  public double ticksLived;

  public Location currentLocation;

  public boolean hasHitTarget;

  public final Location startLocation;

  public final double maxDistance;

  public final ItemDisplay mudDisplay;

  public final Vector direction;

  public final double gravity;

  public final World world;

  public final double damage;

  public final int muddyDurationTicks;

  public final MudslideProjectileTask projectileTask;

  private static final String TARGET_HIT_BOSSBAR_TITLE = "!! Pull Target !!";

  public MudslideProjectileAnimationTask(MudslideProjectileTask mudslideProjectileTask, Location paramLocation, double paramDouble1, ItemDisplay paramItemDisplay, Vector paramVector, double paramDouble2, World paramWorld, double paramDouble3, int paramInt) {
        this.projectileTask = mudslideProjectileTask;
        this.startLocation = paramLocation;
        this.maxDistance = paramDouble1;
        this.mudDisplay = paramItemDisplay;
        this.direction = paramVector;
        this.gravity = paramDouble2;
        this.world = paramWorld;
        this.damage = paramDouble3;
        this.muddyDurationTicks = paramInt;
        this.ticksLived = 0.0;
        this.currentLocation = this.startLocation.clone();
        this.hasHitTarget = false;
    }

  public void run() {
    if (this.ticksLived < this.maxDistance)
      {
        if (!this.hasHitTarget)
          {
            if (this.projectileTask.player.isOnline()) {
              this.direction.setY(this.direction.getY() - this.gravity);
              this.direction.normalize();
              this.ticksLived += 2.0D;
              this.currentLocation.add(this.direction.clone().normalize().multiply(1));
              this.currentLocation = VulcanGauntletAbility.findSafeExplosionLocation(this.currentLocation, 10);
              Location location = this.currentLocation.clone().add(0.0D, 1.5D, 0.0D);
              this.mudDisplay.setTeleportDuration(3);
              this.mudDisplay.setInterpolationDelay(0);
              this.mudDisplay.setInterpolationDuration(3);
              this.mudDisplay.teleport(this.currentLocation);
              EarthGauntletAbility.makeMud(this.currentLocation);
              float f = (float)Math.toRadians(20.0D);
              Transformation transformation = this.mudDisplay.getTransformation();
              transformation.getLeftRotation().rotateX(f);
              this.mudDisplay.setTransformation(transformation);
              this.world.spawnParticle(Particle.BLOCK_CRUMBLE, location, 5, 0.1D, 0.1D, 0.1D, 0.0D, Material.MUD.createBlockData());
              this.world.spawnParticle(Particle.BLOCK_CRUMBLE, location, 12, 0.1D, 0.1D, 0.1D, Material.MUD.createBlockData());
              for (Entity entity : this.world.getNearbyEntities(location, 1.0D, 1.0D, 1.0D)) {
                if (entity instanceof LivingEntity && entity != this.projectileTask.player) {
                  LivingEntity livingEntity = (LivingEntity)entity;
                  this.hasHitTarget = true;
                  this.world.spawnParticle(Particle.ITEM, livingEntity.getLocation().add(0.0D, 1.0D, 0.0D), 500, 0.0D, 0.0D, 0.0D, 0.3D, new ItemStack(Material.MUD));
                  livingEntity.damage(this.damage, (Entity)this.projectileTask.player);
                  EarthGauntletAbility.meteorStrikeTargets.put(this.projectileTask.player.getUniqueId(), livingEntity);
                  BossBarManager.createBar(this.projectileTask.player, TARGET_HIT_BOSSBAR_TITLE, this.muddyDurationTicks / 20, ChatColor.GREEN);
                  livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, this.muddyDurationTicks, 2));
                  EarthGauntletAbility.jumpCancelledPlayers.add(livingEntity.getUniqueId());
                  this.projectileTask.player.getWorld().playSound(this.projectileTask.player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
                  this.projectileTask.player.getWorld().playSound(this.projectileTask.player.getLocation(), Sound.BLOCK_MUD_BREAK, 1.0F, 1.0F);
                  this.projectileTask.player.getWorld().playSound(this.projectileTask.player.getLocation(), Sound.BLOCK_PACKED_MUD_FALL, 1.0F, 1.0F);
                  this.projectileTask.player.getWorld().playSound(this.projectileTask.player.getLocation(), Sound.BLOCK_MUD_FALL, 1.0F, 1.0F);
                  (new MeteorStrikeCleanupTask(this, livingEntity)).runTaskLater((Plugin)AltarSMP.getInstance(), this.muddyDurationTicks);
                  break;
                } 

              } 
              if (WorldGuardHook.isBlocked(this.currentLocation)) {
                this.mudDisplay.remove();
                cancel();
              } 

              return;
            } 
            this.mudDisplay.remove();
            cancel();
            return;
          }  
      }  

    this.mudDisplay.remove();
    cancel();
  }


}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ea.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */