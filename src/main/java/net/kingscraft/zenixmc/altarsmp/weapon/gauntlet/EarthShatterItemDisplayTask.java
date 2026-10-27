package net.kingscraft.zenixmc.altarsmp.weapon.gauntlet;

import org.bukkit.entity.ItemDisplay;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.weapon.paladin.PaladinEarthAbility;

public class EarthShatterItemDisplayTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public EarthShatterItemDisplayTask(ItemDisplay paramItemDisplay) {
        this.itemDisplay = paramItemDisplay;
    }

  public void run() {
    this.itemDisplay.setItemStack(PaladinEarthAbility.createEarthShatterItem());
  }
}
