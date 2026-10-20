package net.kingscraft.zenixmc.altarsmp.util;

import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class RandomUtils {
  public static float randomFloat(float paramFloat1, float paramFloat2) {
    return paramFloat1 + (float)Math.random() * (paramFloat2 - paramFloat1);
  }
}
