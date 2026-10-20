package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class SlashHideTask extends BukkitRunnable {
  public final ItemDisplay display;

  public SlashHideTask(ItemDisplay paramItemDisplay) {
        this.display = paramItemDisplay;
    }

  public void run() {
    Transformation transformation = this.display.getTransformation();
    transformation.getScale().set(0.0F, 0.0F, 0.0F);
    this.display.setTransformation(transformation);
  }
}
