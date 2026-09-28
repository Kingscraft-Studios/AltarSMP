package pl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ItemDespawnEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a2 killTracker;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au killTracker2;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br configManager;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm altarManager;
  
  public static Main instance;
  
  public static You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ah NIGHT_PIERCER;
  
  public static You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am PURE_BLADE;
  
  public static You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ap WITHER_BONE;
  
  public static You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ak EARTH_GAUNTLET;
  
  public static You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an DARK_BLADE;
  
  static You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9 trust;
  
  private static final String[] a;
  
  private static final String[] b;
  
  public void onEnable() {
    instance = this;
    saveDefaultConfig();
    FileConfiguration fileConfiguration = getConfig();
    try {
      InputStream inputStream = getResource(a(28172, -1518));
      try {
        if (inputStream != null) {
          YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(new InputStreamReader(inputStream));
          fileConfiguration.setDefaults((Configuration)yamlConfiguration);
          fileConfiguration.options().copyDefaults(true);
          saveConfig();
        } 
        try {
          if (inputStream != null)
            inputStream.close(); 
        } catch (Throwable throwable) {
          throw a(null);
        } 
      } catch (Throwable throwable) {
        if (inputStream != null)
          try {
            inputStream.close();
          } catch (Throwable throwable1) {
            throwable.addSuppressed(throwable1);
          }  
        throw throwable;
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    this.killTracker = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a2(this);
    this.killTracker2 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au(this);
    this.configManager = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br(this);
    this.altarManager = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm(this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bl(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bk(this.altarManager), (Plugin)this);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ah.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b7(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b6(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b5(this), (Plugin)this);
    getCommand(a(28170, 11768)).setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a9());
    NIGHT_PIERCER = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ah();
    PURE_BLADE = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am(this);
    WITHER_BONE = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ap();
    EARTH_GAUNTLET = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ak();
    DARK_BLADE = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an();
    Bukkit.getPluginManager().registerEvents(NIGHT_PIERCER, (Plugin)this);
    Bukkit.getPluginManager().registerEvents(PURE_BLADE, (Plugin)this);
    Bukkit.getPluginManager().registerEvents(WITHER_BONE, (Plugin)this);
    Bukkit.getPluginManager().registerEvents(EARTH_GAUNTLET, (Plugin)this);
    Bukkit.getPluginManager().registerEvents(DARK_BLADE, (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764as(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ar(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bx(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cf(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aj(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ao(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(this, (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764az(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ay(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax(this), (Plugin)this);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be(this);
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be, (Plugin)this);
    getCommand(a(28185, -9594)).setExecutor(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be);
    getCommand(a(28188, -602)).setExecutor(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi();
    getCommand(a(28160, -15156)).setExecutor(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi);
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi, (Plugin)this);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh();
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh, (Plugin)this);
    getCommand(a(28164, -5973)).setExecutor(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bg you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bg = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bg();
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bg, (Plugin)this);
    getCommand(a(28186, -27890)).setExecutor(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bg);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a4(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a1(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(this.altarManager, (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aq(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aw(), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai(this), (Plugin)this);
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b_(), (Plugin)this);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj();
    Bukkit.getPluginManager().registerEvents(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj, (Plugin)this);
    getCommand(a(28163, -26295)).setExecutor(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj);
    getCommand(a(28183, -1453)).setTabCompleter(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
    getCommand(a(28191, -9349)).setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a8(this.altarManager, this.configManager));
    getCommand(a(28190, 6856)).setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_());
    getCommand(a(28178, -32733)).setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ba());
    getCommand(a(28187, -5640)).setTabCompleter(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ba());
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ap.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    getCommand(a(28184, -3951)).setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764q(this));
    getCommand(a(28173, -23584)).setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764r(this));
    ((PluginCommand)Objects.<PluginCommand>requireNonNull(getCommand(a(28165, 27004)))).setExecutor(Main::lambda$onEnable$0);
    getCommand(a(28167, 16481)).setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764s(this));
    ((PluginCommand)Objects.<PluginCommand>requireNonNull(getCommand(a(28176, 6031)))).setExecutor(Main::lambda$onEnable$1);
    registerTrust();
    Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_(), (Plugin)this);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764co(this)).runTaskLater((Plugin)getInstance(), 40L);
  }
  
  public static boolean areSimilar(ItemStack paramItemStack1, ItemStack paramItemStack2) {
    try {
      if (paramItemStack1 != null) {
        try {
          if (paramItemStack2 == null)
            return false; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
      } else {
        return false;
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (paramItemStack1.getType() != paramItemStack2.getType())
        return false; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    ItemMeta itemMeta1 = paramItemStack1.getItemMeta();
    ItemMeta itemMeta2 = paramItemStack2.getItemMeta();
    try {
      if (itemMeta1 == null)
        try {
          if (itemMeta2 == null)
            return true; 
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (itemMeta1 != null)
        try {
          if (itemMeta2 != null) {
            try {
              if (itemMeta1.hasItemModel() != itemMeta2.hasItemModel())
                return false; 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            try {
              if (itemMeta1.hasItemModel())
                try {
                  if (!Objects.equals(itemMeta1.getItemModel(), itemMeta2.getItemModel()))
                    return false; 
                } catch (MatchException matchException) {
                  throw a(null);
                }  
            } catch (MatchException matchException) {
              throw a(null);
            } 
            try {
              if (itemMeta1.hasCustomModelData() != itemMeta2.hasCustomModelData())
                return false; 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            try {
              if (itemMeta1.getCustomModelData() != itemMeta2.getCustomModelData())
                return false; 
            } catch (MatchException matchException) {
              throw a(null);
            } 
            return true;
          } 
          return false;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return false;
  }
  
  @EventHandler
  public void join(PlayerJoinEvent paramPlayerJoinEvent) {
    Player player = paramPlayerJoinEvent.getPlayer();
    if (getInstance().getConfig().getBoolean(a(28162, -31125), true)) {
      player.setMaxHealth(20.0D);
      AttributeInstance attributeInstance = player.getAttribute(Attribute.MAX_HEALTH);
      attributeInstance.setBaseValue(20.0D);
    } 
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cp(this, player)).runTaskLater((Plugin)getInstance(), 20L);
  }
  
  public void onDisable() {
    try {
      if (this.killTracker != null)
        this.killTracker.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.killTracker2 != null)
        this.killTracker2.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    try {
      if (this.altarManager != null)
        this.altarManager.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(); 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    for (Player player : Bukkit.getOnlinePlayers()) {
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
    } 
  }
  
  public static Main getInstance() {
    return instance;
  }
  
  public void registerTrust() {
    trust = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9();
    getCommand(a(28161, 1141)).setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b8(trust));
    getCommand(a(28169, 8471)).setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b8(trust));
  }
  
  public static boolean isTrusted(Player paramPlayer, Entity paramEntity) {
    if (paramEntity instanceof Player) {
      Player player = (Player)paramEntity;
      return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(paramPlayer, player);
    } 
    return false;
  }
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br getConfigManager() {
    return this.configManager;
  }
  
  @EventHandler
  public void death(ItemDespawnEvent paramItemDespawnEvent) {
    Item item = paramItemDespawnEvent.getEntity();
    if (item instanceof Item) {
      Item item1 = item;
      ItemStack itemStack = item1.getItemStack();
      try {
        if (!itemStack.hasItemMeta())
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (!itemStack.getItemMeta().hasCustomModelData())
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (!itemStack.getItemMeta().isUnbreakable())
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (!getInstance().getConfig().getBoolean(a(28180, 11791), true))
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(item1.getUniqueId(), a(28177, -22800)))
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      Bukkit.broadcastMessage(itemStack.getItemMeta().getDisplayName() + itemStack.getItemMeta().getDisplayName());
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(item1.getUniqueId(), a(28168, 521), 1.0D);
    } 
  }
  
  @EventHandler
  public void death(EntityDamageEvent paramEntityDamageEvent) {
    Entity entity = paramEntityDamageEvent.getEntity();
    if (entity instanceof Item) {
      Item item = (Item)entity;
      ItemStack itemStack = item.getItemStack();
      try {
        if (!itemStack.hasItemMeta())
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (!itemStack.getItemMeta().hasCustomModelData())
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (!itemStack.getItemMeta().isUnbreakable())
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (!getInstance().getConfig().getBoolean(a(28175, 28649), true))
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      try {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(item.getUniqueId(), a(28168, 521)))
          return; 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      Bukkit.broadcastMessage(itemStack.getItemMeta().getDisplayName() + itemStack.getItemMeta().getDisplayName());
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(item.getUniqueId(), a(28168, 521), 1.0D);
    } 
  }
  
  private static boolean lambda$onEnable$1(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    if (paramCommandSender instanceof Player) {
      Player player = (Player)paramCommandSender;
      player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
    } 
    Component component1 = ((TextComponent)Component.text(a(28181, 14300)).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, (ClickEvent.Payload)ClickEvent.Payload.string(a(28196, -3696))))).decorate(TextDecoration.UNDERLINED);
    Component component2 = ((TextComponent)Component.text(a(28197, -9377)).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.OPEN_URL, (ClickEvent.Payload)ClickEvent.Payload.string(a(28174, -7382))))).decorate(TextDecoration.UNDERLINED);
    paramCommandSender.sendMessage(component1.append(component2));
    paramCommandSender.sendMessage(a(28166, -909));
    paramCommandSender.sendMessage(a(28171, 13989));
    paramCommandSender.sendMessage(a(28179, -7545));
    return true;
  }
  
  private static boolean lambda$onEnable$0(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
    if (paramCommandSender instanceof Player) {
      Player player = (Player)paramCommandSender;
      try {
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(player)) {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
          return true;
        } 
      } catch (MatchException matchException) {
        throw a(null);
      } 
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player, EntityType.ZOMBIE, (Player)null);
    } 
    return true;
  }
  
  private static Throwable a(Throwable paramThrowable) {
    return paramThrowable;
  }
  
  static {
    // Byte code:
    //   0: bipush #34
    //   2: anewarray java/lang/String
    //   5: astore #5
    //   7: iconst_0
    //   8: istore_3
    //   9: ldc 'J/LXÝ7Ü<b2>ÜeQËÌ«³ÿúúsÝTÝw^¸`®s0$ãÒ×ãúÖ\\tqQ½GxHàh*1"_çzf;nm®5¦ÐBHìf\\bè<2ðqKý¤aoúâ\\t çm^½?\\fhV°ßÌKÁ·Z\\nl5¬­¬À\\b{"ù[±»ÛI gue1ñ1ëoçßÍonG86®°;¡[zªåCàD\\rHGK½¸Ê?ZQ)C³ÌÃY_fÎá0fb­k[U.d\\nÛËç"¡¡3.\\r¡âf3¹ÚÎåXEÃ·ûç3S`Áç\\bkÿMþ¢p¤­ræ&x1tíÁ+'Ó>ð* J²ÀÉ³îÒK5¬.¤Q¬©â6/ßÊ¡ÄdÌ=.k9äüD²§0¿ý\\n¸-§s¯ód)Í®H0WW*þÏyâîLßÝúÆ5»ÞÉ²\\bë]TæYE\\r&"ùÚ×ÕÔ\\r¥¿µmvaáJw²þÍ"¹»qÑWU"$BínqKÐpÂ\\niÍJÀäÀI\\bÿ]Þ²J0ë\\b9s#ýd1w°Òq#ø&Ó9øñó¥Jñ¶}@á'
    //   11: dup
    //   12: astore_2
    //   13: invokevirtual length : ()I
    //   16: istore #4
    //   18: iconst_5
    //   19: istore_1
    //   20: iconst_m1
    //   21: istore_0
    //   22: bipush #51
    //   24: iinc #0, 1
    //   27: aload_2
    //   28: iload_0
    //   29: dup
    //   30: iload_1
    //   31: iadd
    //   32: invokevirtual substring : (II)Ljava/lang/String;
    //   35: iconst_m1
    //   36: goto -> 142
    //   39: aload #5
    //   41: swap
    //   42: iload_3
    //   43: iinc #3, 1
    //   46: swap
    //   47: aastore
    //   48: iload_0
    //   49: iload_1
    //   50: iadd
    //   51: dup
    //   52: istore_0
    //   53: iload #4
    //   55: if_icmpge -> 67
    //   58: aload_2
    //   59: iload_0
    //   60: invokevirtual charAt : (I)C
    //   63: istore_1
    //   64: goto -> 22
    //   67: ldc 'Ë°é¤.+>¢ÍèÈ<ÎCzy A±ßõ¯\\bÚìÿJ:æ4?k4wÙ¥Pb_H'
    //   69: dup
    //   70: astore_2
    //   71: invokevirtual length : ()I
    //   74: istore #4
    //   76: bipush #20
    //   78: istore_1
    //   79: iconst_m1
    //   80: istore_0
    //   81: bipush #124
    //   83: iinc #0, 1
    //   86: aload_2
    //   87: iload_0
    //   88: dup
    //   89: iload_1
    //   90: iadd
    //   91: invokevirtual substring : (II)Ljava/lang/String;
    //   94: iconst_0
    //   95: goto -> 142
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
    //   128: putstatic pl/Main.a : [Ljava/lang/String;
    //   131: bipush #34
    //   133: anewarray java/lang/String
    //   136: putstatic pl/Main.b : [Ljava/lang/String;
    //   139: goto -> 300
    //   142: dup_x2
    //   143: pop
    //   144: invokevirtual toCharArray : ()[C
    //   147: dup_x1
    //   148: arraylength
    //   149: dup_x2
    //   150: pop
    //   151: iconst_0
    //   152: istore #6
    //   154: dup2_x1
    //   155: pop2
    //   156: dup_x2
    //   157: iconst_1
    //   158: if_icmpgt -> 260
    //   161: dup2
    //   162: swap
    //   163: iload #6
    //   165: dup2_x1
    //   166: caload
    //   167: swap
    //   168: iload #6
    //   170: bipush #7
    //   172: irem
    //   173: tableswitch default -> 242, 0 -> 212, 1 -> 217, 2 -> 222, 3 -> 227, 4 -> 232, 5 -> 237
    //   212: bipush #97
    //   214: goto -> 244
    //   217: bipush #44
    //   219: goto -> 244
    //   222: bipush #57
    //   224: goto -> 244
    //   227: bipush #63
    //   229: goto -> 244
    //   232: bipush #50
    //   234: goto -> 244
    //   237: bipush #65
    //   239: goto -> 244
    //   242: bipush #29
    //   244: ixor
    //   245: ixor
    //   246: i2c
    //   247: castore
    //   248: iinc #6, 1
    //   251: dup
    //   252: ifne -> 260
    //   255: dup2
    //   256: dup_x1
    //   257: goto -> 165
    //   260: dup2_x1
    //   261: pop2
    //   262: dup_x2
    //   263: iload #6
    //   265: if_icmpgt -> 161
    //   268: pop
    //   269: new java/lang/String
    //   272: dup_x1
    //   273: swap
    //   274: invokespecial <init> : ([C)V
    //   277: invokevirtual intern : ()Ljava/lang/String;
    //   280: swap
    //   281: pop
    //   282: swap
    //   283: tableswitch default -> 39, 0 -> 98
    //   300: return
  }
  
  private static String a(int paramInt1, int paramInt2) {
    int i = (paramInt1 ^ 0x6E05) & 0xFFFF;
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
      char c = '';
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/Main.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */