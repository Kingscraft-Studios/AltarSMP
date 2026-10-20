package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;

public class SlashDespawnTask extends BukkitRunnable {
  public final ItemDisplay display;

  public SlashDespawnTask(ItemDisplay paramItemDisplay) {
        this.display = paramItemDisplay;
    }

  public void run() {
    this.display.remove();
  }
}
