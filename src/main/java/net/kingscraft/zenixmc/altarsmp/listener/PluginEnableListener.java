package net.kingscraft.zenixmc.altarsmp.listener;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.armor.knightfall.KnightfallListener;
import net.kingscraft.zenixmc.altarsmp.event.crazy.CrazySlotsListener;
import net.kingscraft.zenixmc.altarsmp.illusion.IllusionWandAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.blood.BloodLustAbilityListener;
import net.kingscraft.zenixmc.altarsmp.weapon.boneblade.BoneBladeAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.frostscythe.FrostScytheAbilityListener;
import net.kingscraft.zenixmc.altarsmp.weapon.scorching.ScorchingBladeAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.vulcan.VulcanGauntletAbility;

public class PluginEnableListener implements Listener {


  @EventHandler
  public void onPluginEnable(PluginEnableEvent paramPluginEnableEvent) {
    {
      if (!paramPluginEnableEvent.getPlugin().getName().equals(AltarSMP.getInstance().getName()))
        return;
    }
    AltarSMP main = AltarSMP.getInstance();


    BoneBladeAbility boneBladeAbility = new BoneBladeAbility();
    VulcanGauntletAbility vulcanGauntletAbility = new VulcanGauntletAbility(main);
    BloodLustAbilityListener bloodLustAbilityListener = new BloodLustAbilityListener(main.bloodLustKillTracker);
    KnightfallListener knightfallListener = new KnightfallListener(main.knightFallKillTracker);
    FrostScytheAbilityListener frostScytheAbilityListener = new FrostScytheAbilityListener(main);
    IllusionWandAbility illusionWandAbility = new IllusionWandAbility(main);
    Bukkit.getPluginManager().registerEvents(illusionWandAbility, main);
    CrazySlotsListener crazySlotsListener = new CrazySlotsListener(main);
    ScorchingBladeAbility scorchingBladeAbility = new ScorchingBladeAbility();
    Bukkit.getPluginManager().registerEvents(boneBladeAbility, main);
    Bukkit.getPluginManager().registerEvents(vulcanGauntletAbility, main);
    Bukkit.getPluginManager().registerEvents(bloodLustAbilityListener, main);
    Bukkit.getPluginManager().registerEvents(knightfallListener, main);
    Bukkit.getPluginManager().registerEvents(frostScytheAbilityListener, main);
    Bukkit.getPluginManager().registerEvents(crazySlotsListener, main);
    Bukkit.getPluginManager().registerEvents(scorchingBladeAbility, main);
    AbilityInputListener abilityInputListener = new AbilityInputListener();
    Bukkit.getPluginManager().registerEvents(abilityInputListener, main);
    main.getCommand("ability1").setExecutor(abilityInputListener);
    main.getCommand("ability2").setExecutor(abilityInputListener);
  }


}
