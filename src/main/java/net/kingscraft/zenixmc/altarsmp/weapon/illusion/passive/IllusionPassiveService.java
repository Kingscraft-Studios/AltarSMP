package net.kingscraft.zenixmc.altarsmp.weapon.illusion.passive;

import java.util.*;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.IllusionDisguiseManager;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.attribute.IllusionAttributeService;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionConfig;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

public final class IllusionPassiveService {

  private record Passive(PotionEffectType type, int amplifier) {
  }

  private static final Map<EntityType, List<Passive>> TABLE = new EnumMap<>(EntityType.class);

  private static final Set<EntityType> FALL_IMMUNE = EnumSet.of(EntityType.CAT, EntityType.OCELOT, EntityType.CHICKEN);

  private static final Map<UUID, Set<Location>> LAVA_PLAYER_BLOCKS = new HashMap<>();

  private static final Map<Location, Integer> LAVA_BLOCK_USERS = new HashMap<>();

  private static final Map<Location, BlockData> LAVA_ORIGINAL_BLOCKS = new HashMap<>();

  private static final int LAVA_PLATFORM_RADIUS = 1; // 3x3 around the player

  private static final int LAVA_SCAN_DEPTH = 4; // blocks below the feet

  private static final class PassiveState {
    final Map<PotionEffectType, PotionEffect> previous;
    final List<Passive> effects;
    final boolean lavaWalk;
    BukkitTask task;
    BukkitTask lavaTask;

    PassiveState(Map<PotionEffectType, PotionEffect> previous, List<Passive> effects, boolean lavaWalk) {
      this.previous = previous;
      this.effects = effects;
      this.lavaWalk = lavaWalk;
    }
  }

  private static final Map<UUID, PassiveState> STATES = new HashMap<>();

  private IllusionPassiveService() {
  }

  private static void add(PotionEffectType type, EntityType... mobs) {
    for (EntityType mob : mobs) {
      TABLE.computeIfAbsent(mob, key -> new ArrayList<>()).add(new Passive(type, 0));
    }
  }

  static {
    add(PotionEffectType.FIRE_RESISTANCE, EntityType.BLAZE, EntityType.GHAST,
            EntityType.HAPPY_GHAST, EntityType.MAGMA_CUBE, EntityType.WITHER_SKELETON,
            EntityType.ZOMBIFIED_PIGLIN, EntityType.STRIDER, EntityType.WITHER);

    add(PotionEffectType.WATER_BREATHING, EntityType.DROWNED, EntityType.GUARDIAN,
            EntityType.ELDER_GUARDIAN, EntityType.COD, EntityType.SALMON, EntityType.TROPICAL_FISH,
            EntityType.PUFFERFISH, EntityType.TADPOLE, EntityType.AXOLOTL, EntityType.DOLPHIN,
            EntityType.SQUID, EntityType.GLOW_SQUID, EntityType.TURTLE);

    add(PotionEffectType.NIGHT_VISION, EntityType.BAT, EntityType.CAT, EntityType.OCELOT);
    add(PotionEffectType.SLOW_FALLING, EntityType.CHICKEN);
    add(PotionEffectType.JUMP_BOOST, EntityType.RABBIT, EntityType.FROG, EntityType.GOAT);
    // Horse speed comes from the vanilla movement-speed attribute, not a potion.
    add(PotionEffectType.SPEED, EntityType.CAMEL, EntityType.OCELOT);
    add(PotionEffectType.RESISTANCE, EntityType.IRON_GOLEM, EntityType.TURTLE,
            EntityType.ARMADILLO);
    add(PotionEffectType.REGENERATION, EntityType.AXOLOTL, EntityType.MOOSHROOM);
  }

  public static void apply(Player player, EntityType type) {
    clear(player);
    if (player == null || type == null || !IllusionConfig.passivesEnabled()) {
      return;
    }

    List<Passive> effects = TABLE.get(type);
    boolean fallImmune = FALL_IMMUNE.contains(type);
    boolean lavaWalk = type == EntityType.STRIDER && IllusionConfig.striderLavaWalk();
    if ((effects == null || effects.isEmpty()) && !fallImmune && !lavaWalk) {
      return;
    }

    Map<PotionEffectType, PotionEffect> previous = new HashMap<>();
    if (effects != null) {
      for (Passive passive : effects) {
        PotionEffect existing = player.getPotionEffect(passive.type());
        if (existing != null) {
          previous.put(passive.type(), existing);
        }
        applyEffect(player, passive);
      }
    }
    if (fallImmune) {
      IllusionAttributeService.applyFallDamageImmunity(player);
    }

    PassiveState state = new PassiveState(previous, effects == null ? List.of() : effects, lavaWalk);
    STATES.put(player.getUniqueId(), state);
    state.task = AltarSMP.getInstance().getServer().getScheduler().runTaskTimer(
            AltarSMP.getInstance(), () -> reassert(player), 40L, 40L);
    if (lavaWalk) {
      state.lavaTask = AltarSMP.getInstance().getServer().getScheduler().runTaskTimer(
              AltarSMP.getInstance(), () -> lavaWalk(player), 1L, 1L);
    }
  }

