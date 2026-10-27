package net.kingscraft.zenixmc.altarsmp.copper.leggings;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class CopperLeggingsEventTask extends BukkitRunnable {
  private static final TextColor COPPER = TextColor.color(0xB06736);
  public int elapsedTicks;

  public double displayRotation;

  public final int eventDurationTicks;

  public final int announcementIntervalSeconds;

  public final CopperLeggingsEventManager eventManager;


  public CopperLeggingsEventTask(CopperLeggingsEventManager copperLeggingsEventManager, int paramInt1, int paramInt2) {
        this.eventManager = copperLeggingsEventManager;
        this.eventDurationTicks = paramInt1;
        this.announcementIntervalSeconds = paramInt2;
        this.elapsedTicks = 0;
        this.displayRotation = 0.0;
    }

  public void run() {
    {
      if (!AltarSMP.getInstance().getConfig().getBoolean("leggingsActive", false)) {
        this.eventManager.cleanupEventEntities();
        cancel();
        return;
      } 
    }{
      if (this.elapsedTicks >= this.eventDurationTicks) {
        this.eventManager.endLeggingsEvent();
        cancel();
        return;
      } 
    }this.displayRotation += 0.1D;
    for (Player player : Bukkit.getOnlinePlayers()) {
      boolean bool = false;
      for (ItemStack itemStack : player.getInventory().getContents()) {
        if (this.eventManager.isCopperCore(itemStack)) {
          bool = true;
          break;
        } 
      } 
      {
        if (bool) {
          {
            this.eventManager.playerHoldingTimes.put(player.getUniqueId(), this.eventManager.playerHoldingTimes.getOrDefault(player.getUniqueId(), 0) + 1);
            if (!this.eventManager.playerCoreDisplays.containsKey(player.getUniqueId()))
              this.eventManager.spawnPlayerCoreDisplay(player);
          }{
            this.eventManager.updatePlayerCoreDisplay(player, this.displayRotation);
            if (this.elapsedTicks % 20 == 0)
              player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 35, 0, false, false, false)); 
          }} else {
          this.eventManager.removePlayerCoreDisplay(player);
        } 
      }{
        if (bool && this.elapsedTicks % (this.announcementIntervalSeconds * 20) == 0) {
          Location location = player.getLocation();
          Bukkit.broadcast(Component.text()
              .append(Component.text(player.getName(), COPPER, TextDecoration.BOLD))
              .append(Component.text(" has the core in " + this.eventManager.getWorldDisplayName(player.getWorld())
                  + " at (" + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ() + ")"))
              .build());
        } 
      }} 
    this.elapsedTicks++;
  }


}
