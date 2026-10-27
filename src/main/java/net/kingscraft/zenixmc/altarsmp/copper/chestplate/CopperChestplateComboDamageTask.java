package net.kingscraft.zenixmc.altarsmp.copper.chestplate;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

class CopperChestplateComboDamageTask extends BukkitRunnable {
  public final LivingEntity target;

  public final Player attacker;

  public CopperChestplateComboDamageTask(LivingEntity paramLivingEntity, Player paramPlayer) {
        this.target = paramLivingEntity;
        this.attacker = paramPlayer;
    }

  public void run() {
    if (this.target.isValid())
      {
        if (!this.target.isDead())
          TrueDamage.apply(this.target, CopperChestplateComboAbility.MAX_DAMAGE, this.attacker);
      }  

  }

}
