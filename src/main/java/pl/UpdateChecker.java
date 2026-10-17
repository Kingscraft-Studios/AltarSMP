package pl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;

public class UpdateChecker implements Listener {
  
  @EventHandler
  public void handlePlayerJoin(PlayerJoinEvent paramPlayerJoinEvent) {
    {
      if (paramPlayerJoinEvent.getPlayer().isOp())
        checkForUpdate(paramPlayerJoinEvent.getPlayer());
    }}
  
  @EventHandler
  public void handlePluginEnable(PluginEnableEvent paramPluginEnableEvent) {
    {
      if (!paramPluginEnableEvent.getPlugin().getName().equalsIgnoreCase(Main.getInstance().getName()))
        return; 
    }for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (player.isOp())
          checkForUpdate(player);
      }} 
  }
  
  public void checkForUpdate(Player paramPlayer) {
    Bukkit.getAsyncScheduler().runNow((Plugin)Main.getInstance(), paramTask -> fetchUpdateVersion(paramPlayer, paramTask));
  }
  
  private static void fetchUpdateVersion(Player paramPlayer, ScheduledTask paramScheduledTask) {
    try {
      String str = "https://gist.githubusercontent.com/Doomwen/407b6dc6cf7e8d23432b670045523226/raw/updates.txt?t=" + System.currentTimeMillis();
      URL url = new URL(str);
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
      String str2 = null;
      String str3;
      while ((str3 = bufferedReader.readLine()) != null) {
        str3 = str3.trim();
        if (str3.startsWith("Altar:")) {
          str2 = str3.split(":")[1].trim();
          break;
        }
      }
      bufferedReader.close();
      String str4 = str2;
      String str5 = Main.getInstance().getDescription().getVersion();
      if (!str4.equalsIgnoreCase(str5)) {
        Bukkit.getRegionScheduler().execute(Main.getInstance(), paramPlayer.getLocation(), () -> sendUpdateNotification(paramPlayer, str4));
      }
    } catch (Exception e) {
      Main.getInstance().getLogger().warning("Failed to check for updates: " + e.getMessage());
    }
  }
  
  private static void sendUpdateNotification(Player paramPlayer, String paramString) {
    paramPlayer.sendMessage(String.valueOf(ChatColor.GOLD) + "[AltarSMP] A new version is available: v" + paramString);
    paramPlayer.sendMessage(String.valueOf(ChatColor.AQUA) + "Download it here:");
    paramPlayer.sendMessage(String.valueOf(ChatColor.YELLOW) + "https://mc-shop-plugins.tebex.io");
    paramPlayer.sendMessage(String.valueOf(ChatColor.YELLOW) + "or https://discord.gg/svt2AHNK7J");
  }}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b_.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */