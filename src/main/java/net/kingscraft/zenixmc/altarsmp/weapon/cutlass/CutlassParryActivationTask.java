package net.kingscraft.zenixmc.altarsmp.weapon.cutlass;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;

public class CutlassParryActivationTask extends BukkitRunnable {
  public final Player player;

  private static final String ACTIVE_PARRY_COOLDOWN_KEY = "active_parry";

  public CutlassParryActivationTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    if (CooldownManager.isOnCooldown(this.player.getUniqueId(), ACTIVE_PARRY_COOLDOWN_KEY))
      CutlassAbility.activateParry(this.player);

  }


}
