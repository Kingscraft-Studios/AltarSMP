package net.kingscraft.zenixmc.altarsmp.altars2.ability.dragonrend;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.ItemDisplay.ItemDisplayTransform;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemType;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public final class DragonrendAbility {
  private static final String HYPERSONIC_COOLDOWN_KEY = "dragonrend_hypersonic";

  private static final String VOID_COOLDOWN_KEY = "dragonrend_infinite_void";

  private static final String HYPERSONIC_TITLE = "Hypersonic Slash";

  private static final String VOID_TITLE = "Infinite Void";

  private static final int WINDUP_TICKS = 50;

  private static final int MIN_WINDOW_TICKS = 5;

  private static final double ARC_DOT_THRESHOLD = 0.7D;

  private static final long HIT_SLASH_DEBOUNCE_MS = 250L;

  private static final long CLICK_SLASH_DEBOUNCE_MS = 500L;

  private static final Map<UUID, ArmedState> armed = new HashMap<>();

  private static final Map<UUID, VoidZone> voidZones = new HashMap<>();

  private static final Map<UUID, Integer> arcCounters = new HashMap<>();

  private DragonrendAbility() {
  }

  public static boolean armHypersonic(Player player) {
    if (player == null) {
      return false;
    }
    UUID uuid = player.getUniqueId();
    if (armed.containsKey(uuid)) {
      return true;
    }
    if (CooldownManager.isOnCooldown(uuid, HYPERSONIC_COOLDOWN_KEY)) {
      return true;
    }
    ArmedState state = new ArmedState();
    int duration = Math.max(1, AltarSMP.getInstance().getConfig().getInt("dragonrend.hypersonic_slash_duration", 5));
    state.windowTicks = Math.max(MIN_WINDOW_TICKS, duration * 20);
    armed.put(uuid, state);
    player.getWorld().playSound(player.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_1, 0.7F, 1.6F);
    applyCasterSlow(player, 20);
    state.windupTask = Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      state.windupTask = null;
      Player online = Bukkit.getPlayer(uuid);
      if (online != null && online.isOnline() && holdsWeapon(online)) {
        startWindowTimer(online, state);
      } else {
        disarmQuiet(uuid);
      }
    }, WINDUP_TICKS);
    return true;
  }

  public static boolean infiniteVoid(Player player) {
    if (player == null) {
      return false;
    }
    UUID uuid = player.getUniqueId();
    if (CooldownManager.isOnCooldown(uuid, VOID_COOLDOWN_KEY)) {
      return true;
    }
    if (voidZones.containsKey(uuid)) {
      return true;
    }
    int cooldown = Math.max(1, AltarSMP.getInstance().getConfig().getInt("dragonrend.infinite_void_cooldown", 60));
    CooldownManager.setCooldown(uuid, VOID_COOLDOWN_KEY, cooldown);
    BossBarManager.createBar(player, VOID_TITLE, cooldown, ChatColor.LIGHT_PURPLE);
    int duration = Math.max(1, AltarSMP.getInstance().getConfig().getInt("dragonrend.infinite_void_duration", 10));
    startVoidZone(player, duration * 20);
    return true;
  }

  static boolean holdsWeapon(Player player) {
    CustomItem weapon = CustomItem.fromItem(player.getInventory().getItemInMainHand());
    if (weapon == null) {
      weapon = CustomItem.fromItem(player.getInventory().getItemInOffHand());
    }
    return weapon == CustomItem.DRAGONREND;
  }

  static void tryClickSlash(Player player) {
    ArmedState state = armed.get(player.getUniqueId());
    if (state == null || state.windowTask == null) {
      return;
    }
    if (player.getAttackCooldown() < 0.9F) {
      return;
    }
    LivingEntity target = rayTraceTarget(player);
    if (target == null) {
      return;
    }
    performSlash(player, target, state, CLICK_SLASH_DEBOUNCE_MS);
  }

  static boolean tryHitSlash(Player player, LivingEntity target) {
    ArmedState state = armed.get(player.getUniqueId());
    if (state == null || state.windowTask == null) {
      return false;
    }
    if (player.getAttackCooldown() < 0.9F) {
      return false;
    }
    return performSlash(player, target, state, HIT_SLASH_DEBOUNCE_MS);
  }

  static void playSwingFeedback(Player player) {
    electricArc(player);
    player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_ATTACK_SWEEP, 0.7F, 1.8F);
  }

  static void handleQuit(Player player) {
    UUID uuid = player.getUniqueId();
    disarmQuiet(uuid);
    endVoidZone(uuid);
    arcCounters.remove(uuid);
  }

  private static boolean performSlash(Player caster, LivingEntity target, ArmedState state, long debounceMs) {
    if (WorldGuardHook.isBlocked(target.getLocation())) {
      return false;
    }
    long now = System.currentTimeMillis();
    if (now - state.lastSlashAt < debounceMs) {
      return false;
    }
    state.lastSlashAt = now;
    teleportBehind(caster, target);
    electricArc(caster);
    double damage = AltarSMP.getInstance().getConfig().getDouble("dragonrend.hypersonic-slash_damage", 5.0D);
    target.setNoDamageTicks(0);
    TrueDamage.apply(target, damage, caster);
    target.setNoDamageTicks(0);
    caster.getWorld().playSound(caster.getLocation(), "custom:slash", 2.0F, 2.0F);
    applyCasterSlow(caster, 10);
    state.windowTicks = Math.max(MIN_WINDOW_TICKS, state.windowTicks / 2);
    startWindowTimer(caster, state);
    return true;
  }

  private static void startWindowTimer(Player player, ArmedState state) {
    cancelTask(state.windowTask);
    int ticks = state.windowTicks;
    UUID uuid = player.getUniqueId();
    BossBarManager.createBar(player, HYPERSONIC_TITLE, Math.max(1, ticks / 20), ChatColor.LIGHT_PURPLE);
    state.windowTask = new BukkitRunnable() {
      private int elapsed;

      @Override
      public void run() {
        Player online = Bukkit.getPlayer(uuid);
        if (online == null || !online.isOnline() || !holdsWeapon(online)) {
          cancel();
          endWindow(uuid);
          return;
        }
        this.elapsed++;
        if (this.elapsed >= ticks) {
          cancel();
          endWindow(uuid);
        }
      }
    }.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  private static void endWindow(UUID uuid) {
    ArmedState state = armed.remove(uuid);
    if (state == null) {
      return;
    }
    cancelTask(state.windupTask);
    cancelTask(state.windowTask);
    Player online = Bukkit.getPlayer(uuid);
    if (online != null && online.isOnline()) {
      int cooldown = Math.max(1, AltarSMP.getInstance().getConfig().getInt("dragonrend.hypersonic_slash_cooldown", 40));
      CooldownManager.setCooldown(uuid, HYPERSONIC_COOLDOWN_KEY, cooldown);
      BossBarManager.createBar(online, HYPERSONIC_TITLE, cooldown, ChatColor.LIGHT_PURPLE);
    }
  }

  private static void disarmQuiet(UUID uuid) {
    ArmedState state = armed.remove(uuid);
    if (state == null) {
      return;
    }
    cancelTask(state.windupTask);
    cancelTask(state.windowTask);
    Player online = Bukkit.getPlayer(uuid);
    if (online != null && online.isOnline()) {
      BossBarManager.removeBar(online, HYPERSONIC_TITLE);
    }
  }

  private static void startVoidZone(Player player, int durationTicks) {
    UUID uuid = player.getUniqueId();
    Location base = player.getLocation().clone();
    Location center = base.clone().add(0.0D, player.getHeight() * 0.5D, 0.0D);
    center.setYaw(0.0F);
    center.setPitch(0.0F);
    Location clockLoc = base.clone().add(0.0D, 0.5D, 0.0D);
    clockLoc.setYaw(0.0F);
    clockLoc.setPitch(0.0F);
    playCustom(center, "altar:use", 1.2F, 1.0F);
    ItemDisplay display = spawnClock(clockLoc);
    spawnClockBurst(clockLoc);
    VoidZone zone = new VoidZone(center, display);
    voidZones.put(uuid, zone);
    double radius = AltarSMP.getInstance().getConfig().getDouble("dragonrend.infinite_void_radius", 6.0D);
    int amplifier = Math.max(0, AltarSMP.getInstance().getConfig().getInt("dragonrend.infinite_void_slownewess_strength", 14));
    zone.task = new BukkitRunnable() {
      private int tick;

      @Override
      public void run() {
        Player caster = Bukkit.getPlayer(uuid);
        if (caster == null || !caster.isOnline()) {
          cancel();
          endVoidZone(uuid);
          return;
        }
        this.tick += 5;
        if (this.tick >= durationTicks) {
          cancel();
          endVoidZone(uuid);
          return;
        }
        if (this.tick % 40 == 5) {
          playCustom(center, "altar:tick", 1.2F, 1.0F);
        }
        updateDisplay(display, this.tick);
        orbitParticles(center, radius);
        refreshZoneEffects(caster, zone, radius, amplifier, durationTicks - this.tick);
      }
    }.runTaskTimer(AltarSMP.getInstance(), 0L, 5L);
  }

  private static void endVoidZone(UUID uuid) {
    VoidZone zone = voidZones.remove(uuid);
    if (zone == null) {
      return;
    }
    cancelTask(zone.task);
    for (UUID victimId : zone.affected) {
      Player victim = Bukkit.getPlayer(victimId);
      if (victim != null) {
        BossBarManager.removeBar(victim, "SLOWED");
      }
    }
    zone.affected.clear();
    Location center = zone.center;
    removeGlow(zone.display);
    if (zone.display != null && zone.display.isValid()) {
      zone.display.setInterpolationDuration(8);
      Transformation transformation = zone.display.getTransformation();
      zone.display.setTransformation(new Transformation(transformation.getTranslation(), transformation.getLeftRotation(), new Vector3f(0.0F, 0.0F, 0.0F), transformation.getRightRotation()));
    }
    spawnCollapseBurst(center);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      if (zone.display != null && zone.display.isValid()) {
        zone.display.remove();
      }
      playCustom(center, "altar:use", 1.5F, 1.0F);
    }, 10L);
  }

  private static void refreshZoneEffects(Player caster, VoidZone zone, double radius, int amplifier, int remainingTicks) {
    World world = zone.center.getWorld();
    if (world == null) {
      return;
    }
    Set<UUID> affected = new HashSet<>();
    for (Entity entity : world.getNearbyEntities(zone.center, radius, radius, radius)) {
      if (!(entity instanceof Player victim)) {
        continue;
      }
      if (victim.getLocation().distanceSquared(zone.center) > radius * radius) {
        continue;
      }
      if (victim.equals(caster)) {
        continue;
      }
      if (AltarSMP.isTrusted(caster, victim)) {
        continue;
      }
      if (WorldGuardHook.isBlocked(victim.getLocation())) {
        continue;
      }
      affected.add(victim.getUniqueId());
      victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 40, amplifier, true, false, false));
      victim.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, 40, amplifier, true, false, false));
      victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 40, amplifier, true, false, false));
      if (!zone.affected.contains(victim.getUniqueId())) {
        BossBarManager.createBar(victim, "SLOWED", Math.max(1, remainingTicks / 20 + 1), ChatColor.RED, BarColor.RED);
      }
    }
    for (UUID previous : zone.affected) {
      if (!affected.contains(previous)) {
        Player victim = Bukkit.getPlayer(previous);
        if (victim != null) {
          BossBarManager.removeBar(victim, "SLOWED");
        }
      }
    }
    zone.affected = affected;
  }

  private static ItemDisplay spawnClock(Location location) {
    ItemDisplay display = (ItemDisplay) location.getWorld().spawnEntity(location, EntityType.ITEM_DISPLAY);
    display.setItemStack(CustomItemType.VOID_CLOCK.getItem());
    display.setItemDisplayTransform(ItemDisplayTransform.FIXED);
    display.setGravity(false);
    display.setInvulnerable(true);
    display.setPersistent(false);
    display.setInterpolationDuration(0);
    display.setInterpolationDelay(-1);
    display.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new Quaternionf(0.0F, 0.0F, 0.0F, 1.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Quaternionf(0.0F, 0.0F, 0.0F, 1.0F)));
    addGlow(display);
    return display;
  }

  private static void updateDisplay(ItemDisplay display, int tick) {
    if (display == null || !display.isValid()) {
      return;
    }
    float progress = Math.min(tick / 20.0F, 1.0F);
    float eased = 1.0F - (1.0F - progress) * (1.0F - progress) * (1.0F - progress);
    float scale = 4.0F * eased;
    Quaternionf rotation = new Quaternionf(0.0F, 0.0F, 0.0F, 1.0F);
    if (tick > 22) {
      rotation = rotation.rotateY((float) Math.toRadians(tick * 4.0F));
    }
    display.setInterpolationDuration(0);
    display.setInterpolationDelay(-1);
    display.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), rotation, new Vector3f(scale, scale, scale), new Quaternionf(0.0F, 0.0F, 0.0F, 1.0F)));
  }

  private static void spawnClockBurst(Location location) {
    for (long delay : new long[]{0L, 2L, 4L}) {
      Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> spawnEndRodRing(location), delay);
    }
  }

  private static void spawnEndRodRing(Location location) {
    World world = location.getWorld();
    if (world == null) {
      return;
    }
    Location ring = location.clone().add(0.0D, 0.18D, 0.0D);
    for (int i = 0; i < 72; i++) {
      double angle = (Math.PI * 2.0D) * i / 72.0D;
      Vector velocity = new Vector(Math.cos(angle), 0.0D, Math.sin(angle));
      world.spawnParticle(Particle.END_ROD, ring, 0, velocity.getX() * 0.42D, 0.075D, velocity.getZ() * 0.42D, 1.0D);
    }
  }

  private static void spawnCollapseBurst(Location location) {
    World world = location.getWorld();
    if (world == null) {
      return;
    }
    Location ring = location.clone().add(0.0D, 0.45D, 0.0D);
    for (int i = 0; i < 42; i++) {
      double angle = (Math.PI * 2.0D) * i / 42.0D;
      Vector velocity = new Vector(Math.cos(angle), 0.0D, Math.sin(angle));
      world.spawnParticle(Particle.END_ROD, ring, 0, velocity.getX() * 0.2D, 0.22D, velocity.getZ() * 0.2D, 1.0D);
    }
    world.spawnParticle(Particle.END_ROD, ring.clone().add(0.0D, 0.25D, 0.0D), 18, 0.22D, 0.45D, 0.22D, 0.04D);
  }

  private static void orbitParticles(Location center, double radius) {
    World world = center.getWorld();
    if (world == null) {
      return;
    }
    double phase = System.currentTimeMillis() / 50.0D % (Math.PI * 2.0D);
    for (int i = 0; i < 3; i++) {
      double angle = phase + i * (Math.PI * 2.0D / 3.0D);
      double x = Math.cos(angle) * radius;
      double z = Math.sin(angle) * radius;
      Location point = center.clone().add(x, 0.1D, z);
      world.spawnParticle(Particle.DRAGON_BREATH, point, 2, 0.05D, 0.05D, 0.05D, 0.01D, 1.0F);
    }
  }

  private static void electricArc(Player player) {
    World world = player.getWorld();
    Location origin = player.getLocation().add(0.0D, 1.25D, 0.0D);
    Vector forward = origin.getDirection().setY(0.0D);
    if (forward.lengthSquared() < 0.001D) {
      forward = new Vector(0.0D, 0.0D, 1.0D);
    }
    forward.normalize();
    Vector side = new Vector(-forward.getZ(), 0.0D, forward.getX()).normalize();
    Vector up = new Vector(0, 1, 0);
    world.playSound(origin, Sound.BLOCK_CHAIN_BREAK, 0.75F, 0.85F);
    int count = arcCounters.merge(player.getUniqueId(), 1, Integer::sum);
    double tilt = switch (count % 6) {
      case 0 -> -28.0D;
      case 1 -> 18.0D;
      case 2 -> -12.0D;
      case 3 -> 30.0D;
      case 4 -> 6.0D;
      default -> -22.0D;
    };
    double radians = Math.toRadians(tilt);
    Vector axisA = side.clone().multiply(Math.cos(radians)).add(up.clone().multiply(Math.sin(radians))).normalize();
    Vector axisB = up.clone().multiply(Math.cos(radians)).subtract(side.clone().multiply(Math.sin(radians))).normalize();
    Location arcOrigin = origin.clone().add(forward.clone().multiply(1.05D));
    int points = 34;
    for (int i = 0; i < points; i++) {
      double t = (double) i / (points - 1);
      double lateral = -1.8D + t * 3.6D;
      double depth = Math.sin(t * Math.PI) * 0.12D - 0.03D;
      double forwardOffset = Math.sin(t * Math.PI) * 0.62D;
      Location point = arcOrigin.clone()
          .add(axisA.clone().multiply(lateral))
          .add(axisB.clone().multiply(depth))
          .add(forward.clone().multiply(forwardOffset));
      if (i % 2 == 0 || i > points - 8) {
        world.spawnParticle(Particle.ELECTRIC_SPARK, point, 1, 0.018D, 0.018D, 0.018D, 0.012D);
      }
    }
  }

  private static void teleportBehind(Player caster, LivingEntity target) {
    Location destination = target.getLocation().clone();
    Vector behind = target.getLocation().getDirection().normalize().multiply(-1.2D);
    destination.add(behind);
    destination.setYaw(target.getLocation().getYaw() + 180.0F);
    destination.setPitch(caster.getLocation().getPitch());
    caster.teleport(destination);
  }

  private static LivingEntity rayTraceTarget(Player player) {
    double range = AltarSMP.getInstance().getConfig().getDouble("dragonrend.hypersonic_slash_range", 16.0D);
    Location eye = player.getEyeLocation();
    Vector direction = eye.getDirection().normalize();
    LivingEntity best = null;
    double bestDot = ARC_DOT_THRESHOLD;
    for (Entity entity : player.getWorld().getNearbyEntities(eye, range, range, range)) {
      if (entity.equals(player)) {
        continue;
      }
      if (!(entity instanceof LivingEntity living) || living.isDead()) {
        continue;
      }
      Location center = living.getLocation().clone().add(0.0D, living.getHeight() * 0.5D, 0.0D);
      if (eye.distance(center) > range) {
        continue;
      }
      Vector toTarget = center.toVector().subtract(eye.toVector());
      if (toTarget.lengthSquared() < 1.0E-4D) {
        continue;
      }
      double dot = direction.dot(toTarget.normalize());
      if (dot > bestDot) {
        bestDot = dot;
        best = living;
      }
    }
    return best;
  }

  private static void applyCasterSlow(Player player, int ticks) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, ticks, 4, true, false, false));
    player.addPotionEffect(new PotionEffect(PotionEffectType.MINING_FATIGUE, ticks, 4, true, false, false));
  }

  private static void playCustom(Location location, String sound, float volume, float pitch) {
    World world = location.getWorld();
    if (world != null) {
      world.playSound(location, sound, volume, pitch);
    }
  }

  private static void addGlow(Entity entity) {
    if (entity == null) {
      return;
    }
    try {
      Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
      String teamName = "altar_glow_" + ChatColor.DARK_PURPLE.name().toLowerCase(Locale.ROOT);
      Team team = scoreboard.getTeam(teamName);
      if (team == null) {
        team = scoreboard.registerNewTeam(teamName);
        team.setColor(ChatColor.DARK_PURPLE);
      }
      team.addEntry(entity.getUniqueId().toString());
    } catch (Exception ignored) {
    }
    entity.setGlowing(true);
  }

  private static void removeGlow(Entity entity) {
    if (entity != null) {
      entity.setGlowing(false);
    }
  }

  private static void cancelTask(BukkitTask task) {
    if (task != null) {
      task.cancel();
    }
  }

  private static final class ArmedState {
    int windowTicks;
    long lastSlashAt;
    BukkitTask windupTask;
    BukkitTask windowTask;
  }

  private static final class VoidZone {
    final Location center;
    final ItemDisplay display;
    Set<UUID> affected = new HashSet<>();
    BukkitTask task;

    VoidZone(Location center, ItemDisplay display) {
      this.center = center;
      this.display = display;
    }
  }
}
