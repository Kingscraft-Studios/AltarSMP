package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class MudslideParticleTask extends BukkitRunnable {
  final double particleYOffset = 0.5D;

  public int ticksLived;

  public final Player player;

  public MudslideParticleTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.ticksLived = 0;
    }

  public void run() {
    if (this.ticksLived >= 10.0D) {
      cancel();
      return;
    } 

    this.player.getWorld().spawnParticle(Particle.BLOCK_CRUMBLE, this.player.getLocation().clone().add(0.0D, 1.0D, 0.0D), 20, 0.2D, 0.5D, 0.2D, 0.0D, Material.PACKED_MUD.createBlockData());
    this.ticksLived++;
  }

}
