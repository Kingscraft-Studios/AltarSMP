package net.kingscraft.zenixmc.altarsmp.util;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;

public class FloatingTextRemovalTask extends BukkitRunnable {
  public final TextDisplay textDisplay;

  public FloatingTextRemovalTask(TextDisplay paramTextDisplay) {
        this.textDisplay = paramTextDisplay;
    }

  public void run() {
    this.textDisplay.remove();
  }
}
