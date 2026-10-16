package pl;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

class FrostScytheReturnAnimationTask extends BukkitRunnable {
  final Player player;
  
  final ItemDisplay scytheDisplay;
  
  FrostScytheReturnAnimationTask(Player paramPlayer, ItemDisplay paramItemDisplay) {
        this.player = paramPlayer;
        this.scytheDisplay = paramItemDisplay;
    }
  
  public void run() {
    this.player.addPassenger((Entity)this.scytheDisplay);
    Transformation transformation = new Transformation(new Vector3f(), new Quaternionf(), new Vector3f(), new Quaternionf());
    try {
      transformation.getScale().set(1.0F);
      transformation.getTranslation().set(0.0D, -1.0D, -0.25D);
      this.scytheDisplay.setTransformation(transformation);
      this.scytheDisplay.setRotation(this.player.getLocation().getYaw(), 0.0F);
      if (FrostScytheAbilityListener.hasEmptyInventorySlot(this.player).booleanValue())
        try {
          if (this.player.isOnline()) {
            this.scytheDisplay.remove();
            this.player.getInventory().addItem(new ItemStack[] { this.scytheDisplay.getItemStack() });
            cancel();
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    if (!this.player.isOnline()) {
      Item item = (Item)this.scytheDisplay.getWorld().spawnEntity(this.scytheDisplay.getLocation(), EntityType.ITEM);
      item.setItemStack(this.scytheDisplay.getItemStack());
      item.setUnlimitedLifetime(true);
      item.setInvulnerable(true);
      this.scytheDisplay.remove();
      cancel();
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dd.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */