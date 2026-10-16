package pl;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class VulcanMagmaProjectileTask extends BukkitRunnable {
  int ticksLived;
  
  final int maxDistance = Main.getInstance().getConfig().getInt(SKIP, 500);

  final Vector initialVelocity;
  Vector velocity;
  final double gravity = 0.025D;
  final ItemDisplay magmaDisplay;
  final Player player;
  final VulcanGauntletAbility ability;
  private static final String SKIP = "vulcanMaxDistance";
  
  VulcanMagmaProjectileTask(VulcanGauntletAbility vulcanGauntletAbility, Vector paramVector, ItemDisplay paramItemDisplay, Player paramPlayer) {
        this.ability = vulcanGauntletAbility;
        this.initialVelocity = paramVector;
        this.magmaDisplay = paramItemDisplay;
        this.player = paramPlayer;
        this.ticksLived = 0;
        this.velocity = this.initialVelocity.clone();
    }
  
  public void run() {
    try {
      if (!this.magmaDisplay.isDead())
        try {
          if (this.ticksLived++ < this.maxDistance) {
            this.magmaDisplay.setTeleportDuration(3);
            Location location = this.magmaDisplay.getLocation();
            this.velocity.setY(this.velocity.getY() - 0.025D);
            location.add(this.velocity);
            this.magmaDisplay.teleport(location);
            location.getWorld().spawnParticle(Particle.FLAME, location, 3, 0.1D, 0.1D, 0.1D, 0.01D);
            Vector vector = this.velocity.clone().normalize();
            try {
              location.setDirection(vector);
              if (WorldGuardHook.isBlocked(location)) {
                this.magmaDisplay.remove();
                cancel();
                return;
              } 
            } catch (MatchException matchException) {

            } 
            for (Entity entity : this.magmaDisplay.getNearbyEntities(1.0D, 1.0D, 1.0D)) {
              try {
                if (entity instanceof org.bukkit.entity.LivingEntity)
                  try {
                    if (entity != this.player) {
                      this.ability.createVulcanExplosion(this.magmaDisplay.getLocation(), this.player);
                      this.magmaDisplay.remove();
                      cancel();
                      return;
                    } 
                  } catch (MatchException matchException) {

                  }  
              } catch (MatchException matchException) {

              } 
            } 
            try {
              if (!location.getBlock().getType().isAir()) {
                this.ability.createVulcanExplosion(location, this.player);
                this.magmaDisplay.remove();
                cancel();
              } 
            } catch (MatchException matchException) {

            } 
            return;
          } 
          this.magmaDisplay.getLocation().createExplosion(2.0F);
          this.magmaDisplay.remove();
          cancel();
          return;
        } catch (MatchException matchException) {

        }  
    } catch (MatchException matchException) {

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