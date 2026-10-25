package net.kingscraft.zenixmc.altarsmp.legendary;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
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
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemType;

public class LegendaryItemsMenu implements CommandExecutor, Listener {
  public static String MENU_TITLE;

  public static String SEASON_TWO_TITLE;

  static {
    MENU_TITLE = "§c§lʟᴇɢᴇɴᴅᴀʀɪᴇѕ";
    SEASON_TWO_TITLE = "§5§lꜱᴇᴀꜱᴏɴ ᴛᴡᴏ ᴡᴇᴀᴘᴏɴꜱ";
  }


  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, String @NotNull [] paramArrayOfString) {
    if (paramCommandSender instanceof Player player) {
      openLegendaryItemsMenu(player);
    } 
    return false;
  }

  public static void openLegendaryItemsMenu(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 45, MENU_TITLE);
    decorateInventory(inventory);
    int b = 2;
    {
      while (b < 7) {
        inventory.setItem(b, null);
        b++;
      } 
    }for (CustomItem customItem : CustomItem.values()) {
      {
        if (customItem.isSeasonTwo()) {
          continue;
        } 
        if (customItem == CustomItem.KNIGHTFALL) {
          inventory.addItem(CustomItemRegistry.getKnightfall(paramPlayer, false));
        } else {
          inventory.addItem(customItem.getItem());
        } 
      }} 
    {
      inventory.setItem(39, createWeaponSettingsButton());
      inventory.setItem(40, createIngredientsButton());
      inventory.setItem(41, createSeasonTwoWeaponsButton());
    }paramPlayer.openInventory(inventory);
  }

  public static void openSeasonTwoWeaponsMenu(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 45, SEASON_TWO_TITLE);
    decorateInventory(inventory);
    for (net.kingscraft.zenixmc.altarsmp.item.CustomItem weapon : net.kingscraft.zenixmc.altarsmp.item.CustomItem.values()) {
      if (!weapon.isSeasonTwo()) {
        continue;
      }
      inventory.addItem(weapon.getItem(paramPlayer));
    }
    inventory.setItem(40, createLegendaryItemsButton());
    paramPlayer.openInventory(inventory);
  }

  public void openIngredientsMenu(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 45, "ɪɴɢʀᴇᴅɪᴇɴᴛꜱ");
    decorateInventory(inventory);
for (CustomItemType customItemType : CustomItemType.values()) {
      inventory.addItem(customItemType.getItem());
    } 
    inventory.setItem(40, createLegendaryItemsButton());
    paramPlayer.openInventory(inventory);
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent paramInventoryClickEvent) {
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
      if (paramInventoryClickEvent.getView().getTitle().equalsIgnoreCase(MENU_TITLE)) {
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
                openIngredientsMenu(player);
                player.playSound(player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
              } else {
                {
                  if (paramInventoryClickEvent.getSlot() == 41) {
                    paramInventoryClickEvent.setCancelled(true);
                    openSeasonTwoWeaponsMenu(player);
                    player.playSound(player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                  } else {
                    {
                      if (paramInventoryClickEvent.getSlot() == 39) {
                        paramInventoryClickEvent.setCancelled(true);
                        LegendaryItemConfigMenu.openConfigMenu(player);
                        player.playSound(player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                      } 
                    }} 
                }} 
            }return;
          } 
        }} else {
        {
          if (paramInventoryClickEvent.getView().getTitle().equalsIgnoreCase(SEASON_TWO_TITLE)) {
            {
              if (paramInventoryClickEvent.getWhoClicked().isOp()) {
                {
                  if (paramInventoryClickEvent.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE)
                    paramInventoryClickEvent.setCancelled(true); 
                }{
                  if (paramInventoryClickEvent.getSlot() == 40) {
                    paramInventoryClickEvent.setCancelled(true);
                    openLegendaryItemsMenu(player);
                    player.playSound(player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
                  } 
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
                        openLegendaryItemsMenu(player);
                        player.playSound(player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
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
    }paramInventoryClickEvent.setCancelled(true);
  }

  public static void decorateInventory(Inventory paramInventory) {
    ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(" ");
    itemStack.setItemMeta(itemMeta);
    int b = 0;
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

  public static ItemStack createIngredientsButton() {
    ItemStack itemStack = CustomItemRegistry.getVulcanSkull().clone();
    return createMenuButton(itemStack, "§6", "ɪɴɢʀᴇᴅɪᴇɴᴛꜱ");
  }

  public static ItemStack createLegendaryItemsButton() {
    return createMenuButton(CustomItemRegistry.getIllusionWand(), "§d", MENU_TITLE);
  }

  public static ItemStack createSeasonTwoWeaponsButton() {
    ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(16);
    itemStack.setItemMeta(itemMeta);
    return createMenuButton(itemStack, "§d", "ꜱᴇᴀꜱᴏɴ ᴛᴡᴏ ᴡᴇᴀᴘᴏɴꜱ");
  }

  public static ItemStack createWeaponSettingsButton() {
    return createMenuButton(new ItemStack(Material.COMPARATOR), "§d", "ᴡᴇᴀᴘᴏɴ ꜱᴇᴛᴛɪɴɢꜱ");
  }

  public static ItemStack createMenuButton(ItemStack paramItemStack, String paramString1, String paramString2) {
    ItemMeta itemMeta = paramItemStack.getItemMeta();
    itemMeta.addItemFlags(ItemFlag.values());
    itemMeta.removeEnchantments();
    itemMeta.setDisplayName(paramString1 + "§l" + paramString2);
    itemMeta.setLore(List.of("§7Click to view " + paramString2));
    paramItemStack.setItemMeta(itemMeta);
    return paramItemStack;
  }

}
