package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

class FrostScytheProjectileTask extends BukkitRunnable {
  public int ticksElapsed;

  public Vector movementVector;

    public final Vector initialVelocity;

  public final ItemDisplay scytheDisplay;

  public final FrostScytheLaunchTask launchTask;

  private static final String FROST_DURATION_KEY = "frostDuration";

  public FrostScytheProjectileTask(FrostScytheLaunchTask frostScytheLaunchTask, Vector paramVector, ItemDisplay paramItemDisplay) {
        this.launchTask = frostScytheLaunchTask;
        this.initialVelocity = paramVector;
        this.scytheDisplay = paramItemDisplay;
        this.ticksElapsed = 0;
        this.movementVector = this.initialVelocity.clone();
    }

  public void run() {
    if (this.scytheDisplay.isDead() || this.ticksElapsed++ >= this.launchTask.maxThrowDistance) {
      this.scytheDisplay.getWorld().spawnParticle(Particle.ITEM, this.scytheDisplay.getLocation(), 200, 0.0D, 0.0D, 0.0D, 0.5D, new ItemStack(Material.BLUE_ICE));
      this.launchTask.player.getWorld().playSound(this.launchTask.player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0F, 0.7F);
      if (this.launchTask.returnScythe) {
        FrostScytheAbilityListener.animateScythe(this.launchTask.player, this.scytheDisplay, this.launchTask.maxThrowDistance);
      } else {
        this.scytheDisplay.remove();
      } 
      cancel();
      return;
    } 
    this.scytheDisplay.setTeleportDuration(2);
    this.scytheDisplay.setInterpolationDelay(0);
    this.scytheDisplay.setInterpolationDuration(2);
    Location location = this.scytheDisplay.getLocation();
    this.movementVector.setY(this.movementVector.getY() - 0.0D);
    Transformation transformation = this.scytheDisplay.getTransformation();
    transformation.getLeftRotation().rotateX((float)Math.toRadians(30.0D));
    this.scytheDisplay.setTransformation(transformation);
    if (this.ticksElapsed % 4 == 0)
      this.launchTask.player.getWorld().playSound(this.launchTask.player, Sound.ENTITY_WITCH_THROW, 1.0F, 1.0F);
    location.add(this.movementVector);
    this.scytheDisplay.teleport(location);
    location.getWorld().spawnParticle(Particle.SNOWFLAKE, location, 3, 0.1D, 0.1D, 0.1D, 0.01D);
    Vector vector = this.movementVector.clone().normalize();
    location.setDirection(vector);
    for (Entity entity : this.scytheDisplay.getNearbyEntities(1.0D, 1.0D, 1.0D)) {
      if (entity instanceof LivingEntity livingEntity) {
          if (entity != this.launchTask.player) {
          TrueDamage.apply(livingEntity, this.launchTask.damage, this.launchTask.player);
          int i = AltarSMP.getInstance().getConfig().getInt(FROST_DURATION_KEY, 10);
          livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, i, 1, false, true, true));
          new FrostScytheFreezeTask(i, livingEntity).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
          livingEntity.getWorld().playSound(livingEntity.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0F, 1.5F);
          livingEntity.getWorld().playSound(livingEntity.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1.0F, 1.0F);
          this.scytheDisplay.getWorld().spawnParticle(Particle.ITEM, this.scytheDisplay.getLocation(), 200, 0.0D, 0.0D, 0.0D, 0.5D, new ItemStack(Material.BLUE_ICE));
          this.launchTask.player.getWorld().playSound(this.launchTask.player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0F, 0.7F);
          if (this.launchTask.returnScythe) {
            FrostScytheAbilityListener.animateScythe(this.launchTask.player, this.scytheDisplay, this.launchTask.maxThrowDistance);
          } else {
            this.scytheDisplay.remove();
          } 
          cancel();
          return;
        } 
      } 
    } 
    if (location.getBlock().getType().isSolid()) {
      this.scytheDisplay.getWorld().spawnParticle(Particle.ITEM, this.scytheDisplay.getLocation(), 200, 0.0D, 0.0D, 0.0D, 0.5D, new ItemStack(Material.BLUE_ICE));
      this.launchTask.player.getWorld().playSound(this.launchTask.player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0F, 0.7F);
      if (this.launchTask.returnScythe) {
        FrostScytheAbilityListener.animateScythe(this.launchTask.player, this.scytheDisplay, this.launchTask.maxThrowDistance);
      } else {
        this.scytheDisplay.remove();
      } 
      cancel();
    } 
  }


}
