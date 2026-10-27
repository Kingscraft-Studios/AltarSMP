package net.kingscraft.zenixmc.altarsmp.altarS2.weapon.omen;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;

class OmenTetherTask extends BukkitRunnable {
  private final UUID casterId;
  private final UUID targetId;
  private final Location center;
  private final double radius;
  private final int totalTicks;
  private final String targetBarTitle;
  private int tick;

  OmenTetherTask(UUID casterId, UUID targetId, Location center, double radius, int totalTicks, String targetBarTitle) {
    this.casterId = casterId;
    this.targetId = targetId;
    this.center = center;
    this.radius = radius;
    this.totalTicks = totalTicks;
    this.targetBarTitle = targetBarTitle;
  }

  @Override
  public void run() {
    Player caster = Bukkit.getPlayer(casterId);
    Player target = Bukkit.getPlayer(targetId);
    World world = center.getWorld();
    if (caster == null || !caster.isOnline() || caster.isDead()
      || target == null || !target.isOnline() || target.isDead()
      || world == null || !target.getWorld().equals(world)) {
      stop();
      return;
    }
    OmenAbility.pullToward(target, center, radius);
    OmenParticles.tetherVisual(world, center, target, radius, tick);
    if (tick % 10 == 0) {
      world.playSound(target.getLocation(), Sound.BLOCK_COPPER_BULB_TURN_ON, 0.25F, 1.7F);
    }
    tick++;
    if (tick >= totalTicks) {
      OmenParticles.zoneCollapse(world, center, radius);
      world.playSound(center, Sound.BLOCK_VAULT_CLOSE_SHUTTER, 0.75F, 1.35F);
      stop();
    }
  }

  void stop() {
    cancel();
    if (OmenAbility.ACTIVE_TETHERS.get(targetId) == this) {
      OmenAbility.ACTIVE_TETHERS.remove(targetId);
    }
    Player caster = Bukkit.getPlayer(casterId);
    if (caster != null) {
      BossBarManager.removeBar(caster, "Tethering");
    }
    Player target = Bukkit.getPlayer(targetId);
    if (target != null) {
      BossBarManager.removeBar(target, targetBarTitle);
    }
  }

  UUID getCasterId() {
    return casterId;
  }

  boolean involves(UUID playerId) {
    return casterId.equals(playerId) || targetId.equals(playerId);
  }
}
