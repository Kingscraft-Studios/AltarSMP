package net.kingscraft.zenixmc.altarsmp.weapon.knightfall;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class CloakSpeedTask extends BukkitRunnable {
  public final Player player;

  public final KnightfallListener listener;

  public CloakSpeedTask(KnightfallListener listener, Player paramPlayer) {
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
