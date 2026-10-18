package net.kingscraft.zenixmc.altarsmp.util;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.Color;

public class ChatFormattingUtils {


  public static String toHexColorCode(Color paramColor) {
    return String.format("§x§%1$X§%2$X§%3$X§%4$X§%5$X§%6$X", paramColor.getRed() >> 4 & 0xF, paramColor.getRed() & 0xF, paramColor.getGreen() >> 4 & 0xF, paramColor.getGreen() & 0xF, paramColor.getBlue() >> 4 & 0xF, paramColor.getBlue() & 0xF);
  }



}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ca.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */