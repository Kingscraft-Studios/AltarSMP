package pl;

import org.bukkit.Location;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e1 extends BukkitRunnable {
  final Location You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  final ItemDisplay You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e1(Location paramLocation, ItemDisplay paramItemDisplay) {}
  
  public void run() {
    double d1;
    Location location1 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.clone().add(0.0D, 0.0D, 0.0D);
    if (Math.random() < 0.5D) {
      d1 = -1.0D + Math.random();
    } else {
      d1 = 1.0D + Math.random();
    } 
    Vector vector1 = location1.getDirection().normalize().multiply(d1);
    double d2 = (Math.random() - 0.5D) * 6.0D;
    double d3 = (Math.random() - 0.5D) * 6.0D;
    double d4 = (Math.random() - 0.5D) * 6.0D;
    Vector vector2 = new Vector(d2, d3, d4);
    Location location2 = location1.clone().add(vector1).add(vector2);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.teleport(location2);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e1.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */