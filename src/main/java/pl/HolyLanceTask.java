package pl;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

class HolyLanceTask extends BukkitRunnable {
  final double UNUSED_LITERAL = 1.5D;
  
  int ticks;
  
  final ItemDisplay display;
  
  final Player player;
  
  private static final String DAMAGE_CONFIG_KEY = "holyLanceDamage";
  
  HolyLanceTask(ItemDisplay paramItemDisplay, Player paramPlayer) {
        this.display = paramItemDisplay;
        this.player = paramPlayer;
        this.ticks = 0;
    }
  
  public void run() {
    if (this.ticks >= 6.0D) {
      this.display.setInterpolationDelay(0);
      this.display.setInterpolationDuration(6);
      (new HolyLanceCollapseTask(this)).runTaskLater((Plugin)Main.getInstance(), 2L);
      (new HolyLanceDespawnTask(this)).runTaskLater((Plugin)Main.getInstance(), 20L);
      cancel();
      return;
    }

    if (this.ticks % 2 == 0) {
      byte b1 = 3;
      for (byte b2 = 0; b2 < 360; b2 += 8) {
        Location location1 = this.player.getLocation().clone().add(0.0D, 1.0D, 0.0D);
        World world = this.player.getWorld();
        double d1 = Math.toRadians(b2);
        double d2 = location1.getX() + b1 * Math.cos(d1);
        double d3 = location1.getY();
        double d4 = location1.getZ() + b1 * Math.sin(d1);
        Location location2 = new Location(world, d2, d3, d4);
        world.spawnParticle(Particle.CRIT, location2, 0, 0.0D, 0.0D, 0.0D, 0.0D);
        this.player.getLocation().getWorld().spawnParticle(Particle.POOF, location2, 0, 0.0D, 0.0D, 0.0D, 0.1D);
      } 
    } 
    for (Entity entity : this.player.getLocation().getNearbyEntities(3.0D, 3.0D, 3.0D)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        if (entity.equals(this.player))
          continue;

        this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 2.0F, 1.0F);
        livingEntity.damage(Main.getInstance().getConfig().getDouble(DAMAGE_CONFIG_KEY, 6.0D), (Entity)this.player);
      } 
    }
    if (this.ticks == 0)
      ShadeSoul.castCycloneSlash(this.player);

    this.ticks++;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e4.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */