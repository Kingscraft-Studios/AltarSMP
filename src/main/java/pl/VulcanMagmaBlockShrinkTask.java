package pl;

import org.bukkit.entity.BlockDisplay;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

class VulcanMagmaBlockShrinkTask extends BukkitRunnable {
  final BlockDisplay blockDisplay;
  
  VulcanMagmaBlockShrinkTask(BlockDisplay paramBlockDisplay) {
        this.blockDisplay = paramBlockDisplay;
    }
  
  public void run() {
    this.blockDisplay.setInterpolationDelay(0);
    this.blockDisplay.setInterpolationDuration(10);
    Transformation transformation = this.blockDisplay.getTransformation();
    transformation.getScale().set(0.0F, 0.0F, 0.0F);
    this.blockDisplay.setTransformation(transformation);
    (new VulcanMagmaBlockCleanupTask(this)).runTaskLater((Plugin)Main.getInstance(), 10L);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764do.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */