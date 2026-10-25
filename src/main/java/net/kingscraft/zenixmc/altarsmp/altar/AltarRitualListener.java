package net.kingscraft.zenixmc.altarsmp.altar;

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
import org.bukkit.util.Transformation;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.core.cooldown.CooldownManager;
import net.kingscraft.zenixmc.altarsmp.event.contagion.ContagionRitualAnnouncementTask;
import net.kingscraft.zenixmc.altarsmp.event.contagion.ContagionRitualBootSequenceTask;
import net.kingscraft.zenixmc.altarsmp.event.contagion.ContagionRitualCoordinatesAnnouncementTask;
import net.kingscraft.zenixmc.altarsmp.event.contagion.ContagionSignalAnimationTask;
import net.kingscraft.zenixmc.altarsmp.event.contagion.ContagionSignalItemAnimationTask;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.item.RecipeIngredient;
import net.kingscraft.zenixmc.altarsmp.vampire.VampireEventManager;

public class AltarRitualListener implements Listener {
  public final AltarController altarController;

  public final Map<UUID, Long> missingIngredientsCooldowns = new HashMap<>();

  public static Map<UUID, UUID> copperHelmetPlayers;

  public static Map<UUID, UUID> copperChestplatePlayers;

  private static final double CONTAGION_RITUAL_DURATION = AltarSMP.getInstance().getConfig().getDouble("contagion_ritual_duration", 10.0D);

  public static final int CONTAGION_SIGNAL_HEALTH = AltarSMP.getInstance().getConfig().getInt("contagion_signal_health", 50);

  public static HashMap<Interaction, Integer> contagionInteractions;


  public AltarRitualListener(AltarController altarController) {
    this.altarController = altarController;
  }

  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    List<RecipeIngredient> list = null;
    UUID uUID = null;
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
      if (AltarSMP.areSimilar(itemStack, CustomItemRegistry.getContagionSignal())) {
        player.sendMessage("starting");
        itemStack.setAmount(itemStack.getAmount() - 1);
        paramPlayerInteractEvent.setCancelled(true);
        startContagionRitual(location, player);
        return;
      } 
    }
    AltarInstance altarInstance = this.altarController.getAltarInstance(paramPlayerInteractEvent.getClickedBlock().getLocation());
    {
      if (altarInstance == null)
        return; 
    }{
      paramPlayerInteractEvent.setCancelled(true);
      if (this.altarController.isAltarUsed(altarInstance.getLocation()))
        return; 
    }
    Altar altar = AltarSMP.getInstance().getConfigManager().getAltar(altarInstance.getType());
    {
      if (altar == null)
        return; 
    }    Iterator<AltarRecipe> iterator = altar.getRecipe().values().iterator();
    if (!iterator.hasNext()) {
      player.sendMessage(ChatColor.RED + "No valid recipe found!");
      return;
    }
    while (iterator.hasNext()) {
      AltarRecipe altarRecipe = iterator.next();
      list = this.altarController.getMissingIngredients(player, altarRecipe);
      if (list.isEmpty()) {
        consumeIngredients(player, altarRecipe);
        ItemStack itemStack1 = AltarController.createItemStack(altarInstance.getType());
        {
          player.getInventory().addItem(itemStack1);
          if (altarInstance.getType().equalsIgnoreCase("crazyslots"))
            player.getInventory().addItem(new ItemStack(Material.DRAGON_EGG));
        }{
          if (altarInstance.getType().equalsIgnoreCase("copperhelmet"))
            copperHelmetPlayers.put(player.getUniqueId(), player.getUniqueId());
        }{
          if (altarInstance.getType().equalsIgnoreCase("copperchestplate"))
            copperChestplatePlayers.put(player.getUniqueId(), player.getUniqueId());
        }altarInstance.getLocation().getWorld().strikeLightning(altarInstance.getLocation());
        this.altarController.broadcastCraftAnnouncement(player, itemStack1);
        this.altarController.setAltarUsed(altarInstance.getLocation(), true);
        this.altarController.removeAltar(altarInstance.getLocation());
        altarInstance.removeItemDisplay();
        return;
      }
      uUID = player.getUniqueId();
      l = System.currentTimeMillis();
      Long long_ = this.missingIngredientsCooldowns.get(uUID);
      {
        if (long_ != null) {
          {
            if (l - long_ >= 1000L) {
              this.altarController.sendMissingIngredients(player, list);
              this.missingIngredientsCooldowns.put(uUID, l);
              return;
            }
          }
          return;
        }
      }
    }
    this.altarController.sendMissingIngredients(player, list);
    this.missingIngredientsCooldowns.put(uUID, l);
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
    textDisplay.setText("§a|".repeat(Math.max(0, CONTAGION_SIGNAL_HEALTH)));
    Transformation transformation2 = textDisplay.getTransformation();
    transformation2.getTranslation().set(0.0F, 0.0F, 0.0F);
    textDisplay.setTransformation(transformation2);
    Interaction interaction = (Interaction)world.spawnEntity(location.clone().add(0.0D, 1.0D, 0.0D), EntityType.INTERACTION);
    interaction.setInteractionHeight(1.5F);
    interaction.setInteractionWidth(1.0F);
    interaction.setResponsive(false);
    int i = (int)(CONTAGION_RITUAL_DURATION * 60.0D * 20.0D);
    startContagionSequence(str1, paramLocation);
    BossBar bossBar = Bukkit.createBossBar("§a§kaa §f" + str1 + " §aCONTAGION RITUAL §a§kaa", BarColor.PINK, BarStyle.SOLID);
    int b2 = 5;
    String str3 = str1;
    (new ContagionSignalAnimationTask(interaction, bossBar, paramLocation, itemDisplay, textDisplay, i, str3, b2)).runTaskTimer(AltarSMP.getInstance(), 140L, 1L);
  }

  public static void animateContagionSignal(ItemDisplay paramItemDisplay) {
    Location location = paramItemDisplay.getLocation();
    paramItemDisplay.setTeleportDuration(20);
    (new ContagionSignalItemAnimationTask(paramItemDisplay, location)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
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
    int i = contagionInteractions.merge(interaction, -1, Integer::sum);
    {
      player.playSound(player, Sound.ENTITY_PLAYER_ATTACK_CRIT, 1.0F, 1.0F);
      player.playSound(player, Sound.ENTITY_PLAYER_ATTACK_STRONG, 1.0F, 1.0F);
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
    (new ContagionRitualAnnouncementTask(paramString)).runTaskLater(AltarSMP.getInstance(), 40L);
    (new ContagionRitualCoordinatesAnnouncementTask(paramLocation)).runTaskLater(AltarSMP.getInstance(), 80L);
    (new ContagionRitualBootSequenceTask()).runTaskLater(AltarSMP.getInstance(), 120L);
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
    for (RecipeIngredient recipeIngredient : altarRecipe.ingredients())
      hashMap.put(recipeIngredient, recipeIngredient.getAmount());
    for (int b = 0; b < playerInventory.getSize(); b++) {
      ItemStack itemStack = playerInventory.getItem(b);
      {
        if (itemStack != null)
          for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
            {
              if ((Integer) entry.getValue() <= 0)
                continue; 
            }
            RecipeIngredient recipeIngredient = (RecipeIngredient)entry.getKey();
            if (recipeIngredient.matches(itemStack)) {
              int i = Math.min((Integer) entry.getValue(), itemStack.getAmount());
              {
                itemStack.setAmount(itemStack.getAmount() - i);
                hashMap.put(recipeIngredient, (Integer) entry.getValue() - i);
                if (itemStack.getAmount() <= 0)
                  playerInventory.setItem(b, null); 
              }} 
          }  
      }} 
  }



}
