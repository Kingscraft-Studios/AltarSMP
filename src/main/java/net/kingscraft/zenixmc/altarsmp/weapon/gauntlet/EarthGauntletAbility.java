package net.kingscraft.zenixmc.altarsmp.weapon.gauntlet;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.item.ItemUtility;
import net.kingscraft.zenixmc.altarsmp.weapon.meteor.MeteorStrikeLaunchTask;
import net.kingscraft.zenixmc.altarsmp.weapon.meteor.MeteorStrikePullTask;

public class EarthGauntletAbility implements Listener {
  public static int meteorStrikeCooldown;

  public static int mudslideCooldown;

  public static String meteorStrikeCooldownKey;

  public static String mudslideCooldownKey;

  public static final HashMap<UUID, LivingEntity> meteorStrikeTargets;

  public static final int meteorUseDuration;

  public static final double meteorStrikeKnockback;

  public static final int meteorDamage;

  public static HashSet<UUID> jumpCancelledPlayers;

  public static boolean hasEarthGauntlet(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    {
      if (itemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    }{
      if (!itemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = itemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      List<Float> customModelData = itemMeta.getCustomModelDataComponent().getFloats();
      return !customModelData.isEmpty() && customModelData.getFirst() == 8;
    }
  }

  @EventHandler
  public static void onEntityDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    LivingEntity livingEntity;
    Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
    if (entity1 instanceof Player) {
      player = (Player)entity1;
    } else {
      return;
    } 
    Entity entity2 = paramEntityDamageByEntityEvent.getEntity();
    if (entity2 instanceof LivingEntity) {
      livingEntity = (LivingEntity)entity2;
    } else {
      return;
    } 
    {
      if (!hasEarthGauntlet(player))
        return; 
    }if (CooldownManager.isOnCooldown(player.getUniqueId(), "used_meteor")) {
      CooldownManager.setCooldown(player.getUniqueId(), "used_meteor", 0.0D);
      Location location = livingEntity.getLocation().add(0.0D, 1.0D, 0.0D);
      livingEntity.getWorld().spawnParticle(Particle.GUST_EMITTER_LARGE, location, 1, 0.0D, 0.0D, 0.0D, 0.0D);
      ItemUtility.spawnFlashParticle(location);
      livingEntity.getWorld().spawnParticle(Particle.FLAME, location, 60, 0.1D, 0.1D, 0.1D, 0.1D);
      livingEntity.getWorld().playSound(location, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F);
      paramEntityDamageByEntityEvent.setDamage(paramEntityDamageByEntityEvent.getDamage() + meteorDamage);
      livingEntity.setVelocity(player.getLocation().getDirection().multiply(meteorStrikeKnockback));
      BossBarManager.createBar(player, "Meteor Strike", meteorStrikeCooldown, NamedTextColor.YELLOW);
      CooldownManager.setCooldown(player.getUniqueId(), meteorStrikeCooldownKey, meteorStrikeCooldown);
    } 
  }

  public static void activateMeteorStrike(Player paramPlayer) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 10, 3, false, false, true));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BREEZE_INHALE, 1.0F, 1.0F);
    (new MudslideParticleTask(paramPlayer)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
    (new MudslideProjectileTask(paramPlayer)).runTaskLater(AltarSMP.getInstance(), 10L);
  }

  public static void makeMud(Location paramLocation) {
    Block block = paramLocation.getBlock();
    if (block.getType() == Material.MUD) {
      return;
    }
    BlockData blockData = block.getBlockData().clone();
    block.setType(Material.MUD);
    Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> block.setBlockData(blockData), 40L);
  }

  public static void applyMudslide(LivingEntity paramLivingEntity, Player paramPlayer) {
    (new MeteorStrikePullTask(paramLivingEntity, paramPlayer)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  @EventHandler
  public void onPlayerJump(PlayerJumpEvent paramPlayerJumpEvent) {
    Player player = paramPlayerJumpEvent.getPlayer();
    {
      if (!jumpCancelledPlayers.contains(player.getUniqueId()))
        return; 
    }(new MeteorStrikeLaunchTask(player)).runTaskLater(AltarSMP.getInstance(), 1L);
    paramPlayerJumpEvent.setCancelled(true);
  }

  static {
    meteorStrikeCooldown = AltarSMP.getInstance().getConfig().getInt("EarthGauntletMeteorStrike", 30);
    mudslideCooldown = AltarSMP.getInstance().getConfig().getInt("EarthGauntletMudslide", 18);
    meteorStrikeCooldownKey = "meteorStrike";
    mudslideCooldownKey = "mudSlide";
    meteorStrikeTargets = new HashMap<>();
    meteorUseDuration = AltarSMP.getInstance().getConfig().getInt("meteorUseDuration", 10);
    meteorStrikeKnockback = AltarSMP.getInstance().getConfig().getInt("meteorStrikeKnockback", 8);
    meteorDamage = AltarSMP.getInstance().getConfig().getInt("meteorDamage", 14);
    jumpCancelledPlayers = new HashSet<>();
  }

}
