package net.kingscraft.zenixmc.altarsmp.weapon.witherbone;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.util.RandomUtils;

class CleansingBlockShrinkTask extends BukkitRunnable {
  public final CleansingBlockAnimationTask animationTask;

  public CleansingBlockShrinkTask(CleansingBlockAnimationTask cleansingBlockAnimationTask) {
        this.animationTask = cleansingBlockAnimationTask;
    }

  public void run() {
    float f = RandomUtils.randomFloat(0.2F, 0.4F);
    if (this.animationTask.outerBlockDisplay.isValid())
      {
        if (this.animationTask.innerBlockDisplay.isValid()) {
          this.animationTask.world.spawnParticle(Particle.SQUID_INK, this.animationTask.landingLocation, 10, 0.3D, 0.1D, 0.3D, 0.1D);
          this.animationTask.world.playSound(this.animationTask.landingLocation, Sound.BLOCK_SLIME_BLOCK_FALL, 0.4F, 1.2F);
          this.animationTask.outerBlockDisplay.setInterpolationDelay(0);
          this.animationTask.outerBlockDisplay.setInterpolationDuration(5);
          Transformation transformation1 = this.animationTask.outerBlockDisplay.getTransformation();
          transformation1.getScale().set(this.animationTask.outerBlockScale, f, this.animationTask.outerBlockScale);
          this.animationTask.outerBlockDisplay.setTransformation(transformation1);
          this.animationTask.innerBlockDisplay.setInterpolationDelay(0);
          this.animationTask.innerBlockDisplay.setInterpolationDuration(5);
          Transformation transformation2 = this.animationTask.innerBlockDisplay.getTransformation();
          transformation2.getScale().set(this.animationTask.innerBlockScale, f + 0.1D, this.animationTask.innerBlockScale);
          this.animationTask.innerBlockDisplay.setTransformation(transformation2);
          return;
        } 
        return;
      }  

  }

}
