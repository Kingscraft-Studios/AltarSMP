package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import java.util.List;
import org.bukkit.entity.Item;
import org.bukkit.scheduler.BukkitRunnable;

class BoneBladeItemCleanupTask extends BukkitRunnable {
  public final List<Item> boneItems;

  public BoneBladeItemCleanupTask(List<Item> paramList) {
        this.boneItems = paramList;
    }

  public void run() {
    this.boneItems.forEach(BoneBladeItemCleanupTask::lambda$run$0);
  }

  private static void lambda$run$0(Item paramItem) {
    if (paramItem.isValid())
      paramItem.remove(); 

  }

}
