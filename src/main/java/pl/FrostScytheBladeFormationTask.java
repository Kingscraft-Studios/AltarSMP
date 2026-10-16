package pl;

import java.util.List;
import org.bukkit.Sound;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;

class FrostScytheBladeFormationTask extends BukkitRunnable {
  int animationStep = 1;
  
  final List bladeDisplays;
  
  final Player player;
  
  FrostScytheBladeFormationTask(List paramList, Player paramPlayer) {
        this.bladeDisplays = paramList;
        this.player = paramPlayer;
        this.animationStep = 1;
    }
  
  public void run() {
    ItemDisplay itemDisplay = (ItemDisplay)this.bladeDisplays.get(this.animationStep);
    double d = 1.5D;
    if (this.animationStep == 1)
      d = 2.0D; 
    itemDisplay.setViewRange(100.0F);
    this.player.getWorld().playSound(this.player.getLocation(), Sound.ENTITY_ENDER_EYE_DEATH, 2.0F, 0.75F);
    itemDisplay.setInterpolationDelay(0);
    itemDisplay.setInterpolationDuration(10);
    Transformation transformation = itemDisplay.getTransformation();
    try {
      transformation.getTranslation().set((this.animationStep - 1) * 1.5D, d, 0.0D);
      transformation.getLeftRotation().rotateY((float)Math.toRadians(45.0D));
      transformation.getLeftRotation().rotateX((float)Math.toRadians(45.0D));
      itemDisplay.setTransformation(transformation);
      if (this.animationStep == 1) {
        this.animationStep++;
      } else {
        try {
          if (this.animationStep == 2) {
            this.animationStep = 0;
            return;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.animationStep == 0)
        cancel(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764de.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */