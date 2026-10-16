package pl;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

class GrapplePullTask extends BukkitRunnable {
  int ticks;
  
  final Player player;
  
  final double maxTicks;
  
  final Location hookLocation;
  
  final int leapStrength;
  
  final ItemStack chainItem;
  
  final double pullStrength;
  
  GrapplePullTask(Player paramPlayer, double paramDouble1, Location paramLocation, int paramInt, ItemStack paramItemStack, double paramDouble2) {
        this.player = paramPlayer;
        this.maxTicks = paramDouble1;
        this.hookLocation = paramLocation;
        this.leapStrength = paramInt;
        this.chainItem = paramItemStack;
        this.pullStrength = paramDouble2;
        this.ticks = 0;
    }
  
  public void run() {
    if (!this.player.isValid() || (double)this.ticks > this.maxTicks) {
      cancel();
      return;
    }

    if (this.hookLocation.getWorld() != this.player.getWorld())
      return;

    if (this.hookLocation.distance(this.player.getLocation()) <= 2.0D || (this.player.isOnGround() && this.ticks <= 5)) {
      this.player.setVelocity(this.player.getVelocity().setY(this.leapStrength));
      this.player.getWorld().spawnParticle(Particle.DUST, this.player.getEyeLocation(), 10, 0.25D, 0.25D, 0.25D, new Particle.DustOptions(Color.WHITE, 2.0F));
      cancel();
      return;
    }

    if (this.ticks % 2 == 0) {
      Location location1 = this.player.getLocation().clone().add(0.0D, 1.6D, 0.0D);
      Vector vector = this.hookLocation.toVector().subtract(location1.toVector());
      double d = vector.length();
      double d1 = 0.1D;
      Vector vector1 = vector.normalize().multiply(d1);
      int i = (int)(d / d1);
      for (int j = 0; j <= i; ++j) {
        Location location2 = location1.clone().add(vector1.clone().multiply(j));
        location2.getWorld().spawnParticle(Particle.ITEM, location2, 0, 0.0D, 0.0D, 0.0D, 0.0D, this.chainItem);
      } 
    } 
    Vector vector2 = this.hookLocation.toVector().subtract(this.player.getLocation().toVector()).normalize();
    this.player.setVelocity(vector2.multiply(this.pullStrength));
    this.player.getWorld().playSound(this.player.getLocation(), Sound.BLOCK_CHAIN_PLACE, 2.0F, 0.9F);
    this.ticks++;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fx.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */