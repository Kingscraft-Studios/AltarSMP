package net.kingscraft.zenixmc.altarsmp.weapon.cutlass;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.util.CombatEffectUtils;

class CutlassAttackTask extends BukkitRunnable {
  final double MAX_TICKS = 20.0D;

  public int ticks;

  public final Player player;

  public final int tickInterval;

  private static final String CUTLASS_DAMAGE_CONFIG_KEY = "cutlassCutDamage";

  public CutlassAttackTask(Player paramPlayer, int paramInt) {
        this.player = paramPlayer;
        this.tickInterval = paramInt;
        this.ticks = 0;
    }

  public void run() {
    if (this.ticks >= 20.0D) {
      this.player.getWorld().playSound((Entity)this.player, Sound.ENTITY_BREEZE_CHARGE, 1.0F, 1.0F);
      CutlassAbility.startCutlassParry(this.player);
      cancel();
      return;
    } 

    LivingEntity livingEntity = CutlassAbility.findTargetEntity((LivingEntity)this.player, 3.0D);
    if (this.ticks % 4 == 0)
      CombatEffectUtils.spawnDualParticleRings((LivingEntity)this.player, Particle.ELECTRIC_SPARK, Particle.CRIT, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 2.0F);

    if (livingEntity != null) {
      livingEntity.setNoDamageTicks(0);
      livingEntity.damage(AltarSMP.getInstance().getConfig().getDouble(CUTLASS_DAMAGE_CONFIG_KEY, 12.0D) / 4.0D, (Entity)this.player);
    } 

    this.player.swingMainHand();
    this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1.0F, 2.0F);
    this.ticks += this.tickInterval;
  }


}
