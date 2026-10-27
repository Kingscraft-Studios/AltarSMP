package net.kingscraft.zenixmc.altarsmp.altarS2;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.scheduler.BukkitTask;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.ancientblade.AncientBladeListener;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.dragonrend.DragonrendListener;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.omen.OmenListener;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.tidebreaker.TidebreakerListener;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.withersymbiote.WitherSymbioteListener;
import net.kingscraft.zenixmc.altarsmp.altarS2.core.AltarS2KillListener;
import net.kingscraft.zenixmc.altarsmp.altarS2.core.AltarS2PassiveTask;
import net.kingscraft.zenixmc.altarsmp.core.KillTracker;

public final class AltarS2 {
  private static boolean enabled;
  private static KillTracker killTracker;
  private static BukkitTask passiveTask;

  private AltarS2() {
  }

  public static void bootstrap(AltarSMP plugin) {
    if (enabled) {
      return;
    }
    killTracker = new KillTracker(plugin, "ancientbladekills.yml");
    PluginManager pluginManager = Bukkit.getPluginManager();
    pluginManager.registerEvents(new AltarS2KillListener(), plugin);
    pluginManager.registerEvents(new TidebreakerListener(), plugin);
    pluginManager.registerEvents(new AncientBladeListener(), plugin);
    pluginManager.registerEvents(new WitherSymbioteListener(), plugin);
    pluginManager.registerEvents(new OmenListener(), plugin);
    pluginManager.registerEvents(new DragonrendListener(), plugin);
    passiveTask = new AltarS2PassiveTask().runTaskTimer(plugin, 20L, 20L);
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
