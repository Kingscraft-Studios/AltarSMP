package net.kingscraft.zenixmc.altarsmp.weapon.echo;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.illusion.IllusionDisguiseManager;

public class EchoAbility implements Listener {
  public static String ECHO_SHRIEK_COOLDOWN_KEY;

  public static String ECHO_SONIC_COOLDOWN_KEY;

  public static boolean isEchoSword(ItemStack paramItemStack) {
    {
      if (paramItemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    }{
      if (!paramItemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = paramItemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      if (!itemMeta.hasCustomModelData())
        return false; 
    }{

    }return (itemMeta.getCustomModelData() == 13);
  }

  public static void activateSonicCharge(Player paramPlayer) {
    paramPlayer.playSound((Entity)paramPlayer, Sound.ENTITY_WARDEN_SONIC_CHARGE, 1.0F, 1.0F);
    (new EchoSonicBlastDelayTask(paramPlayer)).runTaskLater((Plugin)AltarSMP.getInstance(), 30L);
  }

  public static void launchSonicBlast(Player paramPlayer) {
    Location location1 = paramPlayer.getLocation().clone().add(paramPlayer.getLocation().getDirection()).add(0.0D, 1.2D, 0.0D);
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    int i = AltarSMP.getInstance().getConfig().getInt("echoSonicDamage", 10);
    Location location2 = paramPlayer.getEyeLocation();
    Vector vector1 = location2.getDirection().normalize();
    {
      if (!isEchoSword(itemStack)) {
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), ECHO_SONIC_COOLDOWN_KEY, 0.0D);
        BossBarManager.removeBar(paramPlayer, "Sonic Blast");
        paramPlayer.sendMessage("You must keep holding Echo");
        return;
      } 
    }paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().multiply(-1));
    paramPlayer.swingMainHand();
    paramPlayer.playSound((Entity)paramPlayer, Sound.ENTITY_WARDEN_SONIC_BOOM, 1.0F, 1.0F);
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(location2.add(vector1.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(itemStack);
    itemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f((float)Math.toRadians(90.0D), 1.0F, 0.0F, 0.0F), new Vector3f(1.5F, 1.5F, 1.5F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F)));
    double d = AltarSMP.getInstance().getConfig().getInt("echoSonicThrowStrength", 2);
    Vector vector2 = vector1.multiply(d);
    (new EchoSonicProjectileTask(vector2, itemDisplay, paramPlayer, i)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }

  public static void activateEchoShriek(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("echoShriekDuration", 10) * 20;
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_SCULK_SHRIEKER_SHRIEK, 1.0F, 1.0F);
    Location location1 = paramPlayer.getLocation().add(0.0D, 0.1D, 0.0D);
    int b1 = 30;
    double d1 = 0.1D;
    double d2 = 1000000.0D;
    Location location2 = location1.clone();
    for (int b2 = 0; b2 < b1; b2++) {
      double d3 = 6.283185307179586D * b2 / b1;
      double d4 = location2.getX() + d1 * Math.cos(d3);
      double d5 = location2.getY();
      double d6 = location2.getZ() + d1 * Math.sin(d3);
      double d7 = Math.cos(d3) * d2;
      double d8 = 0;
      double d9 = Math.sin(d3) * d2;
      location2.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, d4, d5, d6, 0, d7, d8, d9, 6.0E-7D);
      location2.getWorld().spawnParticle(Particle.SCULK_SOUL, d4, d5, d6, 0, d7, d8, d9, 6.0E-7D);
    } 
    for (Player player : paramPlayer.getLocation().getNearbyPlayers(7.0D, 7.0D, 7.0D)) {
      {
        if (player == paramPlayer)
          continue; 
      }{
        if (AltarSMP.isTrusted(paramPlayer, (Entity)player))
          continue; 
      }player.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, i, 1));
      player.addPotionEffect(new PotionEffect(PotionEffectType.DARKNESS, i, 1));
    } 
    for (Player player : paramPlayer.getLocation().getNearbyPlayers(12.0D, 12.0D, 12.0D)) {
      {
        if (player == paramPlayer)
          continue; 
      }{
        if (AltarSMP.isTrusted(paramPlayer, (Entity)player))
          continue; 
      }player.removePotionEffect(PotionEffectType.INVISIBILITY);
      IllusionDisguiseManager.revealPlayer(player);
    } 
  }

  static {
    ECHO_SHRIEK_COOLDOWN_KEY = "Echo_Shriek";
    ECHO_SONIC_COOLDOWN_KEY = "Echo_Sonic";
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aq.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */