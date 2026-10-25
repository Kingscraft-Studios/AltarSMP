package net.kingscraft.zenixmc.altarsmp.util;

import org.bukkit.ChatColor;

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
      }stringBuilder.append(paramString, i, j);
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
    return paramChar >= 'a' && paramChar <= 'f';
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

  public static String gradient(String text, String fromHex, String toHex) {
    int from = parseGradientHex(fromHex);
    int to = parseGradientHex(toHex);
    int denominator = Math.max(text.length() - 1, 1);
    StringBuilder builder = new StringBuilder(text.length() * 8);
    for (int i = 0; i < text.length(); i++) {
      double progress = i / (double) denominator;
      int red = gradientChannel((from >> 16) & 0xFF, (to >> 16) & 0xFF, progress);
      int green = gradientChannel((from >> 8) & 0xFF, (to >> 8) & 0xFF, progress);
      int blue = gradientChannel(from & 0xFF, to & 0xFF, progress);
      builder.append(net.md_5.bungee.api.ChatColor.of(String.format("#%02x%02x%02x", red, green, blue)));
      builder.append(net.md_5.bungee.api.ChatColor.BOLD);
      builder.append(text.charAt(i));
    }
    return builder.toString();
  }

  private static int gradientChannel(int from, int to, double progress) {
    return (int)Math.round(from + (to - from) * progress);
  }

  private static int parseGradientHex(String hex) {
    String value = hex.startsWith("#") ? hex.substring(1) : hex;
    return Integer.parseInt(value, 16);
  }
}
