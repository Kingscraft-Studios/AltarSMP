package net.kingscraft.zenixmc.altarsmp.illusion;

import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.scheduler.BukkitTask;

record DisguiseEntityTask(Entity entity, BukkitTask task, BossBar bossBar) {
  public Entity getEntity() {
    return entity();
  }
  public BukkitTask getBukkitTask() {
    return task();
  }
  public BossBar getBossbar() {
    return bossBar();
  }
}
