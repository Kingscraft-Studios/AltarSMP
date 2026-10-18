package pl;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class WitherBoneChargeBarTask extends BukkitRunnable {
  
  
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (!WitherBoneAbility.cleansingChargeBars.containsKey(player.getUniqueId()))
          return; 
      }{
        if (!WitherBoneAbility.hasWitheredBoneBlade(player))
          return; 
      }int i = ((Integer) WitherBoneAbility.cleansingChargeBars.getOrDefault(player.getUniqueId(), Integer.valueOf(0))).intValue();
      String str = "§f☠ -§7";
      for (int b = 1; b < WitherBoneAbility.cleansingRequiredBars + 1; b++) {
        String str1 = "§7";
        if (b <= i)
          str1 = "§8"; 
        str = str + str1 + "|";
      } 
      player.sendActionBar(str);
    } 
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fg.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */