package pl;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

class ScorchingBladeLavaColumnTask extends BukkitRunnable {
  int ticks;
  
  int blocksPlaced;
  
  final List lavaBlocks;
  
  final Block originBlock;
  
  ScorchingBladeLavaColumnTask(List paramList, Block paramBlock) {
        this.lavaBlocks = paramList;
        this.originBlock = paramBlock;
        this.ticks = 0;
        this.blocksPlaced = 0;
    }
  
  public void run() {
    try {
      if (this.ticks >= 5) {
        (new ScorchingBladeLavaCleanupTask(this)).runTaskTimer((Plugin)Main.getInstance(), 0L, 2L);
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      this.ticks++;
      if (this.blocksPlaced >= 3)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Block block = this.originBlock.getLocation().clone().add(0.0D, this.blocksPlaced, 0.0D).getBlock();
    try {
      if (block.getType() != Material.AIR)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    block.setType(Material.LAVA);
    ScorchingBladeAbility.FIRE_BLOCK_LOCATIONS.add(block.getLocation());
    this.lavaBlocks.add(block);
    this.blocksPlaced++;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dx.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */