package net.kingscraft.zenixmc.altarsmp.weapon.scorching;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ScorchingBladeLavaCleanupTask extends BukkitRunnable {
  public int cleanupIndex;
  public final ScorchingBladeLavaColumnTask parentTask;
  public final int totalBlocks;

  public ScorchingBladeLavaCleanupTask(ScorchingBladeLavaColumnTask scorchingBladeLavaColumnTask) {
        this.parentTask = scorchingBladeLavaColumnTask;
        this.totalBlocks = this.parentTask.lavaBlocks.size();
        this.cleanupIndex = 0;
    }

  public void run() {
    if (this.cleanupIndex >= this.totalBlocks) {
      cancel();
      return;
    } 

    Block block = (Block)this.parentTask.lavaBlocks.get(this.totalBlocks - this.cleanupIndex - 1);
    if (block.getType() == Material.LAVA)
      block.setType(Material.AIR); 

    ScorchingBladeAbility.FIRE_BLOCK_LOCATIONS.remove(block.getLocation());
    this.cleanupIndex++;
  }
}
