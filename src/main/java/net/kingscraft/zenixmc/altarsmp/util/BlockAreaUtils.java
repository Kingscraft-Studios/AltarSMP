package net.kingscraft.zenixmc.altarsmp.util;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.block.Block;

public class BlockAreaUtils {
  public static List<Block> getBlocksInArea(Location paramLocation, int paramInt1, int paramInt2) {
    int i = paramInt1 / 2;
    int j = paramInt2 / 2;
    ArrayList<Block> arrayList = new ArrayList<>();
    for (int k = -i; k <= i; k++) {
      for (int m = -i; m <= i; m++) {
        int n = -j;
        while (n <= j) {
          arrayList.add(paramLocation.clone().add(k, n, m).getBlock());
          n++;
        } 

      } 
    } 
    return arrayList;
  }

}
