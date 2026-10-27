package net.kingscraft.zenixmc.altarsmp.weapon.blood;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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
  public int ticksElapsed;

  public final Player player;

  public final int durationSeconds;

  private static final Component EXIT_ACTIONBAR = Component.text()
      .append(Component.text("Press ", NamedTextColor.RED))
      .append(Component.text("[JUMP]", NamedTextColor.YELLOW))
      .append(Component.text(" to Exit.", NamedTextColor.RED))
      .build();

  public BloodTrailInvisibilityTask(Player paramPlayer, int paramInt) {
        this.player = paramPlayer;
        this.durationSeconds = paramInt;
        this.ticksElapsed = 0;
    }

  public void run() {
    if (this.player.isOnline())
      {
        if (!this.player.isDead())
          {
            if (this.ticksElapsed < this.durationSeconds * 20) {
              AttributeInstance attributeInstance = this.player.getAttribute(Attribute.STEP_HEIGHT);
              if (attributeInstance != null)
                attributeInstance.setBaseValue(1.0D); 

              Location location = this.player.getLocation().add(0.0D, 0.0D, 0.0D);
              this.player.getWorld().spawnParticle(Particle.ITEM, location, 20, 0.1D, 0.0D, 0.1D, 0.075D, new ItemStack(Material.REDSTONE_BLOCK));
              this.player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 0, false, false, false));
              this.player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 5, 3, false, false, false));
              this.player.sendActionBar(EXIT_ACTIONBAR);
              this.ticksElapsed++;
              return;
            } 
          }  
      }  

    BloodLustAbilityListener.endBloodTrailEffect(this.player);
    cancel();
  }


}
