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

      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764x.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
      this.killTracker = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a2(this);
      this.killTracker2 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764au(this);
      this.configManager = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br(this);
      this.altarManager = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bm(this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bl(this), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bk(this.altarManager), this);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ah.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b7(this), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b6(this), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b5(this), this);
      this.getCommand("cooldown").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a9());
      NIGHT_PIERCER = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ah();
      PURE_BLADE = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764am(this);
      WITHER_BONE = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ap();
      EARTH_GAUNTLET = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ak();
      DARK_BLADE = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764an();
      Bukkit.getPluginManager().registerEvents(NIGHT_PIERCER, this);
      Bukkit.getPluginManager().registerEvents(PURE_BLADE, this);
      Bukkit.getPluginManager().registerEvents(WITHER_BONE, this);
      Bukkit.getPluginManager().registerEvents(EARTH_GAUNTLET, this);
      Bukkit.getPluginManager().registerEvents(DARK_BLADE, this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764as(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ar(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bx(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cf(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aj(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ao(this), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al(this), this);
      Bukkit.getPluginManager().registerEvents(this, this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764az(this), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a0(this), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ay(this), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ax(this), this);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be var11 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764be(
         this
      );
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
      Bukkit.getPluginManager().registerEvents(this.altarManager, this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aq(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aw(), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai(this), this);
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b_(), this);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj var6 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj();
      Bukkit.getPluginManager().registerEvents(var6, this);
      this.getCommand("vampire").setExecutor(var6);
      this.getCommand("vampire").setTabCompleter(var6);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c();
      this.getCommand("altar")
         .setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a8(this.altarManager, this.configManager));
      this.getCommand("legendaries").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_());
      this.getCommand("setkills").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ba());
      this.getCommand("setkills").setTabCompleter(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ba());
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ap.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
      this.getCommand("controls").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764q(this));
      this.getCommand("giveselector").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764r(this));
      Objects.requireNonNull(this.getCommand("dtest")).setExecutor(Main::lambda$onEnable$0);
      this.getCommand("checklegendary").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764s(this));
      Objects.requireNonNull(this.getCommand("credits")).setExecutor(Main::lambda$onEnable$1);
      this.registerTrust();
      Bukkit.getPluginManager().registerEvents(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_(), this);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
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
      if (this.killTracker != null) {
         this.killTracker.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d();
      }

      if (this.killTracker2 != null) {
         this.killTracker2.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d();
      }

      if (this.altarManager != null) {
         this.altarManager.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b();
      }

      for (Player var2 : Bukkit.getOnlinePlayers()) {
         You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
            var2
         );
         You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
            var2
         );
      }
   }

   public static Main getInstance() {
      return instance;
   }

   public void registerTrust() {
      trust = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9();
      this.getCommand("trust").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b8(trust));
      this.getCommand("untrust").setExecutor(new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b8(trust));
   }

   public static boolean isTrusted(Player var0, Entity var1) {
      return var1 instanceof Player var2
         ? You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b9.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(
            var0, var2
         )
         : false;
   }

   public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764br getConfigManager() {
      return this.configManager;
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

         if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
            var2.getUniqueId(), "wait_a_bit"
         )) {
            return;
         }

         Bukkit.broadcastMessage(var4.getItemMeta().getDisplayName() + " §4§lHas been destroyed!");
         You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
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

         if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
            var2.getUniqueId(), "wait_a_bit"
         )) {
            return;
         }

         Bukkit.broadcastMessage(var4.getItemMeta().getDisplayName() + " §4§lHas been destroyed!");
         You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
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
         if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(
            var4
         )) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(
               var4
            );
            return true;
         }

         You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(
            var4, EntityType.ZOMBIE, null
         );
      }

      return true;
   }

   // $VF: Irreducible bytecode was duplicated to produce valid code


}
