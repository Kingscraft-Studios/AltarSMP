package net.kingscraft.zenixmc.altarsmp.altars2.ability.withersymbiote;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;

public class WitherSymbioteListener implements Listener {

  @EventHandler
  public void onJoin(PlayerJoinEvent event) {
    WitherSymbioteAbility.handleJoin(event.getPlayer());
  }

  @EventHandler
  public void onQuit(PlayerQuitEvent event) {
    WitherSymbioteAbility.handleQuit(event.getPlayer());
  }

  @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
  public void onDamage(EntityDamageByEntityEvent event) {
    if (!(event.getDamager() instanceof Player damager)) {
      if (event.getEntity() instanceof Player victim) {
        if (WitherSymbioteAbility.isRampaging(victim.getUniqueId())) {
          WitherSymbioteAbility.loseRampageBar(victim);
        }
      }
      return;
    }
    if (WorldGuardHook.isBlocked(event.getEntity().getLocation())) {
      return;
    }
    LivingEntity target = event.getEntity() instanceof LivingEntity living ? living : null;
    if (!isHoldingWeapon(damager)) {
      if (target instanceof Player victim && WitherSymbioteAbility.isRampaging(victim.getUniqueId())) {
        WitherSymbioteAbility.loseRampageBar(victim);
      }
      return;
    }
    if (target == null || event.getFinalDamage() <= 0.0D) {
      return;
    }
    if (damager.getAttackCooldown() < 0.9F) {
      return;
    }
    if (WitherSymbioteAbility.isArmed(damager.getUniqueId()) && target instanceof Player victim && !victim.getUniqueId().equals(damager.getUniqueId())) {
      WitherSymbioteAbility.infectTarget(damager, victim);
      event.setCancelled(false);
      return;
    }
    WitherSymbioteAbility.tryPassOn(damager, target);
    if (WitherSymbioteAbility.isRampaging(damager.getUniqueId())) {
      WitherSymbioteAbility.gainRampageBars(damager);
    }
    if (target instanceof Player victim && WitherSymbioteAbility.isRampaging(victim.getUniqueId())) {
      WitherSymbioteAbility.loseRampageBar(victim);
    }
  }

  private boolean isHoldingWeapon(Player player) {
    ItemStack main = player.getInventory().getItemInMainHand();
    if (CustomItem.fromItem(main) == CustomItem.WITHERSYMBIOTE) {
      return true;
    }
    ItemStack off = player.getInventory().getItemInOffHand();
    return CustomItem.fromItem(off) == CustomItem.WITHERSYMBIOTE;
  }
}
