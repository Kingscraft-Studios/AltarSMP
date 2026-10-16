package pl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.entity.TextDisplay;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Transformation;

public class AltarRitualListener implements Listener {
  public final AltarController altarController;
  
  public final Map<UUID, Long> missingIngredientsCooldowns = new HashMap<>();
  
  public static final long MISSING_INGREDIENTS_COOLDOWN = 1000L;
  
  private static Map<UUID, UUID> copperHelmetPlayers;
  
  private static Map<UUID, UUID> copperChestplatePlayers;
  
  private static final double CONTAGION_RITUAL_DURATION = Main.getInstance().getConfig().getDouble("contagion_ritual_duration", 10.0D);
  
  public static final int CONTAGION_SIGNAL_HEALTH = Main.getInstance().getConfig().getInt("contagion_signal_health", 50);
  
  public static HashMap<Interaction, Integer> contagionInteractions;
  
  
  
  public AltarRitualListener(AltarController altarController) {
    this.altarController = altarController;
  }
  
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    List<RecipeIngredient> list;
    UUID uUID;
    long l = 0;
    {
      if (paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_BLOCK)
        return; 
    }{
      if (paramPlayerInteractEvent.getClickedBlock() == null)
        return; 
    }{
      if (!paramPlayerInteractEvent.getClickedBlock().getType().toString().contains("STRUCTURE_BLOCK"))
        return; 
    }Player player = paramPlayerInteractEvent.getPlayer();
    Location location = paramPlayerInteractEvent.getClickedBlock().getLocation().clone().add(0.5D, 0.0D, 0.5D);
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    {
      if (Main.areSimilar(itemStack, CustomItemRegistry.getContagionSignal())) {
        player.sendMessage("starting");
        itemStack.setAmount(itemStack.getAmount() - 1);
        paramPlayerInteractEvent.setCancelled(true);
        startContagionRitual(location, player);
        return;
      } 
    }
    AltarInstance you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 = this.altarController.getAltarInstance(paramPlayerInteractEvent.getClickedBlock().getLocation());
    {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1 == null)
        return; 
    }{
      paramPlayerInteractEvent.setCancelled(true);
      if (this.altarController.isAltarUsed(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getLocation()))
        return; 
    }
    Altar you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bs = Main.getInstance().getConfigManager().getAltar(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getType());
    {
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bs == null)
        return; 
    }Iterator<AltarRecipe> iterator = you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bs.getRecipe().values().iterator();
    if (iterator.hasNext()) {
      AltarRecipe you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b2 = iterator.next();
      list = this.altarController.getMissingIngredients(player, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b2);
      if (list.isEmpty()) {
        consumeIngredients(player, you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b2);
        ItemStack itemStack1 = AltarController.createItemStack(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getType());
        {
          player.getInventory().addItem(new ItemStack[] { itemStack1 });
          if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getType().equalsIgnoreCase("crazyslots"))
            player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DRAGON_EGG) }); 
        }{
          if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getType().equalsIgnoreCase("copperhelmet"))
            copperHelmetPlayers.put(player.getUniqueId(), player.getUniqueId());
        }{
          if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getType().equalsIgnoreCase("copperchestplate"))
            copperChestplatePlayers.put(player.getUniqueId(), player.getUniqueId());
        }you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getLocation().getWorld().strikeLightning(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getLocation());
        this.altarController.broadcastCraftAnnouncement(player, itemStack1);
        this.altarController.setAltarUsed(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getLocation(), true);
        this.altarController.getItemDisplayScale(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.getType());
        you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b1.removeItemDisplay();
        return;
      } 
      uUID = player.getUniqueId();
      l = System.currentTimeMillis();
      Long long_ = this.missingIngredientsCooldowns.get(uUID);
      {
        if (long_ != null) {
          {
            if (l - long_.longValue() >= 1000L) {
              this.altarController.sendMissingIngredients(player, list);
              this.missingIngredientsCooldowns.put(uUID, Long.valueOf(l));
              return;
            } 
          }return;
        } 
      }} else {
      player.sendMessage(String.valueOf(ChatColor.RED) + "No valid recipe found!");
      return;
    } 
    this.altarController.sendMissingIngredients(player, list);
    this.missingIngredientsCooldowns.put(uUID, Long.valueOf(l));
  }
  
  public static void startContagionRitual(Location paramLocation, Player paramPlayer) {
    Location location = paramLocation.clone();
    String str1 = VampireEventManager.getPlayerType(paramPlayer);
    if (str1.isEmpty())
      str1 = "HUMAN"; 
    World world = paramLocation.getWorld();
    ItemDisplay itemDisplay = (ItemDisplay)world.spawnEntity(location, EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(CustomItemRegistry.getContagionSignal());
    Transformation transformation1 = itemDisplay.getTransformation();
    transformation1.getTranslation().set(0.0D, 1.5D, 0.0D);
    itemDisplay.setTransformation(transformation1);
    itemDisplay.setTeleportDuration(1);
    animateContagionSignal(itemDisplay);
    TextDisplay textDisplay = (TextDisplay)world.spawnEntity(location.clone().add(0.0D, 2.5D, 0.0D), EntityType.TEXT_DISPLAY);
    textDisplay.setBillboard(Display.Billboard.CENTER);
    String str2 = "";
    for (byte b1 = 0; b1 < CONTAGION_SIGNAL_HEALTH; b1++)
      str2 = str2 + "§a|";
    textDisplay.setText(str2);
    Transformation transformation2 = textDisplay.getTransformation();
    transformation2.getTranslation().set(0.0F, 0.0F, 0.0F);
    textDisplay.setTransformation(transformation2);
    Interaction interaction = (Interaction)world.spawnEntity(location.clone().add(0.0D, 1.0D, 0.0D), EntityType.INTERACTION);
    interaction.setInteractionHeight(1.5F);
    interaction.setInteractionWidth(1.0F);
    interaction.setResponsive(false);
    int i = (int)(CONTAGION_RITUAL_DURATION * 60.0D * 20.0D);
    startContagionSequence(str1, paramLocation);
    BossBar bossBar = Bukkit.createBossBar("§a§kaa §f" + str1 + " §aCONTAGION RITUAL §a§kaa", BarColor.PINK, BarStyle.SOLID, new org.bukkit.boss.BarFlag[0]);
    byte b2 = 5;
    String str3 = str1;
    (new ContagionSignalAnimationTask(interaction, bossBar, paramLocation, itemDisplay, textDisplay, i, str3, b2)).runTaskTimer((Plugin)Main.getInstance(), 140L, 1L);
  }
  
  public static void animateContagionSignal(ItemDisplay paramItemDisplay) {
    Location location = paramItemDisplay.getLocation();
    paramItemDisplay.setTeleportDuration(20);
    (new ContagionSignalItemAnimationTask(paramItemDisplay, location)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  @EventHandler
  public void onEntityDamageByEntity(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player;
    Interaction interaction;
    Entity entity1 = paramEntityDamageByEntityEvent.getDamager();
    if (entity1 instanceof Player) {
      player = (Player)entity1;
    } else {
      return;
    } 
    Entity entity2 = paramEntityDamageByEntityEvent.getEntity();
    if (entity2 instanceof Interaction) {
      interaction = (Interaction)entity2;
    } else {
      return;
    } 
    {
      if (!contagionInteractions.containsKey(interaction))
        return; 
    }{
      if (CooldownManager.isOnCooldown(player.getUniqueId(), "contagion_hit"))
        return; 
    }
      CooldownManager.setCooldown(player.getUniqueId(), "contagion_hit", 0.5D);
    int i = ((Integer) contagionInteractions.merge(interaction, Integer.valueOf(-1), Integer::sum)).intValue();
    {
      player.playSound((Entity)player, Sound.ENTITY_PLAYER_ATTACK_CRIT, 1.0F, 1.0F);
      player.playSound((Entity)player, Sound.ENTITY_PLAYER_ATTACK_STRONG, 1.0F, 1.0F);
      if (i <= 0) {
        contagionInteractions.remove(interaction);
        interaction.setResponsive(false);
      } 
    }}
  
  public static void startContagionSequence(String paramString, Location paramLocation) {
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.sendMessage(" ");
      player.sendMessage("§8>> §a# SUCCESSFULLY DOCKED TO ALTAR");
      player.sendMessage("§eBEGINNING BOOT SEQUENCE...");
      player.sendMessage(" ");
    } 
    (new ContagionRitualAnnouncementTask(paramString)).runTaskLater((Plugin)Main.getInstance(), 40L);
    (new ContagionRitualCoordinatesAnnouncementTask(paramLocation)).runTaskLater((Plugin)Main.getInstance(), 80L);
    (new ContagionRitualBootSequenceTask()).runTaskLater((Plugin)Main.getInstance(), 120L);
  }
  
  public static boolean isCopperHelmetPlayer(Player paramPlayer) {
    return copperHelmetPlayers.containsKey(paramPlayer.getUniqueId());
  }
  
  public static boolean isCopperChestplatePlayer(Player paramPlayer) {
    return copperChestplatePlayers.containsKey(paramPlayer.getUniqueId());
  }
  
  public void consumeIngredients(Player paramPlayer, AltarRecipe altarRecipe) {
    PlayerInventory playerInventory = paramPlayer.getInventory();
    HashMap<Object, Object> hashMap = new HashMap<>();
    for (RecipeIngredient you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4 : altarRecipe.getIngredients())
      hashMap.put(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4, Integer.valueOf(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.getAmount()));
    for (byte b = 0; b < playerInventory.getSize(); b++) {
      ItemStack itemStack = playerInventory.getItem(b);
      {
        if (itemStack != null)
          for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
            {
              if (((Integer)entry.getValue()).intValue() <= 0)
                continue; 
            }
            RecipeIngredient you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4 = (RecipeIngredient)entry.getKey();
            if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4.matches(itemStack)) {
              int i = Math.min(((Integer)entry.getValue()).intValue(), itemStack.getAmount());
              {
                itemStack.setAmount(itemStack.getAmount() - i);
                hashMap.put(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b4, Integer.valueOf(((Integer)entry.getValue()).intValue() - i));
                if (itemStack.getAmount() <= 0)
                  playerInventory.setItem(b, null); 
              }} 
          }  
      }} 
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bk.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */