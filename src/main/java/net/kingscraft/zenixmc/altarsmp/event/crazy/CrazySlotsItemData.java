package net.kingscraft.zenixmc.altarsmp.event.crazy;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.inventory.ItemStack;

class CrazySlotsItemData {
  public final String itemId;

  public final ItemStack itemStack;

  public CrazySlotsItemData(String paramString, ItemStack paramItemStack) {
    this.itemId = paramString;
    this.itemStack = paramItemStack;
  }
}
