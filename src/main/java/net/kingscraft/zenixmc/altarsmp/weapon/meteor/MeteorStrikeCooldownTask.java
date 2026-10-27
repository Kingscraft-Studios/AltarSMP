package net.kingscraft.zenixmc.altarsmp.weapon.meteor;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.weapon.gauntlet.EarthGauntletAbility;

public class MeteorStrikeCooldownTask extends BukkitRunnable {
  public final Player player;

  public MeteorStrikeCooldownTask(Player paramPlayer) {
        this.player = paramPlayer;
    }

  public void run() {
    {
      if (CooldownManager.isOnCooldown(this.player.getUniqueId(), "used_meteor")) {
        BossBarManager.createBar(this.player, "Meteor Strike", EarthGauntletAbility.meteorStrikeCooldown, NamedTextColor.YELLOW);
        CooldownManager.setCooldown(this.player.getUniqueId(), EarthGauntletAbility.meteorStrikeCooldownKey, EarthGauntletAbility.meteorStrikeCooldown);
      } 
    }}



}
