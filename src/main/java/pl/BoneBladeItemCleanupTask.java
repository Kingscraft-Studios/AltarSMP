package pl;

import java.util.List;
import org.bukkit.entity.Item;
import org.bukkit.scheduler.BukkitRunnable;

class BoneBladeItemCleanupTask extends BukkitRunnable {
  final List<Item> boneItems;
  
  BoneBladeItemCleanupTask(List paramList) {
        this.boneItems = paramList;
    }
  
  public void run() {
    this.boneItems.forEach(BoneBladeItemCleanupTask::lambda$run$0);
  }
  
  private static void lambda$run$0(Item paramItem) {
    try {
      if (paramItem.isValid())
        paramItem.remove(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c5.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */