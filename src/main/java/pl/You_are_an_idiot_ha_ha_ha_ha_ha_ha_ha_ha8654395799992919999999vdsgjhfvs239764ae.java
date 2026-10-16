package pl;

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

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae implements Listener {
   private final Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
   public static Map<UUID, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
   public static Map<UUID, BukkitTask> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
   private static final String[] a;
   private static final String[] b;

   public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae(Main var1) {
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = var1;
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new ConcurrentHashMap<>();
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new ConcurrentHashMap<>();
   }

   @EventHandler
   public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent var1) {
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
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(var2);
   }

   private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(Player var1) {
      UUID var2 = var1.getUniqueId();
      int var3 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getInt("crazySlotsCooldown", 60);
      int var4 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getInt("crazySlotsDuration", 30);
      String var5 = UUID.randomUUID().toString();
      ItemStack var6 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(var1, var5);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(
         var2, new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af(var5, var6)
      );
      BossBarManager.createBar(
         var1, "Crazy Slots", var3, ChatColor.YELLOW
      );
      CooldownManager.setCooldown(
         var1.getUniqueId(), "crazy_slots", var3
      );
      BukkitTask var7 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dq(this, var1, var2)
         .runTaskLater(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, var4 * 20L);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(var2, var7);
   }

   private ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player var1, String var2) {
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
         NamespacedKey var6 = new NamespacedKey(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, "crazy_slots_item");
         var5.getPersistentDataContainer().set(var6, PersistentDataType.STRING, var2);
         var4.setItemMeta(var5);
      }

      var1.getInventory().setItemInMainHand(var4);
      return var4;
   }

   public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player var0) {
      UUID var1 = var0.getUniqueId();
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af var2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.remove(var1);
      if (var2 == null) {
         return;
      }
      BukkitTask var3 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(var1);
      if (var3 != null) {
         var3.cancel();
      }

      ItemStack var4 = CustomItemRegistry.getCrazySlots();

      for (ItemStack var6 : You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(var0)) {
         if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(var6, var2.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
            var6.setType(var4.getType());
            var6.setItemMeta(var4.getItemMeta());
         }
      }
   }

   public static List<ItemStack> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player var0) {
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

   public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack var0, String var1) {
      if (var0 == null || var1 == null) {
         return false;
      }

      ItemMeta var2 = var0.getItemMeta();
      if (var2 == null) {
         return false;
      }

      NamespacedKey var3 = new NamespacedKey(Main.getInstance(), "crazy_slots_item");
      if (!var2.getPersistentDataContainer().has(var3, PersistentDataType.STRING)) {
         return false;
      }

      String var4 = (String)var2.getPersistentDataContainer().get(var3, PersistentDataType.STRING);
      return var1.equals(var4);
   }

   public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack var0) {
      if (var0 == null) {
         return false;
      }

      ItemMeta var1 = var0.getItemMeta();
      if (var1 == null) {
         return false;
      }

      NamespacedKey var2 = new NamespacedKey(Main.getInstance(), "crazy_slots_item");
      return var1.getPersistentDataContainer().has(var2, PersistentDataType.STRING);
   }

   @EventHandler
   public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(PlayerInteractEvent var1) {
      if (var1.getAction() != Action.RIGHT_CLICK_BLOCK) {
         return;
      }

      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(var3)) {
         return;
      }

      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af var4 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(var3);
      if (var1.getClickedBlock() == null) {
         return;
      }

      if ((var1.getClickedBlock().getType() == Material.DECORATED_POT || var1.getClickedBlock().getType().toString().contains("_SHELF"))
         && You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(var1.getItem(), var4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
         var1.setCancelled(true);
      }
   }

   @EventHandler
   public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEntityEvent var1) {
      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(var3)) {
         return;
      }

      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af var4 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(var3);
      if (var1.getRightClicked().getType() != EntityType.ITEM_FRAME && var1.getRightClicked().getType() != EntityType.GLOW_ITEM_FRAME) {
         return;
      }

      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(var1.getPlayer().getInventory().getItemInMainHand(), var4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
         var1.setCancelled(true);
      }
   }

   @EventHandler
   public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(InventoryClickEvent var1) {
      if (!(var1.getWhoClicked() instanceof Player)) {
         return;
      }
      Player var2 = (Player)var1.getWhoClicked();
      UUID var3 = var2.getUniqueId();
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(var3)) {
         return;
      }
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af var4 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(var3);
      if (var1.getView().getType() == InventoryType.CRAFTING) {
         return;
      }
      if (var1.getClick() == ClickType.NUMBER_KEY) {
         ItemStack var5 = var2.getInventory().getItem(var1.getHotbarButton());
         if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
            var5, var4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a
         )) {
            var1.setCancelled(true);
            return;
         }
      }
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
         var1.getCurrentItem(), var4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a
      )) {
         var1.setCancelled(true);
         return;
      }
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
         var1.getCursor(), var4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a
      )) {
         var1.setCancelled(true);
      }
   }

   @EventHandler
   public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(InventoryMoveItemEvent var1) {
      ItemStack var2 = var1.getItem();

      for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af var4 : You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.values()) {
         if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
            var2, var4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a
         )) {
            var1.setCancelled(true);
            return;
         }
      }
   }

   @EventHandler
   public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDropItemEvent var1) {
      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(var3)) {
         return;
      }

      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af var4 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(var3);
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(var1.getItemDrop().getItemStack(), var4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
         var1.setCancelled(true);
      }
   }

   @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
   public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent var1) {
      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(var1.getPlayer().getUniqueId())) {
         return;
      }

      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af var4 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.remove(var3);
      List var5 = new ArrayList();

      for (ItemStack var7 : var1.getDrops()) {
         if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(var7, var4.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
            var7.setAmount(0);
            var5.add(CustomItemRegistry.getCrazySlots());
         }
      }

      var1.getDrops().addAll(var5);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(var1.getPlayer().getUniqueId());
   }

   @EventHandler
   public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerQuitEvent var1) {
      Player var2 = var1.getPlayer();
      UUID var3 = var2.getUniqueId();
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(var3)) {
         You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(var2);
      }
   }

   @EventHandler
   public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PluginDisableEvent var1) {
      if (!var1.getPlugin().equals(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
         return;
      }

      for (UUID var3 : new HashSet<>(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.keySet())) {
         Player var4 = Bukkit.getPlayer(var3);
         if (var4 != null && var4.isOnline()) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(var4);
         }
      }

      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.values().forEach(BukkitTask::cancel);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.clear();
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.clear();
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code
   static {
      a = new String[0];
      b = new String[0];
   }

}