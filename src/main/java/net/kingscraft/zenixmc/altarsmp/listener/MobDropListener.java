package net.kingscraft.zenixmc.altarsmp.listener;

import java.util.ArrayList;
import java.util.Random;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.ElderGuardian;
import org.bukkit.entity.EnderDragon;
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
import net.kingscraft.zenixmc.altarsmp.item.CustomItemType;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

public class MobDropListener implements Listener {
   public AltarSMP plugin;

   public MobDropListener(AltarSMP var1) {
      this.plugin = var1;
   }

   @EventHandler(priority = EventPriority.MONITOR)
   public void onPlayerDeath(PlayerDeathEvent var1) {
      Player var2 = var1.getEntity();
      if (!var1.isCancelled()) {
         if (AltarSMP.getInstance().getConfig().getBoolean("drop_heads", true)) {
            if (var1.getEntity().getKiller() instanceof Player var3) {
               World var11 = var2.getWorld();
               Location var5 = var2.getLocation();
               ItemStack var6 = new ItemStack(Material.PLAYER_HEAD);
               SkullMeta var7 = (SkullMeta)var6.getItemMeta();
               var7.setOwningPlayer(Bukkit.getOfflinePlayer(var2.getUniqueId()));
               var7.displayName(Component.text(var2.getName() + "'s Head"));
               ArrayList<Component> var8 = new ArrayList<>();
               var8.add(Component.text("Killed by ", NamedTextColor.GOLD).append(Component.text(var3.getName(), NamedTextColor.YELLOW)));
               var7.lore(var8);
               var6.setItemMeta(var7);
               if (AltarSMP.getInstance().getConfig().getBoolean("give_dropped_head_to_killer", true)) {
                  var3.getInventory().addItem(var6);
               } else {
                  var11.dropItemNaturally(var5, var6);
               }
            }
         }
      }
   }

   @EventHandler
   public void onEntityDeath(EntityDeathEvent var1) {
      if (var1.isCancelled()) {
         return;
      }
      int var2 = this.plugin.getConfig().getInt("WardenHeartDropChance", 100);
      Random var3 = new Random();
      if (var1.getEntity() instanceof Warden && var3.nextInt(100) <= var2) {
         var1.getDrops()
            .add(
               CustomItemRegistry.getWardenHeart()
            );
      }
      int dragonChance = this.plugin.getConfig().getInt("DragonHeartDropChance", 100);
      if (var1.getEntity() instanceof EnderDragon && dragonChance > 0 && var3.nextInt(100) < dragonChance) {
         var1.getDrops().add(CustomItemType.DRAGON_HEART.getItem());
      }
      int fragmentChance = this.plugin.getConfig().getInt("FragmentOfTheSeaDropChance", 100);
      if (var1.getEntity() instanceof ElderGuardian && fragmentChance > 0 && var3.nextInt(100) < fragmentChance) {
         var1.getDrops().add(CustomItemType.FRAGMENT_OF_THE_SEA.getItem());
      }
   }

}
