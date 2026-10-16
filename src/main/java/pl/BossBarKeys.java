package pl;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;

public class BossBarKeys {
  public static NamespacedKey bossBarKey;

  public BossBarKeys(BossBarManager bossbarManager) {
  }

  static {
    bossBarKey = new NamespacedKey((Plugin)Main.getInstance(), "bossbar");
  }
}
