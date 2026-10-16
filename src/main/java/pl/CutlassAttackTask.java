package pl;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class CutlassAttackTask extends BukkitRunnable {
  final double MAX_TICKS = 20.0D;
  
  int ticks;
  
  final Player player;
  
  final int tickInterval;
  
  private static final String CUTLASS_DAMAGE_CONFIG_KEY = "cutlassCutDamage";
  
  CutlassAttackTask(Player paramPlayer, int paramInt) {
        this.player = paramPlayer;
        this.tickInterval = paramInt;
        this.ticks = 0;
    }
  
  public void run() {
    try {
      if (this.ticks >= 20.0D) {
        this.player.getWorld().playSound((Entity)this.player, Sound.ENTITY_BREEZE_CHARGE, 1.0F, 1.0F);
        CutlassAbility.startCutlassParry(this.player);
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    LivingEntity livingEntity = CutlassAbility.findTargetEntity((LivingEntity)this.player, 3.0D);
    try {
      if (this.ticks % 4 == 0)
        CombatEffectUtils.spawnDualParticleRings((LivingEntity)this.player, Particle.ELECTRIC_SPARK, Particle.CRIT, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 2.0F);
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (livingEntity != null) {
        livingEntity.setNoDamageTicks(0);
        livingEntity.damage(Main.getInstance().getConfig().getDouble(CUTLASS_DAMAGE_CONFIG_KEY, 12.0D) / 4.0D, (Entity)this.player);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.player.swingMainHand();
    this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_CRIT, 1.0F, 2.0F);
    this.ticks += this.tickInterval;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d6.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */