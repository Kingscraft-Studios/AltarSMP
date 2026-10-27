package net.kingscraft.zenixmc.altarsmp.weapon.meteor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class MeteorStrikePullTask extends BukkitRunnable {
  public int ticksLived;

  public final LivingEntity target;

  public final Player player;

  public MeteorStrikePullTask(LivingEntity paramLivingEntity, Player paramPlayer) {
        this.target = paramLivingEntity;
        this.player = paramPlayer;
        this.ticksLived = 0;
    }

  public void run() {
    if (this.ticksLived < 20)
      {
        if (this.target.isValid())
          {
            if (this.player.isOnline()) {
              if (this.player.getWorld() != this.target.getWorld())
                return; 

              if (this.player.getLocation().distance(this.target.getLocation()) <= 2.0D) {
                this.target.setVelocity(new Vector(0, 0, 0));
                cancel();
                return;
              } 

              Location location1 = this.target.getLocation().clone().add(0.0D, 1.0D, 0.0D);
              Location location2 = this.player.getLocation().clone().add(0.0D, 1.0D, 0.0D);
              Vector vector1 = location2.toVector().subtract(location1.toVector());
              double d1 = vector1.length();
              Vector vector2 = vector1.normalize().multiply(1);
              double d2;
              for (d2 = 0.0D; d2 < d1; d2++) {
                Location location = location1.clone().add(vector2.clone().multiply(d2));
                location1.getWorld().spawnParticle(Particle.ITEM, location, 0, 0.0D, 0.0D, 0.0D, 0.0D, new ItemStack(Material.MUD));
              } 
              this.player.getWorld().playSound(this.player.getLocation(), Sound.BLOCK_PACKED_MUD_BREAK, 1.0F, 1.0F);
              Vector vector3 = this.player.getLocation().toVector().subtract(this.target.getLocation().toVector()).normalize();
              this.target.setVelocity(vector3.multiply(1.5D));
              this.ticksLived++;
              return;
            } 
            cancel();
            return;
          }  
      }  

    cancel();
  }

}
