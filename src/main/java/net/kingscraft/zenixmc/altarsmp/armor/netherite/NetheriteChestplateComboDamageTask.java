package net.kingscraft.zenixmc.altarsmp.armor.netherite;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

class NetheriteChestplateComboDamageTask extends BukkitRunnable {
  public final LivingEntity target;

  public final Player attacker;

  public NetheriteChestplateComboDamageTask(LivingEntity paramLivingEntity, Player paramPlayer) {
        this.target = paramLivingEntity;
        this.attacker = paramPlayer;
    }

  public void run() {
    if (this.target.isValid())
      {
        if (!this.target.isDead())
          TrueDamage.apply(this.target, NetheriteChestplateComboAbility.MAX_DAMAGE, this.attacker);
      }  

  }

}
