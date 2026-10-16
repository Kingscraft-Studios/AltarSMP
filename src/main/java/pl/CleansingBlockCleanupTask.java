package pl;

import org.bukkit.scheduler.BukkitRunnable;

class CleansingBlockCleanupTask extends BukkitRunnable {
  final CleansingBlockEffectTask animationTask;

  CleansingBlockCleanupTask(CleansingBlockEffectTask cleansingBlockEffectTask) {
        this.animationTask = cleansingBlockEffectTask;
    }
  
  public void run() {
    try {
      if (this.animationTask.outerBlockDisplay.isValid())
        this.animationTask.outerBlockDisplay.remove();
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.animationTask.innerBlockDisplay.isValid())
        this.animationTask.innerBlockDisplay.remove();
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fn.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */