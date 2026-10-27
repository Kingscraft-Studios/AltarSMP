package net.kingscraft.zenixmc.altarsmp.copper.leggings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Transformation;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.bossbar.BossBarManager;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import net.kingscraft.zenixmc.altarsmp.util.TimeUtils;
import org.jspecify.annotations.NonNull;

public class CopperLeggingsEventManager implements Listener, CommandExecutor {
  private static final TextColor COPPER = TextColor.color(0xB06736);

  public final HashMap<UUID, ItemDisplay> playerCoreDisplays = new HashMap<>();

  public final HashMap<UUID, Integer> playerHoldingTimes = new HashMap<>();

  protected NamespacedKey coreInteractionKey = new NamespacedKey(AltarSMP.getPlugin(AltarSMP.class), "legEvent");

  public void startEventCountdown() {
    int i = AltarSMP.getInstance().getConfig().getInt("leggingsEventAnnounceTime", 60);
    int j = AltarSMP.getInstance().getConfig().getInt("leggingsTime", 30) * 60 * 20;
    (new CopperLeggingsEventTask(this, j, i)).runTaskTimer(AltarSMP.getInstance(), 0L, 1L);
  }

  public void endLeggingsEvent() {
    UUID uUID = null;
    int i = -1;
    for (Map.Entry<UUID, Integer> entry : this.playerHoldingTimes.entrySet()) {
      if (entry.getValue() > i) {
        i = entry.getValue();
        uUID = entry.getKey();
      } 
    } 
    AltarSMP.getInstance().getConfig().set("leggingsActive", false);
    cleanupEventEntities();
    if (uUID != null) {
      Player player = Bukkit.getPlayer(uUID);
      {

      }String str1 = (player != null) ? player.getName() : Bukkit.getOfflinePlayer(uUID).getName();
      Bukkit.broadcast(Component.text()
          .append(Component.text(str1, COPPER, TextDecoration.BOLD))
          .append(Component.text(" has won the event!"))
          .build());
      String str2 = TimeUtils.formatMmSs(i);
      {
        Bukkit.broadcast(Component.text()
            .append(Component.text("Total holding time: ", NamedTextColor.WHITE, TextDecoration.BOLD))
            .append(Component.text(str2, COPPER, TextDecoration.BOLD))
            .build());
        if (player != null && player.isOnline()) {
          ItemStack itemStack1 = player.getInventory().getLeggings();
          player.getInventory().setLeggings(CustomItemRegistry.getCopperLeggings());
          player.getInventory().addItem(itemStack1);
          player.sendMessage(Component.text("You have received the Copper Leggings!", COPPER, TextDecoration.BOLD));
          ItemStack itemStack2 = null;
          for (ItemStack itemStack : player.getInventory().getContents()) {
            if (isCopperCore(itemStack)) {
              itemStack2 = itemStack;
              break;
            } 
          } 
          {
            if (itemStack2 != null)
              player.getInventory().removeItem(itemStack2);
          }} 
      }} 
    this.playerHoldingTimes.clear();
  }

  public void spawnPlayerCoreDisplay(Player paramPlayer) {
    ItemDisplay itemDisplay = paramPlayer.getWorld().spawn(paramPlayer.getEyeLocation().clone().add(0.0D, 1.0D, 0.0D), ItemDisplay.class, CopperLeggingsEventManager::lambda$spawnDisplay$0);
    this.playerCoreDisplays.put(paramPlayer.getUniqueId(), itemDisplay);
  }

  public void updatePlayerCoreDisplay(Player paramPlayer, double paramDouble) {
    ItemDisplay itemDisplay = this.playerCoreDisplays.get(paramPlayer.getUniqueId());
    {
      if (itemDisplay == null)
        return; 
    }double d1 = Math.cos(paramDouble) * 0.6D;
    double d2 = Math.sin(paramDouble) * 0.6D;
    double d3 = 0.5D + Math.sin(paramDouble * 0.5D) * 0.2D;
    Location location = paramPlayer.getEyeLocation().add(d1, d3 + 2.0D, d2);
    location.setYaw((float)Math.toDegrees(paramDouble));
    itemDisplay.setTeleportDuration(1);
    itemDisplay.setInterpolationDuration(1);
    itemDisplay.setInterpolationDelay(0);
    itemDisplay.teleport(location);
    location.getWorld().spawnParticle(Particle.FLAME, location, 2, 0.5D, 0.3D, 0.5D, 0.0D);
  }

  public void removePlayerCoreDisplay(Player paramPlayer) {
    ItemDisplay itemDisplay = this.playerCoreDisplays.remove(paramPlayer.getUniqueId());
    {
      if (itemDisplay != null)
        itemDisplay.remove(); 
    }}

  public void cleanupEventEntities() {
    this.playerCoreDisplays.values().forEach(Entity::remove);
    this.playerCoreDisplays.clear();
    for (Player player : Bukkit.getOnlinePlayers()) {
      ItemStack itemStack = null;
      for (ItemStack itemStack1 : player.getInventory().getContents()) {
        if (isCopperCore(itemStack1)) {
          itemStack = itemStack1;
          break;
        } 
      } 
      {
        if (itemStack != null)
          player.getInventory().removeItem(itemStack);
      }} 
  }

  @EventHandler
  public void onServerLoad(ServerLoadEvent paramServerLoadEvent) {
    cleanupEventEntities();
  }

  public String getWorldDisplayName(World paramWorld) {
    return switch (paramWorld.getName()) {
      case "world" -> "Overworld";
      case "world_nether" -> "Nether";
      case "world_the_end" -> "End";
      default -> paramWorld.getName();
    };
  }

  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String @NonNull [] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      return true;
    } 
    this.playerHoldingTimes.clear();
    AltarSMP.getInstance().getConfig().set("leggingsActive", true);
    showEventBossBar();
    spawnCopperCore(player);
    createCopperCoreItem();
    startEventCountdown();
    return false;
  }

  public void showEventBossBar() {
    int i = AltarSMP.getInstance().getConfig().getInt("leggingsTime", 30) * 60;
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0F, 1.0F);
      BossBarManager.showEventBar("Event Time Remaining:", i, BarColor.PINK);
      BossBarManager.addPlayerToEventBar(player);
    } 
  }

  public void spawnCopperCore(Player paramPlayer) {
    Location location = paramPlayer.getEyeLocation();
    int k = location.getBlockX();
    int j = location.getBlockY();
    int i = location.getBlockZ();
    Bukkit.broadcast(Component.text()
        .append(Component.text("A "))
        .append(Component.text("Copper Infused Heavy Core ", COPPER, TextDecoration.BOLD))
        .append(Component.text("has spawned!"))
        .append(Component.newline())
        .append(Component.text("Location: "))
        .append(Component.text("X: " + k + " Y: " + j + " Z: " + i, COPPER, TextDecoration.BOLD))
        .append(Component.text(" Punch players to steal the core! Whoever holds it longest receives the "))
        .append(Component.text("Copper Leggings", COPPER, TextDecoration.BOLD))
        .append(Component.text("!"))
        .build());
    location.setYaw(0.0F);
    location.setPitch(0.0F);
    location.getWorld().spawn(location.clone().add(0.0D, 2.0D, 0.0D), ItemDisplay.class, CopperLeggingsEventManager::lambda$spawnCore$1);
    Interaction interaction = (Interaction)location.getWorld().spawnEntity(location.clone().add(0.0D, 1.0D, 0.0D), EntityType.INTERACTION);
    interaction.setInteractionWidth(1.2F);
    interaction.setInteractionHeight(1.2F);
    interaction.getPersistentDataContainer().set(this.coreInteractionKey, PersistentDataType.STRING, "legs");
  }

  public static ItemStack createCopperCoreItem() {
    ItemStack itemStack = new ItemStack(Material.HEAVY_CORE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    if (itemMeta != null) {
      CustomModelDataComponent modelData = itemMeta.getCustomModelDataComponent();
      modelData.setFloats(List.of(998.0F));
      itemMeta.setCustomModelDataComponent(modelData);
      itemMeta.addEnchant(Enchantment.BREACH, 1, true);
      itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
      itemMeta.displayName(Component.text("Copper Infused Heavy Core", COPPER));
      itemStack.setItemMeta(itemMeta);
    }
    return itemStack;
  }

  @EventHandler
  public void onCoreInteraction(PlayerInteractAtEntityEvent paramPlayerInteractAtEntityEvent) {
    Interaction interaction;
    Entity entity = paramPlayerInteractAtEntityEvent.getRightClicked();
    if (entity instanceof Interaction) {
      interaction = (Interaction)entity;
    } else {
      return;
    } 
    {
      if (!"legs".equals(paramPlayerInteractAtEntityEvent.getRightClicked().getPersistentDataContainer().get(this.coreInteractionKey, PersistentDataType.STRING)))
        return; 
    }paramPlayerInteractAtEntityEvent.getPlayer().getInventory().addItem(createCopperCoreItem());
    Bukkit.broadcast(Component.text()
        .append(Component.text("ALERT! ", COPPER, TextDecoration.BOLD))
        .append(Component.text(paramPlayerInteractAtEntityEvent.getPlayer().getName() + " has picked up the Copper Infused Heavy Core!"))
        .build());
    for (Entity entity1 : paramPlayerInteractAtEntityEvent.getRightClicked().getNearbyEntities(2.0D, 2.0D, 2.0D)) {
      {
        if (entity1 instanceof ItemDisplay) {
          entity1.remove();
          interaction.remove();
        } 
      }} 
  }

  @EventHandler
  public void onCoreStolen(EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
    Player player1;
    Player player2;
    Entity entity = paramEntityDamageByEntityEvent.getDamager();
    if (entity instanceof Player) {
      player1 = (Player)entity;
      entity = paramEntityDamageByEntityEvent.getEntity();
      if (entity instanceof Player) {
        player2 = (Player)entity;
      } else {
        return;
      } 
    } else {
      return;
    } 
    for (ItemStack itemStack : player2.getInventory().getContents()) {
      {
        if (isCopperCore(itemStack)) {
          player2.getInventory().removeItem(itemStack);
          player1.getInventory().addItem(createCopperCoreItem());
          Bukkit.broadcast(Component.text()
              .append(Component.text("ALERT! ", COPPER, TextDecoration.BOLD))
              .append(Component.text(player1.getName() + " stole the core!"))
              .build());
          break;
        } 
      }} 
  }

  @EventHandler
  public void onCopperCorePlace(BlockPlaceEvent event) {
    ItemStack itemStack = event.getItemInHand();
    if (isCopperCore(itemStack)) {
      event.setCancelled(true);
    }
  }

  @EventHandler
  public void onPlayerQuit(PlayerQuitEvent paramPlayerQuitEvent) {
    removePlayerCoreDisplay(paramPlayerQuitEvent.getPlayer());
  }

  @EventHandler
  public void onPlayerDeath(PlayerDeathEvent paramPlayerDeathEvent) {
    removePlayerCoreDisplay(paramPlayerDeathEvent.getEntity());
  }

  public boolean isCopperCore(ItemStack paramItemStack) {
    if (paramItemStack == null || !paramItemStack.hasItemMeta()) {
      return false;
    }
    if (paramItemStack.getType() != Material.HEAVY_CORE) {
      return false;
    }
    ItemMeta itemMeta = paramItemStack.getItemMeta();
    if (itemMeta == null) {
      return false;
    }
    List<Float> floats = itemMeta.getCustomModelDataComponent().getFloats();
    return !floats.isEmpty() && Math.round(floats.getFirst()) == 998;
  }

  private static void lambda$spawnCore$1(ItemDisplay paramItemDisplay) {
    paramItemDisplay.setItemStack(createCopperCoreItem());
    paramItemDisplay.setBrightness(new Display.Brightness(15, 15));
  }

  private static void lambda$spawnDisplay$0(ItemDisplay paramItemDisplay) {
    paramItemDisplay.setItemStack(createCopperCoreItem());
    paramItemDisplay.setBrightness(new Display.Brightness(15, 15));
    paramItemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new Quaternionf(), new Vector3f(0.8F, 0.8F, 0.8F), new Quaternionf()));
  }


}
