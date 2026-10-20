package net.kingscraft.zenixmc.altarsmp.armor.knightfall;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class CloakAutoStartTask extends BukkitRunnable {
  public final KnightFallKillTracker killTracker;

  public final KnightfallListener listener;

  public CloakAutoStartTask(KnightfallListener listener, KnightFallKillTracker tracker) {
        this.listener = listener;
        this.killTracker = tracker;
    }

  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      boolean bool = KnightfallListener.isKnightfall(player.getInventory().getItemInMainHand());
        if (bool)
          if (this.killTracker.getKillCount(player) >= 6) {
            if (!this.listener.cloakTasks.containsKey(player.getUniqueId()))
              this.listener.startCloakLoop(player);
            continue;
          }

      this.listener.stopCloakLoop(player);
    } 
  }
}
