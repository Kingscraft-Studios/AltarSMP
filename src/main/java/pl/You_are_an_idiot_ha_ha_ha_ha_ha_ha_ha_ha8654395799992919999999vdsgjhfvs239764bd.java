package pl;

import io.papermc.paper.dialog.Dialog;
import net.kyori.adventure.dialog.DialogLike;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import java.util.List;
import org.bukkit.entity.Entity;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd implements Listener {
  static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  FileConfiguration You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b = Main.getInstance().getConfig();
  
  
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer) {
    Inventory inventory = Bukkit.createInventory(null, 45, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a);
    ItemStack itemStack = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
    ItemMeta itemMeta = itemStack.getItemMeta();
    itemMeta.setDisplayName(" ");
    itemStack.setItemMeta(itemMeta);
    byte b = 0;
    {
      while (b < 9) {
        inventory.setItem(b, itemStack);
        b++;
      } 
    }b = 2;
    {
      while (b < 7) {
        inventory.setItem(b, null);
        b++;
      } 
    }b = 36;
    {
      while (b < 45) {
        inventory.setItem(b, itemStack);
        b++;
      } 
    }inventory.setItem(9, itemStack);
    inventory.setItem(18, itemStack);
    inventory.setItem(27, itemStack);
    inventory.setItem(17, itemStack);
    inventory.setItem(26, itemStack);
    inventory.setItem(35, itemStack);
    inventory.setItem(40, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b());
    for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l : You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.values()) {
      inventory.addItem(new ItemStack[] { you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0() });
    } 
    paramPlayer.openInventory(inventory);
  }
  
  @EventHandler
  public void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(InventoryClickEvent paramInventoryClickEvent) {
    Player player;
    {
      if (!paramInventoryClickEvent.getView().getTitle().equals(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a))
        return; 
    }{
      if (paramInventoryClickEvent.getClickedInventory() != paramInventoryClickEvent.getView().getTopInventory())
        return; 
    }ItemStack itemStack = paramInventoryClickEvent.getCurrentItem();
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1(itemStack);
    HumanEntity humanEntity = paramInventoryClickEvent.getWhoClicked();
    if (humanEntity instanceof Player) {
      player = (Player)humanEntity;
    } else {
      return;
    } 
    {
      player.playSound((Entity)player, Sound.UI_BUTTON_CLICK, 1.0F, 1.0F);
      paramInventoryClickEvent.setCancelled(true);
      if (paramInventoryClickEvent.getSlot() == 40) {
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a_.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player);
        return;
      } 
    }{
      if (you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l == null)
        return; 
    }player.showDialog((DialogLike)You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l));
  }
  
  private Dialog You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l) {
    String s = ChatColor.stripColor(paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0().getItemMeta().getDisplayName());
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb builder = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b().You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(s + "Configure ");
    List<You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764w> list = paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v1();
    if (list.isEmpty()) {
      builder.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a("No config", player -> {});
    } else {
      for (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764w o : list) {
        if (o instanceof You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cl x) {
          builder.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(x.label(), player -> lambda$buildWeaponDialog$1(paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, s, x, player));
        } else if (o instanceof You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cj x) {
          builder.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(x.label(), player -> lambda$buildWeaponDialog$2(paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, s, x, player));
        } else if (o instanceof You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ck x) {
          builder.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(x.label(), player -> lambda$buildWeaponDialog$3(paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, s, x, player));
        } else {
          throw new MatchException(null, (Throwable)null);
        }
      }
    }
    return builder.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a();
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, String paramString1, String paramString2, float paramFloat1, float paramFloat2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : Lorg/bukkit/configuration/file/FileConfiguration;
    //   4: aload #4
    //   6: invokevirtual getDouble : (Ljava/lang/String;)D
    //   9: d2f
    //   10: fstore #7
    //   12: aload_0
    //   13: aload_2
    //   14: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l;)Lio/papermc/paper/dialog/Dialog;
    //   17: astore #8
    //   19: aload #4
    //   21: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Ljava/lang/String;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   24: aload_3
    //   25: aload #4
    //   27: sipush #13934
    //   30: sipush #-6747
    //   33: invokestatic a : (II)Ljava/lang/String;
    //   36: swap
    //   37: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : (Ljava/lang/String;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   45: aload #4
    //   47: invokestatic text : (Ljava/lang/String;)Lnet/kyori/adventure/text/TextComponent;
    //   50: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Lnet/kyori/adventure/text/Component;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   53: fload #5
    //   55: fload #6
    //   57: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (FF)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   60: fload #7
    //   62: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (F)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   65: aload_0
    //   66: aload #4
    //   68: aload #8
    //   70: <illegal opcode> accept : (Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd;Ljava/lang/String;Lio/papermc/paper/dialog/Dialog;)Ljava/util/function/BiConsumer;
    //   75: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Ljava/util/function/BiConsumer;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   78: aload_1
    //   79: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)V
    //   82: return
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, String paramString1, String paramString2, float paramFloat1, float paramFloat2, float paramFloat3) {
    // Byte code:
    //   0: aload_0
    //   1: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : Lorg/bukkit/configuration/file/FileConfiguration;
    //   4: aload #4
    //   6: invokevirtual getDouble : (Ljava/lang/String;)D
    //   9: d2f
    //   10: fstore #8
    //   12: aload_0
    //   13: aload_2
    //   14: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l;)Lio/papermc/paper/dialog/Dialog;
    //   17: astore #9
    //   19: aload #4
    //   21: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Ljava/lang/String;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   24: aload_3
    //   25: aload #4
    //   27: sipush #13935
    //   30: sipush #-22701
    //   33: invokestatic a : (II)Ljava/lang/String;
    //   36: swap
    //   37: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : (Ljava/lang/String;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   45: aload #4
    //   47: invokestatic text : (Ljava/lang/String;)Lnet/kyori/adventure/text/TextComponent;
    //   50: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Lnet/kyori/adventure/text/Component;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   53: fload #5
    //   55: fload #6
    //   57: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (FF)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   60: fload #8
    //   62: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (F)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   65: fload #7
    //   67: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : (F)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   70: aload_0
    //   71: aload #4
    //   73: aload #9
    //   75: <illegal opcode> accept : (Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd;Ljava/lang/String;Lio/papermc/paper/dialog/Dialog;)Ljava/util/function/BiConsumer;
    //   80: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : (Ljava/util/function/BiConsumer;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   83: aload_1
    //   84: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)V
    //   87: return
  }
  
  private void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, String paramString1, String paramString2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : Lorg/bukkit/configuration/file/FileConfiguration;
    //   4: aload #4
    //   6: invokevirtual getBoolean : (Ljava/lang/String;)Z
    //   9: istore #5
    //   11: aload_0
    //   12: aload_2
    //   13: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l;)Lio/papermc/paper/dialog/Dialog;
    //   16: astore #6
    //   18: aload #4
    //   20: invokestatic You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c : (Ljava/lang/String;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   23: aload_3
    //   24: aload #4
    //   26: sipush #13934
    //   29: sipush #-6747
    //   32: invokestatic a : (II)Ljava/lang/String;
    //   35: swap
    //   36: <illegal opcode> makeConcatWithConstants : (Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e : (Ljava/lang/String;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   44: aload #4
    //   46: invokestatic text : (Ljava/lang/String;)Lnet/kyori/adventure/text/TextComponent;
    //   49: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b : (Lnet/kyori/adventure/text/Component;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   52: iload #5
    //   54: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Z)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   57: aload_0
    //   58: aload #4
    //   60: aload #6
    //   62: <illegal opcode> accept : (Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd;Ljava/lang/String;Lio/papermc/paper/dialog/Dialog;)Ljava/util/function/BiConsumer;
    //   67: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d : (Ljava/util/function/BiConsumer;)Lpl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bb;
    //   70: aload_1
    //   71: invokevirtual You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a : (Lorg/bukkit/entity/Player;)V
    //   74: return
  }
  
  private void lambda$boolDialog$6(String paramString, Dialog paramDialog, Player paramPlayer, Boolean paramBoolean) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.set(paramString, paramBoolean);
    Main.getInstance().saveConfig();
    paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + paramString + " set to ");
    paramPlayer.showDialog((DialogLike)paramDialog);
  }
  
  private void lambda$floatDialog$5(String paramString, Dialog paramDialog, Player paramPlayer, Float paramFloat) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.set(paramString, paramFloat);
    Main.getInstance().saveConfig();
    paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + paramString + " set to ");
    paramPlayer.showDialog((DialogLike)paramDialog);
  }
  
  private void lambda$numDialog$4(String paramString, Dialog paramDialog, Player paramPlayer, Integer paramInteger) {
    this.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b.set(paramString, paramInteger);
    Main.getInstance().saveConfig();
    paramPlayer.sendMessage(String.valueOf(ChatColor.GREEN) + String.valueOf(ChatColor.GREEN) + paramString + " set to ");
    paramPlayer.showDialog((DialogLike)paramDialog);
  }
  
  private void lambda$buildWeaponDialog$3(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, String paramString, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ck paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ck, Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, paramString, paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ck.key(), paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ck.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(), paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ck.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(), paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ck.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c());
  }
  
  private void lambda$buildWeaponDialog$2(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, String paramString, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cj paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cj, Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, paramString, paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cj.key());
  }
  
  private void lambda$buildWeaponDialog$1(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, String paramString, You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cl paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cl, Player paramPlayer) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramPlayer, paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764l, paramString, paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cl.key(), paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(), paramYou_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764cl.You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e());
  }
  
  private static void lambda$buildWeaponDialog$0(Player paramPlayer) {}

  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }

  static {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = "§cʟᴇɢᴇɴᴅᴀʀɪᴇꜱ ᴄᴏɴꜰɪɢ";
  }

}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764bd.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */