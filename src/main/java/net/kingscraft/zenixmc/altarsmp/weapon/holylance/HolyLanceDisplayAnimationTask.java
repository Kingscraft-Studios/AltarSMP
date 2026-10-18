package net.kingscraft.zenixmc.altarsmp.weapon.holylance;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class HolyLanceDisplayAnimationTask extends BukkitRunnable {
  public int ticks;

  float rotationAngle = 0.0F;

  float scale = 1.5F;

  public final ItemDisplay itemDisplay;

  public HolyLanceDisplayAnimationTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
        this.ticks = 0;
        this.rotationAngle = 0.0f;
        this.scale = 1.5f;
    }

  public void run() {
    if (this.itemDisplay.isValid())
      {
        if (this.ticks < 20) {
          this.itemDisplay.setInterpolationDelay(0);
          this.itemDisplay.setInterpolationDuration(2);
          this.itemDisplay.setTeleportDuration(2);
          this.rotationAngle += (float)Math.toRadians(30.0D);
          if (this.rotationAngle >= 6.283185307179586D)
            this.rotationAngle = 0.0F;

          if (this.ticks >= 10)
            {
              this.scale -= 0.25F;
              if (this.scale < 0.0F)
                this.scale = 0.0F;
            }  

          Quaternionf quaternionf = new Quaternionf();
          quaternionf.rotateY(this.rotationAngle);
          Transformation transformation = new Transformation(new Vector3f(0.0F, 15.0F, 0.0F), new AxisAngle4f((Quaternionfc)quaternionf), new Vector3f(this.scale, 30.0F, this.scale), new AxisAngle4f(0.0F, 0.0F, 0.0F, 0.0F));
          this.itemDisplay.setTransformation(transformation);
          this.ticks++;
          return;
        } 
        if (this.itemDisplay.isValid())
          this.itemDisplay.remove();

      }  

    if (this.itemDisplay.isValid())
      this.itemDisplay.remove();

  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764du.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */