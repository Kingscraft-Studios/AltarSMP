package net.kingscraft.zenixmc.altarsmp.weapon.meteor;

import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.earth.EarthGauntletAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.earth.MudslideProjectileAnimationTask;

public class MeteorStrikeCleanupTask extends BukkitRunnable {
  public final LivingEntity livingEntity;

  public final MudslideProjectileAnimationTask projectileAnimationTask;

  public MeteorStrikeCleanupTask(MudslideProjectileAnimationTask mudslideProjectileAnimationTask, LivingEntity paramLivingEntity) {
        this.projectileAnimationTask = mudslideProjectileAnimationTask;
        this.livingEntity = paramLivingEntity;
    }

  public void run() {
    EarthGauntletAbility.meteorStrikeTargets.remove(this.projectileAnimationTask.projectileTask.player.getUniqueId());
    EarthGauntletAbility.jumpCancelledPlayers.remove(this.livingEntity.getUniqueId());
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764eb.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */