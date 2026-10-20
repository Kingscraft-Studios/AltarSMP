package net.kingscraft.zenixmc.altarsmp.weapon.vulcan;

import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class VulcanArrowTrailTask extends BukkitRunnable {
  public int ticksLived;

  public final Arrow primaryArrow;

  public final Arrow secondaryArrow;

  public final Arrow tertiaryArrow;

  public final World world;

  public VulcanArrowTrailTask(Arrow paramArrow1, Arrow paramArrow2, Arrow paramArrow3, World paramWorld) {
        this.primaryArrow = paramArrow1;
        this.secondaryArrow = paramArrow2;
        this.tertiaryArrow = paramArrow3;
        this.world = paramWorld;
        this.ticksLived = 0;
    }

  public void run() {
    this.ticksLived++;
    if (this.ticksLived >= 20) {
      if (this.primaryArrow.isValid())
        this.primaryArrow.remove();

      if (this.secondaryArrow.isValid())
        this.secondaryArrow.remove();

      if (this.tertiaryArrow.isValid())
        this.tertiaryArrow.remove();

      cancel();
      return;
    } 

    if (this.primaryArrow.isValid())
      {
        if (this.primaryArrow.isOnGround()) {
          this.world.spawnParticle(Particle.FLAME, this.primaryArrow.getLocation(), 5, 0.1D, 0.1D, 0.1D, 0.1D);
          this.world.spawnParticle(Particle.FLAME, this.primaryArrow.getLocation(), 5, 0.1D, 0.1D, 0.1D, 0.1D);
          this.world.spawnParticle(Particle.CRIT, this.primaryArrow.getLocation(), 20, 0.0D, 0.0D, 0.0D, 0.5D);
        } 
      }  

    if (this.primaryArrow.isValid())
      {
        if (!this.primaryArrow.isOnGround())
          this.world.spawnParticle(Particle.FLAME, this.primaryArrow.getLocation(), 1, 0.0D, 0.0D, 0.0D, 0.0D);
      }  

    if (this.secondaryArrow.isValid())
      this.world.spawnParticle(Particle.SOUL_FIRE_FLAME, this.secondaryArrow.getLocation(), 1, 0.0D, 0.0D, 0.0D, 0.0D);

    if (this.tertiaryArrow.isValid())
      this.world.spawnParticle(Particle.SOUL_FIRE_FLAME, this.tertiaryArrow.getLocation(), 1, 0.0D, 0.0D, 0.0D, 0.0D);

  }

}
