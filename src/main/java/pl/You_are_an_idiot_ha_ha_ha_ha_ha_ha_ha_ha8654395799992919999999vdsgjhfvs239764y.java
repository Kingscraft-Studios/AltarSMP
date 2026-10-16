package pl;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764y implements Listener, CommandExecutor {
  
  
  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    if (paramCommandSender instanceof Player) {
      Player player = (Player)paramCommandSender;
      {
        if (paramCommand.getName().equals("ability1")) {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
          return true;
        } 
      }{
        if (paramCommand.getName().equals("ability2")) {
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
          return true;
        } 
      }} 
    return true;
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerSwapHandItemsEvent paramPlayerSwapHandItemsEvent) {
    Player player = paramPlayerSwapHandItemsEvent.getPlayer();
    {
      if (!Main.getInstance().getConfig().getBoolean("offhand." + player.getName(), true))
        return; 
    }{
      if (!player.isSneaking()) {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player))
            paramPlayerSwapHandItemsEvent.setCancelled(true); 
        }} else {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(player))
            paramPlayerSwapHandItemsEvent.setCancelled(true); 
        }} 
    }}
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    {
      if (WorldGuardHook.isBlocked(paramPlayer.getLocation()))
        return false; 
    }ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    int i = Main.getInstance().getConfig().getInt("echoSonicBlastCooldown", 40);
    int j = Main.getInstance().getConfig().getInt("legendaryLimit", -1);
    {
      if (j != -1)
        {
          if (CustomItem.countInInventory(paramPlayer) > j) {
            paramPlayer.sendMessage("§eThe legendary limit is " + j);
            paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
            return false;
          } 
        }}{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getIllusionWand())) {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(paramPlayer))
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ab.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer)); 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getCutlass())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("CutlassCutsCooldown", 15);
        paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        BossBarManager.createBar(paramPlayer, "Thousand Cuts", k, ChatColor.YELLOW);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, k);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getPaleCannon())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "PaleRoots"))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("paleRootsCooldown", 45);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
        BossBarManager.createBar(paramPlayer, "Pale Roots", k, ChatColor.YELLOW);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), "PaleRoots", k);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getEarthGauntlet())) {
        if (EarthGauntletAbility.meteorStrikeTargets.containsKey(paramPlayer.getUniqueId())) {
          LivingEntity livingEntity = EarthGauntletAbility.meteorStrikeTargets.get(paramPlayer.getUniqueId());
          BossBarManager.removeBar(paramPlayer, "!! Pull Target !!");
          EarthGauntletAbility.applyMudslide(livingEntity, paramPlayer);
          EarthGauntletAbility.meteorStrikeTargets.remove(paramPlayer.getUniqueId());
          return true;
        } 
        {
          if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), EarthGauntletAbility.meteorStrikeCooldownKey))
            {
              if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "used_meteor")) {
                paramPlayer.updateInventory();
                BossBarManager.createBar(paramPlayer, "Meteor Strike", EarthGauntletAbility.meteorUseDuration, ChatColor.GREEN);
                CooldownManager.setCooldown(paramPlayer.getUniqueId(), "used_meteor", EarthGauntletAbility.meteorUseDuration);
                paramPlayer.getWorld().playSound((Entity)paramPlayer, Sound.ENTITY_EVOKER_PREPARE_ATTACK, 1.0F, 1.0F);
                paramPlayer.getWorld().spawnParticle(Particle.WITCH, paramPlayer.getLocation().clone().add(0.0D, 1.0D, 0.0D), 120, 0.2D, 0.5D, 0.2D, 0.1D);
                (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cq(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), EarthGauntletAbility.meteorUseDuration * 20L - 1L);
                return true;
              } 
              return true;
            }}return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getPaladinAxe())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e))
            return true; 
        }{
          paramPlayer.updateInventory();
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(paramPlayer)) {
            BossBarManager.createBar(paramPlayer, "Earth Shatter", You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, ChatColor.YELLOW);
            CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b);
          } 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getPureBlade())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), ShadeSoul.shadePart))
            return true; 
        }
        ShadeSoul.castShadeSoul(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), ShadeSoul.shadePart, ShadeSoul.shadeSoulCooldown);
        BossBarManager.createBar(paramPlayer, "Shade Soul", ShadeSoul.shadeSoulCooldown, ChatColor.YELLOW);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getShadowBlade())) {
        ShadowBladeAbility.activateShadowDaggers(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getWindweaver())) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ao.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getWitheredBone())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), WitherBoneAbility.leapCooldownKey))
            return true; 
        }paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        WitherBoneAbility.performLeap(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getEcho())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aq.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b))
            return true; 
        }paramPlayer.updateInventory();
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aq.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aq.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, i);
        BossBarManager.createBar(paramPlayer, "Sonic Blast", i, ChatColor.YELLOW);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getEclipse())) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getKnightfall(paramPlayer, false))) {
        {
          if ((Main.getInstance()).knightFallKillTracker.getKillCount(paramPlayer) >= 4)
            {
              if (KnightfallListener.useGrapplingHook(paramPlayer)) {
                paramPlayer.swingMainHand();
                paramPlayer.updateInventory();
              } 
            }}return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getBloodlust(null, false))) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "bloodHook"))
            return true; 
        }{
          if ((Main.getInstance()).bloodLustKillTracker.getKillCount(paramPlayer) >= 5) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764z.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764i(paramPlayer);
          } 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getBoneBlade())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("skeletalLeapCooldown", 30);
        paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, k);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getFrostScythe())) {
        {
          if (Main.getInstance().getConfig().getBoolean("holdForThrowFrostScythe", true))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("scytheThrowCooldown", 30);
        {
          if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c)) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
            CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, k);
            BossBarManager.createBar(paramPlayer, "Scythe Throw", k, ChatColor.YELLOW);
          } 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getHyperion())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("holyLanceCooldown", 60);
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
            CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c, k);
            BossBarManager.createBar(paramPlayer, "Holy Lance", k, ChatColor.YELLOW);
          } 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getNightpiercer())) {
        Vampire.crimsonBite(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getVulcanCrossbow())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "charged_vulcan_powershot"))
            return true; 
        }{
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "vulcan_powershot"))
            return true; 
        }
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), "charged_vulcan_powershot", 30.0D);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.0F, 1.0F);
        paramPlayer.sendMessage("§c§lCharged your Vulcan's Crossbow");
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getNukeRemote())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "nukeRemoteCooldownMinutes"))
            return true; 
        }paramPlayer.updateInventory();
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764av.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer)) {
          int k = Main.getInstance().getConfig().getInt("nukeRemoteCooldownMinutes") * 60;
          CooldownManager.setCooldown(paramPlayer.getUniqueId(), "nukeRemoteCooldownMinutes", k);
          BossBarManager.createBar(paramPlayer, "Nuke", k, ChatColor.YELLOW);
        } 
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getStrikerBow())) {
        {
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
          if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.contains(paramPlayer.getUniqueId())) {
            paramPlayer.sendActionBar("§e§lᴍᴏᴅᴇ: §cᴏʀʙɪᴛᴀʟ ꜱᴛʀɪᴋᴇ");
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.add(paramPlayer.getUniqueId());
          } else {
            paramPlayer.sendActionBar("§e§lᴍᴏᴅᴇ: §cꜱᴛᴀʙꜱʜᴏᴛ");
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.remove(paramPlayer.getUniqueId());
          } 
        }return true;
      } 
    }return false;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b__v0(Player paramPlayer) {
    {
      if (WorldGuardHook.isBlocked(paramPlayer.getLocation()))
        return false; 
    }int i = Main.getInstance().getConfig().getInt("echoShriekCooldown", 60);
    int j = Main.getInstance().getConfig().getInt("legendaryLimit", -1);
    {
      if (j != -1)
        {
          if (CustomItem.countInInventory(paramPlayer) > j) {
            paramPlayer.sendMessage("§eThe legendary limit is " + j);
            paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
            return false;
          } 
        }}ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    {
      if (Main.areSimilar(itemStack, CustomItemRegistry.getCutlass())) {
        {
          if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aj.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b))
            {
              if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "active_parry")) {
                int k = Main.getInstance().getConfig().getInt("CutlassParryDuration", 7);
                paramPlayer.swingMainHand();
                paramPlayer.updateInventory();
                BossBarManager.createBar(paramPlayer, "§6§l!! §e§lParry x3 §6§l!!", k, ChatColor.YELLOW, BarColor.RED);
                CooldownManager.setCooldown(paramPlayer.getUniqueId(), "active_parry", k);
                (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cr(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), 20L * k - 1L);
                return true;
              } 
              return true;
            }}return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getEarthGauntlet())) {
        if (EarthGauntletAbility.meteorStrikeTargets.containsKey(paramPlayer.getUniqueId())) {
          LivingEntity livingEntity = EarthGauntletAbility.meteorStrikeTargets.get(paramPlayer.getUniqueId());
          BossBarManager.removeBar(paramPlayer, "!! Pull Target !!");
          EarthGauntletAbility.applyMudslide(livingEntity, paramPlayer);
          EarthGauntletAbility.meteorStrikeTargets.remove(paramPlayer.getUniqueId());
          return true;
        } 
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), EarthGauntletAbility.mudslideCooldownKey))
            return true; 
        }
        BossBarManager.createBar(paramPlayer, "Mudslide", EarthGauntletAbility.mudslideCooldown, ChatColor.YELLOW);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), EarthGauntletAbility.mudslideCooldownKey, EarthGauntletAbility.mudslideCooldown);
        EarthGauntletAbility.activateMeteorStrike(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getPaladinAxe())) {
        {
          if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764f))
            {
              if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "StalwartAbsorption")) {
                paramPlayer.updateInventory();
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer);
                BossBarManager.createBar(paramPlayer, "Stalwart Absorption", You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764al.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d, ChatColor.GREEN);
                return true;
              } 
              return true;
            }}return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getPureBlade())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), ShadeSoul.slashPart))
            return true; 
        }paramPlayer.updateInventory();
        ShadeSoul.castHolyLance(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), ShadeSoul.slashPart, ShadeSoul.cycloneSlashCooldown);
        BossBarManager.createBar(paramPlayer, "Cyclone Slash", ShadeSoul.cycloneSlashCooldown, ChatColor.YELLOW);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getShadowBlade())) {
        ShadowBladeAbility.activateShadowLeap(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getWindweaver())) {
        {
          if (((Boolean)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ao.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e.getOrDefault(paramPlayer.getUniqueId(), Boolean.valueOf(false))).booleanValue()) {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ao.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
          } else {
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ao.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer);
          } 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getWitheredBone())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), WitherBoneAbility.cleansingCooldownKey))
            return true; 
        }
          WitherBoneAbility.performCleansing(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getEcho())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aq.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a))
            return true; 
        }paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aq.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aq.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, i);
        BossBarManager.createBar(paramPlayer, "Echo Shriek", i, ChatColor.YELLOW);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getEclipse())) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getKnightfall(paramPlayer, false))) {
        {
          if ((Main.getInstance()).knightFallKillTracker.getKillCount(paramPlayer) >= 10)
            {
              if (KnightfallListener.throwHammer(paramPlayer)) {
                paramPlayer.swingMainHand();
                paramPlayer.updateInventory();
              } 
            }}return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getBloodlust(null, false))) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "bloodTrail"))
            return true; 
        }{
          if ((Main.getInstance()).bloodLustKillTracker.getKillCount(paramPlayer) >= 3) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764z.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g(paramPlayer);
          } 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getBoneBlade())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a))
            return true; 
        }paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        int k = Main.getInstance().getConfig().getInt("boneCageCooldown", 20);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1.0F, 1.0F);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_VAULT_AMBIENT, 1.0F, 1.0F);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764_.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, k);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getFrostScythe())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("commandOfIceCooldown", 45);
        paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aa.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, k);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getHyperion())) {
        {
          if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b))
            {
              if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "scorchingPending")) {
                paramPlayer.updateInventory();
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ag.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer);
                return true;
              } 
              return true;
            }}return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getNightpiercer())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "batFlight"))
            return true; 
        }paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        Vampire.transformIntoBat(paramPlayer);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_BAT_AMBIENT, 1.0F, 1.0F);
        int k = Main.getInstance().getConfig().getInt("transformationCooldown", 30);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), "batFlight", k);
        BossBarManager.createBar(paramPlayer, "Transformation", k, ChatColor.YELLOW);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getStrikerBow())) {
        {
          paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
          if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.contains(paramPlayer.getUniqueId())) {
            paramPlayer.sendActionBar("§e§lᴍᴏᴅᴇ: §cᴏʀʙɪᴛᴀʟ ꜱᴛʀɪᴋᴇ");
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.add(paramPlayer.getUniqueId());
          } else {
            paramPlayer.sendActionBar("§e§lᴍᴏᴅᴇ: §cꜱᴛᴀʙꜱʜᴏᴛ");
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764aw.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a.remove(paramPlayer.getUniqueId());
          } 
        }return true;
      } 
    }return false;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    {
      if (paramPlayer.getWorld().isDayTime()) {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ar.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
          } 
        }} else {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ar.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
          } 
        }} 
    }}
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    {
      if (paramPlayer.getWorld().isDayTime()) {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ar.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
          } 
        }} else {
        {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ar.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
          } 
        }} 
    }}
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764y.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */