package net.kingscraft.zenixmc.altarsmp.task;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Display;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class MudslideProjectileTask extends BukkitRunnable {
  public final Player player;
  
  public MudslideProjectileTask(Player paramPlayer) {
        this.player = paramPlayer;
    }
  
  public void run() {
    this.player.getWorld().playSound(this.player.getLocation(), Sound.BLOCK_MUD_BREAK, 5.0F, 1.0F);
    this.player.swingMainHand();
    this.player.updateInventory();
    double d1 = AltarSMP.getInstance().getConfig().getDouble("mudGravity", 0.0025D);
    double d2 = AltarSMP.getInstance().getConfig().getDouble("mudMaxDistance", 100.0D);
    double d3 = AltarSMP.getInstance().getConfig().getDouble("mudDamage", 4.0D);
    int i = AltarSMP.getInstance().getConfig().getInt("muddiedDuration", 4) * 20;
    Location location = this.player.getLocation();
    Vector vector = location.getDirection().normalize().clone().setY(0);
    World world = this.player.getWorld();
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(location.clone().add(vector.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.MUD));
    itemDisplay.setBrightness(new Display.Brightness(15, 15));
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getTranslation().set(0.0D, 1.5D, 0.0D);
    transformation.getScale().set(1.5F, 1.5F, 1.5F);
    itemDisplay.setTransformation(transformation);
    (new MudslideProjectileAnimationTask(this, location, d2, itemDisplay, vector, d1, world, d3, i)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d_.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */