package net.kingscraft.zenixmc.altarsmp.core.worldguard;

import org.bukkit.Location;

import java.lang.reflect.Method;

public final class WorldGuardPvpHandler {

  private WorldGuardPvpHandler() {
  }

  public static boolean isPvpDenied(Location location) {
    try {
      Class<?> worldGuardClass = Class.forName("com.sk89q.worldguard.WorldGuard");
      Object worldGuard = worldGuardClass.getMethod("getInstance").invoke(null);
      Object platform = worldGuardClass.getMethod("getPlatform").invoke(worldGuard);
      Object container = platform.getClass().getMethod("getRegionContainer").invoke(platform);
      Object query = container.getClass().getMethod("createQuery").invoke(container);

      Class<?> adapterClass = Class.forName("com.sk89q.worldedit.bukkit.BukkitAdapter");
      Class<?> worldEditLocationClass = Class.forName("com.sk89q.worldedit.util.Location");

      Object worldEditLocation = adapterClass.getMethod("adapt", Location.class).invoke(null, location);
      Object applicableRegions = query.getClass().getMethod("getApplicableRegions", worldEditLocationClass).invoke(query, worldEditLocation);

      Class<?> flagsClass = Class.forName("com.sk89q.worldguard.protection.flags.Flags");

      Object pvpFlag = flagsClass.getField("PVP").get(null);

      Class<?> flagClass = Class.forName("com.sk89q.worldguard.protection.flags.Flag");
      Class<?> protectedRegionClass = Class.forName("com.sk89q.worldguard.protection.regions.ProtectedRegion");

      Method getFlag = protectedRegionClass.getMethod("getFlag", flagClass);

      for (Object region : (Iterable<?>) applicableRegions) {
        Object state = getFlag.invoke(region, pvpFlag);

        if (state != null && state.toString().equals("DENY")) {
          return true;
        }
      }

      return false;
    } catch (ClassNotFoundException exception) {
      return false;

    } catch (ReflectiveOperationException exception) {
      exception.printStackTrace();
      return false;

    }
  }
}