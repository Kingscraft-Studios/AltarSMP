package net.kingscraft.zenixmc.altarsmp.vampire;

import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class BatTransformationTask extends BukkitRunnable {
  public int ticks;

  public final int totalTicks;

  public final int durationSeconds;

  public final Player player;

  public final List<Bat> bats;

  public final Map<Bat, Vector> batOffsets;

  public final double speed;

  public final int damage;


  public BatTransformationTask(int paramInt1, Player paramPlayer, List<Bat> paramList, Map<Bat, Vector> paramMap, double paramDouble, int paramInt2) {
        this.durationSeconds = paramInt1;
        this.totalTicks = this.durationSeconds * 20;
        this.player = paramPlayer;
        this.bats = paramList;
        this.batOffsets = paramMap;
        this.speed = paramDouble;
        this.damage = paramInt2;
        this.ticks = 0;
    }

  public void run() {
    {
      if (!this.player.isOnline() || this.ticks >= this.totalTicks) {
        for (Bat bat : this.bats)
          bat.remove(); 
        for (Player player : Bukkit.getOnlinePlayers())
          player.showPlayer(AltarSMP.getInstance(), this.player);
        this.bats.clear();
        this.batOffsets.clear();
        VampireListener.transformedPlayers.remove(this.player.getUniqueId());
        cancel();
        return;
      } 
    }
    Vector vector = this.player.getLocation().getDirection().clone().multiply(this.speed);
    for (Bat bat : this.bats) {
      Vector vector1 = this.batOffsets.get(bat);
      double d1 = Math.sin((this.ticks + bat.getEntityId()) * 0.2D) * 0.2D;
      double d2 = Math.cos((this.ticks + bat.getEntityId()) * 0.25D) * 0.15D;
      double d3 = Math.sin((this.ticks + bat.getEntityId()) * 0.18D) * 0.2D;
      {
        bat.teleport(this.player.getLocation().clone().add(vector1).add(d1, d2, d3));
      }
      bat.setAwake((this.ticks % 10 < 5));
    } 
    {
      if (this.ticks % 10 == 0)
        this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_BAT_TAKEOFF, 1.0F, 1.0F);
    }
    vector.setY(vector.getY() * 0.5D + 0.1D);
    this.player.setVelocity(vector);
    this.player.getWorld().spawnParticle(Particle.DUST, this.player.getLocation().clone().subtract(0.0D, 0.3D, 0.0D), 15, 0.4D, 0.2D, 0.4D, 0.01D, new Particle.DustOptions(Color.BLACK, 1.5F));
    for (Entity entity : this.player.getNearbyEntities(2.0D, 2.0D, 2.0D)) {
      if (entity instanceof LivingEntity livingEntity) {
          if (entity instanceof Bat bat) {
            {
            if (this.bats.contains(bat))
              continue; 
            }
          }
        {
          if (this.player == livingEntity)
            continue; 
        }
        {
          if (AltarSMP.isTrusted(this.player, livingEntity))
            continue; 
        }
        {
          if (CooldownManager.isOnCooldown(livingEntity.getUniqueId(), "damageNightpiercer"))
            continue; 
        }
        CooldownManager.setCooldown(livingEntity.getUniqueId(), "damageNightpiercer", 1.0D);
        this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 1.0F);
        TrueDamage.apply(livingEntity, this.damage, this.player);
      } 
    } 
    this.ticks++;
  }


}
