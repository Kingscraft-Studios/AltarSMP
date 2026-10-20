package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class FrostScytheReturnTask extends BukkitRunnable {
  public int ticksElapsed;

  final double returnSpeed = AltarSMP.getInstance().getConfig().getInt(SCYTHE_RETURN_SPEED_KEY, 2);

  public final Player player;

  public final ItemDisplay scytheDisplay;

  public final double maxReturnDuration;

  private static final String SCYTHE_RETURN_SPEED_KEY = "scytheReturnPower";

  public FrostScytheReturnTask(Player paramPlayer, ItemDisplay paramItemDisplay, double paramDouble) {
        this.player = paramPlayer;
        this.scytheDisplay = paramItemDisplay;
        this.maxReturnDuration = paramDouble;
        this.ticksElapsed = 0;
    }

  public void run() {
    if (this.player.isOnline())
      {
        if (!this.scytheDisplay.isDead()) {
          if (this.ticksElapsed++ >= this.maxReturnDuration) {
            FrostScytheAbilityListener.handleScytheReturn(this.player, this.scytheDisplay);
            cancel();
            return;
          } 

          this.scytheDisplay.setTeleportDuration(2);
          this.scytheDisplay.setInterpolationDelay(0);
          this.scytheDisplay.setInterpolationDuration(2);
          Transformation transformation = this.scytheDisplay.getTransformation();
          transformation.getLeftRotation().rotateX((float)Math.toRadians(30.0D));
          this.scytheDisplay.setTransformation(transformation);
          if (this.ticksElapsed % 4 == 0)
            this.player.getWorld().playSound((Entity)this.player, Sound.ENTITY_WITCH_THROW, 1.0F, 1.0F);

          Location location1 = this.scytheDisplay.getLocation();
          Location location2 = this.player.getEyeLocation();
          Vector vector1 = location2.toVector().subtract(location1.toVector());
          double d = vector1.length();
          if (d < 1.0D) {
            FrostScytheAbilityListener.handleScytheReturn(this.player, this.scytheDisplay);
            cancel();
            return;
          } 

          Vector vector2 = vector1.normalize().multiply(this.returnSpeed);
          location1.add(vector2);
          this.scytheDisplay.teleport(location1);
          location1.getWorld().spawnParticle(Particle.SNOWFLAKE, location1, 3, 0.1D, 0.1D, 0.1D, 0.01D);
          location1.setDirection(vector2);
          return;
        } 
        if (!this.scytheDisplay.isDead())
          this.scytheDisplay.remove();

      }  

    if (!this.scytheDisplay.isDead())
      this.scytheDisplay.remove();

  }


}
