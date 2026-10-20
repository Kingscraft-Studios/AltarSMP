package net.kingscraft.zenixmc.altarsmp.altar;

import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class AltarReloadTask extends BukkitRunnable {
  public final AltarSMP plugin;

  public AltarReloadTask(AltarSMP paramAltarSMP) {
        this.plugin = paramAltarSMP;
    }

  public void run() {
    this.plugin.altarController.loadAltars();
  }
}
