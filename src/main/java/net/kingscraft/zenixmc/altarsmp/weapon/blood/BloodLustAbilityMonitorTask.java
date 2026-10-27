package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import net.kingscraft.zenixmc.altarsmp.core.KillTracker;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class BloodLustAbilityMonitorTask extends BukkitRunnable {
  public final KillTracker killTracker;

  public final BloodLustAbilityListener abilityListener;

  public BloodLustAbilityMonitorTask(BloodLustAbilityListener bloodLustAbilityListener, KillTracker paramBloodLustKillTracker) {
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

}
