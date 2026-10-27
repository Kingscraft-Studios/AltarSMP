package net.kingscraft.zenixmc.altarsmp.altarS2.weapon.omen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public final class OmenAbility {
  private static final String VAULT_COOLDOWN_KEY = "omen_vault_omen";
  private static final String CONJURING_COOLDOWN_KEY = "omen_ominous_conjuring";
  private static final double LEVEL_RADIUS = 16.0;
  static final double PROJECTILE_SPEED = 1.8;
  static final double PROJECTILE_HIT_RADIUS = 1.15;
  private static final double PROJECTILE_AOE_RADIUS = 3.5;
  private static final double PROJECTILE_LEVEL_RANGE_BONUS = 5.0;
  static final double BOLT_SPEED = 1.1;
  private static final int PROJECTILE_ITEM_COOLDOWN = 12;

  static final Map<UUID, OmenZoneTask> ACTIVE_ZONES = new HashMap<>();
  static final Map<UUID, OmenTetherTask> ACTIVE_TETHERS = new HashMap<>();
  static final Map<UUID, Long> CONJURING_BUFFS = new HashMap<>();
  static final Map<UUID, OmenConjuringBuffTask> BUFF_TASKS = new HashMap<>();
  static final Map<UUID, Long> LAST_PROJECTILE = new HashMap<>();

  private OmenAbility() {
  }

  public static boolean vaultOmen(Player player) {
    if (player == null || !player.isOnline()) {
      return false;
    }
    UUID playerId = player.getUniqueId();
    if (CooldownManager.isOnCooldown(playerId, VAULT_COOLDOWN_KEY)) {
      denySound(player);
      return true;
    }
    int cooldown = AltarSMP.getInstance().getConfig().getInt("omen.vault_omen_cooldown", 35);
    CooldownManager.setCooldown(playerId, VAULT_COOLDOWN_KEY, cooldown);
    BossBarManager.createBar(player, "Vault Omen", cooldown, NamedTextColor.GREEN);
    Vector direction = player.getEyeLocation().getDirection().normalize();
    Location start = player.getLocation().clone().add(0.0, 1.0, 0.0).add(direction.clone().multiply(0.45));
    double range = AltarSMP.getInstance().getConfig().getInt("omen.vault_omen_length", 30);
    Location end = traceVaultEnd(player.getWorld(), start, direction, range);
    player.getWorld().playSound(start, Sound.BLOCK_VAULT_ACTIVATE, 0.9F, 1.25F);
    if (start.distanceSquared(end) <= 0.0025) {
      onVaultImpact(playerId, end);
    } else {
      new OmenVaultBoltTask(playerId, start, end).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
    }
    return true;
  }

  public static boolean ominousConjuring(Player player) {
    if (player == null || !player.isOnline()) {
      return false;
    }
    UUID playerId = player.getUniqueId();
    if (CooldownManager.isOnCooldown(playerId, CONJURING_COOLDOWN_KEY)) {
      denySound(player);
      return true;
    }
    int cooldown = AltarSMP.getInstance().getConfig().getInt("omen.ominous_conjuring_cooldown", 50);
    CooldownManager.setCooldown(playerId, CONJURING_COOLDOWN_KEY, cooldown);
    BossBarManager.createBar(player, "Ominous Conjuring", cooldown, NamedTextColor.GREEN);
    int durationTicks = AltarSMP.getInstance().getConfig().getInt("omen.ominous_conjuring_duration", 10) * 20;
    long expiry = System.currentTimeMillis() + durationTicks * 50L;
    CONJURING_BUFFS.put(playerId, expiry);
    LAST_PROJECTILE.remove(playerId);
    OmenConjuringBuffTask previous = BUFF_TASKS.remove(playerId);
    if (previous != null) {
      previous.cancel();
    }
    OmenConjuringBuffTask task = new OmenConjuringBuffTask(playerId, expiry);
    BUFF_TASKS.put(playerId, task);
    task.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
    World world = player.getWorld();
    Location location = player.getLocation();
    world.playSound(location, Sound.BLOCK_TRIAL_SPAWNER_AMBIENT_OMINOUS, 1.0F, 0.7F);
    world.spawnParticle(Particle.SOUL_FIRE_FLAME, location.clone().add(0.0, 1.0, 0.0), 35, 0.65, 0.65, 0.65, 0.12);
    OmenParticles.ambientEndRod(world, location);
    OmenParticles.casterRing(world, player);
    return true;
  }

  static void handleSwing(Player player) {
    UUID playerId = player.getUniqueId();
    long now = System.currentTimeMillis();
    if (!holdsOmen(player)) {
      return;
    }
    if (CONJURING_BUFFS.getOrDefault(playerId, 0L) <= now) {
      return;
    }
    if (player.getAttackCooldown() < 0.9F) {
      return;
    }
    double interval = AltarSMP.getInstance().getConfig().getDouble("omen.ominous_conjuring_attack_cooldown", 0.5) * 1000.0;
    if (now - LAST_PROJECTILE.getOrDefault(playerId, 0L) < interval) {
      return;
    }
    LAST_PROJECTILE.put(playerId, now);
    ItemStack weapon = resolveOmenItem(player);
    if (weapon != null) {
      player.setCooldown(weapon.getType(), PROJECTILE_ITEM_COOLDOWN);
    }
    int level = spellLevel(player);
    World world = player.getWorld();
    Location origin = player.getEyeLocation().clone().add(0.0, -0.7, 0.0);
    Vector direction = player.getEyeLocation().getDirection().normalize();
    double range = AltarSMP.getInstance().getConfig().getInt("omen.ominous_conjuring_length", 12) + level * PROJECTILE_LEVEL_RANGE_BONUS;
    world.playSound(origin, Sound.BLOCK_TRIAL_SPAWNER_OMINOUS_ACTIVATE, 1.0F, 1.0F);
    new OmenConjuringProjectileTask(playerId, origin, direction, range, level).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  static void cleanup(UUID playerId) {
    OmenZoneTask zone = ACTIVE_ZONES.get(playerId);
    if (zone != null) {
      zone.stop(true);
    }
    for (OmenTetherTask tether : new ArrayList<>(ACTIVE_TETHERS.values())) {
      if (tether.involves(playerId)) {
        tether.stop();
      }
    }
    endConjuring(playerId);
    LAST_PROJECTILE.remove(playerId);
  }

  static void endConjuring(UUID playerId) {
    CONJURING_BUFFS.remove(playerId);
    OmenConjuringBuffTask task = BUFF_TASKS.remove(playerId);
    if (task != null) {
      task.cancel();
    }
  }

  static void endTethersForCaster(UUID casterId) {
    for (OmenTetherTask tether : new ArrayList<>(ACTIVE_TETHERS.values())) {
      if (tether.getCasterId().equals(casterId)) {
        tether.stop();
      }
    }
  }

  static void onVaultImpact(UUID casterId, Location impact) {
    World world = impact.getWorld();
    if (world == null) {
      return;
    }
    OmenParticles.vaultImpact(world, impact);
    world.playSound(impact, Sound.BLOCK_TRIAL_SPAWNER_SPAWN_MOB, 1.1F, 0.75F);
    Player caster = Bukkit.getPlayer(casterId);
    if (caster != null && !WorldGuardHook.isBlocked(impact)) {
      double damage = AltarSMP.getInstance().getConfig().getDouble("omen.vault_omen_impact_damage", 4.0);
      double radius = AltarSMP.getInstance().getConfig().getDouble("omen.vault_omen_impact_radius", 2.25);
      double radiusSquared = radius * radius;
      for (Entity entity : world.getNearbyEntities(impact, radius, radius, radius)) {
        if (entity instanceof LivingEntity living && !entity.equals(caster) && living.getLocation().distanceSquared(impact) <= radiusSquared) {
          TrueDamage.apply(living, damage, caster);
        }
      }
    }
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> startZone(casterId, impact.clone()), 2L);
  }

  static void startZone(UUID casterId, Location center) {
    Player caster = Bukkit.getPlayer(casterId);
    if (caster == null || !caster.isOnline() || caster.isDead()) {
      return;
    }
    OmenZoneTask previous = ACTIVE_ZONES.remove(casterId);
    if (previous != null) {
      previous.stop(true);
    }
    int durationTicks = AltarSMP.getInstance().getConfig().getInt("omen.vault_omen_duration", 7) * 20;
    double radius = AltarSMP.getInstance().getConfig().getInt("omen.vault_omen_radius", 3);
    OmenZoneTask task = new OmenZoneTask(casterId, center.clone(), radius, durationTicks, !WorldGuardHook.isBlocked(center));
    ACTIVE_ZONES.put(casterId, task);
    task.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  static void startTether(UUID casterId, Player target, Location center, double radius, int ticks) {
    Player caster = Bukkit.getPlayer(casterId);
    if (caster == null || !caster.isOnline()) {
      return;
    }
    OmenTetherTask existing = ACTIVE_TETHERS.get(target.getUniqueId());
    if (existing != null) {
      existing.stop();
    }
    double damage = AltarSMP.getInstance().getConfig().getDouble("omen.vault_omen_tether_damage", 4.0);
    TrueDamage.apply(target, damage, caster);
    int seconds = Math.max(1, (ticks + 19) / 20);
    BossBarManager.createBar(caster, "Tethering", seconds, NamedTextColor.YELLOW);
    String targetTitle = LegacyComponentSerializer.legacySection().serialize(Component.text()
        .append(Component.text("!! TETHERED ", NamedTextColor.RED))
        .append(Component.text("| ", NamedTextColor.GRAY))
        .append(Component.text(seconds + "s ", NamedTextColor.WHITE))
        .append(Component.text("!!", NamedTextColor.RED))
        .build());
    BossBarManager.createBar(target, targetTitle, seconds, NamedTextColor.RED);
    OmenTetherTask task = new OmenTetherTask(casterId, target.getUniqueId(), center.clone(), radius, ticks, targetTitle);
    ACTIVE_TETHERS.put(target.getUniqueId(), task);
    task.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  static void pullToward(Player target, Location center, double radius) {
    Location targetLocation = target.getLocation();
    Vector offset = targetLocation.toVector().subtract(center.toVector());
    offset.setY(0.0);
    double distance = offset.length();
    if (distance <= 0.05) {
      return;
    }
    double inner = radius * 0.45;
    if (distance <= inner) {
      return;
    }
    Vector pull = center.toVector().subtract(targetLocation.toVector());
    pull.setY(0.0);
    if (pull.lengthSquared() < 0.001) {
      return;
    }
    double weight = Math.min(1.0, (distance - inner) / Math.max(0.01, radius - inner));
    pull.normalize().multiply(0.22 * (0.35 + 0.65 * weight));
    Vector velocity = target.getVelocity().clone();
    velocity.setX(velocity.getX() * 0.55 + pull.getX());
    velocity.setZ(velocity.getZ() * 0.55 + pull.getZ());
    velocity.setY(Math.clamp(velocity.getY(), 0.0, 0.12));
    target.setVelocity(velocity);
  }

  static void onConjuringImpact(Location impact, Player caster, LivingEntity directHit, int level) {
    World world = impact.getWorld();
    if (world == null) {
      return;
    }
    world.spawnParticle(Particle.SOUL_FIRE_FLAME, impact, 25, 0.45, 0.45, 0.45, 0.1);
    double damage = AltarSMP.getInstance().getConfig().getDouble("omen.ominous_conjuring_damage", 4.0);
    boolean bypass = level >= 2;
    if (!WorldGuardHook.isBlocked(impact)) {
      if (directHit != null && !directHit.equals(caster)) {
        boolean blocked = directHit instanceof Player target && target.isBlocking() && !bypass;
        if (!blocked) {
          if (bypass && directHit instanceof Player shieldHolder && shieldHolder.isBlocking()) {
            shieldHolder.setCooldown(Material.SHIELD, 100);
          }
          TrueDamage.apply(directHit, damage, caster, bypass);
        }
      }
      double radiusSquared = PROJECTILE_AOE_RADIUS * PROJECTILE_AOE_RADIUS;
      for (Entity entity : world.getNearbyEntities(impact, PROJECTILE_AOE_RADIUS, PROJECTILE_AOE_RADIUS, PROJECTILE_AOE_RADIUS)) {
        if (entity instanceof LivingEntity living && !entity.equals(caster) && !entity.equals(directHit) && living.getLocation().distanceSquared(impact) <= radiusSquared) {
          TrueDamage.apply(living, damage, caster, bypass);
        }
      }
    }
    if (directHit != null) {
      world.playSound(impact, Sound.BLOCK_TRIAL_SPAWNER_SPAWN_MOB, 2.0F, 1.0F);
      int speedTicks = (int)(AltarSMP.getInstance().getConfig().getDouble("omen.ominous_conjuring_speed_duration", 1.1) * 20.0);
      caster.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, speedTicks, 1, true, false, false));
      if (level >= 3 && !caster.isSneaking()) {
        Vector pull = directHit.getLocation().toVector().subtract(caster.getLocation().toVector());
        if (pull.lengthSquared() > 0.001) {
          pull.normalize().multiply(1.3);
          pull.setY(0.35);
          caster.setVelocity(pull);
        }
      }
    }
  }

  static LivingEntity traceEntities(World world, Player caster, Location from, Location to) {
    Vector difference = to.toVector().subtract(from.toVector());
    double length = difference.length();
    if (length <= 0.01) {
      return null;
    }
    Vector direction = difference.clone().normalize();
    Location middle = from.clone().add(difference.clone().multiply(0.5));
    double searchRadius = Math.max(OmenAbility.PROJECTILE_HIT_RADIUS + 1.0, length * 0.5 + OmenAbility.PROJECTILE_HIT_RADIUS + 0.5);
    double radiusSquared = OmenAbility.PROJECTILE_HIT_RADIUS * OmenAbility.PROJECTILE_HIT_RADIUS;
    LivingEntity closest = null;
    double closestProjection = Double.MAX_VALUE;
    for (Entity entity : world.getNearbyEntities(middle, searchRadius, searchRadius + 1.5, searchRadius)) {
      if (!(entity instanceof LivingEntity living) || entity.equals(caster) || !living.isValid() || living.isDead()) {
        continue;
      }
      Location center = living.getLocation().add(0.0, living.getHeight() * 0.55, 0.0);
      double projection = center.toVector().subtract(from.toVector()).dot(direction);
      if (projection >= -OmenAbility.PROJECTILE_HIT_RADIUS && projection <= length + OmenAbility.PROJECTILE_HIT_RADIUS && pointSegmentDistanceSquared(center, from, to) <= radiusSquared && projection < closestProjection) {
        closestProjection = projection;
        closest = living;
      }
    }
    return closest;
  }

  static Location traceBlocks(Location from, Location to) {
    Vector difference = to.toVector().subtract(from.toVector());
    double length = difference.length();
    if (length <= 0.01) {
      return null;
    }
    double increment = 0.12;
    Vector step = difference.clone().normalize().multiply(increment);
    Location location = from.clone();
    for (double traveled = 0.0; traveled <= length; traveled += increment) {
      if (isSolid(location.getBlock())) {
        return location.clone();
      }
      location.add(step);
    }
    return isSolid(to.getBlock()) ? to.clone() : null;
  }

  private static boolean isSolid(Block block) {
    if (block == null) {
      return false;
    }
    if (block.getType().isAir() || block.isLiquid()) {
      return false;
    }
    return !block.isPassable();
  }

  private static double pointSegmentDistanceSquared(Location point, Location start, Location end) {
    Vector segment = end.toVector().subtract(start.toVector());
    double lengthSquared = segment.lengthSquared();
    if (lengthSquared <= 1.0E-4) {
      return point.distanceSquared(start);
    }
    double projection = point.toVector().subtract(start.toVector()).dot(segment) / lengthSquared;
    projection = Math.clamp(projection, 0.0, 1.0);
    Location closest = start.clone().add(segment.multiply(projection));
    return point.distanceSquared(closest);
  }

  private static Location traceVaultEnd(World world, Location start, Vector direction, double range) {
    RayTraceResult result = world.rayTraceBlocks(start, direction, range, FluidCollisionMode.NEVER, true);
    if (result != null) {
        result.getHitPosition();
        return result.getHitPosition().toLocation(world).add(direction.clone().multiply(-0.08));
    }
    return start.clone().add(direction.clone().multiply(range));
  }

  private static int spellLevel(Player player) {
    long nearby = player.getWorld().getNearbyEntities(player.getLocation(), LEVEL_RADIUS, LEVEL_RADIUS, LEVEL_RADIUS).stream()
      .filter(entity -> entity instanceof Player && !entity.equals(player))
      .count();
    if (nearby >= 5) {
      return 3;
    }
    return nearby >= 2 ? 2 : 1;
  }

  private static boolean holdsOmen(Player player) {
    return resolveOmenItem(player) != null;
  }

  private static ItemStack resolveOmenItem(Player player) {
    ItemStack item = player.getInventory().getItemInMainHand();
    if (CustomItem.fromItem(item) == CustomItem.OMEN) {
      return item;
    }
    item = player.getInventory().getItemInOffHand();
    if (CustomItem.fromItem(item) == CustomItem.OMEN) {
      return item;
    }
    return null;
  }

  private static void denySound(Player player) {
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
  }
}
