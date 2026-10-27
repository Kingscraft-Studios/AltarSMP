package net.kingscraft.zenixmc.altarsmp.copper.chestplate;

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
import org.jetbrains.annotations.NotNull;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;
import net.kingscraft.zenixmc.altarsmp.item.CustomItemRegistry;
import org.jspecify.annotations.NonNull;

import java.util.Objects;

public class CopperChestplateEventManager implements CommandExecutor, Listener {
  private static final TextColor COPPER = TextColor.color(0xB06736);
  protected NamespacedKey chestInteractionKey = new NamespacedKey(AltarSMP.getPlugin(AltarSMP.class), "chestEvent");

  public boolean onCommand(@NotNull CommandSender paramCommandSender, @NotNull Command paramCommand, @NotNull String paramString, @NotNull String @NonNull [] paramArrayOfString) {
    Player player;
    if (paramCommandSender instanceof Player) {
      player = (Player)paramCommandSender;
    } else {
      return true;
    } 
    spawnChestplateShard(player);
    startLightningStormTask(player.getLocation());
    AltarSMP.getInstance().getConfig().set("lightningFine", false);
    player.sendMessage(Component.text("You have started the Copper Chestplate event", NamedTextColor.GREEN));
    player.sendMessage(Component.text("Use /altar spawn copperchestplate to spawn the altar for copper chestplate", NamedTextColor.GOLD));
    return false;
  }

  public void startChestplateAnnouncementTask() {
    int i = AltarSMP.getInstance().getConfig().getInt("chestplateEventAnnouncePeriod", 60);
    (new CopperChestplateShardAnnouncementTask(this)).runTaskTimer(AltarSMP.getInstance(), 0L, (i * 20L));
  }

  public void spawnChestplateShard(Player paramPlayer) {
    Location location = paramPlayer.getEyeLocation();
    Bukkit.broadcast(Component.text().append(Component.text("A ")).append(Component.text("Chestplate Shard ", COPPER, TextDecoration.BOLD))
        .append(Component.text("has spawned!")).append(Component.newline()).append(Component.text("Location: "))
        .append(Component.text("X: " + location.getBlockX() + " Y: " + location.getBlockY() + " Z: " + location.getBlockZ(), COPPER, TextDecoration.BOLD)).build());

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
    (new CopperChestplateLightningTask(paramLocation, i)).runTaskTimer(AltarSMP.getInstance(), 0L, j);
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
      if (!Objects.equals(paramPlayerInteractAtEntityEvent.getRightClicked().getPersistentDataContainer().get(this.chestInteractionKey, PersistentDataType.STRING), "chest"))
        return; 
    }paramPlayerInteractAtEntityEvent.getPlayer().getInventory().addItem(CustomItemRegistry.getChestplateShard());
    Bukkit.broadcast(Component.text().append(Component.text("ALERT! ", COPPER, TextDecoration.BOLD))
            .append(Component.text(paramPlayerInteractAtEntityEvent.getPlayer().getName() + " has retrieved a Chestplate Shard!")).build());
    Bukkit.broadcast(Component.text("The weather has calmed down near the shard´s location."));
    AltarSMP.getInstance().getConfig().set("lightningFine", true);
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
    return switch (paramWorld.getName()) {
      case "world" -> "Overworld";
      case "world_nether" -> "Nether";
      case "world_the_end" -> "End";
      default -> paramWorld.getName();
    };
  }

  public boolean isChestplateShard(ItemStack paramItemStack) {
    return AltarSMP.areSimilar(paramItemStack, CustomItemRegistry.getChestplateShard());
  }

  public static void spawnCore(ItemDisplay paramItemDisplay) {
    paramItemDisplay.setItemStack(CustomItemRegistry.getChestplateShard());
    paramItemDisplay.setBrightness(new Display.Brightness(15, 15));
    paramItemDisplay.setCustomNameVisible(true);
    paramItemDisplay.customName(Component.text("Chestplate Shard", COPPER));
  }



}
