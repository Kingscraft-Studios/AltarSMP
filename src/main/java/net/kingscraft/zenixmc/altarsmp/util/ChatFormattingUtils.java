package net.kingscraft.zenixmc.altarsmp.util;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

import org.bukkit.Color;

public class ChatFormattingUtils {


  public static String toHexColorCode(Color paramColor) {
    return String.format("§x§%1$X§%2$X§%3$X§%4$X§%5$X§%6$X", paramColor.getRed() >> 4 & 0xF, paramColor.getRed() & 0xF, paramColor.getGreen() >> 4 & 0xF, paramColor.getGreen() & 0xF, paramColor.getBlue() >> 4 & 0xF, paramColor.getBlue() & 0xF);
  }



}
