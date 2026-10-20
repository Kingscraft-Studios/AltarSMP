package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class FrostScytheLaunchTask extends BukkitRunnable {
  public final Player player;

  public final boolean returnScythe;

  public final double throwPower;

  public final int maxThrowDistance;

  public final int damage;

  public FrostScytheLaunchTask(Player paramPlayer, boolean paramBoolean, double paramDouble, int paramInt1, int paramInt2) {
        this.player = paramPlayer;
        this.returnScythe = paramBoolean;
        this.throwPower = paramDouble;
        this.maxThrowDistance = paramInt1;
        this.damage = paramInt2;
    }

  public void run() {
    Location location1 = this.player.getLocation().clone().add(this.player.getLocation().getDirection()).add(0.0D, 1.2D, 0.0D);
    FrostScytheAbilityListener.throwScythe(this.player, location1);
    ItemStack itemStack = this.player.getInventory().getItemInMainHand();
    Location location2 = this.player.getEyeLocation();
    Vector vector1 = location2.getDirection().normalize();
    ItemDisplay itemDisplay = (ItemDisplay)this.player.getWorld().spawnEntity(location2.add(vector1.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(itemStack);
    if (this.returnScythe)
      itemStack.setAmount(0); 

    Transformation transformation = new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 0.0F), new Vector3f(1.5F, 1.5F, 1.5F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F));
    transformation.getLeftRotation().rotateZ((float)Math.toRadians(90.0D));
    itemDisplay.setTransformation(transformation);
    Vector vector2 = vector1.multiply(this.throwPower);
    (new FrostScytheProjectileTask(this, vector2, itemDisplay)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }

}
