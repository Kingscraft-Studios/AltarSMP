package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class OrbitalStrikeProjectileTask extends BukkitRunnable {
  public Location currentLocation;

  public final Location targetLocation;

  public final int groundLevel;

  public final World world;

  public final Player player;

  public final int explosionPower;

  public OrbitalStrikeProjectileTask(Location paramLocation, int paramInt1, World paramWorld, Player paramPlayer, int paramInt2) {
        this.targetLocation = paramLocation;
        this.groundLevel = paramInt1;
        this.world = paramWorld;
        this.player = paramPlayer;
        this.explosionPower = paramInt2;
        this.currentLocation = this.targetLocation.clone();
    }

  public void run() {
    this.currentLocation.subtract(0.0D, 1.0D, 0.0D);
    if (this.currentLocation.getY() <= (this.groundLevel + 1)) {
      this.world.spawnParticle(Particle.ELECTRIC_SPARK, this.currentLocation, 5, 0.05D, 0.2D, 0.05D, 0.01D);
      for (Player player : this.currentLocation.getWorld().getPlayers()) {
        if (AltarSMP.isTrusted(this.player, (Entity)player) || player == this.player)
          this.player.setInvulnerable(true);
      } 
      this.world.createExplosion(this.currentLocation.getX(), this.currentLocation.getY(), this.currentLocation.getZ(), this.explosionPower, false, true);
      for (Player player : this.currentLocation.getWorld().getPlayers()) {
        if (AltarSMP.isTrusted(this.player, (Entity)player) || player == this.player)
          this.player.setInvulnerable(false);
      } 
      for (Entity entity : this.world.getNearbyEntities(this.currentLocation, 3.0D, 3.0D, 3.0D)) {
        if (entity instanceof Player) {
          Player player = (Player)entity;
          player.setVelocity(new Vector(0.0D, 0.5D, 0.0D));
        } 
      } 
      cancel();
      return;
    } 
    if (this.currentLocation.getY() % 5.0D == 0.0D)
      this.world.playSound(this.currentLocation, Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1.0F, 1.0F);

    this.world.spawnParticle(Particle.ELECTRIC_SPARK, this.currentLocation, 6, 0.0D, 0.2D, 0.0D, 0.0D);
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f2.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */