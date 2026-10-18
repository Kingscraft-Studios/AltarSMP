package net.kingscraft.zenixmc.altarsmp.ability.nuke;

import java.util.HashSet;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.RayTraceResult;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class NukeAbility implements Listener {
  public static final boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = !NukeAbility.class.desiredAssertionStatus();
  }


  public static boolean activateNuke(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("nukeRadius", 100);
    int j = AltarSMP.getInstance().getConfig().getInt("nukeDuration", 30);
    int k = AltarSMP.getInstance().getConfig().getInt("nukeAnnounceEvery", 10);
    RayTraceResult rayTraceResult = paramPlayer.getWorld().rayTraceBlocks(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), 100.0D);
    {
      if (rayTraceResult == null) {
        paramPlayer.sendMessage("§cNo target block found!");
        return false;
      } 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a)
        {
          if (rayTraceResult.getHitBlock() == null)
            throw new AssertionError(); 
        }}Location location = rayTraceResult.getHitBlock().getLocation().add(0.0D, 1.0D, 0.0D);
    World world = location.getWorld();
    String str1 = String.valueOf(location.getBlock().getX());
    String str2 = String.valueOf(location.getBlock().getY());
    String str3 = String.valueOf(location.getBlock().getZ());
    HashSet hashSet = new HashSet();
    (new NukeCountdownTask(j, location, paramPlayer, i, hashSet, world, k, str1, str2, str3)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 20L);
    return true;
  }

  public static void detonateNuke(Location paramLocation, Player paramPlayer, int paramInt) {
    double d = AltarSMP.getInstance().getConfig().getDouble("nukeDamage", 100.0D);
    for (int i = -paramInt; i <= paramInt; i++) {
      int j = -paramInt;
      while (j <= paramInt) {
        int k = -paramInt;
        while (true) {
          {
            if (k <= paramInt) {
              if (i * i + j * j + k * k <= paramInt * paramInt) {
                Location location = paramLocation.clone().add(i, j, k);
                Block block = location.getBlock();
                {
                  if (!block.getType().isAir())
                    {
                      if (block.getType().getHardness() != -1.0F)
                        block.setType(Material.AIR); 
                    }}} 
              k++;
              continue;
            } 
          }j++;
        } 
      } 
    } 
    for (Player player : paramLocation.getNearbyPlayers(paramInt)) {
      {
        player.spawnParticle(Particle.EXPLOSION, player.getLocation(), 1);
        player.playSound((Entity)player, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
        if (paramPlayer == player)
          continue; 
      }{
        if (AltarSMP.isTrusted(paramPlayer, (Entity)player))
          continue; 
      }
        TrueDamage.apply((LivingEntity)player, d, paramPlayer);
    } 
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764av.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */