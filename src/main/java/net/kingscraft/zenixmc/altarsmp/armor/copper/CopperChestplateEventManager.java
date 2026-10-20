package net.kingscraft.zenixmc.altarsmp.armor.copper;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Display;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;

public class CopperChestplateEventManager implements CommandExecutor, Listener {
  protected NamespacedKey chestInteractionKey = new NamespacedKey(AltarSMP.getPlugin(AltarSMP.class), "chestEvent");

  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String[] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      return true;
    } 
    spawnChestplateShard(player);
    startLightningStormTask(player.getLocation());
    AltarSMP.getInstance().getConfig().set("lightningFine", Boolean.valueOf(false));
    player.sendMessage(String.valueOf(ChatColor.GREEN) + "You have started the Copper Chestplate event");
    player.sendMessage(String.valueOf(ChatColor.GOLD) + "Use /altar spawn copperchestplate to spawn the altar for copper chestplate");
    return false;
  }

  public void startChestplateAnnouncementTask() {
    int i = AltarSMP.getInstance().getConfig().getInt("chestplateEventAnnouncePeriod", 60);
    (new CopperChestplateShardAnnouncementTask(this)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, (i * 20));
  }

  public void spawnChestplateShard(Player paramPlayer) {
    Location location = paramPlayer.getEyeLocation();
    Bukkit.broadcastMessage("A " + String.valueOf(ChatColor.of("#B06736")) + "§lChestplate Shard §rhas spawned!\\nLocation: " + ChatColor.of("#B06736").toString() + "§lX: " + location.getBlockX() + " §lY: " + location.getBlockY() + " §lZ: " + location.getBlockZ());
    location.setYaw(0.0F);
    location.setPitch(0.0F);
    location.getWorld().spawn(location.clone().add(0.0D, 2.0D, 0.0D), ItemDisplay.class, CopperChestplateEventManager::spawnCore);
    Interaction interaction = (Interaction)location.getWorld().spawnEntity(location.clone().add(0.0D, 1.0D, 0.0D), EntityType.INTERACTION);
    interaction.setInteractionWidth(1.2F);
    interaction.setInteractionHeight(1.2F);
    interaction.getPersistentDataContainer().set(this.chestInteractionKey, PersistentDataType.STRING, "chest");
  }

  public void startLightningStormTask(Location paramLocation) {
    int i = AltarSMP.getInstance().getConfig().getInt("lightningRadius", 50);
    int j = AltarSMP.getInstance().getConfig().getInt("lightningInterval", 5);
    (new CopperChestplateLightningTask(this, paramLocation, i)).runTaskTimer((Plugin)AltarSMP.getInstance(), 0L, j);
  }

  @EventHandler
  public void onShardInteraction(PlayerInteractAtEntityEvent paramPlayerInteractAtEntityEvent) {
    Interaction interaction;
    Entity entity = paramPlayerInteractAtEntityEvent.getRightClicked();
    if (entity instanceof Interaction) {
      interaction = (Interaction)entity;
    } else {
      return;
    } 
    {
      if (paramPlayerInteractAtEntityEvent.getRightClicked().getPersistentDataContainer().get(this.chestInteractionKey, PersistentDataType.STRING) != "chest")
        return; 
    }paramPlayerInteractAtEntityEvent.getPlayer().getInventory().addItem(CustomItemRegistry.getChestplateShard());
    Bukkit.broadcastMessage(String.valueOf(ChatColor.of("#B06736")) + "§lALERT! §r" + paramPlayerInteractAtEntityEvent.getPlayer().getName() + " has retrieved a Chestplate Shard!");
    Bukkit.broadcastMessage("The weather has calmed down near the shard´s location.");
    AltarSMP.getInstance().getConfig().set("lightningFine", Boolean.valueOf(true));
    startChestplateAnnouncementTask();
    for (Entity entity1 : paramPlayerInteractAtEntityEvent.getRightClicked().getNearbyEntities(2.0D, 2.0D, 2.0D)) {
      {
        if (entity1 instanceof ItemDisplay) {
          entity1.remove();
          interaction.remove();
        } 
      }} 
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

  public boolean isChestplateShard(ItemStack paramItemStack) {
    return AltarSMP.areSimilar(paramItemStack, CustomItemRegistry.getChestplateShard());
  }

  public static void spawnCore(ItemDisplay paramItemDisplay) {
    paramItemDisplay.setItemStack(CustomItemRegistry.getChestplateShard());
    paramItemDisplay.setBrightness(new Display.Brightness(15, 15));
    paramItemDisplay.setCustomNameVisible(true);
    paramItemDisplay.setCustomName(String.valueOf(ChatColor.of("#B06736")) + "Chestplate Shard");
  }



}
