package net.kingscraft.zenixmc.altarsmp.weapon.cutlass;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class CutlassParryLaunchTask extends BukkitRunnable {
  public final Player player;

  public CutlassParryLaunchTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    this.player.setVelocity(this.player.getLocation().getDirection().multiply(2).setY(0.2D));
    (new CutlassParryEffectTask(this)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }
}
