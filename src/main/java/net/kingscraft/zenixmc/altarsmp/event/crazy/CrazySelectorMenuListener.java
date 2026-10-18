package net.kingscraft.zenixmc.altarsmp.event.crazy;

import java.util.ArrayList;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.illusion.IllusionWandAbility;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;

public class CrazySelectorMenuListener implements Listener {
  public static String MENU_TITLE = ChatColor.GOLD + "Legendaries";

  public static ItemStack createCrazySelectorItem() {
    ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(4));
    itemMeta.setDisplayName(String.valueOf(ChatColor.GOLD) + ChatColor.BOLD.toString() + "Crazy Selector");
    itemMeta.setUnbreakable(true);
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(String.valueOf(ChatColor.GRAY) + "Right-Click to select a legendary!");
    itemMeta.setLore(arrayList);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  @EventHandler
  public void onSelectorInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    {
      if (paramPlayerInteractEvent.getAction().isRightClick())
        {
          if (paramPlayerInteractEvent.getPlayer().getInventory().getItemInMainHand().isSimilar(createCrazySelectorItem())) {
            paramPlayerInteractEvent.getPlayer().getInventory().getItemInMainHand().setAmount(paramPlayerInteractEvent.getPlayer().getInventory().getItemInMainHand().getAmount() - 1);
            openLegendarySelectionMenu(paramPlayerInteractEvent.getPlayer());
            CooldownManager.setCooldown(paramPlayerInteractEvent.getPlayer().getUniqueId(), "open", 2.147483647E9D);
          } 
        }}}

  @EventHandler
  public void onMenuClose(InventoryCloseEvent paramInventoryCloseEvent) {
    HumanEntity humanEntity = paramInventoryCloseEvent.getPlayer();
    if (humanEntity instanceof Player) {
      Player player = (Player)humanEntity;
      {
        if (paramInventoryCloseEvent.getView().getTitle().equals(MENU_TITLE))
          {
            if (CooldownManager.isOnCooldown(player.getUniqueId(), "open"))
              player.getInventory().addItem(createCrazySelectorItem());
          }}} 
  }

  public void openLegendarySelectionMenu(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(paramPlayer, 27, MENU_TITLE);
    List<ItemStack> list = CustomItem.getRollingDropItems();
    for (ItemStack itemStack : list) {
      inventory.addItem(itemStack);
    } 
    paramPlayer.openInventory(inventory);
  }

  @EventHandler
  public void onMenuClick(InventoryClickEvent paramInventoryClickEvent) {
    HumanEntity humanEntity = paramInventoryClickEvent.getWhoClicked();
    if (humanEntity instanceof Player) {
      Player player = (Player)humanEntity;
      {
        if (paramInventoryClickEvent.getView().getTitle().equals(MENU_TITLE)) {
          {
            if (paramInventoryClickEvent.getClickedInventory() != paramInventoryClickEvent.getView().getTopInventory())
              return; 
          }paramInventoryClickEvent.setCancelled(true);
          ItemStack itemStack = paramInventoryClickEvent.getCurrentItem();
          {
            if (itemStack == null)
              return; 
          }{
            if (CustomItem.fromItem(itemStack) == CustomItem.ILLUSION_WAND) {
              IllusionWandAbility.storeCapturedMob(player, itemStack, EntityType.WARDEN);
              return;
            } 
          }player.getInventory().addItem(itemStack);
          CooldownManager.setCooldown(player.getUniqueId(), "open", 0.0D);
          player.closeInventory();
          player.playSound(player, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
        } 
      }} 
  }



}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a4.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */