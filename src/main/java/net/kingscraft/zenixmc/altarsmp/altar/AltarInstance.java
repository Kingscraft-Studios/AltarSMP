package net.kingscraft.zenixmc.altarsmp.altar;

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

  public void removeItemDisplay() {
    if (this.itemDisplay != null)
        if (!this.itemDisplay.isDead()) {
            this.itemDisplay.remove();
            this.itemDisplay = null;
        }
  }

}
