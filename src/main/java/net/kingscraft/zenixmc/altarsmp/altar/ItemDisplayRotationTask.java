package net.kingscraft.zenixmc.altarsmp.altar;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.joml.AxisAngle4f;

public class ItemDisplayRotationTask extends BukkitRunnable {
  public float rotation;

  public final AltarController controller;

  public ItemDisplayRotationTask(AltarController altarController) {
        this.controller = altarController;
        this.rotation = 0.0f;
    }

  public void run() {
    this.rotation = (float)(this.rotation + AltarManager.getRotationSpeed());
    if (this.rotation >= 6.283185307179586D)
      this.rotation = 0.0F;

    for (AltarInstance altarInstance : this.controller.altars.values()) {
      ItemDisplay itemDisplay = altarInstance.getItemDisplay();
      if (itemDisplay == null)
        continue;


      Transformation transformation = itemDisplay.getTransformation();
      transformation.getLeftRotation().set(new AxisAngle4f(this.rotation, 0.0F, 1.0F, 0.0F));
      itemDisplay.setInterpolationDelay(0);
      itemDisplay.setInterpolationDuration(5);
      itemDisplay.setTeleportDuration(5);
      itemDisplay.setTransformation(transformation);
    } 
  }
}
