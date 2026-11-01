package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Keeps the disguise alive across a portal instead of revealing it. The fake
 * entity and the flight/passive state are rebuilt in the new world.
 */
class DisguiseWorldChangeTask extends BukkitRunnable {

  private final PlayerChangedWorldEvent event;

  DisguiseWorldChangeTask(PlayerChangedWorldEvent event) {
    this.event = event;
  }

  @Override
  public void run() {
    Player player = this.event.getPlayer();
    if (!IllusionDisguiseManager.isDisguised(player)) {
      return;
    }
    EntityType type = IllusionDisguiseManager.getDisguisedEntityType(player);
    if (type == null) {
      return;
    }

    Player target = null;
    UUID targetId = IllusionDisguiseManager.disguisedPlayerTargets.get(player.getUniqueId());
    if (targetId != null) {
      target = Bukkit.getPlayer(targetId);
    }

    IllusionDisguiseManager.revealPlayer(player, false);

    if (type == EntityType.PLAYER) {
      if (target != null && target.isOnline()) {
        IllusionDisguiseManager.disguisePlayer(player, EntityType.PLAYER, target);
      }
      return;
    }
    IllusionDisguiseManager.disguisePlayer(player, type, null);
  }
}