  private static void lavaWalk(Player player) {
    PassiveState state = STATES.get(player.getUniqueId());

    if (state == null || !state.lavaWalk) {
      return;
    }

    if (!player.isOnline() || !IllusionDisguiseManager.isDisguised(player)) {
      clear(player);
      return;
    }

    GameMode mode = player.getGameMode();
    if (player.isDead()
            || mode == GameMode.SPECTATOR
            || player.isFlying()) {
      releasePlayerLavaPlatform(player);
      return;
    }

    player.setFireTicks(0);

    if (updateLavaPlatform(player)) {
      // Landing on the barrier must not deal fall damage.
      player.setFallDistance(0.0F);
    }
  }

  private static void applyEffect(Player player, Passive passive) {
    player.addPotionEffect(new PotionEffect(passive.type(), PotionEffect.INFINITE_DURATION, passive.amplifier(), true, false, false));
  }

  private static void reassert(Player player) {
    PassiveState state = STATES.get(player.getUniqueId());
    if (state == null) {
      return;
    }
    if (!player.isOnline() || !IllusionDisguiseManager.isDisguised(player)) {
      clear(player);
      return;
    }
    for (Passive passive : state.effects) {
      PotionEffect current = player.getPotionEffect(passive.type());
      if (current == null || !current.isInfinite()) {
        applyEffect(player, passive);
      }
    }
  }

  public static void clear(Player player) {
    if (player == null) {
      return;
    }
    PassiveState state = STATES.remove(player.getUniqueId());
    if (state == null) {
      return;
    }
    if (state.task != null) {
      state.task.cancel();
    }
    if (state.lavaTask != null) {
      state.lavaTask.cancel();
    }

    if (state.lavaWalk) {
      releasePlayerLavaPlatform(player);
    }
    for (Passive passive : state.effects) {
      player.removePotionEffect(passive.type());
      PotionEffect previous = state.previous.get(passive.type());
      if (previous != null) {
        player.addPotionEffect(previous);
      }
    }
    IllusionAttributeService.clearFallDamageImmunity(player);
  }

  private static void releasePlayerLavaPlatform(Player player) {
    UUID uuid = player.getUniqueId();

    Set<Location> blocks = LAVA_PLAYER_BLOCKS.remove(uuid);

    if (blocks == null || blocks.isEmpty()) {
      return;
    }

    for (Location location : blocks) {
      releaseLavaBlock(location);
    }
  }

  private static boolean updateLavaPlatform(Player player) {
    UUID uuid = player.getUniqueId();

    Set<Location> oldBlocks = LAVA_PLAYER_BLOCKS.get(uuid);

    Integer platformY = findLavaPlatformY(player);

    if (platformY == null) {
      if (oldBlocks != null) {
        for (Location oldLocation : new HashSet<>(oldBlocks)) {
          releaseLavaBlock(oldLocation);
        }
        LAVA_PLAYER_BLOCKS.remove(uuid);
      }
      return false;
    }

    Set<Location> newBlocks = findLavaPlatform(player, platformY);

    if (oldBlocks == null) {
      oldBlocks = new HashSet<>();
      LAVA_PLAYER_BLOCKS.put(uuid, oldBlocks);
    }

    for (Location oldLocation : new HashSet<>(oldBlocks)) {
      if (!newBlocks.contains(oldLocation)) {
        releaseLavaBlock(oldLocation);
        oldBlocks.remove(oldLocation);
      }
    }

    for (Location newLocation : newBlocks) {
      if (!oldBlocks.contains(newLocation) && claimLavaBlock(newLocation)) {
        oldBlocks.add(newLocation);
      }
    }

    if (oldBlocks.isEmpty()) {
      LAVA_PLAYER_BLOCKS.remove(uuid);
      return false;
    }

    return true;
  }

