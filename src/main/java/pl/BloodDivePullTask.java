package pl;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class BloodDivePullTask extends BukkitRunnable {
  int ticksElapsed;
  
  final int duration = 10;
  
  final LivingEntity target;
  
  final Player player;
  
  private static final String DIVE_SOUND = "minecraft:bloodlust.dive";
  
  BloodDivePullTask(LivingEntity paramLivingEntity, Player paramPlayer) {
        this.target = paramLivingEntity;
        this.player = paramPlayer;
        this.ticksElapsed = 0;
    }
  
  public void run() {
    try {
      if (this.ticksElapsed < 10)
        try {
          if (this.target.isValid())
            try {
              if (this.player.isOnline()) {
                try {
                  if (this.player.getWorld() != this.target.getWorld())
                    return; 
                } catch (MatchException matchException) {
                  throw a(null);
                } 
                try {
                  if (this.player.getLocation().distance(this.target.getLocation()) <= 2.0D) {
                    this.target.setVelocity(new Vector(0, 0, 0));
                    cancel();
                    return;
                  } 
                } catch (MatchException matchException) {
                  throw a(null);
                } 
                Location location1 = this.target.getLocation().clone().add(0.0D, 1.0D, 0.0D);
                Location location2 = this.player.getLocation().clone().add(0.0D, 1.0D, 0.0D);
                Vector vector1 = location2.toVector().subtract(location1.toVector());
                double d = vector1.length();
                Vector vector2 = vector1.normalize().multiply(1);
                if (this.ticksElapsed % 2 == 0) {
                  double d1 = 0;
                  for (d1 = 0.0D; d1 < d; d1++) {
                    Location location = location1.clone().add(vector2.clone().multiply(d1));
                    location1.getWorld().spawnParticle(Particle.ITEM, location, 0, 0.0D, 0.0D, 0.0D, 0.0D, new ItemStack(Material.REDSTONE_BLOCK));
                  } 
                } 
                this.player.getWorld().playSound(this.player.getLocation(), DIVE_SOUND, 2.0F, 0.8F);
                Vector vector3 = this.player.getLocation().toVector().subtract(this.target.getLocation().toVector()).normalize();
                this.target.setVelocity(vector3.multiply(1.5D));
                this.ticksElapsed++;
                return;
              } 
              cancel();
              return;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    cancel();
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c0.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */