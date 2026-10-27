package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class BloodDiveSpeedTask extends BukkitRunnable {
  public final Player player;

  public final BloodLustAbilityListener abilityListener;

  public BloodDiveSpeedTask(BloodLustAbilityListener bloodLustAbilityListener, Player paramPlayer) {
        this.abilityListener = bloodLustAbilityListener;
        this.player = paramPlayer;
    }

  public void run() {
    if (this.player.isOnline())
      {
        if (this.abilityListener.killTracker.getKillCount(this.player) >= 1)
          {
            if (BloodLustAbilityListener.isHoldingBloodlust(this.player)) {
              this.player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, BloodLustAbilityListener.speedLevel, true, true, true));
              return;
            } 
            this.abilityListener.stopBloodDive(this.player);
            return;
          }  
      }  

    this.abilityListener.stopBloodDive(this.player);
  }

}
