package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.shade.ShadeSoul;

public class SlashSwingTask extends BukkitRunnable {
  final int UNUSED_LITERAL = 1;
  
  public int ticks;
  
  public final Player player;
  
  public SlashSwingTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.ticks = 0;
    }
  
  public void run() {
    if (this.ticks >= 20) {
      cancel();
      return;
    }
    Location location = this.player.getLocation().clone().add(0.0D, 1.0D, 0.0D);
    ShadeSoul.spawnSlashDisplay(location);
    this.ticks++;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e0.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */