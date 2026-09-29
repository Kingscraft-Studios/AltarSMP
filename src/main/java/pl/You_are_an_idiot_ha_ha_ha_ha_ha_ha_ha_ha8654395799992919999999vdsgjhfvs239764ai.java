package pl;

import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai implements Listener {
  public Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  public static int You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b;

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = Main.getInstance().getConfig().getInt("palecannonCooldown", 30);
  }
  
  
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai(Main paramMain) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(Player paramPlayer) {
    ItemStack itemStack = paramPlayer.getInventory().getItemInMainHand();
    {
      if (itemStack == null)
        return false; 
    }{
      if (itemStack.getType() != Material.CROSSBOW)
        return false; 
    }{
      if (!itemStack.hasItemMeta())
        return false; 
    }ItemMeta itemMeta = itemStack.getItemMeta();
    {
      if (itemMeta == null)
        return false; 
    }{
      if (!itemMeta.hasCustomModelData())
        return false; 
    }{
    
    }return (itemMeta.getCustomModelData() == 2);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(PlayerInteractEvent paramPlayerInteractEvent) {
    Player player = paramPlayerInteractEvent.getPlayer();
    ItemStack itemStack = player.getInventory().getItemInMainHand();
    {
      if (itemStack.getType() != Material.CROSSBOW)
        return; 
    }{
      if (!itemStack.hasItemMeta())
        return; 
    }CrossbowMeta crossbowMeta = (CrossbowMeta)itemStack.getItemMeta();
    {
      if (crossbowMeta != null) {
        {
          if (!crossbowMeta.hasCustomModelData())
            return; 
        }} else {
        return;
      } 
    }{
      if (!crossbowMeta.hasChargedProjectiles())
        return; 
    }{
      if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(player))
        return; 
    }{
      if (paramPlayerInteractEvent.getAction() != Action.RIGHT_CLICK_AIR) {
        {
          if (paramPlayerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK) {
            {
              if (player.hasCooldown(Material.CROSSBOW))
                return; 
            }paramPlayerInteractEvent.setCancelled(true);
            You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
            return;
          } 
        }return;
      } 
    }{
      if (player.hasCooldown(Material.CROSSBOW))
        return; 
    }paramPlayerInteractEvent.setCancelled(true);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(player);
  }
  
  public static ItemStack You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a() {
    ItemStack itemStack = new ItemStack(Material.PALE_OAK_LOG);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setItemModel(new NamespacedKey("altar", "item/pale_roots"));
    itemStack.setItemMeta(itemMeta);
    return itemStack;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    ArrayList arrayList = new ArrayList();
    int i = Main.getInstance().getConfig().getInt("paleRootsCount", 12);
    int j = Main.getInstance().getConfig().getInt("paleRootsDamage", 3);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d3(paramPlayer, arrayList, i, j)).runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
  }
  
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Player paramPlayer) {
    {
      if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), "palecannon"))
        return; 
    }CrossbowMeta crossbowMeta = (CrossbowMeta)paramPlayer.getInventory().getItemInMainHand().getItemMeta();
    crossbowMeta.setChargedProjectiles(null);
    paramPlayer.getInventory().getItemInMainHand().setItemMeta((ItemMeta)crossbowMeta);
    paramPlayer.setVelocity(paramPlayer.getLocation().getDirection().normalize().multiply(-0.5D));
    paramPlayer.getWorld().playSound(paramPlayer.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 1.5F);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bt.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer.getUniqueId(), "palecannon", You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bo.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, "Pale Cannon", You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b, ChatColor.YELLOW, BarColor.YELLOW);
    Location location = paramPlayer.getEyeLocation();
    Vector vector1 = location.getDirection().normalize();
    ItemDisplay itemDisplay = (ItemDisplay)paramPlayer.getWorld().spawnEntity(location, EntityType.ITEM_DISPLAY);
    itemDisplay.setItemStack(new ItemStack(Material.RESIN_BLOCK));
    itemDisplay.setTransformation(new Transformation(new Vector3f(0.0F, 0.0F, 0.0F), new AxisAngle4f((float)Math.toRadians(90.0D), 1.0F, 0.0F, 0.0F), new Vector3f(0.75F, 0.75F, 0.75F), new AxisAngle4f(0.0F, 0.0F, 0.0F, 1.0F)));
    double d = Main.getInstance().getConfig().getInt("palePower", 2);
    Vector vector2 = vector1.multiply(d);
    (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d5(this, vector2, itemDisplay, paramPlayer)).runTaskTimer((Plugin)this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a, 0L, 1L);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Player paramPlayer) {
    paramLocation = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ad.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation, 3);
    World world = paramLocation.getWorld();
    world.playSound(paramLocation, Sound.ENTITY_GENERIC_EXPLODE, 2.0F, 1.0F);
    double d = Main.getInstance().getConfig().getDouble("paleDamage", 8.0D);
    paramLocation.getWorld().spawnParticle(Particle.ITEM, paramLocation, 200, 0.0D, 0.0D, 0.0D, 0.5D, new ItemStack(Material.RESIN_BLOCK));
    for (Entity entity : paramLocation.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
      {
        if (entity == paramPlayer)
          continue; 
      }{
        if (!Main.isTrusted(paramPlayer, entity) && entity instanceof LivingEntity) {
          LivingEntity livingEntity = (LivingEntity)entity;
          You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a5.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(livingEntity, d, paramPlayer);
        } 
      }} 
    if (Main.getInstance().getConfig().getBoolean("paleParticleEffects", true)) {
      AreaEffectCloud areaEffectCloud = (AreaEffectCloud)world.spawnEntity(paramLocation, EntityType.AREA_EFFECT_CLOUD);
      areaEffectCloud.setDuration(80);
      areaEffectCloud.setRadius(5.0F);
      areaEffectCloud.setRadiusOnUse(0.0F);
      areaEffectCloud.setRadiusPerTick(0.0F);
      areaEffectCloud.setWaitTime(0);
      areaEffectCloud.setReapplicationDelay(200);
      areaEffectCloud.addCustomEffect(new PotionEffect(PotionEffectType.LUCK, 12000, 1, true, false, true), true);
      areaEffectCloud.setParticle(Particle.ENTITY_EFFECT, Color.GRAY);
    } 
  }

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ai.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */