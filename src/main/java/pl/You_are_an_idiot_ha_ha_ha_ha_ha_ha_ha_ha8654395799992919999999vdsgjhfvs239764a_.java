package pl;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_ implements CommandExecutor, Listener {
  static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = "§c§lʟᴇɢᴇɴᴅᴀʀɪᴇѕ";
  }
  
  
  
  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    if (paramCommandSender instanceof Player) {
      Player player = (Player)paramCommandSender;
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
    } 
    return false;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 45, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(inventory);
    byte b = 2;
    {
      while (b < 7) {
        inventory.setItem(b, null);
        b++;
      } 
    }for (CustomItem you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l : CustomItem.values()) {
      {
        if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l == CustomItem.KNIGHTFALL) {
          inventory.addItem(new ItemStack[] { CustomItemRegistry.getKnightfall(paramPlayer, false) });
        } else {
          inventory.addItem(new ItemStack[] { you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.getItem() });
        } 
      }} 
    {
      inventory.setItem(39, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d());
      inventory.setItem(40, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a());
      if (Bukkit.getPluginManager().getPlugin("AltarS2") != null)
        inventory.setItem(41, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c()); 
    }paramPlayer.openInventory(inventory);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 45, "ɪɴɢʀᴇᴅɪᴇɴᴛꜱ");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(inventory);
for (CustomItemType you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : CustomItemType.values()) {
      inventory.addItem(new ItemStack[] { you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getItem() });
    } 
    inventory.setItem(40, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b());
    paramPlayer.openInventory(inventory);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(InventoryClickEvent paramInventoryClickEvent) {
    Player player;
    HumanEntity humanEntity = paramInventoryClickEvent.getWhoClicked();
    if (humanEntity instanceof Player) {
      player = (Player)humanEntity;
    } else {
      return;
    } 
    {
      if (paramInventoryClickEvent.getCurrentItem() == null)
        return; 
    }{
      if (paramInventoryClickEvent.getView().getTitle().equalsIgnoreCase(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)) {
        {
          if (paramInventoryClickEvent.getWhoClicked().isOp()) {
            {
              if (paramInventoryClickEvent.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE) {
                paramInventoryClickEvent.setCancelled(true);
                return;
              } 
            }{
              if (paramInventoryClickEvent.getSlot() == 40) {
                paramInventoryClickEvent.setCancelled(true);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
                player.playSound((Entity)player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
              } else {
                {
                  if (paramInventoryClickEvent.getSlot() == 41) {
                    {
                      paramInventoryClickEvent.setCancelled(true);
                      if (Bukkit.getPluginManager().getPlugin("AltarS2") == null)
                        return; 
                    }player.performCommand("altars2:legendaries");
                    player.playSound((Entity)player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                  } else {
                    {
                      if (paramInventoryClickEvent.getSlot() == 39) {
                        paramInventoryClickEvent.setCancelled(true);
                        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
                        player.playSound((Entity)player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                      } 
                    }} 
                }} 
            }return;
          } 
        }} else {
        {
          if (paramInventoryClickEvent.getView().getTitle().equalsIgnoreCase("ɪɴɢʀᴇᴅɪᴇɴᴛꜱ")) {
            {
              if (paramInventoryClickEvent.getWhoClicked().isOp()) {
                {
                  if (paramInventoryClickEvent.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE)
                    paramInventoryClickEvent.setCancelled(true); 
                }{
                  if (paramInventoryClickEvent.getSlot() == 40) {
                    paramInventoryClickEvent.setCancelled(true);
                    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
                    player.playSound((Entity)player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                  } 
                }return;
              } 
            }} else {
            return;
          } 
        }paramInventoryClickEvent.setCancelled(true);
      } 
    }paramInventoryClickEvent.setCancelled(true);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Inventory paramInventory) {
    ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(" ");
    itemStack.setItemMeta(itemMeta);
    byte b = 0;
    {
      while (b < 9) {
        paramInventory.setItem(b, itemStack);
        b++;
      } 
    }b = 36;
    {
      while (b < 45) {
        paramInventory.setItem(b, itemStack);
        b++;
      } 
    }paramInventory.setItem(9, itemStack);
    paramInventory.setItem(18, itemStack);
    paramInventory.setItem(27, itemStack);
    paramInventory.setItem(17, itemStack);
    paramInventory.setItem(26, itemStack);
    paramInventory.setItem(35, itemStack);
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    ItemStack itemStack = CustomItemRegistry.getVulcanSkull().clone();
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack, "§6", "ɪɴɢʀᴇᴅɪᴇɴᴛꜱ");
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(CustomItemRegistry.getIllusionWand(), "§d", You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c() {
    ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(16));
    itemStack.setItemMeta(itemMeta);
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack, "§d", "ꜱᴇᴀꜱᴏɴ ᴛᴡᴏ ᴡᴇᴀᴘᴏɴꜱ");
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d() {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(new ItemStack(Material.COMPARATOR), "§d", "ᴡᴇᴀᴘᴏɴ ꜱᴇᴛᴛɪɴɢꜱ");
  }
  
  private static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack paramItemStack, String paramString1, String paramString2) {
    ItemMeta itemMeta = paramItemStack.getItemMeta();
    itemMeta.addItemFlags(ItemFlag.values());
    itemMeta.removeEnchantments();
    itemMeta.setDisplayName(paramString1 + "§l" + paramString2);
    itemMeta.setLore(List.of("§7Click to view " + paramString2));
    paramItemStack.setItemMeta(itemMeta);
    return paramItemStack;
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */