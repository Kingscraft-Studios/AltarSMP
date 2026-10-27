package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
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
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.vampire.VampireListener;

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
      NamespacedKey namespacedKey = new NamespacedKey(VampireListener.plugin, "crimson_bite_" + java.util.UUID.randomUUID());
      AttributeInstance attributeInstance1 = this.victim.getAttribute(Attribute.MAX_HEALTH);
      AttributeModifier attributeModifier1 = new AttributeModifier(namespacedKey, -this.healthSteal, AttributeModifier.Operation.ADD_NUMBER);
      attributeInstance1.addModifier(attributeModifier1);
      AttributeInstance attributeInstance2 = this.attacker.getAttribute(Attribute.MAX_HEALTH);
      AttributeModifier attributeModifier2 = new AttributeModifier(namespacedKey, this.healthSteal, AttributeModifier.Operation.ADD_NUMBER);
      attributeInstance2.addModifier(attributeModifier2);
      if (this.victim instanceof Player player) {
          BossBarManager.createBar(player, LegacyComponentSerializer.legacySection().serialize(Component.text()
            .append(Component.text("!! ", NamedTextColor.DARK_RED))
            .append(Component.text("BITTEN ", NamedTextColor.RED))
            .append(Component.text("!!", NamedTextColor.DARK_RED))
            .build()), this.durationSeconds, NamedTextColor.RED, BarColor.RED);
      } 
      (new CrimsonBiteModifierTask(this, attributeInstance1, attributeModifier1, attributeInstance2, attributeModifier2)).runTaskLater(VampireListener.plugin, this.durationSeconds * 20L);
      this.victim.getWorld().playSound(this.victim.getLocation(), Sound.BLOCK_SWEET_BERRY_BUSH_BREAK, 1.0F, 1.0F);
      this.victim.getWorld().spawnParticle(Particle.BLOCK, this.victim.getLocation().add(0.0D, 1.0D, 0.0D), 50, 0.5D, 0.8D, 0.5D, 0.1D, Material.REDSTONE_BLOCK.createBlockData());
      Particle.DustOptions dustOptions = new Particle.DustOptions(Color.RED, 2.0F);
      this.victim.getWorld().spawnParticle(Particle.DUST, this.victim.getLocation().add(0.0D, 1.0D, 0.0D), 30, 0.3D, 0.5D, 0.3D, 0.1D, dustOptions);
    } 
    CooldownManager.setCooldown(this.attacker.getUniqueId(), "crimsonBite", this.cooldownSeconds);
    BossBarManager.createBar(this.attacker, "Crimson Bite", this.cooldownSeconds, NamedTextColor.YELLOW);
  }


}
