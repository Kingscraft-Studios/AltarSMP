package net.kingscraft.zenixmc.altarsmp.item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.kyori.adventure.text.Component;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import net.kingscraft.zenixmc.altarsmp.AltarSMP;

public enum CustomItem {
   COPPER_HELMET(
                        CustomItemRegistry.getCopperHelmet(),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Strength Amplifier")),
                           "copperHelmetStrengthAmplifier",
                           0.0F,
                           5.0F
                        )
                     ),
   COPPER_CHESTPLATE(
                        CustomItemRegistry.getCopperChestplate(),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Lightning Damage")),
                           "copperChestplateDamage",
                           1.0F,
                           20.0F
                        )
                     ),
   COPPER_LEGGINGS(
                        CustomItemRegistry.getCopperLeggings(),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Max Mace Fall Damage")),
                           "copperLeggingsMaxDamage",
                           1.0F,
                           120.0F
                        )
                     ),
   COPPER_BOOTS(
                        CustomItemRegistry.getCopperBoots()
                     ),
   COPPER_PICKAXE(
                        CustomItemRegistry.getCopperPickaxe()
                     ),
   PURE_BLADE(
                        CustomItemRegistry.getPureBlade(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Shade Soul Cooldown")),
                           "shadeSoulCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Shade Soul Damage")),
                           "shadeSoulDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Shade Soul Range")),
                           "shadeSoulRange",
                           1.0F,
                           100.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Cyclone Slash Cooldown")),
                           "cycloneSlashCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Cyclone Slash Damage")),
                           "cycloneSlashDamage",
                           1.0F,
                           50.0F
                        )
                     ),
   EARTH_GAUNTLET(
                        CustomItemRegistry.getEarthGauntlet(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Mudslide Cooldown")),
                           "EarthGauntletMudslide",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Muddied Duration")),
                           "muddiedDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Mud Max Distance")),
                           "mudMaxDistance",
                           1.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Mud Damage")),
                           "mudDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Meteor Strike Cooldown")),
                           "EarthGauntletMeteorStrike",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_STOPWATCH
                              .append(Component.text(" Meteor Use Duration")),
                           "meteorUseDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Meteor Damage")),
                           "meteorDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_EXPLOSION
                              .append(Component.text(" Meteor Knockback")),
                           "meteorStrikeKnockback",
                           1.0F,
                           20.0F
                        )
                     ),
   WITHERED_BONE_BLADE(
                        CustomItemRegistry.getWitheredBone(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Leap Cooldown")),
                           "WitherBoneleapCooldown",
                           1.0F,
                           120.0F
                        ),
                        steppedStat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Leap Horizontal Strength")),
                           "WitherBoneLeapHorizontalStrength",
                           0.1F,
                           10.0F,
                           0.1F
                        ),
                        steppedStat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Leap Vertical Strength")),
                           "WitherBoneLeapVerticalStrength",
                           0.1F,
                           10.0F,
                           0.1F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 50.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Cleansing Cooldown")),
                           "WitherBoneCleansingCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Cleansing Duration")),
                           "WitherBoneCleansingDuration",
                           1.0F,
                           30.0F
                        )
                     ),
   SHADOW_BLADE(
                        CustomItemRegistry.getShadowBlade(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Leap Cooldown")),
                           "ShadowBladeLeapCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Leap Distance")),
                           "ShadowBladeLeapDistance",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Leap Speed")),
                           "shadowBladeLeapSpeed",
                           1.0F,
                           10.0F
                        ),
                        toggle(
                           StatIcons.ICON_TOGGLE
                              .append(Component.text(" Stop On Block")),
                           "shadowLeapStopWhenTouchingBlocks"
                        ),
                        toggle(
                           StatIcons.ICON_TOGGLE
                              .append(Component.text(" Border Logic")),
                           "shadowBladeBorderLogic"
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Dagger Cooldown")),
                           "ShadowBladeDaggerCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Dagger Damage")),
                           "shadowDaggerDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Dagger Distance")),
                           "shadowDaggerDistance",
                           1.0F,
                           30.0F
                        )
                     ),
   CUTLASS(
                        CustomItemRegistry.getCutlass(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Parry Cooldown")),
                           "CutlassParryCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Parry Duration")),
                           "CutlassParryDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Cuts Cooldown")),
                           "CutlassCutsCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Cut Damage")),
                           "cutlassCutDamage",
                           1.0F,
                           50.0F
                        )
                     ),
   PALADIN_AXE(
                        CustomItemRegistry.getPaladinAxe(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Earth Shatter Cooldown")),
                           "paladinEarthShatterCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Earth Shatter Radius")),
                           "earthShatterRadius",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Earth Shatter Damage")),
                           "earthShatterDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Absorption Damage Reduction")),
                           "stalwartAbsorptionNerf",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Absorption Cooldown")),
                           "paladinStalwartAbsorptionCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Absorption Duration")),
                           "paladinStalwartAbsorptionDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Absorption Max Damage")),
                           "absorptionDamageLimit",
                           1.0F,
                           200.0F
                        )
                     ),
   WINDWEAVER(
                        CustomItemRegistry.getWindweaver(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Dash Cooldown")),
                           "windweaver.dashCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Dash Strength")),
                           "windweaver.dashStrength",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Speed Duration")),
                           "windweaver.speedAfterDashDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Gust Cooldown")),
                           "windweaver.gustCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Gust Strength")),
                           "windweaver.gustStrength",
                           1.0F,
                           10.0F
                        )
                     ),
   BONE_BLADE(
                        CustomItemRegistry.getBoneBlade(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Leap Cooldown")),
                           "skeletalLeapCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Leap Distance")),
                           "skeletalLeapDistance",
                           1.0F,
                           20.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Leap Damage")),
                           "skeletalLeapDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        toggle(
                           StatIcons.ICON_TOGGLE
                              .append(Component.text(" Stop Stunned Players From Attacking")),
                           "boneCageStopAttacking"
                        ),
                        toggle(
                           StatIcons.ICON_TOGGLE
                              .append(Component.text(" Stop Stunned Players From Interacting")),
                           "boneCageStopInteractions"
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Bone Cage Length")),
                           "boneCageLength",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Bone Cage Stun")),
                           "boneCageStunDuration",
                           1.0F,
                           20.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Bone Cage Cooldown")),
                           "boneCageCooldown",
                           1.0F,
                           120.0F
                        )
                     ),
   VULCAN_CROSSBOW(
                        CustomItemRegistry.getVulcanCrossbow(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Wrath Cooldown")),
                           "vulcansWrathCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Wrath Damage")),
                           "vulcansWrathDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Max Distance")),
                           "vulcanMaxDistance",
                           1.0F,
                           1000.0F
                        ),
                        stat(
                           StatIcons.ICON_PROJECTILE
                              .append(Component.text(" Power")),
                           "vulcanPower",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_EXPLOSION
                              .append(Component.text(" Explosion Radius")),
                           "vulcanExplosionRadius",
                           1.0F,
                           20.0F
                        ),
                        toggle(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Make Vulcan Wrath Magma Visual")),
                           "vulcanWrathVisual"
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Scattershot Damage")),
                           "vulcansScattershotDamage",
                           1.0F,
                           50.0F
                        )
                     ),
   BLOODLUST(
                        CustomItemRegistry.getBloodlust(
                           null, false
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Speed Level")),
                           "speedLevel",
                           0.0F,
                           5.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Strength Level")),
                           "strengthLevel",
                           0.0F,
                           5.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Track Range")),
                           "bloodlustTrackRange",
                           1.0F,
                           200.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Infection Duration")),
                           "infectionDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Infection Damage")),
                           "infectionDamage",
                           1.0F,
                           20.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        toggle(
                           StatIcons.ICON_TOGGLE
                              .append(Component.text(" Border Logic")),
                           "bloodlustBorderLogic"
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Blood Trail Cooldown")),
                           "bloodTrailCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Blood Trail Duration")),
                           "bloodTrailDuration",
                           0.0F,
                           60.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Hook Cooldown")),
                           "hookCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Hook Max Distance")),
                           "hookMaxDistance",
                           1.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Hook Damage")),
                           "hookDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Hook Pull Strength")),
                           "hookPullStrength",
                           1.0F,
                           10.0F
                        )
                     ),
   FROST_SCYTHE(
                        CustomItemRegistry.getFrostScythe(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Throw Cooldown")),
                           "scytheThrowCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Throw Damage")),
                           "scytheThrowDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Slowness Duration")),
                           "frostDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Max Distance")),
                           "scytheThrowMaxThrow",
                           1.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_PROJECTILE
                              .append(Component.text(" Throw Power")),
                           "scytheThrowPower",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_PROJECTILE
                              .append(Component.text(" Return Power")),
                           "scytheReturnPower",
                           1.0F,
                           10.0F
                        ),
                        toggle(
                           StatIcons.ICON_TOGGLE
                              .append(Component.text(" Scythe return logic")),
                           "scytheThrowReturnScythe"
                        ),
                        toggle(
                           StatIcons.ICON_TOGGLE
                              .append(Component.text(" Hold To Throw")),
                           "holdForThrowFrostScythe"
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Charge Duration")),
                           "frostScytheChargeDuration",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Ice Command Cooldown")),
                           "commandOfIceCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Ice Command Damage")),
                           "commandOfIceDamage",
                           1.0F,
                           50.0F
                        )
                     ),
   ILLUSION_WAND(
                        CustomItemRegistry.getIllusionWand(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Mob Ability Cooldown")),
                           "mobAbilityCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_EXPLOSION
                              .append(Component.text(" Creeper Explosion Strength")),
                           "illusionCreeperExplosionStrength",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Wand Charge Duration")),
                           "IllusionWandChargeDuration",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_PROJECTILE
                              .append(Component.text(" Blaze Fireball Strength")),
                           "IllusionBlazeFireballStrength",
                           1.0F,
                           10.0F
                        )
                     ),
   HYPERION(
                        CustomItemRegistry.getHyperion(),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Hollowed Flames Damage")),
                           "hollowedFlamesDamage",
                           1.0F,
                           10.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Scorching Cooldown")),
                           "scorchingCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Scorching Damage")),
                           "scorchingDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Holy Lance Cooldown")),
                           "holyLanceCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Holy Lance Damage")),
                           "holyLanceDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Holy Lance Radius")),
                           "holyLanceRadius",
                           1.0F,
                           10.0F
                        )
                     ),
   NIGHTPIERCER(
                        CustomItemRegistry.getNightpiercer(),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Transformation Duration")),
                           "transformationDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Transformation Cooldown")),
                           "transformationCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Transformation Speed")),
                           "transformationSpeed",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Transformation Damage")),
                           "transformationDamage",
                           1.0F,
                           20.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Crimson Use Duration")),
                           "crimsonUseDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Crimson Bite Duration")),
                           "crimsonBiteDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Crimson Bite Cooldown")),
                           "crimsonBiteCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Crimson Health Steal")),
                           "crimsonBiteHealthSteal",
                           1.0F,
                           20.0F
                        )
                     ),
   STRIKER(
                        CustomItemRegistry.getStrikerBow(),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Stabshot Radius")),
                           "stabShotRadius",
                           1.0F,
                           20.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Stabshot Radius Y")),
                           "stabShotRadiusY",
                           1.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Stabshot Damage")),
                           "stabShotDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Stabshot Cooldown")),
                           "stabShotCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_EXPLOSION
                              .append(Component.text(" Explosion Power")),
                           "stabShotExplosionPower",
                           1.0F,
                           10.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 10.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Orbital Shot Cooldown")),
                           "orbitalShotCooldown",
                           1.0F,
                           300.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Orbital Shot Radius")),
                           "orbitalShotRadius",
                           1.0F,
                           100.0F
                        ),
                        stat(
                           StatIcons.ICON_EXPLOSION
                              .append(Component.text(" Orbital Shot Explosion Power")),
                           "orbitalShotExplosionPower",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_PROJECTILE
                              .append(Component.text(" Orbital Shot Strikes")),
                           "orbitalShotStrikes",
                           1.0F,
                           100.0F
                        )
                     ),
   ECLIPSE(
                        CustomItemRegistry.getEclipse(),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" True Invis Duration")),
                           "EclipseTrueInvisDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" True Invis Cooldown")),
                           "EclipseTrueInvisCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 120.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Leap Cooldown")),
                           "EclipseLeapCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Leap Strength")),
                           "EclipseLeapStrength",
                           1.0F,
                           10.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Shooting Stars Range")),
                           "EclipseStarsRange",
                           1.0F,
                           100.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Shooting Stars Cooldown")),
                           "EclipseStarsCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Shooting Stars Damage")),
                           "eclipseMoonlitStarsDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Explosion Cooldown")),
                           "EclipseExplosionCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_EXPLOSION
                              .append(Component.text(" Explosion Strength")),
                           "EclipseExplosionStrength",
                           1.0F,
                           10.0F
                        )
                     ),
   PALE_CANNON(
                        CustomItemRegistry.getPaleCannon(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Cooldown")),
                           "palecannonCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Max Distance")),
                           "paleMaxDistance",
                           20.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_PROJECTILE
                              .append(Component.text(" Projectile Speed")),
                           "palePower",
                           1.0F,
                           5.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Damage")),
                           "paleDamage",
                           1.0F,
                           20.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Pale Roots Cooldown")),
                           "paleRootsCooldown",
                           10.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Pale Roots Count")),
                           "paleRootsCount",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Pale Roots Duration")),
                           "paleRootsDuration",
                           1.0F,
                           20.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Pale Roots Damage")),
                           "paleRootsDamage",
                           1.0F,
                           20.0F
                        ),
                        stat(
                           StatIcons.ICON_EXPLOSION
                              .append(Component.text(" Particle Area")),
                           "paleParticleEffects",
                           1.0F,
                           20.0F
                        )
                     ),
   ECHO(
                        CustomItemRegistry.getEcho(),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Shriek Duration")),
                           "echoShriekDuration",
                           1.0F,
                           60.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Sonic Blast Cooldown")),
                           "echoSonicBlastCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Sonic Blast Damage")),
                           "echoSonicDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Sonic Blast Distance")),
                           "echoSonicThrowMax",
                           1.0F,
                           100.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Sonic Blast Strength")),
                           "echoSonicThrowStrength",
                           1.0F,
                           10.0F
                        )
                     ),
   CRAZY_SLOTS(
                        CustomItemRegistry.getCrazySlots(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Cooldown")),
                           "crazySlotsCooldown",
                           1.0F,
                           300.0F
                        ),
                        stat(
                           StatIcons.ICON_STOPWATCH
                              .append(Component.text(" Duration")),
                           "crazySlotsDuration",
                           1.0F,
                           120.0F
                        )
                     ),
   KNIGHTFALL(
                        CustomItemRegistry.getKnightfall(
                           null, false
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Speed Amplifier")),
                           "KnightfallSpeedAmplifier",
                           0.0F,
                           5.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Damage Limit")),
                           "knightfallDamageLimit",
                           0.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Mace Cooldown")),
                           "knightfallCooldown",
                           0.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Cloak Chances")),
                           "cloakChances",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Cloak Duration")),
                           "cloakDuration",
                           1.0F,
                           30.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Grapple Cooldown")),
                           "grapplingHookCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Grapple Strength")),
                           "grapplingHookStrength",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Grapple Leap Strength")),
                           "grapplingHookLeapStrength",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Grapple Max Distance")),
                           "grapplingHookMaxDistance",
                           1.0F,
                           200.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Hammer Cooldown")),
                           "hammerThrowCooldown",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Hammer Damage")),
                           "hammerThrowDamage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Hammer Speed")),
                           "hammerThrowSpeed",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Hammer Max Distance")),
                           "hammerThrowMaxDistance",
                           1.0F,
                           200.0F
                        ),
                        toggle(
                           StatIcons.ICON_TOGGLE
                              .append(Component.text(" Hammer Stun Shield")),
                           "hammerThrowStunShield"
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Hammer Stun Duration")),
                           "hammerThrowStunShieldDuration",
                           1.0F,
                           30.0F
                        )
                     ),
   NUKE_REMOTE(
                        CustomItemRegistry.getNukeRemote(),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Cooldown")),
                           "nukeRemoteCooldownMinutes",
                           1.0F,
                           1200.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Damage")),
                           "nukeDamage",
                           1.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Radius")),
                           "nukeRadius",
                           1.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Duration")),
                           "nukeDuration",
                           1.0F,
                           120.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Announce Every")),
                           "nukeAnnounceEvery",
                           1.0F,
                           60.0F
                        )
                     ),

   TIDEBREAKER(
                        CustomItemRegistry.getTidebreaker(),
                        true,
                        2.25D,
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Stormcall Cooldown")),
                           "tidebreaker.stormcall_cooldown",
                           1.0F,
                           300.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Stormcall Duration")),
                           "tidebreaker.stormcall_duration",
                           1.0F,
                           60.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Stormcall Radius")),
                           "tidebreaker.stormcall_radius",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Stormcall Damage")),
                           "tidebreaker.stormcall_damage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_STOPWATCH
                              .append(Component.text(" Stormcall Interval")),
                           "tidebreaker.stormcall_interval",
                           1.0F,
                           100.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Stormcall Trident Gravity")),
                           "tidebreaker.stormcall_trident_gravity",
                           0.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Stormcall Throw Strength")),
                           "tidebreaker.stormcall_throw_strength",
                           1.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Stormcall Throw Max")),
                           "tidebreaker.stormcall_throw_max",
                           1.0F,
                           200.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_EXPLOSION
                              .append(Component.text(" Rising Tide Knockback")),
                           "tidebreaker.rising_tide_kb",
                           1.0F,
                           20.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Rising Tide Radius")),
                           "tidebreaker.rising_tide_radius",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Rising Tide Cooldown")),
                           "tidebreaker.rising_tide_cooldown",
                           1.0F,
                           300.0F
                        )
                     ),
   ANCIENTBLADE(
                        CustomItemRegistry.getAncientBlade(),
                        true,
                        2.25D,
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Unyielding Darkness Cooldown")),
                           "ancientblade.unyielding_darkness_cooldown",
                           1.0F,
                           600.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Unyielding Visual Radius")),
                           "ancientblade.unyielding_visual_radius",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Unyielding Damage Radius")),
                           "ancientblade.unyielding_damage_radius",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Unyielding Power")),
                           "ancientblade.unyielding_power",
                           0.0F,
                           20.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Presence Cooldown")),
                           "ancientblade.presence_cooldown",
                           1.0F,
                           300.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Presence Duration")),
                           "ancientblade.presence_duration",
                           1.0F,
                           120.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Echo Location Cooldown")),
                           "ancientblade.echo_location_cooldown",
                           1.0F,
                           300.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Echo Location Radius")),
                           "ancientblade.echo_location_radius",
                           1.0F,
                           100.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Strength Passive Amplifier")),
                           "ancientblade.strength_passive_amplifier",
                           0.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Speed Passive Amplifier")),
                           "ancientblade.speed_passive_amplifier",
                           0.0F,
                           10.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Speed Passive Sculk Amplifier")),
                           "ancientblade.speed_passive_standonsculk_amplifier",
                           0.0F,
                           10.0F
                        )
                     ) {
      @Override
      public ItemStack getItem(Player paramPlayer) {
         return CustomItemRegistry.getAncientBlade(paramPlayer);
      }
   },
   WITHERSYMBIOTE(
                        CustomItemRegistry.getWitherSymbiote(),
                        true,
                        2.25D,
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Infection Cooldown")),
                           "withersymbiote.infection_cooldown",
                           1.0F,
                           300.0F
                        ),
                        stat(
                           StatIcons.ICON_STOPWATCH
                              .append(Component.text(" Infection Timeout Detonate")),
                           "withersymbiote.infection_time_before_timeout_detonate",
                           1.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_STOPWATCH
                              .append(Component.text(" Infection Delay")),
                           "withersymbiote.infection_delay",
                           1.0F,
                           100.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Infection Detonate Damage")),
                           "withersymbiote.infection_detonate_damage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Infection Time To Infect")),
                           "withersymbiote.infection_time_to_infect",
                           1.0F,
                           60.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Rampage Cooldown")),
                           "withersymbiote.rampage_cooldown",
                           1.0F,
                           600.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Rampage Max Bars")),
                           "withersymbiote.rampage_max_bars",
                           1.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Rampage Start Bars")),
                           "withersymbiote.rampage_start_bars",
                           0.0F,
                           200.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Rampage Bars Gained From Hit")),
                           "withersymbiote.rampage_bars_gained_from_hit",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_STOPWATCH
                              .append(Component.text(" Rampage Bar Lose Interval")),
                           "withersymbiote.rampage_bar_lose_interval",
                           1.0F,
                           100.0F
                        ),
                        steppedStat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Rampage Speed Multiplier")),
                           "withersymbiote.rampage_speed_multiplier",
                           0.1F,
                           10.0F,
                           0.1F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Rampage Lifesteal HP")),
                           "withersymbiote.rampage_lifesteal_hp",
                           0.0F,
                           20.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Rampage Extra Health")),
                           "withersymbiote.rampage_extra_health",
                           0.0F,
                           40.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Rampage Hunger Amplifier")),
                           "withersymbiote.rampage_hunger_amp",
                           -1.0F,
                           5.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Rampage Negatives Duration")),
                           "withersymbiote.rampage_negatives_duration",
                           0.0F,
                           60.0F
                        )
                     ),
   OMEN(
                        CustomItemRegistry.getOmen(),
                        true,
                        2.5D,
                        stat(
                           StatIcons.ICON_STOPWATCH
                              .append(Component.text(" Vault Omen Length")),
                           "omen.vault_omen_length",
                           1.0F,
                           200.0F
                        ),
                        steppedStat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Vault Omen Gravity")),
                           "omen.vault_omen_gravity",
                           0.0F,
                           1.0F,
                           0.01F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Vault Omen Radius")),
                           "omen.vault_omen_radius",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Vault Omen Duration")),
                           "omen.vault_omen_duration",
                           1.0F,
                           60.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Vault Omen Cooldown")),
                           "omen.vault_omen_cooldown",
                           1.0F,
                           300.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Ominous Conjuring Duration")),
                           "omen.ominous_conjuring_duration",
                           1.0F,
                           60.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Ominous Conjuring Cooldown")),
                           "omen.ominous_conjuring_cooldown",
                           1.0F,
                           300.0F
                        ),
                        stat(
                           StatIcons.ICON_STOPWATCH
                              .append(Component.text(" Ominous Conjuring Length")),
                           "omen.ominous_conjuring_length",
                           1.0F,
                           200.0F
                        ),
                        steppedStat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Ominous Conjuring Gravity")),
                           "omen.ominous_conjuring_gravity",
                           0.0F,
                           1.0F,
                           0.01F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Ominous Conjuring Damage")),
                           "omen.ominous_conjuring_damage",
                           1.0F,
                           50.0F
                        ),
                        steppedStat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Ominous Conjuring Speed Duration")),
                           "omen.ominous_conjuring_speed_duration",
                           0.0F,
                           10.0F,
                           0.1F
                        ),
                        steppedStat(
                           StatIcons.ICON_STOPWATCH
                              .append(Component.text(" Ominous Conjuring Attack Cooldown")),
                           "omen.ominous_conjuring_attack_cooldown",
                           0.0F,
                           10.0F,
                           0.1F
                        )
                     ),
   DRAGONREND(
                        CustomItemRegistry.getDragonrend(),
                        true,
                        2.25D,
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Infinite Void Duration")),
                           "dragonrend.infinite_void_duration",
                           1.0F,
                           60.0F
                        ),
                        stat(
                           StatIcons.ICON_BOLT
                              .append(Component.text(" Infinite Void Slowness Strength")),
                           "dragonrend.infinite_void_slownewess_strength",
                           0.0F,
                           20.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Infinite Void Radius")),
                           "dragonrend.infinite_void_radius",
                           1.0F,
                           30.0F
                        ),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Infinite Void Cooldown")),
                           "dragonrend.infinite_void_cooldown",
                           1.0F,
                           600.0F
                        ),
                        stat(Component.empty(), "empty", 1.0F, 1.0F),
                        stat(
                           StatIcons.ICON_COOLDOWN
                              .append(Component.text(" Hypersonic Slash Cooldown")),
                           "dragonrend.hypersonic_slash_cooldown",
                           1.0F,
                           300.0F
                        ),
                        stat(
                           StatIcons.ICON_DAMAGE
                              .append(Component.text(" Hypersonic Slash Damage")),
                           "dragonrend.hypersonic-slash_damage",
                           1.0F,
                           50.0F
                        ),
                        stat(
                           StatIcons.ICON_SNOWFLAKE
                              .append(Component.text(" Hypersonic Slash Duration")),
                           "dragonrend.hypersonic_slash_duration",
                           1.0F,
                           60.0F
                        ),
                        stat(
                           StatIcons.ICON_DISTANCE
                              .append(Component.text(" Hypersonic Slash Range")),
                           "dragonrend.hypersonic_slash_range",
                           1.0F,
                           100.0F
                        )
                     );

   public final ItemStack itemStack;
   public final List<ItemStat> stats;
   public final boolean seasonTwo;
   public final double displayScale;
   public static final CustomItem[] VALUES;

   public static RangedStat stat(Component var0, String var1, float var2, float var3) {
      return new RangedStat(var0, var1, var2, var3);
   }

   public static ToggleStat toggle(Component var0, String var1) {
      return new ToggleStat(var0, var1);
   }

   public static SteppedStat steppedStat(Component var0, String var1, float var2, float var3, float var4) {
      return new SteppedStat(var0, var1, var2, var3, var4);
   }

   CustomItem(ItemStack var3, ItemStat... var4) {
      this(var3, false, 1.75D, var4);
   }

   CustomItem(ItemStack var3, boolean var5, double var6, ItemStat... var8) {
      this.itemStack = var3;
      this.stats = List.of(var8);
      this.seasonTwo = var5;
      this.displayScale = var6;
   }

   public ItemStack getItem() {
      return this.itemStack;
   }

   public ItemStack getItem(Player paramPlayer) {
      return this.itemStack;
   }

   public boolean isSeasonTwo() {
      return this.seasonTwo;
   }

   public List<ItemStat> getStats() {
      return this.stats;
   }

   public static CustomItem fromItem(ItemStack var0) {
      if (var0 == null) {
         return null;
      }

      for (CustomItem var4 : values()) {
         if (AltarSMP.areSimilar(var4.itemStack, var0)) {
            return var4;
         }
      }

      return null;
   }

   public static boolean isCustomItem(ItemStack var0) {
      CustomItem var1 = fromItem(var0);
      return var1 != null;
   }

   public static int countInInventory(Player var0) {
      int var1 = 0;

      for (ItemStack var5 : var0.getInventory().getContents()) {
         if (isCustomItem(var5)) {
            var1++;
         }
      }

      if (isCustomItem(var0.getInventory().getItemInOffHand())) {
         var1++;
      }

      return var1;
   }

    public static List<ItemStack> getRollingDropItems() {
        Set<String> var0 = new HashSet<>(AltarSMP.getInstance().getConfig().getStringList("weapons_that_can_be_obtained_from_rolling"));
        List<ItemStack> var1 = new ArrayList<>();

        for (CustomItem var5 : values()) {
            if (var0.contains(var5.name())) {
                var1.add(var5.getItem());
            }
        }

        return var1;
    }

   public static CustomItem[] cachedValues() {
      return new CustomItem[]{
         COPPER_HELMET,
         COPPER_CHESTPLATE,
         COPPER_LEGGINGS,
         COPPER_BOOTS,
         COPPER_PICKAXE,
         PURE_BLADE,
         EARTH_GAUNTLET,
         WITHERED_BONE_BLADE,
         SHADOW_BLADE,
         CUTLASS,
         PALADIN_AXE,
         WINDWEAVER,
         BONE_BLADE,
         VULCAN_CROSSBOW,
         BLOODLUST,
         FROST_SCYTHE,
         ILLUSION_WAND,
         HYPERION,
         NIGHTPIERCER,
         STRIKER,
         ECLIPSE,
         PALE_CANNON,
         ECHO,
         CRAZY_SLOTS,
         KNIGHTFALL,
         NUKE_REMOTE,
         TIDEBREAKER,
         ANCIENTBLADE,
         WITHERSYMBIOTE,
         OMEN,
         DRAGONREND
      };
   }
   static {
      VALUES = cachedValues();
   }

}
