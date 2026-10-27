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
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
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
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;
import org.jetbrains.annotations.NotNull;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.TrustManager;

public class BingoEventManager implements CommandExecutor, Listener {
  public final AltarSMP plugin;

  private final Map<UUID, Set<BingoQuestType>> playerCompletedQuests = new HashMap<>();

  public BukkitRunnable countdownTask;

  public boolean isBingoRunning = false;

  private static final Component BINGO_BOARD_TITLE = Component.text("Bingo Board", BossBarManager.COPPER, TextDecoration.BOLD);

  private static final NamedTextColor[] SCOREBOARD_COLORS = {
      NamedTextColor.BLACK, NamedTextColor.DARK_BLUE, NamedTextColor.DARK_GREEN, NamedTextColor.DARK_AQUA,
      NamedTextColor.DARK_RED, NamedTextColor.DARK_PURPLE, NamedTextColor.GOLD, NamedTextColor.GRAY,
      NamedTextColor.DARK_GRAY, NamedTextColor.BLUE, NamedTextColor.GREEN, NamedTextColor.AQUA,
      NamedTextColor.RED, NamedTextColor.LIGHT_PURPLE, NamedTextColor.YELLOW, NamedTextColor.WHITE
  };

  private static final int[] BINGO_SLOT_INDICES = new int[] {0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,18,19,20,21,22,23,24,25,27,28,29,30,31,32,33,34,36,37,38,39,40,41,42,43};

  public int remainingTimeTicks;


