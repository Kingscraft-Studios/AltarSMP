package net.kingscraft.zenixmc.altarsmp.altars2;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitTask;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.ancientblade.AncientBladeListener;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.dragonrend.DragonrendListener;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.omen.OmenListener;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.tidebreaker.TidebreakerListener;
import net.kingscraft.zenixmc.altarsmp.altars2.ability.withersymbiote.WitherSymbioteListener;
import net.kingscraft.zenixmc.altarsmp.altars2.kill.Altars2KillListener;
import net.kingscraft.zenixmc.altarsmp.altars2.task.Altars2PassiveTask;
import net.kingscraft.zenixmc.altarsmp.core.tracker.KillTracker;

public final class Altars2 {
  private static boolean enabled;
  private static KillTracker killTracker;
  private static BukkitTask passiveTask;

  private Altars2() {
  }

  public static void bootstrap(AltarSMP plugin) {
    if (enabled) {
      return;
    }
    killTracker = new KillTracker(plugin, "ancientbladekills.yml");
    PluginManager pluginManager = Bukkit.getPluginManager();
    pluginManager.registerEvents(new Altars2KillListener(), plugin);
    pluginManager.registerEvents(new TidebreakerListener(), plugin);
    pluginManager.registerEvents(new AncientBladeListener(), plugin);
    pluginManager.registerEvents(new WitherSymbioteListener(), plugin);
    pluginManager.registerEvents(new OmenListener(), plugin);
    pluginManager.registerEvents(new DragonrendListener(), plugin);
    passiveTask = new Altars2PassiveTask().runTaskTimer(plugin, 20L, 20L);
    enabled = true;
  }

  public static void shutdown() {
    if (killTracker != null) {
      killTracker.flush();
      killTracker = null;
    }
    if (passiveTask != null) {
      passiveTask.cancel();
      passiveTask = null;
    }
    enabled = false;
  }

  public static boolean isEnabled() {
    return enabled;
  }

  public static KillTracker getKillTracker() {
    return killTracker;
  }

  public static int killLevel(Player player) {
    if (!AltarSMP.getInstance().getConfig().getBoolean("killSystem", true)) {
      return 5;
    }
    if (killTracker == null) {
      return 0;
    }
    return Math.min(killTracker.getKillCount(player), 5);
  }
}
