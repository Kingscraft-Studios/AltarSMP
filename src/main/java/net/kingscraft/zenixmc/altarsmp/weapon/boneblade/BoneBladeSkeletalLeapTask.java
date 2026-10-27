package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class BoneBladeSkeletalLeapTask extends BukkitRunnable {

  public int ticks;

  public final Player player;

  public final double damage;

  public BoneBladeSkeletalLeapTask(Player paramPlayer, double paramDouble) {
        this.player = paramPlayer;
        this.damage = paramDouble;
        this.ticks = 0;
    }

  public void run() {
    if (this.ticks < 100)
      {
        if (!this.player.isOnGround()) {
          for (Entity entity : this.player.getLocation().getNearbyEntities(2.0D, 2.0D, 2.0D)) {
            if (entity instanceof LivingEntity livingEntity) {
                if (livingEntity.equals(this.player))
                  continue;

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
      }  

    cancel();
  }

}
