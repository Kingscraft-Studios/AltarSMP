package pl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.ClickEvent.Action;
import net.kyori.adventure.text.event.ClickEvent.Payload;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
   public BloodLustKillTracker bloodLustKillTracker;
   public KnightFallKillTracker knightFallKillTracker;
   public AltarManager altarConfigManager;
   public AltarController altarController;
   public static Main instance;
   public static Vampire NIGHT_PIERCER;
   public static ShadeSoul PURE_BLADE;
   public static WitherBoneAbility WITHER_BONE;
   public static EarthGauntletAbility EARTH_GAUNTLET;
   public static ShadowBladeAbility DARK_BLADE;
   static TrustManager trust;

   @Override
   public void onEnable() {
      instance = this;
      this.saveDefaultConfig();
      FileConfiguration var1 = this.getConfig();

      try (InputStream var2 = this.getResource("config.yml")) {
         if (var2 != null) {
            YamlConfiguration var3 = YamlConfiguration.loadConfiguration(new InputStreamReader(var2));
            var1.setDefaults(var3);
            var1.options().copyDefaults(true);
            this.saveConfig();
         }
      } catch (IOException var10) {
         var10.printStackTrace();
      }

      CustomItemRegistry.loadMessages();
      this.bloodLustKillTracker = new BloodLustKillTracker(this);
      this.knightFallKillTracker = new KnightFallKillTracker(this);
      this.altarConfigManager = new AltarManager(this);
      this.altarController = new AltarController(this);

      Bukkit.getPluginManager().registerEvents(new MobDropListener(this), this);
      Bukkit.getPluginManager().registerEvents(new AltarRitualListener(this.altarController), this);
      Vampire.startPassiveTask();
      Bukkit.getPluginManager().registerEvents(new WeaponHandleRecipeListener(this), this);
      Bukkit.getPluginManager().registerEvents(new VulcanSkullRecipeListener(this), this);
      Bukkit.getPluginManager().registerEvents(new IllusionCoreRecipeListener(this), this);

      this.getCommand("cooldown").setExecutor(new ClearCooldownsCommand());

      NIGHT_PIERCER = new Vampire();
      PURE_BLADE = new ShadeSoul(this);
      WITHER_BONE = new WitherBoneAbility();
      EARTH_GAUNTLET = new EarthGauntletAbility();
      DARK_BLADE = new ShadowBladeAbility();

      Bukkit.getPluginManager().registerEvents(NIGHT_PIERCER, this);
      Bukkit.getPluginManager().registerEvents(PURE_BLADE, this);
      Bukkit.getPluginManager().registerEvents(WITHER_BONE, this);
      Bukkit.getPluginManager().registerEvents(EARTH_GAUNTLET, this);
      Bukkit.getPluginManager().registerEvents(DARK_BLADE, this);
      Bukkit.getPluginManager().registerEvents(new KnightfallEnchantmentListener(), this);
      Bukkit.getPluginManager().registerEvents(new EclipseAbility(), this);
      Bukkit.getPluginManager().registerEvents(new PluginEnableListener(), this);
      Bukkit.getPluginManager().registerEvents(new CrazyRandomizerListener(), this);
      Bukkit.getPluginManager().registerEvents(new CutlassAbility(), this);
      Bukkit.getPluginManager().registerEvents(new WindweaverAbility(this), this);
      Bukkit.getPluginManager().registerEvents(new PaladinEarthAbility(this), this);
      Bukkit.getPluginManager().registerEvents(this, this);
      Bukkit.getPluginManager().registerEvents(new IllusionDisguiseManager(), this);
      Bukkit.getPluginManager().registerEvents(new NetheriteHelmetAbilityListener(this), this);
      Bukkit.getPluginManager().registerEvents(new CopperLeggingsShockwaveAbility(this), this);
      Bukkit.getPluginManager().registerEvents(new NetheriteChestplateComboAbility(this), this);
      Bukkit.getPluginManager().registerEvents(new CopperBootsSpeedAbility(this), this);

      BingoEventManager var11 = new BingoEventManager(this);
      Bukkit.getPluginManager().registerEvents(var11, this);
      this.getCommand("startbingo").setExecutor(var11);
      this.getCommand("bingo").setExecutor(var11);

      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi var12 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi();
      this.getCommand("startleggingsevent").setExecutor(var12);
      Bukkit.getPluginManager().registerEvents(var12, this);

      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh var4 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bh();
      Bukkit.getPluginManager().registerEvents(var4, this);
      this.getCommand("starthelmetevent").setExecutor(var4);

      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bg var5 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bg();
      Bukkit.getPluginManager().registerEvents(var5, this);
      this.getCommand("startchestplateevent").setExecutor(var5);

      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a4(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a1(this), this);
      Bukkit.getPluginManager().registerEvents(this.altarController, this);
      Bukkit.getPluginManager().registerEvents(new EchoAbility(), this);
      Bukkit.getPluginManager().registerEvents(new StrikerBowAbility(), this);
      Bukkit.getPluginManager().registerEvents(new PaleCannonAbility(this), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b_(), this);

      VampireEventManager var6 = new VampireEventManager();
      Bukkit.getPluginManager().registerEvents(var6, this);
      this.getCommand("vampire").setExecutor(var6);
      this.getCommand("vampire").setTabCompleter(var6);

      VampireEventManager.loadVampireData();
      VampireEventManager.startSunDamageTask();

      this.getCommand("altar").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a8(this.altarController, this.altarConfigManager));
      this.getCommand("legendaries").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_());
      this.getCommand("setkills").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ba());
      this.getCommand("setkills").setTabCompleter(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ba());

      WitherBoneAbility.startTask();

      this.getCommand("controls").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764q(this));
      this.getCommand("giveselector").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764r(this));
      Objects.requireNonNull(this.getCommand("dtest")).setExecutor(Main::lambda$onEnable$0);
      this.getCommand("checklegendary").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764s(this));
      Objects.requireNonNull(this.getCommand("credits")).setExecutor(Main::lambda$onEnable$1);

      this.registerTrust();

      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_(), this);

      BossBarManager.startUpdater();

      new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764co(this).runTaskLater(getInstance(), 40L);
   }

   public static boolean areSimilar(ItemStack var0, ItemStack var1) {
      if (var0 != null && var1 != null) {
         if (var0.getType() != var1.getType()) {
            return false;
         }

         ItemMeta var2 = var0.getItemMeta();
         ItemMeta var3 = var1.getItemMeta();
         if (var2 == null && var3 == null) {
            return true;
         }

         if (var2 != null && var3 != null) {
            if (var2.hasItemModel() != var3.hasItemModel()) {
               return false;
            } else if (var2.hasItemModel() && !Objects.equals(var2.getItemModel(), var3.getItemModel())) {
               return false;
            } else {
               return var2.hasCustomModelData() != var3.hasCustomModelData() ? false : var2.getCustomModelData() == var3.getCustomModelData();
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @EventHandler
   public void join(PlayerJoinEvent var1) {
      Player var2 = var1.getPlayer();
      if (getInstance().getConfig().getBoolean("reset_hearts_on_relog", true)) {
         var2.setMaxHealth(20.0);
         AttributeInstance var3 = var2.getAttribute(Attribute.MAX_HEALTH);
         var3.setBaseValue(20.0);
      }

      new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cp(this, var2).runTaskLater(getInstance(), 20L);
   }

   @Override
   public void onDisable() {
      if (this.bloodLustKillTracker != null) {
         this.bloodLustKillTracker.flush();
      }

      if (this.knightFallKillTracker != null) {
         this.knightFallKillTracker.flush();
      }

      if (this.altarController != null) {
         this.altarController.removeAllAltars();
      }

      for (Player var2 : Bukkit.getOnlinePlayers()) {
         BossBarManager.removeAllBars(
            var2
         );
         IllusionDisguiseManager.revealPlayer(
            var2
         );
      }
   }

   public static Main getInstance() {
      return instance;
   }

   public void registerTrust() {
      trust = new TrustManager();
      this.getCommand("trust").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b8(trust));
      this.getCommand("untrust").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b8(trust));
   }

   public static boolean isTrusted(Player var0, Entity var1) {
      return var1 instanceof Player var2
         ? TrustManager.isTrusted(
            var0, var2
         )
         : false;
   }

   public AltarManager getConfigManager() {
      return this.altarConfigManager;
   }

   @EventHandler
   public void death(ItemDespawnEvent var1) {
      if (var1.getEntity() instanceof Item var2) {
         ItemStack var4 = var2.getItemStack();
         if (!var4.hasItemMeta()) {
            return;
         }

         if (!var4.getItemMeta().hasCustomModelData()) {
            return;
         }

         if (!var4.getItemMeta().isUnbreakable()) {
            return;
         }

         if (!getInstance().getConfig().getBoolean("announce_destroying_legendaries", true)) {
            return;
         }

         if (CooldownManager.isOnCooldown(
            var2.getUniqueId(), "wait_a_bit"
         )) {
            return;
         }

         Bukkit.broadcastMessage(var4.getItemMeta().getDisplayName() + " §4§lHas been destroyed!");
         CooldownManager.setCooldown(
            var2.getUniqueId(), "wait_a_bit", 1.0
         );
      }
   }

   @EventHandler
   public void death(EntityDamageEvent var1) {
      if (var1.getEntity() instanceof Item var2) {
         ItemStack var4 = var2.getItemStack();
         if (!var4.hasItemMeta()) {
            return;
         }

         if (!var4.getItemMeta().hasCustomModelData()) {
            return;
         }

         if (!var4.getItemMeta().isUnbreakable()) {
            return;
         }

         if (!getInstance().getConfig().getBoolean("announce_destroying_legendaries", true)) {
            return;
         }

         if (CooldownManager.isOnCooldown(
            var2.getUniqueId(), "wait_a_bit"
         )) {
            return;
         }

         Bukkit.broadcastMessage(var4.getItemMeta().getDisplayName() + " §4§lHas been destroyed!");
         CooldownManager.setCooldown(
            var2.getUniqueId(), "wait_a_bit", 1.0
         );
      }
   }

   private static boolean lambda$onEnable$1(CommandSender var0, Command var1, String var2, String[] var3) {
      if (var0 instanceof Player var4) {
         var4.getWorld().playSound(var4.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
      }

      Component var6 = ((TextComponent)Component.text("§ePurchase ").clickEvent(ClickEvent.clickEvent(Action.OPEN_URL, Payload.string("https://mc-shop-plugins.tebex.io"))))
         .decorate(TextDecoration.UNDERLINED);
      Component var5 = ((TextComponent)Component.text("§7| §bDownload Pack ").clickEvent(ClickEvent.clickEvent(Action.OPEN_URL, Payload.string("https://modrinth.com/resourcepack/altar-smp-texture-pack"))))
         .decorate(TextDecoration.UNDERLINED);
      var0.sendMessage(var6.append(var5));
      var0.sendMessage("§8---------------------");
      var0.sendMessage("§7Plugin by §5.Doomwen");
      var0.sendMessage("§7Models by §8ilyduckzy");
      return true;
   }

   private static boolean lambda$onEnable$0(CommandSender var0, Command var1, String var2, String[] var3) {
      if (var0 instanceof Player var4) {
         if (IllusionDisguiseManager.isDisguised(
            var4
         )) {
            IllusionDisguiseManager.revealPlayer(
               var4
            );
            return true;
         }

         IllusionDisguiseManager.disguisePlayer(
            var4, EntityType.ZOMBIE, null
         );
      }

      return true;
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code


}
