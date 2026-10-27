package net.kingscraft.zenixmc.altarsmp.altarS2.core;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Nautilus;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.altarS2.AltarS2;
import net.kingscraft.zenixmc.altarsmp.item.CustomItem;

public class AltarS2PassiveTask extends BukkitRunnable {

  @Override
  public void run() {
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (!player.isValid()) {
        continue;
      }
      CustomItem weapon = CustomItem.fromItem(player.getInventory().getItemInMainHand());
      if (weapon == CustomItem.TIDEBREAKER) {
        applyTidebreakerPassives(player);
      } else if (weapon == CustomItem.ANCIENTBLADE) {
        applyAncientBladePassives(player);
      }
    }
  }

  private void applyTidebreakerPassives(Player player) {
    player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 60, 0, true, false, false));
    for (Entity entity : player.getNearbyEntities(10.0D, 10.0D, 10.0D)) {
      if (entity instanceof org.bukkit.entity.LivingEntity living && entity instanceof Nautilus) {
        living.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 60, 2, true, false, true));
        living.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, 4, true, false, true));
      }
    }
  }

  private void applyAncientBladePassives(Player player) {
    if (AltarS2.killLevel(player) >= 2) {
      int amplifier = AltarSMP.getInstance().getConfig().getInt("ancientblade.speed_passive_amplifier", 0);
      player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, amplifier, true, false, true));
    }
    if (AltarS2.killLevel(player) >= 4) {
      int amplifier = AltarSMP.getInstance().getConfig().getInt("ancientblade.strength_passive_amplifier", 1);
      player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 60, amplifier, true, false, true));
    }
    Block standingOn = player.getLocation().clone().subtract(0.0D, 0.1D, 0.0D).getBlock();
    if (standingOn.getType().name().startsWith("SCULK")) {
      int amplifier = AltarSMP.getInstance().getConfig().getInt("ancientblade.speed_passive_standonsculk_amplifier", 1);
      player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 60, amplifier, true, false, true));
    }
  }
}
