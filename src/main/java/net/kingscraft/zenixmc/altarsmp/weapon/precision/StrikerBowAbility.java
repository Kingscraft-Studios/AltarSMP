package net.kingscraft.zenixmc.altarsmp.weapon.precision;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.core.worldguard.WorldGuardHook;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.util.TrueDamage;
import net.kingscraft.zenixmc.altarsmp.weapon.vulcan.VulcanGauntletAbility;

public class StrikerBowAbility implements Listener {
  public static HashSet<UUID> activeOrbitalShotPlayers;

  static {
    activeOrbitalShotPlayers = new HashSet<>();
  }

  public static ItemStack createStrikerProjectileItem() {
    ItemStack itemStack = new ItemStack(Material.RED_CONCRETE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    CustomModelDataComponent customModelData = itemMeta.getCustomModelDataComponent();
    customModelData.setFloats(List.of(1.0F));
    itemMeta.setCustomModelDataComponent(customModelData);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  @EventHandler
  public void onStrikerBowProjectileHit(ProjectileHitEvent paramProjectileHitEvent) {
    Player player;
    AbstractArrow abstractArrow;
    ProjectileSource projectileSource = paramProjectileHitEvent.getEntity().getShooter();
    if (projectileSource instanceof Player) {
      player = (Player)projectileSource;
    } else {
      return;
    } 
    Projectile projectile = paramProjectileHitEvent.getEntity();
    if (projectile instanceof AbstractArrow) {
      abstractArrow = (AbstractArrow)projectile;
    } else {
      return;
    } 
    ItemStack itemStack = abstractArrow.getWeapon();
    {
      if (!AltarSMP.areSimilar(itemStack, CustomItemRegistry.getStrikerBow()))
        return; 
    }{
      if (activeOrbitalShotPlayers.contains(player.getUniqueId())) {
        activateOrbitalShot(player, paramProjectileHitEvent.getEntity().getLocation());
      } else {
        activateStabShot(player, paramProjectileHitEvent.getEntity().getLocation());
      } 
    }}

  public static void activateStabShot(Player paramPlayer, Location paramLocation) {
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "stabShotCooldown"))
        return;
    }{
      if (WorldGuardHook.isBlocked(paramLocation))
        return;
    }paramLocation.setRotation(0.0F, 0.0F);
    int i = AltarSMP.getInstance().getConfig().getInt("stabShotRadius", 5);
    int j = AltarSMP.getInstance().getConfig().getInt("stabShotRadiusY", 5);
    World world = paramLocation.getWorld();
    int k = AltarSMP.getInstance().getConfig().getInt("stabShotCooldown", 60);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "stabShotCooldown", k);
    BossBarManager.createBar(paramPlayer, "Stab Shot", k, NamedTextColor.YELLOW);
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(paramLocation, EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(createStrikerProjectileItem());
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(0.0F, j, 0.0F);
    itemDisplay.setTransformation(transformation);
    (new StabShotChargeTask(paramLocation, paramPlayer, i, itemDisplay, world, j)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  public static void activateOrbitalShot(Player paramPlayer, Location paramLocation) {
    {
      if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "orbitalShotCooldown"))
        return;
    }paramLocation.setRotation(0.0F, 0.0F);
    World world = paramPlayer.getWorld();
    Random random = new Random();
    int i = AltarSMP.getInstance().getConfig().getInt("orbitalShotRadius", 20);
    int j = AltarSMP.getInstance().getConfig().getInt("orbitalShotStrikes", 40);
    int k = AltarSMP.getInstance().getConfig().getInt("orbitalShotExplosionPower", 2);
    int m = AltarSMP.getInstance().getConfig().getInt("orbitalShotCooldown", 120);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "orbitalShotCooldown", m);
    BossBarManager.createBar(paramPlayer, "Orbital Shot", m, NamedTextColor.YELLOW);
    for (int b = 0; b < j; b++) {
      double d1 = random.nextDouble() * Math.PI * 2.0D;
      double d2 = random.nextDouble() * i;
      double d3 = Math.cos(d1) * d2;
      double d4 = Math.sin(d1) * d2;
      Location location1 = paramLocation.clone().add(d3, 0.0D, d4);
      int n = (int) VulcanGauntletAbility.findSafeExplosionLocation(location1, 40).getY();
      Location location2 = new Location(world, location1.getX() + 0.5D, (n + 20), location1.getZ() + 0.5D);
      (new OrbitalStrikeProjectileTask(location2, n, world, paramPlayer, k)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
    }
  }

  public static void detonateStabShot(Location paramLocation, Player paramPlayer, int paramInt, ItemDisplay paramItemDisplay) {
    Location location;
    double d = AltarSMP.getInstance().getConfig().getDouble("stabShotDamage", 8.0D);
    int i = AltarSMP.getInstance().getConfig().getInt("stabShotRadiusY", 100);
    float f = (float)AltarSMP.getInstance().getConfig().getDouble("stabShotExplosionPower", 3.5D);
    spawnStabShotDebris(paramLocation);
    paramLocation.getWorld().playSound(paramLocation, Sound.BLOCK_ANVIL_LAND, 0.5F, 2.0F);
    paramLocation.getWorld().playSound(paramLocation, Sound.ITEM_TOTEM_USE, 1.0F, 2.0F);
    createStabShotShockwave(paramLocation);
    paramItemDisplay.setItemStack(new ItemStack(Material.WHITE_CONCRETE));
    paramItemDisplay.setInterpolationDelay(0);
    paramItemDisplay.setInterpolationDuration(5);
    Transformation transformation = paramItemDisplay.getTransformation();
    transformation.getScale().set(transformation.getScale().x() + 1.0F, i, transformation.getScale().x() + 1.0F);
    paramItemDisplay.setTransformation(transformation);
    (new StabShotPillarShrinkTask(paramItemDisplay, i)).runTaskLater(AltarSMP.getInstance(), 5L);
    (new StabShotPillarRemovalTask(paramItemDisplay)).runTaskLater(AltarSMP.getInstance(), 15L);
    HashSet<Player> hashSet = new HashSet<>();
    for (Player player : paramLocation.getNearbyPlayers(paramInt, i, paramInt)) {
      {
        player.setInvulnerable(true);
        hashSet.add(player);
        if (paramPlayer == player)
          continue; 
      }{
        if (AltarSMP.isTrusted(paramPlayer, player))
          continue; 
      }
        TrueDamage.apply(player, d, paramPlayer);
    } 
    for (int j = -i; j <= i; j++) {
      location = paramLocation.clone().add(0.0D, j, 0.0D);
      Material material = location.getBlock().getType();
      {
        if (material.getBlastResistance() < 600.0F)
          location.getBlock().setType(Material.AIR); 
      }location.createExplosion(f);
    } 
    for (Player player : hashSet) {
      player.setInvulnerable(false);
      if (paramPlayer == player || AltarSMP.isTrusted(paramPlayer, player))
        player.setVelocity(new Vector(0, 0, 0));
    } 
    hashSet.clear();
  }

  public static void createStabShotShockwave(Location paramLocation) {
    int c = 360;
    double d1 = 0;
    double d2 = 1500000.0D;
    Location location = paramLocation.clone();
    for (int b = 0; b < c; b += 4) {
      double d3 = 6.283185307179586D * b / c;
      double d4 = location.getX() + d1 * Math.cos(d3);
      double d5 = location.getY();
      double d6 = location.getZ() + d1 * Math.sin(d3);
      double d7 = Math.cos(d3) * d2;
      double d8 = 0;
      double d9 = Math.sin(d3) * d2;
      location.getWorld().spawnParticle(Particle.CLOUD, d4, d5, d6, 0, d7, d8, d9, 6.0E-7D);
    } 
  }

  public static void spawnStabShotDebris(Location paramLocation) {
    HashSet<ItemDisplay> hashSet = new HashSet<>();
    HashMap<ItemDisplay, double[]> hashMap = new HashMap<>();
    Material material1 = paramLocation.clone().subtract(0.0D, 1.0D, 0.0D).getBlock().getType();
    Material material2 = paramLocation.clone().subtract(0.0D, 10.0D, 0.0D).getBlock().getType();
    {
      if (material1 == null || !material1.isItem())
        material1 = Material.GRASS_BLOCK; 
    }{
      if (material2 == null || !material2.isItem())
        material2 = Material.DEEPSLATE; 
    }int b = 0;
    while (true) {
      {
        if (b < 50) {
          {

          }Material material = (b % 2 == 0) ? material1 : material2;
          if (!material.isItem())
            material = Material.STONE; 
          Location location = paramLocation.clone().add(Math.random() - 0.5D, Math.random() * 3.0D, Math.random() - 0.5D);
          ItemDisplay itemDisplay = (ItemDisplay)paramLocation.getWorld().spawnEntity(location, EntityType.ITEM_DISPLAY);
          itemDisplay.setItemStack(new ItemStack(material));
          Transformation transformation = itemDisplay.getTransformation();
          itemDisplay.setTransformation(new Transformation(transformation.getTranslation(), transformation.getLeftRotation(), transformation.getScale(), transformation.getRightRotation()));
          double[] arrayOfDouble = { (Math.random() - 0.5D) * 0.8D, Math.random() * 0.6D + 0.4D, (Math.random() - 0.5D) * 0.8D };
          hashSet.add(itemDisplay);
          hashMap.put(itemDisplay, arrayOfDouble);
          b++;
          continue;
        } 
      }(new StabShotDebrisAnimationTask(hashSet, hashMap)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
      return;
    } 
  }

}
