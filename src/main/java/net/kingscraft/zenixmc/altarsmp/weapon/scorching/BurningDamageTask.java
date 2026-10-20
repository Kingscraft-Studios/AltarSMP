package net.kingscraft.zenixmc.altarsmp.weapon.scorching;

import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class BurningDamageTask extends BukkitRunnable {
  public int ticks;

  public final int durationSeconds;

  public final LivingEntity target;

  public final int damage;

  public final Player attacker;

  public BurningDamageTask(int paramInt1, LivingEntity paramLivingEntity, int paramInt2, Player paramPlayer) {
        this.durationSeconds = paramInt1;
        this.target = paramLivingEntity;
        this.damage = paramInt2;
        this.attacker = paramPlayer;
        this.ticks = 0;
    }

  public void run() {
    if (this.ticks >= this.durationSeconds * 20) {
      this.target.setVisualFire(false);
      cancel();
      return;
    } 

    this.target.setVisualFire(true);
    if (this.ticks % 20 == 0) {
      TrueDamage.apply(this.target, this.damage, this.attacker);
      if (this.target instanceof Player) {
        Player player = (Player)this.target;
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_HURT_ON_FIRE, 1.0F, 1.0F);
      } 
    } 

    this.ticks++;
  }

}
