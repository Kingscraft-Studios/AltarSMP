package net.kingscraft.zenixmc.altarsmp.event.crazy;

import org.bukkit.inventory.ItemStack;

public class CrazySlotsItemData {
  public final String itemId;

  public final ItemStack itemStack;

  public CrazySlotsItemData(String paramString, ItemStack paramItemStack) {
    this.itemId = paramString;
    this.itemStack = paramItemStack;
  }
}
