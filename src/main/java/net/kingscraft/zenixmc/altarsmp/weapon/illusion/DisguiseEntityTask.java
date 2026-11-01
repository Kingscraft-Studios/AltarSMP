package net.kingscraft.zenixmc.altarsmp.weapon.illusion;

import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitTask;

public record DisguiseEntityTask(Entity entity, BukkitTask task) {
  public Entity getEntity() {
    return entity;
  }
}
