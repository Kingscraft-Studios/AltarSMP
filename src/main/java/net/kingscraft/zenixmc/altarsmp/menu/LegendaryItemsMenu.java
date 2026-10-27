package net.kingscraft.zenixmc.altarsmp.menu;

import java.util.List;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemType;

public class LegendaryItemsMenu implements Listener {
  public static Component MENU_TITLE = Component.text("ʟᴇɢᴇɴᴅᴀʀɪᴇѕ", NamedTextColor.RED, TextDecoration.BOLD);
  public static Component SEASON_TWO_TITLE = Component.text("ꜱᴇᴀꜱᴏɴ ᴛᴡᴏ ᴡᴇᴀᴘᴏɴꜱ", NamedTextColor.DARK_PURPLE, TextDecoration.BOLD);

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
    Inventory inventory = Bukkit.createInventory(null, 45, Component.text("ɪɴɢʀᴇᴅɪᴇɴᴛꜱ"));
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
      if (paramInventoryClickEvent.getView().title().equals(MENU_TITLE)) {
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
          if (paramInventoryClickEvent.getView().title().equals(SEASON_TWO_TITLE)) {
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
              if (PlainTextComponentSerializer.plainText().serialize(paramInventoryClickEvent.getView().title()).equalsIgnoreCase("ɪɴɢʀᴇᴅɪᴇɴᴛꜱ")) {
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
    itemMeta.displayName(Component.text(" "));
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
    return createMenuButton(itemStack, NamedTextColor.GOLD, Component.text("ɪɴɢʀᴇᴅɪᴇɴᴛꜱ"));
  }

  public static ItemStack createLegendaryItemsButton() {
    return createMenuButton(CustomItemRegistry.getIllusionWand(), NamedTextColor.LIGHT_PURPLE, MENU_TITLE);
  }

  public static ItemStack createSeasonTwoWeaponsButton() {
    ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
    ItemMeta itemMeta = itemStack.getItemMeta();

    CustomModelDataComponent customModelData = itemMeta.getCustomModelDataComponent();
    customModelData.setFloats(List.of(16.0f));
    itemMeta.setCustomModelDataComponent(customModelData);

    itemStack.setItemMeta(itemMeta);
    return createMenuButton(itemStack, NamedTextColor.LIGHT_PURPLE, Component.text("ꜱᴇᴀꜱᴏɴ ᴛᴡᴏ ᴡᴇᴀᴘᴏɴꜱ"));
  }

  public static ItemStack createWeaponSettingsButton() {
    return createMenuButton(new ItemStack(Material.COMPARATOR), NamedTextColor.LIGHT_PURPLE, Component.text("ᴡᴇᴀᴘᴏɴ ꜱᴇᴛᴛɪɴɢꜱ"));
  }

  public static ItemStack createMenuButton(ItemStack paramItemStack, NamedTextColor paramColor, Component paramComponent) {
    ItemMeta itemMeta = paramItemStack.getItemMeta();
    itemMeta.addItemFlags(ItemFlag.values());
    itemMeta.removeEnchantments();
    itemMeta.displayName(paramComponent.color(paramColor).decorate(TextDecoration.BOLD));
    itemMeta.lore(List.of(Component.text("Click to view ").append(paramComponent.color(NamedTextColor.GRAY))));
    paramItemStack.setItemMeta(itemMeta);
    return paramItemStack;
  }
}
