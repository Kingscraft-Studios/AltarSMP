package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764db.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */