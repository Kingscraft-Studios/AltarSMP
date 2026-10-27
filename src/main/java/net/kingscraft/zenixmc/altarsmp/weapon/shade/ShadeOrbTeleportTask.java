package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import java.util.List;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class ShadeOrbTeleportTask extends BukkitRunnable {
  public final List<ItemDisplay> orbs;

  public final Player player;

  public ShadeOrbTeleportTask(List<ItemDisplay> paramList, Player paramPlayer) {
        this.orbs = paramList;
        this.player = paramPlayer;
    }

  public void run() {
    for (ItemDisplay itemDisplay : this.orbs)
      itemDisplay.setTeleportDuration(20); 
    (new ShadeOrbRecoilTask(this)).runTaskLater(AltarSMP.getInstance(), 3L);
  }
}
