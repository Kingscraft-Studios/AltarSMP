package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class StabShotChargeTask extends BukkitRunnable {
  public int remainingTicks;

  public double currentRadius;

  public final Location location;

  public final Player player;

  public final int radius;

  public final ItemDisplay itemDisplay;

  public final World world;

  public final int verticalRadius;

  private static final String WARNING_MESSAGE = "§c§lWARNING: §eSTAB SHOT IMMINENT";

  public StabShotChargeTask(Location paramLocation, Player paramPlayer, int paramInt1, ItemDisplay paramItemDisplay, World paramWorld, int paramInt2) {
        this.location = paramLocation;
        this.player = paramPlayer;
        this.radius = paramInt1;
        this.itemDisplay = paramItemDisplay;
        this.world = paramWorld;
        this.verticalRadius = paramInt2;
        this.remainingTicks = 20;
        this.currentRadius = 0.0;
    }

  public void run() {
    if (this.remainingTicks <= 0) {
      StrikerBowAbility.detonateStabShot(this.location, this.player, this.radius, this.itemDisplay);
      cancel();
      return;
    } 

    for (int b = 0; b < 360; b += 30) {
      for (double d = 0.0D; d < 2.0D; d += 0.2D) {
        double d1 = Math.toRadians((this.remainingTicks + b));
        double d2 = this.location.getX() + this.currentRadius * Math.cos(d1);
        double d3 = this.location.getY() + d;
        double d4 = this.location.getZ() + this.currentRadius * Math.sin(d1);
        Location location = new Location(this.world, d2, d3, d4);
        this.world.spawnParticle(Particle.ELECTRIC_SPARK, location, 0, 0.0D, 0.0D, 0.0D, 0.0D);
      } 
    } 
    this.itemDisplay.setInterpolationDelay(0);
    this.itemDisplay.setInterpolationDuration(2);
    Transformation transformation = this.itemDisplay.getTransformation();
    transformation.getLeftRotation().rotateY((float)Math.toRadians(5.0D));
    float f = (float)this.currentRadius;
    transformation.getScale().set(f, this.verticalRadius, f);
    this.itemDisplay.setTransformation(transformation);
    for (Player player : this.location.getNearbyPlayers(this.currentRadius, this.verticalRadius, this.currentRadius)) {
      player.getWorld().playSound(player.getLocation(), Sound.BLOCK_RESPAWN_ANCHOR_SET_SPAWN, 0.25F, 1.0F);
      player.sendTitle("", WARNING_MESSAGE, 0, 2, 0);
    } 
    if (this.currentRadius != this.radius) {
      this.currentRadius += 0.5D;
      return;
    } 

    this.remainingTicks--;
  }


}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f1.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */