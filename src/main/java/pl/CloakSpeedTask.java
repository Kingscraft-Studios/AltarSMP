package pl;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class CloakSpeedTask extends BukkitRunnable {
  final Player player;
  
  final KnightfallListener listener;
  
  CloakSpeedTask(KnightfallListener listener, Player paramPlayer) {
        this.listener = listener;
        this.player = paramPlayer;
    }

  @Override
  public void run() {
    if (this.player.isOnline() && this.listener.killTracker.getKillCount(this.player) >= 6 && KnightfallListener.isKnightfall(this.player.getInventory().getItemInMainHand())) {
      this.player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, KnightfallListener.speedAmplifier, true, true, true));
      return;
    }
    this.listener.stopCloakLoop(this.player);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fu.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */