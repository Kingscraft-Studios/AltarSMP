package net.kingscraft.zenixmc.altarsmp.weapon.scorching;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ScorchingBladeLavaColumnTask extends BukkitRunnable {
  public int ticks;

  public int blocksPlaced;

  public final List lavaBlocks;

  public final Block originBlock;

  public ScorchingBladeLavaColumnTask(List paramList, Block paramBlock) {
        this.lavaBlocks = paramList;
        this.originBlock = paramBlock;
        this.ticks = 0;
        this.blocksPlaced = 0;
    }

  public void run() {
    if (this.ticks >= 5) {
      (new ScorchingBladeLavaCleanupTask(this)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 2L);
      cancel();
      return;
    } 

    this.ticks++;
    if (this.blocksPlaced >= 3)
      return; 

    Block block = this.originBlock.getLocation().clone().add(0.0D, this.blocksPlaced, 0.0D).getBlock();
    if (block.getType() != Material.AIR)
      return; 

    block.setType(Material.LAVA);
    ScorchingBladeAbility.FIRE_BLOCK_LOCATIONS.add(block.getLocation());
    this.lavaBlocks.add(block);
    this.blocksPlaced++;
  }

}
