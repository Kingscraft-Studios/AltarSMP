package net.kingscraft.zenixmc.altarsmp.util;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.block.Block;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public class BlockAreaUtils {
  public static List<Block> getBlocksInArea(Location paramLocation, int paramInt1, int paramInt2) {
    int i = paramInt1 / 2;
    int j = paramInt2 / 2;
    ArrayList<Block> arrayList = new ArrayList();
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


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764p.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */