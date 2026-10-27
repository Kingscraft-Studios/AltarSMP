package net.kingscraft.zenixmc.altarsmp.weapon.echo;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

class EchoSonicProjectileTask extends BukkitRunnable {
  public int ticks;

  final int MAX_TICKS = AltarSMP.getInstance().getConfig().getInt("echoSonicThrowMax", 30);

  public Vector velocity;

  final double GRAVITY = AltarSMP.getInstance().getConfig().getDouble("echoSonicGravity", 0.0D);

  public final Vector initialVelocity;

  public final ItemDisplay projectileDisplay;

  public final Player player;

  public final int damage;


  public EchoSonicProjectileTask(Vector paramVector, ItemDisplay paramItemDisplay, Player paramPlayer, int paramInt) {
        this.initialVelocity = paramVector;
        this.projectileDisplay = paramItemDisplay;
        this.player = paramPlayer;
        this.damage = paramInt;
        this.ticks = 0;
        this.velocity = this.initialVelocity.clone();
    }

  public void run() {
    {
      if (!this.projectileDisplay.isDead())
        {
          if (this.ticks++ < this.MAX_TICKS) {
            this.projectileDisplay.setTeleportDuration(2);
            this.projectileDisplay.setInterpolationDelay(0);
            this.projectileDisplay.setInterpolationDuration(2);
            Location location = this.projectileDisplay.getLocation();
            this.velocity.setY(this.velocity.getY() - this.GRAVITY);
            location.add(this.velocity);
            this.projectileDisplay.teleport(location);
            Transformation transformation = this.projectileDisplay.getTransformation();
            transformation.getLeftRotation().rotateY((float)Math.toRadians(30.0D));
            this.projectileDisplay.setTransformation(transformation);
            location.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, location, 8, 0.0D, 0.0D, 0.0D, 0.2D);
            location.getWorld().spawnParticle(Particle.SONIC_BOOM, location, 0);
            Vector vector = this.velocity.clone().normalize();
            location.setDirection(vector);
            for (Entity entity : this.projectileDisplay.getNearbyEntities(2.0D, 2.0D, 2.0D)) {
              {
                if (entity instanceof LivingEntity livingEntity) {
                  if (entity instanceof Player player1) {
                      {
                      if (player1 == this.player)
                        continue; 
                    }{
                      if (AltarSMP.isTrusted(this.player, player1))
                        continue; 
                    }} 
                  {
                    if (CooldownManager.isOnCooldown(entity.getUniqueId(), "sonic"))
                      continue; 
                  }
                  CooldownManager.setCooldown(entity.getUniqueId(), "sonic", 1.0D);
                    TrueDamage.apply(livingEntity, this.damage, this.player);
                  return;
                } 
              }} 
            {
              if (location.getBlock().getType().isSolid())
                location.getWorld().createExplosion(location, 5.0F, false, true); 
            }return;
          } 
          this.projectileDisplay.remove();
          cancel();
          return;
        }}this.projectileDisplay.remove();
    cancel();
  }


}
