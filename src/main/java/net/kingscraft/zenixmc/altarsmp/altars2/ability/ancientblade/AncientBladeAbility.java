package net.kingscraft.zenixmc.altarsmp.altars2.ability.ancientblade;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.BlockDisplay;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.altars2.Altars2;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public final class AncientBladeAbility {
  private static final String PRESENCE_COOLDOWN_KEY = "ancientblade_presence";

  private static final String UNYIELDING_COOLDOWN_KEY = "ancientblade_unyielding";

  private static final String ECHO_COOLDOWN_KEY = "ancientblade_echolocation";

  private static final int PRESENCE_WINDUP_TICKS = 40;

  private static final int PRESENCE_WINDOW_TICKS = 100;

  private static final double MARK_RING_RADIUS = 0.72;

  private static final int CATALYST_MAX_TICKS = 240;

  public static final ConcurrentHashMap<UUID, Long> presenceWindows = new ConcurrentHashMap<>();

  public static final ConcurrentHashMap<UUID, Long> presenceActiveTasks = new ConcurrentHashMap<>();

  public static final ConcurrentHashMap<UUID, Long> markedTargets = new ConcurrentHashMap<>();

  public static final ConcurrentHashMap<UUID, Long> fallProtection = new ConcurrentHashMap<>();

  public static final ConcurrentHashMap<UUID, List<BukkitTask>> activeTasks = new ConcurrentHashMap<>();

  public static final ConcurrentHashMap<UUID, BlockDisplay> activeDisplays = new ConcurrentHashMap<>();

  private static int hitArcCounter;

  private AncientBladeAbility() {
  }

  public static void echolocation(Player player) {
    if (Altars2.killLevel(player) < 1) {
      return;
    }
    UUID id = player.getUniqueId();
    if (CooldownManager.isOnCooldown(id, ECHO_COOLDOWN_KEY)) {
      denySound(player);
      return;
    }
    double radius = configDouble("echo_location_radius", 24.0);
    double radiusSquared = radius * radius;
    boolean found = false;
    for (Player other : Bukkit.getOnlinePlayers()) {
      if (other.equals(player) || other.getWorld() != player.getWorld()) {
        continue;
      }
      if (other.getLocation().distanceSquared(player.getLocation()) > radiusSquared) {
        continue;
      }
      player.playSound(other.getLocation(), Sound.ENTITY_WARDEN_TENDRIL_CLICKS, 0.85F, 1.15F);
      found = true;
    }
    CooldownManager.setCooldown(id, ECHO_COOLDOWN_KEY, configInt("echo_location_cooldown", 3));
    if (found) {
      swirlParticles(player);
    }
  }

  public static boolean presence(Player player) {
    if (Altars2.killLevel(player) < 3) {
      return true;
    }
    UUID id = player.getUniqueId();
    if (CooldownManager.isOnCooldown(id, PRESENCE_COOLDOWN_KEY) || isPresenceActive(id)) {
      denySound(player);
      return true;
    }
    int cooldown = configInt("presence_cooldown", 45);
    markPresenceActive(id, PRESENCE_WINDUP_TICKS + PRESENCE_WINDOW_TICKS + 20);
    player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 40, 0, true, false, true));
    player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 40, 0, true, false, true));
    player.getWorld().playSound(player.getLocation(), Sound.PARTICLE_SOUL_ESCAPE, 0.85F, 0.65F);
    sculkBurst(player);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      Player caster = Bukkit.getPlayer(id);
      if (caster == null || !caster.isOnline() || !isPresenceActive(id)) {
        clearPresenceActive(id);
        return;
      }
      caster.getWorld().playSound(caster.getLocation(), Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 0.55F, 1.65F);
      presenceWindows.put(id, System.currentTimeMillis() + PRESENCE_WINDOW_TICKS * 50L);
      BossBarManager.createBar(caster, "Presence", PRESENCE_WINDOW_TICKS / 20, ChatColor.DARK_AQUA);
      Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
        if (presenceWindows.remove(id) != null) {
          clearPresenceActive(id);
          Player online = Bukkit.getPlayer(id);
          if (online != null && online.isOnline()) {
            BossBarManager.removeBar(online, "Presence");
            BossBarManager.createBar(online, "Presence", cooldown, ChatColor.DARK_AQUA);
          }
          CooldownManager.setCooldown(id, PRESENCE_COOLDOWN_KEY, cooldown);
        }
      }, PRESENCE_WINDOW_TICKS);
    }, PRESENCE_WINDUP_TICKS);
    return true;
  }

  public static boolean unyieldingDarkness(Player player) {
    if (Altars2.killLevel(player) < 5) {
      return true;
    }
    UUID id = player.getUniqueId();
    if (CooldownManager.isOnCooldown(id, UNYIELDING_COOLDOWN_KEY)) {
      denySound(player);
      return true;
    }
    if (activeTasks.containsKey(id)) {
      denySound(player);
      return true;
    }
    int cooldown = configInt("unyielding_darkness_cooldown", 60);
    CooldownManager.setCooldown(id, UNYIELDING_COOLDOWN_KEY, cooldown);
    BossBarManager.createBar(player, "Unyielding Darkness", cooldown, ChatColor.DARK_AQUA);
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_SCULK_SPREAD, 1.1F, 0.85F);
    grantFallProtection(player, 9000L);
    player.setVelocity(player.getVelocity().setY(1.4));
    spawnRisingRing(player);
    track(id, new BukkitRunnable() {
      private int tick;

      public void run() {
        Player caster = Bukkit.getPlayer(id);
        if (caster == null || !caster.isOnline()) {
          cancel();
          return;
        }
        spawnLandingPuff(caster);
        if (tick >= 10) {
          caster.setVelocity(new Vector(0.0, 0.0, 0.0));
        }
        this.tick++;
        if (this.tick >= 10) {
          try {
            launchCatalyst(caster);
          } catch (RuntimeException e) {
            AltarSMP.getInstance().getLogger().warning("Unyielding Darkness failed to launch: " + e.getMessage());
            cancelTasks(id);
          }
          cancel();
        }
      }
    }.runTaskTimer(AltarSMP.getInstance(), 0L, 1L));
    return true;
  }

  static void handlePlayerHit(Player damager, EntityDamageByEntityEvent event) {
    UUID id = damager.getUniqueId();
    Long expiry = presenceWindows.get(id);
    if (expiry == null) {
      return;
    }
    if (System.currentTimeMillis() > expiry) {
      endPresenceWindow(id, damager);
      return;
    }
    if (!(event.getEntity() instanceof LivingEntity target) || target.equals(damager)) {
      return;
    }
    endPresenceWindow(id, damager);
    applyMark(target, configInt("presence_duration", 10));
    markBurst(target.getLocation().add(0.0, Math.max(0.6, target.getHeight() * 0.5), 0.0));
  }

  static boolean hasFallProtection(Player player) {
    UUID id = player.getUniqueId();
    Long expiry = fallProtection.get(id);
    if (expiry == null) {
      return false;
    }
    if (System.currentTimeMillis() > expiry) {
      fallProtection.remove(id);
      return false;
    }
    return true;
  }

  static void cleanupPlayer(UUID id) {
    clearPresenceActive(id);
    presenceWindows.remove(id);
    markedTargets.remove(id);
    fallProtection.remove(id);
    BlockDisplay display = activeDisplays.remove(id);
    if (display != null && display.isValid()) {
      display.remove();
    }
    cancelTasks(id);
  }

  static void spawnHitArc(Player player) {
    try {
      World world = player.getWorld();
      Location origin = player.getLocation().add(0.0, 1.25, 0.0);
      Vector forward = origin.getDirection().setY(0.0);
      if (forward.lengthSquared() < 0.001) {
        forward = new Vector(0.0, 0.0, 1.0);
      }
      forward.normalize();
      Vector side = new Vector(-forward.getZ(), 0.0, forward.getX()).normalize();
      Vector up = new Vector(0.0, 1.0, 0.0);
      world.playSound(origin, Sound.BLOCK_CHAIN_BREAK, 0.75F, 0.85F);
      double degrees = switch (++hitArcCounter % 6) {
        case 0 -> -28.0;
        case 1 -> 18.0;
        case 2 -> -12.0;
        case 3 -> 30.0;
        case 4 -> 6.0;
        default -> -22.0;
      };
      double radians = Math.toRadians(degrees);
      Vector axisA = side.clone().multiply(Math.cos(radians)).add(up.clone().multiply(Math.sin(radians))).normalize();
      Vector axisB = up.clone().multiply(Math.cos(radians)).subtract(side.clone().multiply(Math.sin(radians))).normalize();
      Location start = origin.clone().add(forward.clone().multiply(1.05));
      int points = 34;
      for (int i = 0; i < points; i++) {
        double t = (double) i / (points - 1);
        double lateral = -1.8 + t * 3.6;
        double depth = Math.sin(t * Math.PI) * 0.12 - 0.03;
        double reach = Math.sin(t * Math.PI) * 0.62;
        Location point = start.clone().add(axisA.clone().multiply(lateral)).add(axisB.clone().multiply(depth)).add(forward.clone().multiply(reach));
        if (i % 2 == 0 || i > points - 8) {
          world.spawnParticle(Particle.ELECTRIC_SPARK, point, 1, 0.018, 0.018, 0.018, 0.012);
        }
      }
    } catch (RuntimeException ignored) {
    }
  }

  private static void launchCatalyst(Player player) {
    UUID id = player.getUniqueId();
    World world = player.getWorld();
    Location eye = player.getEyeLocation();
    Vector direction = eye.getDirection();
    if (direction.lengthSquared() < 0.001) {
      direction = new Vector(0.0, 0.0, 1.0);
    }
    direction.normalize();
    Vector heading = direction.clone();
    Location origin = eye.clone().add(heading.clone().multiply(1.35));
    faceDirection(origin, heading);
    flashPair(world, origin);
    world.playSound(origin, Sound.ENTITY_WARDEN_SONIC_BOOM, 0.8F, 0.7F);
    recoil(player, heading);
    grantFallProtection(player, 9000L);
    BlockDisplay display = world.spawn(origin, BlockDisplay.class);
    display.setBlock(Material.SCULK_CATALYST.createBlockData());
    display.setTransformation(spinTransformation(0));
    display.setPersistent(false);
    display.setInterpolationDelay(0);
    display.setInterpolationDuration(1);
    display.setTeleportDuration(1);
    activeDisplays.put(id, display);
    track(id, new BukkitRunnable() {
      private int tick;

      private final Location pos = origin.clone();

      private final Vector velocity = heading.clone().multiply(1.15);

      public void run() {
        Player caster = Bukkit.getPlayer(id);
        if (caster == null || !caster.isOnline()) {
          if (display.isValid()) {
            display.remove();
          }
          activeDisplays.remove(id);
          cancel();
          return;
        }
        Location previous = pos.clone();
        this.velocity.setY(this.velocity.getY() - 0.012);
        Location next = this.pos.clone().add(this.velocity);
        Location hit = raycastHit(this.pos, next, caster);
        this.pos.add(this.velocity);
        if (hit == null && (this.tick > CATALYST_MAX_TICKS || this.pos.getY() <= world.getMinHeight() + 2)) {
          hit = snapToGround(this.pos);
        }
        Location resolved = hit == null ? this.pos.clone() : hit.clone();
        faceDirection(resolved, this.velocity);
        if (display.isValid()) {
          display.teleport(resolved);
          display.setTransformation(spinTransformation(this.tick));
          display.setInterpolationDelay(0);
          display.setInterpolationDuration(1);
        }
        spawnProjectileTrail(world, previous, resolved);
        if (hit != null) {
          if (display.isValid()) {
            display.remove();
          }
          activeDisplays.remove(id);
          resolveImpact(resolved.clone(), caster);
          Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> activeTasks.remove(id), 32L);
          cancel();
        } else {
          this.tick++;
        }
      }
    }.runTaskTimer(AltarSMP.getInstance(), 0L, 1L));
  }

  private static void resolveImpact(Location impact, Player caster) {
    World world = impact.getWorld();
    if (world == null) {
      return;
    }
    flashPair(world, impact);
    Location ground = impact.clone();
    for (int y = impact.getBlockY(); y >= world.getMinHeight(); y--) {
      Block block = world.getBlockAt(impact.getBlockX(), y, impact.getBlockZ());
      if (block.getType().isSolid()) {
        ground = new Location(world, impact.getX(), y + 1.0, impact.getZ());
        break;
      }
    }
    world.spawnParticle(Particle.BLOCK, ground, 80, 0.65, 0.45, 0.65, 0.22, Material.SCULK_CATALYST.createBlockData());
    world.spawnParticle(Particle.BLOCK, ground, 55, 0.55, 0.35, 0.55, 0.18, Material.SCULK.createBlockData());
    world.playSound(impact, Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.25F, 0.8F);
    spreadSculk(world, ground);
    burstDamage(world, ground.clone().add(0.0, 0.55, 0.0), caster);
    spawnTendrils(impact, caster);
  }

  private static void spreadSculk(World world, Location ground) {
    if (WorldGuardHook.isBlocked(ground)) {
      return;
    }
    int baseY = ground.getBlockY();
    List<RevertEntry> entries = new ArrayList<>();
    for (int dx = -5; dx <= 5; dx++) {
      for (int dz = -5; dz <= 5; dz++) {
        if (dx * dx + dz * dz > 25) {
          continue;
        }
        for (int y = baseY + 1; y >= baseY - 4; y--) {
          Block block = world.getBlockAt(ground.getBlockX() + dx, y, ground.getBlockZ() + dz);
          if (block.getType().isSolid() && isConvertible(block.getType())) {
            entries.add(new RevertEntry(block, block.getBlockData()));
            block.setType(Material.SCULK, false);
            world.spawnParticle(Particle.BLOCK, block.getLocation().add(0.5, 1.05, 0.5), 10, 0.34, 0.08, 0.34, 0.04, Material.SCULK.createBlockData());
            break;
          }
        }
      }
    }
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      for (RevertEntry entry : entries) {
        if (entry.block().getType() == Material.SCULK) {
          entry.block().setBlockData(entry.previous(), false);
        }
      }
    }, 100L);
  }

  private static void spawnTendrils(Location impact, Player caster) {
    World world = impact.getWorld();
    if (world == null) {
      return;
    }
    UUID id = caster.getUniqueId();
    List<Vector> directions = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      double angle = Math.PI * 2 * i / 10.0;
      Vector direction = new Vector(Math.cos(angle), 0.08, Math.sin(angle)).normalize();
      directions.add(direction.clone());
      track(id, new BukkitRunnable() {
        private int step;

        private Location cursor = snapToGroundHigh(impact.clone(), world);

        public void run() {
          double progress = this.step / 18.0;
          Location target = impact.clone().add(direction.clone().multiply(progress * 8.0));
          Location snapped = snapToGroundHigh(target, world);
          spawnTendrilSpiral(world, this.cursor, snapped);
          this.cursor = snapped;
          this.step++;
          if (this.step > 18) {
            sonicBurst(world, snapped, caster);
            cancel();
          }
        }
      }.runTaskTimer(AltarSMP.getInstance(), 0L, 1L));
    }
    track(id, Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      for (Vector direction : directions) {
        Location end = snapToGroundHigh(impact.clone().add(direction.clone().multiply(8.0)), world);
        sonicBurst(world, end, direction, caster);
      }
    }, 24L));
  }

  private static void sonicBurst(World world, Location center, Vector direction, Player caster) {
    Vector side = new Vector(-direction.getZ(), 0.0, direction.getX());
    if (side.lengthSquared() < 0.001) {
      side = new Vector(1.0, 0.0, 0.0);
    }
    side.normalize();
    sonicBurst(world, center, caster);
    sonicBurst(world, center.clone().add(direction.clone().multiply(0.55)), caster);
    sonicBurst(world, center.clone().add(side.clone().multiply(0.48)), caster);
    sonicBurst(world, center.clone().add(side.clone().multiply(-0.48)), caster);
  }

  private static void sonicBurst(World world, Location center, Player caster) {
    if (WorldGuardHook.isBlocked(center)) {
      return;
    }
    flashPair(world, center);
    Location base = center.clone().add(0.0, 0.28, 0.0);
    for (int i = 0; i < 5; i++) {
      world.spawnParticle(Particle.SONIC_BOOM, base.clone().add(0.0, i * 0.18, 0.0), 1, 0.0, 0.0, 0.0, 0.0);
    }
    world.spawnParticle(Particle.BLOCK, base, 36, 0.32, 0.18, 0.32, 0.09, Material.SCULK.createBlockData());
    sculkWave(world, base);
    burstDamage(world, base, caster);
    world.playSound(base, Sound.ENTITY_GENERIC_EXPLODE, 0.42F, 1.72F);
    world.playSound(base, Sound.ENTITY_WARDEN_SONIC_BOOM, 0.34F, 1.55F);
  }

  private static void burstDamage(World world, Location center, Player caster) {
    double radius = configDouble("unyielding_damage_radius", 2.0);
    double power = configDouble("unyielding_power", 2.0);
    double radiusSquared = radius * radius;
    for (Entity entity : world.getNearbyEntities(center, radius, radius, radius)) {
      if (!(entity instanceof LivingEntity living) || living.equals(caster)) {
        continue;
      }
      if (living.getLocation().distanceSquared(center) > radiusSquared) {
        continue;
      }
      if (WorldGuardHook.isBlocked(living.getLocation())) {
        continue;
      }
      living.setNoDamageTicks(0);
      TrueDamage.apply(living, power, caster);
      living.setNoDamageTicks(0);
    }
  }

  private static void applyMark(LivingEntity target, int durationSeconds) {
    UUID id = target.getUniqueId();
    int durationTicks = Math.max(1, durationSeconds) * 20;
    markedTargets.put(id, System.currentTimeMillis() + durationTicks * 50L);
    target.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, durationTicks, 0, true, false, true));
    target.removePotionEffect(PotionEffectType.ABSORPTION);
    if (target instanceof Player player) {
      player.setAbsorptionAmount(0.0);
    }
    int iterations = Math.max(1, durationTicks / 8);
    new BukkitRunnable() {
      private int tick;

      public void run() {
        Entity entity = Bukkit.getEntity(id);
        if (!(entity instanceof LivingEntity living) || !living.isValid() || living.isDead()) {
          markedTargets.remove(id);
          cancel();
          return;
        }
        World world = living.getWorld();
        Location center = living.getLocation().add(0.0, Math.max(0.62, living.getHeight() * 0.52), 0.0);
        double rotation = this.tick * 0.22;
        for (int i = 0; i < 42; i++) {
          double angle = Math.PI * 2 * i / 42.0 + rotation;
          Location ring = center.clone().add(Math.cos(angle) * MARK_RING_RADIUS, Math.sin(angle * 2.0) * 0.035, Math.sin(angle) * MARK_RING_RADIUS);
          world.spawnParticle(Particle.BLOCK, ring, 2, 0.035, 0.035, 0.035, 0.035, Material.SCULK.createBlockData());
        }
        int remaining = Math.max(2, (iterations - this.tick) * 8);
        living.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, remaining, 0, true, false, true));
        living.removePotionEffect(PotionEffectType.ABSORPTION);
        if (living instanceof Player player) {
          player.setAbsorptionAmount(0.0);
        }
        this.tick++;
        if (this.tick >= iterations) {
          markedTargets.remove(id);
          cancel();
        }
      }
    }.runTaskTimer(AltarSMP.getInstance(), 0L, 8L);
  }

  private static void endPresenceWindow(UUID id, Player player) {
    presenceWindows.remove(id);
    clearPresenceActive(id);
    BossBarManager.removeBar(player, "Presence");
    int cooldown = configInt("presence_cooldown", 45);
    CooldownManager.setCooldown(id, PRESENCE_COOLDOWN_KEY, cooldown);
    BossBarManager.createBar(player, "Presence", cooldown, ChatColor.DARK_AQUA);
  }

  private static void markBurst(Location target) {
    World world = target.getWorld();
    if (world == null) {
      return;
    }
    world.spawnParticle(Particle.SONIC_BOOM, target, 1, 0.0, 0.0, 0.0, 0.0);
    for (int i = 0; i < 104; i++) {
      double angle = Math.PI * 2 * i / 104.0;
      double y = -0.24 + i % 13 * 0.055;
      double radius = 0.28 * (0.78 + i % 5 * 0.13);
      Vector velocity = new Vector(Math.cos(angle) * radius, y, Math.sin(angle) * radius);
      world.spawnParticle(Particle.SOUL, target, 0, velocity.getX(), velocity.getY(), velocity.getZ(), 0.68);
    }
    world.spawnParticle(Particle.SOUL, target, 70, 0.62, 0.52, 0.62, 0.045);
    world.spawnParticle(Particle.SCULK_SOUL, target, 10, 0.36, 0.28, 0.36, 0.025);
    world.playSound(target, Sound.ENTITY_WARDEN_SONIC_BOOM, 0.9F, 1.15F);
    world.playSound(target, Sound.PARTICLE_SOUL_ESCAPE, 1.05F, 0.78F);
  }

  private static void swirlParticles(Player player) {
    new BukkitRunnable() {
      private int tick;

      public void run() {
        if (!player.isOnline()) {
          cancel();
          return;
        }
        World world = player.getWorld();
        Location center = player.getLocation().add(0.0, 1.7, 0.0);
        int points = 22;
        double radius = 0.32 + this.tick * 0.01;
        world.spawnParticle(Particle.SCULK_SOUL, center, 10, 0.12, 0.12, 0.12, 0.01);
        world.spawnParticle(Particle.SOUL, center, 8, 0.18, 0.18, 0.18, 0.01);
        for (int i = 0; i < points; i++) {
          double angle = Math.PI * 2 * i / points + this.tick * 0.24;
          Location point = center.clone().add(Math.cos(angle) * radius, Math.sin(this.tick * 0.34 + i * 0.45) * 0.16, Math.sin(angle) * radius);
          world.spawnParticle(Particle.SCULK_SOUL, point, 1, 0.03, 0.03, 0.03, 0.0);
          if (i % 4 == 0) {
            world.spawnParticle(Particle.SOUL, point, 1, 0.02, 0.02, 0.02, 0.0);
          }
        }
        if (this.tick % 5 == 0) {
          world.spawnParticle(Particle.FLASH, center, 1, 0.0, 0.0, 0.0, 0.0, Color.WHITE);
        }
        this.tick++;
        if (this.tick >= 40) {
          cancel();
        }
      }
    }.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  private static void sculkBurst(Player player) {
    World world = player.getWorld();
    Location center = player.getLocation().clone();
    center.setY(Math.floor(center.getY()) + 0.06);
    world.spawnParticle(Particle.BLOCK, center, 42, 0.42, 0.035, 0.42, 0.055, Material.SCULK.createBlockData());
    for (int i = 0; i < 32; i++) {
      double angle = Math.PI * 2 * i / 32.0;
      Location point = center.clone().add(Math.cos(angle) * 0.85, 0.02, Math.sin(angle) * 0.85);
      world.spawnParticle(Particle.BLOCK, point, 2, 0.035, 0.018, 0.035, 0.035, Material.SCULK.createBlockData());
    }
  }

  private static void spawnLandingPuff(Player player) {
    Location center = player.getLocation().clone();
    center.setY(Math.floor(center.getY()));
    player.getWorld().spawnParticle(Particle.BLOCK, center.clone().add(0.0, 0.05, 0.0), 18, 0.55, 0.02, 0.55, 0.01, Material.SCULK.createBlockData());
  }

  private static void spawnRisingRing(Player player) {
    UUID id = player.getUniqueId();
    World world = player.getWorld();
    Location center = player.getLocation().clone();
    center.setY(Math.floor(center.getY()) + 0.08);
    track(id, new BukkitRunnable() {
      private int tick;

      public void run() {
        Player caster = Bukkit.getPlayer(id);
        if (caster == null || !caster.isOnline()) {
          cancel();
          return;
        }
        double radius = Math.max(0.08, 4.6 * this.tick / 9.0);
        int points = Math.max(24, (int) (radius * 20.0));
        for (int i = 0; i < points; i++) {
          double angle = Math.PI * 2 * i / points;
          Location point = center.clone().add(Math.cos(angle) * radius, 0.0, Math.sin(angle) * radius);
          world.spawnParticle(Particle.BLOCK, point, 2, 0.04, 0.02, 0.04, 0.03, Material.SCULK.createBlockData());
        }
        this.tick++;
        if (this.tick >= 10) {
          cancel();
        }
      }
    }.runTaskTimer(AltarSMP.getInstance(), 0L, 1L));
  }

  private static void spawnProjectileTrail(World world, Location from, Location to) {
    Vector delta = to.toVector().subtract(from.toVector());
    double length = delta.length();
    if (length <= 0.02) {
      return;
    }
    Vector step = delta.clone().normalize().multiply(0.22);
    Location cursor = from.clone();
    for (double travelled = 0.0; travelled < length; travelled += 0.22) {
      world.spawnParticle(Particle.BLOCK, cursor, 5, 0.18, 0.18, 0.18, 0.06, Material.SCULK.createBlockData());
      world.spawnParticle(Particle.BLOCK, cursor, 3, 0.12, 0.12, 0.12, 0.04, Material.SCULK.createBlockData());
      Location soul = cursor.clone().add(0.0, 0.08, 0.0);
      world.spawnParticle(Particle.SOUL, soul, 6, 0.09, 0.09, 0.09, 0.025);
      world.spawnParticle(Particle.SOUL, soul, 0, step.getX() * 0.55, 0.02, step.getZ() * 0.55, 0.18);
      cursor.add(step);
    }
  }

  private static void spawnTendrilSpiral(World world, Location from, Location to) {
    Vector delta = to.toVector().subtract(from.toVector());
    double length = delta.length();
    if (length <= 0.01) {
      return;
    }
    Vector direction = delta.clone().normalize();
    Vector step = direction.clone().multiply(0.16);
    Vector side = new Vector(-direction.getZ(), 0.0, direction.getX());
    if (side.lengthSquared() < 0.001) {
      side = new Vector(1.0, 0.0, 0.0);
    }
    side.normalize();
    Location cursor = from.clone();
    double phase = 0.0;
    for (double travelled = 0.0; travelled < length; travelled += 0.16) {
      for (int arm = 0; arm < 2; arm++) {
        double angle = phase * 7.2 + arm * Math.PI;
        double lateral = Math.sin(angle) * 0.42;
        double lift = Math.max(0.02, Math.cos(angle) * 0.12 + 0.08);
        Location point = cursor.clone().add(side.clone().multiply(lateral)).add(0.0, lift, 0.0);
        world.spawnParticle(Particle.BLOCK, point, 4, 0.055, 0.09, 0.055, 0.055, Material.SCULK.createBlockData());
      }
      cursor.add(step);
      phase += 0.16;
    }
  }

  private static void sculkWave(World world, Location center) {
    for (int i = 0; i < 16; i++) {
      double angle = Math.random() * Math.PI * 2.0;
      double distance = Math.random();
      Location point = center.clone().add(Math.cos(angle) * distance, 0.0, Math.sin(angle) * distance);
      world.spawnParticle(Particle.BLOCK, point, 2, 0.04, 0.0, 0.04, 0.03, Material.SCULK.createBlockData());
      world.spawnParticle(Particle.SOUL, point.clone().add(0.0, 0.05, 0.0), 1, 0.04, 0.0, 0.04, 0.01);
    }
  }

  private static void flashPair(World world, Location center) {
    world.spawnParticle(Particle.FLASH, center.clone().add(0.0, 0.55, 0.0), 1, 0.0, 0.0, 0.0, 0.0, Color.WHITE);
    world.spawnParticle(Particle.FLASH, center.clone().add(0.0, 1.0, 0.0), 1, 0.0, 0.0, 0.0, 0.0, Color.WHITE);
  }

  private static Location raycastHit(Location from, Location to, Player caster) {
    World world = from.getWorld();
    if (world == null) {
      return null;
    }
    Vector delta = to.toVector().subtract(from.toVector());
    double length = delta.length();
    if (length <= 0.05) {
      return null;
    }
    Vector direction = delta.normalize();
    RayTraceResult blocks = world.rayTraceBlocks(from, direction, length, FluidCollisionMode.NEVER, true);
    RayTraceResult entities = world.rayTraceEntities(from, direction, length, 0.85, entity -> entity instanceof LivingEntity living && !living.equals(caster));
    Location blockHit = blocks != null ? blocks.getHitPosition().toLocation(world).add(0.0, 0.08, 0.0) : null;
    Location entityHit = entities != null ? entities.getHitPosition().toLocation(world).add(0.0, 0.08, 0.0) : null;
    if (blockHit == null) {
      return entityHit;
    }
    if (entityHit == null) {
      return blockHit;
    }
    return entityHit.distanceSquared(from) < blockHit.distanceSquared(from) ? entityHit : blockHit;
  }

  private static Location snapToGround(Location location) {
    World world = location.getWorld();
    if (world == null) {
      return location;
    }
    int x = location.getBlockX();
    int z = location.getBlockZ();
    for (int y = Math.min(location.getBlockY(), world.getMaxHeight() - 1); y >= world.getMinHeight(); y--) {
      if (world.getBlockAt(x, y, z).getType().isSolid()) {
        return new Location(world, location.getX(), y + 1.05, location.getZ());
      }
    }
    return location;
  }

  private static Location snapToGroundHigh(Location location, World world) {
    int x = location.getBlockX();
    int z = location.getBlockZ();
    int y = Math.min(location.getBlockY() + 4, world.getMaxHeight() - 1);
    for (; y >= world.getMinHeight(); y--) {
      if (world.getBlockAt(x, y, z).getType().isSolid()) {
        return new Location(world, location.getX(), y + 1.0, location.getZ());
      }
    }
    return location.clone().add(0.0, 0.08, 0.0);
  }

  private static void faceDirection(Location location, Vector direction) {
    double horizontal = Math.sqrt(direction.getX() * direction.getX() + direction.getZ() * direction.getZ());
    location.setYaw((float) Math.toDegrees(Math.atan2(-direction.getX(), direction.getZ())));
    location.setPitch((float) Math.toDegrees(-Math.atan2(direction.getY(), horizontal)));
  }

  private static void recoil(Player player, Vector direction) {
    Vector horizontal = direction.clone();
    horizontal.setY(0.0);
    if (horizontal.lengthSquared() < 0.001) {
      horizontal = player.getLocation().getDirection().setY(0.0);
    }
    if (horizontal.lengthSquared() < 0.001) {
      horizontal = new Vector(0.0, 0.0, 1.0);
    }
    horizontal.normalize().multiply(-0.62);
    horizontal.setY(0.18);
    player.setVelocity(horizontal);
    player.setFallDistance(0.0F);
  }

  private static Transformation spinTransformation(int tick) {
    float angle = (float) Math.toRadians(tick * 22.0F);
    Quaternionf rotation = new Quaternionf().rotateX(angle);
    Vector3f translation = new Vector3f(1.35F * 0.5F, 1.35F * 0.5F, 1.35F * 0.5F);
    rotation.transform(translation);
    translation.negate();
    return new Transformation(translation, rotation, new Vector3f(1.35F, 1.35F, 1.35F), new Quaternionf());
  }

  private static boolean isConvertible(Material material) {
    return material != Material.BEDROCK
        && material != Material.BARRIER
        && material != Material.COMMAND_BLOCK
        && material != Material.CHAIN_COMMAND_BLOCK
        && material != Material.REPEATING_COMMAND_BLOCK
        && material != Material.STRUCTURE_BLOCK
        && material != Material.JIGSAW;
  }

  private static void grantFallProtection(Player player, long millis) {
    fallProtection.put(player.getUniqueId(), System.currentTimeMillis() + millis);
    player.setFallDistance(0.0F);
  }

  private static boolean isPresenceActive(UUID id) {
    Long expiry = presenceWindows.get(id);
    return expiry != null || presenceActiveTasks.containsKey(id);
  }

  private static void markPresenceActive(UUID id, int ticks) {
    presenceActiveTasks.put(id, System.currentTimeMillis() + ticks * 50L);
  }

  private static void clearPresenceActive(UUID id) {
    presenceWindows.remove(id);
    presenceActiveTasks.remove(id);
  }

  private static void denySound(Player player) {
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
  }

  private static void track(UUID id, BukkitTask task) {
    activeTasks.computeIfAbsent(id, key -> new ArrayList<>()).add(task);
  }

  private static void cancelTasks(UUID id) {
    List<BukkitTask> tasks = activeTasks.remove(id);
    if (tasks != null) {
      for (BukkitTask task : tasks) {
        task.cancel();
      }
    }
  }

  private static int configInt(String key, int def) {
    return AltarSMP.getInstance().getConfig().getInt("ancientblade." + key, def);
  }

  private static double configDouble(String key, double def) {
    return AltarSMP.getInstance().getConfig().getDouble("ancientblade." + key, def);
  }

  private record RevertEntry(Block block, BlockData previous) {
  }
}
