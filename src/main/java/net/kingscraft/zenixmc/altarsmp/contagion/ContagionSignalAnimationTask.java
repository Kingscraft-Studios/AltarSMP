package net.kingscraft.zenixmc.altarsmp.contagion;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.altar.AltarRitualListener;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.vampire.VampireEventManager;

public class ContagionSignalAnimationTask extends BukkitRunnable {
  public int ticksLived;
  
  public int signalHealth;
  
  public final Interaction interaction;
  
  public final BossBar bossBar;
  
  public final Location location;
  
  public final ItemDisplay itemDisplay;
  
  public final TextDisplay textDisplay;
  
  public final int duration;
  
  public final String winnerType;
  
  public final int healthDecrement;
  
  
  
  public ContagionSignalAnimationTask(Interaction paramInteraction, BossBar paramBossBar, Location paramLocation, ItemDisplay paramItemDisplay, TextDisplay paramTextDisplay, int paramInt1, String paramString, int paramInt2) {
        this.interaction = paramInteraction;
        this.bossBar = paramBossBar;
        this.location = paramLocation;
        this.itemDisplay = paramItemDisplay;
        this.textDisplay = paramTextDisplay;
        this.duration = paramInt1;
        this.winnerType = paramString;
        this.healthDecrement = paramInt2;
        this.ticksLived = 0;
        this.signalHealth = 0;
    }
  
  public void run() {
    if (this.ticksLived == 0) {
      AltarRitualListener.contagionInteractions.put(this.interaction, Integer.valueOf(AltarRitualListener.CONTAGION_SIGNAL_HEALTH));
      this.interaction.setResponsive(true);
      for (Player player : Bukkit.getOnlinePlayers()) {
        this.bossBar.addPlayer(player);
        player.playSound((Entity)player, Sound.ENTITY_WITHER_SPAWN, 1.0F, 1.0F);
      } 
    } 
    {
      if (!this.interaction.isResponsive()) {
        this.location.getWorld().dropItemNaturally(this.location, CustomItemRegistry.getContagionSignal());
        this.interaction.remove();
        this.itemDisplay.remove();
        this.textDisplay.remove();
        this.bossBar.removeAll();
        cancel();
        return;
      } 
    }{
      if (this.ticksLived >= this.duration) {
        VampireEventManager.endVampireEvent(this.winnerType);
        this.itemDisplay.remove();
        this.textDisplay.remove();
        this.bossBar.removeAll();
        cancel();
        return;
      } 
    }String str = "";
    int i = ((Integer) AltarRitualListener.contagionInteractions.get(this.interaction)).intValue();
    int j = AltarRitualListener.CONTAGION_SIGNAL_HEALTH - i;
    int b = 0;
for (b = 0; b < i; b++)
      str = str + "§a|";
    for (b = 0; b < j; b++)
      str = str + "§7|";
    this.textDisplay.setText(str);
    this.bossBar.setProgress(1.0D - (double)this.ticksLived / (double)this.duration);
    this.ticksLived++;
    this.signalHealth += this.healthDecrement;
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gj.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */