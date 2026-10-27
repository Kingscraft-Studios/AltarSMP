package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

class BloodInfectionDamageTask extends BukkitRunnable {
  public int ticksElapsed;

  public final int duration;

  public final LivingEntity target;

  public final int damageAmount;

  private static final String HIT_SOUND = "minecraft*bloodlust.hit";

  public BloodInfectionDamageTask(int paramInt1, LivingEntity paramLivingEntity, int paramInt2) {
        this.duration = paramInt1;
        this.target = paramLivingEntity;
        this.damageAmount = paramInt2;
        this.ticksElapsed = 0;
    }

  public void run() {
    if (this.ticksElapsed < this.duration)
      {
        if (this.target.isValid())
          {
            if (!this.target.isDead()) {
              if (this.ticksElapsed % 20 == 0) {
                this.target.damage(this.damageAmount);
                this.target.getWorld().playSound(this.target.getLocation(), HIT_SOUND, 2.0F, 0.8F);
              } 

              this.target.getWorld().spawnParticle(Particle.ITEM, this.target.getLocation().add(0.0D, 1.0D, 0.0D), 10, 0.3D, 0.5D, 0.3D, 0.0D, new ItemStack(Material.REDSTONE_BLOCK));
              this.ticksElapsed++;
              return;
            } 
            cancel();
            return;
          }  
      }  

    cancel();
  }


}
