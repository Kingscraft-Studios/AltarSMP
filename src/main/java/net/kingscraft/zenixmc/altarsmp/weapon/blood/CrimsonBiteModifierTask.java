package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

class CrimsonBiteModifierTask extends BukkitRunnable {
  public final AttributeInstance victimMaxHealth;
  
  public final AttributeModifier victimModifier;
  
  public final AttributeInstance attackerMaxHealth;
  
  public final AttributeModifier attackerModifier;
  
  public final CrimsonBiteTask parent;
  
  public CrimsonBiteModifierTask(CrimsonBiteTask crimsontask, AttributeInstance paramAttributeInstance1, AttributeModifier paramAttributeModifier1, AttributeInstance paramAttributeInstance2, AttributeModifier paramAttributeModifier2) {
        this.parent = crimsontask;
        this.victimMaxHealth = paramAttributeInstance1;
        this.victimModifier = paramAttributeModifier1;
        this.attackerMaxHealth = paramAttributeInstance2;
        this.attackerModifier = paramAttributeModifier2;
    }
  
  public void run() {
    if (!this.parent.victim.isDead())
      this.victimMaxHealth.removeModifier(this.victimModifier);

    if (this.parent.attacker.isOnline())
      this.attackerMaxHealth.removeModifier(this.attackerModifier);
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d1.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */