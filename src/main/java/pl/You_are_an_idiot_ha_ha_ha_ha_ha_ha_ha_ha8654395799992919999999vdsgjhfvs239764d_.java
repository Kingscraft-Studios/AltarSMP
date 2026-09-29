package pl;

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

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d_ extends BukkitRunnable {
  final Player You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d_(Player paramPlayer) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramPlayer;
    }
  
  public void run() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getWorld().playSound(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getLocation(), Sound.BLOCK_MUD_BREAK, 5.0F, 1.0F);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.swingMainHand();
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.updateInventory();
    double d1 = Main.getInstance().getConfig().getDouble("mudGravity", 0.0025D);
    double d2 = Main.getInstance().getConfig().getDouble("mudMaxDistance", 100.0D);
    double d3 = Main.getInstance().getConfig().getDouble("mudDamage", 4.0D);
    int i = Main.getInstance().getConfig().getInt("muddiedDuration", 4) * 20;
    Location location = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getLocation();
    Vector vector = location.getDirection().normalize().clone().setY(0);
    World world = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getWorld();
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(location.clone().add(vector.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.MUD));
    itemDisplay.setBrightness(new Display.Brightness(15, 15));
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getTranslation().set(0.0D, 1.5D, 0.0D);
    transformation.getScale().set(1.5F, 1.5F, 1.5F);
    itemDisplay.setTransformation(transformation);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ea(this, location, d2, itemDisplay, vector, d1, world, d3, i)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d_.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */