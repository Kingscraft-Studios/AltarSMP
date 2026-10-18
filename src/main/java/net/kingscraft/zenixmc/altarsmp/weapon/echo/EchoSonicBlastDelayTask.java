package net.kingscraft.zenixmc.altarsmp.weapon.echo;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class EchoSonicBlastDelayTask extends BukkitRunnable {
  public final Player player;

  public EchoSonicBlastDelayTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    EchoAbility.launchSonicBlast(this.player);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fo.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */