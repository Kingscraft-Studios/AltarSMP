package net.kingscraft.zenixmc.altarsmp.weapon.pale;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class PaleCannonProjectileTask extends BukkitRunnable {
  public int ticks;

  final int MAX_DISTANCE = AltarSMP.getInstance().getConfig().getInt("paleMaxDistance", 500);

  public Vector velocity;

  final double GRAVITY = AltarSMP.getInstance().getConfig().getDouble("paleGravity", 0.0025D);

  public final Vector initialVelocity;

  public final ItemDisplay projectileDisplay;

  public final Player player;


  public PaleCannonProjectileTask(PaleCannonAbility paleCannonAbility, Vector paramVector, ItemDisplay paramItemDisplay, Player paramPlayer) {
        this.initialVelocity = paramVector;
        this.projectileDisplay = paramItemDisplay;
        this.player = paramPlayer;
        this.ticks = 0;
        this.velocity = this.initialVelocity.clone();
    }

  public void run() {
    {
      if (!this.projectileDisplay.isDead())
        {
          if (this.ticks++ < this.MAX_DISTANCE) {
            this.projectileDisplay.setTeleportDuration(3);
            Location location = this.projectileDisplay.getLocation();
            this.velocity.setY(this.velocity.getY() - this.GRAVITY);
            location.add(this.velocity);
            this.projectileDisplay.teleport(location);
            location.getWorld().spawnParticle(Particle.BLOCK_CRUMBLE, location, 3, 0.1D, 0.1D, 0.1D, 0.01D, Material.RESIN_BLOCK.createBlockData());
            Vector vector = this.velocity.clone().normalize();
            location.setDirection(vector);
            for (Entity entity : this.projectileDisplay.getNearbyEntities(1.0D, 1.0D, 1.0D)) {
              {
                if (entity instanceof org.bukkit.entity.LivingEntity)
                  {
                    if (entity != this.player) {
                      PaleCannonAbility.detonatePaleCannon(this.projectileDisplay.getLocation(), this.player);
                      this.projectileDisplay.remove();
                      cancel();
                      return;
                    } 
                  }}} 
            {
              if (!location.getBlock().getType().isAir()) {
                PaleCannonAbility.detonatePaleCannon(location, this.player);
                this.projectileDisplay.remove();
                cancel();
              } 
            }return;
          } 
          this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 1.5F);
          this.projectileDisplay.remove();
          cancel();
          return;
        }}this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 1.5F);
    this.projectileDisplay.remove();
    cancel();
  }



}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d5.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */