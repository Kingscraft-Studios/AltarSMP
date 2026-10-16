package pl;

import org.bukkit.Color;

public class ChatFormattingUtils {
  
  
  public static String translateColorCodes(String paramString) {
    {
      if (paramString == null)
        return null; 
    }return paramString.replaceAll("(?i)&([0-9A-FK-OR])", "§$1");
  }
  
  public static String toHexColorCode(Color paramColor) {
    return String.format("§x§%1$X§%2$X§%3$X§%4$X§%5$X§%6$X", new Object[] { Integer.valueOf(paramColor.getRed() >> 4 & 0xF), Integer.valueOf(paramColor.getRed() & 0xF), Integer.valueOf(paramColor.getGreen() >> 4 & 0xF), Integer.valueOf(paramColor.getGreen() & 0xF), Integer.valueOf(paramColor.getBlue() >> 4 & 0xF), Integer.valueOf(paramColor.getBlue() & 0xF) });
  }
  
  public static String formatHexColor(String paramString) {
    {
      if (paramString.startsWith("#"))
        {
          if (paramString.length() == 7) {
            StringBuilder stringBuilder = new StringBuilder("§x");
            for (char c : paramString.substring(1).toCharArray())
              stringBuilder.append("§").append(c); 
            return stringBuilder.toString();
          } 
          return "Invalid hex code! Use format: #RRGGBB";
        }
    }
    return "Invalid hex code! Use format: #RRGGBB";
  }
  
  public static String toSmallCaps(String paramString) {
    paramString = paramString.toLowerCase();
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : paramString.toCharArray()) {
      {
        switch (c) {
          case 'a':
            stringBuilder.append('ᴀ');
            break;
          case 'b':
            stringBuilder.append('ʙ');
            break;
          case 'c':
            stringBuilder.append('ᴄ');
            break;
          case 'd':
            stringBuilder.append('ᴅ');
            break;
          case 'e':
            stringBuilder.append('ᴇ');
            break;
          case 'f':
            stringBuilder.append('ғ');
            break;
          case 'g':
            stringBuilder.append('ɢ');
            break;
          case 'h':
            stringBuilder.append('ʜ');
            break;
          case 'i':
            stringBuilder.append('ɪ');
            break;
          case 'j':
            stringBuilder.append('ᴊ');
            break;
          case 'k':
            stringBuilder.append('ᴋ');
            break;
          case 'l':
            stringBuilder.append('ʟ');
            break;
          case 'm':
            stringBuilder.append('ᴍ');
            break;
          case 'n':
            stringBuilder.append('ɴ');
            break;
          case 'o':
            stringBuilder.append('ᴏ');
            break;
          case 'p':
            stringBuilder.append('ᴘ');
            break;
          case 'q':
            stringBuilder.append('ǫ');
            break;
          case 'r':
            stringBuilder.append('ʀ');
            break;
          case 's':
            stringBuilder.append('ꜱ');
            break;
          case 't':
            stringBuilder.append('ᴛ');
            break;
          case 'u':
            stringBuilder.append('ᴜ');
            break;
          case 'v':
            stringBuilder.append('ᴠ');
            break;
          case 'w':
            stringBuilder.append('ᴡ');
            break;
          case 'x':
            stringBuilder.append('x');
            break;
          case 'y':
            stringBuilder.append('ʏ');
            break;
          case 'z':
            stringBuilder.append('ᴢ');
            break;
          case ' ':
            stringBuilder.append(' ');
            break;
          default:
            stringBuilder.append(c);
            break;
        } 
      }} 
    return stringBuilder.toString();
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ca.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */