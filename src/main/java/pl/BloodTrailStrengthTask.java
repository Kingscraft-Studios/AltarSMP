package pl;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class BloodTrailStrengthTask extends BukkitRunnable {
  final Player player;
  
  final BloodLustAbilityListener abilityListener;
  
  BloodTrailStrengthTask(BloodLustAbilityListener bloodLustAbilityListener, Player paramPlayer) {
        this.abilityListener = bloodLustAbilityListener;
        this.player = paramPlayer;
    }
  
  public void run() {
    try {
      if (this.player.isOnline())
        try {
          if (this.abilityListener.killTracker.getKillCount(this.player) >= 4)
            try {
              if (BloodLustAbilityListener.isHoldingBloodlust(this.player)) {
                this.player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 200, BloodLustAbilityListener.strengthLevel, true, true, true));
                return;
              } 
              this.abilityListener.stopBloodTrail(this.player);
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
    this.abilityListener.stopBloodTrail(this.player);
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cv.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */