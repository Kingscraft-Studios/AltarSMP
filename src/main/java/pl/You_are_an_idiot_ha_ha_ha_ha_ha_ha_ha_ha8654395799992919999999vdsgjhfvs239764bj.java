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
  
  private static final String[] a;
  
  private static final String[] b;
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    try {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = new File(Main.getInstance().getDataFolder(), a(8253, 9289));
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.exists()) {
        Main.getInstance().getDataFolder().mkdirs();
        try {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.createNewFile();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } 
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = YamlConfiguration.loadConfiguration(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g);
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
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gi()).runTaskTimer((Plugin)Main.getInstance(), 0L, 20L);
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(Player paramPlayer) {
    try {
      if (paramPlayer.getWorld().getEnvironment() != World.Environment.NORMAL)
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (!paramPlayer.getWorld().isDayTime())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Location location = paramPlayer.getEyeLocation();
    Vector vector = new Vector(0, 1, 0);
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (paramPlayer.getWorld().rayTraceBlocks(location, vector, paramPlayer.getWorld().getMaxHeight(), FluidCollisionMode.NEVER) == null);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent paramPlayerDeathEvent) {
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Player player1 = paramPlayerDeathEvent.getPlayer();
    Player player2 = player1.getKiller();
    try {
      if (player2 == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ItemStack itemStack = player2.getInventory().getItemInMainHand();
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
        try {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player2)) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player1);
          } else {
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player2)) {
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player1);
              } else {
                try {
                  if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(player2))
                    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(player1); 
                } catch (MatchException matchException) {
                  throw a(null);
                } 
              } 
            } catch (MatchException matchException) {
              throw a(null);
            } 
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } else {
        try {
          if (Main.areSimilar(itemStack, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h())) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(player1);
          } else {
            try {
              if (Main.areSimilar(itemStack, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i())) {
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player1);
              } else {
                try {
                  if (player1.hasPotionEffect(PotionEffectType.LUCK))
                    try {
                      if (player1.getPotionEffect(PotionEffectType.LUCK).getAmplifier() == 1)
                        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player1); 
                    } catch (MatchException matchException) {
                      throw a(null);
                    }  
                } catch (MatchException matchException) {
                  throw a(null);
                } 
              } 
            } catch (MatchException matchException) {
              throw a(null);
            } 
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    LivingEntity livingEntity;
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
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
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player))
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Vector vector1 = livingEntity.getLocation().getDirection().normalize();
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
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.containsKey(player.getUniqueId()))
        try {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j != null)
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j); 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    String str1 = a(8238, 26774) + a(8238, 26774);
    Team team = scoreboard.getTeam(str1);
    if (team == null) {
      team = scoreboard.registerNewTeam(str1);
      team.addEntry(paramPlayer.getName());
    } 
    String str2 = ChatColor.stripColor(paramPlayer.getName());
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer)) {
        team.setColor(ChatColor.YELLOW);
        team.setPrefix(a(8207, 23294));
        paramPlayer.setDisplayName(a(8236, 4286) + a(8236, 4286));
        paramPlayer.setPlayerListName(a(8236, 4286) + a(8236, 4286));
      } else {
        try {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer)) {
            team.setColor(ChatColor.RED);
            team.setPrefix(a(8240, -4502));
            paramPlayer.setDisplayName(a(8250, 3217) + a(8250, 3217));
            paramPlayer.setPlayerListName(a(8250, 3217) + a(8250, 3217));
          } else {
            team.setColor(ChatColor.RESET);
            team.setPrefix("");
            paramPlayer.setDisplayName(str2);
            paramPlayer.setPlayerListName(str2);
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, a(8205, -18504));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    paramPlayer.sendMessage(a(8251, 120));
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, a(8230, -25733));
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    paramPlayer.sendMessage(a(8244, -19018));
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(paramPlayer);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
    paramPlayer.sendMessage(a(8239, -10576));
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
    return a(8246, -5884).equals(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.get(paramPlayer.getUniqueId()));
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c__v0(Player paramPlayer) {
    return a(8230, -25733).equals(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.get(paramPlayer.getUniqueId()));
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d__v0(Player paramPlayer) {
    try {
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer))
        try {
          if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer));
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.get(paramPlayer.getUniqueId());
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(String paramString) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = false;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.set(a(8232, 10234), Boolean.valueOf(false));
    String str2 = paramString.toLowerCase();
    byte b = -1;
    try {
      switch (str2.hashCode()) {
        case 3433258:
          if (str2.equals(a(8249, -10022)))
            b = 0; 
          break;
        case 232384526:
          if (str2.equals(a(8245, -21647)))
            b = 1; 
          break;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      switch (b) {
        case 0:
        
        case 1:
        
        default:
          break;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    String str1 = null;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j = str1;
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.set(a(8201, 31155), str1);
    Main.getInstance().saveConfig();
    for (Player player : Bukkit.getOnlinePlayers()) {
      try {
        if (str1 == null) {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(player);
          continue;
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, str1);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
    } 
    for (UUID uUID : new ArrayList(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.keySet())) {
      try {
        if (Bukkit.getPlayer(uUID) == null) {
          try {
            if (str1 == null) {
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.remove(uUID);
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.set(uUID.toString(), null);
              continue;
            } 
          } catch (MatchException matchException) {
            throw a(null);
          } 
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i.put(uUID, str1);
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h.set(uUID.toString(), str1);
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k = false;
    Bukkit.broadcastMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.BOLD));
  }
  
  public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    String str1 = paramArrayOfString[0];
    Player player = Bukkit.getPlayer(str1);
    try {
      if (player == null) {
        try {
          if (str1.equalsIgnoreCase(a(8242, -30095))) {
            try {
            
            } catch (MatchException matchException) {
              throw a(null);
            } 
            try {
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = !You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f) {
                paramCommandSender.sendMessage(a(8247, 13045));
              } else {
                paramCommandSender.sendMessage(a(8254, -22293));
              } 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.set(a(8232, 10234), Boolean.valueOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f));
            Main.getInstance().saveConfig();
            return true;
          } 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        paramCommandSender.sendMessage(a(8241, -26968));
        return true;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramArrayOfString.length != 2) {
        paramCommandSender.sendMessage(a(8225, 29622));
        return true;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    String str2 = paramArrayOfString[1].toLowerCase();
    byte b = -1;
    try {
      switch (str2.hashCode()) {
        case 3433258:
          if (str2.equals(a(8249, -10022)))
            b = 0; 
          break;
        case 232384526:
          if (str2.equals(a(8245, -21647)))
            b = 1; 
          break;
        case 99639597:
          if (str2.equals(a(8233, 3796)))
            b = 2; 
          break;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      switch (b) {
        case 0:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
          paramCommandSender.sendMessage(a(8227, -13338) + a(8227, -13338) + player.getName());
          return true;
        case 1:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player);
          paramCommandSender.sendMessage(a(8228, -29000) + a(8228, -29000) + player.getName());
          return true;
        case 2:
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(player);
          paramCommandSender.sendMessage(a(8228, -29000) + a(8228, -29000) + player.getName());
          return true;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    paramCommandSender.sendMessage(a(8248, -8594));
    return true;
  }
  
  public List<String> onTabComplete(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    if (paramArrayOfString.length == 1) {
      String str = paramArrayOfString[0].toLowerCase();
      ArrayList<String> arrayList = new ArrayList();
      for (Player player : Bukkit.getOnlinePlayers()) {
        try {
          if (player.getName().toLowerCase().startsWith(str))
            arrayList.add(player.getName()); 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
      arrayList.add(a(8234, 17156));
      return arrayList;
    } 
    if (paramArrayOfString.length == 2) {
      String str = paramArrayOfString[1].toLowerCase();
      ArrayList<String> arrayList = new ArrayList();
      for (String str1 : List.<String>of(a(8229, 988), a(8255, 13870), a(8206, -28352))) {
        try {
          if (str1.startsWith(str))
            arrayList.add(str1); 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } 
      return arrayList;
    } 
    return List.of();
  }
  
  static {
    // Byte code:
    //   0: bipush #40
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'Ëh×ÀÕÍÿ¿È\\n¸{$Þj¦Í;«2ðÆæ¢üþ×VG¬Ê»¢ùYµzÜ`W2Ê|Åü/ßO5Pî3¾¿·QìÇ|2¬Ê>úÙ)<ÉÄ[­¤æ¿y/îLÆäÊÛÂ±ä*!2·¹®J]¦*¾SHc/\\thãêÉ%2ÆÐàùE¸vuò\\fá]k ^Òxì\\n³%iÒjÐ3/>þ1y¤°wSè]à å-É«3\\bæª3û;»±Äµó0@&é,4¼ÄBÏQ+B±/[0³Ý[¼k¤ w,ñ`Û¥fË½\\bn+\\r&árµÙÕï×jð;ºW¶ãÊõhá¯5,©ç[.'Æª5¬x¬Q/i\\r@+®´Á¶¹{4¿õæ^9ï¤25ê°¨Ì5yn÷Úå#·¬%ñÞ©ytS[<z!Í¬(Â(H«$çj@±¯nÃå\îì\EçÀoçµg$Ô-³=\\t¶ï-Ñ1Æq ` «Z´Íh²¡ìü=¶4T¼®7E4Å¾y`õZFv²Å<ãVÿ=ÛZh'Þö>û{¿·ËL)ÚIpÜ*¶`Yi\\f¹®:ó<ÚCå;ÖÂ'õd<¶£#y\\b.ñå¹©³V>¯B|û!Ë¡5$"éÇlr´'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #21
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #38
    //   25: iinc #0, 1
    //   28: aload_2
    //   29: iload_0
    //   30: dup
    //   31: iload_1
    //   32: iadd
    //   33: invokevirtual substring : (II)Ljava/lang/String;
    //   36: iconst_m1
    //   37: goto -> 166
    //   40: aload #5
    //   42: swap
    //   43: iload_3
    //   44: iinc #3, 1
    //   47: swap
    //   48: aastore
    //   49: iload_0
    //   50: iload_1
    //   51: iadd
    //   52: dup
    //   53: istore_0
    //   54: iload #4
    //   56: if_icmpge -> 68
    //   59: aload_2
    //   60: iload_0
    //   61: invokevirtual charAt : (I)C
    //   64: istore_1
    //   65: goto -> 23
    //   68: ldc '¨¢ªàö'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: iconst_5
    //   78: istore_1
    //   79: iconst_m1
    //   80: istore_0
    //   81: bipush #119
    //   83: iinc #0, 1
    //   86: aload_2
    //   87: iload_0
    //   88: dup
    //   89: iload_1
    //   90: iadd
    //   91: invokevirtual substring : (II)Ljava/lang/String;
    //   94: iconst_0
    //   95: goto -> 166
    //   98: aload #5
    //   100: swap
    //   101: iload_3
    //   102: iinc #3, 1
    //   105: swap
    //   106: aastore
    //   107: iload_0
    //   108: iload_1
    //   109: iadd
    //   110: dup
    //   111: istore_0
    //   112: iload #4
    //   114: if_icmpge -> 126
    //   117: aload_2
    //   118: iload_0
    //   119: invokevirtual charAt : (I)C
    //   122: istore_1
    //   123: goto -> 81
    //   126: aload #5
    //   128: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.a : [Ljava/lang/String;
    //   131: bipush #40
    //   133: anewarray java/lang/String
    //   136: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.b : [Ljava/lang/String;
    //   139: sipush #8237
    //   142: sipush #-20654
    //   145: invokestatic a : (II)Ljava/lang/String;
    //   148: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : Ljava/lang/String;
    //   151: sipush #8203
    //   154: sipush #-10369
    //   157: invokestatic a : (II)Ljava/lang/String;
    //   160: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : Ljava/lang/String;
    //   163: goto -> 324
    //   166: dup_x2
    //   167: pop
    //   168: invokevirtual toCharArray : ()[C
    //   171: dup_x1
    //   172: arraylength
    //   173: dup_x2
    //   174: pop
    //   175: iconst_0
    //   176: istore #6
    //   178: dup2_x1
    //   179: pop2
    //   180: dup_x2
    //   181: iconst_1
    //   182: if_icmpgt -> 284
    //   185: dup2
    //   186: swap
    //   187: iload #6
    //   189: dup2_x1
    //   190: caload
    //   191: swap
    //   192: iload #6
    //   194: bipush #7
    //   196: irem
    //   197: tableswitch default -> 266, 0 -> 236, 1 -> 241, 2 -> 246, 3 -> 251, 4 -> 256, 5 -> 261
    //   236: bipush #26
    //   238: goto -> 268
    //   241: bipush #98
    //   243: goto -> 268
    //   246: bipush #101
    //   248: goto -> 268
    //   251: bipush #53
    //   253: goto -> 268
    //   256: bipush #101
    //   258: goto -> 268
    //   261: bipush #114
    //   263: goto -> 268
    //   266: bipush #75
    //   268: ixor
    //   269: ixor
    //   270: i2c
    //   271: castore
    //   272: iinc #6, 1
    //   275: dup
    //   276: ifne -> 284
    //   279: dup2
    //   280: dup_x1
    //   281: goto -> 189
    //   284: dup2_x1
    //   285: pop2
    //   286: dup_x2
    //   287: iload #6
    //   289: if_icmpgt -> 185
    //   292: pop
    //   293: new java/lang/String
    //   296: dup_x1
    //   297: swap
    //   298: invokespecial <init> : ([C)V
    //   301: invokevirtual intern : ()Ljava/lang/String;
    //   304: swap
    //   305: pop
    //   306: swap
    //   307: tableswitch default -> 40, 0 -> 98
    //   324: invokestatic getInstance : ()Lpl/Main;
    //   327: invokevirtual getConfig : ()Lorg/bukkit/configuration/file/FileConfiguration;
    //   330: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Lorg/bukkit/configuration/file/FileConfiguration;
    //   333: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Lorg/bukkit/configuration/file/FileConfiguration;
    //   336: sipush #8235
    //   339: sipush #-4709
    //   342: invokestatic a : (II)Ljava/lang/String;
    //   345: ldc2_w 2.0
    //   348: invokevirtual getDouble : (Ljava/lang/String;D)D
    //   351: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : D
    //   354: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Lorg/bukkit/configuration/file/FileConfiguration;
    //   357: sipush #8200
    //   360: sipush #23810
    //   363: invokestatic a : (II)Ljava/lang/String;
    //   366: iconst_1
    //   367: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   370: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : Z
    //   373: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Lorg/bukkit/configuration/file/FileConfiguration;
    //   376: sipush #8226
    //   379: sipush #-18135
    //   382: invokestatic a : (II)Ljava/lang/String;
    //   385: iconst_0
    //   386: invokevirtual getBoolean : (Ljava/lang/String;Z)Z
    //   389: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Z
    //   392: new java/util/HashMap
    //   395: dup
    //   396: invokespecial <init> : ()V
    //   399: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i : Ljava/util/Map;
    //   402: getstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : Lorg/bukkit/configuration/file/FileConfiguration;
    //   405: sipush #8231
    //   408: sipush #11551
    //   411: invokestatic a : (II)Ljava/lang/String;
    //   414: aconst_null
    //   415: invokevirtual getString : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   418: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764j : Ljava/lang/String;
    //   421: iconst_0
    //   422: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764k : Z
    //   425: return
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0x2028) & 0xFFFF;
    if (b[i] == null) {
      char[] arrayOfChar = a[i].toCharArray();
      switch (arrayOfChar[0] & 0xFF) {
        case 0:
        
        case 1:
        
        case 2:
        
        case 3:
        
        case 4:
        
        case 5:
        
        case 6:
        
        case 7:
        
        case 8:
        
        case 9:
        
        case 10:
        
        case 11:
        
        case 12:
        
        case 13:
        
        case 14:
        
        case 15:
        
        case 16:
        
        case 17:
        
        case 18:
        
        case 19:
        
        case 20:
        
        case 21:
        
        case 22:
        
        case 23:
        
        case 24:
        
        case 25:
        
        case 26:
        
        case 27:
        
        case 28:
        
        case 29:
        
        case 30:
        
        case 31:
        
        case 32:
        
        case 33:
        
        case 34:
        
        case 35:
        
        case 36:
        
        case 37:
        
        case 38:
        
        case 39:
        
        case 40:
        
        case 41:
        
        case 42:
        
        case 43:
        
        case 44:
        
        case 45:
        
        case 46:
        
        case 47:
        
        case 48:
        
        case 49:
        
        case 50:
        
        case 51:
        
        case 52:
        
        case 53:
        
        case 54:
        
        case 55:
        
        case 56:
        
        case 57:
        
        case 58:
        
        case 59:
        
        case 60:
        
        case 61:
        
        case 62:
        
        case 63:
        
        case 64:
        
        case 65:
        
        case 66:
        
        case 67:
        
        case 68:
        
        case 69:
        
        case 70:
        
        case 71:
        
        case 72:
        
        case 73:
        
        case 74:
        
        case 75:
        
        case 76:
        
        case 77:
        
        case 78:
        
        case 79:
        
        case 80:
        
        case 81:
        
        case 82:
        
        case 83:
        
        case 84:
        
        case 85:
        
        case 86:
        
        case 87:
        
        case 88:
        
        case 89:
        
        case 90:
        
        case 91:
        
        case 92:
        
        case 93:
        
        case 94:
        
        case 95:
        
        case 96:
        
        case 97:
        
        case 98:
        
        case 99:
        
        case 100:
        
        case 101:
        
        case 102:
        
        case 103:
        
        case 104:
        
        case 105:
        
        case 106:
        
        case 107:
        
        case 108:
        
        case 109:
        
        case 110:
        
        case 111:
        
        case 112:
        
        case 113:
        
        case 114:
        
        case 115:
        
        case 116:
        
        case 117:
        
        case 118:
        
        case 119:
        
        case 120:
        
        case 121:
        
        case 122:
        
        case 123:
        
        case 124:
        
        case 125:
        
        case 126:
        
        case 127:
        
        case 128:
        
        case 129:
        
        case 130:
        
        case 131:
        
        case 132:
        
        case 133:
        
        case 134:
        
        case 135:
        
        case 136:
        
        case 137:
        
        case 138:
        
        case 139:
        
        case 140:
        
        case 141:
        
        case 142:
        
        case 143:
        
        case 144:
        
        case 145:
        
        case 146:
        
        case 147:
        
        case 148:
        
        case 149:
        
        case 150:
        
        case 151:
        
        case 152:
        
        case 153:
        
        case 154:
        
        case 155:
        
        case 156:
        
        case 157:
        
        case 158:
        
        case 159:
        
        case 160:
        
        case 161:
        
        case 162:
        
        case 163:
        
        case 164:
        
        case 165:
        
        case 166:
        
        case 167:
        
        case 168:
        
        case 169:
        
        case 170:
        
        case 171:
        
        case 172:
        
        case 173:
        
        case 174:
        
        case 175:
        
        case 176:
        
        case 177:
        
        case 178:
        
        case 179:
        
        case 180:
        
        case 181:
        
        case 182:
        
        case 183:
        
        case 184:
        
        case 185:
        
        case 186:
        
        case 187:
        
        case 188:
        
        case 189:
        
        case 190:
        
        case 191:
        
        case 192:
        
        case 193:
        
        case 194:
        
        case 195:
        
        case 196:
        
        case 197:
        
        case 198:
        
        case 199:
        
        case 200:
        
        case 201:
        
        case 202:
        
        case 203:
        
        case 204:
        
        case 205:
        
        case 206:
        
        case 207:
        
        case 208:
        
        case 209:
        
        case 210:
        
        case 211:
        
        case 212:
        
        case 213:
        
        case 214:
        
        case 215:
        
        case 216:
        
        case 217:
        
        case 218:
        
        case 219:
        
        case 220:
        
        case 221:
        
        case 222:
        
        case 223:
        
        case 224:
        
        case 225:
        
        case 226:
        
        case 227:
        
        case 228:
        
        case 229:
        
        case 230:
        
        case 231:
        
        case 232:
        
        case 233:
        
        case 234:
        
        case 235:
        
        case 236:
        
        case 237:
        
        case 238:
        
        case 239:
        
        case 240:
        
        case 241:
        
        case 242:
        
        case 243:
        
        case 244:
        
        case 245:
        
        case 246:
        
        case 247:
        
        case 248:
        
        case 249:
        
        case 250:
        
        case 251:
        
        case 252:
        
        case 253:
        
        case 254:
        
        default:
          break;
      } 
      char c = 'ü';
      int j = (paramInt2 & 0xFF) - c;
      if (j < 0)
        j += 256; 
      int k = ((paramInt2 & 0xFFFF) >>> 8) - c;
      if (k < 0)
        k += 256; 
      for (byte b = 0; b < arrayOfChar.length; b++) {
        int m = b % 2;
        if (m == 0) {
          arrayOfChar[b] = (char)(arrayOfChar[b] ^ j);
          j = ((j >>> 3 | j << 5) ^ arrayOfChar[b]) & 0xFF;
        } else {
          arrayOfChar[b] = (char)(arrayOfChar[b] ^ k);
          k = ((k >>> 3 | k << 5) ^ arrayOfChar[b]) & 0xFF;
        } 
      } 
      b[i] = (new String(arrayOfChar)).intern();
    } 
    return b[i];
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */