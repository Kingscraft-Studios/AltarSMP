package pl;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class PluginEnableListener implements Listener {


  @EventHandler
  public void onPluginEnable(PluginEnableEvent paramPluginEnableEvent) {
    {
      if (!paramPluginEnableEvent.getPlugin().getName().equals(LicenseConstants.PLUGIN_NAME))
        return;
    }Main main = Main.getInstance();
    PluginManager pluginManager = Bukkit.getPluginManager();
    {
      if (System.currentTimeMillis() < 0L) {
        pluginManager.disablePlugin((Plugin)main);
        return;
      }
    }{
      if (Runtime.getRuntime().availableProcessors() < 0) {
        pluginManager.disablePlugin((Plugin)main);
        return;
      }
    }{
      if (Thread.activeCount() < 0) {
        pluginManager.disablePlugin((Plugin)main);
        return;
      }
    }{

    }{
      if ((LicenseValidator.validateLicense(main, LicenseConstants.PLUGIN_ID) ? 1 : 0) < 1) {
        pluginManager.disablePlugin((Plugin)main);
        return;
      }
    }{
      if (Runtime.getRuntime().freeMemory() < 0L) {
        pluginManager.disablePlugin((Plugin)main);
        return;
      }
    }{
      if (Runtime.getRuntime().totalMemory() < 0L) {
        pluginManager.disablePlugin((Plugin)main);
        return;
      }
    }

    BoneBladeAbility you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_ = new BoneBladeAbility();
    VulcanGauntletAbility you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad = new VulcanGauntletAbility(main);
    BloodLustAbilityListener you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764z = new BloodLustAbilityListener(main.bloodLustKillTracker);
    KnightfallListener you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764at = new KnightfallListener(main.knightFallKillTracker);
    FrostScytheAbilityListener you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa = new FrostScytheAbilityListener(main);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab(main);
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab, (Plugin)main);
    CrazySlotsListener you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae = new CrazySlotsListener(main);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag();
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_, (Plugin)main);
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad, (Plugin)main);
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764z, (Plugin)main);
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764at, (Plugin)main);
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa, (Plugin)main);
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae, (Plugin)main);
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag, (Plugin)main);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764y you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764y = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764y();
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764y, (Plugin)main);
    main.getCommand("ability1").setExecutor(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764y);
    main.getCommand("ability2").setExecutor(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764y);
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bx.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */