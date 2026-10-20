package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.tracker.KillTracker;

public class BloodLustKillTracker extends KillTracker {
  public static boolean bool;

  public BloodLustKillTracker(AltarSMP plugin) {
    super(plugin, "bloodlustkills.yml");
  }

  @Override
  protected boolean forceMax() {
    return bool;
  }
}
