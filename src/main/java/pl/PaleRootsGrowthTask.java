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

class PaleRootsGrowthTask extends BukkitRunnable {
  double ROOT_SPACING;
  
  final int durationSeconds = Main.getInstance().getConfig().getInt("paleRootsDuration", 10);
  
  int ticks;
  
  Location lastRootLocation;
  
  final Player player;
  
  final List rootDisplays;
  
  final int maxRoots;
  
  final int rootDamage;
  
  
  
  PaleRootsGrowthTask(Player paramPlayer, List paramList, int paramInt1, int paramInt2) {
        this.player = paramPlayer;
        this.rootDisplays = paramList;
        this.maxRoots = paramInt1;
        this.rootDamage = paramInt2;
        this.ROOT_SPACING = 3.0;
        this.ticks = 0;
        this.lastRootLocation = this.player.getLocation().clone().add(this.player.getLocation().getDirection().clone().multiply(0));
    }
  
  public void run() {
    if (this.ticks >= this.durationSeconds * 20) {
      for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.rootDisplays) {
        this.player.getWorld().playSound(itemDisplay.getLocation(), Sound.BLOCK_CREAKING_HEART_BREAK, 1.0F, 1.0F);
        itemDisplay.getWorld().spawnParticle(Particle.ITEM, itemDisplay.getLocation(), 20, 0.0D, 0.0D, 0.0D, 0.1D, new ItemStack(Material.PALE_OAK_LOG));
        itemDisplay.remove();
      } 
      cancel();
      return;
    } 
    Vector vector = this.player.getLocation().getDirection().normalize().setY(0).multiply(this.ROOT_SPACING);
    {
      if (this.rootDisplays.size() < this.maxRoots && this.ticks % 4 == 0) {
        Location location1 = this.lastRootLocation.clone().add(vector);
        Location location2 = VulcanGauntletAbility.findSafeExplosionLocation(location1, 12).clone().add(0.0D, 0.0D, 0.0D);
        this.player.getWorld().playSound(location2, Sound.ENTITY_CREAKING_ATTACK, 1.0F, 1.0F);
        ItemDisplay itemDisplay = (ItemDisplay)this.player.getWorld().spawnEntity(location2, EntityType.ITEM_DISPLAY);
        itemDisplay.setRotation(this.player.getYaw(), 0.0F);
        itemDisplay.setItemStack(PaleCannonAbility.createPaleRootsItem());
        Transformation transformation = itemDisplay.getTransformation();
        transformation.getTranslation().set(0.0D, -1.5D, 0.0D);
        transformation.getScale().set(1.0F, 1.0F, 1.0F);
        transformation.getLeftRotation().rotateX((float)Math.toRadians(180.0D));
        itemDisplay.setTransformation(transformation);
        this.rootDisplays.add(itemDisplay);
        itemDisplay.setInterpolationDelay(0);
        itemDisplay.setInterpolationDuration(12);
        (new PaleRootRiseTask(this, itemDisplay)).runTaskLater((Plugin)Main.getInstance(), 3L);
        this.lastRootLocation = location2;
      } 
    }for (ItemDisplay itemDisplay : (Iterable<ItemDisplay>)(Iterable<?>) this.rootDisplays) {
      for (Entity entity : itemDisplay.getNearbyEntities(2.0D, 2.0D, 2.0D)) {
        if (entity instanceof LivingEntity) {
          LivingEntity livingEntity = (LivingEntity)entity;
          {
            if (CooldownManager.isOnCooldown(livingEntity.getUniqueId(), "rootsDamage"))
              continue; 
          }{
            if (Main.isTrusted(this.player, (Entity)livingEntity))
              continue; 
          }{
            if (this.player == livingEntity)
              continue; 
          }
            TrueDamage.apply(livingEntity, this.rootDamage, this.player);
          livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 20, 0));
          CooldownManager.setCooldown(livingEntity.getUniqueId(), "rootsDamage", 1.0D);
          livingEntity.getWorld().playSound(livingEntity.getLocation(), Sound.ENCHANT_THORNS_HIT, 1.0F, 1.0F);
          livingEntity.setNoDamageTicks(0);
          Vector vector1 = livingEntity.getLocation().toVector().subtract(itemDisplay.getLocation().toVector()).normalize().multiply(0.5D);
          livingEntity.setVelocity(vector1);
        } 
      } 
    } 
    this.ticks++;
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d3.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */