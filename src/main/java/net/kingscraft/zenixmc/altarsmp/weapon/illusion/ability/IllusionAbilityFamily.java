package net.kingscraft.zenixmc.altarsmp.weapon.illusion.ability;

/**
 * Ability families group mobs that share one usable ability instead of giving
 * every single mob its own bespoke implementation.
 */
public enum IllusionAbilityFamily {

  FIREBALL("Shoot Fireball", true),
  EXPLODE("Explosive Burst", false),
  TELEPORT("Blink", false),
  SONIC_BOOM("Sonic Boom", false),
  WITHER_SKULL("Wither Skull Volley", true),
  POISON_BITE("Venomous Bite", false),
  ARROW_VOLLEY("Arrow Volley", false),
  TRIDENT("Trident Throw", false),
  MELEE_BURST("Brutal Swipe", false),
  CHARGE("Charge", false),
  SUMMON_FANGS("Evoker Fangs", false),
  HEX("Hex", false),
  LEVITATE("Levitate", true),
  LASER("Guardian Beam", false),
  WIND_CHARGE("Wind Burst", false),
  LEAP("Leap Slam", false),
  INK("Ink Cloud", false),
  SNOWBALL("Snowball Volley", false),
  SPIT("Spit", false),
  FLY_DASH("Aerial Dash", true),
  SLAM("Ground Slam", false),
  STAMPEDE("Stampede", false),
  FEATHER("Feather Volley", false),
  GUARD("Shell Guard", false),
  HEAL("Healing Burst", false),
  AQUATIC_DASH("Aquatic Dash", false),
  SNIFF("Sniff", false),
  TRADE("Emerald Toss", false),
  PASSIVE("No active ability", false);

  private final String displayName;
  private final boolean flight;

  IllusionAbilityFamily(String displayName, boolean flight) {
    this.displayName = displayName;
    this.flight = flight;
  }

  public String displayName() {
    return displayName;
  }

  public boolean canFly() {
    return flight;
  }

  public boolean isPassive() {
    return this == PASSIVE;
  }
}
