package net.kingscraft.zenixmc.altarsmp.weapon.vulcan;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;

class VulcanMagmaProjectileTask extends BukkitRunnable {
  public int ticksLived;

  final int maxDistance = AltarSMP.getInstance().getConfig().getInt(SKIP, 500);

  public final Vector initialVelocity;
  public Vector velocity;
  final double gravity = 0.025D;
  public final ItemDisplay magmaDisplay;
  public final Player player;
  public final VulcanGauntletAbility ability;
  private static final String SKIP = "vulcanMaxDistance";

  public VulcanMagmaProjectileTask(VulcanGauntletAbility vulcanGauntletAbility, Vector paramVector, ItemDisplay paramItemDisplay, Player paramPlayer) {
        this.ability = vulcanGauntletAbility;
        this.initialVelocity = paramVector;
        this.magmaDisplay = paramItemDisplay;
        this.player = paramPlayer;
        this.ticksLived = 0;
        this.velocity = this.initialVelocity.clone();
    }

  public void run() {
    if (!this.magmaDisplay.isDead())
      {
        if (this.ticksLived++ < this.maxDistance) {
          this.magmaDisplay.setTeleportDuration(3);
          Location location = this.magmaDisplay.getLocation();
          this.velocity.setY(this.velocity.getY() - 0.025D);
          location.add(this.velocity);
          this.magmaDisplay.teleport(location);
          location.getWorld().spawnParticle(Particle.FLAME, location, 3, 0.1D, 0.1D, 0.1D, 0.01D);
          Vector vector = this.velocity.clone().normalize();
          location.setDirection(vector);
          if (WorldGuardHook.isBlocked(location)) {
            this.magmaDisplay.remove();
            cancel();
            return;
          } 

          for (Entity entity : this.magmaDisplay.getNearbyEntities(1.0D, 1.0D, 1.0D)) {
            if (entity instanceof org.bukkit.entity.LivingEntity)
              {
                if (entity != this.player) {
                  this.ability.createVulcanExplosion(this.magmaDisplay.getLocation(), this.player);
                  this.magmaDisplay.remove();
                  cancel();
                  return;
                } 
              }  

          } 
          if (!location.getBlock().getType().isAir()) {
            this.ability.createVulcanExplosion(location, this.player);
            this.magmaDisplay.remove();
            cancel();
          } 

          return;
        } 
        this.magmaDisplay.getLocation().createExplosion(2.0F);
        this.magmaDisplay.remove();
        cancel();
        return;
      }  

    this.magmaDisplay.getLocation().createExplosion(2.0F);
    this.magmaDisplay.remove();
    cancel();
  }

}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dn.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */