package net.kingscraft.zenixmc.altarsmp.crazy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitTask;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

public class CrazySlotsListener implements Listener {
   public final AltarSMP plugin;
   public static Map<UUID, CrazySlotsItemData> activeCrazySlots;
   public static Map<UUID, BukkitTask> expirationTasks;

   public CrazySlotsListener(AltarSMP var1) {
      this.plugin = var1;
      activeCrazySlots = new ConcurrentHashMap<>();
      expirationTasks = new ConcurrentHashMap<>();
   }

   @EventHandler
   public void onPlayerInteract(PlayerInteractEvent var1) {
      Player var2 = var1.getPlayer();
      ItemStack var3 = var2.getInventory().getItemInMainHand();
      if (!var3.isSimilar(
         CustomItemRegistry.getCrazySlots()
      )) {
         return;
      }

      if (CooldownManager.isOnCooldown(var2.getUniqueId(), "crazy_slots")) {
         var2.sendMessage(ChatColor.RED + "Crazy Slots is on cooldown!");
         return;
      }

      var1.setCancelled(true);
      var3.setAmount(var3.getAmount() - 1);
      this.startCrazySlots(var2);
   }

   public void startCrazySlots(Player var1) {
      UUID var2 = var1.getUniqueId();
      int var3 = this.plugin.getConfig().getInt("crazySlotsCooldown", 60);
      int var4 = this.plugin.getConfig().getInt("crazySlotsDuration", 30);
      String var5 = UUID.randomUUID().toString();
      ItemStack var6 = this.createRandomCrazySlotsItem(var1, var5);
      activeCrazySlots.put(
         var2, new CrazySlotsItemData(var5, var6)
      );
      BossBarManager.createBar(
         var1, "Crazy Slots", var3, ChatColor.YELLOW
      );
      CooldownManager.setCooldown(
         var1.getUniqueId(), "crazy_slots", var3
      );
      BukkitTask var7 = new CrazySlotsExpirationTask(this, var1, var2)
         .runTaskLater(this.plugin, var4 * 20L);
      expirationTasks.put(var2, var7);
   }

   public ItemStack createRandomCrazySlotsItem(Player var1, String var2) {
      List var3 = Arrays.asList(
         CustomItemRegistry.getBoneBlade(),
         CustomItemRegistry.getVulcanCrossbow(),
         CustomItemRegistry.getBloodlust(
            null, false
         ),
         CustomItemRegistry.getFrostScythe(),
         CustomItemRegistry.getNightpiercer(),
         CustomItemRegistry.getHyperion(),
         CustomItemRegistry.getWindweaver(),
         CustomItemRegistry.getWitheredBone(),
         CustomItemRegistry.getShadowBlade(),
         CustomItemRegistry.getPureBlade(),
         CustomItemRegistry.getCutlass(),
         CustomItemRegistry.getEarthGauntlet(),
         CustomItemRegistry.getPaladinAxe(),
         CustomItemRegistry.getPaleCannon(),
         CustomItemRegistry.getKnightfall(
            var1, false
         ),
         CustomItemRegistry.getEcho(),
         CustomItemRegistry.getEclipse()
      );
      ItemStack var4 = ((ItemStack)var3.get(ThreadLocalRandom.current().nextInt(var3.size()))).clone();
      ItemMeta var5 = var4.getItemMeta();
      if (var5 != null) {
         NamespacedKey var6 = new NamespacedKey(this.plugin, "crazy_slots_item");
         var5.getPersistentDataContainer().set(var6, PersistentDataType.STRING, var2);
         var4.setItemMeta(var5);
      }

      var1.getInventory().setItemInMainHand(var4);
      return var4;
   }

   public static void clearCrazySlots(Player var0) {
      UUID var1 = var0.getUniqueId();
      CrazySlotsItemData var2 = activeCrazySlots.remove(var1);
      if (var2 == null) {
         return;
      }
      BukkitTask var3 = expirationTasks.remove(var1);
      if (var3 != null) {
         var3.cancel();
      }

      ItemStack var4 = CustomItemRegistry.getCrazySlots();

      for (ItemStack var6 : getPlayerItems(var0)) {
         if (isCrazySlotsItem(var6, var2.itemId)) {
            var6.setType(var4.getType());
            var6.setItemMeta(var4.getItemMeta());
         }
      }
   }

   public static List<ItemStack> getPlayerItems(Player var0) {
      List var1 = new ArrayList();
      PlayerInventory var2 = var0.getInventory();
      var1.addAll(Arrays.asList(var2.getContents()));
      var1.add(var2.getItemInOffHand());
      var1.add(var0.getItemOnCursor());
      var1.addAll(Arrays.asList(var2.getArmorContents()));
      if (var0.getOpenInventory().getTopInventory() instanceof CraftingInventory var3) {
         var1.addAll(Arrays.asList(var3.getMatrix()));
      }

      return var1;
   }

   public static boolean isCrazySlotsItem(ItemStack var0, String var1) {
      if (var0 == null || var1 == null) {
         return false;
      }

      ItemMeta var2 = var0.getItemMeta();
      if (var2 == null) {
         return false;
      }

      NamespacedKey var3 = new NamespacedKey(AltarSMP.getInstance(), "crazy_slots_item");
      if (!var2.getPersistentDataContainer().has(var3, PersistentDataType.STRING)) {
         return false;
      }

      String var4 = (String)var2.getPersistentDataContainer().get(var3, PersistentDataType.STRING);
      return var1.equals(var4);
   }

   public static boolean isCrazySlotsItem(ItemStack var0) {
      if (var0 == null) {
         return false;
      }

      ItemMeta var1 = var0.getItemMeta();
      if (var1 == null) {
         return false;
      }

      NamespacedKey var2 = new NamespacedKey(AltarSMP.getInstance(), "crazy_slots_item");
      return var1.getPersistentDataContainer().has(var2, PersistentDataType.STRING);
   }

   @EventHandler
   public void onBlockInteract(PlayerInteractEvent var1) {
      if (var1.getAction() != Action.RIGHT_CLICK_BLOCK) {
         return;
      }

      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (!activeCrazySlots.containsKey(var3)) {
         return;
      }

      CrazySlotsItemData var4 = activeCrazySlots.get(var3);
      if (var1.getClickedBlock() == null) {
         return;
      }

      if ((var1.getClickedBlock().getType() == Material.DECORATED_POT || var1.getClickedBlock().getType().toString().contains("_SHELF"))
         && isCrazySlotsItem(var1.getItem(), var4.itemId)) {
         var1.setCancelled(true);
      }
   }

   @EventHandler
   public void onEntityInteract(PlayerInteractEntityEvent var1) {
      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (!activeCrazySlots.containsKey(var3)) {
         return;
      }

      CrazySlotsItemData var4 = activeCrazySlots.get(var3);
      if (var1.getRightClicked().getType() != EntityType.ITEM_FRAME && var1.getRightClicked().getType() != EntityType.GLOW_ITEM_FRAME) {
         return;
      }

      if (isCrazySlotsItem(var1.getPlayer().getInventory().getItemInMainHand(), var4.itemId)) {
         var1.setCancelled(true);
      }
   }

   @EventHandler
   public void onInventoryClick(InventoryClickEvent var1) {
      if (!(var1.getWhoClicked() instanceof Player)) {
         return;
      }
      Player var2 = (Player)var1.getWhoClicked();
      UUID var3 = var2.getUniqueId();
      if (!activeCrazySlots.containsKey(var3)) {
         return;
      }
      CrazySlotsItemData var4 = activeCrazySlots.get(var3);
      if (var1.getView().getType() == InventoryType.CRAFTING) {
         return;
      }
      if (var1.getClick() == ClickType.NUMBER_KEY) {
         ItemStack var5 = var2.getInventory().getItem(var1.getHotbarButton());
         if (isCrazySlotsItem(
            var5, var4.itemId
         )) {
            var1.setCancelled(true);
            return;
         }
      }
      if (isCrazySlotsItem(
         var1.getCurrentItem(), var4.itemId
      )) {
         var1.setCancelled(true);
         return;
      }
      if (isCrazySlotsItem(
         var1.getCursor(), var4.itemId
      )) {
         var1.setCancelled(true);
      }
   }

   @EventHandler
   public void onInventoryMoveItem(InventoryMoveItemEvent var1) {
      ItemStack var2 = var1.getItem();

      for (CrazySlotsItemData var4 : activeCrazySlots.values()) {
         if (isCrazySlotsItem(
            var2, var4.itemId
         )) {
            var1.setCancelled(true);
            return;
         }
      }
   }

   @EventHandler
   public void onPlayerDropItem(PlayerDropItemEvent var1) {
      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (!activeCrazySlots.containsKey(var3)) {
         return;
      }

      CrazySlotsItemData var4 = activeCrazySlots.get(var3);
      if (isCrazySlotsItem(var1.getItemDrop().getItemStack(), var4.itemId)) {
         var1.setCancelled(true);
      }
   }

   @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
   public void onPlayerDeath(PlayerDeathEvent var1) {
      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (!activeCrazySlots.containsKey(var1.getPlayer().getUniqueId())) {
         return;
      }

      CrazySlotsItemData var4 = activeCrazySlots.remove(var3);
      List var5 = new ArrayList();

      for (ItemStack var7 : var1.getDrops()) {
         if (isCrazySlotsItem(var7, var4.itemId)) {
            var7.setAmount(0);
            var5.add(CustomItemRegistry.getCrazySlots());
         }
      }

      var1.getDrops().addAll(var5);
      expirationTasks.remove(var1.getPlayer().getUniqueId());
   }

   @EventHandler
   public void onPlayerQuit(PlayerQuitEvent var1) {
      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (activeCrazySlots.containsKey(var3)) {
         clearCrazySlots(var2);
      }
   }

   @EventHandler
   public void onPluginDisable(PluginDisableEvent var1) {
      if (!var1.getPlugin().equals(this.plugin)) {
         return;
      }

      for (UUID var3 : new HashSet<>(activeCrazySlots.keySet())) {
         Player var4 = Bukkit.getPlayer(var3);
         if (var4 != null && var4.isOnline()) {
            clearCrazySlots(var4);
         }
      }

      expirationTasks.values().forEach(BukkitTask::cancel);
      activeCrazySlots.clear();
      expirationTasks.clear();
   }

}