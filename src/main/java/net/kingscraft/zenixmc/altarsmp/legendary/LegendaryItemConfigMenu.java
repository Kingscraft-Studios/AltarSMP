package net.kingscraft.zenixmc.altarsmp.legendary;

import io.papermc.paper.dialog.Dialog;
import net.kyori.adventure.dialog.DialogLike;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;
import net.kingscraft.zenixmc.altarsmp.item.ItemStat;
import net.kingscraft.zenixmc.altarsmp.item.RangedStat;
import net.kingscraft.zenixmc.altarsmp.item.SteppedStat;
import net.kingscraft.zenixmc.altarsmp.item.ToggleStat;
import net.kingscraft.zenixmc.altarsmp.menu.DialogBuilder;

public class LegendaryItemConfigMenu implements Listener {
  public static String MENU_TITLE;
  public static String SEASON_TWO_TITLE;

  private static LegendaryItemConfigMenu instance;

  FileConfiguration config = AltarSMP.getInstance().getConfig();

  public LegendaryItemConfigMenu() {
    instance = this;
  }

  public static void showConfigDialog(Player paramPlayer, CustomItem paramCustomItem) {
    if (instance != null && paramCustomItem != null) {
      paramPlayer.showDialog((DialogLike) instance.buildWeaponDialog(paramCustomItem));
    }
  }

  public static void openConfigMenu(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 45, MENU_TITLE);
    ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(" ");
    itemStack.setItemMeta(itemMeta);
    int b = 0;
    {
      while (b < 9) {
        inventory.setItem(b, itemStack);
        b++;
      } 
    }b = 2;
    {
      while (b < 7) {
        inventory.setItem(b, null);
        b++;
      } 
    }b = 36;
    {
      while (b < 45) {
        inventory.setItem(b, itemStack);
        b++;
      } 
    }inventory.setItem(9, itemStack);
    inventory.setItem(18, itemStack);
    inventory.setItem(27, itemStack);
    inventory.setItem(17, itemStack);
    inventory.setItem(26, itemStack);
    inventory.setItem(35, itemStack);
    inventory.setItem(41, LegendaryItemsMenu.createSeasonTwoWeaponsButton());
    inventory.setItem(40, LegendaryItemsMenu.createLegendaryItemsButton());
    for (CustomItem customItem : CustomItem.values()) {
      if (customItem.isSeasonTwo()) {
        continue;
      }
      inventory.addItem(new ItemStack[] { customItem.getItem() });
    } 
    paramPlayer.openInventory(inventory);
  }

  public static void openSeasonTwoConfigMenu(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 45, SEASON_TWO_TITLE);
    LegendaryItemsMenu.decorateInventory(inventory);
    for (CustomItem customItem : CustomItem.values()) {
      if (!customItem.isSeasonTwo()) {
        continue;
      }
      inventory.addItem(new ItemStack[] { customItem.getItem() });
    } 
    inventory.setItem(40, LegendaryItemsMenu.createWeaponSettingsButton());
    paramPlayer.openInventory(inventory);
  }

  @EventHandler
  public void onMenuClick(InventoryClickEvent paramInventoryClickEvent) {
    String title = paramInventoryClickEvent.getView().getTitle();
    boolean isMain = title.equals(MENU_TITLE);
    boolean isSeasonTwo = title.equals(SEASON_TWO_TITLE);
    if (!isMain && !isSeasonTwo) {
      return;
    }
    if (paramInventoryClickEvent.getClickedInventory() != paramInventoryClickEvent.getView().getTopInventory()) {
      return;
    }
    ItemStack itemStack = paramInventoryClickEvent.getCurrentItem();
    CustomItem customItem = CustomItem.fromItem(itemStack);
    HumanEntity humanEntity = paramInventoryClickEvent.getWhoClicked();
    if (!(humanEntity instanceof Player player)) {
      return;
    }
    player.playSound((Entity)player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
    paramInventoryClickEvent.setCancelled(true);
    if (itemStack != null && itemStack.getType() == Material.GRAY_STAINED_GLASS_PANE) {
      return;
    }
    if (isMain) {
      if (paramInventoryClickEvent.getSlot() == 40) {
        LegendaryItemsMenu.openLegendaryItemsMenu(player);
        return;
      }
      if (paramInventoryClickEvent.getSlot() == 41) {
        openSeasonTwoConfigMenu(player);
        return;
      }
    } else if (paramInventoryClickEvent.getSlot() == 40) {
      openConfigMenu(player);
      return;
    }
    if (customItem == null) {
      return;
    }
    player.showDialog((DialogLike) buildWeaponDialog(customItem));
  }

  public Dialog buildWeaponDialog(CustomItem customItem) {
    String s = ChatColor.stripColor(customItem.getItem().getItemMeta().getDisplayName());
    DialogBuilder builder = DialogBuilder.multiAction().title("Configure " + s);
    List<ItemStat> list = customItem.getStats();
    int visibleButtons = 0;
    if (!list.isEmpty()) {
      for (ItemStat o : list) {
        if (o.key().equals("empty") || o.label().equals(Component.empty()))
          continue;
        visibleButtons++;
        if (o instanceof RangedStat x) {
          builder.addActionButton(x.label(), player -> openRangedStatDialog(customItem, s, x, player));
        } else if (o instanceof ToggleStat x) {
          builder.addActionButton(x.label(), player -> openToggleStatDialog(customItem, s, x, player));
        } else if (o instanceof SteppedStat x) {
          builder.addActionButton(x.label(), player -> openSteppedStatDialog(customItem, s, x, player));
        } else {
          throw new MatchException(null, (Throwable)null);
        }
      }
    }
    if (visibleButtons == 0) {
      builder.addActionButton("No config", player -> {});
    }
    return builder.build();
  }

  public void openNumberConfigDialog(Player paramPlayer, CustomItem customItem, String paramString1, String paramString2, float paramFloat1, float paramFloat2) {
    float f = (float)this.config.getDouble(paramString2);
    Dialog dialog = this.buildWeaponDialog(customItem);
    DialogBuilder.number(paramString2)
        .title(paramString1 + " - " + paramString2)
        .description(Component.text(paramString2))
        .setMinMaxNumber(paramFloat1, paramFloat2)
        .initialNumber(f)
        .onIntegerSubmit((player, integer) -> saveNumberConfig(paramString2, dialog, player, integer))
        .show(paramPlayer);
  }

  public void openFloatConfigDialog(Player paramPlayer, CustomItem customItem, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3) {
    float f = (float)this.config.getDouble(paramString2);
    Dialog dialog = this.buildWeaponDialog(customItem);
    DialogBuilder.number(paramString2)
        .title(paramString1 + " - " + paramString2)
        .description(Component.text(paramString2))
        .setMinMaxNumber(paramFloat1, paramFloat2)
        .initialNumber(f)
        .useFloatInput(paramFloat3)
        .onFloatSubmit((player, float1) -> saveFloatConfig(paramString2, dialog, player, float1))
        .show(paramPlayer);
  }

  public void openBooleanConfigDialog(Player paramPlayer, CustomItem customItem, String paramString1, String paramString2) {
    boolean b = this.config.getBoolean(paramString2);
    Dialog dialog = this.buildWeaponDialog(customItem);
    DialogBuilder.bool(paramString2)
        .title(paramString1 + " - " + paramString2)
        .description(Component.text(paramString2))
        .initialBoolean(b)
        .onBooleanSubmit((player, bool) -> saveBooleanConfig(paramString2, dialog, player, bool))
        .show(paramPlayer);
  }

  public void saveBooleanConfig(String paramString, Dialog paramDialog, Player paramPlayer, Boolean paramBoolean) {
    this.config.set(paramString, paramBoolean);
    AltarSMP.getInstance().saveConfig();
    paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + paramString + " set to " + paramBoolean);
    paramPlayer.showDialog((DialogLike)paramDialog);
  }

  public void saveFloatConfig(String paramString, Dialog paramDialog, Player paramPlayer, Float paramFloat) {
    this.config.set(paramString, paramFloat);
    AltarSMP.getInstance().saveConfig();
    paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + paramString + " set to " + paramFloat);
    paramPlayer.showDialog((DialogLike)paramDialog);
  }

  public void saveNumberConfig(String paramString, Dialog paramDialog, Player paramPlayer, Integer paramInteger) {
    this.config.set(paramString, paramInteger);
    AltarSMP.getInstance().saveConfig();
    paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + paramString + " set to " + paramInteger);
    paramPlayer.showDialog((DialogLike)paramDialog);
  }

  public void openSteppedStatDialog(CustomItem customItem, String paramString, SteppedStat steppedStat, Player paramPlayer) {
    openFloatConfigDialog(paramPlayer, customItem, paramString, steppedStat.key(), steppedStat.min(), steppedStat.max(), steppedStat.step());
  }

  public void openToggleStatDialog(CustomItem customItem, String paramString, ToggleStat toggleStat, Player paramPlayer) {
    openBooleanConfigDialog(paramPlayer, customItem, paramString, toggleStat.key());
  }

  public void openRangedStatDialog(CustomItem customItem, String paramString, RangedStat rangedStat, Player paramPlayer) {
    openNumberConfigDialog(paramPlayer, customItem, paramString, rangedStat.key(), rangedStat.min(), rangedStat.max());
  }

  static {
    MENU_TITLE = "§cʟᴇɢᴇɴᴅᴀʀɪᴇꜱ ᴄᴏɴꜰɪɢ";
    SEASON_TWO_TITLE = "§5ꜱᴇᴀꜱᴏɴ ᴛᴡᴏ ᴄᴏɴꜰɪɢ";
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */