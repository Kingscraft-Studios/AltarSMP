package net.kingscraft.zenixmc.altarsmp.weapon.witherbone;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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
      }int i = WitherBoneAbility.cleansingChargeBars.getOrDefault(player.getUniqueId(), 0);
      Component chargeBar = Component.text("☠ -", NamedTextColor.WHITE);
      for (int b = 1; b < WitherBoneAbility.cleansingRequiredBars + 1; b++)
        chargeBar = chargeBar.append(Component.text("|", b <= i ? NamedTextColor.DARK_GRAY : NamedTextColor.GRAY));
      player.sendActionBar(chargeBar);
    } 
  }


}
