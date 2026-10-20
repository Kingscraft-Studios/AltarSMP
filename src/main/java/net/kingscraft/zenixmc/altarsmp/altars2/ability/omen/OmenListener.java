package net.kingscraft.zenixmc.altarsmp.altars2.ability.omen;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;

public class OmenListener implements Listener {
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent event) {
    if (event.getHand() != EquipmentSlot.HAND) {
      return;
    }
    Action action = event.getAction();
    if (action != Action.LEFT_CLICK_AIR && action != Action.LEFT_CLICK_BLOCK) {
      return;
    }
    Player player = event.getPlayer();
    OmenAbility.handleSwing(player);
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    OmenAbility.cleanup(event.getPlayer().getUniqueId());
  }
}
