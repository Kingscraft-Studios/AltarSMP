package pl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Transformation;

public class CrazyRandomizerListener implements Listener {

  public CrazyRandomizerListener() {
    Main.getInstance().getCommand("giverandomizer").setExecutor(new GiveRandomizerCommand(this));
  }
  
  public static ItemStack createCrazyRandomizerItem() {
    ItemStack itemStack = new ItemStack(Material.CLAY_BALL);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setCustomModelData(Integer.valueOf(4));
    itemMeta.setDisplayName(String.valueOf(ChatColor.GOLD) + ChatColor.BOLD.toString() + "Crazy Randomizer");
    itemMeta.setUnbreakable(true);
    ArrayList<String> arrayList = new ArrayList();
    arrayList.add(String.valueOf(ChatColor.GRAY) + "Right-Click to get a random legendary!");
    itemMeta.setLore(arrayList);
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  @EventHandler
  public void onPlayerInteract(PlayerInteractEvent paramPlayerInteractEvent) {
    Player player = paramPlayerInteractEvent.getPlayer();
    {
      if (!paramPlayerInteractEvent.getAction().isRightClick())
        return; 
    }
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    {
      if (!createCrazyRandomizerItem().isSimilar(itemStack))
        return; 
    }
    itemStack.setAmount(itemStack.getAmount() - 1);
    activateRandomizer(player);
    paramPlayerInteractEvent.setCancelled(true);
  }
  
  public static void activateRandomizer(Player paramPlayer) {
    List<ItemStack> list = CustomItem.getRollingDropItems();
    startRandomizerAnimation(paramPlayer, list);
  }
  
  private static void startRandomizerAnimation(Player paramPlayer, List<ItemStack> paramList) {
    int i = paramList.size();
    double d = 2.0D;
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.BLOCK_BEACON_ACTIVATE, 1.0F, 1.0F);
    ArrayList<ItemDisplay> arrayList = new ArrayList();
    for (int b = 0; b < i; b++) {
      double d1 = Math.toRadians(360.0D / i * b);
      double d2 = d * Math.cos(d1);
      double d3 = d * Math.sin(d1);
      ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(paramPlayer.getLocation(), EntityType.ITEM_DISPLAY);
      itemDisplay.setItemStack(paramList.get(b));
      Transformation transformation = itemDisplay.getTransformation();
      transformation.getTranslation().set((float)d2, 0.0F, (float)d3);
      itemDisplay.setTransformation(transformation);
      paramPlayer.addPassenger((Entity)itemDisplay);
      itemDisplay.setRotation(0.0F, 0.0F);
      arrayList.add(itemDisplay);
    } 
    Random random = new Random();
    int j = random.nextInt(i);
    World world = paramPlayer.getWorld();
    (new CrazyRandomizerAnimationTask(arrayList, paramPlayer, world, paramList, j)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public static void shrinkItemDisplay(ItemDisplay paramItemDisplay) {
    paramItemDisplay.setInterpolationDelay(0);
    paramItemDisplay.setInterpolationDuration(10);
    Transformation transformation = paramItemDisplay.getTransformation();
    transformation.getScale().set(0.0F, 0.0F, 0.0F);
    paramItemDisplay.setTransformation(transformation);
    (new CrazyRandomizerDisplayRemovalTask(paramItemDisplay)).runTaskLater((Plugin)Main.getInstance(), 20L);
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cf.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */