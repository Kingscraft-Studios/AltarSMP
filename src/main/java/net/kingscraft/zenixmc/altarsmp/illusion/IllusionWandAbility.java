package net.kingscraft.zenixmc.altarsmp.illusion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.core.MobAbilityTypeSwitchMappings;
import net.kingscraft.zenixmc.altarsmp.task.CapturedMobDeathTask;
import net.kingscraft.zenixmc.altarsmp.task.InventoryUpdateTask;

public class IllusionWandAbility implements Listener {
  public AltarSMP plugin;
  
  public static NamespacedKey STORED_MOB_KEY;
  
  public NamespacedKey storedPlayerNameKey;
  
  public static Map<UUID, UUID> disguisedPlayers;
  
  
  
  public IllusionWandAbility(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    STORED_MOB_KEY = new NamespacedKey((Plugin)paramAltarSMP, "stored_mob");
    this.storedPlayerNameKey = new NamespacedKey((Plugin)paramAltarSMP, "stored_player_name");
  }
  
  public static boolean isIllusionWand(ItemStack paramItemStack) {
    {
      if (paramItemStack.getType() != Material.NETHERITE_SWORD)
        return false; 
    }{
      if (!paramItemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = paramItemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      if (!itemMeta.hasCustomModelData())
        return false; 
    }{
    
    }return (itemMeta.getCustomModelData() == 2);
  }
  
  @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
  public void onPlayerDeath(PlayerDeathEvent paramPlayerDeathEvent) {
    Player player = paramPlayerDeathEvent.getEntity();
    {
      if (IllusionDisguiseManager.isDisguised(player)) {
        paramPlayerDeathEvent.setCancelled(true);
        IllusionDisguiseManager.revealPlayer(player);
        (new CapturedMobDeathTask(this, player)).runTaskLater((Plugin)AltarSMP.getInstance(), 2L);
      } 
    }}
  
  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onEntityDeath(EntityDeathEvent paramEntityDeathEvent) {
    LivingEntity livingEntity = paramEntityDeathEvent.getEntity();
    Player player = paramEntityDeathEvent.getEntity().getKiller();
    {
      if (player == null)
        return; 
    }ItemStack itemStack = player.getInventory().getItemInMainHand();
    {
      if (!isIllusionWand(itemStack))
        return; 
    }if (livingEntity instanceof Player) {
      Player player1 = (Player)livingEntity;
      ItemMeta itemMeta = itemStack.getItemMeta();
      {
        if (itemMeta == null)
          return; 
      }PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
      persistentDataContainer.set(this.storedPlayerNameKey, PersistentDataType.STRING, player1.getName());
      persistentDataContainer.remove(STORED_MOB_KEY);
      itemStack.setItemMeta(itemMeta);
      String str1 = player1.getName();
      String str2 = ChatColor.UNDERLINE.toString();
      String str3 = String.valueOf(ChatColor.RED);
      player.sendMessage(String.valueOf(ChatColor.DARK_RED) + "» You captured " + str3 + str2 + str1);
      player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.5F);
    } else {
      storeCapturedMob(player, itemStack, livingEntity.getType());
    } 
  }
  
  public static void storeCapturedMob(Player paramPlayer, ItemStack paramItemStack, EntityType paramEntityType) {
    ItemMeta itemMeta = paramItemStack.getItemMeta();
    {
      if (itemMeta == null)
        return; 
    }PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
    {
      if (paramEntityType == EntityType.ENDER_DRAGON)
        return; 
    }persistentDataContainer.set(STORED_MOB_KEY, PersistentDataType.STRING, paramEntityType.name());
    paramItemStack.setItemMeta(itemMeta);
    String str1 = paramEntityType.name();
    String str2 = ChatColor.UNDERLINE.toString();
    String str3 = String.valueOf(ChatColor.RED);
    paramPlayer.sendMessage(String.valueOf(ChatColor.DARK_RED) + "» You captured a " + str3 + str2 + str1);
    paramPlayer.playSound((Entity)paramPlayer, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.2F);
  }
  
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    Player player = paramPlayerInteractEvent.getPlayer();
    ItemStack itemStack = paramPlayerInteractEvent.getItem();
    if (itemStack == null) {
      return;
    }
    if (!isIllusionWand(itemStack)) {
      return;
    }
    if ((paramPlayerInteractEvent.getAction() == Action.LEFT_CLICK_AIR || paramPlayerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) && player.isSneaking()) {
      boolean b = IllusionDisguiseManager.isDisguised(player);
      if (b) {
        IllusionDisguiseManager.revealPlayer(player);
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.8F);
      }
    } else if (paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
      if (IllusionDisguiseManager.isDisguised(player)) {
        return;
      }
      (new IllusionWandChargeTask(this, player)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
    }
  }
  
  @EventHandler
  public void onPlayerItemConsume(PlayerItemConsumeEvent paramPlayerItemConsumeEvent) {
    Player player = paramPlayerItemConsumeEvent.getPlayer();
    ItemMeta itemMeta = paramPlayerItemConsumeEvent.getItem().getItemMeta();
    PersistentDataContainer persistentDataContainer = itemMeta.getPersistentDataContainer();
    {
      if (isIllusionWand(paramPlayerItemConsumeEvent.getItem())) {
        {
          paramPlayerItemConsumeEvent.setCancelled(true);
          (new InventoryUpdateTask(this, player)).runTaskLater((Plugin)AltarSMP.getInstance(), 1L);
          if (IllusionDisguiseManager.isDisguised(player)) {
            player.sendMessage("§cYou are already disguised");
            return;
          } 
        }boolean bool = AltarSMP.getInstance().getConfig().getBoolean("IllusionWandRandomMob", false);
        if (bool) {
          ArrayList<EntityType> arrayList = new ArrayList();
          for (String str : AltarSMP.getInstance().getConfig().getStringList("randomMobs")) {
            try {
              arrayList.add(EntityType.valueOf(str.toUpperCase()));
            } catch (IllegalArgumentException illegalArgumentException) {
              AltarSMP.getInstance().getLogger().warning("Invalid EntityType in config: " + str);
            } 
          } 
          int i = ThreadLocalRandom.current().nextInt(0, arrayList.size());
          EntityType entityType = arrayList.get(i);
          IllusionDisguiseManager.disguisePlayer(player, entityType, (Player)null);
        } else {
          restoreCapturedMob(player, persistentDataContainer);
        } 
      } 
    }}
  
  public void restoreCapturedMob(Player paramPlayer, PersistentDataContainer paramPersistentDataContainer) {
    if (paramPersistentDataContainer.has(this.storedPlayerNameKey, PersistentDataType.STRING)) {
      String str = (String)paramPersistentDataContainer.get(this.storedPlayerNameKey, PersistentDataType.STRING);
      {
        if (str == null)
          return; 
      }Player player = Bukkit.getPlayer(str);
      {
        if (player == null)
          return; 
      }
      IllusionDisguiseManager.disguisePlayer(paramPlayer, EntityType.PLAYER, player);
    } else if (paramPersistentDataContainer.has(STORED_MOB_KEY, PersistentDataType.STRING)) {
      String str = (String)paramPersistentDataContainer.get(STORED_MOB_KEY, PersistentDataType.STRING);
      EntityType entityType = EntityType.valueOf(str);
      IllusionDisguiseManager.disguisePlayer(paramPlayer, entityType, (Player)null);
    } 
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.getPersistentDataContainer().remove(this.storedPlayerNameKey);
    itemMeta.getPersistentDataContainer().remove(STORED_MOB_KEY);
    itemStack.setItemMeta(itemMeta);
  }
  
  public static void startAbilityCooldown(Player paramPlayer) {
    int i = AltarSMP.getInstance().getConfig().getInt("mobAbilityCooldown", 30);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "mobAbility", i);
    BossBarManager.createBar(paramPlayer,String.valueOf(ChatColor.RED) + "Illusion Ability", i, ChatColor.YELLOW);
  }
  
  @EventHandler
  public void onEntityDamage(EntityDamageEvent paramEntityDamageEvent) {
    Player player;
    Entity entity = paramEntityDamageEvent.getEntity();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    {
      if (!disguisedPlayers.containsKey(player.getUniqueId()))
        return; 
    }{
      if (paramEntityDamageEvent.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION)
        paramEntityDamageEvent.setCancelled(true); 
    }}
  
  public static void useMobAbility(Player paramPlayer, EntityType paramEntityType) {
    if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "mobAbility")) {
      return;
    }
    if (!IllusionDisguiseManager.isDisguised(paramPlayer)) {
      return;
    }
    if (paramEntityType == null) {
      return;
    }
    boolean b = true;
    switch (MobAbilityTypeSwitchMappings.ENTITY_TYPE_MAPPING[paramEntityType.ordinal()]) {
      case 1: {
        paramPlayer.setInvulnerable(true);
        paramPlayer.getWorld().createExplosion(paramPlayer.getLocation(), (float)AltarSMP.getInstance().getConfig().getDouble("illusionCreeperExplosionStrength", 3.0D), false, false);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_CREEPER_PRIMED, 1.0F, 1.0F);
        paramPlayer.setInvulnerable(false);
        break;
      }
      case 2: {
        Location location = paramPlayer.getTargetBlock(null, 30).getLocation();
        paramPlayer.teleport(location.add(0.0D, 1.0D, 0.0D));
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
        break;
      }
      case 3: {
        Fireball fireball = (Fireball)paramPlayer.launchProjectile(Fireball.class);
        fireball.setVelocity(paramPlayer.getLocation().getDirection().multiply(AltarSMP.getInstance().getConfig().getDouble("IllusionBlazeFireballStrength", 2.0D)));
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1.0F, 1.0F);
        break;
      }
      case 4: {
        for (int i = -1; i <= 1; i++) {
          WitherSkull witherSkull = (WitherSkull)paramPlayer.launchProjectile(WitherSkull.class);
          witherSkull.setYield(2.0F);
          witherSkull.setVelocity(paramPlayer.getLocation().getDirection().rotateAroundY(Math.toRadians(i * 15)).multiply(2));
        }
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_WITHER_SHOOT, 1.0F, 1.0F);
        break;
      }
      case 5: {
        Location location2 = paramPlayer.getEyeLocation();
        Vector vector = location2.getDirection();
        Location location3 = null;
        double d = 0.0D;
        while (d <= 15.0D) {
          Location location4 = location2.clone().add(vector.clone().multiply(d));
          if (location4.getBlock().getType().isSolid()) {
            location3 = location4.subtract(vector.clone().multiply(0.5D));
            break;
          }
          d += 0.5D;
        }
        if (location3 == null) {
          location3 = location2.clone().add(vector.clone().multiply(15));
        }
        Location location5 = location3;
        double d2 = location2.distance(location5);
        paramPlayer.getWorld().playSound(location2, Sound.ENTITY_WARDEN_SONIC_CHARGE, 3.0F, 1.0F);
        Bukkit.getScheduler().runTaskLater(AltarSMP.getInstance(), () -> createSonicBoomEffect(paramPlayer, location2, d2, vector), 20L);
        break;
      }
      case 6:
      case 7: {
        for (Entity entity : paramPlayer.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
          if (entity instanceof LivingEntity && entity != paramPlayer) {
            ((LivingEntity)entity).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
          }
        }
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_SPIDER_HURT, 1.0F, 0.8F);
        break;
      }
      case 8: {
        Fireball fireball2 = (Fireball)paramPlayer.launchProjectile(Fireball.class);
        fireball2.setYield(3.0F);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_GHAST_SHOOT, 1.0F, 1.0F);
        break;
      }
      default: {
        b = false;
      }
    }
    if (b) {
      startAbilityCooldown(paramPlayer);
    }
  }
  
  public static void createSonicBoomEffect(Player paramPlayer, Location paramLocation, double paramDouble, Vector paramVector) {
    paramPlayer.getWorld().playSound(paramLocation, Sound.ENTITY_WARDEN_SONIC_BOOM, 3.0F, 1.0F);
    double d1 = 0;
    for (d1 = 0.0D; d1 <= paramDouble; d1 += 0.3D) {
      Location location = paramLocation.clone().add(paramVector.clone().multiply(d1));
      paramPlayer.getWorld().spawnParticle(Particle.SONIC_BOOM, location, 1, 0.0D, 0.0D, 0.0D, 0.0D);
    } 
    HashSet<UUID> hashSet = new HashSet();
    double d2 = 0;
    for (d2 = 0.0D; d2 <= paramDouble; d2 += 0.5D) {
      Location location = paramLocation.clone().add(paramVector.clone().multiply(d2));
      for (Entity entity : location.getWorld().getNearbyEntities(location, 1.0D, 1.0D, 1.0D)) {
        {
          if (entity instanceof LivingEntity)
            {
              if (entity != paramPlayer && !hashSet.contains(entity.getUniqueId())) {
                LivingEntity livingEntity = (LivingEntity)entity;
                hashSet.add(entity.getUniqueId());
                livingEntity.setHealth(Math.max(0.0D, livingEntity.getHealth() - 10.0D));
                Vector vector = paramVector.clone().multiply(1.5D);
                vector.setY(0.4D);
                livingEntity.setVelocity(vector);
              } 
            }}} 
    } 
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */