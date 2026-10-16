package pl;

import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

public class BloodLustAbilityListener implements Listener {
  public final BloodLustKillTracker killTracker;
  
  public final Map<UUID, BukkitRunnable> bloodHookTasks = new ConcurrentHashMap<>();
  
  public final Map<UUID, BukkitRunnable> bloodTrailTasks = new ConcurrentHashMap<>();
  
  public final Map<UUID, BukkitRunnable> bloodDiveTasks = new ConcurrentHashMap<>();
  
  public static final Map<UUID, BukkitRunnable> activeBloodTrails;
  
  public final Map<UUID, BukkitRunnable> bloodInfectionTasks = new ConcurrentHashMap<>();
  
  public static Main plugin;
  
  static int speedLevel;
  
  static int strengthLevel;
  
  static double bloodlustTrackRange;

  static {
    activeBloodTrails = new ConcurrentHashMap();
    plugin = Main.getInstance();
    speedLevel = plugin.getConfig().getInt("speedLevel", 1);
    strengthLevel = plugin.getConfig().getInt("strengthLevel", 0);
    bloodlustTrackRange = plugin.getConfig().getDouble("bloodlustTrackRange", 80.0D);
  }

  public BloodLustAbilityListener(BloodLustKillTracker paramBloodLustKillTracker) {
    this.killTracker = paramBloodLustKillTracker;
    (new BloodLustAbilityMonitorTask(this, paramBloodLustKillTracker)).runTaskTimer((Plugin) plugin, 0L, 20L);
  }
  
  public static boolean isHoldingBloodlust(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    return Main.areSimilar(itemStack, CustomItemRegistry.getBloodlust(null, false));
  }
  
  @EventHandler
  public void onBloodlustInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    Player player = paramPlayerInteractEvent.getPlayer();
    {
      if (!isHoldingBloodlust(player))
        return; 
    }{
      if (paramPlayerInteractEvent.getAction() != Action.LEFT_CLICK_AIR) {
        {
          if (paramPlayerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (player.isSneaking()) {
              int i = this.killTracker.getKillCount(player);
              player.sendActionBar(String.valueOf(ChatColor.RED) + "You are at " + i + " bloodlust kill(s).");
            } 
            return;
          } 
        }return;
      } 
    }if (player.isSneaking()) {
      int i = this.killTracker.getKillCount(player);
      player.sendActionBar(String.valueOf(ChatColor.RED) + "You are at " + i + " bloodlust kill(s).");
    } 
  }
  
  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onBloodlustKill(PlayerDeathEvent paramPlayerDeathEvent) {
    Player player = paramPlayerDeathEvent.getEntity().getKiller();
    {
      if (player == null)
        return; 
    }{
      if (!isHoldingBloodlust(player))
        return; 
    }this.killTracker.incrementKillCount(player);
    player.sendActionBar(String.valueOf(ChatColor.RED) + "Your weapon grows stronger...");
    player.getWorld().playSound(player.getLocation(), "minecraft:bloodlust.kill", 1.0F, 1.0F);
  }
  
  @EventHandler
  public void onBloodlustDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    LivingEntity livingEntity;
    Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
    if (entity1 instanceof Player) {
      player = (Player)entity1;
    } else {
      return;
    } 
    {
      if (paramEntityDamageByEntityEvent.isCancelled())
        return; 
    }{
      if (paramEntityDamageByEntityEvent.getFinalDamage() < 0.5D)
        return; 
    }{
      if (CooldownManager.isOnCooldown(player.getUniqueId(), "infection"))
        return; 
    }{
      if (!isHoldingBloodlust(player))
        return; 
    }Entity entity2 = paramEntityDamageByEntityEvent.getEntity();
    if (entity2 instanceof LivingEntity) {
      livingEntity = (LivingEntity)entity2;
    } else {
      return;
    } 
    Random random = new Random();
    {
      if (random.nextInt(100) >= 15)
        return; 
    }int i = plugin.getConfig().getInt("infectionCooldown", 15);
    int j = plugin.getConfig().getInt("infectionDuration", 5) * 20;
    int k = plugin.getConfig().getInt("infectionDamage", 2);
    CooldownManager.setCooldown(player.getUniqueId(), "infection", i);
    (new BloodInfectionDamageTask(this, j, livingEntity, k)).runTaskTimer((Plugin) plugin, 0L, 1L);
  }
  
  public void startBloodDive(Player paramPlayer) {
    BloodDiveSpeedTask bloodDiveSpeedTask = new BloodDiveSpeedTask(this, paramPlayer);
    bloodDiveSpeedTask.runTaskTimer((Plugin) plugin, 0L, 20L);
    this.bloodTrailTasks.put(paramPlayer.getUniqueId(), bloodDiveSpeedTask);
  }
  
  public void stopBloodDive(Player paramPlayer) {
    BukkitRunnable bukkitRunnable = this.bloodTrailTasks.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable != null)
        try {
          bukkitRunnable.cancel();
        } catch (IllegalStateException illegalStateException) {} 
    }}
  
  public void startBloodTrail(Player paramPlayer) {
    BloodTrailStrengthTask bloodTrailStrengthTask = new BloodTrailStrengthTask(this, paramPlayer);
    bloodTrailStrengthTask.runTaskTimer((Plugin) plugin, 0L, 20L);
    this.bloodDiveTasks.put(paramPlayer.getUniqueId(), bloodTrailStrengthTask);
  }
  
  public void stopBloodTrail(Player paramPlayer) {
    BukkitRunnable bukkitRunnable = this.bloodDiveTasks.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable != null)
        try {
          bukkitRunnable.cancel();
        } catch (IllegalStateException illegalStateException) {} 
    }}
  
  public void startBloodHook(Player paramPlayer) {
    BloodHookTargetingTask bloodHookTargetingTask = new BloodHookTargetingTask(this, paramPlayer);
    bloodHookTargetingTask.runTaskTimer((Plugin) plugin, 0L, 20L);
    this.bloodHookTasks.put(paramPlayer.getUniqueId(), bloodHookTargetingTask);
  }
  
  public Player findNearestEnemy(Player paramPlayer, double paramDouble) {
    Player player = null;
    double d = paramDouble;
    for (Player player1 : paramPlayer.getLocation().getNearbyPlayers(paramDouble)) {
      {
        if (player1.equals(paramPlayer))
          continue; 
      }{
        if (Main.isTrusted(paramPlayer, (Entity)player1))
          continue; 
      }{
        if (player1.getWorld() != paramPlayer.getWorld())
          continue; 
      }double d1 = player1.getLocation().distance(paramPlayer.getLocation());
      if (d1 < d) {
        d = d1;
        player = player1;
      } 
    } 
    return player;
  }
  
  public void cancelPlayerAbilities(Player paramPlayer) {
    BukkitRunnable bukkitRunnable1 = this.bloodHookTasks.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable1 != null)
        try {
          bukkitRunnable1.cancel();
        } catch (IllegalStateException illegalStateException) {} 
    }BukkitRunnable bukkitRunnable2 = this.bloodInfectionTasks.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable2 != null)
        try {
          bukkitRunnable2.cancel();
        } catch (IllegalStateException illegalStateException) {} 
    }}
  
  public static void startBloodTrailEffect(Player paramPlayer) {
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), "minecraft:bloodlust.dive", 2.0F, 1.0F);
    AttributeInstance attributeInstance = paramPlayer.getAttribute(Attribute.SCALE);
    {
      if (attributeInstance != null)
        attributeInstance.setBaseValue(0.4D); 
    }int i = plugin.getConfig().getInt("bloodTrailDuration", 15);
    for (Player player : Bukkit.getOnlinePlayers())
      player.hidePlayer((Plugin)Main.getInstance(), paramPlayer); 
    BloodTrailInvisibilityTask bloodTrailInvisibilityTask = new BloodTrailInvisibilityTask(paramPlayer, i);
    WorldBorder worldBorder = Bukkit.createWorldBorder();
    {
      worldBorder.setCenter(paramPlayer.getLocation());
      worldBorder.setSize(5.9999968E7D);
      worldBorder.setWarningDistance(59999968);
      if (Main.getInstance().getConfig().getBoolean("bloodlustBorderLogic", true))
        paramPlayer.setWorldBorder(worldBorder); 
    }bloodTrailInvisibilityTask.runTaskTimer((Plugin) plugin, 0L, 2L);
    activeBloodTrails.put(paramPlayer.getUniqueId(), bloodTrailInvisibilityTask);
  }
  
  public static void endBloodTrailEffect(Player paramPlayer) {
    BukkitRunnable bukkitRunnable = activeBloodTrails.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable == null)
        return; 
    }bukkitRunnable.cancel();
    int i = plugin.getConfig().getInt("bloodTrailCooldown", 60);
    BossBarManager.createBar(paramPlayer, "Blood Trail", i, ChatColor.YELLOW);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "bloodTrail", i);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), "minecraft:bloodlust.resurface", 2.0F, 1.0F);
    AttributeInstance attributeInstance1 = paramPlayer.getAttribute(Attribute.SCALE);
    {
      if (attributeInstance1 != null)
        attributeInstance1.setBaseValue(1.0D); 
    }AttributeInstance attributeInstance2 = paramPlayer.getAttribute(Attribute.STEP_HEIGHT);
    {
      if (attributeInstance2 != null)
        attributeInstance2.setBaseValue(0.6D); 
    }for (Player player : Bukkit.getOnlinePlayers())
      player.showPlayer((Plugin)Main.getInstance(), paramPlayer); 
    {
      if (Main.getInstance().getConfig().getBoolean("bloodlustBorderLogic", true))
        paramPlayer.setWorldBorder(null); 
    }paramPlayer.sendActionBar(" ");
  }
  
  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent paramPlayerDeathEvent) {
    Player player = paramPlayerDeathEvent.getPlayer();
    endBloodTrailEffect(player);
  }
  
  @EventHandler
  public void onPlayerChangedWorld(PlayerChangedWorldEvent paramPlayerChangedWorldEvent) {
    Player player = paramPlayerChangedWorldEvent.getPlayer();
    endBloodTrailEffect(player);
  }
  
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent paramPlayerJoinEvent) {
    Player player = paramPlayerJoinEvent.getPlayer();
    AttributeInstance attributeInstance1 = player.getAttribute(Attribute.STEP_HEIGHT);
    {
      if (attributeInstance1 != null)
        attributeInstance1.setBaseValue(0.6D); 
    }AttributeInstance attributeInstance2 = player.getAttribute(Attribute.SCALE);
    {
      if (attributeInstance2 != null)
        attributeInstance2.setBaseValue(1.0D); 
    }
    endBloodTrailEffect(player);
    player.setInvisible(false);
  }
  
  @EventHandler
  public void onPlayerJump(PlayerJumpEvent paramPlayerJumpEvent) {
    Player player = paramPlayerJumpEvent.getPlayer();
    if (activeBloodTrails.containsKey(player.getUniqueId())) {
      endBloodTrailEffect(player);
      int i = plugin.getConfig().getInt("bloodTrailCooldown", 60);
      BossBarManager.createBar(player, "Blood Trail", i, ChatColor.YELLOW);
      CooldownManager.setCooldown(player.getUniqueId(), "bloodTrail", i);
    } 
  }
  
  @EventHandler
  public void onBloodTrailDamage(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    if (activeBloodTrails.containsKey(player.getUniqueId())) {
      endBloodTrailEffect(player);
      int i = plugin.getConfig().getInt("bloodTrailCooldown", 60);
      BossBarManager.createBar(player, "Blood Trail", i, ChatColor.YELLOW);
      CooldownManager.setCooldown(player.getUniqueId(), "bloodTrail", i);
    } 
  }
  
  public static void launchBloodHook(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt("hookCooldown", 30);
    double d1 = Main.getInstance().getConfig().getDouble("hookGravity", 0.0025D);
    double d2 = Main.getInstance().getConfig().getDouble("hookMaxDistance", 100.0D);
    double d3 = Main.getInstance().getConfig().getDouble("hookDamage", 4.0D);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), "minecraft:bloodlust.resurface", 2.0F, 1.4F);
    CooldownManager.setCooldown(paramPlayer.getUniqueId(), "bloodHook", i);
    BossBarManager.createBar(paramPlayer, "Blood Hook", i, ChatColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector = location.getDirection().normalize().clone();
    World world = paramPlayer.getWorld();
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(location.clone().add(vector.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.REDSTONE_BLOCK));
    itemDisplay.setBrightness(new Display.Brightness(15, 15));
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(1.0F, 1.0F, 1.0F);
    itemDisplay.setTransformation(transformation);
    (new BloodHookProjectileTask(location, d2, paramPlayer, itemDisplay, vector, d1, world, d3)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void infectEntity(LivingEntity paramLivingEntity, Player paramPlayer) {
    {
      if (WorldGuardHook.isBlocked(paramLivingEntity.getLocation()))
        return; 
    }(new BloodDivePullTask(paramLivingEntity, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764z.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */