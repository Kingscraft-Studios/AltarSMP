package net.kingscraft.zenixmc.altarsmp.contagion;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class ContagionRitualAnnouncementTask extends BukkitRunnable {
  public final String winnerType;
  
  
  
  public ContagionRitualAnnouncementTask(String paramString) {
        this.winnerType = paramString;
    }
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.sendMessage(" ");
      player.sendMessage("§8>> §a# CONTAGION RITUAL CALIBRATED TO");
      player.sendMessage("§n" + this.winnerType.toUpperCase());
      player.sendMessage(" ");
    } 
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gl.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */