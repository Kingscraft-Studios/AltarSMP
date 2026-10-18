package pl;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.TextDisplay;

public class AltarInstance {
  public final String type;
  
  public final Location location;
  
  public ItemDisplay itemDisplay;
  
  public final List<TextDisplay> holograms;
  
  private static final String a = "STRUCTURE_BLOCK";
  
  public AltarInstance(String paramString, Location paramLocation) {
    this.type = paramString;
    this.location = paramLocation;
    this.holograms = new ArrayList<>();
  }
  
  public String getType() {
    return this.type;
  }
  
  public Location getLocation() {
    return this.location;
  }
  
  public ItemDisplay getItemDisplay() {
    return this.itemDisplay;
  }
  
  public void setItemDisplay(ItemDisplay paramItemDisplay) {
    this.itemDisplay = paramItemDisplay;
  }
  
  public List<TextDisplay> getHolograms() {
    return this.holograms;
  }
  
  public void addHologram(TextDisplay paramTextDisplay) {
    this.holograms.add(paramTextDisplay);
  }
  
  public void removeAllEntities() {
    if (this.itemDisplay != null)
      if (!this.itemDisplay.isDead())
        this.itemDisplay.remove();

    for (TextDisplay textDisplay : this.holograms) {
      if (!textDisplay.isDead())
          textDisplay.remove();
    } 
    this.holograms.clear();
  }
  
  public boolean isStructureBlock() {
    return this.location.getBlock().getType().toString().contains(a);
  }
  
  public void removeItemDisplay() {
    if (this.itemDisplay != null)
        if (!this.itemDisplay.isDead()) {
            this.itemDisplay.remove();
            this.itemDisplay = null;
          }
  }
  
  public boolean hasItemDisplay() {
    return this.itemDisplay != null && !this.itemDisplay.isDead();
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */