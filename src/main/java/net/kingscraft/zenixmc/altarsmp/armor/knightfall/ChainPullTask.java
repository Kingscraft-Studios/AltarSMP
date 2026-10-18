package net.kingscraft.zenixmc.altarsmp.armor.knightfall;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.ItemUtility;

public class ChainPullTask extends BukkitRunnable {
  public int ticks;

  final int MAX_TICKS = 20;

  public final LivingEntity victim;

  public final Player puller;

  public ChainPullTask(LivingEntity paramLivingEntity, Player paramPlayer) {
        this.victim = paramLivingEntity;
        this.puller = paramPlayer;
        this.ticks = 0;
    }

  public void run() {
    if (this.ticks < 20)
      if (this.victim.isValid())
        if (this.puller.isOnline()) {
          if (this.puller.getWorld() != this.victim.getWorld())
            return;
          if (this.puller.getLocation().distance(this.victim.getLocation()) <= 2.0D) {
            this.victim.setVelocity(new Vector(0, 0, 0));
            cancel();
            return;
          }
          Location location1 = this.victim.getLocation().clone().add(0.0D, 1.0D, 0.0D);
          Location location2 = this.puller.getLocation().clone().add(0.0D, 1.0D, 0.0D);
          Vector vector1 = location2.toVector().subtract(location1.toVector());
          double d = vector1.length();
          Vector vector2 = vector1.normalize().multiply(1);
          if (this.ticks % 2 == 0) {
            double d1 = 0;
            for (d1 = 0.0D; d1 < d; d1 += 0.1D) {
              Location location = location1.clone().add(vector2.clone().multiply(d1));
              location.getWorld().spawnParticle(Particle.ITEM, location, 0, 0.0D, 0.0D, 0.0D, 0.0D, new ItemStack(ItemUtility.getChainMaterial()));
            }
          }
          Vector vector3 = this.puller.getLocation().toVector().subtract(this.victim.getLocation().toVector()).normalize();
          this.victim.setVelocity(vector3.multiply(1.5D));
          this.ticks++;
          return;
        }
    cancel();
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fw.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */