package net.kingscraft.zenixmc.altarsmp.weapon.knightfall;

import org.bukkit.entity.Player;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.KillTracker;

public class KnightFallKillTracker extends KillTracker {
  public static boolean bool;

  static {
    bool = AltarSMP.getInstance().getConfig().getBoolean("nimlot", false);
  }

  public KnightFallKillTracker(AltarSMP plugin) {
    super(plugin, "knightfallkills.yml");
  }

  @Override
  protected boolean forceMax() {
    return bool;
  }

  @Override
  public void setKillCount(Player player, int killCount) {
    if (bool) {
      return;
    }
    super.setKillCount(player, killCount);
    new KnightfallItemRestoreTask(player).runTaskLater(this.plugin, 1L);
  }
}
