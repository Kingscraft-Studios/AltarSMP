package net.kingscraft.zenixmc.altarsmp.weapon.pale;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;
import net.kingscraft.zenixmc.altarsmp.weapon.vulcan.VulcanGauntletAbility;

public class PaleCannonAbility implements Listener {
  public AltarSMP plugin;

  public static int COOLDOWN;

  static {
    COOLDOWN = AltarSMP.getInstance().getConfig().getInt("palecannonCooldown", 30);
  }

  public PaleCannonAbility(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
  }

  public static boolean isPaleCannon(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    {
      if (itemStack == null)
        return false; 
    }{
      if (itemStack.getType() != Material.CROSSBOW)
        return false; 
    }{
      if (!itemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = itemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      if (!itemMeta.hasCustomModelData())
        return false; 
    }{

    }return (itemMeta.getCustomModelData() == 2);
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    Player player = paramPlayerInteractEvent.getPlayer();
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    {
      if (itemStack.getType() != Material.CROSSBOW)
        return; 
    }{
      if (!itemStack.hasItemMeta())
        return; 
    }CrossbowMeta crossbowMeta = (CrossbowMeta)itemStack.getItemMeta();
    {
      if (crossbowMeta != null) {
        {
          if (!crossbowMeta.hasCustomModelData())
            return; 
        }} else {
        return;
      } 
    }{
      if (!crossbowMeta.hasChargedProjectiles())
        return; 
    }{
      if (!isPaleCannon(player))
        return; 
    }{
      if (paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) {
        {
          if (paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            {
              if (player.hasCooldown(Material.CROSSBOW))
                return; 
            }paramPlayerInteractEvent.setCancelled(true);
            activatePaleCannon(player);
            return;
          } 
        }return;
      } 
    }{
      if (player.hasCooldown(Material.CROSSBOW))
        return; 
    }paramPlayerInteractEvent.setCancelled(true);
    activatePaleCannon(player);
  }

  public static ItemStack createPaleRootsItem() {
    ItemStack itemStack = new ItemStack(Material.PALE_OAK_LOG);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setItemModel(new NamespacedKey("altar", "item/pale_roots"));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  public static void spawnPaleRoots(Player paramPlayer) {
    ArrayList arrayList = new ArrayList();
    int i = AltarSMP.getInstance().getConfig().getInt("paleRootsCount", 12);
    int j = AltarSMP.getInstance().getConfig().getInt("paleRootsDamage", 3);
    (new PaleRootsGrowthTask(paramPlayer, arrayList, i, j)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, 1L);
  }

  public void activatePaleCannon(Player paramPlayer) {
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "palecannon"))
        return; 
    }CrossbowMeta crossbowMeta = (CrossbowMeta)paramPlayer.getInventory().getItemInMainHand().getItemMeta();
    crossbowMeta.setChargedProjectiles(null);
    paramPlayer.getInventory().getItemInMainHand().setItemMeta((ItemMeta)crossbowMeta);
    paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().normalize().multiply(-0.5D));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 1.5F);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "palecannon", COOLDOWN);
    BossBarManager.createBar(paramPlayer, "Pale Cannon", COOLDOWN, ChatColor.YELLOW, BarColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector1 = location.getDirection().normalize();
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(location, EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.RESIN_BLOCK));
    itemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f((float)Math.toRadians(90.0D), 1.0F, 0.0F, 0.0F), new Vector3f(0.75F, 0.75F, 0.75F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F)));
    double d = AltarSMP.getInstance().getConfig().getInt("palePower", 2);
    Vector vector2 = vector1.multiply(d);
    (new PaleCannonProjectileTask(this, vector2, itemDisplay, paramPlayer)).runTaskTimer((Plugin)this.plugin, 0L, 1L);
  }

  public static void detonatePaleCannon(Location paramLocation, Player paramPlayer) {
    paramLocation = VulcanGauntletAbility.findSafeExplosionLocation(paramLocation, 3);
    World world = paramLocation.getWorld();
    world.playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 1.0F);
    double d = AltarSMP.getInstance().getConfig().getDouble("paleDamage", 8.0D);
    paramLocation.getWorld().spawnParticle(Particle.ITEM, paramLocation, 200, 0.0D, 0.0D, 0.0D, 0.5D, new ItemStack(Material.RESIN_BLOCK));
    for (Entity entity : paramLocation.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
      {
        if (entity == paramPlayer)
          continue; 
      }{
        if (!AltarSMP.isTrusted(paramPlayer, entity) && entity instanceof LivingEntity) {
          LivingEntity livingEntity = (LivingEntity)entity;
          TrueDamage.apply(livingEntity, d, paramPlayer);
        } 
      }} 
    if (AltarSMP.getInstance().getConfig().getBoolean("paleParticleEffects", true)) {
      AreaEffectCloud areaEffectCloud = (AreaEffectCloud)world.spawnEntity(paramLocation, EntityType.AREA_EFFECT_CLOUD);
      areaEffectCloud.setDuration(80);
      areaEffectCloud.setRadius(5.0F);
      areaEffectCloud.setRadiusOnUse(0.0F);
      areaEffectCloud.setRadiusPerTick(0.0F);
      areaEffectCloud.setWaitTime(0);
      areaEffectCloud.setReapplicationDelay(200);
      areaEffectCloud.addCustomEffect(new PotionEffect(PotionEffectType.LUCK, 12000, 1, true, false, true), true);
      areaEffectCloud.setParticle(Particle.ENTITY_EFFECT, Color.GRAY);
    } 
  }

}
