package net.kingscraft.zenixmc.altarsmp.listener;

import java.util.ArrayList;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Warden;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

public class MobDropListener implements Listener {
   public AltarSMP plugin;

   public MobDropListener(AltarSMP var1) {
      this.plugin = var1;
   }

   @EventHandler(priority = EventPriority.MONITOR)
   public void onPlayerDeath(PlayerDeathEvent var1) {
      Player var2 = var1.getEntity();
      if (Bukkit.getPluginManager().getPlugin("AltarS2") == null) {
         if (!var1.isCancelled()) {
            if (AltarSMP.getInstance().getConfig().getBoolean("drop_heads", true)) {
               if (var1.getEntity().getKiller() instanceof Player var3) {
                  World var11 = var2.getWorld();
                  Location var5 = var2.getLocation();
                  ItemStack var6 = new ItemStack(Material.PLAYER_HEAD);
                  SkullMeta var7 = (SkullMeta)var6.getItemMeta();
                  var7.setOwningPlayer(Bukkit.getOfflinePlayer(var2.getUniqueId()));
                  var7.setDisplayName(ChatColor.RESET + var2.getName() + "'s Head");
                  ArrayList var8 = new ArrayList();
                  String var10001 = String.valueOf(ChatColor.GOLD);
                  String var10002 = String.valueOf(ChatColor.YELLOW);
                  String var9 = var3.getName();
                  String var10 = var10002;
                  var8.add(var10001 + "Killed by " + var10 + var9);
                  var7.setLore(var8);
                  var6.setItemMeta(var7);
                  if (AltarSMP.getInstance().getConfig().getBoolean("give_dropped_head_to_killer", true)) {
                     var3.getInventory().addItem(new ItemStack[]{var6});
                  } else {
                     var11.dropItemNaturally(var5, var6);
                  }
               }
            }
         }
      }
   }

   @EventHandler
   public void onEntityDeath(EntityDeathEvent var1) {
      if (!var1.isCancelled()) {
         if (Bukkit.getPluginManager().getPlugin("AltarS2") == null) {
            int var2 = this.plugin.getConfig().getInt("WardenHeartDropChance", 25);
            Random var3 = new Random();
            if (var1.getEntity() instanceof Warden && var3.nextInt(100) <= var2) {
               var1.getDrops()
                  .add(
                     CustomItemRegistry.getWardenHeart()
                  );
            }
         }
      }
   }

}
