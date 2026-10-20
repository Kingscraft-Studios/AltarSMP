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