  private static Integer findLavaPlatformY(Player player) {
    Location playerLocation = player.getLocation();
    World world = player.getWorld();

    int centerX = playerLocation.getBlockX();
    int centerZ = playerLocation.getBlockZ();
    int feetY = playerLocation.getBlockY();

    Block feet = world.getBlockAt(centerX, feetY, centerZ);
    Block below = world.getBlockAt(centerX, feetY - 1, centerZ);

    // The player's feet are inside the top lava block. Put the platform in that
    // same block so the collision lifts them onto the lava surface.
    if (isLavaLike(feet)) {
      return feetY;
    }

    // Standing on solid ground: never replace lava under a bridge or floor.
    if (below.getType().isSolid() && !isLavaLike(below)) {
      return null;
    }

    // The player is on the surface: use the block directly below their feet.
    if (hasLavaAround(world, centerX, centerZ, feetY - 1)) {
      return feetY - 1;
    }

    // The player is falling towards lava: find the topmost lava layer, but do
    // not look through a solid floor.
    for (int y = feetY - 2; y >= feetY - LAVA_SCAN_DEPTH; y--) {
      Block center = world.getBlockAt(centerX, y, centerZ);
      if (center.getType().isSolid() && !isLavaLike(center)) {
        break;
      }
      if (hasLavaAround(world, centerX, centerZ, y)) {
        return y;
      }
    }

    return null;
  }

  private static Set<Location> findLavaPlatform(Player player, int platformY) {
    Set<Location> result = new HashSet<>();

    Location playerLocation = player.getLocation();
    World world = player.getWorld();

    int centerX = playerLocation.getBlockX();
    int centerZ = playerLocation.getBlockZ();

    for (int x = centerX - LAVA_PLATFORM_RADIUS; x <= centerX + LAVA_PLATFORM_RADIUS; x++) {
      for (int z = centerZ - LAVA_PLATFORM_RADIUS; z <= centerZ + LAVA_PLATFORM_RADIUS; z++) {
        Block block = world.getBlockAt(x, platformY, z);
        if (isLavaLike(block)) {
          result.add(block.getLocation());
        }
      }
    }

    return result;
  }

  private static boolean hasLavaAround(World world, int centerX, int centerZ, int y) {
    for (int x = centerX - LAVA_PLATFORM_RADIUS; x <= centerX + LAVA_PLATFORM_RADIUS; x++) {
      for (int z = centerZ - LAVA_PLATFORM_RADIUS; z <= centerZ + LAVA_PLATFORM_RADIUS; z++) {
        if (isLavaLike(world.getBlockAt(x, y, z))) {
          return true;
        }
      }
    }
    return false;
  }

  private static boolean isLavaLike(Block block) {
    Material type = block.getType();
    if (type == Material.LAVA) {
      return true;
    }
    return type == Material.BARRIER && LAVA_BLOCK_USERS.containsKey(block.getLocation());
  }

  /**
   * True when the player is standing in lava, on one of the lava-walk barriers,
   * or close enough above lava that the platform is about to appear. Used to
   * suppress fall damage from landing on the platform.
   */
  public static boolean isOnOrFallingIntoLava(Player player) {
    return IllusionConfig.passivesEnabled()
            && IllusionConfig.striderLavaWalk()
            && player != null
            && findLavaPlatformY(player) != null;
  }

  private static boolean claimLavaBlock(Location location) {
    Integer users = LAVA_BLOCK_USERS.get(location);

    if (users != null) {
      LAVA_BLOCK_USERS.put(location, users + 1);
      return true;
    }

    Block block = location.getBlock();

    if (block.getType() != Material.LAVA) {
      return false;
    }

    LAVA_ORIGINAL_BLOCKS.put(location, block.getBlockData().clone());

    block.setType(Material.BARRIER, false);

    LAVA_BLOCK_USERS.put(location, 1);

    return true;
  }

  private static void releaseLavaBlock(Location location) {
    Integer users = LAVA_BLOCK_USERS.get(location);

    if (users == null) {
      return;
    }

    if (users > 1) {
      LAVA_BLOCK_USERS.put(location, users - 1);
      return;
    }

    LAVA_BLOCK_USERS.remove(location);

    BlockData original = LAVA_ORIGINAL_BLOCKS.remove(location);

    if (original == null) {
      return;
    }

    Block block = location.getBlock();

    if (block.getType() == Material.BARRIER) {
      block.setBlockData(original, false);
    }
  }
}
