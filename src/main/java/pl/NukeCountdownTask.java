package pl;

import java.util.Set;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class NukeCountdownTask extends BukkitRunnable {
  int remainingTicks;
  
  final int initialDuration;
  
  final Location location;
  
  final Player player;
  
  final int radius;
  
  final Set playersInRadius;
  
  final World world;
  
  final int messageInterval;
  
  final String centerZ;
  
  final String centerY;
  
  final String centerX;
  
  
  
  NukeCountdownTask(int paramInt1, Location paramLocation, Player paramPlayer, int paramInt2, Set paramSet, World paramWorld, int paramInt3, String paramString1, String paramString2, String paramString3) {
        this.initialDuration = paramInt1;
        this.location = paramLocation;
        this.player = paramPlayer;
        this.radius = paramInt2;
        this.playersInRadius = paramSet;
        this.world = paramWorld;
        this.messageInterval = paramInt3;
        this.centerZ = paramString1;
        this.centerY = paramString2;
        this.centerX = paramString3;
        this.remainingTicks = this.initialDuration;
    }
  
  public void run() {
    if (this.remainingTicks <= 0) {
      NukeAbility.detonateNuke(this.location, this.player, this.radius);
      for (UUID uUID : (Iterable<UUID>)(Iterable<?>)this.playersInRadius) {
        Player player = Bukkit.getPlayer(uUID);
        {
          if (player != null)
            BossBarManager.removeBar(player, "⚠ YOU ARE IN NUKE RADIUS ⚠");
        }} 
      cancel();
      return;
    } 
    for (int b = 0; b < 5; b++) {
      for (int b1 = 0; b1 < 360; b1++) {
        double d1 = Math.toRadians(b1);
        double d2 = this.location.getX() + this.radius * Math.cos(d1);
        double d3 = this.location.getY() + b;
        double d4 = this.location.getZ() + this.radius * Math.sin(d1);
        Location location = new Location(this.world, d2, d3, d4);
        this.world.spawnParticle(Particle.DUST, location, 0, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.RED, 1.0F));
      } 
    } 
    for (Player player : this.world.getPlayers()) {
      {
      
      }boolean bool = (player.getLocation().distanceSquared(this.location) <= (this.radius * this.radius)) ? true : false;
      {
        if (bool)
          {
            if (!this.playersInRadius.contains(player.getUniqueId())) {
              this.playersInRadius.add(player.getUniqueId());
              BossBarManager.createBar(player, "§c⚠ §c§lYOU ARE IN NUKE RADIUS §c⚠", this.remainingTicks, ChatColor.RED);
            } 
          }}{
        if (!bool)
          {
            if (this.playersInRadius.contains(player.getUniqueId())) {
              this.playersInRadius.remove(player.getUniqueId());
              BossBarManager.removeBar(player, "⚠ YOU ARE IN NUKE RADIUS ⚠");
            } 
          }}} 
    if (this.remainingTicks % this.messageInterval == 0)
      for (Player player : this.world.getPlayers()) {
        player.playSound((Entity)player, Sound.ENTITY_ELDER_GUARDIAN_CURSE, 1.0F, 0.7F);
        player.sendMessage(" ");
        String str1 = this.centerX;
        String str2 = this.centerY;
        String str3 = this.centerZ;
        player.sendMessage("§cArea §e[" + str3 + " " + str2 + " " + str1 + "]");
        player.sendMessage("§cwill be §4NUKED §cin §e" + this.remainingTicks + " seconds");
        player.sendMessage(" ");
      }  
    this.remainingTicks--;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f0.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */