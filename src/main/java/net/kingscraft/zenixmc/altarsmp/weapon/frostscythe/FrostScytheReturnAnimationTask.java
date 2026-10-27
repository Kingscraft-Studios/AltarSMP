package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

class FrostScytheReturnAnimationTask extends BukkitRunnable {
  public final Player player;

  public final ItemDisplay scytheDisplay;

  public FrostScytheReturnAnimationTask(Player paramPlayer, ItemDisplay paramItemDisplay) {
        this.player = paramPlayer;
        this.scytheDisplay = paramItemDisplay;
    }

  public void run() {
    this.player.addPassenger(this.scytheDisplay);
    Transformation transformation = new Transformation(new Vector3f(), new Quaternionf(), new Vector3f(), new Quaternionf());
    transformation.getScale().set(1.0F);
    transformation.getTranslation().set(0.0D, -1.0D, -0.25D);
    this.scytheDisplay.setTransformation(transformation);
    this.scytheDisplay.setRotation(this.player.getLocation().getYaw(), 0.0F);
    if (FrostScytheAbilityListener.hasEmptyInventorySlot(this.player))
      {
        if (this.player.isOnline()) {
          this.scytheDisplay.remove();
          this.player.getInventory().addItem(this.scytheDisplay.getItemStack());
          cancel();
          return;
        } 
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

}
