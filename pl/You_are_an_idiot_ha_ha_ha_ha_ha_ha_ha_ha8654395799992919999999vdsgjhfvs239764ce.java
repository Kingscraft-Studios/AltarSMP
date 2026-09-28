package pl;

import java.util.Collection;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public final class You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ce {
  private static Main You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a;
  
  private static final String a;
  
  public You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ce(Main paramMain) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a = paramMain;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, int paramInt1, int paramInt2, double paramDouble1, double paramDouble2, double paramDouble3) {
    World world = paramLocation.getWorld();
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                double d1 = paramLocation.getX();
                double d2 = paramLocation.getY();
                double d3 = paramLocation.getZ();
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gv you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gv = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gv(paramInt1, paramDouble2, paramInt2, paramDouble1, paramDouble3, world, paramParticle, d1, d2, d3);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gv.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gv;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  private static Vector You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Vector paramVector) {
    Vector vector1 = paramVector.clone().normalize();
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    Vector vector2 = (Math.abs(vector1.getY()) < 0.99D) ? new Vector(0, 1, 0) : new Vector(1, 0, 0);
    return vector1.clone().crossProduct(vector2).normalize();
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, Vector paramVector, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (paramVector != null)
                try {
                  if (paramVector.lengthSquared() != 0.0D) {
                    Vector vector1 = paramVector.clone().normalize();
                    Vector vector2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(vector1);
                    Vector vector3 = vector1.clone().crossProduct(vector2).normalize();
                    double d1 = Math.max(0.1D, paramDouble1);
                    double d2 = Math.max(0.05D, paramDouble2);
                    double d3 = Math.max(0.1D, paramDouble4);
                    double d4 = paramLocation.getX();
                    double d5 = paramLocation.getY();
                    double d6 = paramLocation.getZ();
                    double d7;
                    for (d7 = 0.0D; d7 <= d1; d7 += d2) {
                      double d8 = d7 % d3 / d3;
                      double d9 = Math.abs(Math.cos(d8 * Math.PI));
                      double d10 = paramDouble3 * d9;
                      double d11 = d7 * paramDouble5;
                      Vector vector = vector1.clone().multiply(d7);
                      vector = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(vector, paramFloat1, paramFloat2, paramFloat3);
                      double d12 = d4 + vector.getX();
                      double d13 = d5 + vector.getY();
                      double d14 = d6 + vector.getZ();
                      for (byte b = 0; b < 4; b++) {
                        double d = d11 + 1.5707963267948966D * b;
                        Vector vector4 = vector2.clone().multiply(Math.cos(d) * d10).add(vector3.clone().multiply(Math.sin(d) * d10));
                        vector4 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(vector4, paramFloat1, paramFloat2, paramFloat3);
                        world.spawnParticle(paramParticle, d12 + vector4.getX(), d13 + vector4.getY(), d14 + vector4.getZ(), Math.max(1, paramInt), paramDouble6, paramDouble7, paramDouble8, paramDouble9, null, true);
                      } 
                    } 
                    return;
                  } 
                  return;
                } catch (MatchException matchException) {
                  throw a(null);
                }  
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, Vector paramVector, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt, double paramDouble6, double paramDouble7, double paramDouble8, double paramDouble9, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null)
            try {
              if (paramVector != null)
                try {
                  if (paramVector.lengthSquared() != 0.0D) {
                    Vector vector1 = paramVector.clone().normalize();
                    Vector vector2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(vector1);
                    Vector vector3 = vector1.clone().crossProduct(vector2).normalize();
                    double d1 = Math.max(0.1D, paramDouble1);
                    double d2 = Math.max(0.05D, paramDouble2);
                    double d3 = Math.max(0.1D, paramDouble4);
                    double d4 = paramLocation.getX();
                    double d5 = paramLocation.getY();
                    double d6 = paramLocation.getZ();
                    double d7;
                    for (d7 = 0.0D; d7 <= d1; d7 += d2) {
                      double d8 = d7 % d3 / d3;
                      double d9 = Math.abs(Math.cos(d8 * Math.PI));
                      double d10 = paramDouble3 * d9;
                      double d11 = d7 * paramDouble5;
                      Vector vector = vector1.clone().multiply(d7);
                      vector = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(vector, paramFloat1, paramFloat2, paramFloat3);
                      double d12 = d4 + vector.getX();
                      double d13 = d5 + vector.getY();
                      double d14 = d6 + vector.getZ();
                      for (byte b = 0; b < 4; b++) {
                        double d = d11 + 1.5707963267948966D * b;
                        Vector vector4 = vector2.clone().multiply(Math.cos(d) * d10).add(vector3.clone().multiply(Math.sin(d) * d10));
                        vector4 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(vector4, paramFloat1, paramFloat2, paramFloat3);
                        world.spawnParticle(Particle.DUST, d12 + vector4.getX(), d13 + vector4.getY(), d14 + vector4.getZ(), Math.max(1, paramInt), paramDouble6, paramDouble7, paramDouble8, paramDouble9, paramDustOptions, true);
                      } 
                    } 
                    return;
                  } 
                  return;
                } catch (MatchException matchException) {
                  throw a(null);
                }  
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, Vector paramVector, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, int paramInt1, int paramInt2, double paramDouble7, double paramDouble8, double paramDouble9, double paramDouble10, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null)
                try {
                  if (paramVector != null)
                    try {
                      if (paramVector.lengthSquared() != 0.0D) {
                        Vector vector1 = paramVector.clone().normalize();
                        Vector vector2 = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(vector1);
                        Vector vector3 = vector1.clone().crossProduct(vector2).normalize();
                        double d1 = Math.max(0.1D, paramDouble1);
                        double d2 = Math.max(0.05D, paramDouble2);
                        double d3 = Math.max(0.1D, paramDouble4);
                        double d4 = Math.max(d2, paramDouble6);
                        double d5 = paramLocation.getX();
                        double d6 = paramLocation.getY();
                        double d7 = paramLocation.getZ();
                        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g6 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g6 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g6(paramInt1, d4, d1, d2, d3, paramDouble3, paramDouble5, vector1, paramFloat1, paramFloat2, paramFloat3, d5, d6, d7, vector2, vector3, world, paramParticle, paramInt2, paramDouble7, paramDouble8, paramDouble9, paramDouble10);
                        you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g6.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                        return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g6;
                      } 
                      return null;
                    } catch (MatchException matchException) {
                      throw a(null);
                    }  
                } catch (MatchException matchException) {
                  throw a(null);
                }  
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, int paramInt3) {
    World world = paramLocation.getWorld();
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                double d1 = paramLocation.getX();
                double d2 = paramLocation.getY();
                double d3 = paramLocation.getZ();
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g_ you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g_ = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g_(paramInt1, paramInt2, paramDouble1, d1, d3, world, paramParticle, d2, paramInt3, paramDouble2);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g_.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g_;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  private static World You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation) {
    try {
    
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return (paramLocation == null) ? null : paramLocation.getWorld();
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(World paramWorld, Particle paramParticle, Location paramLocation, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    try {
      if (paramWorld != null)
        try {
          if (paramLocation != null)
            try {
              if (paramParticle != null) {
                paramWorld.spawnParticle(paramParticle, paramLocation, Math.max(1, paramInt), paramDouble1, paramDouble2, paramDouble3, paramDouble4);
                return;
              } 
              return;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(World paramWorld, Location paramLocation, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, Particle.DustOptions paramDustOptions) {
    try {
      if (paramWorld != null)
        try {
          if (paramLocation != null)
            try {
              if (paramDustOptions != null) {
                paramWorld.spawnParticle(Particle.DUST, paramLocation, Math.max(1, paramInt), paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDustOptions, true);
                return;
              } 
              return;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static Vector You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Vector paramVector, float paramFloat) {
    double d1 = Math.toRadians(paramFloat);
    double d2 = Math.cos(d1);
    double d3 = Math.sin(d1);
    double d4 = paramVector.getX() * d2 - paramVector.getZ() * d3;
    double d5 = paramVector.getX() * d3 + paramVector.getZ() * d2;
    return new Vector(d4, paramVector.getY(), d5);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt3) {
    World world = paramLocation.getWorld();
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt2);
                double d1 = paramLocation.getX();
                double d2 = paramLocation.getY();
                double d3 = paramLocation.getZ();
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ha you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ha = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ha(paramInt1, paramDouble4, paramDouble5, paramDouble1, i, paramDouble3, paramDouble2, d1, d3, world, paramParticle, d2, paramInt3);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ha.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ha;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, int paramInt3, BlockData paramBlockData) {
    World world = paramLocation.getWorld();
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt2);
                double d1 = paramLocation.getX();
                double d2 = paramLocation.getY();
                double d3 = paramLocation.getZ();
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hb you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hb = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hb(paramInt1, paramDouble4, paramDouble5, paramDouble1, i, paramDouble3, paramDouble2, d1, d3, world, paramParticle, d2, paramInt3, paramBlockData);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hb.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hb;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, int paramInt4, double paramDouble7, double paramDouble8, double paramDouble9, double paramDouble10, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt1);
                int j = Math.max(1, paramInt2);
                int k = Math.max(8, paramInt3);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hc you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hc = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hc(i, paramDouble5, paramDouble6, j, k, paramDouble1, paramDouble4, paramDouble3, paramDouble2, paramFloat1, paramFloat2, paramFloat3, paramLocation, world, paramInt4, paramDouble7, paramDouble8, paramDouble9, paramDouble10, paramDustOptions);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hc.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hc;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble, int paramInt) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramParticle, paramLocation, paramDouble, paramInt, 4, 0.25D, 2.0D, 0.02D, 0.25D, 1);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble, int paramInt) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramDustOptions, paramLocation, paramDouble, paramInt, 4, 60, 0.1D, 0.25D, 2.0D, 0.08D, 0.35D, 1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static Vector You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Vector paramVector, float paramFloat1, float paramFloat2, float paramFloat3) {
    double d1 = Math.toRadians(paramFloat1);
    double d2 = Math.toRadians(paramFloat2);
    double d3 = Math.toRadians(paramFloat3);
    Vector vector = paramVector.clone();
    double d4 = Math.cos(d3);
    double d5 = Math.sin(d3);
    double d6 = vector.getX() * d4 - vector.getY() * d5;
    double d7 = vector.getX() * d5 + vector.getY() * d4;
    vector.setX(d6).setY(d7);
    double d8 = Math.cos(d2);
    double d9 = Math.sin(d2);
    double d10 = vector.getY() * d8 - vector.getZ() * d9;
    double d11 = vector.getY() * d9 + vector.getZ() * d8;
    vector.setY(d10).setZ(d11);
    double d12 = Math.cos(d1);
    double d13 = Math.sin(d1);
    double d14 = vector.getX() * d12 + vector.getZ() * d13;
    double d15 = -vector.getX() * d13 + vector.getZ() * d12;
    vector.setX(d14).setZ(d15);
    return vector;
  }
  
  public static Vector You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Vector paramVector, float paramFloat1, float paramFloat2, float paramFloat3) {
    double d1 = Math.toRadians(paramFloat1);
    double d2 = Math.toRadians(paramFloat2);
    double d3 = Math.toRadians(paramFloat3);
    double d4 = paramVector.getX();
    double d5 = paramVector.getY();
    double d6 = paramVector.getZ();
    double d7 = Math.cos(d1);
    double d8 = Math.sin(d1);
    double d9 = d4 * d7 - d6 * d8;
    double d10 = d4 * d8 + d6 * d7;
    double d11 = Math.cos(d2);
    double d12 = Math.sin(d2);
    double d13 = d5 * d11 - d10 * d12;
    double d14 = d5 * d12 + d10 * d11;
    double d15 = Math.cos(d3);
    double d16 = Math.sin(d3);
    double d17 = d9 * d15 - d13 * d16;
    double d18 = d9 * d16 + d13 * d15;
    return new Vector(d17, d18, d14);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, int paramInt3, int paramInt4, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(3, paramInt1);
                int j = Math.max(0, paramInt2);
                int k = Math.max(1, paramInt3);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hd you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hd = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hd(j, paramParticle, paramLocation, paramDouble1, i, paramInt4, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramFloat1, paramFloat2, paramFloat3, k, paramDouble2);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hd.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hd;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, int paramInt3, int paramInt4, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(3, paramInt1);
                int j = Math.max(0, paramInt2);
                int k = Math.max(1, paramInt3);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764he you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764he = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764he(j, paramDustOptions, paramLocation, paramDouble1, i, paramInt4, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramFloat1, paramFloat2, paramFloat3, k, paramDouble2);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764he.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764he;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, int paramInt3) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramParticle, paramLocation, paramDouble1, paramInt1, paramInt2, paramDouble2, paramInt3, 1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, int paramInt3) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramDustOptions, paramLocation, paramDouble1, paramInt1, paramInt2, paramDouble2, paramInt3, 1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null) {
            int i = Math.max(3, paramInt1);
            double d = 6.283185307179586D / i;
            for (byte b = 0; b < i; b++) {
              double d1 = b * d;
              Vector vector = new Vector(Math.cos(d1) * paramDouble1, 0.0D, Math.sin(d1) * paramDouble1);
              vector = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(vector, paramFloat1, paramFloat2, paramFloat3);
              Location location = paramLocation.clone().add(vector);
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(world, paramParticle, location, paramInt2, paramDouble2, paramDouble3, paramDouble4, paramDouble5);
            } 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    int i = Math.max(3, paramInt1);
    double d = 6.283185307179586D / i;
    for (byte b = 0; b < i; b++) {
      double d1 = b * d;
      Vector vector = new Vector(Math.cos(d1) * paramDouble1, 0.0D, Math.sin(d1) * paramDouble1);
      vector = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(vector, paramFloat1, paramFloat2, paramFloat3);
      Location location = paramLocation.clone().add(vector);
      You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(world, location, paramInt2, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDustOptions);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble, int paramInt) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramParticle, paramLocation, paramDouble, paramInt, 1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble, int paramInt) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramDustOptions, paramLocation, paramDouble, paramInt, 1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(3, paramInt2);
                int j = Math.max(1, paramInt1);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hf you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hf = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hf(j, paramDouble1, paramParticle, paramLocation, i, paramInt3, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramFloat1, paramFloat2, paramFloat3);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hf.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764hf;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(3, paramInt2);
                int j = Math.max(1, paramInt1);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gw you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gw = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gw(j, paramDouble1, paramDustOptions, paramLocation, i, paramInt3, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramFloat1, paramFloat2, paramFloat3);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gw.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gw;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Particle paramParticle, Location paramLocation, double paramDouble, int paramInt) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramParticle, paramLocation, paramDouble, paramInt, 100, 2, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble, int paramInt) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramDustOptions, paramLocation, paramDouble, paramInt, 100, 2, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, boolean paramBoolean, int paramInt2, double paramDouble2, int paramInt3, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt1);
                int j = Math.max(1, paramInt2);
                try {
                
                } catch (MatchException matchException) {
                  throw a(null);
                } 
                double d = paramBoolean ? 1.0D : -1.0D;
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gx you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gx = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gx(i, j, d, paramDouble1, paramFloat1, paramFloat2, paramFloat3, paramLocation, world, paramParticle, paramInt3, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDouble2);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gx.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gx;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, boolean paramBoolean, int paramInt2, double paramDouble2, int paramInt3, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt1);
                int j = Math.max(1, paramInt2);
                try {
                
                } catch (MatchException matchException) {
                  throw a(null);
                } 
                double d = paramBoolean ? 1.0D : -1.0D;
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gy you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gy = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gy(i, j, d, paramDouble1, paramFloat1, paramFloat2, paramFloat3, paramLocation, world, paramInt3, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDustOptions, paramDouble2);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gy.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gy;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, int paramInt1, double paramDouble, int paramInt2, boolean paramBoolean) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramParticle, paramLocation, paramDouble, paramInt2, paramBoolean, 15, 0.15D, paramInt1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble, int paramInt, boolean paramBoolean) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramParticle, paramLocation, paramDouble, paramInt, paramBoolean, 15, 0.15D, 1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble, int paramInt, boolean paramBoolean) {
    return You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramDustOptions, paramLocation, paramDouble, paramInt, paramBoolean, 15, 0.15D, 1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, float paramFloat, int paramInt2, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt1);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gz you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gz = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gz(i, paramDouble1, paramFloat, world, paramLocation, paramDustOptions, paramInt2, paramDouble2, paramDouble3, paramDouble4, paramDouble5);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gz.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764gz;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(World paramWorld, Location paramLocation, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, Particle.DustOptions paramDustOptions, int paramInt, double paramDouble5, double paramDouble6, double paramDouble7, double paramDouble8) {
    double d1 = paramDouble1 * paramDouble3 - paramDouble2 * paramDouble4;
    double d2 = paramDouble1 * paramDouble4 + paramDouble2 * paramDouble3;
    Location location = paramLocation.clone().add(d1, 0.0D, d2);
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramWorld, location, paramInt, paramDouble5, paramDouble6, paramDouble7, paramDouble8, paramDustOptions);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null) {
            int i = Math.max(3, paramInt1);
            int j = Math.max(6, paramInt2);
            for (byte b = 0; b <= i; b++) {
              double d1 = Math.PI * b / i;
              double d2 = Math.cos(d1) * paramDouble1;
              double d3 = Math.sin(d1) * paramDouble1;
              for (byte b1 = 0; b1 < j; b1++) {
                double d = 6.283185307179586D * b1 / j;
                Vector vector = new Vector(Math.cos(d) * d3, d2, Math.sin(d) * d3);
                vector = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(vector, paramFloat1, paramFloat2, paramFloat3);
                Location location = paramLocation.clone().add(vector);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(world, paramParticle, location, paramInt3, paramDouble2, paramDouble3, paramDouble4, paramDouble5);
              } 
            } 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null) {
            int i = Math.max(3, paramInt1);
            int j = Math.max(6, paramInt2);
            for (byte b = 0; b <= i; b++) {
              double d1 = Math.PI * b / i;
              double d2 = Math.cos(d1) * paramDouble1;
              double d3 = Math.sin(d1) * paramDouble1;
              for (byte b1 = 0; b1 < j; b1++) {
                double d = 6.283185307179586D * b1 / j;
                Vector vector = new Vector(Math.cos(d) * d3, d2, Math.sin(d) * d3);
                vector = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764b(vector, paramFloat1, paramFloat2, paramFloat3);
                Location location = paramLocation.clone().add(vector);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(world, location, paramInt3, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramDustOptions);
              } 
            } 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble, int paramInt1, int paramInt2) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramParticle, paramLocation, paramDouble, paramInt1, paramInt2, 1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble, int paramInt1, int paramInt2) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramDustOptions, paramLocation, paramDouble, paramInt1, paramInt2, 1, 0.0D, 0.0D, 0.0D, 0.0D, 0.0F, 0.0F, 0.0F);
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, int paramInt4, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt3);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g0 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g0 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g0(i, paramParticle, paramLocation, paramDouble1, paramInt1, paramInt2, paramInt4, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramFloat2, paramFloat3, paramFloat1);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g0.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g0;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, int paramInt4, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt3);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g1 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g1 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g1(i, paramDustOptions, paramLocation, paramDouble1, paramInt1, paramInt2, paramInt4, paramDouble2, paramDouble3, paramDouble4, paramDouble5, paramFloat2, paramFloat3, paramFloat1);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g1.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g1;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, double paramDouble3, int paramInt4, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt3);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g2 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g2 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g2(i, paramDouble3, paramDouble1, paramDouble2, paramParticle, paramLocation, paramInt1, paramInt2, paramInt4, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramFloat1, paramFloat2, paramFloat3);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g2.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g2;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, int paramInt3, double paramDouble3, int paramInt4, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt3);
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g3 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g3 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g3(i, paramDouble3, paramDouble1, paramDouble2, paramDustOptions, paramLocation, paramInt1, paramInt2, paramInt4, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramFloat1, paramFloat2, paramFloat3);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g3.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g3;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2, double paramDouble3, int paramInt4, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt1);
                int j = Math.max(1, paramInt2);
                int k = Math.max(8, paramInt3);
                double d = 6.283185307179586D / k;
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g4 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g4 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g4(i, paramDouble3, j, paramDouble1, paramDouble2, k, d, paramFloat1, paramFloat2, paramFloat3, paramLocation, world, paramParticle, paramInt4, paramDouble4, paramDouble5, paramDouble6, paramDouble7);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g4.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g4;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static BukkitRunnable You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2, double paramDouble3, int paramInt4, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7, float paramFloat1, float paramFloat2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (paramDustOptions != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                int i = Math.max(1, paramInt1);
                int j = Math.max(1, paramInt2);
                int k = Math.max(8, paramInt3);
                double d = 6.283185307179586D / k;
                You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g5 you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g5 = new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g5(i, paramDouble3, j, paramDouble1, paramDouble2, k, d, paramFloat1, paramFloat2, paramFloat3, paramLocation, world, paramInt4, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramDustOptions);
                you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g5.runTaskTimer((Plugin)Main.getInstance(), 0L, 1L);
                return you_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g5;
              } 
              return null;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
    return null;
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, Particle paramParticle, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, int paramInt3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7) {
    try {
      if (paramPlayer != null)
        try {
          if (paramParticle != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g7(paramPlayer, paramInt1, paramDouble2, paramDouble1, paramParticle, paramInt3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramDouble3, paramInt2)).runTaskTimer((Plugin)Main.getInstance(), 0L, Math.max(1, paramInt2));
                return;
              } 
              return;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Player paramPlayer, Particle.DustOptions paramDustOptions, double paramDouble1, double paramDouble2, int paramInt1, int paramInt2, double paramDouble3, int paramInt3, double paramDouble4, double paramDouble5, double paramDouble6, double paramDouble7) {
    try {
      if (paramPlayer != null)
        try {
          if (paramDustOptions != null)
            try {
              if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
                (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g8(paramPlayer, paramInt1, paramDouble2, paramDouble1, paramInt3, paramDouble4, paramDouble5, paramDouble6, paramDouble7, paramDustOptions, paramDouble3, paramInt2)).runTaskTimer((Plugin)Main.getInstance(), 0L, Math.max(1, paramInt2));
                return;
              } 
              return;
            } catch (MatchException matchException) {
              throw a(null);
            }  
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Color paramColor) {
    String str = Bukkit.getMinecraftVersion();
    try {
      if (Integer.parseInt(str.split(a)[2]) >= 9) {
        paramLocation.getWorld().spawnParticle(Particle.FLASH, paramLocation, 1, 0.0D, 0.0D, 0.0D, 0.0D, paramColor);
      } else {
        paramLocation.getWorld().spawnParticle(Particle.FLASH, paramLocation, 1, 0.0D, 0.0D, 0.0D, 0.0D);
      } 
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle paramParticle, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramParticle, paramLocation, paramDouble1, paramInt1, paramInt2, paramInt3, paramDouble2, paramDouble3, paramDouble4, paramDouble5, 0.0F, 0.0F, 0.0F);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Particle.DustOptions paramDustOptions, Location paramLocation, double paramDouble1, int paramInt1, int paramInt2, int paramInt3, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5) {
    You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramDustOptions, paramLocation, paramDouble1, paramInt1, paramInt2, paramInt3, paramDouble2, paramDouble3, paramDouble4, paramDouble5, 0.0F, 0.0F, 0.0F);
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, Sound paramSound, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2, float paramFloat3) {
    World world = You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(paramLocation);
    try {
      if (world != null)
        try {
          if (You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a != null) {
            int i = Math.max(1, paramInt1);
            int j = Math.max(1, paramInt2);
            (new You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764g9(paramFloat2, i, world, paramLocation, paramSound, paramFloat1, paramFloat3)).runTaskTimer((Plugin)Main.getInstance(), 0L, j);
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble1, double paramDouble2, PotionEffectType paramPotionEffectType, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {
    try {
      if (paramLocation != null)
        try {
          if (paramLocation.getWorld() != null) {
            for (Player player : paramLocation.getNearbyPlayers(paramDouble1, paramDouble2, paramDouble1))
              player.addPotionEffect(new PotionEffect(paramPotionEffectType, paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramBoolean3)); 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble1, double paramDouble2, PotionEffectType paramPotionEffectType) {
    try {
      if (paramLocation != null)
        try {
          if (paramLocation.getWorld() != null) {
            for (Player player : paramLocation.getNearbyPlayers(paramDouble1, paramDouble2, paramDouble1))
              player.removePotionEffect(paramPotionEffectType); 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4) {
    try {
      if (paramLocation != null)
        try {
          if (paramLocation.getWorld() != null) {
            Vector vector = paramLocation.toVector();
            for (Player player : paramLocation.getNearbyPlayers(paramDouble1, paramDouble2, paramDouble1)) {
              Vector vector1 = player.getLocation().toVector().subtract(vector);
              try {
                vector1.setY(0);
                if (vector1.lengthSquared() < 1.0E-4D)
                  continue; 
              } catch (MatchException matchException) {
                throw a(null);
              } 
              Vector vector2 = vector1.normalize().multiply(paramDouble3);
              vector2.setY(paramDouble4);
              player.setVelocity(vector2);
            } 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble1, double paramDouble2, Particle paramParticle, int paramInt, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
    try {
      if (paramLocation != null)
        try {
          if (paramLocation.getWorld() != null) {
            for (Player player : paramLocation.getNearbyPlayers(paramDouble1, paramDouble2, paramDouble1)) {
              Location location = player.getLocation().clone().add(0.0D, 1.0D, 0.0D);
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location.getWorld(), paramParticle, location, paramInt, paramDouble3, paramDouble4, paramDouble5, paramDouble6);
            } 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Location paramLocation, double paramDouble1, double paramDouble2, Particle.DustOptions paramDustOptions, int paramInt, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6) {
    try {
      if (paramLocation != null)
        try {
          if (paramLocation.getWorld() != null) {
            for (Player player : paramLocation.getNearbyPlayers(paramDouble1, paramDouble2, paramDouble1)) {
              Location location = player.getLocation().clone().add(0.0D, 1.0D, 0.0D);
              You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(location.getWorld(), location, paramInt, paramDouble3, paramDouble4, paramDouble5, paramDouble6, paramDustOptions);
            } 
            return;
          } 
          return;
        } catch (MatchException matchException) {
          throw a(null);
        }  
    } catch (MatchException matchException) {
      throw a(null);
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Collection<Player> paramCollection, Particle paramParticle, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5) {
    try {
      if (paramCollection == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    for (Player player : paramCollection) {
      if (player != null) {
        try {
          if (!player.isOnline())
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        Location location = player.getLocation().clone().add(0.0D, paramDouble5, 0.0D);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getWorld(), paramParticle, location, paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4);
      } 
    } 
  }
  
  public static void You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(Collection<Player> paramCollection, Particle.DustOptions paramDustOptions, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5) {
    try {
      if (paramCollection == null)
        return; 
    } catch (MatchException matchException) {
      throw a(null);
    } 
    for (Player player : paramCollection) {
      if (player != null) {
        try {
          if (!player.isOnline())
            continue; 
        } catch (MatchException matchException) {
          throw a(null);
        } 
        Location location = player.getLocation().clone().add(0.0D, paramDouble5, 0.0D);
        You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764a(player.getWorld(), location, paramInt, paramDouble1, paramDouble2, paramDouble3, paramDouble4, paramDustOptions);
      } 
    } 
  }
  
  private static MatchException a(MatchException paramMatchException) {
    return paramMatchException;
  }
  
  static {
    // Byte code:
    //   0: bipush #122
    //   2: ldc 'oo'
    //   4: iconst_m1
    //   5: goto -> 14
    //   8: putstatic pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ce.a : Ljava/lang/String;
    //   11: goto -> 154
    //   14: dup_x2
    //   15: pop
    //   16: invokevirtual toCharArray : ()[C
    //   19: dup_x1
    //   20: arraylength
    //   21: dup_x2
    //   22: pop
    //   23: iconst_0
    //   24: istore_0
    //   25: dup2_x1
    //   26: pop2
    //   27: dup_x2
    //   28: iconst_1
    //   29: if_icmpgt -> 128
    //   32: dup2
    //   33: swap
    //   34: iload_0
    //   35: dup2_x1
    //   36: caload
    //   37: swap
    //   38: iload_0
    //   39: bipush #7
    //   41: irem
    //   42: tableswitch default -> 110, 0 -> 80, 1 -> 85, 2 -> 90, 3 -> 95, 4 -> 100, 5 -> 105
    //   80: bipush #73
    //   82: goto -> 112
    //   85: bipush #59
    //   87: goto -> 112
    //   90: bipush #46
    //   92: goto -> 112
    //   95: bipush #83
    //   97: goto -> 112
    //   100: bipush #58
    //   102: goto -> 112
    //   105: bipush #22
    //   107: goto -> 112
    //   110: bipush #16
    //   112: ixor
    //   113: ixor
    //   114: i2c
    //   115: castore
    //   116: iinc #0, 1
    //   119: dup
    //   120: ifne -> 128
    //   123: dup2
    //   124: dup_x1
    //   125: goto -> 35
    //   128: dup2_x1
    //   129: pop2
    //   130: dup_x2
    //   131: iload_0
    //   132: if_icmpgt -> 32
    //   135: pop
    //   136: new java/lang/String
    //   139: dup_x1
    //   140: swap
    //   141: invokespecial <init> : ([C)V
    //   144: invokevirtual intern : ()Ljava/lang/String;
    //   147: swap
    //   148: pop
    //   149: swap
    //   150: pop
    //   151: goto -> 8
    //   154: return
  }
}


/* Location:              /home/kingscrafts/Documents/AltarSMP.jar!/pl/You_are_an_idiot_ha_ha_ha_ha_ha_ha_ha_ha8654395799992919999999vdsgjhfvs239764ce.class
 * Java compiler version: 21 (65.0)
 * JD-Core Version:       1.1.3
 */