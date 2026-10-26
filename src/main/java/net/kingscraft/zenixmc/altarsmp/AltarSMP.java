package net.kingscraft.zenixmc.altarsmp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HexFormat;
import java.util.Objects;
import java.util.UUID;

import net.kingscraft.zenixmc.altarsmp.armor.knightfall.KnightFallKillTracker;
import net.kingscraft.zenixmc.altarsmp.armor.knightfall.KnightfallListener;
import net.kingscraft.zenixmc.altarsmp.core.tracker.KillTracker;
import net.kingscraft.zenixmc.altarsmp.event.crazy.CrazySlotsListener;
import net.kingscraft.zenixmc.altarsmp.illusion.IllusionWandAbility;
import net.kingscraft.zenixmc.altarsmp.listener.*;
import net.kingscraft.zenixmc.altarsmp.weapon.blood.BloodLustAbilityListener;
import net.kingscraft.zenixmc.altarsmp.weapon.boneblade.BoneBladeAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.frostscythe.FrostScytheAbilityListener;
import net.kingscraft.zenixmc.altarsmp.weapon.scorching.ScorchingBladeAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.vulcan.VulcanGauntletAbility;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
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
import net.kingscraft.zenixmc.altarsmp.ability.paladin.PaladinEarthAbility;
import net.kingscraft.zenixmc.altarsmp.altar.AltarCommand;
import net.kingscraft.zenixmc.altarsmp.altar.AltarController;
import net.kingscraft.zenixmc.altarsmp.altar.AltarManager;
import net.kingscraft.zenixmc.altarsmp.altar.AltarReloadTask;
import net.kingscraft.zenixmc.altarsmp.altar.AltarRitualListener;
import net.kingscraft.zenixmc.altarsmp.armor.copper.CopperBootsSpeedAbility;
import net.kingscraft.zenixmc.altarsmp.armor.copper.CopperChestplateEventManager;
import net.kingscraft.zenixmc.altarsmp.armor.copper.CopperHelmetEventManager;
import net.kingscraft.zenixmc.altarsmp.armor.copper.CopperLeggingsEventManager;
import net.kingscraft.zenixmc.altarsmp.armor.copper.CopperLeggingsShockwaveAbility;
import net.kingscraft.zenixmc.altarsmp.armor.copper.CopperOreVeinMinerListener;
import net.kingscraft.zenixmc.altarsmp.armor.knightfall.KnightfallEnchantmentListener;
import net.kingscraft.zenixmc.altarsmp.armor.netherite.NetheriteChestplateComboAbility;
import net.kingscraft.zenixmc.altarsmp.armor.netherite.NetheriteHelmetAbilityListener;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.command.ClearCooldownsCommand;
import net.kingscraft.zenixmc.altarsmp.command.OffhandAbilityCommand;
import net.kingscraft.zenixmc.altarsmp.command.SetKillsCommand;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.event.bingo.BingoEventManager;
import net.kingscraft.zenixmc.altarsmp.event.crazy.CrazyRandomizerListener;
import net.kingscraft.zenixmc.altarsmp.event.crazy.CrazySelectorMenuListener;
import net.kingscraft.zenixmc.altarsmp.illusion.IllusionCoreRecipeListener;
import net.kingscraft.zenixmc.altarsmp.illusion.IllusionDisguiseManager;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRefreshTask;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.legendary.FindLegendaryItemDuplicatesCommand;
import net.kingscraft.zenixmc.altarsmp.legendary.LegendaryItemConfigMenu;
import net.kingscraft.zenixmc.altarsmp.legendary.LegendaryItemsMenu;
import net.kingscraft.zenixmc.altarsmp.trust.TrustCommand;
import net.kingscraft.zenixmc.altarsmp.trust.TrustManager;
import net.kingscraft.zenixmc.altarsmp.vampire.Vampire;
import net.kingscraft.zenixmc.altarsmp.vampire.VampireEventManager;
import net.kingscraft.zenixmc.altarsmp.weapon.cutlass.CutlassAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.earth.EarthGauntletAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.echo.EchoAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.eclipse.EclipseAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.pale.PaleCannonAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.precision.StrikerBowAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.shade.ShadeSoul;
import net.kingscraft.zenixmc.altarsmp.weapon.shadow.ShadowBladeAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.vulcan.VulcanSkullRecipeListener;
import net.kingscraft.zenixmc.altarsmp.weapon.wind.WindweaverAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.witherbone.WitherBoneAbility;

