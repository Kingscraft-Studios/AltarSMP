package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

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

    if (this.target instanceof Player) {
      Player player = (Player)this.target;
      player.sendTitle("", String.valueOf(ChatColor.YELLOW) + STUNNED_MESSAGE, 0, 10, 0);
    } 
  }


}
