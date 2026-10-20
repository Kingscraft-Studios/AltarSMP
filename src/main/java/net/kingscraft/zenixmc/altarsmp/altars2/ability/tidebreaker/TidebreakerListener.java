package net.kingscraft.zenixmc.altarsmp.altars2.ability.tidebreaker;

import java.util.UUID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Trident;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class TidebreakerListener implements Listener {
  @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
  public void onProjectileHit(ProjectileHitEvent event) {
    Entity projectile = event.getEntity();
    if (!(projectile instanceof Trident)) {
      return;
    }
    TidebreakerAbility.handleProjectileLanding(projectile.getUniqueId(), projectile.getLocation());
  }

  @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
  public void onEntityDamage(EntityDamageEvent event) {
    if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
      return;
    }
    UUID uuid = event.getEntity().getUniqueId();
    Long until = TidebreakerAbility.fallImmunity.get(uuid);
    if (until == null || System.currentTimeMillis() > until) {
      return;
    }
    event.setCancelled(true);
    if (event.getEntity() instanceof LivingEntity living) {
      living.setFallDistance(0.0F);
    }
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent event) {
    TidebreakerAbility.handleQuit(event.getPlayer().getUniqueId());
  }
}
