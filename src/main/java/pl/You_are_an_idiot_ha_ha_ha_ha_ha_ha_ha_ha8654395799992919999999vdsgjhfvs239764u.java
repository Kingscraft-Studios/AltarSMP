package pl;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.Flags;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;
import org.bukkit.Location;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764u {
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation) {
    com.sk89q.worldedit.util.Location location = BukkitAdapter.adapt(paramLocation);
    RegionContainer regionContainer = WorldGuard.getInstance().getPlatform().getRegionContainer();
    RegionQuery regionQuery = regionContainer.createQuery();
    ApplicableRegionSet applicableRegionSet = regionQuery.getApplicableRegions(location);
    for (ProtectedRegion protectedRegion : applicableRegionSet) {
      StateFlag.State state = (StateFlag.State)protectedRegion.getFlag((Flag)Flags.PVP);
      try {
        if (state == StateFlag.State.DENY)
          return true; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    return false;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764u.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */