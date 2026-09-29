package pl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.FluidCollisionMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;
import java.util.HashMap;

public final class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj implements Listener, CommandExecutor, TabCompleter {
  private static final String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private static final String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
  
  private static final FileConfiguration You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  private static final double You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  private static final boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e;
  
  private static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  private static File You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  private static YamlConfiguration You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  private static final Map<UUID, String> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i;
  
  private static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j;
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k;
  
  
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = new File(Main.getInstance().getDataFolder(), "vampire.yml");
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.exists()) {
        Main.getInstance().getDataFolder().mkdirs();
        try {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.createNewFile();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } 
      } 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = YamlConfiguration.loadConfiguration(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.clear();
    for (String str : You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.getKeys(false))
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.put(UUID.fromString(str), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.getString(str)); 
  }
  
  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    try {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.save(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g);
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c() {
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f)
        return; 
    }(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gi()).runTaskTimer((Plugin)Main.getInstance(), 0L, 20L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(Player paramPlayer) {
    {
      if (paramPlayer.getWorld().getEnvironment() != World.Environment.NORMAL)
        return false; 
    }{
      if (!paramPlayer.getWorld().isDayTime())
        return false; 
    }Location location = paramPlayer.getEyeLocation();
    Vector vector = new Vector(0, 1, 0);
    {
    
    }return (paramPlayer.getWorld().rayTraceBlocks(location, vector, paramPlayer.getWorld().getMaxHeight(), FluidCollisionMode.NEVER) == null);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent paramPlayerDeathEvent) {
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f)
        return; 
    }Player player1 = paramPlayerDeathEvent.getPlayer();
    Player player2 = player1.getKiller();
    {
      if (player2 == null)
        return; 
    }ItemStack itemStack = player2.getInventory().getItemInMainHand();
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(player2)) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player1);
          } else {
            {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c__v0(player2)) {
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player1);
              } else {
                {
                  if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d__v0(player2))
                    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(player1); 
                }} 
            }} 
        }} else {
        {
          if (Main.areSimilar(itemStack, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h())) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(player1);
          } else {
            {
              if (Main.areSimilar(itemStack, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i())) {
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player1);
              } else {
                {
                  if (player1.hasPotionEffect(PotionEffectType.LUCK))
                    {
                      if (player1.getPotionEffect(PotionEffectType.LUCK).getAmplifier() == 1)
                        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player1); 
                    }}} 
            }} 
        }} 
    }}
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    LivingEntity livingEntity;
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f)
        return; 
    }Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
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
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(player))
        return; 
    }Vector vector1 = livingEntity.getLocation().getDirection().normalize();
    Vector vector2 = player.getLocation().toVector().subtract(livingEntity.getLocation().toVector()).normalize();
    double d = vector1.dot(vector2);
    if (d < -0.5D) {
      double d1 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
      paramEntityDamageByEntityEvent.setDamage(paramEntityDamageByEntityEvent.getDamage() + d1);
      livingEntity.getWorld().playSound(livingEntity.getLocation(), Sound.ENTITY_CREAKING_ATTACK, 1.2F, 1.0F);
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJoinEvent paramPlayerJoinEvent) {
    Player player = paramPlayerJoinEvent.getPlayer();
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.containsKey(player.getUniqueId()))
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j != null)
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j); 
        }}You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    String str1 = "dw_" + "dw_";
    Team team = scoreboard.getTeam(str1);
    if (team == null) {
      team = scoreboard.registerNewTeam(str1);
      team.addEntry(paramPlayer.getName());
    } 
    String str2 = ChatColor.stripColor(paramPlayer.getName());
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(paramPlayer)) {
        team.setColor(ChatColor.YELLOW);
        team.setPrefix("§e");
        paramPlayer.setDisplayName("§e" + "§e");
        paramPlayer.setPlayerListName("§e" + "§e");
      } else {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c__v0(paramPlayer)) {
            team.setColor(ChatColor.RED);
            team.setPrefix("§c");
            paramPlayer.setDisplayName("§c" + "§c");
            paramPlayer.setPlayerListName("§c" + "§c");
          } else {
            team.setColor(ChatColor.RESET);
            team.setPrefix("");
            paramPlayer.setDisplayName(str2);
            paramPlayer.setPlayerListName(str2);
          } 
        }} 
    }}
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "PALE");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    paramPlayer.sendMessage("§eYou are now a pale rot");
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "VAMPIRE");
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    paramPlayer.sendMessage("§cYou are now a vampire");
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(paramPlayer);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    paramPlayer.sendMessage("§aYou are now a human with no special abilities");
  }
  
  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, String paramString) {
    UUID uUID = paramPlayer.getUniqueId();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.put(uUID, paramString);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.set(uUID.toString(), paramString);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
  }
  
  private static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(Player paramPlayer) {
    UUID uUID = paramPlayer.getUniqueId();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.remove(uUID);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.set(uUID.toString(), null);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(Player paramPlayer) {
    return "PALE".equals(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.get(paramPlayer.getUniqueId()));
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c__v0(Player paramPlayer) {
    return "VAMPIRE".equals(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.get(paramPlayer.getUniqueId()));
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d__v0(Player paramPlayer) {
    {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(paramPlayer))
        {
          if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c__v0(paramPlayer));
        }}return false;
  }
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.get(paramPlayer.getUniqueId());
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(String paramString) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = false;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.set("vampire_event_enabled", Boolean.valueOf(false));
    String str2 = paramString.toLowerCase();
    byte b = -1;
    {
      switch (str2.hashCode()) {
        case 3433258:
          if (str2.equals("pale"))
            b = 0; 
          break;
        case 232384526:
          if (str2.equals("vampire"))
            b = 1; 
          break;
      } 
    }{
      switch (b) {
        case 0:
        
        case 1:
        
        default:
          break;
      } 
    }String str1 = null;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j = str1;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.set("vampire_winner", str1);
    Main.getInstance().saveConfig();
    for (Player player : Bukkit.getOnlinePlayers()) {
      {
        if (str1 == null) {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(player);
          continue;
        } 
      }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, str1);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
    } 
    for (UUID uUID : (Iterable<UUID>)(Iterable<?>)new ArrayList(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.keySet())) {
      {
        if (Bukkit.getPlayer(uUID) == null) {
          {
            if (str1 == null) {
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.remove(uUID);
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.set(uUID.toString(), null);
              continue;
            } 
          }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.put(uUID, str1);
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.set(uUID.toString(), str1);
        } 
      }} 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k = false;
    Bukkit.broadcastMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.BOLD));
  }
  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    String str1 = paramArrayOfString[0];
    Player player = Bukkit.getPlayer(str1);
    {
      if (player == null) {
        {
          if (str1.equalsIgnoreCase("toggle")) {
            {
            
            }{
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = !You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f) {
                paramCommandSender.sendMessage("§aVampire Event enabled.");
              } else {
                paramCommandSender.sendMessage("§cVampire Event disabled.");
              } 
            }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.set("vampire_event_enabled", Boolean.valueOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f));
            Main.getInstance().saveConfig();
            return true;
          } 
        }paramCommandSender.sendMessage("§cPlayer not found.");
        return true;
      } 
    }{
      if (paramArrayOfString.length != 2) {
        paramCommandSender.sendMessage("§cUsage: /vampire <player> <pale|vampire|human>");
        return true;
      } 
    }String str2 = paramArrayOfString[1].toLowerCase();
    byte b = -1;
    {
      switch (str2.hashCode()) {
        case 3433258:
          if (str2.equals("pale"))
            b = 0; 
          break;
        case 232384526:
          if (str2.equals("vampire"))
            b = 1; 
          break;
        case 99639597:
          if (str2.equals("human"))
            b = 2; 
          break;
      } 
    }{
      switch (b) {
        case 0:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
          paramCommandSender.sendMessage("§a" + "§a" + player.getName());
          return true;
        case 1:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player);
          paramCommandSender.sendMessage("§a" + "§a" + player.getName());
          return true;
        case 2:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(player);
          paramCommandSender.sendMessage("§a" + "§a" + player.getName());
          return true;
      } 
    }paramCommandSender.sendMessage("§cUsage: /vampire <player> <pale|vampire|human>");
    return true;
  }
  
  public List<String> onTabComplete(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    if (paramArrayOfString.length == 1) {
      String str = paramArrayOfString[0].toLowerCase();
      ArrayList<String> arrayList = new ArrayList();
      for (Player player : Bukkit.getOnlinePlayers()) {
        {
          if (player.getName().toLowerCase().startsWith(str))
            arrayList.add(player.getName()); 
        }} 
      arrayList.add("toggle");
      return arrayList;
    } 
    if (paramArrayOfString.length == 2) {
      String str = paramArrayOfString[1].toLowerCase();
      ArrayList<String> arrayList = new ArrayList();
      for (String str1 : List.<String>of("pale", "vampire", "human")) {
        {
          if (str1.startsWith(str))
            arrayList.add(str1); 
        }} 
      return arrayList;
    } 
    return List.of();
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = Main.getInstance().getConfig();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getDouble("backstab_damage", 2.0D);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getBoolean("all_vampires_and_palerots_infect_humans", true);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getBoolean("vampire_event_enabled", false);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i = new HashMap<>();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.getString("vampire_winner", null);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k = false;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = "PALE";
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = "VAMPIRE";
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */