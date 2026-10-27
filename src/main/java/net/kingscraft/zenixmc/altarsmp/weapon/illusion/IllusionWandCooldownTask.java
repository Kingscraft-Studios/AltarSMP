package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class IllusionWandCooldownTask extends BukkitRunnable {
  public final Player player;

  public IllusionWandCooldownTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    if (!this.player.isOnline()) {
      cancel();
      return;
    } 

    this.player.setCooldown(Material.NETHERITE_SWORD, 100);
  }

}
