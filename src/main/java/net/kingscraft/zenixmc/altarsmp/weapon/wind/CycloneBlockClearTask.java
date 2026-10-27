package net.kingscraft.zenixmc.altarsmp.weapon.wind;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.weapon.shade.ShadeSoul;

public class CycloneBlockClearTask extends BukkitRunnable {

  public int ticks;

  public final Player player;

  public CycloneBlockClearTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.ticks = 0;
    }

  public void run() {
    if (this.ticks >= 40.0D) {
      cancel();
      return;
    }

    for (Block block : ShadeSoul.getBlocksInArea(this.player, 5, 3)) {
      if (block.getType() == Material.COBWEB) {
        block.setType(Material.AIR);
        this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 2.0F, 1.0F);
      }
    } 
    this.ticks++;
  }
}