public final class AltarSMP extends JavaPlugin implements Listener {
   public KillTracker bloodLustKillTracker;
   public KnightFallKillTracker knightFallKillTracker;
   public AltarManager altarConfigManager;
   public AltarController altarController;
   public static AltarSMP instance;
   public static Vampire NIGHT_PIERCER;
   public static ShadeSoul PURE_BLADE;
   public static WitherBoneAbility WITHER_BONE;
   public static EarthGauntletAbility EARTH_GAUNTLET;
   public static ShadowBladeAbility DARK_BLADE;
   public static TrustManager trust;

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
      this.bloodLustKillTracker = new KillTracker(this, "bloodlustkills.yml");
      this.knightFallKillTracker = new KnightFallKillTracker(this);
      this.altarConfigManager = new AltarManager(this);
      this.altarController = new AltarController(this);
      net.kingscraft.zenixmc.altarsmp.altars2.Altars2.bootstrap(this);

      Bukkit.getPluginManager().registerEvents(new MobDropListener(this), this);
      Bukkit.getPluginManager().registerEvents(new AltarRitualListener(this.altarController), this);
      Vampire.startPassiveTask();
      Bukkit.getPluginManager().registerEvents(new WeaponHandleRecipeListener(this), this);
      Bukkit.getPluginManager().registerEvents(new VulcanSkullRecipeListener(this), this);
      Bukkit.getPluginManager().registerEvents(new IllusionCoreRecipeListener(this), this);
      Bukkit.getPluginManager().registerEvents(new SeasonTwoRecipeListener(this), this);

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

      BoneBladeAbility boneBladeAbility = new BoneBladeAbility();
      VulcanGauntletAbility vulcanGauntletAbility = new VulcanGauntletAbility(this);
      BloodLustAbilityListener bloodLustAbilityListener = new BloodLustAbilityListener(bloodLustKillTracker);
      KnightfallListener knightfallListener = new KnightfallListener(knightFallKillTracker);
      FrostScytheAbilityListener frostScytheAbilityListener = new FrostScytheAbilityListener(this);

      IllusionWandAbility illusionWandAbility = new IllusionWandAbility(this);
      Bukkit.getPluginManager().registerEvents(illusionWandAbility, this);

      CrazySlotsListener crazySlotsListener = new CrazySlotsListener(this);
      ScorchingBladeAbility scorchingBladeAbility = new ScorchingBladeAbility();

      Bukkit.getPluginManager().registerEvents(boneBladeAbility, this);
      Bukkit.getPluginManager().registerEvents(vulcanGauntletAbility, this);
      Bukkit.getPluginManager().registerEvents(bloodLustAbilityListener, this);
      Bukkit.getPluginManager().registerEvents(knightfallListener, this);
      Bukkit.getPluginManager().registerEvents(frostScytheAbilityListener, this);
      Bukkit.getPluginManager().registerEvents(crazySlotsListener, this);
      Bukkit.getPluginManager().registerEvents(scorchingBladeAbility, this);

      AbilityInputListener abilityInputListener = new AbilityInputListener();
      Bukkit.getPluginManager().registerEvents(abilityInputListener, this);
      this.getCommand("ability1").setExecutor(abilityInputListener);
      this.getCommand("ability2").setExecutor(abilityInputListener);

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

      CopperLeggingsEventManager var12 = new CopperLeggingsEventManager();
      this.getCommand("startleggingsevent").setExecutor(var12);
      Bukkit.getPluginManager().registerEvents(var12, this);

      CopperHelmetEventManager var4 = new CopperHelmetEventManager();
      Bukkit.getPluginManager().registerEvents(var4, this);
      this.getCommand("starthelmetevent").setExecutor(var4);

      CopperChestplateEventManager var5 = new CopperChestplateEventManager();
      Bukkit.getPluginManager().registerEvents(var5, this);
      this.getCommand("startchestplateevent").setExecutor(var5);

      Bukkit.getPluginManager().registerEvents(new CrazySelectorMenuListener(), this);
      Bukkit.getPluginManager().registerEvents(new LegendaryItemConfigMenu(), this);
      Bukkit.getPluginManager().registerEvents(new CopperOreVeinMinerListener(this), this);
      Bukkit.getPluginManager().registerEvents(new net.kingscraft.zenixmc.altarsmp.altars2.listener.AmethystToolListener(this), this);
      Bukkit.getPluginManager().registerEvents(this.altarController, this);
      Bukkit.getPluginManager().registerEvents(new EchoAbility(), this);
      Bukkit.getPluginManager().registerEvents(new StrikerBowAbility(), this);
      Bukkit.getPluginManager().registerEvents(new PaleCannonAbility(this), this);

      VampireEventManager var6 = new VampireEventManager();
      Bukkit.getPluginManager().registerEvents(var6, this);
      this.getCommand("vampire").setExecutor(var6);
      this.getCommand("vampire").setTabCompleter(var6);

      VampireEventManager.loadVampireData();
      VampireEventManager.startSunDamageTask();

      this.getCommand("altar").setExecutor(new AltarCommand(this.altarController, this.altarConfigManager));
      this.getCommand("legendaries").setExecutor(new LegendaryItemsMenu());
      this.getCommand("setkills").setExecutor(new SetKillsCommand());
      this.getCommand("setkills").setTabCompleter(new SetKillsCommand());

      WitherBoneAbility.startTask();

      this.getCommand("controls").setExecutor(new OffhandAbilityCommand(this));
      this.getCommand("checklegendary").setExecutor(new FindLegendaryItemDuplicatesCommand());

      this.registerTrust();

      Bukkit.getPluginManager().registerEvents(new LegendaryItemsMenu(), this);

      new BossBarManager();
      BossBarManager.startUpdater();

      new AltarReloadTask(this).runTaskLater(getInstance(), 40L);
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
               boolean hasCmdA = var2.hasCustomModelData();
               boolean hasCmdB = var3.hasCustomModelData();
               if (hasCmdA != hasCmdB) {
                  return false;
               }
               if (hasCmdA) {
                  return var2.getCustomModelData() == var3.getCustomModelData();
               }
               if (var2.hasItemModel()) {
                  return true;
               }
               return Objects.equals(var2.getDisplayName(), var3.getDisplayName());
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @EventHandler
   public void join(PlayerJoinEvent event) {
      Player player = event.getPlayer();
      if (getInstance().getConfig().getBoolean("reset_hearts_on_relog", true)) {
         player.setMaxHealth(20.0);
         AttributeInstance var3 = player.getAttribute(Attribute.MAX_HEALTH);
         var3.setBaseValue(20.0);
      }

      new CustomItemRefreshTask(player).runTaskLater(getInstance(), 20L);

      String PACK_URL = "https://download.mc-packs.net/pack/6854d1e3ba2be9c4a08c774a1058a749746c9ea0.zip";
      byte[] PACK_SHA1 = HexFormat.of().parseHex("6854d1e3ba2be9c4a08c774a1058a749746c9ea0");
      UUID PACK_UUID = UUID.fromString("fec0911a-8d2c-46fc-b277-c1cbbfe1dad3");
      String PACK_PROMPT = "§aThis Server Requires a Custom Resource Pack for Optimal Experience";

      // Merged Resource Pack
      player.addResourcePack(PACK_UUID, PACK_URL, PACK_SHA1, PACK_PROMPT, true);

   }

   @Override
   public void onDisable() {
      net.kingscraft.zenixmc.altarsmp.altars2.Altars2.shutdown();

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

   public static AltarSMP getInstance() {
      return instance;
   }

   public void registerTrust() {
      trust = new TrustManager();
      this.getCommand("trust").setExecutor(new TrustCommand(trust));
      this.getCommand("untrust").setExecutor(new TrustCommand(trust));
   }

   public static boolean isTrusted(Player var0, Entity var1) {
      return var1 instanceof Player var2 && TrustManager.isTrusted(var0, var2);
   }

   public AltarManager getConfigManager() {
      return this.altarConfigManager;
   }

   @EventHandler
   public void death(ItemDespawnEvent var1) {
       Item var2 = var1.getEntity();
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


}
