package net.kingscraft.zenixmc.altarsmp.weapon.holylance;

import org.bukkit.scheduler.BukkitRunnable;

class HolyLanceDespawnTask extends BukkitRunnable {
  public final HolyLanceTask parent;

  public HolyLanceDespawnTask(HolyLanceTask parent) {
        this.parent = parent;
    }

  public void run() {
    this.parent.display.remove();
  }
}
