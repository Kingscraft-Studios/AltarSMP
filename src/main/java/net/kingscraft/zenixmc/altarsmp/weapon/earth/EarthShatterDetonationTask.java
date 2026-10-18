package net.kingscraft.zenixmc.altarsmp.weapon.earth;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.ability.paladin.PaladinEarthAbility;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;

public class EarthShatterDetonationTask extends BukkitRunnable {
  public final ItemDisplay itemDisplay;

  public final Player player;

  public final Location impactLocation;

  public final int radius;

  public final int height;

  public final double damage;

  public EarthShatterDetonationTask(ItemDisplay paramItemDisplay, Player paramPlayer, Location paramLocation, int paramInt1, int paramInt2, double paramDouble) {
        this.itemDisplay = paramItemDisplay;
        this.player = paramPlayer;
        this.impactLocation = paramLocation;
        this.radius = paramInt1;
        this.height = paramInt2;
        this.damage = paramDouble;
    }

  public void run() {
    this.itemDisplay.getWorld().playSound(this.itemDisplay.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 2.0F);
    this.player.getWorld().playSound(this.itemDisplay.getLocation(), Sound.ITEM_TOTEM_USE, 0.5F, 0.5F);
    PaladinEarthAbility.createRisingBlocks(this.impactLocation, this.radius);
    this.itemDisplay.getWorld().spawnParticle(Particle.DUST, this.itemDisplay.getLocation().subtract(0.0D, (this.height / 2), 0.0D), 200 * this.radius, 0.5D * this.radius, 0.0D, 0.5D * this.radius, new Particle.DustOptions(Color.fromRGB(165, 165, 100), 1.0F));
    this.itemDisplay.getWorld().spawnParticle(Particle.FIREWORK, this.itemDisplay.getLocation().subtract(0.0D, (this.height / 2), 0.0D), 400, 0.0D, 0.0D, 0.0D, 0.5D);
    for (Entity entity : this.itemDisplay.getNearbyEntities(this.radius, this.radius, this.radius)) {
      if (entity instanceof LivingEntity) {
        LivingEntity livingEntity = (LivingEntity)entity;
        if (entity == this.player)
          continue; 

        TrueDamage.apply(livingEntity, this.damage, this.player);
        livingEntity.setVelocity(new Vector(0, 1, 0));
      } 
    } 
    (new EarthShatterDisplayShrinkTask(this)).runTaskLater((Plugin)AltarSMP.getInstance(), 20L);
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764eg.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */