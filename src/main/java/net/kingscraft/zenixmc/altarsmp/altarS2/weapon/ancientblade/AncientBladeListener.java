package net.kingscraft.zenixmc.altarsmp.altarS2.weapon.ancientblade;

import java.util.UUID;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;

public class AncientBladeListener implements Listener {

  @EventHandler
  public void onEcholocationInteract(PlayerInteractEvent event) {
    if (event.getHand() != EquipmentSlot.HAND) {
      return;
    }
    if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) {
      return;
    }
    Player player = event.getPlayer();
    if (!player.isSneaking()) {
      return;
    }
    ItemStack item = player.getInventory().getItemInMainHand();
    if (CustomItem.fromItem(item) != CustomItem.ANCIENTBLADE) {
      return;
    }
    event.setCancelled(true);
    AncientBladeAbility.echolocation(player);
  }

  @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
  public void onAncientBladeHit(EntityDamageByEntityEvent event) {
    if (!(event.getDamager() instanceof Player damager)) {
      return;
    }
    EntityDamageEvent.DamageCause cause = event.getCause();
    if (cause != EntityDamageEvent.DamageCause.ENTITY_ATTACK && cause != EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {
      return;
    }
    if (event.getFinalDamage() <= 0.0 || damager.getAttackCooldown() < 0.9F) {
      return;
    }
    ItemStack item = damager.getInventory().getItemInMainHand();
    if (CustomItem.fromItem(item) != CustomItem.ANCIENTBLADE) {
      return;
    }
    AncientBladeAbility.spawnHitArc(damager);
    AncientBladeAbility.handlePlayerHit(damager, event);
  }

  @EventHandler
  public void onFallDamage(EntityDamageEvent event) {
    if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
      return;
    }
    if (!(event.getEntity() instanceof Player player)) {
      return;
    }
    if (AncientBladeAbility.hasFallProtection(player)) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    UUID id = event.getPlayer().getUniqueId();
    AncientBladeAbility.cleanupPlayer(id);
  }
}
