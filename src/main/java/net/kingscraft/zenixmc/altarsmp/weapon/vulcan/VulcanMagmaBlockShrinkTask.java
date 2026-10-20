package net.kingscraft.zenixmc.altarsmp.weapon.vulcan;

import org.bukkit.entity.BlockDisplay;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class VulcanMagmaBlockShrinkTask extends BukkitRunnable {
  public final BlockDisplay blockDisplay;

  public VulcanMagmaBlockShrinkTask(BlockDisplay paramBlockDisplay) {
        this.blockDisplay = paramBlockDisplay;
    }

  public void run() {
    this.blockDisplay.setInterpolationDelay(0);
    this.blockDisplay.setInterpolationDuration(10);
    Transformation transformation = this.blockDisplay.getTransformation();
    transformation.getScale().set(0.0F, 0.0F, 0.0F);
    this.blockDisplay.setTransformation(transformation);
    (new VulcanMagmaBlockCleanupTask(this)).runTaskLater((Plugin)AltarSMP.getInstance(), 10L);
  }
}
