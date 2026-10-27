package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class FrostScytheBladeProjectileTask extends BukkitRunnable {
  public int ticksElapsed;

  public final Location currentLocation;

  public final Location startLocation;

  public final ItemDisplay bladeDisplay;

  public final Vector direction;

  public final FrostScytheBladeLaunchTask launchTask;

  private static final String COMMAND_OF_ICE_DAMAGE_KEY = "commandOfIceDamage";

  public FrostScytheBladeProjectileTask(FrostScytheBladeLaunchTask frostScytheBladeLaunchTask, Location paramLocation, ItemDisplay paramItemDisplay, Vector paramVector) {
    this.launchTask = frostScytheBladeLaunchTask;
    this.startLocation = paramLocation;
    this.currentLocation = this.startLocation.clone();
    this.bladeDisplay = paramItemDisplay;
    this.direction = paramVector;
    this.ticksElapsed = 0;
  }

  public void run() {
    if (this.bladeDisplay.isDead() || !this.bladeDisplay.isValid()) {
      cancel();
      return;
    } 
    if (this.ticksElapsed >= 60 || this.currentLocation.getBlock().getType().isSolid()) {
      FrostScytheAbilityListener.createIceExplosion(this.currentLocation, this.launchTask.player);
      if (!this.bladeDisplay.isDead())
        this.bladeDisplay.remove();
      cancel();
      return;
    } 
    this.currentLocation.add(this.direction.clone().multiply(1.5D));
    if (this.bladeDisplay.isDead() || !this.bladeDisplay.isValid()) {
      cancel();
      return;
    } 
    this.bladeDisplay.setTeleportDuration(5);
    this.bladeDisplay.teleport(this.currentLocation);
    this.bladeDisplay.getWorld().spawnParticle(Particle.SNOWFLAKE, this.currentLocation, 5, 0.1D, 0.1D, 0.1D, 0.01D);
    this.bladeDisplay.getWorld().spawnParticle(Particle.CLOUD, this.currentLocation, 2, 0.1D, 0.1D, 0.1D, 0.01D);
    for (Entity entity : this.currentLocation.getWorld().getNearbyEntities(this.currentLocation, 0.7D, 0.7D, 0.7D)) {
      if (entity instanceof LivingEntity livingEntity && entity != this.launchTask.player) {
          double d = FrostScytheAbilityListener.plugin.getConfig().getDouble(COMMAND_OF_ICE_DAMAGE_KEY, 8.0D);
        livingEntity.damage(d, DamageSource.builder(DamageType.MAGIC).build());
        livingEntity.setNoDamageTicks(0);
        livingEntity.setFreezeTicks(100);
        FrostScytheAbilityListener.createIceExplosion(this.currentLocation, this.launchTask.player);
        if (!this.bladeDisplay.isDead())
          this.bladeDisplay.remove();
        cancel();
        return;
      } 
    } 
    this.ticksElapsed++;
  }


}
