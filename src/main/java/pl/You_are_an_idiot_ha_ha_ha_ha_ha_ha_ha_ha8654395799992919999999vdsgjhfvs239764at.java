package pl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764at implements Listener {
  public final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public final Map<UUID, BukkitRunnable> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new HashMap<>();
  
  public static Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  public static HashMap<UUID, Integer> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  public static HashMap<UUID, BukkitTask> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  static final boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = !You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764at.class.desiredAssertionStatus();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = Main.getInstance();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = Main.getInstance().getConfig().getInt("KnightfallSpeedAmplifier", 1);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = new HashMap<>();
  }
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764at(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au;
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fs(this, paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au)).runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, 0L, 20L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack paramItemStack) {
    {
      if (paramItemStack == null)
        return false; 
    }ItemMeta itemMeta = paramItemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }return itemMeta.getPersistentDataContainer().equals(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(null, false).getItemMeta().getPersistentDataContainer());
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    {
      if (paramEntityDamageByEntityEvent.isCancelled())
        return; 
    }Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
    if (entity1 instanceof Player) {
      player = (Player)entity1;
    } else {
      return;
    } 
    int i = Main.getInstance().getConfig().getInt("knightfallDamageLimit", 12);
    {
      if (i == 0)
        return; 
    }{
      if (paramEntityDamageByEntityEvent.getFinalDamage() <= i)
        return; 
    }ItemStack itemStack = player.getInventory().getItemInMainHand();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack))
        return; 
    }paramEntityDamageByEntityEvent.setDamage(0.0D);
    Entity entity2 = paramEntityDamageByEntityEvent.getEntity();
    if (entity2 instanceof LivingEntity) {
      LivingEntity livingEntity = (LivingEntity)entity2;
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity, i, player, true);
    } 
  }
  
  @EventHandler(priority = EventPriority.LOWEST)
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      Player player = (Player)entity;
      ItemStack itemStack = player.getInventory().getItemInMainHand();
      {
        if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack))
          return; 
      }String str = "knightfallCooldown";
      int i = Main.getInstance().getConfig().getInt(str, 0);
      {
        if (i == 0)
          return; 
      }{
        if (paramEntityDamageByEntityEvent.isCancelled())
          return; 
      }{
        if (paramEntityDamageByEntityEvent.getFinalDamage() <= 1.0D)
          return; 
      }{
        if (player.hasCooldown(Material.MACE)) {
          paramEntityDamageByEntityEvent.setCancelled(true);
          player.setVelocity(new Vector(0, 0, 0));
          player.setFallDistance(0.0F);
          player.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
          return;
        } 
      }player.setCooldown(itemStack, i * 20);
    } 
  }
  
  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent paramPlayerDeathEvent) {
    Player player = paramPlayerDeathEvent.getPlayer().getKiller();
    {
      if (player == null)
        return; 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getInventory().getItemInMainHand()))
        return; 
    }this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
    player.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED) + "Knightfall is now at " + this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player));
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setLore(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player, false).getLore());
    itemMeta.setCustomModelData(Integer.valueOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player, false).getItemMeta().getCustomModelData()));
    itemStack.setItemMeta(itemMeta);
    player.getInventory().setItemInMainHand(itemStack);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer, int paramInt) {
    paramPlayer.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, paramInt * 20, 1, true, false, false));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0F, 0.5F);
    paramPlayer.getWorld().spawnParticle(Particle.SQUID_INK, paramPlayer.getLocation(), 20, 0.0D, 0.0D, 0.0D, 0.0D);
    for (Player player : Bukkit.getOnlinePlayers())
      player.hidePlayer((Plugin)Main.getInstance(), paramPlayer); 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ft(paramInt, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getInventory().getItemInMainHand()))
        return; 
    }int i = Main.getInstance().getConfig().getInt("cloakChances", 10);
    int j = Main.getInstance().getConfig().getInt("cloakDuration", 3);
    Random random = new Random();
    {
      if (paramEntityDamageByEntityEvent.getEntity() instanceof LivingEntity)
        {
          if (random.nextInt(100) < i) {
            {
              if (player.getFallDistance() < 2.0F)
                return; 
            }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, j);
          } 
        }}}
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fu you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fu = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fu(this, paramPlayer);
    you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fu.runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, 0L, 20L);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(paramPlayer.getUniqueId(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fu);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    BukkitRunnable bukkitRunnable = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable != null)
        bukkitRunnable.cancel(); 
    }}
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), "hammerThrow"))
        return false; 
    }int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getConfig().getInt("hammerThrowCooldown", 30);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), "hammerThrow", i);
    double d1 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getConfig().getDouble("hammerThrowMaxDistance", 100.0D);
    double d2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getConfig().getDouble("hammerThrowDamage", 6.0D);
    boolean bool = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getConfig().getBoolean("hammerThrowStunShield", true);
    int j = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getConfig().getInt("hammerThrowStunShieldDuration", 5) * 20;
    double d3 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getConfig().getDouble("hammerThrowSpeed", 1.5D);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Hammer Throw", i, ChatColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector = location.getDirection().normalize().clone();
    World world = paramPlayer.getWorld();
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(location.clone().add(vector.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    ItemStack itemStack = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer, false);
    itemDisplay.setItemStack(itemStack);
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(1.0F, 1.0F, 1.0F);
    transformation.getLeftRotation().rotateX((float)Math.toRadians(90.0D));
    itemDisplay.setTransformation(transformation);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_CHAIN_BREAK, 1.0F, 0.1F);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fv(location, d1, paramPlayer, itemDisplay, vector, d3, world, bool, j, d2)).runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, 3L, 1L);
    return true;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(LivingEntity paramLivingEntity, Player paramPlayer) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764t.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLivingEntity.getLocation()))
        return; 
    }(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fw(paramLivingEntity, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Grappling Hook x1");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Grappling Hook x2");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Grappling Hook x3");
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt("grapplingHookCooldown", 10);
    int j = Main.getInstance().getConfig().getInt("grapplingHookMaxDistance", 50);
    Location location = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, j);
    {
      if (location == null)
        return false; 
    }{
      if (((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(0))).intValue() >= 3)
        return false; 
    }BukkitTask bukkitTask = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.get(paramPlayer.getUniqueId());
    {
      if (bukkitTask != null)
        bukkitTask.cancel(); 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.put(paramPlayer.getUniqueId(), Integer.valueOf(((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(0))).intValue() + 1));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer);
    int k = ((Integer)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getOrDefault(paramPlayer.getUniqueId(), Integer.valueOf(1))).intValue();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Grappling Hook §6§lx" + "Grappling Hook §6§lx", i, ChatColor.YELLOW);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer, i);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location, paramPlayer, j);
    return true;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer, int paramInt) {
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_ZOMBIE_ATTACK_IRON_DOOR, 1.0F, 2.0F);
    ItemStack itemStack = new ItemStack(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a6.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a());
    Location location1 = paramLocation.clone().add(0.0D, 1.0D, 0.0D);
    location1.getWorld().spawnParticle(Particle.GUST, location1, 0, 0.0D, 0.0D, 0.0D, 0.0D);
    location1.getWorld().spawnParticle(Particle.ITEM, location1, 120, 0.2D, 0.2D, 0.2D, 0.1D, itemStack);
    double d1 = Main.getInstance().getConfig().getDouble("grapplingHookStrength", 1.5D);
    int i = Main.getInstance().getConfig().getInt("grapplingHookLeapStrength", 1);
    double d2 = paramInt / d1;
    Location location2 = paramPlayer.getLocation().clone().add(0.0D, 1.0D, 0.0D);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fx(paramPlayer, d2, location1, i, itemStack, d1)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer, int paramInt) {
    BukkitTask bukkitTask = (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764fy(paramPlayer, paramInt)).runTaskLater((Plugin)Main.getInstance(), (paramInt * 20));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.put(paramPlayer.getUniqueId(), bukkitTask);
  }
  
  public static Location You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, int paramInt) {
    RayTraceResult rayTraceResult = paramPlayer.getWorld().rayTraceBlocks(paramPlayer.getEyeLocation(), paramPlayer.getEyeLocation().getDirection(), paramInt);
    {
      if (rayTraceResult == null) {
        paramPlayer.sendMessage("§cNo target block found!");
        return null;
      } 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g)
        {
          if (rayTraceResult.getHitBlock() == null)
            throw new AssertionError(); 
        }}{
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764t.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(rayTraceResult.getHitBlock().getLocation()))
        return null; 
    }return rayTraceResult.getHitBlock().getLocation().add(0.5D, 0.0D, 0.5D);
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764at.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */