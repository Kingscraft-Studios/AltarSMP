package net.kingscraft.zenixmc.altarsmp.task;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.util.FloatingTextEffectUtils;

public class FloatingTextSpawnTask extends BukkitRunnable {
  public int ticksElapsed;
  
  public final int maxTicks;
  
  public final int spawnCount;
  
  public final Location location;
  
  public final Color backgroundColor;
  
  public final Color textColor;
  
  public final double verticalOffset;
  
  public final int interpolationDuration;
  
  public final int displayDuration;
  
  public final boolean animated;
  
  public final String text;
  
  public final int spawnInterval;
  
  public final int cleanupDelay;
  
  public FloatingTextSpawnTask(int paramInt1, int paramInt2, Location paramLocation, Color paramColor1, Color paramColor2, double paramDouble, int paramInt3, int paramInt4, boolean paramBoolean, String paramString, int paramInt5, int paramInt6) {
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
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hi.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */