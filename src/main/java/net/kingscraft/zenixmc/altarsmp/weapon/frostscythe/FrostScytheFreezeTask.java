package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

class FrostScytheFreezeTask extends BukkitRunnable {
  public int ticksElapsed;

  public final int durationSeconds;

  public final LivingEntity target;

  public FrostScytheFreezeTask(int paramInt, LivingEntity paramLivingEntity) {
        this.durationSeconds = paramInt;
        this.target = paramLivingEntity;
        this.ticksElapsed = 0;
    }

  public void run() {
    if (this.ticksElapsed >= this.durationSeconds * 20) {
      cancel();
      return;
    } 

    this.target.setFreezeTicks(100);
    this.ticksElapsed++;
  }

}
