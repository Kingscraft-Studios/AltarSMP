package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import java.time.Duration;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

class BoneCageStunTitleTask extends BukkitRunnable {
  public final LivingEntity target;

  private static final String STUNNED_MESSAGE = "Stunned!";

  public BoneCageStunTitleTask(LivingEntity paramLivingEntity) {
        this.target = paramLivingEntity;
    }

  public void run() {
    if (!BoneBladeAbility.boneCageDisplays.containsKey(this.target)) {
      cancel();
      return;
    } 

    if (this.target instanceof Player player) {
        player.showTitle(Title.title(
          Component.empty(),
          Component.text(STUNNED_MESSAGE, NamedTextColor.YELLOW),
          Title.Times.times(Duration.ZERO, Duration.ofMillis(500), Duration.ZERO)));
    } 
  }


}
