// 
// Decompiled by Procyon v0.6.0
// 

package pl;

import org.bukkit.Material;
import org.bukkit.event.block.Action;
import pl.Main;
import pl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af;
import pl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo;
import pl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt;
import pl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dq;
import pl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x;
import org.bukkit.Bukkit;
import java.util.HashSet;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.CraftingInventory;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.NamespacedKey;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.scheduler.BukkitTask;
import java.util.UUID;
import java.util.Map;
import org.bukkit.event.Listener;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae implements Listener
{
    private final Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
    public static Map<UUID, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
    public static Map<UUID, BukkitTask> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
    private static final String[] a;
    private static final String[] b;
    
    public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae(final Main you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new ConcurrentHashMap<UUID, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af>();
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new ConcurrentHashMap<UUID, BukkitTask>();
    }
    
    @EventHandler
    public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final PlayerInteractEvent playerInteractEvent) {
        final Player player = playerInteractEvent.getPlayer();
        final ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        
        if (!itemInMainHand.isSimilar(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g())) {
            return;
        }
    
        
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), a(7755, 29111))) {
            player.sendMessage(String.valueOf(ChatColor.RED) + a(7756, -9536));
            return;
        }
    
        playerInteractEvent.setCancelled(true);
        itemInMainHand.setAmount(itemInMainHand.getAmount() - 1);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
    }
    
    private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final Player player) {
        final UUID uniqueId = player.getUniqueId();
        final int int1 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getInt(a(7757, 14867), 60);
        final int int2 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getConfig().getInt(a(7759, 26479), 30);
        final String string = UUID.randomUUID().toString();
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(uniqueId, new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af(string, this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, string)));
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, a(7754, 11326), int1, ChatColor.YELLOW);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), a(7753, 16950), int1);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(uniqueId, new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dq(this, player, uniqueId).runTaskLater((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, int2 * 20L));
    }
    
    private ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final Player player, final String s) {
        final List<ItemStack> list = Arrays.asList(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(null, false), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764p(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764m(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764o(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764q(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player, false), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764r(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764s());
        final ItemStack clone = list.get(ThreadLocalRandom.current().nextInt(list.size())).clone();
        final ItemMeta itemMeta = clone.getItemMeta();
        if (itemMeta != null) {
            itemMeta.getPersistentDataContainer().set(new NamespacedKey((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, a(7752, 10246)), PersistentDataType.STRING, (Object)s);
            clone.setItemMeta(itemMeta);
        }
        player.getInventory().setItemInMainHand(clone);
        return clone;
    }
    
    public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(final Player player) {
        final UUID uniqueId = player.getUniqueId();
        final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.remove(uniqueId);
        try {
            if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af == null) {
                return;
            }
        }
        catch (final MatchException ex) {
 
        if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af == null) {
            return;
        }
    (uniqueId);
        
        if (bukkitTask != null) {
            bukkitTask.cancel();
        }
    
        final ItemStack you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = You_are_an_idi
        if (bukkitTask != null) {
            bukkitTask.cancel();
        }
    ck : You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player)) {
            
            if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
                continue;
            }
            itemStack.setType(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getType());
            itemStack.setItemMeta(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getItemMeta());
        
        }
    }
    
    public static List<ItemStack> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final Player player) {
        final ArrayList list = new ArrayList();
        final PlayerInventory inventory = player.getInventory();
        list.addAll(Arrays.asList(inventory.getContents()));
        list.add(inventory.getItemInOffHand());
        list.add(player.getItemOnCursor());
        list.addAll(Arrays.asList(inventory.getArmorContents()));
        final Inventory topInventory = player.getOpenInventory().getTopInventory();
        if (topInventory instanceof final CraftingInventory craftingInventory) {
            list.addAll(Arrays.asList(craftingInventory.getMatrix()));
        }
        return list;
    }
    
    public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final ItemStack itemStack, final String s) {
        Label_0021: {
            try {
                if (itemStack == null) {
                    return false;
                }
                final String s2 = s;
                if (s2 == null) {
                    return false;
                }
    
            if (itemStack == null) {
                return false;
            }
            final String s2 = s;
            if (s2 == null) {
                return false;
            }
            break Label_0021;
        (ex2);
            }
        }
        final ItemMeta itemMeta = itemStack.getItemMeta();
        try {
            if (itemMeta == null) {
                return false;
            }
        }
     
        if (itemMeta == null) {
            return false;
        }
    s;
            if (s2 == null) {
                return false;
            }
        tchException ex4) {
            throw a(ex4);
        }
        return s.equals(itemMeta.getPersistentDataContainer().get(namespacedKey, PersistentDataType.STRING));
    }
    
    public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsg
        if (!itemMeta.getP
        if (itemMeta == null) {
            return false;
        }
           if (itemMeta == null) {
                return false;
            }
        }
        catch (final MatchException ex2) {
            throw a(ex2);
        }
        return itemMeta.getPersistentDataContainer().has(new NamespacedKey((Plugin)Main.getInstance(), a(7750, -2117)), PersistentDataType.STRING);
    }

    @EventHandler
    public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(PlayerInteractEvent playerInteractEvent) {
        block15: {
            try {
                if (playerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK) {
                    return;
                }
            }
            catch (MatchException matchException) {
                
        if (itemStack == null) {
            return false;
        }
                return false;
        }
    9992919999999vdsgjhfvs239764b.containsKey(uUID)) {
                    return;
                }
            }
            catch (MatchException matchException) {
                throw You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.a(matchException);
            }
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(uUID);
            
            if (playerInteractEvent.getClickedBlock() == null) {
                return;
            }
        
            
            
            
            if (playerInteractEvent.getClickedBlock().getType() != Material.DECORATED_POT && !playerInteractEvent.getClickedBlock().getType().toString().contains(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.a(7758, 7930))) break block15;
        
            if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(playerInteractEvent.getItem(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) break block15;
        
            playerInteractEvent.setCancelled(true);
        
        }
    }
    
    @EventHandler
    public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final PlayerInteractEntityEvent playerInteractEntityEvent) {
        final UUID uniqueId = playerInteractEntityEvent.getPlayer().getUniqueId();
        
        if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(uniqueId)) {
            return;
        }
    
        final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af you_are_an_idiot_ha_ha_ha_ha_h
        if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(uniqueId)) {
            return;
        }
    == EntityType.ITEM_FRAME) {
                break Label_0085;
            }
            final PlayerInteractEntityEvent playerInteractEntityEvent2 = playerInteractEntityEvent;
            final Entity entity = playerInteractEntityEvent2.getRightClicked();
            final EntityType entityType = entity.getType();
            final EntityType entityType2 = EntityType.GLOW_ITEM_FRAME;
            if (entityType != entityType2) {
                return;
            }
            break Label_0085;
        
            
            final PlayerInteractEntityEvent playerInteractEntityEvent2 = playerInteractEntityEvent;
            final Entity entity = playerInteractEntityEvent2.getRightClicked();
            final EntityType entityType = entity.getType();
    
        final PlayerInteractEntityEvent playerInteractEntityEvent2 = playerInteractEntityEvent;
        final Entity entity = playerInteractEntityEvent2.getRightClicked();
        final EntityType entityType = entity.getType();
        final EntityType entityType2 = EntityType.GLOW_ITEM_FRAME;
        if (entityType != entityType2) {
            return;
        }
    764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
                playerInteractEntityEvent.setCanc
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(playerInteractEntityEvent.getPlayer().getInventory().getItemInMainHand(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
            playerInteractEntityEvent.setCancelled(true);
        }
      }
    final Player player = (Player)inventoryClickEvent.getWhoClicked();
    final UUID uniqueId = player.getUniqueId();
    
    if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(uniqueId)) {
        return;
    }

    final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(uniqueId);
    try {
        if (inventoryClickEvent.getView().getType() == InventoryType.CRAFTING) {
            return;
        }
    }
    catc
    if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha86543957999929199999
    if (!(inventoryClickEvent.getWhoClicked() instanceof Player)) {
        return;
    }
_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
                inventoryClickEvent.setCancelled(true);
                return;
            }
        
        }
        try {
            if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(item, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
                inventoryClickEvent.setCancelled(true);
                return;
            }
            try {
         
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha86543957
        if (inventoryClickEvent.getView().getType() == InventoryType.CRAFTING) {
            return;
        }
    fvs239764a)) {
            inventoryClickEvent.setCancelled(true);
          
     
    if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha86543957
    if (inventoryClickEvent.getView().getType() == InventoryType.CRAFTING) {
        return;
    }
fvs239764a)) {
        inventoryClickEvent.setCancelled(true);
        return;
    }
d You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final InventoryMoveItemEvent inventoryMoveItemEvent) {
    final ItemStack item = inventoryMoveItemEvent.getItem();
    for (final You_are_an_
    if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(inventoryClickEvent.getCursor(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
        inventoryClickEvent.setCancelled(true);
    }
_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
                inventoryMoveItemEvent.setCancelled(true);
                return;
            }
            continue;
        }
        catch (final MatchException ex) {
            throw a(ex);
      
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(item, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
            inventoryMoveItemEvent.setCancelled(true);
            return;
        }
        continue;
        }
    diot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.get(uniqueId);
        
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(playerDropItemEvent.getItemDrop().getItemStack(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
            playerDropItemEvent.setCancelled(true);
        }
    
   
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(playerDropItemEvent.getItemDrop().getItemStack(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
            playerDropItemEvent.setCancelled(true);
        }
    999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
            playerDropItemEvent.setCancelled(true);
        }
     You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.remove(uniqueId);
        final ArrayList list = new ArrayList();
        for (final ItemStack itemStack : playerDeathEvent.getDrops()) {
            try {
                if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764af.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhf
            if (!You_are_an_idiot_ha_h
        if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(playerDeathEvent.getPlayer().getUniqueId())) {
            return;
        }
    a_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g());
        tUniqueId());
    }
    
    @EventHandler
    public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(final PlayerQuitEvent playerQuitEvent) {
        final Player player = playerQuitEvent.getPlayer();
        final UUID uniqueId = player.getUniqueId();
        try {
            if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(uniqueId)) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
        }
    9999999vdsgjhfvs239764a(final PluginDisableEvent pluginDisableEven
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.containsKey(uniqueId)) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
        }
    vs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.keySet()).iterator();
        while (iterator.hasNext()) {
            final Player player = Bukkit.getPlayer((UUID)iterator.next());
            Label_0087: {
                
              
    if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs2397
    if (!pluginDisableEvent.getPlugin().equals((Object)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
        return;
    }
       final Player player2 = player;
                final boolean b = player2.isOnline();
                if (!b) {
                    continue;
                }
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
            
            }
        }
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.You_are_an_idiot_ha_ha_ha_ha_ha_ha_
                final Player player2 = player;
                final boolean b = player2.isOnline();
                if (!b) {
                    continue;
                }
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
            9764a)) {
            return;
        }
    u0000µ\u0095©\u001b9fm¿\u00e0\tv¤L\u0001M\u00836Ho¯§bM\u00ec¦¾\u00e6Yv¾\u009d\u0012\u007fQ\u0081Y}¦\u00faO\u001e\u0018O\bF\u0080
                final Player player2 = player;
                final boolean b = player2.isOnline();
                if (!b) {
                    continue;
                }
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
            n4;
                final String s2 = s;
                final int beginIndex = n4;
                String s3 = s2.substring(beginIndex, beginIndex + n3);
                int n9 = -1;
                while (true) {
                    final char[] charArray = s3.toCharArray();
                    final int length = charArray.length;
                    int n10 = 0;
                    while (true) {
                        Label_0260: {
                            if (length > 1) {
                                break Label_0260;
                            }
                            n7 = (n6 = n10);
                            do {
                                final char c = charArray[n6];
                                charArray[n7] = (char)(c ^ (n5 ^ switch (n10 % 7) {
                                    case 0 -> 55;
                                    case 1 -> 39;
                                    case 2 -> 118;
                                    case 3 -> 65;
                                    case 4 -> 39;
                                    case 5 -> 83;
                                    default -> 27;
                                }));
                                ++n10;
                            } while (n8 == 0);
                        }
                        if (length > n10) {
                            continue;
                        }
                        break;
                    }
                    final String intern = new String(charArray).intern();
                    switch (n9) {
                        default: {
                            a2[n++] = intern;
                            if ((n4 += n3) < n2) {
                                n3 = s.charAt(n4);
                                continue Label_0023;
                            }
                            n2 = (s = "\u0010\u0005\u00d7h\f7pH\u0013'\u001d\u00107J3\u0081\u0090\n\u00e3\u00efa\u00d3S\u001dN·\u009e\u000e").length();
                            n3 = 11;
                            n4 = -1;
                            break;
                        }
                        case 0: {
                            a2[n++] = intern;
                            if ((n4 += n3) < n2) {
                                n3 = s.charAt(n4);
                                break;
                            }
                            break Label_0023;
                        }
                    }
                    n5 = (n6 = (n7 = (n8 = 67)));
                    ++n4;
                    final String s4 = s;
                    final int beginIndex2 = n4;
                    s3 = s4.substring(beginIndex2, beginIndex2 + n3);
                    n9 = 0;
                }
            }
            break;
        }
        a = a2;
        b = new String[9];
    }
    
    private static String a(final int n, final int n2) {
        final int n3 = (n ^ 0x1E4E) & 0xFFFF;
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.b[n3] == null) {
            final char[] charArray = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.a[n3].toCharArray();
            final int n5 = switch (charArray[0] & '\u00ff') {
                case 0 -> 249;
                case 1 -> 195;
                case 2 -> 7;
                case 3 -> 158;
                case 4 -> 151;
                case 5 -> 187;
                case 6 -> 230;
                case 7 -> 24;
                case 8 -> 242;
                case 9 -> 95;
                case 10 -> 5;
                case 11 -> 94;
                case 12 -> 75;
                case 13 -> 66;
                case 14 -> 0;
                case 15 -> 241;
                case 16 -> 55;
                case 17 -> 121;
                case 18 -> 239;
                case 19 -> 9;
                case 20 -> 122;
                case 21 -> 31;
                case 22 -> 251;
                case 23 -> 237;
                case 24 -> 227;
                case 25 -> 99;
                case 26 -> 159;
                case 27 -> 137;
                case 28 -> 26;
                case 29 -> 30;
                case 30 -> 175;
                case 31 -> 96;
                case 32 -> 6;
                case 33 -> 150;
                case 34 -> 184;
                case 35 -> 244;
                case 36 -> 92;
                case 37 -> 146;
                case 38 -> 180;
                case 39 -> 214;
                case 40 -> 74;
                case 41 -> 178;
                case 42 -> 100;
                case 43 -> 136;
                case 44 -> 207;
                case 45 -> 79;
                case 46 -> 51;
                case 47 -> 222;
                case 48 -> 166;
                case 49 -> 194;
                case 50 -> 140;
                case 51 -> 103;
                case 52 -> 190;
                case 53 -> 254;
                case 54 -> 123;
                case 55 -> 191;
                case 56 -> 10;
                case 57 -> 65;
                case 58 -> 172;
                case 59 -> 23;
                case 60 -> 221;
                case 61 -> 109;
                case 62 -> 77;
                case 63 -> 3;
                case 64 -> 225;
                case 65 -> 124;
                case 66 -> 69;
                case 67 -> 155;
                case 68 -> 134;
                case 69 -> 232;
                case 70 -> 129;
                case 71 -> 18;
                case 72 -> 25;
                case 73 -> 45;
                case 74 -> 201;
                case 75 -> 246;
                case 76 -> 76;
                case 77 -> 153;
                case 78 -> 162;
                case 79 -> 20;
                case 80 -> 220;
                case 81 -> 116;
                case 82 -> 50;
                case 83 -> 174;
                case 84 -> 127;
                case 85 -> 197;
                case 86 -> 91;
                case 87 -> 156;
                case 88 -> 80;
                case 89 -> 223;
                case 90 -> 38;
                case 91 -> 15;
                case 92 -> 42;
                case 93 -> 152;
                case 94 -> 183;
                case 95 -> 228;
                case 96 -> 105;
                case 97 -> 196;
                case 98 -> 39;
                case 99 -> 144;
                case 100 -> 47;
                case 101 -> 198;
                case 102 -> 12;
                case 103 -> 177;
                case 104 -> 114;
                case 105 -> 206;
                case 106 -> 62;
                case 107 -> 185;
                case 108 -> 32;
                case 109 -> 58;
                case 110 -> 132;
                case 111 -> 111;
                case 112 -> 147;
                case 113 -> 142;
                case 114 -> 163;
                case 115 -> 36;
                case 116 -> 70;
                case 117 -> 186;
                case 118 -> 255;
                case 119 -> 219;
                case 120 -> 34;
                case 121 -> 157;
                case 122 -> 229;
                case 123 -> 234;
                case 124 -> 57;
                case 125 -> 189;
                case 126 -> 49;
                case 127 -> 138;
                case 128 -> 40;
                case 129 -> 108;
                case 130 -> 59;
                case 131 -> 110;
                case 132 -> 60;
                case 133 -> 202;
                case 134 -> 8;
                case 135 -> 120;
                case 136 -> 161;
                case 137 -> 247;
                case 138 -> 87;
                case 139 -> 125;
                case 140 -> 41;
                case 141 -> 97;
                case 142 -> 240;
                case 143 -> 63;
                case 144 -> 200;
                case 145 -> 139;
                case 146 -> 154;
                case 147 -> 250;
                case 148 -> 126;
                case 149 -> 78;
                case 150 -> 167;
                case 151 -> 203;
                case 152 -> 117;
                case 153 -> 44;
                case 154 -> 67;
                case 155 -> 88;
                case 156 -> 93;
                case 157 -> 27;
                case 158 -> 130;
                case 159 -> 231;
                case 160 -> 16;
                case 161 -> 119;
                case 162 -> 21;
                case 163 -> 29;
                case 164 -> 81;
                case 165 -> 101;
                case 166 -> 89;
                case 167 -> 72;
                case 168 -> 83;
                case 169 -> 179;
                case 170 -> 86;
                case 171 -> 160;
                case 172 -> 64;
                case 173 -> 11;
                case 174 -> 252;
                case 175 -> 193;
                case 176 -> 102;
                case 177 -> 233;
                case 178 -> 165;
                case 179 -> 54;
                case 180 -> 170;
                case 181 -> 171;
                case 182 -> 71;
                case 183 -> 1;
                case 184 -> 213;
                case 185 -> 37;
                case 186 -> 215;
                case 187 -> 224;
                case 188 -> 14;
                case 189 -> 128;
                case 190 -> 104;
                case 191 -> 148;
                case 192 -> 73;
                case 193 -> 22;
                case 194 -> 216;
                case 195 -> 182;
                case 196 -> 243;
                case 197 -> 13;
                case 198 -> 4;
                case 199 -> 212;
                case 200 -> 113;
                case 201 -> 236;
                case 202 -> 176;
                case 203 -> 19;
                case 204 -> 245;
                case 205 -> 68;
                case 206 -> 141;
                case 207 -> 106;
                case 208 -> 209;
                case 209 -> 33;
                case 210 -> 133;
                case 211 -> 131;
                case 212 -> 173;
                case 213 -> 204;
                case 214 -> 169;
                case 215 -> 82;
                case 216 -> 168;
                case 217 -> 112;
                case 218 -> 84;
                case 219 -> 46;
                case 220 -> 28;
                case 221 -> 164;
                case 222 -> 90;
                case 223 -> 217;
                case 224 -> 238;
                case 225 -> 135;
                case 226 -> 17;
                case 227 -> 85;
                case 228 -> 145;
                case 229 -> 143;
                case 230 -> 115;
                case 231 -> 210;
                case 232 -> 52;
                case 233 -> 208;
                case 234 -> 98;
                case 235 -> 149;
                case 236 -> 226;
                case 237 -> 199;
                case 238 -> 43;
                case 239 -> 2;
                case 240 -> 205;
                case 241 -> 35;
                case 242 -> 253;
                case 243 -> 107;
                case 244 -> 211;
                case 245 -> 118;
                case 246 -> 218;
                case 247 -> 181;
                case 248 -> 192;
                case 249 -> 61;
                case 250 -> 248;
                case 251 -> 56;
                case 252 -> 188;
                case 253 -> 235;
                case 254 -> 48;
                default -> 53;
            };
            int n6 = (n2 & 0xFF) - n5;
            if (n6 < '\0') {
                n6 += '\u0100';
            }
            int n7 = ((n2 & 0xFFFF) >>> 8) - n5;
            if (n7 < '\0') {
                n7 += '\u0100';
            }
            for (int i = 0; i < charArray.length; ++i) {
                final int n8 = i % 2;
                final char[] array = charArray;
                final int n9 = i;
                final char c = array[n9];
                if (n8 == 0) {
                    array[n9] = (char)(c ^ n6);
                    n6 = (((n6 >>> 3 | n6 << 5) ^ charArray[i]) & 0xFF);
                }
                else {
                    array[n9] = (char)(c ^ n7);
                    n7 = (((n7 >>> 3 | n7 << 5) ^ charArray[i]) & 0xFF);
                }
            }
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.b[n3] = new String(charArray).intern();
        }
        return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ae.b[n3];
    }
}
