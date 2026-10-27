package net.kingscraft.zenixmc.altarsmp.altarS2.weapon.omen;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class OmenZoneTask extends BukkitRunnable {
  private final UUID casterId;
  private final Location center;
  private final double radius;
  private final int totalTicks;
  private final boolean tetherEnabled;
  private int tick;

  OmenZoneTask(UUID casterId, Location center, double radius, int totalTicks, boolean tetherEnabled) {
    this.casterId = casterId;
    this.center = center;
    this.radius = radius;
    this.totalTicks = totalTicks;
    this.tetherEnabled = tetherEnabled;
  }

  @Override
  public void run() {
    Player caster = Bukkit.getPlayer(casterId);
    if (caster == null || !caster.isOnline() || caster.isDead()) {
      stop(true);
      return;
    }
    World world = center.getWorld();
    if (world == null) {
      stop(true);
      return;
    }
    OmenParticles.zoneRing(world, center, radius, tick);
    if (tick % 10 == 0) {
      world.playSound(center, Sound.BLOCK_COPPER_BULB_TURN_ON, 0.25F, 1.7F);
    }
    if (tetherEnabled) {
      double radiusSquared = radius * radius;
      for (Entity entity : world.getNearbyEntities(center, radius, radius, radius)) {
        if (!(entity instanceof Player target) || target.equals(caster) || !target.isOnline() || target.isDead()) {
          continue;
        }
        if (OmenAbility.ACTIVE_TETHERS.containsKey(target.getUniqueId())) {
          continue;
        }
        Location middle = target.getLocation().add(0.0, target.getHeight() * 0.5, 0.0);
        if (middle.distanceSquared(center) <= radiusSquared) {
          OmenAbility.startTether(casterId, target, center, radius, Math.max(1, totalTicks - tick));
        }
      }
    }
    tick++;
    if (tick >= totalTicks) {
      OmenParticles.zoneCollapse(world, center, radius);
      world.playSound(center, Sound.BLOCK_VAULT_CLOSE_SHUTTER, 0.75F, 1.35F);
      stop(false);
    }
  }

  void stop(boolean endTethers) {
    cancel();
    if (OmenAbility.ACTIVE_ZONES.get(casterId) == this) {
      OmenAbility.ACTIVE_ZONES.remove(casterId);
    }
    if (endTethers) {
      OmenAbility.endTethersForCaster(casterId);
    }
  }
}
