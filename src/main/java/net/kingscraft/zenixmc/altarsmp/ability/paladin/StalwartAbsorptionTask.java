package net.kingscraft.zenixmc.altarsmp.ability.paladin;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;

public class StalwartAbsorptionTask extends BukkitRunnable {
  public int ticks;

  public final Player player;

  public final TextDisplay damageDisplay;


  public StalwartAbsorptionTask(Player paramPlayer, TextDisplay paramTextDisplay) {
        this.player = paramPlayer;
        this.damageDisplay = paramTextDisplay;
        this.ticks = 0;
    }

  public void run() {
    {
      if (this.ticks >= PaladinEarthAbility.STALWART_ABSORPTION_DURATION * 20) {
        {
          BossBarManager.createBar(this.player, "Stalwart Absorption", PaladinEarthAbility.STALWART_ABSORPTION_COOLDOWN, ChatColor.YELLOW);
          CooldownManager.setCooldown(this.player.getUniqueId(), PaladinEarthAbility.STALWART_ABSORPTION_COOLDOWN_KEY, PaladinEarthAbility.STALWART_ABSORPTION_COOLDOWN);
          this.damageDisplay.remove();
          if (this.player.getGameMode() == GameMode.SPECTATOR)
            return; 
        }int j = AltarSMP.getInstance().getConfig().getInt("stalwartAbsorptionNerf", 1);
        for (Entity entity : this.player.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
          this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
          this.player.getWorld().playSound(this.player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
          this.player.getWorld().spawnParticle(Particle.FIREWORK, this.player.getLocation(), 40, 0.0D, 0.0D, 0.0D, 0.5D);
          this.player.getWorld().spawnParticle(Particle.GUST_EMITTER_LARGE, this.player.getLocation(), 0, 0.0D, 0.0D, 0.0D, 0.0D);
          if (entity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity)entity;
            {
              if (livingEntity == this.player)
                continue; 
            }int k = ((Integer) PaladinEarthAbility.absorptionDamage.getOrDefault(this.player.getUniqueId(), Integer.valueOf(1))).intValue() / j;
            livingEntity.damage(k);
            livingEntity.getWorld().strikeLightningEffect(livingEntity.getLocation());
          } 
        } 
        PaladinEarthAbility.absorptionDamage.remove(this.player.getUniqueId());
        cancel();
        return;
      } 
    }int i = ((Integer) PaladinEarthAbility.absorptionDamage.getOrDefault(this.player.getUniqueId(), Integer.valueOf(0))).intValue();
    this.damageDisplay.setText("§6" + i + " §c❤");
    this.player.sendActionBar("§6Damage Absorbed: §e" + i);
    this.ticks++;
  }



}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ee.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */