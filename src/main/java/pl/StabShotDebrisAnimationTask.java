package pl;

import java.util.HashMap;
import java.util.HashSet;
import org.bukkit.Location;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.joml.Quaternionf;
import org.joml.Vector3f;

class StabShotDebrisAnimationTask extends BukkitRunnable {
  int ticks;
  
  final HashSet debrisDisplays;
  
  final HashMap debrisVelocities;
  
  StabShotDebrisAnimationTask(HashSet paramHashSet, HashMap paramHashMap) {
        this.debrisDisplays = paramHashSet;
        this.debrisVelocities = paramHashMap;
        this.ticks = 0;
    }
  
  public void run() {
    this.ticks++;
    if (this.ticks <= 40)
      for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.debrisDisplays) {
        double[] arrayOfDouble = (double[])this.debrisVelocities.get(itemDisplay);
        try {
          if (arrayOfDouble == null)
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        arrayOfDouble[1] = arrayOfDouble[1] - 0.04D;
        arrayOfDouble[0] = arrayOfDouble[0] * 0.98D;
        arrayOfDouble[1] = arrayOfDouble[1] * 0.98D;
        arrayOfDouble[2] = arrayOfDouble[2] * 0.98D;
        Location location = itemDisplay.getLocation().clone();
        location.add(arrayOfDouble[0], arrayOfDouble[1], arrayOfDouble[2]);
        itemDisplay.setTeleportDuration(2);
        itemDisplay.teleport(location);
      }  
    if (this.ticks == 3)
      for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.debrisDisplays) {
        itemDisplay.setInterpolationDelay(0);
        itemDisplay.setInterpolationDuration(40);
        Transformation transformation = itemDisplay.getTransformation();
        Quaternionf quaternionf = (new Quaternionf()).rotateXYZ((float)Math.toRadians(Math.random() * 360.0D), (float)Math.toRadians(Math.random() * 360.0D), (float)Math.toRadians(Math.random() * 360.0D));
        itemDisplay.setTransformation(new Transformation(transformation.getTranslation(), quaternionf, transformation.getScale(), transformation.getRightRotation()));
      }  
    if (this.ticks == 35)
      for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.debrisDisplays) {
        itemDisplay.setInterpolationDelay(0);
        itemDisplay.setInterpolationDuration(5);
        Transformation transformation = itemDisplay.getTransformation();
        itemDisplay.setTransformation(new Transformation(transformation.getTranslation(), transformation.getLeftRotation(), new Vector3f(0.0F, 0.0F, 0.0F), transformation.getRightRotation()));
      }  
    if (this.ticks >= 40) {
      for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.debrisDisplays)
        itemDisplay.remove(); 
      this.debrisDisplays.clear();
      this.debrisVelocities.clear();
      cancel();
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f5.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */