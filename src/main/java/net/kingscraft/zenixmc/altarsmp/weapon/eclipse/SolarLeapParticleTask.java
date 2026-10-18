package net.kingscraft.zenixmc.altarsmp.weapon.eclipse;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fq.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */