package net.kingscraft.zenixmc.altarsmp.weapon.paladin;

import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;

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
          BossBarManager.createBar(this.player, "Stalwart Absorption", PaladinEarthAbility.STALWART_ABSORPTION_COOLDOWN, NamedTextColor.YELLOW);
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
          if (entity instanceof LivingEntity livingEntity) {
            {
              if (livingEntity == this.player)
                continue; 
            }
            int k = PaladinEarthAbility.absorptionDamage.getOrDefault(this.player.getUniqueId(), 1) / j;
            livingEntity.damage(k);
            livingEntity.getWorld().strikeLightningEffect(livingEntity.getLocation());
          } 
        } 
        PaladinEarthAbility.absorptionDamage.remove(this.player.getUniqueId());
        cancel();
        return;
      } 
    }int i = PaladinEarthAbility.absorptionDamage.getOrDefault(this.player.getUniqueId(), 0);
    try {
      this.damageDisplay.text(Component.text().append(Component.text(i + " ", NamedTextColor.GOLD)).append(Component.text("❤", NamedTextColor.RED)).build());
    } catch (Throwable t) {
      this.damageDisplay.text(Component.text(i + " ", NamedTextColor.GOLD).append(Component.text("❤", NamedTextColor.RED)));
    }
    try {
      this.player.sendActionBar(Component.text().append(Component.text("Damage Absorbed: ", NamedTextColor.GOLD)).append(Component.text(String.valueOf(i), NamedTextColor.YELLOW)).build());
    } catch (Throwable t) {
      this.player.sendActionBar(Component.text("Damage Absorbed: ", NamedTextColor.GOLD).append(Component.text(i, NamedTextColor.YELLOW)));
    }
    this.ticks++;
  }



}
