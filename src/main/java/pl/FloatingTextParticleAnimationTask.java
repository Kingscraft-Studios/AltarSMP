package pl;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.TextDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

class FloatingTextParticleAnimationTask extends BukkitRunnable {
  final Location origin;
  
  final boolean allowNegativeVerticalOffset;
  
  final double horizontalSpread;
  
  final double verticalSpread;
  
  final TextDisplay textDisplay;
  
  final String text;
  
  final Color particleColor;
  
  FloatingTextParticleAnimationTask(Location paramLocation, boolean paramBoolean, double paramDouble1, double paramDouble2, TextDisplay paramTextDisplay, String paramString, Color paramColor) {
        this.origin = paramLocation;
        this.allowNegativeVerticalOffset = paramBoolean;
        this.horizontalSpread = paramDouble1;
        this.verticalSpread = paramDouble2;
        this.textDisplay = paramTextDisplay;
        this.text = paramString;
        this.particleColor = paramColor;
    }
  
  public void run() {
    Location location1 = this.origin.clone().add(0.0D, 0.0D, 0.0D);
    double d1 = Math.random();
    double d2 = Math.random();
    double d3 = Math.cbrt(Math.random());
    double d4 = 6.283185307179586D * d1;
    double d5 = Math.acos(2.0D * d2 - 1.0D);
    double d6 = d3 * Math.sin(d5) * Math.cos(d4);
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    double d7 = this.allowNegativeVerticalOffset ? (d3 * Math.cos(d5)) : Math.abs(d3 * Math.cos(d5));
    double d8 = d3 * Math.sin(d5) * Math.sin(d4);
    Vector vector = new Vector(d6 * this.horizontalSpread, d7 * this.verticalSpread, d8 * this.horizontalSpread);
    Location location2 = location1.clone().add(vector);
    this.textDisplay.teleport(location2);
    Transformation transformation = this.textDisplay.getTransformation();
    try {
      if (this.text.equals(" ")) {
        this.textDisplay.setBackgroundColor(this.particleColor);
      } else {
        this.textDisplay.setText(ChatFormattingUtils.toHexColorCode(this.particleColor) + this.text);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    this.textDisplay.setTransformation(transformation);
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hj.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */