package pl;

import org.bukkit.ChatColor;

public class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a3 {
  
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(String paramString) {
    {
      if (paramString != null)
        {
          if (!paramString.isEmpty()) {
            paramString = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(paramString);
            return ChatColor.translateAlternateColorCodes('&', paramString);
          } 
          return paramString;
        }}return paramString;
  }
  
  private static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(String paramString) {
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
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(str)) {
          stringBuilder.append(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(str.substring(2)));
          i = j + 8;
          continue;
        } 
      } 
      if (j + 5 <= paramString.length()) {
        String str = paramString.substring(j, j + 5);
        if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(str)) {
          stringBuilder.append(You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(str.substring(2)));
          i = j + 5;
          continue;
        } 
      } 
      stringBuilder.append("&#");
      i = j + 2;
    } 
    return stringBuilder.toString();
  }
  
  private static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a__v0(String paramString) {
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
        if (!You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(c))
          return false; 
      }} 
    return true;
  }
  
  private static boolean You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(char paramChar) {
    if (paramChar >= '0' && paramChar <= '9')
      return true;
    if (paramChar >= 'A' && paramChar <= 'F')
      return true;
    if (paramChar >= 'a' && paramChar <= 'f')
      return true;
    return false;
  }
  
  private static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(String paramString) {
    StringBuilder stringBuilder = new StringBuilder("§x");
    for (char c : paramString.toCharArray())
      stringBuilder.append("§").append(c); 
    return stringBuilder.toString();
  }
  
  private static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764d(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    for (char c : paramString.toCharArray())
      stringBuilder.append(c).append(c); 
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(stringBuilder.toString());
  }
  
  public static String You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764e(String paramString) {
    {
      if (paramString != null)
        {
          if (!paramString.isEmpty()) {
            {
              if (paramString.startsWith("#"))
                {
                  if (paramString.length() == 7)
                    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramString.substring(1)); 
                }}{
              if (paramString.startsWith("&#"))
                {
                  if (paramString.length() == 8)
                    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764c(paramString.substring(2)); 
                }}return paramString;
          } 
          return "";
        }}return "";
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }


}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a3.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */