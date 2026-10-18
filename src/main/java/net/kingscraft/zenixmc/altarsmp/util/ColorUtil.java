package net.kingscraft.zenixmc.altarsmp.util;

import org.bukkit.ChatColor;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class ColorUtil {
  
  
  public static String translateColors(String paramString) {
    {
      if (paramString != null)
        {
          if (!paramString.isEmpty()) {
            paramString = translateHexColors(paramString);
            return ChatColor.translateAlternateColorCodes('&', paramString);
          } 
          return paramString;
        }}return paramString;
  }
  
  public static String translateHexColors(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length()) {
      int j = paramString.indexOf("&#", i);
      {
        if (j == -1) {
          stringBuilder.append(paramString.substring(i));
          break;
        } 
      }stringBuilder.append(paramString.substring(i, j));
      if (j + 8 <= paramString.length()) {
        String str = paramString.substring(j, j + 8);
        if (isValidHexColor(str)) {
          stringBuilder.append(toMinecraftHexColor(str.substring(2)));
          i = j + 8;
          continue;
        } 
      } 
      if (j + 5 <= paramString.length()) {
        String str = paramString.substring(j, j + 5);
        if (isValidHexColor(str)) {
          stringBuilder.append(expandShortHexColor(str.substring(2)));
          i = j + 5;
          continue;
        } 
      } 
      stringBuilder.append("&#");
      i = j + 2;
    } 
    return stringBuilder.toString();
  }
  
  public static boolean isValidHexColor(String paramString) {
    {
      if (paramString.startsWith("&#")) {
        {
          if (paramString.length() != 8)
            {
              if (paramString.length() != 5)
                return false; 
            }}} else {
        return false;
      } 
    }String str = paramString.substring(2);
    for (char c : str.toCharArray()) {
      {
        if (!isHexDigit(c))
          return false; 
      }} 
    return true;
  }
  
  public static boolean isHexDigit(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return true;
    if (paramChar >= 'A' && paramChar <= 'F')
      return true;
    if (paramChar >= 'a' && paramChar <= 'f')
      return true;
    return false;
  }
  
  public static String toMinecraftHexColor(String paramString) {
    StringBuilder stringBuilder = new StringBuilder("§x");
    for (char c : paramString.toCharArray())
      stringBuilder.append("§").append(c); 
    return stringBuilder.toString();
  }
  
  public static String expandShortHexColor(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : paramString.toCharArray())
      stringBuilder.append(c).append(c); 
    return toMinecraftHexColor(stringBuilder.toString());
  }
  
  public static String toMinecraftHexColorIfValid(String paramString) {
    {
      if (paramString != null)
        {
          if (!paramString.isEmpty()) {
            {
              if (paramString.startsWith("#"))
                {
                  if (paramString.length() == 7)
                    return toMinecraftHexColor(paramString.substring(1));
                }}{
              if (paramString.startsWith("&#"))
                {
                  if (paramString.length() == 8)
                    return toMinecraftHexColor(paramString.substring(2));
                }}return paramString;
          } 
          return "";
        }}return "";
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a3.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */