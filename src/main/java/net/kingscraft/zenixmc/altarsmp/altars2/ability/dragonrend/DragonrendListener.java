package net.kingscraft.zenixmc.altarsmp.altars2.ability.dragonrend;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class DragonrendListener implements Listener {
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    if (event.getAction() != Action.LEFT_CLICK_AIR && event.getAction() != Action.LEFT_CLICK_BLOCK) {
      return;
    }
    Player player = event.getPlayer();
    if (!DragonrendAbility.holdsWeapon(player)) {
      return;
    }
    DragonrendAbility.tryClickSlash(player);
  }

  @EventHandler(ignoreCancelled = true)
  public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    if (!(event.getDamager() instanceof Player player)) {
      return;
    }
    if (!DragonrendAbility.holdsWeapon(player)) {
      return;
    }
    if (!(event.getEntity() instanceof LivingEntity target) || target.isDead()) {
      return;
    }
    if (DragonrendAbility.tryHitSlash(player, target)) {
      event.setCancelled(true);
      return;
    }
    DragonrendAbility.playSwingFeedback(player);
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    DragonrendAbility.handleQuit(event.getPlayer());
  }
}
