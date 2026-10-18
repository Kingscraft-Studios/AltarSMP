package net.kingscraft.zenixmc.altarsmp.weapon.meteor;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.weapon.earth.EarthGauntletAbility;

public class MeteorStrikeLaunchTask extends BukkitRunnable {
  public final Player player;
  
  public MeteorStrikeLaunchTask(EarthGauntletAbility earthGauntletAbility, Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    this.player.setVelocity(this.player.getVelocity().add(new Vector(0.0D, 0.3D, 0.0D)));
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ed.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */