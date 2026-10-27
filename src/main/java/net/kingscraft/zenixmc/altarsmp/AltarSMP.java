package net.kingscraft.zenixmc.altarsmp;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HexFormat;
import java.util.Objects;
import java.util.UUID;

import net.kingscraft.zenixmc.altarsmp.altarS2.AltarS2;
import net.kingscraft.zenixmc.altarsmp.altarS2.weapon.amethyst.AmethystToolListener;
import net.kingscraft.zenixmc.altarsmp.command.*;
import net.kingscraft.zenixmc.altarsmp.core.update.UpdateChecker;
import net.kingscraft.zenixmc.altarsmp.core.update.UpdateNotifier;
import net.kingscraft.zenixmc.altarsmp.weapon.knightfall.KnightFallKillTracker;
import net.kingscraft.zenixmc.altarsmp.weapon.knightfall.KnightfallListener;
import net.kingscraft.zenixmc.altarsmp.core.KillTracker;
import net.kingscraft.zenixmc.altarsmp.weapon.crazy.CrazySlotsListener;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.IllusionWandAbility;
import net.kingscraft.zenixmc.altarsmp.listener.*;
import net.kingscraft.zenixmc.altarsmp.weapon.blood.BloodLustAbilityListener;
import net.kingscraft.zenixmc.altarsmp.weapon.boneblade.BoneBladeAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.frostscythe.FrostScytheAbilityListener;
import net.kingscraft.zenixmc.altarsmp.weapon.scorching.ScorchingBladeAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.vulcan.VulcanGauntletAbility;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
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
import net.kingscraft.zenixmc.altarsmp.weapon.paladin.PaladinEarthAbility;
import net.kingscraft.zenixmc.altarsmp.altar.AltarController;
import net.kingscraft.zenixmc.altarsmp.altar.AltarManager;
import net.kingscraft.zenixmc.altarsmp.altar.AltarReloadTask;
import net.kingscraft.zenixmc.altarsmp.altar.AltarRitualListener;
import net.kingscraft.zenixmc.altarsmp.copper.boots.CopperBootsSpeedAbility;
import net.kingscraft.zenixmc.altarsmp.copper.chestplate.CopperChestplateEventManager;
import net.kingscraft.zenixmc.altarsmp.copper.helmet.CopperHelmetEventManager;
import net.kingscraft.zenixmc.altarsmp.copper.leggings.CopperLeggingsEventManager;
import net.kingscraft.zenixmc.altarsmp.copper.leggings.CopperLeggingsShockwaveAbility;
import net.kingscraft.zenixmc.altarsmp.copper.pickaxe.CopperPickaxeListener;
import net.kingscraft.zenixmc.altarsmp.weapon.knightfall.KnightfallEnchantmentListener;
import net.kingscraft.zenixmc.altarsmp.copper.chestplate.CopperChestplateComboAbility;
import net.kingscraft.zenixmc.altarsmp.copper.helmet.CopperHelmetAbilityListener;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.core.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.event.bingo.BingoEventManager;
import net.kingscraft.zenixmc.altarsmp.weapon.crazy.CrazyRandomizerListener;
import net.kingscraft.zenixmc.altarsmp.weapon.crazy.CrazySelectorMenuListener;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.IllusionCoreRecipeListener;
import net.kingscraft.zenixmc.altarsmp.weapon.illusion.IllusionDisguiseManager;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRefreshTask;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.menu.LegendaryItemConfigMenu;
import net.kingscraft.zenixmc.altarsmp.menu.LegendaryItemsMenu;
import net.kingscraft.zenixmc.altarsmp.core.TrustManager;
import net.kingscraft.zenixmc.altarsmp.vampire.VampireListener;
import net.kingscraft.zenixmc.altarsmp.vampire.VampireEventManager;
import net.kingscraft.zenixmc.altarsmp.weapon.cutlass.CutlassAbility;
import net.kingscraft.zenixmc.altarsmp.weapon.gauntlet.EarthGauntletAbility;
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
   public static VampireListener NIGHT_PIERCER;
   public static ShadeSoul PURE_BLADE;
   public static WitherBoneAbility WITHER_BONE;
   public static EarthGauntletAbility EARTH_GAUNTLET;
   public static ShadowBladeAbility DARK_BLADE;
   public static TrustManager trust;

   private CopperHelmetAbilityListener copperHelmetAbilityListener;

   private net.kingscraft.zenixmc.altarsmp.core.update.UpdateChecker updateChecker;

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
      AltarS2.bootstrap(this);

      Bukkit.getPluginManager().registerEvents(new MobDropListener(this), this);
      Bukkit.getPluginManager().registerEvents(new AltarRitualListener(this.altarController), this);
      VampireListener.startPassiveTask();
      Bukkit.getPluginManager().registerEvents(new WeaponHandleRecipeListener(this), this);
      Bukkit.getPluginManager().registerEvents(new VulcanSkullRecipeListener(this), this);
      Bukkit.getPluginManager().registerEvents(new IllusionCoreRecipeListener(this), this);
      Bukkit.getPluginManager().registerEvents(new SeasonTwoRecipeListener(this), this);

      this.getCommand("cooldown").setExecutor(new ClearCooldownsCommand());

      NIGHT_PIERCER = new VampireListener();
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

      Bukkit.getPluginManager().registerEvents(new AbilityInputListener(), this);
      this.getCommand("ability1").setExecutor(new AbilityCommand());
      this.getCommand("ability2").setExecutor(new AbilityCommand());

      Bukkit.getPluginManager().registerEvents(new CrazyRandomizerListener(), this);
      Bukkit.getPluginManager().registerEvents(new CutlassAbility(), this);
      Bukkit.getPluginManager().registerEvents(new WindweaverAbility(this), this);
      Bukkit.getPluginManager().registerEvents(new PaladinEarthAbility(this), this);
      Bukkit.getPluginManager().registerEvents(this, this);
      Bukkit.getPluginManager().registerEvents(new IllusionDisguiseManager(), this);

      copperHelmetAbilityListener = new CopperHelmetAbilityListener(this);
      Bukkit.getPluginManager().registerEvents(copperHelmetAbilityListener, this);
      Bukkit.getPluginManager().registerEvents(new CopperLeggingsShockwaveAbility(this), this);
      Bukkit.getPluginManager().registerEvents(new CopperChestplateComboAbility(this), this);
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
      Bukkit.getPluginManager().registerEvents(new CopperPickaxeListener(this), this);
      Bukkit.getPluginManager().registerEvents(new AmethystToolListener(this), this);
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
      this.getCommand("legendaries").setExecutor(new LegendaryCommand());
      this.getCommand("setkills").setExecutor(new SetKillsCommand());
      this.getCommand("setkills").setTabCompleter(new SetKillsCommand());

      WitherBoneAbility.startTask();

      this.getCommand("controls").setExecutor(new OffhandAbilityCommand(this));
      this.getCommand("checklegendary").setExecutor(new FindLegendaryItemDuplicatesCommand());

      this.registerTrust();

      Bukkit.getPluginManager().registerEvents(new LegendaryItemsMenu(), this);

      BossBarManager.startUpdater();

      new AltarReloadTask(this).runTaskLater(getInstance(), 40L);

      try {
         updateChecker = new UpdateChecker(this);
         getServer().getScheduler().runTaskAsynchronously(this, () -> updateChecker.check());
         Bukkit.getPluginManager().registerEvents(new UpdateNotifier(updateChecker), this);
      } catch (Exception e) {
         getLogger().severe("An Error Occurred while trying to check for updates: " + e);
      }
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
               boolean hasCmdA = !var2.getCustomModelDataComponent().getFloats().isEmpty();
               boolean hasCmdB = !var3.getCustomModelDataComponent().getFloats().isEmpty();
               if (hasCmdA != hasCmdB) {
                  return false;
               }
               if (hasCmdA) {
                  return var2.getCustomModelDataComponent().getFloats().equals(var3.getCustomModelDataComponent().getFloats());
               }
               if (var2.hasItemModel()) {
                  return true;
               }
               return Objects.equals(var2.displayName(), var3.displayName());
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
         player.getAttribute(Attribute.MAX_HEALTH).setBaseValue(20.0);
         AttributeInstance var3 = player.getAttribute(Attribute.MAX_HEALTH);
         var3.setBaseValue(20.0);
      }

      new CustomItemRefreshTask(player).runTaskLater(getInstance(), 20L);

      String PACK_URL = "https://download.mc-packs.net/pack/6854d1e3ba2be9c4a08c774a1058a749746c9ea0.zip";
      byte[] PACK_SHA1 = HexFormat.of().parseHex("6854d1e3ba2be9c4a08c774a1058a749746c9ea0");
      UUID PACK_UUID = UUID.fromString("fec0911a-8d2c-46fc-b277-c1cbbfe1dad3");
      String PACK_PROMPT = LegacyComponentSerializer.legacySection().serialize(Component.text("This Server Requires a Custom Resource Pack for Optimal Experience", NamedTextColor.GREEN));

      // Merged Resource Pack
      player.addResourcePack(PACK_UUID, PACK_URL, PACK_SHA1, PACK_PROMPT, true);

   }

   @Override
   public void onDisable() {
      AltarS2.shutdown();

      if (this.bloodLustKillTracker != null) {
         this.bloodLustKillTracker.flush();
      }

      if (this.knightFallKillTracker != null) {
         this.knightFallKillTracker.flush();
      }

      if (this.altarController != null) {
         this.altarController.removeAllAltars();
      }

      if (copperHelmetAbilityListener != null)
         copperHelmetAbilityListener.stopEffectTask();

      for (Player var2 : Bukkit.getOnlinePlayers()) {
         BossBarManager.removeAllBars(var2);
         IllusionDisguiseManager.revealPlayer(var2);
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

      if (var4.getItemMeta().getCustomModelDataComponent().getFloats().isEmpty()) {
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

      Bukkit.broadcast(Component.text(var4.getItemMeta().displayName() == null ? "" : PlainTextComponentSerializer.plainText().serialize(var4.getItemMeta().displayName()))
              .append(Component.text(" Has been destroyed!", NamedTextColor.DARK_RED, TextDecoration.BOLD)));
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

         if (var4.getItemMeta().getCustomModelDataComponent().getFloats().isEmpty()) {
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

         Bukkit.broadcast(Component.text(PlainTextComponentSerializer.plainText().serialize(var4.getItemMeta().displayName()) + " ")
                 .append(Component.text("Has been destroyed!", NamedTextColor.DARK_RED, TextDecoration.BOLD)));
         CooldownManager.setCooldown(
            var2.getUniqueId(), "wait_a_bit", 1.0
         );
      }
   }


}
