package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BloodTrailStrengthTask extends BukkitRunnable {
  public final Player player;

  public final BloodLustAbilityListener abilityListener;

  public BloodTrailStrengthTask(BloodLustAbilityListener bloodLustAbilityListener, Player paramPlayer) {
        this.abilityListener = bloodLustAbilityListener;
        this.player = paramPlayer;
    }

  public void run() {
    if (this.player.isOnline())
      {
        if (this.abilityListener.killTracker.getKillCount(this.player) >= 4)
          {
            if (BloodLustAbilityListener.isHoldingBloodlust(this.player)) {
              this.player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 200, BloodLustAbilityListener.strengthLevel, true, true, true));
              return;
            } 
            this.abilityListener.stopBloodTrail(this.player);
            return;
          }  
      }  

    this.abilityListener.stopBloodTrail(this.player);
  }

}
