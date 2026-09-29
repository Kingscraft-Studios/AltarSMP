package pl;

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

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764av implements Listener {
  static final boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = !You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764av.class.desiredAssertionStatus();
  }
  
  
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt("nukeRadius", 100);
    int j = Main.getInstance().getConfig().getInt("nukeDuration", 30);
    int k = Main.getInstance().getConfig().getInt("nukeAnnounceEvery", 10);
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
    String str1 = "" + location.getBlock().getX();
    String str2 = "" + location.getBlock().getY();
    String str3 = "" + location.getBlock().getZ();
    HashSet hashSet = new HashSet();
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f0(j, location, paramPlayer, i, hashSet, world, k, str1, str2, str3)).runTaskTimer((Plugin)Main.getInstance(), 0L, 20L);
    return true;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer, int paramInt) {
    double d = Main.getInstance().getConfig().getDouble("nukeDamage", 100.0D);
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
        if (Main.isTrusted(paramPlayer, (Entity)player))
          continue; 
      }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a((LivingEntity)player, d, paramPlayer);
    } 
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764av.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */