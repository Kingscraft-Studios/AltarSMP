package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.vampire.Vampire;

public class CrimsonBiteTask extends BukkitRunnable {
  public final LivingEntity victim;

  public final double healthSteal;

  public final Player attacker;

  public final int durationSeconds;

  public final int cooldownSeconds;


  public CrimsonBiteTask(LivingEntity paramLivingEntity, double paramDouble, Player paramPlayer, int paramInt1, int paramInt2) {
        this.victim = paramLivingEntity;
        this.healthSteal = paramDouble;
        this.attacker = paramPlayer;
        this.durationSeconds = paramInt1;
        this.cooldownSeconds = paramInt2;
    }

  public void run() {
    if (!this.victim.isDead()) {
      NamespacedKey namespacedKey = new NamespacedKey((Plugin) Vampire.plugin, "crimson_bite_" + java.util.UUID.randomUUID());
      AttributeInstance attributeInstance1 = this.victim.getAttribute(Attribute.MAX_HEALTH);
      AttributeModifier attributeModifier1 = new AttributeModifier(namespacedKey, -this.healthSteal, AttributeModifier.Operation.ADD_NUMBER);
      attributeInstance1.addModifier(attributeModifier1);
      AttributeInstance attributeInstance2 = this.attacker.getAttribute(Attribute.MAX_HEALTH);
      AttributeModifier attributeModifier2 = new AttributeModifier(namespacedKey, this.healthSteal, AttributeModifier.Operation.ADD_NUMBER);
      attributeInstance2.addModifier(attributeModifier2);
      if (this.victim instanceof Player) {
        Player player = (Player)this.victim;
        BossBarManager.createBar(player, "§4!! §cBITTEN §4!!", this.durationSeconds, ChatColor.RED, BarColor.RED);
      } 
      (new CrimsonBiteModifierTask(this, attributeInstance1, attributeModifier1, attributeInstance2, attributeModifier2)).runTaskLater((Plugin) Vampire.plugin, this.durationSeconds * 20L);
      this.victim.getWorld().playSound(this.victim.getLocation(), Sound.BLOCK_SWEET_BERRY_BUSH_BREAK, 1.0F, 1.0F);
      this.victim.getWorld().spawnParticle(Particle.BLOCK, this.victim.getLocation().add(0.0D, 1.0D, 0.0D), 50, 0.5D, 0.8D, 0.5D, 0.1D, Material.REDSTONE_BLOCK.createBlockData());
      Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 2.0F);
      this.victim.getWorld().spawnParticle(Particle.DUST, this.victim.getLocation().add(0.0D, 1.0D, 0.0D), 30, 0.3D, 0.5D, 0.3D, 0.1D, dustOptions);
    } 
    CooldownManager.setCooldown(this.attacker.getUniqueId(), "crimsonBite", this.cooldownSeconds);
    BossBarManager.createBar(this.attacker, "Crimson Bite", this.cooldownSeconds, ChatColor.YELLOW);
  }


}
