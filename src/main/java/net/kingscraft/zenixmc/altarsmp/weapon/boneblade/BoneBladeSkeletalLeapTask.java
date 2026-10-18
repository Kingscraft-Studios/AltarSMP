package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class BoneBladeSkeletalLeapTask extends BukkitRunnable {
  final int MAX_TICKS = 5;
  
  public int ticks;
  
  public final Player player;
  
  public final double damage;
  
  public BoneBladeSkeletalLeapTask(Player paramPlayer, double paramDouble) {
        this.player = paramPlayer;
        this.damage = paramDouble;
        this.ticks = 0;
    }
  
  public void run() {
    try {
      if (this.ticks < 100)
        try {
          if (!this.player.isOnGround()) {
            for (Entity entity : this.player.getLocation().getNearbyEntities(2.0D, 2.0D, 2.0D)) {
              if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity)entity;
                try {
                  if (livingEntity.equals(this.player))
                    continue; 
                } catch (MatchException matchException) {
                  throw a(null);
                } 
                BoneBladeAbility.spawnBoneParticles(livingEntity.getLocation().clone().add(0.0D, 1.0D, 0.0D), Material.BONE, 15, 2.0D, 15);
                livingEntity.damage(this.damage);
                cancel();
                return;
              } 
            } 
            this.ticks++;
            return;
          } 
          cancel();
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    cancel();
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c1.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */