package net.kingscraft.zenixmc.altarsmp.weapon.boneblade;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;

class BoneCageProjectileTask extends BukkitRunnable {
  public int currentStep;

  public boolean cageApplied;

  public final int maxSteps;

  public final Location startLocation;

  public final Vector direction;

  public final Player shooter;

  public final int cageDuration;

  public BoneCageProjectileTask(int paramInt1, Location paramLocation, Vector paramVector, Player paramPlayer, int paramInt2) {
        this.maxSteps = paramInt1;
        this.startLocation = paramLocation;
        this.direction = paramVector;
        this.shooter = paramPlayer;
        this.cageDuration = paramInt2;
        this.currentStep = 0;
        this.cageApplied = false;
    }

  public void run() {
    if (!this.cageApplied)
      {
        if (this.currentStep < this.maxSteps) {
          Location location = this.startLocation.clone().add(this.direction.clone().multiply(this.currentStep));
          location.getWorld().spawnParticle(Particle.ITEM, location, 5, 0.2D, 0.2D, 0.2D, 0.0D, new ItemStack(Material.BONE));
          BoneBladeAbility.spawnBoneParticles(location, Material.BONE, 5, 1.0D, 10);
          for (Entity entity : location.getNearbyEntities(1.5D, 1.5D, 1.5D)) {
            if (entity instanceof LivingEntity) {
              LivingEntity livingEntity = (LivingEntity)entity;
              if (livingEntity.equals(this.shooter))
                continue; 

              if (livingEntity instanceof Player) {
                Player player = (Player)livingEntity;
                if (player.getGameMode() == GameMode.SPECTATOR)
                  continue; 

              } 
              if (!BoneBladeAbility.boneCageDisplays.containsKey(livingEntity)) {
                BoneBladeAbility.applyBoneCage(livingEntity, this.cageDuration);
                this.cageApplied = true;
                break;
              } 

            } 
          } 
          if (WorldGuardHook.isBlocked(location))
            cancel(); 

          this.currentStep++;
          return;
        } 
        cancel();
        return;
      }  

    cancel();
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c6.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */