package net.kingscraft.zenixmc.altarsmp.weapon.shadow;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadowLeapTask extends BukkitRunnable {
  public double distanceTravelled;

  public Location currentLocation;

  final double leapSpeed = AltarSMP.getInstance().getConfig().getDouble("ShadowBladeLeapSpeed", 2.0D);

  public final Location startLocation;

  public final Player player;


  public ShadowLeapTask(Location paramLocation, Player paramPlayer) {
        this.startLocation = paramLocation;
        this.player = paramPlayer;
        this.distanceTravelled = 0.0;
        this.currentLocation = this.startLocation.clone();
    }

  public void run() {
    {
      if (!ShadowBladeAbility.leapLocations.containsKey(this.player.getUniqueId())) {
        cancel();
        return;
      } 
    }{
      if (this.distanceTravelled >= AltarSMP.getInstance().getConfig().getDouble("ShadowBladeLeapDistance", 30.0D)) {
        ShadowBladeAbility.spawnShadowParticles(this.player, ShadowBladeAbility.leapLocations.get(this.player.getUniqueId()));
        ShadowBladeAbility.leapLocations.remove(this.player.getUniqueId());
        ShadowBladeAbility.leapTasks.remove(this.player.getUniqueId());
        cancel();
        return;
      } 
    }Vector vector = this.player.getEyeLocation().getDirection().normalize();
    Location location = this.currentLocation.clone().add(vector.clone().multiply(this.leapSpeed));
    Block block = location.getBlock();
    {
      if (AltarSMP.getInstance().getConfig().getBoolean("shadowLeapStopWhenTouchingBlocks", false) && block.getType().isSolid()) {
        Location location1 = this.currentLocation.clone();
        Vector vector1 = vector.clone().multiply(0.1D);
        double d = 0.1D;
        while (d < this.leapSpeed) {
          Location location2 = this.currentLocation.clone().add(vector1.clone().multiply(d / 0.1D));
          if (!location2.getBlock().getType().isSolid()) {
            location1 = location2;
            d += 0.1D;
          } 
        } 
        ShadowBladeAbility.spawnShadowParticles(this.player, location1);
        ShadowBladeAbility.leapLocations.remove(this.player.getUniqueId());
        ShadowBladeAbility.leapTasks.remove(this.player.getUniqueId());
        cancel();
        return;
      } 
    }this.currentLocation = location;
    this.distanceTravelled += this.leapSpeed;
    ShadowBladeAbility.leapLocations.put(this.player.getUniqueId(), this.currentLocation.clone());
    this.currentLocation.getWorld().spawnParticle(Particle.SQUID_INK, this.currentLocation, 3, 0.1D, 0.1D, 0.1D, 0.01D);
    this.currentLocation.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, this.currentLocation, 2, 0.05D, 0.05D, 0.05D, 0.02D);
  }



}
