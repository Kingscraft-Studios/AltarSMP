package net.kingscraft.zenixmc.altarsmp.weapon.illusion.flight;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.IllusionDisguiseManager;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.ability.IllusionAbilityFamily;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.ability.IllusionAbilityRegistry;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.attribute.IllusionAttributeService;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.util.IllusionConfig;
import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

/**
 * Creative-style flight for flying mob disguises.
 *
 * <p>allow-flight, fly speed and fall immunity are re-asserted every 10 ticks so
 * regions or other plugins cannot quietly switch flight off. Flight itself is
 * never forced: the player toggles it exactly like creative mode. Fly speed
 * always comes from config (0.1 by default), including the Wither.</p>
 */
public final class IllusionFlightService {

  private static final float DEFAULT_FLY_SPEED = 0.05F;

  private record FlightState(boolean previousAllowFlight, boolean previousFlying,
                             float previousFlySpeed, BukkitTask task) {
  }

  private static final Map<UUID, FlightState> STATES = new HashMap<>();

  private IllusionFlightService() {
  }

  public static boolean canFly(EntityType type) {
    if (!IllusionConfig.flightEnabled()) {
      return false;
    }
    IllusionAbilityFamily family = IllusionAbilityRegistry.family(type);
    return family.canFly();
  }

  public static void apply(Player player, EntityType type) {
    clear(player);
    if (player == null || !canFly(type)) {
      return;
    }
    GameMode mode = player.getGameMode();
    if (mode == GameMode.CREATIVE || mode == GameMode.SPECTATOR) {
      return;
    }

    float speed = (float) IllusionConfig.flySpeed();
    UUID id = player.getUniqueId();
    boolean previousAllowFlight = player.getAllowFlight();
    boolean previousFlying = player.isFlying();
    float previousFlySpeed = player.getFlySpeed();

    player.setAllowFlight(true);
    player.setFlySpeed(speed);
    if (IllusionConfig.noFallDamage()) {
      IllusionAttributeService.applyFallDamageImmunity(player);
    }

    BukkitTask task = AltarSMP.getInstance().getServer().getScheduler()
            .runTaskTimer(AltarSMP.getInstance(), () -> {
              if (!player.isOnline() || !IllusionDisguiseManager.isDisguised(player)) {
                clear(player);
                return;
              }
              // Never force flight. The player double-taps space exactly like
              // creative mode; we only keep the permission and speed alive.
              if (!player.getAllowFlight()) {
                player.setAllowFlight(true);
              }
              if (Math.abs(player.getFlySpeed() - speed) > 0.001F) {
                player.setFlySpeed(speed);
              }
              if (IllusionConfig.noFallDamage()) {
                IllusionAttributeService.applyFallDamageImmunity(player);
              }
            }, 10L, 10L);

    STATES.put(id, new FlightState(previousAllowFlight, previousFlying, previousFlySpeed, task));
  }

  public static void clear(Player player) {
    if (player == null) {
      return;
    }
    FlightState state = STATES.remove(player.getUniqueId());
    if (state == null) {
      return;
    }
    if (state.task() != null) {
      state.task().cancel();
    }
    if (player.isOnline()) {
      GameMode mode = player.getGameMode();
      if (mode != GameMode.CREATIVE && mode != GameMode.SPECTATOR) {
        player.setAllowFlight(state.previousAllowFlight());
        player.setFlying(state.previousFlying());
      }
      float speed = state.previousFlySpeed();
      if (speed <= 0.0F) {
        speed = DEFAULT_FLY_SPEED;
      }
      player.setFlySpeed(Math.clamp(speed, 0.0F, 1.0F));
    }
    IllusionAttributeService.clearFallDamageImmunity(player);
  }

  public static boolean isFlyManaged(Player player) {
    return player != null && STATES.containsKey(player.getUniqueId());
  }
}
