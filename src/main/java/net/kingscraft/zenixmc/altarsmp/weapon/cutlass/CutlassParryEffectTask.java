package net.kingscraft.zenixmc.altarsmp.weapon.cutlass;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;

class CutlassParryEffectTask extends BukkitRunnable {

  public int ticks;

  public final CutlassParryLaunchTask parryTask;

  public CutlassParryEffectTask(CutlassParryLaunchTask cutlassParryLaunchTask) {
        this.parryTask = cutlassParryLaunchTask;
        this.ticks = 0;
    }

  public void run() {
    {
      if (this.ticks < 40) {
        {
          if (this.ticks >= 4)
            {
              if (this.parryTask.player.isOnGround()) {
                this.parryTask.player.getWorld().playSound(this.parryTask.player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
                cancel();
                return;
              } 
            }}this.parryTask.player.spawnParticle(Particle.ELECTRIC_SPARK, this.parryTask.player.getLocation(), 0);
        for (Entity entity : this.parryTask.player.getLocation().getNearbyEntities(3.0D, 3.0D, 3.0D)) {
          if (entity instanceof LivingEntity livingEntity) {
              {
              if (CooldownManager.isOnCooldown(livingEntity.getUniqueId(), "already_hit_cutlass"))
                continue; 
            }{
              if (livingEntity.equals(this.parryTask.player))
                continue; 
            }livingEntity.setNoDamageTicks(0);
            livingEntity.damage(2.0D);
            CooldownManager.setCooldown(livingEntity.getUniqueId(), "already_hit_cutlass", 2.0D);
            livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 60, 1));
          } 
        } 
        this.ticks++;
        return;
      } 
    }this.parryTask.player.getWorld().playSound(this.parryTask.player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 1.0F, 1.0F);
    cancel();
  }



}
