package pl;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

class FrostScytheReturnTask extends BukkitRunnable {
  int ticksElapsed;
  
  final double returnSpeed = Main.getInstance().getConfig().getInt(SCYTHE_RETURN_SPEED_KEY, 2);
  
  final Player player;
  
  final ItemDisplay scytheDisplay;
  
  final double maxReturnDuration;
  
  private static final String SCYTHE_RETURN_SPEED_KEY = "scytheReturnPower";
  
  FrostScytheReturnTask(Player paramPlayer, ItemDisplay paramItemDisplay, double paramDouble) {
        this.player = paramPlayer;
        this.scytheDisplay = paramItemDisplay;
        this.maxReturnDuration = paramDouble;
        this.ticksElapsed = 0;
    }
  
  public void run() {
    try {
      if (this.player.isOnline())
        try {
          if (!this.scytheDisplay.isDead()) {
            try {
              if (this.ticksElapsed++ >= this.maxReturnDuration) {
                FrostScytheAbilityListener.handleScytheReturn(this.player, this.scytheDisplay);
                cancel();
                return;
              } 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            this.scytheDisplay.setTeleportDuration(2);
            this.scytheDisplay.setInterpolationDelay(0);
            this.scytheDisplay.setInterpolationDuration(2);
            Transformation transformation = this.scytheDisplay.getTransformation();
            try {
              transformation.getLeftRotation().rotateX((float)Math.toRadians(30.0D));
              this.scytheDisplay.setTransformation(transformation);
              if (this.ticksElapsed % 4 == 0)
                this.player.getWorld().playSound((Entity)this.player, Sound.ENTITY_WITCH_THROW, 1.0F, 1.0F);
            } catch (MatchException matchException) {
              throw a(null);
            } 
            Location location1 = this.scytheDisplay.getLocation();
            Location location2 = this.player.getEyeLocation();
            Vector vector1 = location2.toVector().subtract(location1.toVector());
            double d = vector1.length();
            try {
              if (d < 1.0D) {
                FrostScytheAbilityListener.handleScytheReturn(this.player, this.scytheDisplay);
                cancel();
                return;
              } 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            Vector vector2 = vector1.normalize().multiply(this.returnSpeed);
            location1.add(vector2);
            this.scytheDisplay.teleport(location1);
            location1.getWorld().spawnParticle(Particle.SNOWFLAKE, location1, 3, 0.1D, 0.1D, 0.1D, 0.01D);
            location1.setDirection(vector2);
            return;
          } 
          try {
            if (!this.scytheDisplay.isDead())
              this.scytheDisplay.remove();
          } catch (MatchException matchException) {
            throw a(null);
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!this.scytheDisplay.isDead())
        this.scytheDisplay.remove();
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dc.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */