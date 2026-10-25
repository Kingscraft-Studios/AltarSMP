package net.kingscraft.zenixmc.altarsmp.core.worldguard;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.Location;

public class WorldGuardPvpHandler {
  public static boolean isPvpDenied(Location paramLocation) {
    com.sk89q.worldedit.util.Location location = BukkitAdapter.adapt(paramLocation);
    RegionContainer regionContainer = WorldGuard.getInstance().getPlatform().getRegionContainer();
    RegionQuery regionQuery = regionContainer.createQuery();
    ApplicableRegionSet applicableRegionSet = regionQuery.getApplicableRegions(location);
    for (ProtectedRegion protectedRegion : applicableRegionSet) {
      StateFlag.State state = protectedRegion.getFlag(Flags.PVP);
      if (state == StateFlag.State.DENY)
        return true;
    } 
    return false;
  }
}
