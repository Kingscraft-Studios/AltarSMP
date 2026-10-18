package net.kingscraft.zenixmc.altarsmp.weapon.eclipse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.util.FloatingTextEffectUtils;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class EclipseAbility implements Listener {
  public AltarSMP plugin;
  
  public static boolean solarExplosion(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("EclipseExplosionCooldown", 30);
    float f = AltarSMP.getInstance().getConfig().getInt("EclipseExplosionStrength", 2);
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "SolarExplosion"))
        return false; 
    }
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "SolarExplosion", i);
    BossBarManager.createBar(paramPlayer, "Solar Explosion", i, ChatColor.YELLOW);
    double d1 = (2.0F * f);
    double d2 = (1000.0F * f);
    for (int b = 0; b < d2; b++) {
      double d3 = Math.random() * 2.0D * Math.PI;
      double d4 = Math.acos(2.0D * Math.random() - 1.0D);
      double d5 = d1 * Math.sin(d4) * Math.cos(d3);
      double d6 = d1 * Math.sin(d4) * Math.sin(d3);
      double d7 = d1 * Math.cos(d4);
      paramPlayer.getWorld().spawnParticle(Particle.FLAME, paramPlayer.getLocation().add(d5, d6 + 1.0D, d7), 1, 0.0D, 0.0D, 0.0D, 0.0D);
    } 
    paramPlayer.setInvulnerable(true);
    for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (AltarSMP.isTrusted(paramPlayer, (Entity)player))
          player.setInvulnerable(true); 
      }} 
    paramPlayer.setVelocity(new Vector(0, 0, 0));
    paramPlayer.getWorld().createExplosion(paramPlayer.getLocation().clone().add(0.0D, 1.0D, 0.0D), f, true, true);
    paramPlayer.setVelocity(new Vector(0, 0, 0));
    paramPlayer.setInvulnerable(false);
    for (Player player : Bukkit.getOnlinePlayers())
      player.setInvulnerable(false); 
    return true;
  }
  
  public static boolean solarLeap(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("EclipseLeapCooldown", 30);
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "solarLeap"))
        return false; 
    }
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "solarLeap", i);
    BossBarManager.createBar(paramPlayer, "Solar Leap", i, ChatColor.YELLOW);
    Vector vector1 = paramPlayer.getLocation().getDirection();
    vector1 = paramPlayer.getLocation().getDirection().normalize();
    double d = AltarSMP.getInstance().getConfig().getDouble("EclipseLeapStrength", 2.0D);
    Vector vector2 = vector1.clone().multiply(d);
    paramPlayer.setVelocity(vector2);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_1, 2.0F, 1.0F);
    (new SolarLeapParticleTask(paramPlayer)).runTaskTimer((Plugin)AltarSMP.getInstance(), 2L, 1L);
    return true;
  }
  
  public static boolean moonlitStars(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("EclipseStarsCooldown", 30);
    int j = AltarSMP.getInstance().getConfig().getInt("EclipseStarsRange", 50);
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "stars"))
        return false; 
    }paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_WARDEN_SONIC_BOOM, 1.0F, 2.0F);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "stars", i);
    BossBarManager.createBar(paramPlayer, "Moonlit Stars", i, ChatColor.YELLOW);
    double d1 = 0.5D;
    Location location = paramPlayer.getEyeLocation();
    Vector vector = location.getDirection().normalize();
    double d2 = 0;
    for (d2 = 1.5D; d2 < j; d2 += d1) {
      Location location1 = location.clone().add(vector.clone().multiply(d2));
      location1.getWorld().spawnParticle(Particle.DUST, location1, 1, 0.0D, 0.0D, 0.0D, 0.0D, new Particle.DustOptions(Color.YELLOW, 1.5F));
      FloatingTextEffectUtils.spawnAnimatedTextEffect(location1, 1, Color.YELLOW, Color.YELLOW, 2.0D, 1, 20, 2, true, "⭐", 10, 20);
      for (Entity entity : location1.getNearbyEntities(d1, 0.75D, d1)) {
        if (entity instanceof LivingEntity) {
          LivingEntity livingEntity = (LivingEntity)entity;
          {
            if (livingEntity.equals(paramPlayer))
              continue; 
          }double d = AltarSMP.getInstance().getConfig().getDouble("eclipseMoonlitStarsDamage", 6.0D);
          livingEntity.setNoDamageTicks(0);
          TrueDamage.apply(livingEntity, d, paramPlayer);
          return true;
        } 
      } 
    } 
    return true;
  }
  
  public static boolean moonlitShadows(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("EclipseTrueInvisDuration", 4);
    int j = AltarSMP.getInstance().getConfig().getInt("EclipseTrueInvisCooldown", 30);
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "trueInvisEclipse"))
        return false; 
    }
    BossBarManager.createBar(paramPlayer, "Moonlit Shadows", j, ChatColor.YELLOW);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "trueInvisEclipse", j);
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, i * 20, 1, true, false, false));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.5F);
    paramPlayer.getWorld().spawnParticle(Particle.SQUID_INK, paramPlayer.getLocation(), 20, 0.0D, 0.0D, 0.0D, 0.0D);
    for (Player player : Bukkit.getOnlinePlayers())
      player.hidePlayer((Plugin)AltarSMP.getInstance(), paramPlayer); 
    (new MoonlitShadowsInvisibilityTask(i, paramPlayer)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
    return true;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ar.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */