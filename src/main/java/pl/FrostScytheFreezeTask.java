package pl;

import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

class FrostScytheFreezeTask extends BukkitRunnable {
  int ticksElapsed;
  
  final int durationSeconds;
  
  final LivingEntity target;
  
  FrostScytheFreezeTask(FrostScytheProjectileTask frostScytheProjectileTask, int paramInt, LivingEntity paramLivingEntity) {
        this.durationSeconds = paramInt;
        this.target = paramLivingEntity;
        this.ticksElapsed = 0;
    }
  
  public void run() {
    try {
      if (this.ticksElapsed >= this.durationSeconds * 20) {
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.target.setFreezeTicks(100);
    this.ticksElapsed++;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764db.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */