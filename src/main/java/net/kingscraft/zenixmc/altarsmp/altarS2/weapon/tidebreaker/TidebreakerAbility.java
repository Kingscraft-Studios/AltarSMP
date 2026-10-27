package net.kingscraft.zenixmc.altarsmp.altarS2.weapon.tidebreaker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.Levelled;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Trident;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public final class TidebreakerAbility {
  private static final String STORMCALL_COOLDOWN_KEY = "tidebreaker_stormcall";
  private static final String RISING_TIDE_COOLDOWN_KEY = "tidebreaker_rising_tide";
  private static final Random RANDOM = new Random();

  public static final ConcurrentHashMap<UUID, UUID> activeStormProjectiles = new ConcurrentHashMap<>();
  public static final ConcurrentHashMap<UUID, Long> fallImmunity = new ConcurrentHashMap<>();

  private static final ConcurrentHashMap<UUID, Set<TrackedTask>> trackedTasks = new ConcurrentHashMap<>();

  private TidebreakerAbility() {
  }

  public static boolean stormcall(Player player) {
    UUID uuid = player.getUniqueId();

    if (CooldownManager.isOnCooldown(uuid, STORMCALL_COOLDOWN_KEY)) {
      playDenySound(player);
      return false;
    }

    int cooldown = AltarSMP.getInstance().getConfig()
            .getInt("tidebreaker.stormcall_cooldown", 40);

    CooldownManager.setCooldown(uuid, STORMCALL_COOLDOWN_KEY, cooldown);
    BossBarManager.createBar(player, "Stormcall", cooldown, NamedTextColor.AQUA);
    launchTrident(player);

    return true;
  }

  public static boolean risingTide(Player player) {
    UUID uuid = player.getUniqueId();

    if (CooldownManager.isOnCooldown(uuid, RISING_TIDE_COOLDOWN_KEY)) {
      playDenySound(player);
      return false;
    }

    float pitch = player.getEyeLocation().getPitch();

    if (pitch > -35.0F && pitch < 35.0F) {
      playDenySound(player);
      return false;
    }

    int cooldown = AltarSMP.getInstance().getConfig()
            .getInt("tidebreaker.rising_tide_cooldown", 50);

    CooldownManager.setCooldown(uuid, RISING_TIDE_COOLDOWN_KEY, cooldown);
    BossBarManager.createBar(player, "Rising Tide", cooldown, NamedTextColor.AQUA);

    if (pitch <= -35.0F) {
      launchUpwardJet(player);
    } else {
      launchForwardWave(player);
    }

    return true;
  }

  private static void launchTrident(Player player) {
    World world = player.getWorld();
    Location eye = player.getEyeLocation();
    Vector direction = eye.getDirection().normalize();
    double strength = AltarSMP.getInstance().getConfig().getDouble("tidebreaker.stormcall_throw_strength", 2.0D);
    double maxDistance = AltarSMP.getInstance().getConfig().getDouble("tidebreaker.stormcall_throw_max", 30.0D);
    double gravity = AltarSMP.getInstance().getConfig().getDouble("tidebreaker.stormcall_trident_gravity", 0.0D);
    Location spawn = eye.clone().add(direction.clone().multiply(1.5D));
    spawn.setYaw(eye.getYaw());
    spawn.setPitch(eye.getPitch());
    Trident trident = (Trident) world.spawnEntity(spawn, EntityType.TRIDENT);
    trident.setShooter(player);
    trident.setItemStack(CustomItem.TIDEBREAKER.getItem(player));
    trident.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
    trident.setDamage(0.0D);
    trident.setSilent(true);
    trident.setPersistent(false);
    if (gravity <= 0.0D) {
      trident.setGravity(false);
    }
    trident.setVelocity(direction.clone().multiply(strength));
    activeStormProjectiles.put(trident.getUniqueId(), player.getUniqueId());
    world.playSound(player.getLocation(), "altar:use", 1.0F, 1.0F);
    world.playSound(player.getLocation(), Sound.ITEM_TRIDENT_THROW, 0.3F, 1.1F);
    TridentWatchTask watch = new TridentWatchTask(player.getUniqueId(), trident.getUniqueId(), spawn, Math.max(1.0D, maxDistance));
    watch.runTaskTimer(AltarSMP.getInstance(), 1L, 1L);
    track(player.getUniqueId(), watch);
  }

  static void handleProjectileLanding(UUID projectileId, Location location) {
    UUID casterId = activeStormProjectiles.remove(projectileId);
    if (casterId == null) {
      return;
    }
    Entity projectile = Bukkit.getEntity(projectileId);
    if (projectile != null) {
      projectile.remove();
    }
    Player caster = Bukkit.getPlayer(casterId);
    if (caster == null) {
      return;
    }
    startStorm(caster, location);
  }

  private static void startStorm(Player caster, Location hitLocation) {
    World world = hitLocation.getWorld();
    if (world == null) {
      return;
    }
    Location impact = snapToGround(hitLocation);
    Location flash = hitLocation.clone().add(0.0D, 0.18D, 0.0D);
    world.spawnParticle(Particle.FLASH, flash, 1, 0.0D, 0.0D, 0.0D, 0.0D, Color.WHITE);
    world.spawnParticle(Particle.DUST, flash, 12, 0.18D, 0.05D, 0.18D, 0.0D, new Particle.DustOptions(Color.fromRGB(160, 210, 255), 1.0F));
    world.spawnParticle(Particle.ELECTRIC_SPARK, flash, 8, 0.16D, 0.05D, 0.16D, 0.02D);
    world.playSound(flash, Sound.BLOCK_DRIED_GHAST_PLACE, 20.0F, 0.7F);
    Location boltTarget = impact.clone().add(0.0D, 0.1D, 0.0D);
    drawBolt(world, skyPoint(world, impact), boltTarget);
    world.playSound(boltTarget, Sound.BLOCK_DRIED_GHAST_PLACE, 9.0F, 0.7F);
    StormTask task = new StormTask(caster.getUniqueId(), caster, world, impact);
    task.runTaskTimer(AltarSMP.getInstance(), 1L, 1L);
    track(caster.getUniqueId(), task);
  }

  private static void launchUpwardJet(Player player) {
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE, 1.1F, 0.8F);
    JetChargeTask task = new JetChargeTask(player.getUniqueId(), player);
    task.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
    track(player.getUniqueId(), task);
  }

  private static void launchForwardWave(Player player) {
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_INSIDE, 1.1F, 0.75F);
    WaveChargeTask task = new WaveChargeTask(player.getUniqueId(), player);
    task.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
    track(player.getUniqueId(), task);
  }

  private static void playDenySound(Player player) {
    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0F, 1.0F);
  }

  private static void track(UUID ownerId, TrackedTask task) {
    trackedTasks.computeIfAbsent(ownerId, key -> ConcurrentHashMap.newKeySet()).add(task);
  }

  private static void untrack(UUID ownerId, TrackedTask task) {
    Set<TrackedTask> tasks = trackedTasks.get(ownerId);
    if (tasks == null) {
      return;
    }
    tasks.remove(task);
    if (tasks.isEmpty()) {
      trackedTasks.remove(ownerId, tasks);
    }
  }

  static void handleQuit(UUID uuid) {
    fallImmunity.remove(uuid);
    Iterator<Map.Entry<UUID, UUID>> iterator = activeStormProjectiles.entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<UUID, UUID> entry = iterator.next();
      if (uuid.equals(entry.getValue())) {
        Entity entity = Bukkit.getEntity(entry.getKey());
        if (entity != null) {
          entity.remove();
        }
        iterator.remove();
      }
    }
    Set<TrackedTask> tasks = trackedTasks.remove(uuid);
    if (tasks != null) {
      for (TrackedTask task : tasks) {
        task.cancel();
      }
    }
  }

  private static Location snapToGround(Location location) {
    World world = location.getWorld();
    if (world == null) {
      return location;
    }
    int x = location.getBlockX();
    int z = location.getBlockZ();
    for (int y = Math.min(location.getBlockY(), world.getMaxHeight() - 1); y >= world.getMinHeight(); y--) {
      Block block = world.getBlockAt(x, y, z);
      if (block.getType().isSolid()) {
        return new Location(world, location.getX(), y + 1.0D, location.getZ());
      }
    }
    return location;
  }

  private static Location skyPoint(World world, Location impact) {
    int highest = world.getHighestBlockYAt(impact.getBlockX(), impact.getBlockZ());
    double y = Math.max(impact.getY() + 28.0D, highest + 28.0D);
    y = Math.min(world.getMaxHeight() - 4.0D, y);
    return new Location(world, impact.getX(), y, impact.getZ());
  }

  private static Vector horizontalLook(Player player) {
    Vector direction = player.getEyeLocation().getDirection().setY(0.0D);
    if (direction.lengthSquared() < 0.001D) {
      float yaw = player.getLocation().getYaw();
      direction = new Vector(-Math.sin(Math.toRadians(yaw)), 0.0D, Math.cos(Math.toRadians(yaw)));
    }
    return direction.normalize();
  }

  private static void drawBolt(World world, Location from, Location to) {
    Vector delta = to.toVector().subtract(from.toVector());
    double length = delta.length();
    if (length <= 0.01D) {
      return;
    }
    Vector step = delta.clone().multiply(0.2D / length);
    Location cursor = from.clone();
    for (double traveled = 0.0D; traveled < length; traveled += 0.2D) {
      Location point = cursor.clone().add((RANDOM.nextDouble() - 0.5D) * 0.12D, (RANDOM.nextDouble() - 0.5D) * 0.12D, (RANDOM.nextDouble() - 0.5D) * 0.12D);
      world.spawnParticle(Particle.ELECTRIC_SPARK, point, 1, 0.004D, 0.004D, 0.004D, 0.0D);
      cursor.add(step);
    }
  }

  private static void stormRing(World world, Location center, int tick, double radius) {
    Location base = center.clone().add(0.0D, 0.15D, 0.0D);
    double rotation = tick * 0.06D;
    for (int i = 0; i < 18; i++) {
      double angle = (Math.PI * 2.0D) * i / 18.0D + rotation;
      Location point = base.clone().add(Math.cos(angle) * radius, 0.0D, Math.sin(angle) * radius);
      world.spawnParticle(Particle.ELECTRIC_SPARK, point, 1, 0.0D, 0.0D, 0.0D, 0.0D);
    }
  }

  private static void stormCloud(World world, Location cloud, int elapsed) {
    double progress = Math.min(1.0D, elapsed / 40.0D);
    Particle.DustOptions outer = new Particle.DustOptions(Color.fromRGB(72, 72, 76), 1.65F);
    Particle.DustOptions middle = new Particle.DustOptions(Color.fromRGB(104, 104, 110), 1.25F);
    Particle.DustOptions speck = new Particle.DustOptions(Color.fromRGB(48, 48, 52), 0.85F);
    world.spawnParticle(Particle.DUST, cloud, Math.max(12, (int) (100.8D * progress)), 1.21D, 0.45D, 1.21D, 0.0D, outer);
    world.spawnParticle(Particle.DUST, cloud.clone().add(0.0D, 0.45D, 0.0D), Math.max(14, (int) (96.0D * progress)), 2.09D, 0.7D, 2.09D, 0.0D, middle);
    world.spawnParticle(Particle.DUST, cloud.clone().subtract(0.0D, 0.45D, 0.0D), Math.max(12, (int) (78.72D * progress)), 1.76D, 0.45D, 1.76D, 0.0D, outer);
    int specks = Math.max(8, (int) (57.6D * progress));
    for (int i = 0; i < specks; i++) {
      double angle = RANDOM.nextDouble() * Math.PI * 2.0D;
      double radius = 2.2D * (0.72D + RANDOM.nextDouble() * 0.42D);
      Location point = cloud.clone().add(Math.cos(angle) * radius, (RANDOM.nextDouble() - 0.35D) * 2.5D, Math.sin(angle) * radius);
      world.spawnParticle(Particle.DUST, point, 1, 0.03D, 0.03D, 0.03D, 0.0D, speck);
    }
  }

  private static void tideRings(World world, Location center, int tick) {
    for (int ring = 0; ring < 5; ring++) {
      double height = 0.1D + ring * 0.42D;
      double radius = 1.15D + ring * 0.18D + Math.sin((tick + ring) * 0.35D) * 0.06D;
      double rotation = tick * 0.12D + ring * 0.55D;
      for (int i = 0; i < 34; i++) {
        if (RANDOM.nextDouble() < 0.2D) {
          continue;
        }
        double angle = (Math.PI * 2.0D) * i / 34.0D + rotation + (RANDOM.nextDouble() - 0.5D) * 0.38D;
        double jitterRadius = radius + (RANDOM.nextDouble() - 0.5D) * 0.55D;
        double jitterHeight = height + (RANDOM.nextDouble() - 0.5D) * 0.28D;
        Location point = center.clone().add(Math.cos(angle) * jitterRadius, jitterHeight, Math.sin(angle) * jitterRadius);
        world.spawnParticle(Particle.FALLING_WATER, point, 1, 0.42D + RANDOM.nextDouble() * 0.18D, 0.035D + RANDOM.nextDouble() * 0.05D, 0.42D + RANDOM.nextDouble() * 0.18D, 0.0D);
        if (i % 7 == 0) {
          world.spawnParticle(Particle.SPLASH, point, 1, 0.189D, 0.025D, 0.189D, 0.0D);
        }
      }
    }
  }

  private static void impactRing(World world, Location center) {
    Location base = center.clone().add(0.0D, 0.55D, 0.0D);
    for (int i = 0; i < 42; i++) {
      double angle = (Math.PI * 2.0D) * i / 42.0D;
      Vector velocity = new Vector(Math.cos(angle), 0.04D, Math.sin(angle)).multiply(0.34D);
      world.spawnParticle(Particle.CLOUD, base, 0, velocity.getX(), velocity.getY(), velocity.getZ(), 1.0D);
    }
    world.playSound(base, Sound.ENTITY_PLAYER_SPLASH_HIGH_SPEED, 0.8F, 1.15F);
  }

  private static void shockwaveRings(World world, Location center, double radius, double progress) {
    for (int ring = 0; ring < 2; ring++) {
      double ringRadius = Math.max(0.25D, radius - ring * 1.0D);
      int columnHeight = ring == 0 ? 3 : 1;
      int count = Math.max(24, (int) (ringRadius * 12.0D));
      int splashCount = Math.max(12, (int) (ringRadius * 6.5D));
      for (int i = 0; i < count; i++) {
        double angle = (Math.PI * 2.0D) * i / count;
        double height = 0.08D + Math.sin(progress * Math.PI) * (0.14D + ring * 0.035D);
        Location point = center.clone().add(Math.cos(angle) * ringRadius, height, Math.sin(angle) * ringRadius);
        world.spawnParticle(Particle.FALLING_WATER, point, 1, 0.03D, 0.015D, 0.03D, 0.0D);
        if (ring == 0 && i % 3 == 0) {
          Vector outward = new Vector(Math.cos(angle), 0.0D, Math.sin(angle));
          world.spawnParticle(Particle.CLOUD, point.clone().add(0.0D, 0.08D, 0.0D), 0, outward.getX() * 0.45D, 0.025D, outward.getZ() * 0.45D, 0.24D);
        }
        if (i % Math.max(1, count / splashCount) == 0) {
          placeWaterColumn(point, columnHeight);
        }
      }
    }
  }

  private static void breakWebs(World world, Location center, double radius) {
    int range = (int) Math.ceil(radius);
    double radiusSquared = radius * radius;
    int blockX = center.getBlockX();
    int blockY = center.getBlockY();
    int blockZ = center.getBlockZ();
    for (int x = -range; x <= range; x++) {
      for (int y = -range; y <= range; y++) {
        for (int z = -range; z <= range; z++) {
          if (x * x + y * y + z * z > radiusSquared) {
            continue;
          }
          Block block = world.getBlockAt(blockX + x, blockY + y, blockZ + z);
          if (block.getType() != Material.COBWEB) {
            continue;
          }
          Location location = block.getLocation().add(0.5D, 0.5D, 0.5D);
          world.spawnParticle(Particle.BLOCK, location, 18, 0.28D, 0.28D, 0.28D, 0.02D, Material.COBWEB.createBlockData());
          world.playSound(location, Sound.BLOCK_COBWEB_BREAK, 0.55F, 1.2F);
          block.setType(Material.AIR, false);
        }
      }
    }
  }

  private static void placeWaterColumn(Location location, int height) {
    Block start = location.getBlock();
    List<ColumnBlock> blocks = new ArrayList<>();
    for (int i = 0; i < height; i++) {
      Block block = start.getRelative(0, i, 0);
      if (!isColumnReplaceable(block)) {
        continue;
      }
      blocks.add(new ColumnBlock(block, block.getBlockData()));
      Levelled water = (Levelled) Material.WATER.createBlockData();
      water.setLevel(1);
      block.setBlockData(water, false);
    }
    if (blocks.isEmpty()) {
      return;
    }
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> {
      for (ColumnBlock record : blocks) {
        Block block = record.block();
        if (block.getType() == Material.WATER) {
          block.setBlockData(record.original(), false);
        }
      }
    }, 8);
  }

  private static boolean isColumnReplaceable(Block block) {
    Material material = block.getType();
    return material.isAir()
        || material == Material.WATER
        || material == Material.BUBBLE_COLUMN
        || material == Material.SEAGRASS
        || material == Material.TALL_SEAGRASS
        || material == Material.KELP
        || material == Material.KELP_PLANT;
  }

  private static boolean isWaveReplaceable(Block block) {
    Material material = block.getType();
    if (material.isAir() || material == Material.WATER) {
      return true;
    }
    String name = material.name();
    return name.equals("GRASS")
        || name.equals("SHORT_GRASS")
        || name.equals("TALL_GRASS")
        || name.equals("FERN")
        || name.equals("LARGE_FERN")
        || name.equals("DEAD_BUSH")
        || name.contains("BUSH")
        || name.contains("DRY_GRASS");
  }

  private static void knockbackFrom(World world, Player caster, Location center, double radius, double scale) {
    double radiusSquared = radius * radius;
    for (Entity entity : world.getNearbyEntities(center, radius, 3.0D, radius)) {
      if (!(entity instanceof LivingEntity living) || living.equals(caster)) {
        continue;
      }
      Location location = living.getLocation();
      if (location.distanceSquared(center) > radiusSquared) {
        continue;
      }
      Vector direction = location.toVector().subtract(center.toVector()).setY(0.0D);
      if (direction.lengthSquared() < 0.001D) {
        direction = new Vector(0.0D, 0.0D, 1.0D);
      }
      direction.normalize().multiply(0.95D * scale);
      direction.setY(Math.max(living.getVelocity().getY(), 0.28D * scale));
      living.setVelocity(direction);
    }
  }

  private static void pullToward(World world, Player caster, Vector waveDirection, Location center, double halfHeight, double radius) {
    if (!caster.getWorld().equals(world)) {
      return;
    }
    for (Entity entity : world.getNearbyEntities(center, radius, halfHeight, radius)) {
      if (!(entity instanceof LivingEntity living) || living.equals(caster)) {
        continue;
      }
      Vector pull = caster.getLocation().toVector().subtract(living.getLocation().toVector()).setY(0.0D);
      if (pull.lengthSquared() < 0.001D) {
        pull = waveDirection.clone().multiply(-1.0D);
      }
      pull.normalize();
      double distance = living.getLocation().distance(caster.getLocation());
      double strength = 1.25D * (0.25D + Math.min(1.0D, distance / Math.max(0.01D, radius)) * 0.75D);
      Vector velocity = pull.multiply(strength);
      velocity.setY(Math.max(living.getVelocity().getY(), 0.18D));
      living.setVelocity(velocity);
    }
  }

  private static Location offsetLocation(World world, Location origin, Vector direction, Vector side, int distance, int sideOffset) {
    return new Location(world, origin.getBlockX() + 0.5D, origin.getBlockY(), origin.getBlockZ() + 0.5D)
        .add(direction.clone().multiply(distance))
        .add(side.clone().multiply(sideOffset));
  }

  private static List<Location> waveColumnLocations(World world, Location origin, Vector direction, Vector side, int distance, int sideOffset) {
    List<Location> locations = new ArrayList<>();
    Location main = offsetLocation(world, origin, direction, side, distance, sideOffset);
    addLocationIfAbsent(world, locations, main.getBlockX(), main.getBlockY(), main.getBlockZ());
    if (distance > 1) {
      Location previous = offsetLocation(world, origin, direction, side, distance - 1, sideOffset);
      if (previous.getBlockX() != main.getBlockX() && previous.getBlockZ() != main.getBlockZ()) {
        addLocationIfAbsent(world, locations, main.getBlockX(), previous.getBlockY(), main.getBlockZ());
      }
    }
    return locations;
  }

  private static void addLocationIfAbsent(World world, List<Location> locations, int x, int y, int z) {
    for (Location location : locations) {
      if (location.getBlockX() == x && location.getBlockY() == y && location.getBlockZ() == z) {
        return;
      }
    }
    locations.add(new Location(world, x + 0.5D, y, z + 0.5D));
  }

  private static void waterSpray(World world, Location location, Vector side, Vector direction) {
    Vector push = side.clone().multiply(0.85D);
    for (int i = 0; i < 3; i++) {
      double along = 0.18D + i * 0.26D;
      Location point = location.clone()
          .add(side.clone().multiply(along))
          .add(direction.clone().multiply((RANDOM.nextDouble() - 0.5D) * 0.22D))
          .add(0.0D, RANDOM.nextDouble() * 0.14D, 0.0D);
      world.spawnParticle(Particle.CLOUD, point, 0, push.getX(), 0.02D + RANDOM.nextDouble() * 0.02D, push.getZ(), 0.38D);
    }
    Location splashPoint = location.clone().add(side.clone().multiply(0.42D)).add(0.0D, 0.05D, 0.0D);
    world.spawnParticle(Particle.SPLASH, splashPoint, 0, push.getX() * 1.45D, 0.04D, push.getZ() * 1.45D, 0.2D);
  }

  private static String blockKey(Block block) {
    return block.getX() + ":" + block.getY() + ":" + block.getZ();
  }

  private abstract static class TrackedTask extends BukkitRunnable {
    protected final UUID ownerId;

    TrackedTask(UUID ownerId) {
      this.ownerId = ownerId;
    }

    @Override
    public void cancel() {
      try {
        super.cancel();
      } catch (IllegalStateException ignored) {
      }
      untrack(ownerId, this);
    }
  }

  private static final class TridentWatchTask extends TrackedTask {
    private final UUID projectileId;
    private final double maxDistance;
    private final Location spawnLocation;
    private Location lastLocation;
    private int ticks;

    TridentWatchTask(UUID ownerId, UUID projectileId, Location spawnLocation, double maxDistance) {
      super(ownerId);
      this.projectileId = projectileId;
      this.spawnLocation = spawnLocation.clone();
      this.lastLocation = spawnLocation.clone();
      this.maxDistance = maxDistance;
    }

    @Override
    public void run() {
      ticks++;
      Entity entity = Bukkit.getEntity(projectileId);
      if (entity == null || !entity.isValid()) {
        handleProjectileLanding(projectileId, lastLocation);
        cancel();
        return;
      }
      Location location = entity.getLocation();
      if (!location.getWorld().equals(spawnLocation.getWorld())) {
        handleProjectileLanding(projectileId, lastLocation);
        cancel();
        return;
      }
      lastLocation = location.clone();
      if (ticks >= 60 || spawnLocation.distance(location) > maxDistance) {
        handleProjectileLanding(projectileId, location);
        cancel();
      }
    }
  }

  private static final class StormTask extends TrackedTask {
    private final Player caster;
    private final World world;
    private final Location center;
    private final int interval;
    private final int durationTicks;
    private final double radius;
    private final double damage;
    private final int maxTargets;
    private int tick;
    private int strikeCounter;

    StormTask(UUID ownerId, Player caster, World world, Location center) {
      super(ownerId);
      this.caster = caster;
      this.world = world;
      this.center = center;
      this.interval = Math.max(1, AltarSMP.getInstance().getConfig().getInt("tidebreaker.stormcall_interval", 10));
      this.durationTicks = Math.max(1, AltarSMP.getInstance().getConfig().getInt("tidebreaker.stormcall_duration", 10) * 20);
      this.radius = Math.max(1.0D, AltarSMP.getInstance().getConfig().getDouble("tidebreaker.stormcall_radius", 6.0D));
      this.damage = Math.max(0.0D, AltarSMP.getInstance().getConfig().getDouble("tidebreaker.stormcall_damage", 2.0D));
      this.maxTargets = Math.max(1, AltarSMP.getInstance().getConfig().getInt("tidebreaker.stormcall_max_targets", 2));
    }

    @Override
    public void run() {
      if (!caster.isOnline()) {
        cancel();
        return;
      }
      tick++;
      if (tick % 5 == 0 && tick <= 15) {
        Location from = skyPoint(world, center).add((RANDOM.nextDouble() - 0.5D) * 1.2D, (RANDOM.nextDouble() - 0.5D) * 0.4D, (RANDOM.nextDouble() - 0.5D) * 1.2D);
        Location to = center.clone().add(0.0D, 0.1D, 0.0D).add((RANDOM.nextDouble() - 0.5D) * 0.35D, 0.0D, (RANDOM.nextDouble() - 0.5D) * 0.35D);
        drawBolt(world, from, to);
        world.spawnParticle(Particle.ELECTRIC_SPARK, to, 10, 0.16D, 0.06D, 0.16D, 0.05D);
      }
      if (tick < 20) {
        return;
      }
      int elapsed = tick - 20;
      if (elapsed % 5 == 0) {
        stormRing(world, center, elapsed, radius);
        stormCloud(world, center.clone().add(0.0D, 10.0D, 0.0D), elapsed);
        strikeCounter += 5;
        if (strikeCounter >= interval) {
          strikeCounter = 0;
          strike();
        }
      }
      if (elapsed >= durationTicks) {
        cancel();
      }
    }

    private void strike() {
      double radiusSquared = radius * radius;
      List<LivingEntity> targets = world.getNearbyEntities(center, radius, radius, radius).stream()
          .filter(entity -> entity instanceof LivingEntity)
          .map(entity -> (LivingEntity) entity)
          .filter(target -> !target.equals(caster))
          .filter(Entity::isValid)
          .filter(target -> target.getLocation().distanceSquared(center) <= radiusSquared)
          .sorted(Comparator.comparingDouble(LivingEntity::getHealth).reversed())
          .limit(maxTargets)
          .toList();
      if (targets.isEmpty()) {
        return;
      }
      boolean blocked = WorldGuardHook.isBlocked(center);
      Location cloud = center.clone().add(0.0D, 10.0D, 0.0D)
          .add((RANDOM.nextDouble() - 0.5D) * 0.18D, (RANDOM.nextDouble() - 0.5D) * 0.55D, (RANDOM.nextDouble() - 0.5D) * 0.18D);
      for (LivingEntity target : targets) {
        if (!blocked) {
          target.setNoDamageTicks(0);
          TrueDamage.apply(target, damage, caster);
          target.setNoDamageTicks(0);
        }
        Location targetCenter = target.getLocation().add(0.0D, target.getHeight() * 0.5D, 0.0D);
        drawBolt(world, cloud, targetCenter);
        world.spawnParticle(Particle.ELECTRIC_SPARK, targetCenter, 12, 0.16D, 0.16D, 0.16D, 0.06D);
        world.spawnParticle(Particle.DUST, targetCenter, 5, 0.1D, 0.1D, 0.1D, 0.0D, new Particle.DustOptions(Color.fromRGB(210, 235, 255), 0.7F));
      }
      world.playSound(center, Sound.BLOCK_DRIED_GHAST_PLACE, 9.0F, 0.7F);
    }
  }

  private static final class JetChargeTask extends TrackedTask {
    private final Player player;
    private int tick;

    JetChargeTask(UUID ownerId, Player player) {
      super(ownerId);
      this.player = player;
    }

    @Override
    public void run() {
      if (!player.isOnline()) {
        cancel();
        return;
      }
      World world = player.getWorld();
      Location location = player.getLocation();
      tideRings(world, location, tick);
      world.spawnParticle(Particle.FALLING_WATER, location.clone().add(0.0D, 0.7D, 0.0D), 18, 0.65D, 0.55D, 0.65D, 0.04D);
      breakWebs(world, location, AltarSMP.getInstance().getConfig().getDouble("tidebreaker.rising_tide_radius", 6.0D));
      tick++;
      if (tick >= 18) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 40, 0, true, false, true));
        impactRing(world, location);
        fallImmunity.put(player.getUniqueId(), System.currentTimeMillis() + 8000L);
        JetThrustTask thrust = new JetThrustTask(ownerId, player);
        thrust.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
        track(ownerId, thrust);
        JetLandingTask landing = new JetLandingTask(ownerId, player);
        landing.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
        track(ownerId, landing);
        cancel();
      }
    }
  }

  private static final class JetThrustTask extends TrackedTask {
    private final Player player;
    private int tick;

    JetThrustTask(UUID ownerId, Player player) {
      super(ownerId);
      this.player = player;
    }

    @Override
    public void run() {
      if (!player.isOnline()) {
        cancel();
        return;
      }
      World world = player.getWorld();
      if (tick < 7) {
        Location feet = player.getLocation().clone().subtract(0.0D, 1.75D + Math.min(0.85D, tick * 0.06D), 0.0D);
        int height = Math.min(6, 2 + tick / 2);
        placeWaterColumn(feet, height);
        tideRings(world, feet, tick);
      }
      if (tick == 0) {
        player.setVelocity(new Vector(0.0D, 2.15D, 0.0D));
      } else if (tick < 16 && player.getVelocity().getY() < 1.333D) {
        Vector velocity = player.getVelocity();
        velocity.setY(1.333D);
        player.setVelocity(velocity);
      }
      tick++;
      if (tick >= 16) {
        cancel();
      }
    }
  }

  private static final class JetLandingTask extends TrackedTask {
    private final Player player;
    private int tick;

    JetLandingTask(UUID ownerId, Player player) {
      super(ownerId);
      this.player = player;
    }

    @Override
    public void run() {
      if (!player.isOnline()) {
        cancel();
        return;
      }
      Location location = player.getLocation();
      breakWebs(player.getWorld(), location, AltarSMP.getInstance().getConfig().getDouble("tidebreaker.rising_tide_radius", 6.0D));
      if (tick > 8 && player.isOnGround()) {
        player.getWorld().playSound(location, Sound.ENTITY_PLAYER_SPLASH_HIGH_SPEED, 1.0F, 0.82F);
        ShockwaveTask shockwave = new ShockwaveTask(ownerId, player, location.clone());
        shockwave.runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
        track(ownerId, shockwave);
        cancel();
        return;
      }
      tick++;
      if (tick > 120) {
        cancel();
      }
    }
  }

  private static final class ShockwaveTask extends TrackedTask {
    private final Player player;
    private final Location center;
    private int tick;

    ShockwaveTask(UUID ownerId, Player player, Location center) {
      super(ownerId);
      this.player = player;
      this.center = center;
    }

    @Override
    public void run() {
      World world = center.getWorld();
      if (!player.isOnline() || world == null) {
        cancel();
        return;
      }
      double kb = AltarSMP.getInstance().getConfig().getDouble("tidebreaker.rising_tide_kb", 5.0D);
      double maxRadius = Math.max(1.0D, AltarSMP.getInstance().getConfig().getDouble("tidebreaker.rising_tide_radius", 6.0D));
      double progress = tick / 18.0D;
      double radius = 1.0D + (maxRadius - 1.0D) * progress;
      shockwaveRings(world, center, radius, progress);
      knockbackFrom(world, player, center, radius, kb / 5.0D);
      breakWebs(world, center, radius);
      tick++;
      if (tick > 18) {
        cancel();
      }
    }
  }

  private static final class WaveChargeTask extends TrackedTask {
    private final Player player;
    private int tick;

    WaveChargeTask(UUID ownerId, Player player) {
      super(ownerId);
      this.player = player;
    }

    @Override
    public void run() {
      if (!player.isOnline()) {
        cancel();
        return;
      }
      World world = player.getWorld();
      Location location = player.getLocation().clone().add(0.0D, 0.7D, 0.0D);
      world.spawnParticle(Particle.FALLING_WATER, location, 18, 0.65D, 0.55D, 0.65D, 0.04D);
      if (tick % 5 == 0) {
        world.playSound(location, Sound.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT, 0.45F, 1.45F);
      }
      tick++;
      if (tick >= 20) {
        WaveTask wave = new WaveTask(ownerId, player, player.getLocation().clone(), horizontalLook(player));
        wave.runTaskTimer(AltarSMP.getInstance(), 0L, 2L);
        track(ownerId, wave);
        cancel();
      }
    }
  }

  private static final class WaveTask extends TrackedTask {
    private final Player caster;
    private final World world;
    private final Location origin;
    private final Vector direction;
    private final Vector side;
    private final BlockData waterBlockData = Material.WATER.createBlockData();
    private final Map<String, PlacedBlock> placed = new ConcurrentHashMap<>();
    private int step;

    WaveTask(UUID ownerId, Player caster, Location origin, Vector direction) {
      super(ownerId);
      this.caster = caster;
      this.world = origin.getWorld();
      this.origin = origin;
      this.direction = direction;
      this.side = new Vector(-direction.getZ(), 0.0D, direction.getX()).normalize();
    }

    @Override
    public void run() {
      if (world == null) {
        cancel();
        return;
      }
      if (step > 17) {
        revertAll();
        cancel();
        return;
      }
      Set<String> currentKeys = new HashSet<>();
      int maxRowHeight = 1;
      boolean placedAny = false;
      Location waveCenter = offsetLocation(world, origin, direction, side, Math.min(step, 14), 0);
      for (int row = 0; row < 3; row++) {
        int distance = step - 2 + row;
        if (distance < 1 || distance > 14) {
          continue;
        }
        Location rowBase = offsetLocation(world, origin, direction, side, distance, 0);
        int baseY = Math.max(world.getMinHeight() + 1, rowBase.getBlockY());
        int height = Math.clamp(row + 2, 1, 4);
        maxRowHeight = Math.max(maxRowHeight, height);
        for (int sideOffset = -1; sideOffset <= 1; sideOffset++) {
          for (Location column : waveColumnLocations(world, origin, direction, side, distance, sideOffset)) {
            for (int dy = 0; dy < height; dy++) {
              Block block = world.getBlockAt(column.getBlockX(), baseY + dy, column.getBlockZ());
              if (!isWaveReplaceable(block)) {
                continue;
              }
              String key = blockKey(block);
              if (!placed.containsKey(key)) {
                placed.put(key, new PlacedBlock(block, block.getBlockData()));
              }
              currentKeys.add(key);
              placedAny = true;
              block.setBlockData(waterBlockData, false);
            }
            if (Math.abs(sideOffset) == 1) {
              Vector sprayDirection = side.clone().multiply(sideOffset);
              Location sprayBase = new Location(world, column.getBlockX() + 0.5D, baseY + 0.12D, column.getBlockZ() + 0.5D)
                  .add(sprayDirection.clone().multiply(0.58D));
              waterSpray(world, sprayBase, sprayDirection, direction);
            }
          }
        }
      }
      Iterator<Map.Entry<String, PlacedBlock>> iterator = placed.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry<String, PlacedBlock> entry = iterator.next();
        if (currentKeys.contains(entry.getKey())) {
          continue;
        }
        Block block = entry.getValue().block();
        if (block.getType() == Material.WATER) {
          block.setBlockData(entry.getValue().original(), false);
        }
        iterator.remove();
      }
      if (placedAny) {
        world.playSound(waveCenter, Sound.ITEM_BUCKET_EMPTY, 0.85F, 1.15F);
        double radius = Math.max(1.0D, AltarSMP.getInstance().getConfig().getDouble("tidebreaker.rising_tide_radius", 6.0D));
        pullToward(world, caster, direction, waveCenter, maxRowHeight + 1.2D, radius);
      }
      step++;
    }

    private void revertAll() {
      for (PlacedBlock record : placed.values()) {
        Block block = record.block();
        if (block.getType() == Material.WATER) {
          block.setBlockData(record.original(), false);
        }
      }
      placed.clear();
    }

    @Override
    public void cancel() {
      revertAll();
      super.cancel();
    }
  }

  private record PlacedBlock(Block block, BlockData original) {
  }

  private record ColumnBlock(Block block, BlockData original) {
  }
}
