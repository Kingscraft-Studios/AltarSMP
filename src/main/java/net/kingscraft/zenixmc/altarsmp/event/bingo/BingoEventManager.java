package net.kingscraft.zenixmc.altarsmp.event.bingo;

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
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.trust.TrustManager;

public class BingoEventManager implements CommandExecutor, Listener {
  public final AltarSMP plugin;

  private final Map<UUID, Set<BingoQuestType>> playerCompletedQuests = new HashMap<>();

  public BukkitRunnable countdownTask;

  public long eventStartTimestamp;

  public boolean isBingoRunning = false;

  private static final String BINGO_BOARD_TITLE =String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.BOLD) + "Bingo Board";

  private static final int[] BINGO_SLOT_INDICES = new int[] {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,18,19,20,21,22,23,24,25,27,28,29,30,31,32,33,34,36,37,38,39,40,41,42,43};

  public int remainingTimeTicks;


  public BingoEventManager(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    if ((BingoQuestType.values()).length != 40)
      throw new IllegalStateException("Bingo must have exactly 40 quests."); 
    {
      if (BINGO_SLOT_INDICES.length != 40)
        throw new IllegalStateException("Bingo must have exactly 40 quest slots."); 
    }}

  public static boolean isMusicDisc(ItemStack paramItemStack) {
    {
      if (paramItemStack == null)
        return false; 
    }return paramItemStack.getType().name().startsWith("MUSIC_DISC");
  }

  public static int countMusicDiscs(Player paramPlayer) {
    int i = 0;
    for (ItemStack itemStack : paramPlayer.getInventory().getContents()) {
      if (isMusicDisc(itemStack))
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
          if (this.isBingoRunning) {
            paramCommandSender.sendMessage(String.valueOf(ChatColor.RED) + "Bingo is already running.");
            return true;
          } 
        }
        startBingoEvent();
        return true;
      } 
    }{
      if (paramCommand.getName().equalsIgnoreCase("bingo")) {
        {
          if (!this.isBingoRunning) {
            player.sendMessage(String.valueOf(ChatColor.RED) + "Bingo event did not start yet.");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
            return true;
          } 
        }
        openBingoBoard(player);
        return true;
      } 
    }return false;
  }

  public void startBingoEvent() {
    {
      if (this.countdownTask != null) {
        this.countdownTask.cancel();
        this.countdownTask = null;
      } 
    }this.isBingoRunning = true;
    int i = AltarSMP.getInstance().getConfig().getInt("bingoTime", 60) * 60;
    this.remainingTimeTicks = i * 20;
    AltarSMP.getInstance().getConfig().set("bingoActive", Boolean.valueOf(true));
    AltarSMP.getInstance().saveConfig();
    this.playerCompletedQuests.clear();
    for (Player player : Bukkit.getOnlinePlayers()) {
      this.playerCompletedQuests.put(player.getUniqueId(), EnumSet.noneOf(BingoQuestType.class));
      giveBingoCard(player);
    } 
    BossBarManager.showBingoBar("Bingo Time Remaining:", i, BarColor.PURPLE);
    updateBingoScoreboards();
    this.countdownTask = new BingoEventCountdownTask(this);
    this.countdownTask.runTaskTimer((Plugin)this.plugin, 20L, 20L);
  }

  public void stopBingoEvent() {
    this.isBingoRunning = false;
    AltarSMP.getInstance().getConfig().set("bingoActive", Boolean.valueOf(false));
    AltarSMP.getInstance().saveConfig();
    for (Player player : Bukkit.getOnlinePlayers())
      player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard()); 
    {
      BossBarManager.hideBingoBar();
      updateBingoScoreboards();
      if (this.countdownTask != null) {
        this.countdownTask.cancel();
        this.countdownTask = null;
      } 
    }}

  public void checkBingoCompletion(Player paramPlayer) {
    {
      if (!this.isBingoRunning)
        return; 
    }{
      if (getCompletedQuestCount(paramPlayer) < (BingoQuestType.values()).length)
        return; 
    }{
      Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + "Bingo Event" + String.valueOf(ChatColor.RESET) + " was automatically finished because " + String.valueOf(ChatColor.WHITE) + paramPlayer.getName() + String.valueOf(ChatColor.GRAY) + " completed all 40/40 quests.");
      if (this.countdownTask != null) {
        this.countdownTask.cancel();
        this.countdownTask = null;
      } 
    }
    stopBingoEvent();
  }

  public void checkPlayerQuests(Player paramPlayer) {
    Set<BingoQuestType> set = this.playerCompletedQuests.computeIfAbsent(paramPlayer.getUniqueId(), BingoEventManager::lambda$check$0);
    boolean bool = false;
    for (BingoQuestType bingoQuestType : BingoQuestType.values()) {
      {
        if (!set.contains(bingoQuestType))
          {
            if (bingoQuestType.completionCondition != null) {
              if (bingoQuestType.completionCondition.isCompleted(paramPlayer, bingoQuestType)) {
                set.add(bingoQuestType);
                bool = true;
                String str1 = bingoQuestType.displayName;
                String str2 = String.valueOf(ChatColor.WHITE);
                paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + "Completed bingo objective: " + str2 + str1);
                paramPlayer.playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8F, 1.2F);
              } 
            } else {
              {
                if (bingoQuestType.questType == BingoQuestCategory.COLLECT)
                  {
                    if (bingoQuestType.targetMaterial != null) {
                      int i = 0;
                      for (ItemStack itemStack : paramPlayer.getInventory().getContents()) {
                        {
                          if (itemStack != null && itemStack.getType() == bingoQuestType.targetMaterial)
                            i += itemStack.getAmount(); 
                        }} 
                      if (i >= bingoQuestType.requiredAmount) {
                        set.add(bingoQuestType);
                        bool = true;
                        String str1 = bingoQuestType.displayName;
                        String str2 = String.valueOf(ChatColor.WHITE);
                        paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + "Completed bingo objective: " + str2 + str1);
                        paramPlayer.playSound(paramPlayer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8F, 1.2F);
                      } 
                    } 
                  }}} 
          }}} 
    {
      if (bool) {
        updateBingoScoreboards();
        countMusicDiscs(paramPlayer);
      } 
    }}

  public void openBingoBoard(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 54,String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.BOLD) + "Bingo Board");
    ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(" ");
    itemStack.setItemMeta(itemMeta);
    int b1 = 0;
    {
      while (b1 < 54) {
        inventory.setItem(b1, itemStack);
        b1++;
      } 
    }
    BingoQuestType[] bingoQuestTypes = BingoQuestType.values();
    Set set = this.playerCompletedQuests.getOrDefault(paramPlayer.getUniqueId(), EnumSet.noneOf(BingoQuestType.class));
    for (int b2 = 0; b2 < bingoQuestTypes.length; b2++) {
      BingoQuestType bingoQuestType = bingoQuestTypes[b2];
      boolean bool = set.contains(bingoQuestType);
      {

      }ItemStack itemStack1 = new ItemStack(bool ? Material.BARRIER : bingoQuestType.displayMaterial);
      ItemMeta itemMeta1 = itemStack1.getItemMeta();
      {
        if (bool) {
          itemMeta1.setDisplayName(String.valueOf(ChatColor.GREEN) + bingoQuestType.displayName);
          itemMeta1.setLore(List.of(String.valueOf(ChatColor.WHITE) + bingoQuestType.description, String.valueOf(ChatColor.GRAY) + "Requirement completed.", " ", String.valueOf(ChatColor.GREEN) + "✔ Completed"));
        } else {
          itemMeta1.setDisplayName(String.valueOf(ChatColor.GOLD) + bingoQuestType.displayName);
          itemMeta1.setLore(List.of(String.valueOf(ChatColor.WHITE) + bingoQuestType.description, String.valueOf(ChatColor.GRAY) + "Required amount: " + bingoQuestType.requiredAmount, " ", String.valueOf(ChatColor.RED) + "✘ Not Completed"));
        } 
      }itemStack1.setItemMeta(itemMeta1);
      inventory.setItem(BINGO_SLOT_INDICES[b2], itemStack1);
    } 
    paramPlayer.openInventory(inventory);
    paramPlayer.playSound(paramPlayer.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
  }

  public void updateBingoScoreboards() {
    if (!this.isBingoRunning) {
      for (Player player : Bukkit.getOnlinePlayers())
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard()); 
      return;
    } 
    for (Player player : Bukkit.getOnlinePlayers()) {
      Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
      Objective objective = scoreboard.registerNewObjective("bingo", "dummy",String.valueOf(ChatColor.of("#B06736")) + "Bingo Progress");
      objective.setDisplaySlot(DisplaySlot.SIDEBAR);
      List list = (List)Bukkit.getOnlinePlayers().stream().sorted(Comparator.comparingInt((Player paramPlayer1) -> this.getCompletedQuestCount(paramPlayer1)).reversed().thenComparing(Player::getName, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList());
      int b1 = 15;
      int b2 = 1;
      for (Player player1 : (Iterable<Player>)(Iterable<?>)list) {
        {
          if (b2 > 10)
            break; 
        }String str1 = ChatColor.values()[Math.min(b2, (ChatColor.values()).length - 1)].toString() + String.valueOf(ChatColor.RESET);
        Team team = scoreboard.registerNewTeam("t" + b2);
        team.addEntry(str1);
        int i = getCompletedQuestCount(player1);
        String str2 = truncateString(player1.getName(), 10);
        String str3 = String.valueOf(ChatColor.WHITE);
        int b = b2;
        team.setPrefix(truncateString(String.valueOf(ChatColor.GOLD) + b + ". " + str3 + str2, 16));
        team.setSuffix(truncateString(String.valueOf(ChatColor.GRAY) + " " + i + "/40", 16));
        objective.getScore(str1).setScore(b1--);
        b2++;
      } 
      player.setScoreboard(scoreboard);
    } 
  }

  public int getCompletedQuestCount(Player paramPlayer) {
    return ((Set)this.playerCompletedQuests.getOrDefault(paramPlayer.getUniqueId(), Collections.emptySet())).size();
  }

  public String truncateString(String paramString, int paramInt) {
    {

    }return (paramString.length() <= paramInt) ? paramString : paramString.substring(0, paramInt);
  }

  public void giveBingoCard(Player paramPlayer) {
    ItemStack itemStack = createBingoCard();
    boolean bool = Arrays.<ItemStack>stream(paramPlayer.getInventory().getContents()).filter(Objects::nonNull).anyMatch(paramItem -> lambda$giveCard$1(itemStack, paramItem));
    {
      if (!bool)
        paramPlayer.getInventory().addItem(new ItemStack[] { itemStack }); 
    }}

  public ItemStack createBingoCard() {
    ItemStack itemStack = new ItemStack(Material.BOOK);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.addEnchant(Enchantment.UNBREAKING, 1, true);
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + String.valueOf(ChatColor.BOLD) + "Bingo Card");
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(" ");
    arrayList.add(String.valueOf(ChatColor.WHITE) + "RIGHT CLICK " + String.valueOf(ChatColor.GRAY) + "to open your Bingo Board");
    itemMeta.setLore(arrayList);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent paramInventoryClickEvent) {
    {
      if (!paramInventoryClickEvent.getView().getTitle().contains("Bingo Board"))
        return; 
    }paramInventoryClickEvent.setCancelled(true);
    ((Player)paramInventoryClickEvent.getWhoClicked()).updateInventory();
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    {
      if (!this.isBingoRunning)
        return; 
    }{
      if (paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_AIR || paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
        ItemStack itemStack = paramPlayerInteractEvent.getPlayer().getInventory().getItemInMainHand();
        {
          if (itemStack != null)
            {
              if (itemStack.getType() != Material.AIR)
                {
                  if (itemStack.isSimilar(createBingoCard())) {
                    paramPlayerInteractEvent.setCancelled(true);
                    openBingoBoard(paramPlayerInteractEvent.getPlayer());
                  } 
                }}}} 
    }}

  @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
  public void onPlayerDeath(PlayerDeathEvent paramPlayerDeathEvent) {
    {
      if (!this.isBingoRunning)
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
      if (TrustManager.isTrusted(player2, player1))
        return; 
    }Set<BingoQuestType> set = this.playerCompletedQuests.computeIfAbsent(player2.getUniqueId(), BingoEventManager::lambda$death$2);
    {
      if (set.contains(BingoQuestType.SLAYER))
        return; 
    }set.add(BingoQuestType.SLAYER);
    String str1 = BingoQuestType.SLAYER.displayName;
    String str2 = String.valueOf(ChatColor.WHITE);
    player2.sendMessage(String.valueOf(ChatColor.GREEN) + "Completed bingo objective: " + str2 + str1);
    player2.playSound(player2.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.8F, 1.2F);
    updateBingoScoreboards();
    countMusicDiscs(player2);
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent paramPlayerJoinEvent) {
    {
      this.playerCompletedQuests.putIfAbsent(paramPlayerJoinEvent.getPlayer().getUniqueId(), EnumSet.noneOf(BingoQuestType.class));
      if (this.isBingoRunning) {
        giveBingoCard(paramPlayerJoinEvent.getPlayer());
        BossBarManager.addPlayerToBingoBar(paramPlayerJoinEvent.getPlayer());
        updateBingoScoreboards();
      } else {
        paramPlayerJoinEvent.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
      } 
    }}

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent paramPlayerQuitEvent) {
    {
      if (!this.isBingoRunning)
        return; 
    }paramPlayerQuitEvent.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
    Bukkit.getScheduler().runTaskLater((Plugin)this.plugin, (Runnable)this::updateBingoScoreboards, 1L);
  }

  private static Set lambda$death$2(UUID paramUUID) {
    return EnumSet.noneOf(BingoQuestType.class);
  }

  private static boolean lambda$giveCard$1(ItemStack paramItemStack1, ItemStack paramItemStack2) {
    return paramItemStack2.isSimilar(paramItemStack1);
  }

  private static Set lambda$check$0(UUID paramUUID) {
    return EnumSet.noneOf(BingoQuestType.class);
  }



}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */