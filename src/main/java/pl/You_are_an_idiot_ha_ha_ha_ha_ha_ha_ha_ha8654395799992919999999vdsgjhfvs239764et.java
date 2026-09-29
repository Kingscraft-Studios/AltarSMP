package pl;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764et extends BukkitRunnable {
  final Player You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  final List You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764et(Player paramPlayer, List paramList) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramPlayer;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = paramList;
    }
  
  public void run() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getWorld().playSound((Entity)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 2.0F, 2.0F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a6.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getLocation());
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.swingMainHand();
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.updateInventory();
    double d1 = Main.getInstance().getConfig().getInt("shadeSoulRange", 40);
    double d2 = 1.2D;
    Location location = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.getEyeLocation();
    double d3;
    for (d3 = 1.5D; d3 < d1; d3 += 1.2D) {
      Vector vector = location.getDirection().normalize();
      Location location1 = location.clone().add(vector.multiply(d3));
      ItemDisplay itemDisplay = (ItemDisplay)location1.getWorld().spawnEntity(location1, EntityType.ITEM_DISPLAY);
      itemDisplay.setItemStack(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a());
      Transformation transformation = itemDisplay.getTransformation();
      transformation.getScale().set(0.5D);
      itemDisplay.setTransformation(transformation);
      itemDisplay.setRotation(0.0F, 0.0F);
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.add(itemDisplay);
      for (Entity entity : location1.getNearbyEntities(1.2D, 0.75D, 1.2D)) {
        Integer integer = Integer.valueOf(Main.getInstance().getConfig().getInt("shadeSoulDamage", 7));
        if (entity instanceof LivingEntity) {
          LivingEntity livingEntity = (LivingEntity)entity;
          {
            if (livingEntity.equals(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a))
              continue; 
          }{
            if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity.getUniqueId(), "enough"))
              continue; 
          }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity.getUniqueId(), "enough", 1.0D);
          livingEntity.setNoDamageTicks(0);
          livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 0, false, false, false));
          livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 1, false, false, true));
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity, integer.intValue(), this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
        } 
      } 
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764et.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */