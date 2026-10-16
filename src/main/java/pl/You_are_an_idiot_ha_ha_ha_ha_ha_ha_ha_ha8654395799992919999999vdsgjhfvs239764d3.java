package pl;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d3 extends BukkitRunnable {
  double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = 3.0D;
  
  final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = Main.getInstance().getConfig().getInt("paleRootsDuration", 10);
  
  int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  Location You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  final Player You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  final List You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  final int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  
  
  You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d3(Player paramPlayer, List paramList, int paramInt1, int paramInt2) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = paramPlayer;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = paramList;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = paramInt1;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = paramInt2;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = 3.0;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = 0;
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getLocation().clone().add(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getLocation().getDirection().clone().multiply(0));
    }
  
  public void run() {
    if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c >= this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b * 20) {
      for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getWorld().playSound(itemDisplay.getLocation(), Sound.BLOCK_CREAKING_HEART_BREAK, 1.0F, 1.0F);
        itemDisplay.getWorld().spawnParticle(Particle.ITEM, itemDisplay.getLocation(), 20, 0.0D, 0.0D, 0.0D, 0.1D, new ItemStack(Material.PALE_OAK_LOG));
        itemDisplay.remove();
      } 
      cancel();
      return;
    } 
    Vector vector = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getLocation().getDirection().normalize().setY(0).multiply(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
    {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.size() < this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g && this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c % 4 == 0) {
        Location location1 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.clone().add(vector);
        Location location2 = VulcanGauntletAbility.findSafeExplosionLocation(location1, 12).clone().add(0.0D, 0.0D, 0.0D);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getWorld().playSound(location2, Sound.ENTITY_CREAKING_ATTACK, 1.0F, 1.0F);
        ItemDisplay itemDisplay = (ItemDisplay)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getWorld().spawnEntity(location2, EntityType.ITEM_DISPLAY);
        itemDisplay.setRotation(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getYaw(), 0.0F);
        itemDisplay.setItemStack(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a());
        Transformation transformation = itemDisplay.getTransformation();
        transformation.getTranslation().set(0.0D, -1.5D, 0.0D);
        transformation.getScale().set(1.0F, 1.0F, 1.0F);
        transformation.getLeftRotation().rotateX((float)Math.toRadians(180.0D));
        itemDisplay.setTransformation(transformation);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.add(itemDisplay);
        itemDisplay.setInterpolationDelay(0);
        itemDisplay.setInterpolationDuration(12);
        (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d4(this, itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 3L);
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = location2;
      } 
    }for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f) {
      for (Entity entity : itemDisplay.getNearbyEntities(2.0D, 2.0D, 2.0D)) {
        if (entity instanceof LivingEntity) {
          LivingEntity livingEntity = (LivingEntity)entity;
          {
            if (CooldownManager.isOnCooldown(livingEntity.getUniqueId(), "rootsDamage"))
              continue; 
          }{
            if (Main.isTrusted(this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e, (Entity)livingEntity))
              continue; 
          }{
            if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e == livingEntity)
              continue; 
          }
            TrueDamage.apply(livingEntity, this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h, this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e);
          livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20, 0));
          CooldownManager.setCooldown(livingEntity.getUniqueId(), "rootsDamage", 1.0D);
          livingEntity.getWorld().playSound(livingEntity.getLocation(), Sound.ENCHANT_THORNS_HIT, 1.0F, 1.0F);
          livingEntity.setNoDamageTicks(0);
          Vector vector1 = livingEntity.getLocation().toVector().subtract(itemDisplay.getLocation().toVector()).normalize().multiply(0.5D);
          livingEntity.setVelocity(vector1);
        } 
      } 
    } 
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c++;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d3.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */