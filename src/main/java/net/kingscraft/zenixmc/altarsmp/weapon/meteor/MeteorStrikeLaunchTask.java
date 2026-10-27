package net.kingscraft.zenixmc.altarsmp.weapon.meteor;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MeteorStrikeLaunchTask extends BukkitRunnable {
  public final Player player;

  public MeteorStrikeLaunchTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    this.player.setVelocity(this.player.getVelocity().add(new Vector(0.0D, 0.3D, 0.0D)));
  }
}
