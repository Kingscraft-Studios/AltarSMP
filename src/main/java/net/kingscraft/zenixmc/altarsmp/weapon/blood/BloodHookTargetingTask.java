package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BloodHookTargetingTask extends BukkitRunnable {
  public final Player player;

  public final BloodLustAbilityListener abilityListener;

  public BloodHookTargetingTask(BloodLustAbilityListener bloodLustAbilityListener, Player paramPlayer) {
        this.abilityListener = bloodLustAbilityListener;
        this.player = paramPlayer;
    }

  public void run() {
    if (this.player.isOnline())
      {
        if (this.abilityListener.killTracker.getKillCount(this.player) >= 2)
          {
            if (BloodLustAbilityListener.isHoldingBloodlust(this.player)) {
              Player player = this.abilityListener.findNearestEnemy(this.player, BloodLustAbilityListener.bloodlustTrackRange);
              if (player == null)
                return; 

              Location location1 = this.player.getLocation().add(0.0D, 1.0D, 0.0D);
              Location location2 = player.getLocation().add(0.0D, 1.0D, 0.0D);
              double d1 = location2.getX() - location1.getX();
              double d2 = location2.getY() - location1.getY();
              double d3 = location2.getZ() - location1.getZ();
              double d4 = Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3);
              if (d4 < 0.1D)
                return; 

              d1 /= d4;
              d2 /= d4;
              d3 /= d4;
              Location location3 = location1.clone().add(d1, d2, d3);
              Location location4 = location2.clone();
              if (location3.getWorld() != location4.getWorld())
                return; 

              double d5 = location3.distance(location4);
              double d6 = 2.0D;
              if (d5 > d6) {
                double d = d6 / d5;
                location4 = location3.clone().add((location4.getX() - location3.getX()) * d, (location4.getY() - location3.getY()) * d, (location4.getZ() - location3.getZ()) * d);
              } 
              Location location5 = location3.clone();
              Location location6 = location4.clone();
              BukkitRunnable bukkitRunnable = this.abilityListener.bloodInfectionTasks.remove(this.player.getUniqueId());
              if (bukkitRunnable != null)
                try {
                  bukkitRunnable.cancel();
                } catch (IllegalStateException illegalStateException) {} 

              BloodHookTrailParticleTask bloodHookTrailParticleTask = new BloodHookTrailParticleTask(this, location5, location6);
              this.abilityListener.bloodInfectionTasks.put(this.player.getUniqueId(), bloodHookTrailParticleTask);
              bloodHookTrailParticleTask.runTaskTimer((Plugin) BloodLustAbilityListener.plugin, 0L, 1L);
              return;
            } 
            this.abilityListener.cancelPlayerAbilities(this.player);
            return;
          }  
      }  

    this.abilityListener.cancelPlayerAbilities(this.player);
  }

}
