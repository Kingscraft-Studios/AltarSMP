package pl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
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
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerLoadEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Transformation;
import org.jetbrains.annotations.NotNull;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class CopperLeggingsEventManager implements Listener, CommandExecutor {
  public final HashMap<UUID, ItemDisplay> playerCoreDisplays = new HashMap<>();
  
  public final HashMap<UUID, Integer> playerHoldingTimes = new HashMap<>();
  
  protected NamespacedKey coreInteractionKey = new NamespacedKey(Main.getPlugin(Main.class), "legEvent");
  
  private void startEventCountdown() {
    int i = Main.getInstance().getConfig().getInt("leggingsEventAnnounceTime", 60);
    int j = Main.getInstance().getConfig().getInt("leggingsTime", 30) * 60 * 20;
    (new CopperLeggingsEventTask(this, j, i)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public void endLeggingsEvent() {
    UUID uUID = null;
    int i = -1;
    for (Map.Entry<UUID, Integer> entry : this.playerHoldingTimes.entrySet()) {
      if (((Integer)entry.getValue()).intValue() > i) {
        i = ((Integer)entry.getValue()).intValue();
        uUID = (UUID)entry.getKey();
      } 
    } 
    Main.getInstance().getConfig().set("leggingsActive", Boolean.valueOf(false));
    cleanupEventEntities();
    if (uUID != null) {
      Player player = Bukkit.getPlayer(uUID);
      {
      
      }String str1 = (player != null) ? player.getName() : Bukkit.getOfflinePlayer(uUID).getName();
      Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + ChatColor.BOLD.toString() + str1 + "§r has won the event!");
      String str2 = TimeUtils.formatMmSs(i);
      String str3 = String.valueOf(ChatColor.of("#B06736"));
      {
        Bukkit.broadcastMessage("Total holding time: §l" + str3 + str2);
        if (player != null && player.isOnline()) {
          ItemStack itemStack1 = player.getInventory().getLeggings();
          player.getInventory().setLeggings(CustomItemRegistry.getCopperLeggings());
          player.getInventory().addItem(new ItemStack[] { itemStack1 });
          player.sendMessage(String.valueOf(ChatColor.of("#B06736")) + ChatColor.BOLD.toString() + "You have received the Copper Leggings!");
          ItemStack itemStack2 = null;
          for (ItemStack itemStack : player.getInventory().getContents()) {
            if (isCopperCore(itemStack)) {
              itemStack2 = itemStack;
              break;
            } 
          } 
          {
            if (itemStack2 != null)
              player.getInventory().removeItem(new ItemStack[] { itemStack2 }); 
          }} 
      }} 
    this.playerHoldingTimes.clear();
  }
  
  public void spawnPlayerCoreDisplay(Player paramPlayer) {
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawn(paramPlayer.getEyeLocation().clone().add(0.0D, 1.0D, 0.0D), ItemDisplay.class, CopperLeggingsEventManager::lambda$spawnDisplay$0);
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
          player.getInventory().removeItem(new ItemStack[] { itemStack }); 
      }} 
  }
  
  @EventHandler
  public void onServerLoad(ServerLoadEvent paramServerLoadEvent) {
    cleanupEventEntities();
  }
  
  public String getWorldDisplayName(World paramWorld) {
    String str = paramWorld.getName();
    int b = -1;
    {
      switch (str.hashCode()) {
        case 113318802:
          if (str.equals("world"))
            b = 0; 
          break;
        case 1865466277:
          if (str.equals("world_nether"))
            b = 1; 
          break;
        case -1198266272:
          if (str.equals("world_the_end"))
            b = 2; 
          break;
      } 
    }{
      switch (b) {
        case 0:
          return "Overworld";
        case 1:
          return "Nether";
        case 2:
          return "End";
      } 
    }return paramWorld.getName();
  }
  
  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      return true;
    } 
    this.playerHoldingTimes.clear();
    Main.getInstance().getConfig().set("leggingsActive", Boolean.valueOf(true));
    showEventBossBar();
    spawnCopperCore(player);
    createCopperCoreItem();
    return false;
  }
  
  private void showEventBossBar() {
    int i = Main.getInstance().getConfig().getInt("leggingsTime", 30) * 60;
    for (Player player : Bukkit.getOnlinePlayers()) {
      player.playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.0F, 1.0F);
      BossBarManager.showEventBar(String.valueOf(ChatColor.of("#B06736")) + "§lEvent Time Remaining:", i, BarColor.PINK);
    } 
  }
  
  private void spawnCopperCore(Player paramPlayer) {
    Location location = paramPlayer.getEyeLocation();
    String str1 = String.valueOf(ChatColor.of("#B06736"));
    int k = location.getBlockX();
    int j = location.getBlockY();
    int i = location.getBlockZ();
    String str2 = ChatColor.of("#B06736").toString();
    String str3 = String.valueOf(ChatColor.of("#B06736"));
    Bukkit.broadcastMessage("A " + String.valueOf(ChatColor.of("#B06736")) + "§lCopper Infused Heavy Core §rhas spawned!\\nLocation: " + str2 + "§lX: " + k + " §lY: " + j + " §lZ: " + i + " §rPunch players to steal the core! Whoever holds it longest receives the " + String.valueOf(ChatColor.of("#B06736")) + "§lCopper Leggings§r!");
    location.setYaw(0.0F);
    location.setPitch(0.0F);
    location.getWorld().spawn(location.clone().add(0.0D, 2.0D, 0.0D), ItemDisplay.class, CopperLeggingsEventManager::lambda$spawnCore$1);
    Interaction interaction = (Interaction)location.getWorld().spawnEntity(location.clone().add(0.0D, 1.0D, 0.0D), EntityType.INTERACTION);
    interaction.setInteractionWidth(1.2F);
    interaction.setInteractionHeight(1.2F);
    interaction.getPersistentDataContainer().set(this.coreInteractionKey, PersistentDataType.STRING, "legs");
  }
  
  private static ItemStack createCopperCoreItem() {
    ItemStack itemStack = new ItemStack(Material.HEAVY_CORE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(998));
    itemMeta.addEnchant(Enchantment.BREACH, 1, true);
    itemMeta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
    itemMeta.setDisplayName(String.valueOf(ChatColor.of("#B06736")) + "Copper Infused Heavy Core");
    itemStack.setItemMeta(itemMeta);
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
    }paramPlayerInteractAtEntityEvent.getPlayer().getInventory().addItem(new ItemStack[] { createCopperCoreItem() });
    Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + "§lALERT! §r" + paramPlayerInteractAtEntityEvent.getPlayer().getName() + " has picked up the Copper Infused Heavy Core!");
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
          player2.getInventory().removeItem(new ItemStack[] { itemStack });
          player1.getInventory().addItem(new ItemStack[] { createCopperCoreItem() });
          Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + "§lALERT! §r" + player1.getName() + " stole the core!");
          break;
        } 
      }} 
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
    return paramItemStack.getType() == Material.HEAVY_CORE && paramItemStack.getItemMeta().getCustomModelData() == 998;
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bi.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */