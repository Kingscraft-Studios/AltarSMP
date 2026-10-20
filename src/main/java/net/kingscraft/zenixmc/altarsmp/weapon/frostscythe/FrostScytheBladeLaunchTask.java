package net.kingscraft.zenixmc.altarsmp.weapon.frostscythe;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class FrostScytheBladeLaunchTask extends BukkitRunnable {
  public final List bladeDisplays;

  public final int bladeIndex;

  public final Player player;

  public FrostScytheBladeLaunchTask(List paramList, int paramInt, Player paramPlayer) {
        this.bladeDisplays = paramList;
        this.bladeIndex = paramInt;
        this.player = paramPlayer;
    }

  public void run() {
    ItemDisplay itemDisplay = (ItemDisplay)this.bladeDisplays.get(this.bladeIndex);
    itemDisplay.setInterpolationDelay(0);
    itemDisplay.setInterpolationDuration(10);
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getTranslation().set(0.0F, 0.0F, 0.0F);
    itemDisplay.setTransformation(transformation);
    this.player.getWorld().playSound(itemDisplay.getLocation(), Sound.ENTITY_SNOW_GOLEM_SHOOT, 1.0F, 0.5F);
    this.player.getWorld().playSound(itemDisplay.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.5F, 0.8F);
    Location location1 = itemDisplay.getLocation();
    Location location2 = this.player.getTargetBlock(null, 100).getLocation();
    Vector vector = location2.toVector().subtract(location1.toVector()).normalize();
    (new FrostScytheBladeProjectileTask(this, location1, itemDisplay, vector)).runTaskTimer((Plugin) FrostScytheAbilityListener.plugin, 0L, 1L);
  }
}
