package net.kingscraft.zenixmc.altarsmp.armor.netherite;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class NetheriteSwordCooldownTask extends BukkitRunnable {
  public final Player player;

  public NetheriteSwordCooldownTask(Player paramPlayer) {
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
