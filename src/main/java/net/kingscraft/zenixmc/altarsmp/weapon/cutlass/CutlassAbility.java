package net.kingscraft.zenixmc.altarsmp.weapon.cutlass;

import java.util.HashMap;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.util.CombatEffectUtils;

public class CutlassAbility implements Listener {
  public static String cutsCooldownKey;

  public static String parryCooldownKey;

  public static HashMap<UUID, Integer> parryHits;

  @EventHandler
  public void onCutlassDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    {
      if (!isCutlass(player))
        return; 
    }{
      if (CooldownManager.isOnCooldown(player.getUniqueId(), "cutlassCuts"))
        return; 
    }
      CombatEffectUtils.spawnDualParticleRings(player, Particle.ELECTRIC_SPARK, Particle.CRIT, Sound.ENTITY_PLAYER_ATTACK_SWEEP, 2.0F);
  }

  public static boolean isCutlass(Player paramPlayer) {
    {
      return AltarSMP.areSimilar(paramPlayer.getInventory().getItemInMainHand(), CustomItem.CUTLASS.getItem());
    }
  }

  @EventHandler
  public static void onParryDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    LivingEntity livingEntity;
    Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
    if (entity1 instanceof LivingEntity) {
      livingEntity = (LivingEntity)entity1;
    } else {
      return;
    } 
    Entity entity2 = paramEntityDamageByEntityEvent.getEntity();
    if (entity2 instanceof Player player) {
      if (CooldownManager.isOnCooldown(player.getUniqueId(), "active_parry")) {
        int i = AltarSMP.getInstance().getConfig().getInt("CutlassParryDuration", 7);
        parryHits.put(player.getUniqueId(), parryHits.getOrDefault(player.getUniqueId(), 3) - 1);
        int j = parryHits.getOrDefault(player.getUniqueId(), 3);
        {
          if (j != 0)
            BossBarManager.createBar(player, LegacyComponentSerializer.legacySection().serialize(Component.text()
                .append(Component.text("!! ", NamedTextColor.GOLD, TextDecoration.BOLD))
                .append(Component.text("Parry x" + j + " ", NamedTextColor.YELLOW, TextDecoration.BOLD))
                .append(Component.text("!!", NamedTextColor.GOLD, TextDecoration.BOLD))
                .build()), i, NamedTextColor.YELLOW, BarColor.RED);
        }{
          paramEntityDamageByEntityEvent.setCancelled(true);
          player.getWorld().playSound(player, Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
          livingEntity.setVelocity(player.getLocation().getDirection().multiply(0.5D));
          if (j == 0) {
            parryHits.remove(player.getUniqueId());
            activateParry(player);
          } 
        }} 
    } 
  }

  public static void activateParry(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("CutlassParryCooldown", 30);
    clearParryBars(paramPlayer);
    BossBarManager.createBar(paramPlayer, LegacyComponentSerializer.legacySection().serialize(
        Component.text("Parry", NamedTextColor.YELLOW, TextDecoration.BOLD)), i, NamedTextColor.YELLOW);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "active_parry", 0.0D);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), parryCooldownKey, i);
  }

  public static void clearParryBars(Player paramPlayer) {
    BossBarManager.removeBar(paramPlayer, "!! Parry x3 !!");
    BossBarManager.removeBar(paramPlayer, "!! Parry x2 !!");
    BossBarManager.removeBar(paramPlayer, "!! Parry x1 !!");
  }

  public static void startCutlassAttack(Player paramPlayer) {
    int b = 2;
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "cutlassCuts", 1.0D);
    (new CutlassAttackTask(paramPlayer, b)).runTaskTimer(AltarSMP.getInstance(), 0L, b);
  }

  public static void startCutlassParry(Player paramPlayer) {
    (new CutlassParryLaunchTask(paramPlayer)).runTaskLater(AltarSMP.getInstance(), 10L);
  }

  public static LivingEntity findTargetEntity(LivingEntity paramLivingEntity, double paramDouble) {
    LivingEntity livingEntity = null;
    double d = Double.MAX_VALUE;
    Location location = paramLivingEntity.getLocation().clone().add(0.0D, 1.0D, 0.0D).add(paramLivingEntity.getLocation().getDirection().clone().normalize().multiply(paramDouble));
    for (Entity entity : location.getNearbyEntities(paramDouble, paramDouble, paramDouble)) {
      if (entity instanceof LivingEntity livingEntity1) {
          {
          if (livingEntity1.equals(paramLivingEntity))
            continue; 
        }{
          if (paramLivingEntity.getWorld() != livingEntity1.getWorld())
            continue; 
        }double d1 = paramLivingEntity.getLocation().distance(livingEntity1.getLocation());
        if (d1 < d) {
          d = d1;
          livingEntity = livingEntity1;
        } 
      } 
    } 
    return livingEntity;
  }

  static {
    cutsCooldownKey = "cuts";
    parryCooldownKey = "parry";
    parryHits = new HashMap<>();
  }

}
