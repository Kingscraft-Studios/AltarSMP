package net.kingscraft.zenixmc.altarsmp.armor.copper;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class CopperLeggingsEventTask extends BukkitRunnable {
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
            this.eventManager.playerHoldingTimes.put(player.getUniqueId(), Integer.valueOf(((Integer)this.eventManager.playerHoldingTimes.getOrDefault(player.getUniqueId(), Integer.valueOf(0))).intValue() + 1));
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
          Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + ChatColor.BOLD.toString() + player.getName() + "§r has the core in " + this.eventManager.getWorldDisplayName(player.getWorld()) + " at (" + location.getBlockX() + ", " + location.getBlockY() + ", " + location.getBlockZ() + ")");
        } 
      }} 
    this.elapsedTicks++;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gh.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */