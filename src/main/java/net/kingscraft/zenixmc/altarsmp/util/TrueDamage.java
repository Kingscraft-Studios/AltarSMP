package net.kingscraft.zenixmc.altarsmp.util;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.WorldGuardHook;

public class TrueDamage {
  private static final String TRUE_DAMAGE_ENABLED_KEY = "trueDamage";
  
  public static void apply(LivingEntity paramLivingEntity, double paramDouble, Player paramPlayer) {
    apply(paramLivingEntity, paramDouble, paramPlayer, false);
  }

  public static void apply(LivingEntity paramLivingEntity, double paramDouble, Player paramPlayer, boolean paramBoolean) {
    int i = (int)paramLivingEntity.getHealth();
    if (paramPlayer.getGameMode() == GameMode.SPECTATOR)
      return; 
    if (WorldGuardHook.isBlocked(paramLivingEntity.getLocation()) || WorldGuardHook.isBlocked(paramPlayer.getLocation()))
      return; 
    if (paramLivingEntity instanceof Player) {
      Player player = (Player)paramLivingEntity;
      if (!paramBoolean && player.isBlocking())
        return; 
      if (player.getGameMode() == GameMode.SPECTATOR || player.getGameMode() == GameMode.CREATIVE)
        return; 
      if (AltarSMP.isTrusted(paramPlayer, player))
        return; 
      if (!AltarSMP.getInstance().getConfig().getBoolean(TRUE_DAMAGE_ENABLED_KEY, true)) {
        paramLivingEntity.damage(paramDouble);
        return;
      } 
      Material material = player.getInventory().getItemInMainHand().getType();
      Material material2 = player.getInventory().getItemInOffHand().getType();
      if (material == Material.TOTEM_OF_UNDYING || material2 == Material.TOTEM_OF_UNDYING) {
        if (i <= paramDouble) {
          player.damage(200.0D);
        } else {
          damageDirect(player, paramDouble);
        } 
      } else {
        damageDirect(player, paramDouble);
      } 
    } else {
      damageDirect(paramLivingEntity, paramDouble);
    } 
  }
  
  public static void damageDirect(LivingEntity paramLivingEntity, double paramDouble) {
    double d = 0.0D;
    if (paramLivingEntity.hasPotionEffect(PotionEffectType.ABSORPTION)) {
      d = paramLivingEntity.getAbsorptionAmount();
      paramLivingEntity.setAbsorptionAmount(Math.max(d - paramDouble, 0.0D));
      paramDouble = Math.max(paramDouble - d, 0.0D);
    } 
    Sound sound = paramLivingEntity.getHurtSound();
    if (sound != null)
      paramLivingEntity.getWorld().playSound(paramLivingEntity.getLocation(), sound, 1.0F, 1.0F);
    paramLivingEntity.setHealth(Math.max(paramLivingEntity.getHealth() - paramDouble, 0.0D));
    paramLivingEntity.playHurtAnimation(0.0F);
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */