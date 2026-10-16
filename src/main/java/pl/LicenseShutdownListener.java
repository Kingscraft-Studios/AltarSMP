package pl;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LicenseShutdownListener implements Listener {
  private final JavaPlugin plugin;
  
  public LicenseShutdownListener(JavaPlugin paramJavaPlugin) {
    this.plugin = paramJavaPlugin;
  }
  
  @EventHandler
  public void onPluginDisable(PluginDisableEvent paramPluginDisableEvent) {
    if (paramPluginDisableEvent.getPlugin() == this.plugin)
      try {
        LicenseHeartbeatManager.sendHeartbeat(true);
      } catch (Exception exception) {} 
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b0.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */