package net.kingscraft.zenixmc.altarsmp.weapon.shade;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.item.ItemUtility;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

class ShadeOrbRayTask extends BukkitRunnable {
  public final Player player;
  
  public final List orbs;
  
  
  
  public ShadeOrbRayTask(Player paramPlayer, List paramList) {
        this.player = paramPlayer;
        this.orbs = paramList;
    }
  
  public void run() {
    this.player.getWorld().playSound((Entity)this.player, Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 2.0F, 2.0F);
    ItemUtility.spawnFlashParticle(this.player.getLocation());
    this.player.swingMainHand();
    this.player.updateInventory();
    double d1 = AltarSMP.getInstance().getConfig().getInt("shadeSoulRange", 40);
    double d2 = 1.2D;
    Location location = this.player.getEyeLocation();
    double d3 = 0;
    for (d3 = 1.5D; d3 < d1; d3 += 1.2D) {
      Vector vector = location.getDirection().normalize();
      Location location1 = location.clone().add(vector.multiply(d3));
      ItemDisplay itemDisplay = (ItemDisplay)location1.getWorld().spawnEntity(location1, EntityType.ITEM_DISPLAY);
      itemDisplay.setItemStack(ShadeSoul.createShadeOrbItem());
      Transformation transformation = itemDisplay.getTransformation();
      transformation.getScale().set(0.5D);
      itemDisplay.setTransformation(transformation);
      itemDisplay.setRotation(0.0F, 0.0F);
      this.orbs.add(itemDisplay);
      for (Entity entity : location1.getNearbyEntities(1.2D, 0.75D, 1.2D)) {
        Integer integer = Integer.valueOf(AltarSMP.getInstance().getConfig().getInt("shadeSoulDamage", 7));
        if (entity instanceof LivingEntity) {
          LivingEntity livingEntity = (LivingEntity)entity;
          {
            if (livingEntity.equals(this.player))
              continue; 
          }{
            if (CooldownManager.isOnCooldown(livingEntity.getUniqueId(), "enough"))
              continue; 
          }
          CooldownManager.setCooldown(livingEntity.getUniqueId(), "enough", 1.0D);
          livingEntity.setNoDamageTicks(0);
          livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 0, false, false, false));
          livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 1, false, false, true));
          TrueDamage.apply(livingEntity, integer.intValue(), this.player);
        } 
      } 
    } 
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764et.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */