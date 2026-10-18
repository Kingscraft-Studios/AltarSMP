package pl;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

class FloatingTextSpawnTask extends BukkitRunnable {
  int ticksElapsed;
  
  final int maxTicks;
  
  final int spawnCount;
  
  final Location location;
  
  final Color backgroundColor;
  
  final Color textColor;
  
  final double verticalOffset;
  
  final int interpolationDuration;
  
  final int displayDuration;
  
  final boolean animated;
  
  final String text;
  
  final int spawnInterval;
  
  final int cleanupDelay;
  
  FloatingTextSpawnTask(int paramInt1, int paramInt2, Location paramLocation, Color paramColor1, Color paramColor2, double paramDouble, int paramInt3, int paramInt4, boolean paramBoolean, String paramString, int paramInt5, int paramInt6) {
        this.maxTicks = paramInt1;
        this.spawnCount = paramInt2;
        this.location = paramLocation;
        this.backgroundColor = paramColor1;
        this.textColor = paramColor2;
        this.verticalOffset = paramDouble;
        this.interpolationDuration = paramInt3;
        this.displayDuration = paramInt4;
        this.animated = paramBoolean;
        this.text = paramString;
        this.spawnInterval = paramInt5;
        this.cleanupDelay = paramInt6;
        this.ticksElapsed = 0;
    }
  
  public void run() {
    try {
      if (this.ticksElapsed >= this.maxTicks) {
        cancel();
        return;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    int b = 0;
    try {
      while (b < this.spawnCount) {
        FloatingTextEffectUtils.spawnFloatingTextDisplay(this.location, this.backgroundColor, this.textColor, this.verticalOffset, this.interpolationDuration, this.displayDuration, this.animated, this.text, this.spawnInterval, this.cleanupDelay);
        b++;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.ticksElapsed++;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hi.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */