package net.kingscraft.zenixmc.altarsmp.weapon.echo;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class EchoSonicBlastDelayTask extends BukkitRunnable {
  public final Player player;

  public EchoSonicBlastDelayTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    EchoAbility.launchSonicBlast(this.player);
  }
}