  public BingoEventManager(AltarSMP paramAltarSMP) {
    this.plugin = paramAltarSMP;
    if ((BingoQuestType.values()).length != 40)
      throw new IllegalStateException("Bingo must have exactly 40 quests."); 
    }

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

  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String @NotNull [] paramArrayOfString) {
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
            paramCommandSender.sendMessage(Component.text("Bingo is already running.", NamedTextColor.RED));
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
            player.sendMessage(Component.text("Bingo event did not start yet.", NamedTextColor.RED));
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
    AltarSMP.getInstance().getConfig().set("bingoActive", true);
    AltarSMP.getInstance().saveConfig();
    this.playerCompletedQuests.clear();
    for (Player player : Bukkit.getOnlinePlayers()) {
      this.playerCompletedQuests.put(player.getUniqueId(), EnumSet.noneOf(BingoQuestType.class));
      giveBingoCard(player);
    } 
    BossBarManager.showBingoBar("Bingo Time Remaining:", i, BarColor.PURPLE);
    updateBingoScoreboards();
    this.countdownTask = new BingoEventCountdownTask(this);
    this.countdownTask.runTaskTimer(this.plugin, 20L, 20L);
  }

  public void stopBingoEvent() {
    this.isBingoRunning = false;
    AltarSMP.getInstance().getConfig().set("bingoActive", false);
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
      Bukkit.broadcast(Component.text()
          .append(Component.text("Bingo Event", BossBarManager.COPPER))
          .append(Component.text(" was automatically finished because "))
          .append(Component.text(paramPlayer.getName(), NamedTextColor.WHITE))
          .append(Component.text(" completed all 40/40 quests.", NamedTextColor.GRAY))
          .build());
      if (this.countdownTask != null) {
        this.countdownTask.cancel();
        this.countdownTask = null;
      } 
    }
    stopBingoEvent();
  }

  public void checkPlayerQuests(Player paramPlayer) {
    Set<BingoQuestType> set = this.playerCompletedQuests.computeIfAbsent(paramPlayer.getUniqueId(), BingoEventManager::newQuestSet);
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
                paramPlayer.sendMessage(Component.text()
                    .append(Component.text("Completed bingo objective: ", NamedTextColor.GREEN))
                    .append(Component.text(str1, NamedTextColor.WHITE))
                    .build());
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
                        paramPlayer.sendMessage(Component.text()
                            .append(Component.text("Completed bingo objective: ", NamedTextColor.GREEN))
                            .append(Component.text(str1, NamedTextColor.WHITE))
                            .build());
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
    Inventory inventory = Bukkit.createInventory(null, 54, BINGO_BOARD_TITLE);
    ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.displayName(Component.text(" "));
    itemStack.setItemMeta(itemMeta);
    int b1 = 0;
    {
      while (b1 < 54) {
        inventory.setItem(b1, itemStack);
        b1++;
      } 
    }
    BingoQuestType[] bingoQuestTypes = BingoQuestType.values();
    Set<BingoQuestType> set = this.playerCompletedQuests.getOrDefault(paramPlayer.getUniqueId(), EnumSet.noneOf(BingoQuestType.class));
    for (int b2 = 0; b2 < bingoQuestTypes.length; b2++) {
      BingoQuestType bingoQuestType = bingoQuestTypes[b2];
      boolean bool = set.contains(bingoQuestType);
      {

      }ItemStack itemStack1 = new ItemStack(bool ? Material.BARRIER : bingoQuestType.displayMaterial);
      ItemMeta itemMeta1 = itemStack1.getItemMeta();
      {
        if (bool) {
          itemMeta1.displayName(Component.text(bingoQuestType.displayName, NamedTextColor.GREEN));
          itemMeta1.lore(List.of(
              Component.text(bingoQuestType.description, NamedTextColor.WHITE),
              Component.text("Requirement completed.", NamedTextColor.GRAY),
              Component.text(" "),
              Component.text("✔ Completed", NamedTextColor.GREEN)));
        } else {
          itemMeta1.displayName(Component.text(bingoQuestType.displayName, NamedTextColor.GOLD));
          itemMeta1.lore(List.of(
              Component.text(bingoQuestType.description, NamedTextColor.WHITE),
              Component.text("Required amount: " + bingoQuestType.requiredAmount, NamedTextColor.GRAY),
              Component.text(" "),
              Component.text("✘ Not Completed", NamedTextColor.RED)));
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
      Objective objective = scoreboard.registerNewObjective("bingo", Criteria.DUMMY, Component.text("Bingo Progress", BossBarManager.COPPER));
      objective.setDisplaySlot(DisplaySlot.SIDEBAR);
      List<Player> list = Bukkit.getOnlinePlayers().stream().sorted(Comparator.comparingInt(this::getCompletedQuestCount).reversed().thenComparing(Player::getName, String.CASE_INSENSITIVE_ORDER)).collect(Collectors.toList());
      int b1 = 15;
      int b2 = 1;
      for (Player player1 : list) {
        {
          if (b2 > 10)
            break; 
        }String str1 = LegacyComponentSerializer.legacySection().serialize(
            Component.text(" ", SCOREBOARD_COLORS[Math.min(b2, SCOREBOARD_COLORS.length - 1)]));
        Team team = scoreboard.registerNewTeam("t" + b2);
        team.addEntry(str1);
        int i = getCompletedQuestCount(player1);
        String str2 = truncateString(player1.getName(), 10);
        int b = b2;
        team.prefix(Component.text()
            .append(Component.text(b + ". ", NamedTextColor.GOLD))
            .append(Component.text(str2, NamedTextColor.WHITE))
            .build());
        team.suffix(Component.text(" " + i + "/40", NamedTextColor.GRAY));
        objective.getScore(str1).setScore(b1--);
        b2++;
      } 
      player.setScoreboard(scoreboard);
    } 
  }

  public int getCompletedQuestCount(Player paramPlayer) {
    return this.playerCompletedQuests.getOrDefault(paramPlayer.getUniqueId(), Collections.emptySet()).size();
  }

  public String truncateString(String paramString, int paramInt) {
    {

    }return (paramString.length() <= paramInt) ? paramString : paramString.substring(0, paramInt);
  }

  public void giveBingoCard(Player paramPlayer) {
    ItemStack itemStack = createBingoCard();
    boolean bool = Arrays.stream(paramPlayer.getInventory().getContents()).filter(Objects::nonNull).anyMatch(paramItem -> lambda$giveCard$1(itemStack, paramItem));
    {
      if (!bool)
        paramPlayer.getInventory().addItem(itemStack);
    }}

  public ItemStack createBingoCard() {
    ItemStack itemStack = new ItemStack(Material.BOOK);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.addEnchant(Enchantment.UNBREAKING, 1, true);
    itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    itemMeta.displayName(Component.text("Bingo Card", BossBarManager.COPPER, TextDecoration.BOLD));
    ArrayList<Component> arrayList = new ArrayList<>();
    arrayList.add(Component.text(" "));
    arrayList.add(Component.text()
        .append(Component.text("RIGHT CLICK ", NamedTextColor.WHITE))
        .append(Component.text("to open your Bingo Board", NamedTextColor.GRAY))
        .build());
    itemMeta.lore(arrayList);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }

  @EventHandler
  public void onInventoryClick(InventoryClickEvent paramInventoryClickEvent) {
    {
      if (!PlainTextComponentSerializer.plainText().serialize(paramInventoryClickEvent.getView().title()).contains("Bingo Board"))
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
            if (itemStack.getType() != Material.AIR) {
                if (itemStack.isSimilar(createBingoCard())) {
                  paramPlayerInteractEvent.setCancelled(true);
                  openBingoBoard(paramPlayerInteractEvent.getPlayer());
                }
            }
        }}
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
    }Set<BingoQuestType> set = this.playerCompletedQuests.computeIfAbsent(player2.getUniqueId(), BingoEventManager::newQuestSet);
    {
      if (set.contains(BingoQuestType.SLAYER))
        return; 
    }set.add(BingoQuestType.SLAYER);
    String str1 = BingoQuestType.SLAYER.displayName;
    player2.sendMessage(Component.text()
        .append(Component.text("Completed bingo objective: ", NamedTextColor.GREEN))
        .append(Component.text(str1, NamedTextColor.WHITE))
        .build());
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
    Bukkit.getScheduler().runTaskLater(this.plugin, this::updateBingoScoreboards, 1L);
  }

  private static boolean lambda$giveCard$1(ItemStack paramItemStack1, ItemStack paramItemStack2) {
    return paramItemStack2.isSimilar(paramItemStack1);
  }

  private static Set<BingoQuestType> newQuestSet(UUID uuid) {
    return EnumSet.noneOf(BingoQuestType.class);
  }



}
