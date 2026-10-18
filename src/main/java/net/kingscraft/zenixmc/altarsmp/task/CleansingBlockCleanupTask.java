package net.kingscraft.zenixmc.altarsmp.task;

import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class CleansingBlockCleanupTask extends BukkitRunnable {
  public final CleansingBlockEffectTask animationTask;

  public CleansingBlockCleanupTask(CleansingBlockEffectTask cleansingBlockEffectTask) {
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
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fn.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */