package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BloodLustAbilityMonitorTask extends BukkitRunnable {
  public final BloodLustKillTracker killTracker;
  
  public final BloodLustAbilityListener abilityListener;
  
  public BloodLustAbilityMonitorTask(BloodLustAbilityListener bloodLustAbilityListener, BloodLustKillTracker paramBloodLustKillTracker) {
        this.abilityListener = bloodLustAbilityListener;
        this.killTracker = paramBloodLustKillTracker;
    }
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      boolean flag = BloodLustAbilityListener.isHoldingBloodlust(player);
      if (flag && this.killTracker.getKillCount(player) >= 1) {
        if (!this.abilityListener.bloodTrailTasks.containsKey(player.getUniqueId()))
          this.abilityListener.startBloodDive(player);
      } else {
        this.abilityListener.stopBloodDive(player);
      } 
      if (flag && this.killTracker.getKillCount(player) >= 2) {
        if (!this.abilityListener.bloodHookTasks.containsKey(player.getUniqueId()))
          this.abilityListener.startBloodHook(player);
      } else {
        this.abilityListener.cancelPlayerAbilities(player);
      } 
      if (flag && this.killTracker.getKillCount(player) >= 4) {
        if (!this.abilityListener.bloodDiveTasks.containsKey(player.getUniqueId()))
          this.abilityListener.startBloodTrail(player);
      } else {
        this.abilityListener.stopBloodTrail(player);
      } 
    } 
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cs.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */