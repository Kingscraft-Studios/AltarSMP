package pl;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Display;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Transformation;

public class FloatingTextEffectUtils {
  public static void spawnPlayerStarEffect(Player paramPlayer) {
    Location location = paramPlayer.getLocation();
    int b = 5;
    spawnAnimatedTextEffect(location, 1, Color.WHITE, Color.WHITE, b, b * 10, 10, b, true, "✦", 40, 10);
  }
  
  public static void spawnAnimatedTextEffect(Location paramLocation, int paramInt1, Color paramColor1, Color paramColor2, double paramDouble, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean, String paramString, int paramInt5, int paramInt6) {
    (new FloatingTextSpawnTask(paramInt1, paramInt2, paramLocation, paramColor1, paramColor2, paramDouble, paramInt3, paramInt4, paramBoolean, paramString, paramInt5, paramInt6)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void spawnFloatingTextDisplay(Location paramLocation, Color paramColor1, Color paramColor2, double paramDouble1, int paramInt1, double paramDouble2, boolean paramBoolean, String paramString, int paramInt2, int paramInt3) {
    paramLocation.add(0.0D, 0.0D, 0.0D);
    World world = paramLocation.getWorld();
    TextDisplay textDisplay = (TextDisplay)world.spawnEntity(paramLocation, EntityType.TEXT_DISPLAY);
    textDisplay.setText(paramString);
    float f = 2.0F;
    try {
      if (paramString.equals(" ")) {
        textDisplay.setBackgroundColor(paramColor1);
      } else {
        f = 4.0F;
        textDisplay.setBackgroundColor(Color.fromARGB(0, 0, 0, 0));
        textDisplay.setText(ChatFormattingUtils.toHexColorCode(paramColor1) + paramString);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    textDisplay.setBillboard(Display.Billboard.CENTER);
    Transformation transformation = textDisplay.getTransformation();
    transformation.getScale().set(4.0F, f, 4.0F);
    textDisplay.setTransformation(transformation);
    textDisplay.setInterpolationDelay(0);
    textDisplay.setInterpolationDuration(paramInt1);
    textDisplay.setTeleportDuration(paramInt1);
    (new FloatingTextParticleAnimationTask(paramLocation, paramBoolean, paramDouble1, paramDouble2, textDisplay, paramString, paramColor2)).runTaskLater((Plugin)Main.getInstance(), 2L);
    (new FloatingTextShrinkTask(textDisplay, paramInt2)).runTaskLater((Plugin)Main.getInstance(), paramInt3);
    (new FloatingTextRemovalTask(textDisplay)).runTaskLater((Plugin)Main.getInstance(), (paramInt3 + paramInt2));
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ci.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */