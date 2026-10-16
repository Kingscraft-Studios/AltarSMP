package pl;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

class BloodTrailInvisibilityTask extends BukkitRunnable {
  int ticksElapsed;
  
  final Player player;
  
  final int durationSeconds;
  
  private static final String EXIT_ACTIONBAR = "§cPress §e[JUMP] §cto Exit.";
  
  BloodTrailInvisibilityTask(Player paramPlayer, int paramInt) {
        this.player = paramPlayer;
        this.durationSeconds = paramInt;
        this.ticksElapsed = 0;
    }
  
  public void run() {
    try {
      if (this.player.isOnline())
        try {
          if (!this.player.isDead())
            try {
              if (this.ticksElapsed < this.durationSeconds * 20) {
                AttributeInstance attributeInstance = this.player.getAttribute(Attribute.STEP_HEIGHT);
                try {
                  if (attributeInstance != null)
                    attributeInstance.setBaseValue(1.0D); 
                } catch (MatchException matchException) {
                  throw a(null);
                } 
                Location location = this.player.getLocation().add(0.0D, 0.0D, 0.0D);
                this.player.getWorld().spawnParticle(Particle.ITEM, location, 20, 0.1D, 0.0D, 0.1D, 0.075D, new ItemStack(Material.REDSTONE_BLOCK));
                this.player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 0, false, false, false));
                this.player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 3, false, false, false));
                this.player.sendActionBar(EXIT_ACTIONBAR);
                this.ticksElapsed++;
                return;
              } 
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    BloodLustAbilityListener.endBloodTrailEffect(this.player);
    cancel();
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
}

/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cy.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */