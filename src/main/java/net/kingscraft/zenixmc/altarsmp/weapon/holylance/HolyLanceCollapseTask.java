package net.kingscraft.zenixmc.altarsmp.weapon.holylance;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

class HolyLanceCollapseTask extends BukkitRunnable {
  public final HolyLanceTask parent;

  public HolyLanceCollapseTask(HolyLanceTask parent) {
        this.parent = parent;
    }

  public void run() {
    Transformation transformation = this.parent.display.getTransformation();
    transformation.getScale().set(0.0F, 1.0F, 0.0F);
    this.parent.display.setTransformation(transformation);
  }
}
