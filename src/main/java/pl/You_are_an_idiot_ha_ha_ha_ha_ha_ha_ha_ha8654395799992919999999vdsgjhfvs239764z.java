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

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764z implements Listener {
  public final You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a2 You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public final Map<UUID, BukkitRunnable> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new ConcurrentHashMap<>();
  
  public final Map<UUID, BukkitRunnable> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new ConcurrentHashMap<>();
  
  public final Map<UUID, BukkitRunnable> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = new ConcurrentHashMap<>();
  
  public static final Map<UUID, BukkitRunnable> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  public final Map<UUID, BukkitRunnable> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = new ConcurrentHashMap<>();
  
  public static Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i;
  
  static double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j;

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = new ConcurrentHashMap();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = Main.getInstance();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getInt("speedLevel", 1);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getInt("strengthLevel", 0);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getDouble("bloodlustTrackRange", 80.0D);
  }
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764z(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a2 paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a2) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a2;
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cs(this, paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a2)).runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, 0L, 20L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    return Main.areSimilar(itemStack, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(null, false));
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent paramPlayerInteractEvent) {
    Player player = paramPlayerInteractEvent.getPlayer();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player))
        return; 
    }{
      if (paramPlayerInteractEvent.getAction() != Action.LEFT_CLICK_AIR) {
        {
          if (paramPlayerInteractEvent.getAction() == Action.LEFT_CLICK_BLOCK) {
            if (player.isSneaking()) {
              int i = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
              player.sendActionBar(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED) + "You are at " + i);
            } 
            return;
          } 
        }return;
      } 
    }if (player.isSneaking()) {
      int i = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
      player.sendActionBar(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED) + "You are at " + i);
    } 
  }
  
  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent paramPlayerDeathEvent) {
    Player player = paramPlayerDeathEvent.getEntity().getKiller();
    {
      if (player == null)
        return; 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player))
        return; 
    }this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
    player.sendActionBar(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
    player.getWorld().playSound(player.getLocation(), "minecraft:bloodlust.kill", 1.0F, 1.0F);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
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
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), "infection"))
        return; 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player))
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
    }int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getInt("infectionCooldown", 15);
    int j = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getInt("infectionDuration", 5) * 20;
    int k = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getInt("infectionDamage", 2);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), "infection", i);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ct(this, j, livingEntity, k)).runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, 0L, 1L);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cu you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cu = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cu(this, paramPlayer);
    you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cu.runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, 0L, 20L);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.put(paramPlayer.getUniqueId(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cu);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    BukkitRunnable bukkitRunnable = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable != null)
        try {
          bukkitRunnable.cancel();
        } catch (IllegalStateException illegalStateException) {} 
    }}
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cv you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cv = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cv(this, paramPlayer);
    you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cv.runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, 0L, 20L);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.put(paramPlayer.getUniqueId(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cv);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(Player paramPlayer) {
    BukkitRunnable bukkitRunnable = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable != null)
        try {
          bukkitRunnable.cancel();
        } catch (IllegalStateException illegalStateException) {} 
    }}
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cw you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cw = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cw(this, paramPlayer);
    you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cw.runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, 0L, 20L);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(paramPlayer.getUniqueId(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cw);
  }
  
  public Player You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, double paramDouble) {
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
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f(Player paramPlayer) {
    BukkitRunnable bukkitRunnable1 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable1 != null)
        try {
          bukkitRunnable1.cancel();
        } catch (IllegalStateException illegalStateException) {} 
    }BukkitRunnable bukkitRunnable2 = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable2 != null)
        try {
          bukkitRunnable2.cancel();
        } catch (IllegalStateException illegalStateException) {} 
    }}
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g(Player paramPlayer) {
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), "minecraft:bloodlust.dive", 2.0F, 1.0F);
    AttributeInstance attributeInstance = paramPlayer.getAttribute(Attribute.SCALE);
    {
      if (attributeInstance != null)
        attributeInstance.setBaseValue(0.4D); 
    }int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getInt("bloodTrailDuration", 15);
    for (Player player : Bukkit.getOnlinePlayers())
      player.hidePlayer((Plugin)Main.getInstance(), paramPlayer); 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cy you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cy = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cy(paramPlayer, i);
    WorldBorder worldBorder = Bukkit.createWorldBorder();
    {
      worldBorder.setCenter(paramPlayer.getLocation());
      worldBorder.setSize(5.9999968E7D);
      worldBorder.setWarningDistance(59999968);
      if (Main.getInstance().getConfig().getBoolean("bloodlustBorderLogic", true))
        paramPlayer.setWorldBorder(worldBorder); 
    }you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cy.runTaskTimer((Plugin)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g, 0L, 2L);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.put(paramPlayer.getUniqueId(), you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cy);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h(Player paramPlayer) {
    BukkitRunnable bukkitRunnable = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.remove(paramPlayer.getUniqueId());
    {
      if (bukkitRunnable == null)
        return; 
    }bukkitRunnable.cancel();
    int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getInt("bloodTrailCooldown", 60);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Blood Trail", i, ChatColor.YELLOW);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), "bloodTrail", i);
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
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(PlayerDeathEvent paramPlayerDeathEvent) {
    Player player = paramPlayerDeathEvent.getPlayer();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h(player);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerChangedWorldEvent paramPlayerChangedWorldEvent) {
    Player player = paramPlayerChangedWorldEvent.getPlayer();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h(player);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJoinEvent paramPlayerJoinEvent) {
    Player player = paramPlayerJoinEvent.getPlayer();
    AttributeInstance attributeInstance1 = player.getAttribute(Attribute.STEP_HEIGHT);
    {
      if (attributeInstance1 != null)
        attributeInstance1.setBaseValue(0.6D); 
    }AttributeInstance attributeInstance2 = player.getAttribute(Attribute.SCALE);
    {
      if (attributeInstance2 != null)
        attributeInstance2.setBaseValue(1.0D); 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h(player);
    player.setInvisible(false);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJumpEvent paramPlayerJumpEvent) {
    Player player = paramPlayerJumpEvent.getPlayer();
    if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.containsKey(player.getUniqueId())) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h(player);
      int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getInt("bloodTrailCooldown", 60);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, "Blood Trail", i, ChatColor.YELLOW);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), "bloodTrail", i);
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player = (Player)entity;
    } else {
      return;
    } 
    if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.containsKey(player.getUniqueId())) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h(player);
      int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.getConfig().getInt("bloodTrailCooldown", 60);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, "Blood Trail", i, ChatColor.YELLOW);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getUniqueId(), "bloodTrail", i);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i(Player paramPlayer) {
    int i = Main.getInstance().getConfig().getInt("hookCooldown", 30);
    double d1 = Main.getInstance().getConfig().getDouble("hookGravity", 0.0025D);
    double d2 = Main.getInstance().getConfig().getDouble("hookMaxDistance", 100.0D);
    double d3 = Main.getInstance().getConfig().getDouble("hookDamage", 4.0D);
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), "minecraft:bloodlust.resurface", 2.0F, 1.4F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), "bloodHook", i);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Blood Hook", i, ChatColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector = location.getDirection().normalize().clone();
    World world = paramPlayer.getWorld();
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(location.clone().add(vector.clone().multiply(0.5D)), EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.REDSTONE_BLOCK));
    itemDisplay.setBrightness(new Display.Brightness(15, 15));
    Transformation transformation = itemDisplay.getTransformation();
    transformation.getScale().set(1.0F, 1.0F, 1.0F);
    itemDisplay.setTransformation(transformation);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cz(location, d2, paramPlayer, itemDisplay, vector, d1, world, d3)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(LivingEntity paramLivingEntity, Player paramPlayer) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764t.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLivingEntity.getLocation()))
        return; 
    }(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c0(paramLivingEntity, paramPlayer)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }

  
  private static RuntimeException a(RuntimeException paramRuntimeException) {
    return paramRuntimeException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764z.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */