package net.kingscraft.zenixmc.altarsmp.weapon.illusion.passive;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.IllusionDisguiseManager;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.attribute.IllusionAttributeService;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionConfig;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

/**
 * Always-on traits that make a disguise feel like the mob.
 *
 * <p>Effects are re-asserted every 40 ticks so milk, death or another plugin
 * cannot silently remove them. The player's previous effects are captured and
 * restored on reveal.</p>
 */
public final class IllusionPassiveService {

  private record Passive(PotionEffectType type, int amplifier) {
  }

  private static final Map<EntityType, List<Passive>> TABLE = new EnumMap<>(EntityType.class);

  private static final Set<EntityType> FALL_IMMUNE = EnumSet.of(
          EntityType.CAT, EntityType.OCELOT, EntityType.CHICKEN);

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
    player.setFireTicks(0);
    Location location = player.getLocation();
    Block feet = location.getBlock();
    Block below = location.clone().subtract(0.0D, 0.1D, 0.0D).getBlock();
    if (feet.getType() != Material.LAVA && below.getType() != Material.LAVA) {
      return;
    }
    // Counter the lava sink so the player keeps bobbing along the surface.
    Vector velocity = player.getVelocity();
    if (velocity.getY() < 0.08D) {
      player.setVelocity(new Vector(velocity.getX(), 0.08D, velocity.getZ()));
    }
    player.setFallDistance(0.0F);
    player.setFireTicks(0);
  }

  private static void applyEffect(Player player, Passive passive) {
    player.addPotionEffect(new PotionEffect(passive.type(), PotionEffect.INFINITE_DURATION,
            passive.amplifier(), true, false, false), true);
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
    for (Passive passive : state.effects) {
      player.removePotionEffect(passive.type());
      PotionEffect previous = state.previous.get(passive.type());
      if (previous != null) {
        player.addPotionEffect(previous);
      }
    }
    IllusionAttributeService.clearFallDamageImmunity(player);
  }
}
