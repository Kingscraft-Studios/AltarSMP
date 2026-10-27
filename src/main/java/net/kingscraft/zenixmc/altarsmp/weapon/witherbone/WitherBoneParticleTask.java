package net.kingscraft.zenixmc.altarsmp.weapon.witherbone;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;

class WitherBoneParticleTask extends BukkitRunnable {
  public Vector particleVelocity;

  public float rotationAngle;

  public int ticksLived;

  public final Vector initialVelocity;

  public final ItemDisplay boneDisplay;

  public WitherBoneParticleTask(Vector paramVector, ItemDisplay paramItemDisplay) {
        this.initialVelocity = paramVector;
        this.boneDisplay = paramItemDisplay;
        this.particleVelocity = this.initialVelocity.clone();
        this.rotationAngle = 0.0f;
        this.ticksLived = 0;
    }

  public void run() {
    if (this.ticksLived < 20)
      {
        if (this.boneDisplay.isValid()) {
          this.boneDisplay.teleport(this.boneDisplay.getLocation().add(this.particleVelocity));
          this.particleVelocity.setX(this.particleVelocity.getX() * 0.88D);
          this.particleVelocity.setZ(this.particleVelocity.getZ() * 0.88D);
          this.rotationAngle += 0.6F;
          Transformation transformation = this.boneDisplay.getTransformation();
          transformation.getLeftRotation().set(new AxisAngle4f(this.rotationAngle, 0.0F, 1.0F, 0.0F));
          transformation.getRightRotation().set(new AxisAngle4f(this.rotationAngle * 0.9F, 1.0F, 0.0F, 0.0F));
          this.boneDisplay.setTransformation(transformation);
          this.boneDisplay.setInterpolationDelay(0);
          this.boneDisplay.setInterpolationDuration(5);
          Location location = this.boneDisplay.getLocation().clone();
          double d1 = 0.3D + Math.random() * 0.2D;
          double d2 = Math.random() * Math.PI * 2.0D;
          location.add(Math.cos(d2) * d1, 0.0D, Math.sin(d2) * d1);
          Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(40, 40, 40), 0.6F);
          this.boneDisplay.getWorld().spawnParticle(Particle.DUST, location, 3, 0.0D, 0.0D, 0.0D, 0.0D, dustOptions);
          this.ticksLived++;
          return;
        }
        this.boneDisplay.remove();
        cancel();
        return;
      }

    this.boneDisplay.remove();
    cancel();
  }

}
