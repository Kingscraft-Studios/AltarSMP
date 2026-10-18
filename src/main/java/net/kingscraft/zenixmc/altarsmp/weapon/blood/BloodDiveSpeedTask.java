package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BloodDiveSpeedTask extends BukkitRunnable {
  public final Player player;
  
  public final BloodLustAbilityListener abilityListener;
  
  public BloodDiveSpeedTask(BloodLustAbilityListener bloodLustAbilityListener, Player paramPlayer) {
        this.abilityListener = bloodLustAbilityListener;
        this.player = paramPlayer;
    }
  
  public void run() {
    try {
      if (this.player.isOnline())
        try {
          if (this.abilityListener.killTracker.getKillCount(this.player) >= 1)
            try {
              if (BloodLustAbilityListener.isHoldingBloodlust(this.player)) {
                this.player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, BloodLustAbilityListener.speedLevel, true, true, true));
                return;
              } 
              this.abilityListener.stopBloodDive(this.player);
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
    this.abilityListener.stopBloodDive(this.player);
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cu.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */