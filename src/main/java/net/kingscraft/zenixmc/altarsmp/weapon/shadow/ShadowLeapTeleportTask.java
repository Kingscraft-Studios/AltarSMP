package net.kingscraft.zenixmc.altarsmp.weapon.shadow;

import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;

class ShadowLeapTeleportTask extends BukkitRunnable {
  public final Player player;

  public final Location targetLocation;


  public ShadowLeapTeleportTask(Player paramPlayer, Location paramLocation) {
        this.player = paramPlayer;
        this.targetLocation = paramLocation;
    }

  public void run() {
    Vector vector1 = this.player.getVelocity();
    Vector vector2 = this.player.getLocation().getDirection();
    {
      this.targetLocation.setDirection(vector2);
      this.player.teleport(this.targetLocation);
      this.player.setVelocity(vector1);
      if (!CooldownManager.isOnCooldown(this.player.getUniqueId(), "shadwoleap")) {
        BossBarManager.createBar(this.player, "Shadow Leap", ShadowBladeAbility.leapCooldown, NamedTextColor.YELLOW);
        CooldownManager.setCooldown(this.player.getUniqueId(), "shadwoleap", ShadowBladeAbility.leapCooldown);
      } 
    }{
      if (AltarSMP.getInstance().getConfig().getBoolean("shadowBladeBorderLogic", true))
        this.player.setWorldBorder(null);
    }for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (!player.equals(this.player))
          player.showPlayer(AltarSMP.getInstance(), this.player);
      }} 
    this.player.removePotionEffect(PotionEffectType.INVISIBILITY);
  }


}
