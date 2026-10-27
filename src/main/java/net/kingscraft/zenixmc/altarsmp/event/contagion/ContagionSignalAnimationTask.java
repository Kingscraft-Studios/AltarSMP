package net.kingscraft.zenixmc.altarsmp.event.contagion;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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
      AltarRitualListener.contagionInteractions.put(this.interaction, AltarRitualListener.CONTAGION_SIGNAL_HEALTH);
      this.interaction.setResponsive(true);
      for (Player player : Bukkit.getOnlinePlayers()) {
        this.bossBar.addPlayer(player);
        player.playSound(player, Sound.ENTITY_WITHER_SPAWN, 1.0F, 1.0F);
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
    }
      Component healthBar = Component.empty();
    int i = AltarRitualListener.contagionInteractions.get(this.interaction);
    int j = AltarRitualListener.CONTAGION_SIGNAL_HEALTH - i;
    int b;
for (b = 0; b < i; b++)
      healthBar = healthBar.append(Component.text("|", NamedTextColor.GREEN));
    for (b = 0; b < j; b++)
      healthBar = healthBar.append(Component.text("|", NamedTextColor.GRAY));
    this.textDisplay.text(healthBar);
    this.bossBar.setProgress(1.0D - (double)this.ticksLived / (double)this.duration);
    this.ticksLived++;
    this.signalHealth += this.healthDecrement;
  }



}
