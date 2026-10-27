package net.kingscraft.zenixmc.altarsmp.weapon.eclipse;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.util.FloatingTextEffectUtils;

class SolarLeapParticleTask extends BukkitRunnable {
  public int ticks;

  public final Player player;

  public SolarLeapParticleTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.ticks = 0;
    }

  public void run() {
    if (!this.player.isOnGround())
      {
        if (!this.player.isInWater())
          {
            if (!this.player.isInLava()) {
              Location location = this.player.getLocation();
              FloatingTextEffectUtils.spawnAnimatedTextEffect(location, 1, Color.YELLOW, Color.YELLOW, 0.0D, 1, 20, 0, true, "⭐", 10, 20);
              this.ticks++;
              return;
            } 
            cancel();
            return;
          }  
      }  

    cancel();
  }

}
