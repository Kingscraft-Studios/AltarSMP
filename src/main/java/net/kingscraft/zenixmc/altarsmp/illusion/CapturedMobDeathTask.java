package net.kingscraft.zenixmc.altarsmp.illusion;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CapturedMobDeathTask extends BukkitRunnable {
  public final Player player;

  public CapturedMobDeathTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    this.player.setHealth(0.0D);
  }
}
