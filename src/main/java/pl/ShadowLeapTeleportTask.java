package pl;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class ShadowLeapTeleportTask extends BukkitRunnable {
  final Player player;
  
  final Location targetLocation;
  
  
  
  ShadowLeapTeleportTask(Player paramPlayer, Location paramLocation) {
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
        BossBarManager.createBar(this.player, "Shadow Leap", ShadowBladeAbility.leapCooldown, ChatColor.YELLOW);
        CooldownManager.setCooldown(this.player.getUniqueId(), "shadwoleap", ShadowBladeAbility.leapCooldown);
      } 
    }{
      if (Main.getInstance().getConfig().getBoolean("shadowBladeBorderLogic", true))
        this.player.setWorldBorder(null);
    }for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (!player.equals(this.player))
          player.showPlayer((Plugin)Main.getInstance(), this.player);
      }} 
    this.player.removePotionEffect(PotionEffectType.INVISIBILITY);
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fa.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */