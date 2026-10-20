package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.ability.paladin.PaladinEarthAbility;

public class EarthShatterItemDisplayTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public EarthShatterItemDisplayTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }

  public void run() {
    this.itemDisplay.setItemStack(PaladinEarthAbility.createEarthShatterItem());
  }
}
