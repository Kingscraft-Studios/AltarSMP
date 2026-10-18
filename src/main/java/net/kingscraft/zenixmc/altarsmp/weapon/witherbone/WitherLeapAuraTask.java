package net.kingscraft.zenixmc.altarsmp.weapon.witherbone;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

class WitherLeapAuraTask extends BukkitRunnable {
  public int ticksLived;
  
  public double lastY;
  
  public int boneParticleTicks;
  
  public final Player player;
  
  
  
  public WitherLeapAuraTask(Player paramPlayer) {
        this.player = paramPlayer;
        this.ticksLived = 0;
        this.lastY = this.player.getLocation().getY();
        this.boneParticleTicks = 0;
    }
  
  public void run() {
    {
      if (this.player.isOnline())
        {
          if (this.ticksLived < 60) {
            Location location1 = this.player.getLocation();
            {
              if (this.player.isOnGround())
                {
                  if (this.ticksLived > 5) {
                    cancel();
                    return;
                  } 
                }}{
              if (this.ticksLived > 10)
                {
                  if (location1.getY() <= this.lastY - 0.5D) {
                    cancel();
                    return;
                  } 
                }}this.lastY = location1.getY();
            Location location2 = location1.clone().subtract(0.0D, 0.5D, 0.0D);
            Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(20, 20, 20), 4.0F);
            Location location3 = location2.clone().add(0.0D, 0.5D, 0.0D);
            Vector vector1 = this.player.getLocation().getDirection().rotateAroundY(Math.toRadians(-90.0D)).normalize().multiply(0.4D);
            Vector vector2 = this.player.getLocation().getDirection().rotateAroundY(Math.toRadians(90.0D)).normalize().multiply(0.4D);
            location2.getWorld().spawnParticle(Particle.DUST, location3.clone().add(vector1), 1, 0.0D, 0.0D, 0.0D, 0.0D, dustOptions);
            location2.getWorld().spawnParticle(Particle.DUST, location3.clone().add(vector1).add(0.0D, -0.8D, 0.0D), 1, 0.0D, 0.0D, 0.0D, 0.0D, dustOptions);
            location2.getWorld().spawnParticle(Particle.DUST, location3.clone().add(vector2), 1, 0.0D, 0.0D, 0.0D, 0.0D, dustOptions);
            location2.getWorld().spawnParticle(Particle.DUST, location3.clone().add(vector2).add(0.0D, -0.8D, 0.0D), 1, 0.0D, 0.0D, 0.0D, 0.0D, dustOptions);
            for (Entity entity : this.player.getLocation().getNearbyEntities(1.0D, 1.0D, 1.0D)) {
              {
                if (this.player == entity)
                  continue; 
              }{
                if (!AltarSMP.isTrusted(this.player, entity) && entity instanceof LivingEntity) {
                  LivingEntity livingEntity = (LivingEntity)entity;
                  {
                    if (CooldownManager.isOnCooldown(livingEntity.getUniqueId(), "witheringWait"))
                      continue; 
                  }
                    TrueDamage.apply(livingEntity, 2.0D, this.player);
                  livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20, 4));
                  CooldownManager.setCooldown(livingEntity.getUniqueId(), "witheringWait", 1.0D);
                } 
              }} 
            {
              this.boneParticleTicks++;
              if (this.boneParticleTicks >= 2) {
                this.boneParticleTicks = 0;
                WitherBoneAbility.spawnBoneParticle(location2);
              } 
            }this.ticksLived++;
            return;
          } 
          cancel();
          return;
        }}cancel();
  }
  
  public static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fh.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */