package net.kingscraft.zenixmc.altarsmp.bossbar;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class BossBarKeys {
  public static NamespacedKey bossBarKey;

  public BossBarKeys(BossBarManager bossbarManager) {
  }

  static {
    bossBarKey = new NamespacedKey((Plugin)AltarSMP.getInstance(), "bossbar");
  }
}
