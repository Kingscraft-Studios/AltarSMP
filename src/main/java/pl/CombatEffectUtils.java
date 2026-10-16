package pl;

import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.util.Vector;

public class CombatEffectUtils implements Listener {
  public static void playSoundAndParticleEffect(LivingEntity paramLivingEntity, Particle paramParticle, Object paramObject, Sound paramSound, float paramFloat) {
    paramLivingEntity.getWorld().playSound(paramLivingEntity.getLocation(), paramSound, 1.0F, paramFloat);
    spawnDualParticleRings(paramLivingEntity, paramParticle, paramObject, null, null, null, paramFloat, false);
    spawnDualParticleRings(paramLivingEntity, paramParticle, paramObject, null, null, null, paramFloat, true);
  }
  
  public static void spawnDualParticleRings(LivingEntity paramLivingEntity, Particle paramParticle1, Particle paramParticle2, Sound paramSound, float paramFloat) {
    spawnDualParticleRings(paramLivingEntity, paramParticle1, null, paramParticle2, null, paramSound, paramFloat);
  }
  
  public static void spawnDualParticleRings(LivingEntity paramLivingEntity, Particle paramParticle1, Object paramObject1, Particle paramParticle2, Object paramObject2, Sound paramSound, float paramFloat) {
    spawnDualParticleRings(paramLivingEntity, paramParticle1, paramObject1, paramParticle2, paramObject2, paramSound, paramFloat, ThreadLocalRandom.current().nextBoolean());
  }
  
  public static void spawnDualParticleRings(LivingEntity paramLivingEntity, Particle paramParticle1, Object paramObject1, Particle paramParticle2, Object paramObject2, Sound paramSound, float paramFloat, boolean paramBoolean) {
    paramLivingEntity.getWorld().playSound(paramLivingEntity.getLocation(), paramSound, 1.0F, paramFloat);
    double d = 1.5D;
    Location location = paramLivingEntity.getLocation().clone().add(0.0D, 1.5D, 0.0D);
    World world = paramLivingEntity.getWorld();
    Vector vector1 = paramLivingEntity.getLocation().getDirection().normalize();
    Vector vector2 = new Vector(0.0D, Math.random(), 0.0D);
    Vector vector3 = vector1.getCrossProduct(vector2).normalize();
    for (byte b = -60; b < 60; b += 4) {
      Vector vector;
      double d1 = Math.toRadians(b);
      double d2 = Math.cos(d1);
      double d3 = Math.sin(d1);
      if (paramBoolean) {
        vector = vector1.clone().multiply(d2).add(vector3.clone().multiply(d3)).subtract(vector2.clone().multiply(d3));
      } else {
        vector = vector1.clone().multiply(d2).add(vector3.clone().multiply(d3)).add(vector2.clone().multiply(d3));
      } 
      Location location1 = location.clone().add(vector.multiply(d));
      try {
        world.spawnParticle(paramParticle1, location1, 1, 0.0D, 0.0D, 0.0D, 0.0D, paramObject1);
        if (paramParticle2 != null)
          world.spawnParticle(paramParticle2, location1, 1, 0.0D, 0.0D, 0.0D, 0.0D, paramObject2); 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764v.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */