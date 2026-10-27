package net.kingscraft.zenixmc.altarsmp.weapon.nuke;

import java.util.HashSet;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.util.RayTraceResult;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class NukeAbility implements Listener {

  public static boolean activateNuke(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("nukeRadius", 100);
    int j = AltarSMP.getInstance().getConfig().getInt("nukeDuration", 30);
    int k = AltarSMP.getInstance().getConfig().getInt("nukeAnnounceEvery", 10);
    RayTraceResult rayTraceResult = paramPlayer.getWorld().rayTraceBlocks(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), 100.0D);
    {
      if (rayTraceResult == null) {
        paramPlayer.sendMessage(Component.text("No target block found!", NamedTextColor.RED));
        return false;
      } 
    }{
      assert rayTraceResult.getHitBlock() != null;
    }Location location = rayTraceResult.getHitBlock().getLocation().add(0.0D, 1.0D, 0.0D);
    World world = location.getWorld();
    String str1 = String.valueOf(location.getBlock().getX());
    String str2 = String.valueOf(location.getBlock().getY());
    String str3 = String.valueOf(location.getBlock().getZ());
    HashSet<UUID> hashSet = new HashSet<>();
    (new NukeCountdownTask(j, location, paramPlayer, i, hashSet, world, k, str1, str2, str3)).runTaskTimer(AltarSMP.getInstance(), 0L, 20L);
    return true;
  }

  // TODO: TOO MUCH LAG Server Can Crash
  public static void detonateNuke(Location paramLocation, Player paramPlayer, int paramInt) {
    double d = AltarSMP.getInstance().getConfig().getDouble("nukeDamage", 100.0D);

    for (int i = -paramInt; i <= paramInt; i++) {
      for (int j = -paramInt; j <= paramInt; j++) {
        for (int k = -paramInt; k <= paramInt; k++) {

          if (i * i + j * j + k * k > paramInt * paramInt) {
            continue;
          }

          Location location = paramLocation.clone().add(i, j, k);
          Block block = location.getBlock();

          if (!block.getType().isAir()
                  && block.getType().getHardness() != -1.0F) {
            block.setType(Material.AIR);
          }
        }
      }
    }

    for (Player player : paramLocation.getNearbyPlayers(paramInt)) {
      player.spawnParticle(Particle.EXPLOSION, player.getLocation(), 1);

      player.playSound(player, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);

      if (paramPlayer == player) {
        continue;
      }

      if (AltarSMP.isTrusted(paramPlayer, player)) {
        continue;
      }

      TrueDamage.apply(player, d, paramPlayer);
    }
  }
}
