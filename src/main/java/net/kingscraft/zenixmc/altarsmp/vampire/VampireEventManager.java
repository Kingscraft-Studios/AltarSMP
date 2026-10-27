package net.kingscraft.zenixmc.altarsmp.vampire;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
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
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import org.bukkit.util.Vector;
import java.util.HashMap;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import org.jetbrains.annotations.NotNull;

public final class VampireEventManager implements Listener, CommandExecutor, TabCompleter {
  public static final String PALE;

  public static final String VAMPIRE;

  public static final FileConfiguration config;

  public static final double backstabDamage;

  public static final boolean allVampiresAndPalerotsInfectHumans;

  public static boolean eventEnabled;

  public static File vampireFile;

  public static YamlConfiguration vampireConfig;

  public static final Map<UUID, String> playerTypes;

  public static String vampireWinner;

  public static boolean bloodMoonAnnounced;


  public static void loadVampireData() {
    {
      vampireFile = new File(AltarSMP.getInstance().getDataFolder(), "vampire.yml");
      if (!vampireFile.exists()) {
        AltarSMP.getInstance().getDataFolder().mkdirs();
        try {
          vampireFile.createNewFile();
        } catch (IOException iOException) {
          iOException.printStackTrace();
        } 
      } 
    }
    vampireConfig = YamlConfiguration.loadConfiguration(vampireFile);
    playerTypes.clear();
    for (String str : vampireConfig.getKeys(false))
      playerTypes.put(UUID.fromString(str), vampireConfig.getString(str));
  }

  public static void saveVampireData() {
    try {
      vampireConfig.save(vampireFile);
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
  }

  public static void startSunDamageTask() {
    {
      if (!eventEnabled)
        return; 
    }(new VampireSunAndMoonTask()).runTaskTimer(AltarSMP.getInstance(), 0L, 20L);
  }

  public static boolean isExposedToSun(Player paramPlayer) {
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
  public void onPlayerDeath(PlayerDeathEvent paramPlayerDeathEvent) {
    {
      if (!eventEnabled)
        return; 
    }Player player1 = paramPlayerDeathEvent.getPlayer();
    Player player2 = player1.getKiller();
    {
      if (player2 == null)
        return; 
    }ItemStack itemStack = player2.getInventory().getItemInMainHand();
    {
      if (allVampiresAndPalerotsInfectHumans) {
        {
          if (isPale(player2)) {
            setPale(player1);
          } else {
            {
              if (isVampire(player2)) {
                setVampire(player1);
              } else {
                {
                  if (isSpecialPlayer(player2))
                    removePlayerType(player1);
                }} 
            }} 
        }} else {
        {
          if (AltarSMP.areSimilar(itemStack, CustomItemRegistry.getHyperion())) {
            setHuman(player1);
          } else {
            {
              if (AltarSMP.areSimilar(itemStack, CustomItemRegistry.getNightpiercer())) {
                setVampire(player1);
              } else {
                {
                  if (player1.hasPotionEffect(PotionEffectType.LUCK))
                    {
                      if (player1.getPotionEffect(PotionEffectType.LUCK).getAmplifier() == 1)
                        setPale(player1);
                    }}} 
            }} 
        }} 
    }}

  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    LivingEntity livingEntity;
    {
      if (!eventEnabled)
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
      if (!isPale(player))
        return; 
    }Vector vector1 = livingEntity.getLocation().getDirection().normalize();
    Vector vector2 = player.getLocation().toVector().subtract(livingEntity.getLocation().toVector()).normalize();
    double d = vector1.dot(vector2);
    if (d < -0.5D) {
      paramEntityDamageByEntityEvent.setDamage(paramEntityDamageByEntityEvent.getDamage() + backstabDamage);
      livingEntity.getWorld().playSound(livingEntity.getLocation(), Sound.ENTITY_CREAKING_ATTACK, 1.2F, 1.0F);
    } 
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent paramPlayerJoinEvent) {
    Player player = paramPlayerJoinEvent.getPlayer();
    {
      if (!playerTypes.containsKey(player.getUniqueId()))
        {
          if (vampireWinner != null)
            setPlayerType(player, vampireWinner);
        }}
    getPlayerType(player);
  }

  public static void updatePlayerDisplay(Player paramPlayer) {
    Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    String str1 = "dw_" + paramPlayer.getName();
    Team team = scoreboard.getTeam(str1);
    if (team == null) {
      team = scoreboard.registerNewTeam(str1);
      team.addEntry(paramPlayer.getName());
    }
    String str2 = paramPlayer.getName();
    {
      if (isPale(paramPlayer)) {
        team.color(NamedTextColor.YELLOW);
        team.prefix(Component.text("", NamedTextColor.YELLOW));
        paramPlayer.displayName(Component.text(str2, NamedTextColor.YELLOW));
        paramPlayer.playerListName(Component.text(str2, NamedTextColor.YELLOW));
      } else {
        {
          if (isVampire(paramPlayer)) {
            team.color(NamedTextColor.RED);
            team.prefix(Component.text("", NamedTextColor.RED));
            paramPlayer.displayName(Component.text(str2, NamedTextColor.RED));
            paramPlayer.playerListName(Component.text(str2, NamedTextColor.RED));
          } else {
            team.color(NamedTextColor.WHITE);
            team.prefix(Component.empty());
            paramPlayer.displayName(Component.text(str2));
            paramPlayer.playerListName(Component.text(str2));
          }
        }
      }
    }
  }

  public static void setPale(Player paramPlayer) {
    setPlayerType(paramPlayer, "PALE");
    getPlayerType(paramPlayer);
    paramPlayer.sendMessage(Component.text("You are now a pale rot", NamedTextColor.YELLOW));
  }

  public static void setVampire(Player paramPlayer) {
    setPlayerType(paramPlayer, "VAMPIRE");
    getPlayerType(paramPlayer);
    paramPlayer.sendMessage(Component.text("You are now a vampire", NamedTextColor.RED));
  }

  public static void setHuman(Player paramPlayer) {
    removePlayerType(paramPlayer);
    getPlayerType(paramPlayer);
    paramPlayer.sendMessage(Component.text("You are now a human with no special abilities", NamedTextColor.GREEN));
  }

  public static void setPlayerType(Player paramPlayer, String paramString) {
    UUID uUID = paramPlayer.getUniqueId();
    playerTypes.put(uUID, paramString);
    vampireConfig.set(uUID.toString(), paramString);
    saveVampireData();
  }

  public static void removePlayerType(Player paramPlayer) {
    UUID uUID = paramPlayer.getUniqueId();
    playerTypes.remove(uUID);
    vampireConfig.set(uUID.toString(), null);
    saveVampireData();
  }

  public static boolean isPale(Player paramPlayer) {
    return "PALE".equals(playerTypes.get(paramPlayer.getUniqueId()));
  }

  public static boolean isVampire(Player paramPlayer) {
    return "VAMPIRE".equals(playerTypes.get(paramPlayer.getUniqueId()));
  }

  public static boolean isSpecialPlayer(Player paramPlayer) {
    return !isPale(paramPlayer) && !isVampire(paramPlayer);
  }

  public static String getPlayerType(Player paramPlayer) {
    return playerTypes.get(paramPlayer.getUniqueId());
  }

  public static void endVampireEvent(String paramString) {
    eventEnabled = false;
    config.set("vampire_event_enabled", false);

    // Clean switch expression to determine the winner string
    String winner = paramString != null ? switch (paramString.toLowerCase()) {
      case "pale" -> "PALE";
      case "vampire" -> "VAMPIRE";
      default -> null;
    } : null;

    vampireWinner = winner;
    config.set("vampire_winner", winner);
    AltarSMP.getInstance().saveConfig();

    // Update online players
    for (Player player : Bukkit.getOnlinePlayers()) {
      if (winner == null) {
        setHuman(player);
      } else {
        setPlayerType(player, winner);
        getPlayerType(player);
      }
    }

    // Update offline players stored in data
    for (UUID uuid : new ArrayList<>(playerTypes.keySet())) {
      if (Bukkit.getPlayer(uuid) == null) {
        if (winner == null) {
          playerTypes.remove(uuid);
          vampireConfig.set(uuid.toString(), null);
        } else {
          playerTypes.put(uuid, winner);
          vampireConfig.set(uuid.toString(), winner);
        }
      }
    }

    saveVampireData();
    bloodMoonAnnounced = false;
    Bukkit.broadcast(Component.text("RITUAL COMPLETE", NamedTextColor.RED, TextDecoration.BOLD));
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
    if (args.length == 0) {
      sender.sendMessage(Component.text("Usage: /vampire <player|toggle> [pale|vampire|human]", NamedTextColor.RED));
      return true;
    }

    String targetName = args[0];

    // Check for toggle command first
    if (targetName.equalsIgnoreCase("toggle")) {
      eventEnabled = !eventEnabled;
      if (eventEnabled) {
        sender.sendMessage(Component.text("Vampire Event enabled.", NamedTextColor.GREEN));
      } else {
        sender.sendMessage(Component.text("Vampire Event disabled.", NamedTextColor.RED));
      }
      config.set("vampire_event_enabled", eventEnabled);
      AltarSMP.getInstance().saveConfig();
      return true;
    }

    Player targetPlayer = Bukkit.getPlayer(targetName);
    if (targetPlayer == null) {
      sender.sendMessage(Component.text("Player not found.", NamedTextColor.RED));
      return true;
    }

    if (args.length != 2) {
      sender.sendMessage(Component.text("Usage: /vampire <player> <pale|vampire|human>", NamedTextColor.RED));
      return true;
    }

    String type = args[1].toLowerCase();

    boolean success = switch (type) {
      case "pale" -> {
        setPale(targetPlayer);
        sender.sendMessage(Component.text(targetPlayer.getName() + " is now Pale.", NamedTextColor.GREEN));
        yield true;
      }
      case "vampire" -> {
        setVampire(targetPlayer);
        sender.sendMessage(Component.text(targetPlayer.getName() + " is now Vampire.", NamedTextColor.GREEN));
        yield true;
      }
      case "human" -> {
        setHuman(targetPlayer);
        sender.sendMessage(Component.text(targetPlayer.getName() + " is now Human.", NamedTextColor.GREEN));
        yield true;
      }
      default -> false;
    };

    if (!success) {
      sender.sendMessage(Component.text("Usage: /vampire <player> <pale|vampire|human>", NamedTextColor.RED));
    }

    return true;
  }

  public List<String> onTabComplete(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, String[] paramArrayOfString) {
    if (paramArrayOfString.length == 1) {
      String str = paramArrayOfString[0].toLowerCase();
      ArrayList<String> arrayList = new ArrayList<>();
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
      ArrayList<String> arrayList = new ArrayList<>();
      for (String str1 : List.of("pale", "vampire", "human")) {
        {
          if (str1.startsWith(str))
            arrayList.add(str1); 
        }} 
      return arrayList;
    } 
    return List.of();
  }



  static {
    config = AltarSMP.getInstance().getConfig();
    backstabDamage = config.getDouble("backstab_damage", 2.0D);
    allVampiresAndPalerotsInfectHumans = config.getBoolean("all_vampires_and_palerots_infect_humans", true);
    eventEnabled = config.getBoolean("vampire_event_enabled", false);
    playerTypes = new HashMap<>();
    vampireWinner = config.getString("vampire_winner", null);
    bloodMoonAnnounced = false;
    PALE = "PALE";
    VAMPIRE = "VAMPIRE";
  }

}
