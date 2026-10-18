package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import java.util.List;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class FrostScytheBladeChargingTask extends BukkitRunnable {
  public int ticksElapsed;
  
  public final List bladeDisplays;
  
  public final Player player;
  
  public FrostScytheBladeChargingTask(List paramList, Player paramPlayer) {
        this.bladeDisplays = paramList;
        this.player = paramPlayer;
        this.ticksElapsed = 0;
    }
  
  public void run() {
    try {
      if (this.ticksElapsed >= 23) {
        FrostScytheAbilityListener.scheduleIceBladeLaunches(this.bladeDisplays, this.player);
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    for (int b = 0; b < this.bladeDisplays.size(); b++) {
      ItemDisplay itemDisplay = (ItemDisplay)this.bladeDisplays.get(b);
      itemDisplay.setTeleportDuration(2);
      itemDisplay.setRotation(this.player.getYaw(), 0.0F);
    } 
    try {
      this.player.getWorld().spawnParticle(Particle.TRIAL_SPAWNER_DETECTION_OMINOUS, this.player.getEyeLocation(), 2, 0.2D, 0.2D, 0.2D, 0.0D);
      if (this.ticksElapsed % 10 == 0)
        this.player.getWorld().playSound(this.player.getLocation(), Sound.BLOCK_GLASS_HIT, 0.5F, 1.0F + this.ticksElapsed / 23.0F);
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.ticksElapsed++;
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764df.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */