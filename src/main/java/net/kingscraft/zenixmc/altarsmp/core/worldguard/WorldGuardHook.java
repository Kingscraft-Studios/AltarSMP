package net.kingscraft.zenixmc.altarsmp.core.worldguard;

import org.bukkit.Location;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class WorldGuardHook {
  public static final boolean DISABLED;

  public static final boolean WORLDGUARD_SUPPORT;

  public static boolean isBlocked(Location paramLocation) {
    {
      if (DISABLED)
        {
          if (WORLDGUARD_SUPPORT)
            try {
              Class<?> clazz = Class.forName("net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardPvpHandler");
              return (Boolean) clazz.getMethod("isPvpDenied", new Class[]{Location.class}).invoke(null, new Object[]{paramLocation});
            } catch (ClassNotFoundException classNotFoundException) {
              return false;
            } catch (Throwable throwable) {
              throwable.printStackTrace();
              return false;
            }  
          return false;
        }
    }
    return false;
  }
  static {
    DISABLED = false;
    WORLDGUARD_SUPPORT = AltarSMP.getInstance().getConfig().getBoolean("worldguard_support", false);
  }
}
