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

public class AbilityInputListener implements Listener, CommandExecutor {
  
  
  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    if (paramCommandSender instanceof Player) {
      Player player = (Player)paramCommandSender;
      {
        if (paramCommand.getName().equals("ability1")) {
          activateDayNightAbilityOne(player);
          return true;
        } 
      }{
        if (paramCommand.getName().equals("ability2")) {
          activateDayNightAbilityTwo(player);
          return true;
        } 
      }} 
    return true;
  }
  
  @EventHandler
  public void onPlayerSwapHandItems(PlayerSwapHandItemsEvent paramPlayerSwapHandItemsEvent) {
    Player player = paramPlayerSwapHandItemsEvent.getPlayer();
    {
      if (!Main.getInstance().getConfig().getBoolean("offhand." + player.getName(), true))
        return; 
    }{
      if (!player.isSneaking()) {
        {
          if (activateMainHandAbility(player))
            paramPlayerSwapHandItemsEvent.setCancelled(true); 
        }} else {
        {
          if (activateOffhandAbility(player))
            paramPlayerSwapHandItemsEvent.setCancelled(true); 
        }} 
    }}
  
  public static boolean activateMainHandAbility(Player paramPlayer) {
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
          if (IllusionDisguiseManager.isDisguised(paramPlayer))
            IllusionWandAbility.useMobAbility(paramPlayer, IllusionDisguiseManager.getDisguisedEntityType(paramPlayer));
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getCutlass())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), CutlassAbility.cutsCooldownKey))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("CutlassCutsCooldown", 15);
        paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        BossBarManager.createBar(paramPlayer, "Thousand Cuts", k, ChatColor.YELLOW);
        CutlassAbility.startCutlassAttack(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), CutlassAbility.cutsCooldownKey, k);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getPaleCannon())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "PaleRoots"))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("paleRootsCooldown", 45);
        PaleCannonAbility.spawnPaleRoots(paramPlayer);
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
                (new MeteorStrikeCooldownTask(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), EarthGauntletAbility.meteorUseDuration * 20L - 1L);
                return true;
              } 
              return true;
            }}return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getPaladinAxe())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), PaladinEarthAbility.EARTH_SHATTER_COOLDOWN_KEY))
            return true; 
        }{
          paramPlayer.updateInventory();
          if (PaladinEarthAbility.activateEarthShatter(paramPlayer)) {
            BossBarManager.createBar(paramPlayer, "Earth Shatter", PaladinEarthAbility.EARTH_SHATTER_COOLDOWN, ChatColor.YELLOW);
            CooldownManager.setCooldown(paramPlayer.getUniqueId(), PaladinEarthAbility.EARTH_SHATTER_COOLDOWN_KEY, PaladinEarthAbility.EARTH_SHATTER_COOLDOWN);
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
        WindweaverAbility.activateWindLeap(paramPlayer);
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
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), EchoAbility.ECHO_SONIC_COOLDOWN_KEY))
            return true; 
        }paramPlayer.updateInventory();
        EchoAbility.activateSonicCharge(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), EchoAbility.ECHO_SONIC_COOLDOWN_KEY, i);
        BossBarManager.createBar(paramPlayer, "Sonic Blast", i, ChatColor.YELLOW);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getEclipse())) {
        activateDayNightAbilityOne(paramPlayer);
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
            BloodLustAbilityListener.launchBloodHook(paramPlayer);
          } 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getBoneBlade())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), BoneBladeAbility.SKELETAL_LEAP_ABILITY_ID))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("skeletalLeapCooldown", 30);
        paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), BoneBladeAbility.SKELETAL_LEAP_ABILITY_ID, k);
        BoneBladeAbility.skeletalLeap(paramPlayer);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getFrostScythe())) {
        {
          if (Main.getInstance().getConfig().getBoolean("holdForThrowFrostScythe", true))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("scytheThrowCooldown", 30);
        {
          if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), FrostScytheAbilityListener.SCYTHE_THROW_COOLDOWN_KEY)) {
            FrostScytheAbilityListener.launchScythe(paramPlayer);
            CooldownManager.setCooldown(paramPlayer.getUniqueId(), FrostScytheAbilityListener.SCYTHE_THROW_COOLDOWN_KEY, k);
            BossBarManager.createBar(paramPlayer, "Scythe Throw", k, ChatColor.YELLOW);
          } 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getHyperion())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), ScorchingBladeAbility.THUNDERSTRIKE_COOLDOWN_KEY))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("holyLanceCooldown", 60);
        {
          if (ScorchingBladeAbility.activateThunderstrike(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
            CooldownManager.setCooldown(paramPlayer.getUniqueId(), ScorchingBladeAbility.THUNDERSTRIKE_COOLDOWN_KEY, k);
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
        if (NukeAbility.activateNuke(paramPlayer)) {
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
          if (!StrikerBowAbility.activeOrbitalShotPlayers.contains(paramPlayer.getUniqueId())) {
            paramPlayer.sendActionBar("§e§lᴍᴏᴅᴇ: §cᴏʀʙɪᴛᴀʟ ꜱᴛʀɪᴋᴇ");
            StrikerBowAbility.activeOrbitalShotPlayers.add(paramPlayer.getUniqueId());
          } else {
            paramPlayer.sendActionBar("§e§lᴍᴏᴅᴇ: §cꜱᴛᴀʙꜱʜᴏᴛ");
            StrikerBowAbility.activeOrbitalShotPlayers.remove(paramPlayer.getUniqueId());
          } 
        }return true;
      } 
    }return false;
  }
  
  public static boolean activateOffhandAbility(Player paramPlayer) {
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
          if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), CutlassAbility.parryCooldownKey))
            {
              if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "active_parry")) {
                int k = Main.getInstance().getConfig().getInt("CutlassParryDuration", 7);
                paramPlayer.swingMainHand();
                paramPlayer.updateInventory();
                BossBarManager.createBar(paramPlayer, "§6§l!! §e§lParry x3 §6§l!!", k, ChatColor.YELLOW, BarColor.RED);
                CooldownManager.setCooldown(paramPlayer.getUniqueId(), "active_parry", k);
                (new CutlassParryActivationTask(paramPlayer)).runTaskLater((Plugin)Main.getInstance(), 20L * k - 1L);
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
          if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), PaladinEarthAbility.STALWART_ABSORPTION_COOLDOWN_KEY))
            {
              if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "StalwartAbsorption")) {
                paramPlayer.updateInventory();
                PaladinEarthAbility.activateStalwartAbsorption(paramPlayer);
                BossBarManager.createBar(paramPlayer, "Stalwart Absorption", PaladinEarthAbility.STALWART_ABSORPTION_DURATION, ChatColor.GREEN);
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
          if (((Boolean) WindweaverAbility.isCharging.getOrDefault(paramPlayer.getUniqueId(), Boolean.valueOf(false))).booleanValue()) {
            WindweaverAbility.activateWindGust(paramPlayer);
          } else {
            WindweaverAbility.startWindGustCharge(paramPlayer);
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
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), EchoAbility.ECHO_SHRIEK_COOLDOWN_KEY))
            return true; 
        }paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        EchoAbility.activateEchoShriek(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), EchoAbility.ECHO_SHRIEK_COOLDOWN_KEY, i);
        BossBarManager.createBar(paramPlayer, "Echo Shriek", i, ChatColor.YELLOW);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getEclipse())) {
        activateDayNightAbilityTwo(paramPlayer);
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
            BloodLustAbilityListener.startBloodTrailEffect(paramPlayer);
          } 
        }return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getBoneBlade())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), BoneBladeAbility.BONE_CAGE_ABILITY_ID))
            return true; 
        }paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        int k = Main.getInstance().getConfig().getInt("boneCageCooldown", 20);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_SKELETON_DEATH, 1.0F, 1.0F);
        paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_VAULT_AMBIENT, 1.0F, 1.0F);
        BoneBladeAbility.boneCage(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), BoneBladeAbility.BONE_CAGE_ABILITY_ID, k);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getFrostScythe())) {
        {
          if (CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), FrostScytheAbilityListener.ICE_THROW_COOLDOWN_KEY))
            return true; 
        }int k = Main.getInstance().getConfig().getInt("commandOfIceCooldown", 45);
        paramPlayer.swingMainHand();
        paramPlayer.updateInventory();
        FrostScytheAbilityListener.activateCommandOfIce(paramPlayer);
        CooldownManager.setCooldown(paramPlayer.getUniqueId(), FrostScytheAbilityListener.ICE_THROW_COOLDOWN_KEY, k);
        return true;
      } 
    }{
      if (Main.areSimilar(itemStack, CustomItemRegistry.getHyperion())) {
        {
          if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), ScorchingBladeAbility.SCORCHING_BLADE_COOLDOWN_KEY))
            {
              if (!CooldownManager.isOnCooldown(paramPlayer.getUniqueId(), "scorchingPending")) {
                paramPlayer.updateInventory();
                ScorchingBladeAbility.activateScorchingBlade(paramPlayer);
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
          if (!StrikerBowAbility.activeOrbitalShotPlayers.contains(paramPlayer.getUniqueId())) {
            paramPlayer.sendActionBar("§e§lᴍᴏᴅᴇ: §cᴏʀʙɪᴛᴀʟ ꜱᴛʀɪᴋᴇ");
            StrikerBowAbility.activeOrbitalShotPlayers.add(paramPlayer.getUniqueId());
          } else {
            paramPlayer.sendActionBar("§e§lᴍᴏᴅᴇ: §cꜱᴛᴀʙꜱʜᴏᴛ");
            StrikerBowAbility.activeOrbitalShotPlayers.remove(paramPlayer.getUniqueId());
          } 
        }return true;
      } 
    }return false;
  }
  
  public static void activateDayNightAbilityOne(Player paramPlayer) {
    {
      if (paramPlayer.getWorld().isDayTime()) {
        {
          if (EclipseAbility.solarExplosion(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
          } 
        }} else {
        {
          if (EclipseAbility.moonlitStars(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
          } 
        }} 
    }}
  
  public static void activateDayNightAbilityTwo(Player paramPlayer) {
    {
      if (paramPlayer.getWorld().isDayTime()) {
        {
          if (EclipseAbility.solarLeap(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
          } 
        }} else {
        {
          if (EclipseAbility.moonlitShadows(paramPlayer)) {
            paramPlayer.swingMainHand();
            paramPlayer.updateInventory();
          } 
        }} 
    }}


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764y.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */