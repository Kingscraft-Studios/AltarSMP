package net.kingscraft.zenixmc.altarsmp.core.worldguard;

import org.bukkit.Location;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public final class WorldGuardHook {

  public static final boolean DISABLED = false;
  public static final boolean WORLDGUARD_SUPPORT = AltarSMP.getInstance().getConfig().getBoolean("worldguard_support", false);

  public static boolean isBlocked(Location location) {
    if (DISABLED || !WORLDGUARD_SUPPORT) {
      return false;
    }

    return WorldGuardPvpHandler.isPvpDenied(location);
  }
}