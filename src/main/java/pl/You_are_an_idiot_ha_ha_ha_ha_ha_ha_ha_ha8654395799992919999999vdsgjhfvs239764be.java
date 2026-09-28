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
  
  private static final String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f;
  
  private static final int[] You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g;
  
  public int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h;
  
  private static final String[] a;
  
  private static final String[] b;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
    if ((You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.values()).length != 40)
      throw new IllegalStateException(a(2158, 4962)); 
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.length != 40)
        throw new IllegalStateException(a(2169, -7081)); 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
  }
  
  private static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(ItemStack paramItemStack) {
    try {
      if (paramItemStack == null)
        return false; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    return paramItemStack.getType().name().startsWith(a(2144, 25810));
  }
  
  private static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
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
    try {
      if (paramCommand.getName().equalsIgnoreCase(a(2170, 22800))) {
        try {
          if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
            paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
            return true;
          } 
        } catch (IllegalStateException illegalStateException) {
          throw a(null);
        } 
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
        return true;
      } 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    try {
      if (paramCommand.getName().equalsIgnoreCase(a(2163, 8164))) {
        try {
          if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
            player.sendMessage(String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED));
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
            return true;
          } 
        } catch (IllegalStateException illegalStateException) {
          throw a(null);
        } 
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(player);
        return true;
      } 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    return false;
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0() {
    try {
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = null;
      } 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = true;
    int i = Main.getInstance().getConfig().getInt(a(2155, 13354), 60) * 60;
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764h = i * 20;
    Main.getInstance().getConfig().set(a(2152, 4861), Boolean.valueOf(true));
    Main.getInstance().saveConfig();
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.clear();
    for (Player player : Bukkit.getOnlinePlayers()) {
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.put(player.getUniqueId(), EnumSet.noneOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.class));
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(player);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(a(2157, 18260), i, BarColor.PURPLE);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gc(this);
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 20L, 20L);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b() {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e = false;
    Main.getInstance().getConfig().set(a(2151, -23837), Boolean.valueOf(false));
    Main.getInstance().saveConfig();
    for (Player player : Bukkit.getOnlinePlayers())
      player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard()); 
    try {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = null;
      } 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    try {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer) < (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.values()).length)
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    String str1 = String.valueOf(ChatColor.GRAY);
    String str2 = paramPlayer.getName();
    String str3 = String.valueOf(ChatColor.WHITE);
    String str4 = String.valueOf(ChatColor.RESET);
    try {
      Bukkit.broadcastMessage(String.valueOf(ChatColor.of(a(2174, 29539))) + String.valueOf(ChatColor.of(a(2174, 29539))) + a(2154, 18166) + str4 + a(2165, 32026) + str3 + str2 + str1);
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c != null) {
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c.cancel();
        this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c = null;
      } 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(Player paramPlayer) {
    Set<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n> set = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.computeIfAbsent(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be::lambda$check$0);
    boolean bool = false;
    for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n : You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.values()) {
      try {
        if (!set.contains(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n))
          try {
            if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g != null) {
              if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n)) {
                set.add(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n);
                bool = true;
                String str1 = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
                String str2 = String.valueOf(ChatColor.WHITE);
                paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + a(2162, 7950) + str2);
                paramPlayer.playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8F, 1.2F);
              } 
            } else {
              try {
                if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d == You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764o.COLLECT)
                  try {
                    if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e != null) {
                      int i = 0;
                      for (ItemStack itemStack : paramPlayer.getInventory().getContents()) {
                        try {
                          if (itemStack != null && itemStack.getType() == you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
                            i += itemStack.getAmount(); 
                        } catch (IllegalStateException illegalStateException) {
                          throw a(null);
                        } 
                      } 
                      if (i >= you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f) {
                        set.add(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n);
                        bool = true;
                        String str1 = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
                        String str2 = String.valueOf(ChatColor.WHITE);
                        paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + a(2162, 7950) + str2);
                        paramPlayer.playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8F, 1.2F);
                      } 
                    } 
                  } catch (IllegalStateException illegalStateException) {
                    throw a(null);
                  }  
              } catch (IllegalStateException illegalStateException) {
                throw a(null);
              } 
            } 
          } catch (IllegalStateException illegalStateException) {
            throw a(null);
          }  
      } catch (IllegalStateException illegalStateException) {
        throw a(null);
      } 
    } 
    try {
      if (bool) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
      } 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 54, String.valueOf(ChatColor.of(a(2147, 26467))) + String.valueOf(ChatColor.of(a(2147, 26467))) + String.valueOf(ChatColor.BOLD));
    ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(" ");
    itemStack.setItemMeta(itemMeta);
    byte b1 = 0;
    try {
      while (b1 < 54) {
        inventory.setItem(b1, itemStack);
        b1++;
      } 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n[] arrayOfYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.values();
    Set set = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.getOrDefault(paramPlayer.getUniqueId(), EnumSet.noneOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.class));
    for (byte b2 = 0; b2 < arrayOfYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.length; b2++) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n = arrayOfYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n[b2];
      boolean bool = set.contains(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n);
      try {
      
      } catch (IllegalStateException illegalStateException) {
        throw a(null);
      } 
      ItemStack itemStack1 = new ItemStack(bool ? Material.BARRIER : you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
      ItemMeta itemMeta1 = itemStack1.getItemMeta();
      try {
        if (bool) {
          itemMeta1.setDisplayName(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN));
          itemMeta1.setLore(List.of(String.valueOf(ChatColor.WHITE) + String.valueOf(ChatColor.WHITE), String.valueOf(ChatColor.GRAY) + String.valueOf(ChatColor.GRAY), " ", String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN)));
        } else {
          itemMeta1.setDisplayName(String.valueOf(ChatColor.GOLD) + String.valueOf(ChatColor.GOLD));
          itemMeta1.setLore(List.of(String.valueOf(ChatColor.WHITE) + String.valueOf(ChatColor.WHITE), String.valueOf(ChatColor.GRAY) + String.valueOf(ChatColor.GRAY) + a(2159, -236), " ", String.valueOf(ChatColor.RED) + String.valueOf(ChatColor.RED)));
        } 
      } catch (IllegalStateException illegalStateException) {
        throw a(null);
      } 
      itemStack1.setItemMeta(itemMeta1);
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
      Objective objective = scoreboard.registerNewObjective(a(2175, -16172), a(2166, 14053), String.valueOf(ChatColor.of(a(2147, 26467))) + String.valueOf(ChatColor.of(a(2147, 26467))));
      objective.setDisplaySlot(DisplaySlot.SIDEBAR);
      List list = (List)Bukkit.getOnlinePlayers().stream().sorted(Comparator.comparingInt(this::You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b).reversed().thenComparing(Player::getName, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList());
      byte b1 = 15;
      byte b2 = 1;
      for (Player player1 : list) {
        try {
          if (b2 > 10)
            break; 
        } catch (IllegalStateException illegalStateException) {
          throw a(null);
        } 
        String str1 = ChatColor.values()[Math.min(b2, (ChatColor.values()).length - 1)].toString() + ChatColor.values()[Math.min(b2, (ChatColor.values()).length - 1)].toString();
        Team team = scoreboard.registerNewTeam("t" + b2);
        team.addEntry(str1);
        int i = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player1);
        String str2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player1.getName(), 10);
        String str3 = String.valueOf(ChatColor.WHITE);
        byte b = b2;
        team.setPrefix(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(String.valueOf(ChatColor.GOLD) + String.valueOf(ChatColor.GOLD) + b + a(2161, -15282) + str3, 16));
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
    try {
    
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    return (paramString.length() <= paramInt) ? paramString : paramString.substring(0, paramInt);
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(Player paramPlayer) {
    ItemStack itemStack = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    boolean bool = Arrays.<ItemStack>stream(paramPlayer.getInventory().getContents()).filter(Objects::nonNull).anyMatch(paramItem -> lambda$giveCard$1(itemStack, paramItem));
    try {
      if (!bool)
        paramPlayer.getInventory().addItem(new ItemStack[] { itemStack }); 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
  }
  
  private ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    ItemStack itemStack = new ItemStack(Material.BOOK);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.addEnchant(Enchantment.UNBREAKING, 1, true);
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    itemMeta.setDisplayName(String.valueOf(ChatColor.of(a(2147, 26467))) + String.valueOf(ChatColor.of(a(2147, 26467))) + String.valueOf(ChatColor.BOLD));
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(" ");
    arrayList.add(String.valueOf(ChatColor.WHITE) + String.valueOf(ChatColor.WHITE) + a(2168, -26521) + String.valueOf(ChatColor.GRAY));
    itemMeta.setLore(arrayList);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(InventoryClickEvent paramInventoryClickEvent) {
    try {
      if (!paramInventoryClickEvent.getView().getTitle().contains(a(2156, -22586)))
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    paramInventoryClickEvent.setCancelled(true);
    ((Player)paramInventoryClickEvent.getWhoClicked()).updateInventory();
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent paramPlayerInteractEvent) {
    try {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    try {
      if (paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
        ItemStack itemStack = paramPlayerInteractEvent.getPlayer().getInventory().getItemInMainHand();
        try {
          if (itemStack != null)
            try {
              if (itemStack.getType() != Material.AIR)
                try {
                  if (itemStack.isSimilar(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a())) {
                    paramPlayerInteractEvent.setCancelled(true);
                    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayerInteractEvent.getPlayer());
                  } 
                } catch (IllegalStateException illegalStateException) {
                  throw a(null);
                }  
            } catch (IllegalStateException illegalStateException) {
              throw a(null);
            }  
        } catch (IllegalStateException illegalStateException) {
          throw a(null);
        } 
      } 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
  }
  
  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerDeathEvent paramPlayerDeathEvent) {
    try {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    Player player1 = paramPlayerDeathEvent.getEntity();
    Player player2 = player1.getKiller();
    try {
      if (player2 == null)
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    try {
      if (player2.getUniqueId().equals(player1.getUniqueId()))
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    try {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player2, player1))
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    Set<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n> set = this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.computeIfAbsent(player2.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be::lambda$death$2);
    try {
      if (set.contains(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.SLAYER))
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    set.add(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.SLAYER);
    String str1 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.SLAYER.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;
    String str2 = String.valueOf(ChatColor.WHITE);
    player2.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + a(2145, 13054) + str2);
    player2.playSound(player2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8F, 1.2F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player2);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerJoinEvent paramPlayerJoinEvent) {
    try {
      this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.putIfAbsent(paramPlayerJoinEvent.getPlayer().getUniqueId(), EnumSet.noneOf(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764n.class));
      if (this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(paramPlayerJoinEvent.getPlayer());
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayerJoinEvent.getPlayer());
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
      } else {
        paramPlayerJoinEvent.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
      } 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerQuitEvent paramPlayerQuitEvent) {
    try {
      if (!this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e)
        return; 
    } catch (IllegalStateException illegalStateException) {
      throw a(null);
    } 
    paramPlayerQuitEvent.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    Bukkit.getScheduler().runTaskLater((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, this::You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, 1L);
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
  
  static {
    // Byte code:
    //   0: bipush #32
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'Ì{|¡P➫ò3VNÚßUE´ \\féôqõm4\\nôÔöJ'\\bÿvÙê¼Ã4ÄøÑèAú àoÇ¼TX¡Ä·Ü8eáOW" ?ÞTû,Ñ­\ÔoÂÌq]ªØHIó`pÉ\\tçø´åýêT;VÛ'Rã&µ6ýÅFûIS[ôáÇgMRú*H©ÏB_*hÝyÔ$~²ú4{]\\b!áù9â EþIK!µD¡«ô=-XdE®'6YKø \\tUà%lÖ®~5õ$ú[\\tÂË$ÝoõTð¸Å\\r:L­JÚêèÜXÊU²Ú·©:°0v×g))Û\\tÝbÛ[è¾,÷@«j§;kû\\brWjn6.¬"b©;Up³è¡,}rÔ©]"\\r\\r1s¡ÀIk×Ørï4k[$ü}¥Y³¯|møÚLö!Z_¨ìiêMJ°÷] \\bTò9Kôqo)í_BSô#O<Â¤õvnÌ;±" ½ÞÆT\\næ9xÒ®×ÒÈÕ)»"ó3×ýÉv¯<¾lnþèóo\\brc7❦´\\nÜ_¦nk#87gñ·@r'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: bipush #10
    //   20: istore_1
    //   21: iconst_m1
    //   22: istore_0
    //   23: bipush #48
    //   25: iinc #0, 1
    //   28: aload_2
    //   29: iload_0
    //   30: dup
    //   31: iload_1
    //   32: iadd
    //   33: invokevirtual substring : (II)Ljava/lang/String;
    //   36: iconst_m1
    //   37: goto -> 143
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
    //   68: ldc 'õ3(ê6{õg6Ñs¸\\ré[Û|/.ÔE[©\\nÀµÒYW&'
    //   70: dup
    //   71: astore_2
    //   72: invokevirtual length : ()I
    //   75: istore #4
    //   77: bipush #30
    //   79: istore_1
    //   80: iconst_m1
    //   81: istore_0
    //   82: bipush #109
    //   84: iinc #0, 1
    //   87: aload_2
    //   88: iload_0
    //   89: dup
    //   90: iload_1
    //   91: iadd
    //   92: invokevirtual substring : (II)Ljava/lang/String;
    //   95: iconst_0
    //   96: goto -> 143
    //   99: aload #5
    //   101: swap
    //   102: iload_3
    //   103: iinc #3, 1
    //   106: swap
    //   107: aastore
    //   108: iload_0
    //   109: iload_1
    //   110: iadd
    //   111: dup
    //   112: istore_0
    //   113: iload #4
    //   115: if_icmpge -> 127
    //   118: aload_2
    //   119: iload_0
    //   120: invokevirtual charAt : (I)C
    //   123: istore_1
    //   124: goto -> 82
    //   127: aload #5
    //   129: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be.a : [Ljava/lang/String;
    //   132: bipush #32
    //   134: anewarray java/lang/String
    //   137: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be.b : [Ljava/lang/String;
    //   140: goto -> 300
    //   143: dup_x2
    //   144: pop
    //   145: invokevirtual toCharArray : ()[C
    //   148: dup_x1
    //   149: arraylength
    //   150: dup_x2
    //   151: pop
    //   152: iconst_0
    //   153: istore #6
    //   155: dup2_x1
    //   156: pop2
    //   157: dup_x2
    //   158: iconst_1
    //   159: if_icmpgt -> 260
    //   162: dup2
    //   163: swap
    //   164: iload #6
    //   166: dup2_x1
    //   167: caload
    //   168: swap
    //   169: iload #6
    //   171: bipush #7
    //   173: irem
    //   174: tableswitch default -> 242, 0 -> 212, 1 -> 217, 2 -> 222, 3 -> 227, 4 -> 232, 5 -> 237
    //   212: bipush #24
    //   214: goto -> 244
    //   217: bipush #73
    //   219: goto -> 244
    //   222: bipush #38
    //   224: goto -> 244
    //   227: bipush #92
    //   229: goto -> 244
    //   232: bipush #41
    //   234: goto -> 244
    //   237: bipush #15
    //   239: goto -> 244
    //   242: bipush #123
    //   244: ixor
    //   245: ixor
    //   246: i2c
    //   247: castore
    //   248: iinc #6, 1
    //   251: dup
    //   252: ifne -> 260
    //   255: dup2
    //   256: dup_x1
    //   257: goto -> 166
    //   260: dup2_x1
    //   261: pop2
    //   262: dup_x2
    //   263: iload #6
    //   265: if_icmpgt -> 162
    //   268: pop
    //   269: new java/lang/String
    //   272: dup_x1
    //   273: swap
    //   274: invokespecial <init> : ([C)V
    //   277: invokevirtual intern : ()Ljava/lang/String;
    //   280: swap
    //   281: pop
    //   282: swap
    //   283: tableswitch default -> 40, 0 -> 99
    //   300: sipush #2147
    //   303: sipush #26467
    //   306: invokestatic a : (II)Ljava/lang/String;
    //   309: invokestatic of : (Ljava/lang/String;)Lnet/md_5/bungee/api/ChatColor;
    //   312: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   315: getstatic net/md_5/bungee/api/ChatColor.BOLD : Lnet/md_5/bungee/api/ChatColor;
    //   318: invokestatic valueOf : (Ljava/lang/Object;)Ljava/lang/String;
    //   321: sipush #2153
    //   324: sipush #-23628
    //   327: invokestatic a : (II)Ljava/lang/String;
    //   330: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   335: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f : Ljava/lang/String;
    //   338: bipush #40
    //   340: newarray int
    //   342: dup
    //   343: iconst_0
    //   344: iconst_0
    //   345: iastore
    //   346: dup
    //   347: iconst_1
    //   348: iconst_1
    //   349: iastore
    //   350: dup
    //   351: iconst_2
    //   352: iconst_2
    //   353: iastore
    //   354: dup
    //   355: iconst_3
    //   356: iconst_3
    //   357: iastore
    //   358: dup
    //   359: iconst_4
    //   360: iconst_4
    //   361: iastore
    //   362: dup
    //   363: iconst_5
    //   364: iconst_5
    //   365: iastore
    //   366: dup
    //   367: bipush #6
    //   369: bipush #6
    //   371: iastore
    //   372: dup
    //   373: bipush #7
    //   375: bipush #7
    //   377: iastore
    //   378: dup
    //   379: bipush #8
    //   381: bipush #9
    //   383: iastore
    //   384: dup
    //   385: bipush #9
    //   387: bipush #10
    //   389: iastore
    //   390: dup
    //   391: bipush #10
    //   393: bipush #11
    //   395: iastore
    //   396: dup
    //   397: bipush #11
    //   399: bipush #12
    //   401: iastore
    //   402: dup
    //   403: bipush #12
    //   405: bipush #13
    //   407: iastore
    //   408: dup
    //   409: bipush #13
    //   411: bipush #14
    //   413: iastore
    //   414: dup
    //   415: bipush #14
    //   417: bipush #15
    //   419: iastore
    //   420: dup
    //   421: bipush #15
    //   423: bipush #16
    //   425: iastore
    //   426: dup
    //   427: bipush #16
    //   429: bipush #18
    //   431: iastore
    //   432: dup
    //   433: bipush #17
    //   435: bipush #19
    //   437: iastore
    //   438: dup
    //   439: bipush #18
    //   441: bipush #20
    //   443: iastore
    //   444: dup
    //   445: bipush #19
    //   447: bipush #21
    //   449: iastore
    //   450: dup
    //   451: bipush #20
    //   453: bipush #22
    //   455: iastore
    //   456: dup
    //   457: bipush #21
    //   459: bipush #23
    //   461: iastore
    //   462: dup
    //   463: bipush #22
    //   465: bipush #24
    //   467: iastore
    //   468: dup
    //   469: bipush #23
    //   471: bipush #25
    //   473: iastore
    //   474: dup
    //   475: bipush #24
    //   477: bipush #27
    //   479: iastore
    //   480: dup
    //   481: bipush #25
    //   483: bipush #28
    //   485: iastore
    //   486: dup
    //   487: bipush #26
    //   489: bipush #29
    //   491: iastore
    //   492: dup
    //   493: bipush #27
    //   495: bipush #30
    //   497: iastore
    //   498: dup
    //   499: bipush #28
    //   501: bipush #31
    //   503: iastore
    //   504: dup
    //   505: bipush #29
    //   507: bipush #32
    //   509: iastore
    //   510: dup
    //   511: bipush #30
    //   513: bipush #33
    //   515: iastore
    //   516: dup
    //   517: bipush #31
    //   519: bipush #34
    //   521: iastore
    //   522: dup
    //   523: bipush #32
    //   525: bipush #36
    //   527: iastore
    //   528: dup
    //   529: bipush #33
    //   531: bipush #37
    //   533: iastore
    //   534: dup
    //   535: bipush #34
    //   537: bipush #38
    //   539: iastore
    //   540: dup
    //   541: bipush #35
    //   543: bipush #39
    //   545: iastore
    //   546: dup
    //   547: bipush #36
    //   549: bipush #40
    //   551: iastore
    //   552: dup
    //   553: bipush #37
    //   555: bipush #41
    //   557: iastore
    //   558: dup
    //   559: bipush #38
    //   561: bipush #42
    //   563: iastore
    //   564: dup
    //   565: bipush #39
    //   567: bipush #43
    //   569: iastore
    //   570: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g : [I
    //   573: return
  }
  
  private static IllegalStateException a(IllegalStateException paramIllegalStateException) {
    return paramIllegalStateException;
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0x87A) & 0xFFFF;
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
      byte b1 = 101;
      int j = (paramInt2 & 0xFF) - b1;
      if (j < 0)
        j += 256; 
      int k = ((paramInt2 & 0xFFFF) >>> 8) - b1;
      if (k < 0)
        k += 256; 
      for (byte b2 = 0; b2 < arrayOfChar.length; b2++) {
        int m = b2 % 2;
        if (m == 0) {
          arrayOfChar[b2] = (char)(arrayOfChar[b2] ^ j);
          j = ((j >>> 3 | j << 5) ^ arrayOfChar[b2]) & 0xFF;
        } else {
          arrayOfChar[b2] = (char)(arrayOfChar[b2] ^ k);
          k = ((k >>> 3 | k << 5) ^ arrayOfChar[b2]) & 0xFF;
        } 
      } 
      b[i] = (new String(arrayOfChar)).intern();
    } 
    return b[i];
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */