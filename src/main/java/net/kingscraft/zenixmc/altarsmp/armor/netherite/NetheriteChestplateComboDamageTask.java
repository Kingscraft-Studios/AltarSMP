package net.kingscraft.zenixmc.altarsmp.armor.netherite;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

class NetheriteChestplateComboDamageTask extends BukkitRunnable {
  public final LivingEntity target;

  public final Player attacker;

  public NetheriteChestplateComboDamageTask(NetheriteChestplateComboAbility netheriteChestplateComboAbility, LivingEntity paramLivingEntity, Player paramPlayer) {
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f_.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */