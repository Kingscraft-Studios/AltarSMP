package pl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.jetbrains.annotations.NotNull;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be implements CommandExecutor, Listener {
  private final Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private final Map<UUID, Set<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n>> You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = new HashMap<>();
  
  private BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c;
  
  private long You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d;
  
  public boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = false;
  
  private static final String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f = ChatColor.of("#B06736").toString() + ChatColor.BOLD.toString() + "Bingo Board";
  
  private static final int[] You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g = new int[] {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,18,19,20,21,22,23,24,25,27,28,29,30,31,32,33,34,36,37,38,39,40,41,42,43};
  
  public int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
    if ((You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.values()).length != 40)
      throw new IllegalStateException("Bingo must have exactly 40 quests."); 
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.length != 40)
        throw new IllegalStateException("Bingo must have exactly 40 quest slots."); 
    }}
  
  private static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack paramItemStack) {
    {
      if (paramItemStack == null)
        return false; 
    }return paramItemStack.getType().name().startsWith("MUSIC_DISC");
  }
  
  static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    int i = 0;
    for (ItemStack itemStack : paramPlayer.getInventory().getContents()) {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(itemStack))
        i += itemStack.getAmount(); 
    } 
    return i;
  }
  
  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      return true;
    } 
    {
      if (paramCommand.getName().equalsIgnoreCase("startbingo")) {
        {
          if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
            paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
            return true;
          } 
        }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
        return true;
      } 
    }{
      if (paramCommand.getName().equalsIgnoreCase("bingo")) {
        {
          if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
            player.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
            return true;
          } 
        }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player);
        return true;
      } 
    }return false;
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0() {
    {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = null;
      } 
    }this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = true;
    int i = Main.getInstance().getConfig().getInt("bingoTime", 60) * 60;
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = i * 20;
    Main.getInstance().getConfig().set("bingoActive", Boolean.valueOf(true));
    Main.getInstance().saveConfig();
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.clear();
    for (Player player : Bukkit.getOnlinePlayers()) {
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(player.getUniqueId(), EnumSet.noneOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.class));
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(player);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a("Bingo Time Remaining:", i, BarColor.PURPLE);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gc(this);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 20L, 20L);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = false;
    Main.getInstance().getConfig().set("bingoActive", Boolean.valueOf(false));
    Main.getInstance().saveConfig();
    for (Player player : Bukkit.getOnlinePlayers())
      player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard()); 
    {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = null;
      } 
    }}
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    }{
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer) < (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.values()).length)
        return; 
    }String str1 = String.valueOf(ChatColor.GRAY);
    String str2 = paramPlayer.getName();
    String str3 = String.valueOf(ChatColor.WHITE);
    String str4 = String.valueOf(ChatColor.RESET);
    {
      Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.of("#B06736")) + "Bingo Event" + str4 + " was automatically finished because " + str3 + str2 + str1);
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = null;
      } 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(Player paramPlayer) {
    Set<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n> set = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.computeIfAbsent(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be::lambda$check$0);
    boolean bool = false;
    for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n : You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.values()) {
      {
        if (!set.contains(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n))
          {
            if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g != null) {
              if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n)) {
                set.add(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n);
                bool = true;
                String str1 = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
                String str2 = String.valueOf(ChatColor.WHITE);
                paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + "Completed bingo objective: " + str2);
                paramPlayer.playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8F, 1.2F);
              } 
            } else {
              {
                if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d == You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764o.COLLECT)
                  {
                    if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e != null) {
                      int i = 0;
                      for (ItemStack itemStack : paramPlayer.getInventory().getContents()) {
                        {
                          if (itemStack != null && itemStack.getType() == you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
                            i += itemStack.getAmount(); 
                        }} 
                      if (i >= you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f) {
                        set.add(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n);
                        bool = true;
                        String str1 = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
                        String str2 = String.valueOf(ChatColor.WHITE);
                        paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + "Completed bingo objective: " + str2);
                        paramPlayer.playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8F, 1.2F);
                      } 
                    } 
                  }}} 
          }}} 
    {
      if (bool) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
      } 
    }}
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 54, String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.BOLD));
    ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(" ");
    itemStack.setItemMeta(itemMeta);
    byte b1 = 0;
    {
      while (b1 < 54) {
        inventory.setItem(b1, itemStack);
        b1++;
      } 
    }You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n[] arrayOfYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.values();
    Set set = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.getOrDefault(paramPlayer.getUniqueId(), EnumSet.noneOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.class));
    for (byte b2 = 0; b2 < arrayOfYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.length; b2++) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n = arrayOfYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n[b2];
      boolean bool = set.contains(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n);
      {
      
      }ItemStack itemStack1 = new ItemStack(bool ? Material.BARRIER : you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
      ItemMeta itemMeta1 = itemStack1.getItemMeta();
      {
        if (bool) {
          itemMeta1.setDisplayName(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN));
          itemMeta1.setLore(List.of(String.valueOf(ChatColor.WHITE) + String.valueOf(ChatColor.WHITE), String.valueOf(ChatColor.GRAY) + String.valueOf(ChatColor.GRAY), " ", String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN)));
        } else {
          itemMeta1.setDisplayName(String.valueOf(ChatColor.GOLD) + String.valueOf(ChatColor.GOLD));
          itemMeta1.setLore(List.of(String.valueOf(ChatColor.WHITE) + String.valueOf(ChatColor.WHITE), String.valueOf(ChatColor.GRAY) + String.valueOf(ChatColor.GRAY) + "Required amount: ", " ", String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED)));
        } 
      }itemStack1.setItemMeta(itemMeta1);
      inventory.setItem(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g[b2], itemStack1);
    } 
    paramPlayer.openInventory(inventory);
    paramPlayer.playSound(paramPlayer.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c() {
    if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
      for (Player player : Bukkit.getOnlinePlayers())
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard()); 
      return;
    } 
    for (Player player : Bukkit.getOnlinePlayers()) {
      Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
      Objective objective = scoreboard.registerNewObjective("bingo", "dummy", String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.of("#B06736")));
      objective.setDisplaySlot(DisplaySlot.SIDEBAR);
      List list = (List)Bukkit.getOnlinePlayers().stream().sorted(Comparator.comparingInt((Player paramPlayer1) -> this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer1)).reversed().thenComparing(Player::getName, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList());
      byte b1 = 15;
      byte b2 = 1;
      for (Player player1 : (Iterable<Player>)(Iterable<?>)list) {
        {
          if (b2 > 10)
            break; 
        }String str1 = ChatColor.values()[Math.min(b2, (ChatColor.values()).length - 1)].toString() + ChatColor.values()[Math.min(b2, (ChatColor.values()).length - 1)].toString();
        Team team = scoreboard.registerNewTeam("t" + b2);
        team.addEntry(str1);
        int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player1);
        String str2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player1.getName(), 10);
        String str3 = String.valueOf(ChatColor.WHITE);
        byte b = b2;
        team.setPrefix(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(String.valueOf(ChatColor.GOLD) + String.valueOf(ChatColor.GOLD) + b + ". " + str3, 16));
        team.setSuffix(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(String.valueOf(ChatColor.GRAY) + String.valueOf(ChatColor.GRAY) + " " + i, 16));
        objective.getScore(str1).setScore(b1--);
        b2++;
      } 
      player.setScoreboard(scoreboard);
    } 
  }
  
  private int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    return ((Set)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.getOrDefault(paramPlayer.getUniqueId(), Collections.emptySet())).size();
  }
  
  private String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(String paramString, int paramInt) {
    {
    
    }return (paramString.length() <= paramInt) ? paramString : paramString.substring(0, paramInt);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(Player paramPlayer) {
    ItemStack itemStack = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    boolean bool = Arrays.<ItemStack>stream(paramPlayer.getInventory().getContents()).filter(Objects::nonNull).anyMatch(paramItem -> lambda$giveCard$1(itemStack, paramItem));
    {
      if (!bool)
        paramPlayer.getInventory().addItem(new ItemStack[] { itemStack }); 
    }}
  
  private ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    ItemStack itemStack = new ItemStack(Material.BOOK);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.addEnchant(Enchantment.UNBREAKING, 1, true);
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.BOLD));
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(" ");
    arrayList.add(String.valueOf(ChatColor.WHITE) + String.valueOf(ChatColor.WHITE) + "RIGHT CLICK " + String.valueOf(ChatColor.GRAY));
    itemMeta.setLore(arrayList);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(InventoryClickEvent paramInventoryClickEvent) {
    {
      if (!paramInventoryClickEvent.getView().getTitle().contains("Bingo Board"))
        return; 
    }paramInventoryClickEvent.setCancelled(true);
    ((Player)paramInventoryClickEvent.getWhoClicked()).updateInventory();
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent paramPlayerInteractEvent) {
    {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    }{
      if (paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
        ItemStack itemStack = paramPlayerInteractEvent.getPlayer().getInventory().getItemInMainHand();
        {
          if (itemStack != null)
            {
              if (itemStack.getType() != Material.AIR)
                {
                  if (itemStack.isSimilar(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a())) {
                    paramPlayerInteractEvent.setCancelled(true);
                    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayerInteractEvent.getPlayer());
                  } 
                }}}} 
    }}
  
  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent paramPlayerDeathEvent) {
    {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    }Player player1 = paramPlayerDeathEvent.getEntity();
    Player player2 = player1.getKiller();
    {
      if (player2 == null)
        return; 
    }{
      if (player2.getUniqueId().equals(player1.getUniqueId()))
        return; 
    }{
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player2, player1))
        return; 
    }Set<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n> set = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.computeIfAbsent(player2.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be::lambda$death$2);
    {
      if (set.contains(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.SLAYER))
        return; 
    }set.add(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.SLAYER);
    String str1 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.SLAYER.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
    String str2 = String.valueOf(ChatColor.WHITE);
    player2.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + "Completed bingo objective: " + str2);
    player2.playSound(player2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8F, 1.2F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player2);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJoinEvent paramPlayerJoinEvent) {
    {
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.putIfAbsent(paramPlayerJoinEvent.getPlayer().getUniqueId(), EnumSet.noneOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.class));
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(paramPlayerJoinEvent.getPlayer());
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayerJoinEvent.getPlayer());
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
      } else {
        paramPlayerJoinEvent.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
      } 
    }}
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerQuitEvent paramPlayerQuitEvent) {
    {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    }paramPlayerQuitEvent.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    Bukkit.getScheduler().runTaskLater((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, (Runnable)this::You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, 1L);
  }
  
  private static Set lambda$death$2(UUID paramUUID) {
    return EnumSet.noneOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.class);
  }
  
  private static boolean lambda$giveCard$1(ItemStack paramItemStack1, ItemStack paramItemStack2) {
    return paramItemStack2.isSimilar(paramItemStack1);
  }
  
  private static Set lambda$check$0(UUID paramUUID) {
    return EnumSet.noneOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.class);
  }

  
  private static IllegalStateException a(IllegalStateException paramIllegalStateException) {
    return paramIllegalStateException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */