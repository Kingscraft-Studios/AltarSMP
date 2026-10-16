package pl;

import java.util.Iterator;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class ScorchingBladeProjectileTask extends BukkitRunnable {
  final int MAX_TICKS = 5;
  
  int ticks;
  
  final Set fallingBlocks;
  
  final Player player;
  
  ScorchingBladeProjectileTask(ScorchingBladeAbility scorchingBladeAbility, Set paramSet, Player paramPlayer) {
        this.fallingBlocks = paramSet;
        this.player = paramPlayer;
        this.ticks = 0;
    }
  
  public void run() {
    if (this.ticks >= 100) {
      for (FallingBlock fallingBlock : (Iterable<FallingBlock>)(Iterable<?>)this.fallingBlocks)
        fallingBlock.remove(); 
      cancel();
      return;
    } 
    Iterator<FallingBlock> iterator = this.fallingBlocks.iterator();
    while (iterator.hasNext()) {
      FallingBlock fallingBlock = iterator.next();
      Location location = fallingBlock.getLocation();
      location.getWorld().spawnParticle(Particle.CRIT, location, 5, 0.0D, 0.0D, 0.0D, 0.2D);
      boolean bool1 = location.getNearbyEntities(2.0D, 2.0D, 2.0D).stream().anyMatch(paramEnt2 -> isTargetableEntity(this.player, paramEnt2));
      boolean bool2 = BlockAreaUtils.getBlocksInArea(location, 2, 1).stream().anyMatch(ScorchingBladeProjectileTask::isSolidBlock);
      try {
        if (!bool2 && !bool1 && !fallingBlock.isDead())
          continue; 
        ScorchingBladeAbility.detonateScorchingBlade(location, this.player);
        iterator.remove();
        fallingBlock.remove();
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    this.ticks++;
  }
  
  private static boolean isSolidBlock(Block paramBlock) {
    return paramBlock.getType().isSolid();
  }
  
  private static boolean isTargetableEntity(Player paramPlayer, Entity paramEntity) {
    try {
      if (paramEntity instanceof org.bukkit.entity.LivingEntity)
        try {
          if (paramEntity != paramPlayer)
            try {
              if (!Main.isTrusted(paramPlayer, paramEntity));
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764dv.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */