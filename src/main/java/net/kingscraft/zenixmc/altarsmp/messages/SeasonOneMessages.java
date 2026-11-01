package net.kingscraft.zenixmc.altarsmp.messages;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

import java.util.List;

public class SeasonOneMessages {
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    public static final List<Component> ECLIPSE = List.of(
            text("<gray>---<yellow> [ <#FFBE45><bold>ᴅᴀʏᴛɪᴍᴇ</bold></#FFBE45><yellow> ] </yellow>---"),
            text("<#FFBE45><bold>ꜱᴏʟᴀʀ ɪɴꜰᴇʀɴᴏ</bold>"),
            text("<#E9C37C><bold>(<#E9C37C>ᴏ<#E9C37C>ꜰ<#E9C37C>ꜰ<#E6BE6D>ʜ<#E3BA5F>ᴀ<#DFB550>ɴ<#DCB142>ᴅ<#D9AC33>)</bold>"),
            text("<gray>After a short delay, release a burst"),
            text("<gray>of solar energy around yourself."),
            text("<dark_gray>40s cooldown."),
            Component.space(),
            text("<#FFBE45><bold>ꜱᴏʟᴀʀ ʟᴇᴀᴘ</bold>"),
            text("<#E9C37C><bold>(<#E9C37C>ᴄ<#E9C37C>ʀ<#E9C37C>ᴏ<#E9C37C>ᴜ<#E9C37C>ᴄ<#E9C37C>ʜ<#E7C074>+<#E5BE6C>ᴏ<#E4BB64>ꜰ<#E2B95C>ꜰ<#E0B653>ʜ<#DEB44B>ᴀ<#DDB143>ɴ<#DBAF3B>ᴅ<#D9AC33>)</bold>"),
            text("<gray>A blazing leap that is powered by"),
            text("<gray>solar flares"),
            text("<dark_gray>15-30s Cooldown. "),
            Component.space(),
            text("<gray>---<dark_gray>[ <white><bold>ɴɪɢʜᴛᴛɪᴍᴇ</bold></white> </dark_gray>]<gray>---"),
            text("<white><bold>ᴍᴏᴏɴʟɪᴛ ꜱᴛᴀʀꜱ</bold>"),
            text("<#929292><bold>(<#A0A0A0>ᴏ<#ADADAD>ꜰ<#BBBBBB>ꜰ<#C9C9C9>ʜ<#D6D6D6>ᴀ<#E4E4E4>ɴ<#F1F1F1>ᴅ<#FFFFFF>)</bold>"),
            text("<gray>Throw a barrage of stars that follow the"),
            text("<gray>direction your looking, exploding on contact. "),
            text("<dark_gray>40s Cooldown."),
            Component.empty(),
            text("<white><bold>ᴍᴏᴏɴʟɪᴛ ꜱʜᴀᴅᴏᴡꜱ</bold></white><dark_gray>]</dark_gray><gray>-</gray>"),
            text("<#929292><bold>(<#999999>ᴄ<#A1A1A1>ʀ<#A8A8A8>ᴏ<#AFAFAF>ᴜ<#B6B6B6>ᴄ<#BEBEBE>ʜ<#C5C5C5>+<#CCCCCC>ᴏ<#D3D3D3>ꜰ<#DBDBDB>ꜰ<#E2E2E2>ʜ<#E9E9E9>ᴀ<#F0F0F0>ɴ<#F8F8F8>ᴅ<#FFFFFF>)</bold>"),
            text("<gray>Cloak yourself in the shadows, giving yourself"),
            text("<white>True Invisibility <gray>for <white>4 seconds."),
            text("<dark_gray>30s Cooldown")
    );

    public static List<Component> getKnightfallLore(int kills) {
        var killsTag = Placeholder.parsed("kills", String.valueOf(kills));

        return List.of(
                text("<dark_gray>The Moon Shines Bright On a Dark Knight."),
                text("<red>Kills: <kills>", killsTag), // Dynamically replaces <kills>
                Component.space(),
                text("<white><bold>ᴄʟᴏᴀᴋ</bold> <#C4F5FF><bold>[0 Kills]</bold>"),
                text("<gray>10% chance to gain <white>True Invisibility"),
                text("<gray>for <white>3 seconds on hit."),
                Component.space(),
                text("<white><bold>ᴡɪɴᴅ ʙᴜʀꜱᴛ</bold> <#C4F5FF><bold>[2 Kills]</bold>"),
                text("<gray>Allows the Hammer to be enchanted"),
                text("<gray>with Wind Burst."),
                Component.space(),
                text("<white><bold>ɢʀᴀᴘᴘʟɪɴɢ ʜᴏᴏᴋ</bold> <#C4F5FF><bold>[4 Kills]</bold>"),
                text("<#929292><bold>(<#A0A0A0>ᴏ<#ADADAD>ꜰ<#BBBBBB>ꜰ<#C9C9C9>ʜ<#D6D6D6>ᴀ<#E4E4E4>ɴ<#F1F1F1>ᴅ<#FFFFFF>)</bold>"),
                text("<gray>Hook onto a block and pull yourself"),
                text("<gray>towards it. Reaching the end of the chain "),
                text("<gray>in time makes you leap "),
                text("<dark_gray>x3 10s Cooldown. "),
                Component.space(),
                text("<white><bold>ꜱᴘᴇᴇᴅ 2</bold> <#C4F5FF><bold>[6 Kills]</bold>"),
                text("<gray>Grants the holder permanent Speed II. "),
                text("<gray>while holding the hammer"),
                Component.space(),
                text("<white><bold>ᴅᴇɴꜱɪᴛʏ / ʙʀᴇᴀᴄʜ</bold> <#C4F5FF><bold>[8 Kills]</bold>"),
                text("<gray>Allows the Hammer to be enchanted"),
                text("<gray>with either Density or Breach."),
                Component.space(),
                text("<white><bold>ʜᴀᴍᴍᴇʀ ᴛʜʀᴏᴡ</bold> <#C4F5FF><bold>[10 Kills]</bold>"),
                text("<#929292><bold>(<#999999>ᴄ<#A1A1A1>ʀ<#A8A8A8>ᴏ<#AFAFAF>ᴜ<#B6B6B6>ᴄ<#BEBEBE>ʜ<#C5C5C5>+<#CCCCCC>ᴏ<#D3D3D3>ꜰ<#DBDBDB>ꜰ<#E2E2E2>ʜ<#E9E9E9>ᴀ<#F0F0F0>ɴ<#F8F8F8>ᴅ<#FFFFFF>)</bold>"),
                text("<gray>Throw your Hammer in the direction"),
                text("<gray>you are looking, dealing massive damage"),
                text("<gray>and pulling the enemy towards you."),
                text("<dark_gray>30s Cooldown.")
        );
    }

    public static final List<Component> NUKE_REMOTE = List.of(
            text("<#F8A100><bold>ɴ</bold><#F9A91B><bold>ᴜ</bold><#FBB236><bold>ᴋ</bold><#FCBA50><bold>ᴇ</bold></#FCBA50> <#FFCB86><bold>ꜱ</bold><#FFBF6B><bold>ᴛ</bold><#FFB450><bold>ʀ</bold><#FFA836><bold>ɪ</bold><#FF9D1B><bold>ᴋ</bold><#FF9100><bold>ᴇ</bold>"),
            text("<#F8A100><bold>(</bold><#FAAC22><bold>ᴏ</bold><#FCB643><bold>ꜰ</bold><#FDC165><bold>ꜰ</bold><#FFCB86><bold>ʜ</bold><#FFBD65><bold>ᴀ</bold><#FFAE43><bold>ɴ</bold><#FFA022><bold>ᴅ</bold><#FF9100><bold>)</bold>"),
            text("<#FFCB86>Nuke a 25x25 area 1 shotting any player inside it"),
            text("<dark_gray>(30m cooldown.)")
    );

    public static final List<Component> STRIKER = List.of(
            text("<dark_gray>A bow that was forged from tnt and has"),
            text("<dark_gray>the powers of the Orbital Strike Cannon"),
            text("<#AE0E00><bold>(ᴏꜰꜰʜᴀɴᴅ) to change the ability"),
            text("<#AE0E00><bold>(ꜱʜᴏᴏᴛ) use your ability"),
            Component.empty(),
            text("<#D00000><bold>ꜱ</bold><#D91818><bold>ᴛ</bold><#E33030><bold>ᴀ</bold><#EC4848><bold>ʙ</bold> <#FF7878><bold>ꜱ</bold><#F25A5A><bold>ʜ</bold><#E53C3C><bold>ᴏ</bold><#D81E1E><bold>ᴛ</bold>"),
            text("<#FF1500>Pierces the earths surface with an insane."),
            text("<#FF1500>amount of tnt."),
            text("<dark_gray>60s cooldown."),
            Component.empty(),
            text("<#AB0E00><bold>ᴏ</bold><#C00B00><bold>ʀ</bold><#D50700><bold>ʙ</bold><#EA0400><bold>ɪᴛᴀʟ</bold> <#E10000><bold>ꜱ</bold><#C30000><bold>ʜ</bold><#A40000><bold>ᴏ</bold><#860000><bold>ᴛ</bold>"),
            text("<#FF1500>Summons a nuke that was born"),
            text("<#FF1500>from the orbital strike cannon"),
            text("<dark_gray>120s cooldown.")
    );

    public static final List<Component> WEAPON_HANDLE = List.of(
            text("<gray>Used to forge Mythical Weapons")
    );

    public static final List<Component> VULCANS_SKULL = List.of(
            text("<gray>Used to forge Vulcan's Crossbow")
    );

    public static final List<Component> ILLUSION_CORE = List.of(
            text("<gray>Used to forge the Illusion Wand")
    );

    public static final List<Component> COPPER_HELMET = List.of(
            text("<aqua>Copper Vision: <white>Hold Shift to grant players Glowing."),
            text("<dark_aqua>Infinite Water Breathing")
    );

    public static final List<Component> COPPER_CHESTPLATE = List.of(
            Component.empty(),
            text("<yellow>Static Shock<white>: Upon attacking players, a ring"),
            text("<white>of Lightning will occur every 7 Hits."),
            Component.empty(),
            text("<aqua>Lightning Immunity"),
            text("<gray>Infinite Resistance")
    );

    public static final List<Component> COPPER_LEGGINGS = List.of(
            Component.empty(),
            text("<red>Shockwave<white>: Falling from Heights creates"),
            text("<white>a Shockwave (Works like a Mace)"),
            Component.empty(),
            text("<aqua>Fall Damage Immunity")
    );

    public static final List<Component> COPPER_BOOTS = List.of(
            text("<aqua>Blazing Trail<white>: Run at Superspeed"),
            text("<yellow>Static Shock<white>: Running on Copper allows"),
            text("<white>you to run faster")
    );

    public static final List<Component> COPPER_PICKAXE = List.of(
            Component.empty(),
            text("<dark_gray>A copper pickaxe with custom properties..."),
            Component.empty(),
            text("<yellow>[Offhand] <gray>To toggle 3x3 mining.")
    );

    public static final List<Component> BONE_BLADE = List.of(
            text("<dark_gray>A blade made from the oldest"),
            text("<dark_gray>bones known to mankind."),
            text("<dark_gray>Some say the bones are still alive"),
            Component.empty(),
            text("<#EACE8E><bold>ꜱ</bold><#EED6A1><bold>ᴋ</bold><#F1DEB4><bold>ᴇ</bold><#F5E7C7><bold>ʟ</bold><#F8EFD9><bold>ᴇ</bold><#FCF7EC><bold>ᴛ</bold><#FFFFFF><bold>ᴀ</bold><#FCF7EC><bold>ʟ</bold> <#F5E7C7><bold>ʟ</bold><#F1DEB4><bold>ᴇ</bold><#EED6A1><bold>ᴀ</bold><#EACE8E><bold>ᴘ</bold>"),
            text("<#FCE5B3>Leap in the direction your looking."),
            text("<#FCE5B3>The leap is powered by dead bones that roam still."),
            text("<dark_gray>(30s cooldown.)"),
            Component.empty(),
            text("<#EACE8E><bold>ʙ</bold><#EFDAAA><bold>ᴏ</bold><#F5E7C7><bold>ɴ</bold><#FAF3E3><bold>ᴇ</bold> <#FAF3E3><bold>ᴄ</bold><#F5E7C7><bold>ᴀ</bold><#EFDAAA><bold>ɢ</bold><#EACE8E><bold>ᴇ</bold>"),
            text("<#FCE5B3>Summons bones of the dead that trap any player"),
            text("<#FCE5B3>they interact with."),
            text("<#FCE5B3>Traps players for a short amount of time that is very powerful."),
            text("<dark_gray>(60s cooldown.)")
    );

    public static final List<Component> VULCAN_CROSSBOW = List.of(
            text("<dark_gray>The Legendary crossbow of Vulcan."),
            text("<dark_gray>All arrows inserted in it seem to gain"),
            text("<dark_gray>Flaming propreties."),
            Component.empty(),
            text("<#FF1F00><bold>ᴠ</bold><#FF3910><bold>ᴜ</bold><#FF5321><bold>ʟ</bold><#FF6D31><bold>ᴄ</bold><#FF8741><bold>ᴀ</bold><#FFA152><bold>ɴ</bold><#FFBB62><bold>ꜱ</bold> <#FF8741><bold>ᴡ</bold><#FF6D31><bold>ʀ</bold><#FF5321><bold>ᴀ</bold><#FF3910><bold>ᴛ</bold><#FF1F00><bold>ʜ</bold>"),
            text("<#FF8043>Fires a fireball capable of killing anyone."),
            text("<#FF8043>If aimed correctly, does insane amounts of damage."),
            text("<dark_gray>(45s cooldown.)"),
            Component.empty(),
            text("<#FF1F00><bold>ꜱ</bold><#FF3E14><bold>ᴄ</bold><#FF5D27><bold>ᴀ</bold><#FF7D3B><bold>ᴛ</bold><#FF9C4E><bold>ᴛ</bold><#FFBB62><bold>ᴇ</bold><#FF9C4E><bold>ʀ</bold><#FF7D3B><bold>ꜱ</bold><#FF5D27><bold>ʜ</bold><#FF3E14><bold>ᴏ</bold><#FF1F00><bold>ᴛ</bold>"),
            text("<#FF8043>Each shot shoots 3 arrows."),
            text("<#FF8043>The middle arrow of each shot inflicts fire on the enemy."),
            text("<#FF8043>Can do 3-4 hearts a hit.")
    );

    public static final List<Component> BLOODLUST = List.of(
            text("<#BC001F>A sᴡᴏʀᴅ mᴀᴅᴇ tᴏ mᴀᴋᴇ sᴏᴍᴇᴏɴᴇ a oɴᴇ mᴀɴ aʀᴍʏ"),
            text("<#C42E47><bold>(ꜱʜɪꜰᴛ+ʟᴍʙ) ᴛᴏ ᴄʜᴇᴄᴋ ᴋɪʟʟ ᴄᴏᴜɴᴛ"),
            Component.empty(),
            text("<#BC001F><bold>ɪ</bold><#CD0F2E><bold>ɴ</bold><#DE1E3E><bold>ꜰ</bold><#EE2D4D><bold>ᴇ</bold><#FF3C5C><bold>ᴄ</bold><#EE2D4D><bold>ᴛ</bold><#DE1E3E><bold>ɪ</bold><#CD0F2E><bold>ᴏ</bold><#BC001F><bold>ɴ</bold> <#FF002A>(0+ Kills)"),
            text("<#FFCF65><bold>(ᴘᴀꜱꜱɪᴠᴇ)"),
            text("<#BC001F>Every hit has 15% chance to bleed an enemy."),
            text("<dark_gray>15 second cooldown."),
            Component.empty(),
            text("<#BC001F><bold>ꜱ</bold><#CD0F2E><bold>ᴘ</bold><#DE1E3E><bold>ᴇ</bold><#EE2D4D><bold>ᴇ</bold><#FF3C5C><bold>ᴅ</bold> <#D21433><bold>I</bold><#BC001F><bold>I</bold> <#FF002A>(1+ Kills)"),
            text("<#FFCF65><bold>(ᴘᴀꜱꜱɪᴠᴇ)"),
            text("<#BC001F>Gain permanent Speed II when"),
            text("<#BC001F>holding the <#FF0000><bold>Bloodlust."),
            Component.empty(),
            text("<#BC001F><bold>ʙ</bold><#C70A29><bold>ʟ</bold><#D21433><bold>ᴏ</bold><#DE1E3E><bold>ᴏ</bold><#E92848><bold>ᴅ</bold> <#FF3C5C><bold>ᴛ</bold><#F43252><bold>ʀ</bold><#E92848><bold>ᴀ</bold><#DE1E3E><bold>ᴄ</bold><#D21433><bold>ᴋ</bold><#C70A29><bold>ᴇ</bold><#BC001F><bold>ʀ</bold> <#FF002A>(2+ Kills)"),
            text("<#FFCF65><bold>(ᴘᴀꜱꜱɪᴠᴇ)"),
            text("<#BC001F>Track the blood of nearby players"),
            text("<#BC001F>when holding <#FF0000><bold>Bloodlust."),
            text("<#BC001F>But only you can see the particles."),
            Component.empty(),
            text("<#BC001F><bold>ʙ</bold><#C90C2B><bold>ʟ</bold><#D71837><bold>ᴏ</bold><#E42444><bold>ᴏ</bold><#F23050><bold>ᴅ</bold> <#F23050><bold>ᴛ</bold><#E42444><bold>ʀ</bold><#D71837><bold>ᴀ</bold><#C90C2B><bold>ɪ</bold><#BC001F><bold>ʟ</bold> <#FF002A>(3+ Kills)"),
            text("<#FFCF65><bold>(ᴄʀᴏᴜᴄʜ+ᴏꜰꜰʜᴀɴᴅ)"),
            text("<#BC001F>Submerge yourself in puddle of blood."),
            text("<dark_gray>(1 minute cooldown.)"),
            Component.empty(),
            text("<#BC001F><bold>ꜱ</bold><#C90C2B><bold>ᴛ</bold><#D71837><bold>ʀ</bold><#E42444><bold>ᴇ</bold><#F23050><bold>ɴ</bold><#FF3C5C><bold>ɢ</bold><#EE2D4D><bold>ᴛ</bold><#DE1E3E><bold>ʜ</bold> <#BC001F><bold>I</bold> <#FF002A>(4+ Kills)"),
            text("<#FFCF65><bold>(ᴘᴀꜱꜱɪᴠᴇ)"),
            text("<#BC001F>Gain permanent Strength I while holding"),
            Component.empty(),
            text("<#BC001F><bold>ʙ</bold><#CD0F2E><bold>ʟ</bold><#DE1E3E><bold>ᴏ</bold><#EE2D4D><bold>ᴏ</bold><#FF3C5C><bold>ᴅ</bold><#EE2D4D><bold>ʜ</bold><#DE1E3E><bold>ᴏ</bold><#CD0F2E><bold>ᴏ</bold><#BC001F><bold>ᴋ</bold> <#FF002A>(5+ Kills)"),
            text("<#FFCF65><bold>(ᴏꜰꜰʜᴀɴᴅ)"),
            text("<#BC001F>Throw a blood chain in front of you,"),
            text("<#BC001F>pulling anything it touches towards you."),
            text("<dark_gray>(30 second cooldown.)")
    );

    public static final List<Component> FROST_SCYTHE = List.of(
            text("<dark_gray>An ancient scythe used to harvest"),
            text("<dark_gray>seas of ice. The scythe is cool"),
            text("<dark_gray>the touch."),
            Component.empty(),
            text("<#8CDAFF><bold>ꜱ</bold><#9FE0FF><bold>ᴄ</bold><#B2E6FF><bold>ʏ</bold><#C6EDFF><bold>ᴛ</bold><#D9F3FF><bold>ʜ</bold><#ECF9FF><bold>ᴇ</bold> <#E8F8FF><bold>ᴛ</bold><#D1F0FF><bold>ʜ</bold><#BAE9FF><bold>ʀ</bold><#A3E1FF><bold>ᴏ</bold><#8CDAFF><bold>ᴡ</bold>"),
            text("<#D5F2FF><bold>(ᴏꜰꜰʜᴀɴᴅ)"),
            text("<#8CDAFF>Throw the scythe in the direction you are looking."),
            text("<#8CDAFF>Deals 4 hearts and can be extremely deadly."),
            text("<dark_gray>(30s cooldown.)"),
            Component.empty(),
            text("<#8CDAFF><bold>ᴄ</bold><#9CDFFF><bold>ᴏ</bold><#ADE5FF><bold>ᴍ</bold><#BDEAFF><bold>ᴍ</bold><#CEEEFF><bold>ᴀ</bold><#DEF4FF><bold>ɴ</bold><#EFFAFF><bold>ᴅ</bold> <#ECF9FF><bold>ᴏ</bold><#D9F3FF><bold>ꜰ</bold> <#B2E6FF><bold>ɪ</bold><#9FE0FF><bold>ᴄ</bold><#8CDAFF><bold>ᴇ</bold>"),
            text("<#D5F2FF><bold>(ᴄʀᴏᴜᴄʜ+ᴏꜰꜰʜᴀɴᴅ)"),
            text("<#8CDAFF>Summon ice blocks above your head"),
            text("<#8CDAFF>and fire where ever you are looking"),
            text("<dark_gray>(45s cooldown.)")
    );

    public static final List<Component> ILLUSION_WAND = List.of(
            text("<dark_gray>Kill a mob with the wand to capture it,"),
            text("<dark_gray>or kill a player to capture their name"),
            text("<dark_gray>and skin."),
            text("<dark_gray>Captured mobs are kept in the wand."),
            Component.empty(),
            text("<#FFD371><bold>Holding Right-Click"),
            text("<#FFD371>Disguises you as the mob/player that is currently"),
            text("<#FFD371>stored in the wand."),
            Component.empty(),
            text("<#FFD371><bold>Health"),
            text("<#FFD371>25% of the mob's real health."),
            text("<#FFD371>Minimum 10 hearts, maximum 50 hearts."),
            text("<#FFD371>That is the only stat that changes."),
            Component.empty(),
            text("<#FFD371><bold>[ᴏꜰꜰʜᴀɴᴅ] while disguised"),
            text("<#FFD371>Uses the mob's active ability."),
            text("<#FFD371>10 second cooldown."),
            Component.empty(),
            text("<#FFD371><bold>Passives"),
            text("<#FFD371>Fire resistance, water breathing, night vision,"),
            text("<#FFD371>jump boost, resistance, regeneration and more."),
            Component.empty(),
            text("<#FFD371><bold>Shift-Left-Clicking"),
            text("<#FFD371>Removes your disguise, returning you"),
            text("<#FFD371>back to normal."),
            Component.empty(),
            text("<#FF0000><bold>On Mob Kill"),
            text("<#FF0000>Stores the mob's health pool, passives and ability"),
            text("<#FF0000>in the wand."),
            Component.empty(),
            text("<#FF0000><bold>On Player Kill"),
            text("<#FF0000>Stores the name and skin of the player"),
            text("<#FF0000>in the wand, making you look identical"),
            text("<#FF0000>to the player you killed when disguising.")
    );

    public static final List<Component> CRAZY_SLOTS = List.of(
            text("<gray>Right-Click to transform into a random legendary weapon!"),
            text("<dark_gray>Transforms for 30 seconds"),
            text("<dark_gray>60s cooldown")
    );

    public static final List<Component> HYPERION = List.of(
            text("<gray>You are immune to fire when holding Hyperion."),
            text("<gray>Your abilities inflict <white>Hallowed Flames <gray>on non-humans."),
            Component.empty(),
            text("<dark_gray>Do not go gentle into that good night."),
            text("<dark_gray>Rage, rage against the dying of the light."),
            Component.empty(),
            text("<#FF9000><bold>ʜ</bold><#FFA633><bold>ᴏ</bold><#FFBC66><bold>ʟ</bold><#FFD399><bold>ʏ</bold> <#FFFFFF><bold>ʟ</bold><#FDEABF><bold>ᴀ</bold><#FAD480><bold>ɴ</bold><#F8BF40><bold>ᴄ</bold><#F5A900><bold>ᴇ</bold>"),
            text("<#FFD77E><bold>(ᴏꜰꜰʜᴀɴᴅ)"),
            text("<#FFC545>Summon a powerful beam of light where you look,"),
            text("<#FFC545>dealing a large amount of damage."),
            text("<dark_gray>(1m Cooldown.)"),
            Component.empty(),
            text("<#FF9000><bold>ꜱ</bold><#FFAC40><bold>ᴄ</bold><#FFC880><bold>ᴏ</bold><#FFE3BF><bold>ʀ</bold><#FFFFFF><bold>ᴄ</bold><#FDEABF><bold>ʜ</bold><#FAD480><bold>ɪ</bold><#F8BF40><bold>ɴ</bold><#F5A900><bold>ɢ</bold>"),
            text("<#FFD77E><bold>(ᴄʀᴏᴜᴄʜ+ᴏꜰꜰʜᴀɴᴅ)"),
            text("<#FFC545>Power your next swing with holy fire,"),
            text("<#FFC545>launching a blade of flames towards your enemy."),
            text("<dark_gray>(30s Cooldown.)")
    );

    public static final List<Component> NIGHTPIERCER = List.of(
            text("<gray>You gain <white>Regeneration I <gray>during nighttime while"),
            text("<gray>holding Nightpiercer."),
            Component.empty(),
            text("<dark_gray>Vampiri sunt praedatores noctis ultimi."),
            Component.empty(),
            text("<#D90000><bold>ᴄ</bold><#DC0606><bold>ʀ</bold><#E00D0D><bold>ɪ</bold><#E31313><bold>ᴍ</bold><#E71919><bold>ꜱ</bold><#EA1F1F><bold>ᴏ</bold><#EE2626><bold>ɴ</bold> <#F53232><bold>ʙ</bold><#F83838><bold>ɪ</bold><#FC3F3F><bold>ᴛ</bold><#FF4545><bold>ᴇ</bold>"),
            text("<#FF0000><bold>(ᴏꜰꜰʜᴀɴᴅ)"),
            text("<#FF0053>Slash your sword at an enemy which takes off"),
            text("<#FF0053>two hearts.The duration last for 10s."),
            text("<dark_gray>(1m cooldown.)"),
            Component.empty(),
            text("<#D90000><bold>ᴛ</bold><#DC0505><bold>ʀ</bold><#DF0B0B><bold>ᴀ</bold><#E21010><bold>ɴ</bold><#E51515><bold>ꜱ</bold><#E81B1B><bold>ꜰ</bold><#EB2020><bold>ᴏ</bold><#ED2525><bold>ʀ</bold><#F02A2A><bold>ᴍ</bold><#F33030><bold>ᴀ</bold><#F63535><bold>ᴛ</bold><#F93A3A><bold>ɪ</bold><#FC4040><bold>ᴏ</bold><#FF4545><bold>ɴ</bold>"),
            text("<#FF0000><bold>(ᴄʀᴏᴜᴄʜ+ᴏꜰꜰʜᴀɴᴅ)"),
            text("<#FF0053>Transform into a swarm of bats,"),
            text("<#FF0053>you fly in the direction you are looking."),
            text("<dark_gray>(30s Cooldown.)")
    );

    public static final List<Component> PURE_BLADE = List.of(
            text("<white>Made from pure light energy,"),
            text("<white>has fragments of dark energy aswell."),
            Component.empty(),
            text("<#929292><bold>ꜱ</bold><#9C9E9E><bold>ʜ</bold><#A7AAAA><bold>ᴀ</bold><#B1B6B6><bold>ᴅ</bold><#BBC2C2><bold>ᴇ</bold> <#D0DBDA><bold>ꜱ</bold><#DAE7E6><bold>ᴏ</bold><#E5F3F2><bold>ᴜ</bold><#EFFFFE><bold>ʟ</bold>"),
            text("<#98BCA9><bold>(<#9EC4B3><bold>ᴏ</bold><#A3CDBE><bold>ꜰ</bold><#A9D5C8><bold>ꜰ</bold><#AFDED2><bold>ʜ</bold><#B4E6DC><bold>ᴀ</bold><#BAEEE7><bold>ɴ</bold><#BFF7F1><bold>ᴅ</bold><#C5FFFB><bold>)</bold>"),
            text("<white>Release a beam made out of dark"),
            text("<white>and light energy combined..."),
            text("<white>Hit enemies will receive Glowing and <#AD7AE9>Slowness II <white>for 5s."),
            text("<dark_gray>(45s cooldown.)"),
            Component.empty(),
            text("<#929292><bold>ᴄ</bold><#999A9A><bold>ʏ</bold><#A0A3A3><bold>ᴄ</bold><#A7ABAB><bold>ʟ</bold><#AFB4B3><bold>ᴏ</bold><#B6BCBC><bold>ɴ</bold><#BDC4C4><bold>ᴇ</bold> <#CBD5D4><bold>ꜱ</bold><#D2DDD5><bold>ʟ</bold><#DAE6E5><bold>ᴀ</bold><#E1EEE7><bold>ꜱ</bold><#E8F7F6><bold>ʜ</bold>"),
            text("<#98BCA9><bold>(<#9BC0AE><bold>ᴄ</bold><#9EC4B3><bold>ʜ</bold><#A0C9B8><bold>ʀ</bold><#A3CDBE><bold>ᴏ</bold><#A6D1C3><bold>ᴜ</bold><#A9D5C8><bold>ᴄ</bold><#ACD9CD><bold>ʜ</bold><#AFDED2><bold>+</bold><#B1E2D7><bold>ᴏ</bold><#B4E6DC><bold>ꜰ</bold><#B7EBE1><bold>ꜰ</bold><#BAEEE7><bold>ʜ</bold><#BDF3EC><bold>ᴀ</bold><#BFF7F1><bold>ɴ</bold><#C2FBF6><bold>ᴅ</bold><#C5FFFB><bold>)</bold>"),
            text("<white>Turn into a Cyclone that damages people arround you."),
            text("<white>pierce through cobewbs and"),
            text("<white>gaining immense <#00FFB7>Speed."),
            text("<dark_gray>(30s cooldown).")
    );

    public static final List<Component> EARTH_GAUNTLET = List.of(
            text("<#FFC455>A clay-like gauntlet with a gem in the center"),
            Component.empty(),
            text("<#E9B17C><bold>ᴍ</bold><#E9B17C><bold>ᴇ</bold><#E9B17C><bold>ᴛ</bold><#E9B17C><bold>ᴇ</bold><#E9B17C><bold>ᴏ</bold><#E9B17C><bold>ʀ</bold> <#E4A867><bold>ꜱ</bold><#E2A35D><bold>ᴛ</bold><#E09F52><bold>ʀ</bold><#DE9A48><bold>ɪ</bold><#DB963D><bold>ᴋ</bold><#D99133><bold>ᴇ</bold>"),
            text("<#E9C37C><bold>(<#E9C37C>ᴏ<#E9C37C>ꜰ<#E9C37C>ꜰ<#E6BE6D>ʜ<#E3BA5F>ᴀ<#DFB550>ɴ<#DCB142>ᴅ<#D9AC33>)</bold>"),
            text("<#FFDD9E>Charge your next hit with extra damage."),
            text("<#FFDD9E>Deals insane knockback."),
            text("<dark_gray>(30s cooldown.)"),
            Component.empty(),
            text("<#E9B17C><bold>ʟ</bold><#E9B17C><bold>ᴀ</bold><#E9B17C><bold>ɴ</bold><#E9B17C><bold>ᴅ</bold><#E6AB6D><bold>ꜱ</bold><#E3A45F><bold>ʟ</bold><#DF9E50><bold>ɪ</bold><#DC9742><bold>ᴅ</bold><#D99133><bold>ᴇ</bold>"),
            text("<#E9C37C><bold>(<#E9C37C>ᴄ<#E9C37C>ʀ<#E9C37C>ᴏ<#E9C37C>ᴜ<#E9C37C>ᴄ<#E9C37C>ʜ<#E7C074>+<#E5BE6C>ᴏ<#E4BB64>ꜰ<#E2B95C>ꜰ<#E0B653>ʜ<#DEB44B>ᴀ<#DDB143>ɴ<#DBAF3B>ᴅ<#D9AC33>)</bold>"),
            text("<#FFDD9E>Throw mud in the direction you are looking."),
            text("<#FFDD9E>When you hit someone You have the choice to either,"),
            text("<#FFDD9E>pull them towards you,or let them take"),
            text("<#FFDD9E>the debuffs of the mud."),
            text("<dark_gray>(18s cooldown.)")
    );

    public static final List<Component> WITHERED_BONE = List.of(
            text("<#484848>It has returned..."),
            text("<#484848>But it's not the same as before..."),
            Component.empty(),
            text("<#242424><bold>ᴡ</bold><#282828><bold>ɪ</bold><#2B2B2B><bold>ᴛ</bold><#2F2F2F><bold>ʜ</bold><#383838><bold>ᴇ</bold><#414141><bold>ʀ</bold> <#535353><bold>ʟ</bold><#555555><bold>ᴇ</bold><#565656><bold>ᴀ</bold><#585858><bold>ᴘ</bold>"),
            text("<#221E22><bold>(<#272227><bold>ᴏ</bold><#2D262C><bold>ꜰ</bold><#322A31><bold>ꜰ</bold><#3D323C><bold>ʜ</bold><#483A47><bold>ᴀ</bold><#4F3E4F><bold>ɴ</bold><#554158><bold>ᴅ</bold><#5C4560><bold>)</bold>"),
            text("<#97859B>Gain the ability to leap in a direction"),
            text("<#97859B>up to three times."),
            text("<#97859B>If dashed into enemies,inflict withering upon them."),
            text("<dark_gray>(10s cooldown.)"),
            Component.empty(),
            text("<#242424><bold>ᴡ</bold><#262626><bold>ɪ</bold><#282828><bold>ᴛ</bold><#2B2B2B><bold>ʜ</bold><#2D2D2D><bold>ᴇ</bold><#2F2F2F><bold>ʀ</bold> <#3D3D3D><bold>ᴄ</bold><#454545><bold>ʟ</bold><#4C4C4C><bold>ᴇ</bold><#535353><bold>ᴀ</bold><#545454><bold>ɴ</bold><#555555><bold>ꜱ</bold><#565656><bold>ɪ</bold><#575757><bold>ɴ</bold><#585858><bold>ɢ</bold>"),
            text("<#221E22><bold>(<#252025><bold>ᴄ</bold><#282328><bold>ʀ</bold><#2C252B><bold>ᴏ</bold><#2F282E><bold>ᴜ</bold><#322A31><bold>ᴄ</bold><#362D35><bold>ʜ</bold><#3B303A><bold>+</bold><#3F343E><bold>ᴏ</bold><#443743><bold>ꜰ</bold><#483A47><bold>ꜰ</bold><#4C3C4C><bold>ʜ</bold><#503E51><bold>ᴀ</bold><#544156><bold>ɴ</bold><#58435B><bold>ᴅ</bold><#5C4560><bold>)</bold>"),
            text("<#97859B>Release wither sludge that on contact"),
            text("<#97859B>inflicts withering."),
            text("<#97859B>The wither sludge only harms"),
            text("<#97859B>enemies and mobs that are dangerous."),
            text("<#97859B>Can deal massive damage if done correctly"),
            text("<dark_gray>(30s cooldown.)")
    );

    public static final List<Component> SHADOW_BLADE = List.of(
            text("<#343434>A <#333333>b<#323232>l<#313131>a<#303030>d<#303030>e <#2E2E2E>m<#2D2D2D>a<#2D2D2D>d<#2C2C2C>e <#2A2A2A>o<#2A2A2A>u<#292929>t <#272727>o<#272727>f <#262626>t<#262626>h<#262626>e <#262626>a<#262626>b<#262626>s<#262626>e<#262626>n<#262626>c<#262626>e <#262626>o<#262626>f <#262626>l<#262626>i<#262626>g<#262626>h<#262626>t."),
            text("<#343434>E<#333333>v<#333333>e<#323232>n <#313131>f<#303030>o<#2F2F2F>r <#2E2E2E>a <#2C2C2C>s<#2C2C2C>h<#2B2B2B>a<#2A2A2A>d<#2A2A2A>o<#292929>w<#282828>, <#272727>i<#262626>t <#262626>l<#262626>o<#262626>o<#262626>k<#262626>s <#262626>e<#262626>x<#262626>t<#262626>r<#262626>e<#262626>m<#262626>e<#262626>l<#262626>y <#262626>s<#262626>h<#262626>a<#262626>r<#262626>p."),
            Component.empty(),
            text("<#535360><bold>ꜱ</bold><#5A5C6A><bold>ʜ</bold><#626473><bold>ᴀ</bold><#696D7D><bold>ᴅ</bold><#707686><bold>ᴏ</bold><#787E90><bold>ᴡ</bold> <#7F8799><bold>ᴅ</bold><#7F8799><bold>ᴀ</bold><#7F8799><bold>ɢ</bold><#7F8799><bold>ɢ</bold><#7F8799><bold>ᴇ</bold><#7F8799><bold>ʀ</bold><#7F8799><bold>ꜱ</bold>"),
            text("<#535360><bold>(<#5E606E><bold>ᴏ</bold><#696D7D><bold>ꜰ</bold><#747A8B><bold>ꜰ</bold><#7F8799><bold>ʜ</bold><#7F8799><bold>ᴀ</bold><#7F8799><bold>ɴ</bold><#7F8799><bold>ᴅ</bold><#7F8799><bold>)</bold>"),
            text("<#7F8799>Throw three shadow daggers"),
            text("<#7F8799>that inflict <#AD7AE9>Slowness and Blindness."),
            text("<#7F8799>Deals insane damage if aimed correctly."),
            Component.empty(),
            text("<#4D5866><bold>ꜱ</bold><#515D6C><bold>ʜ</bold><#556271><bold>ᴀ</bold><#586777><bold>ᴅ</bold><#5C6C7D><bold>ᴏ</bold><#607283><bold>ᴡ</bold> <#687C8E><bold>ʟ</bold><#6B8194><bold>ᴇ</bold><#6F8699><bold>ᴀ</bold><#738B9F><bold>ᴘ</bold>"),
            text("<#3C424A><bold>(<#424850><bold>ᴄ</bold><#484E55><bold>ʀ</bold><#4E545B><bold>ᴏ</bold><#545A61><bold>ᴜ</bold><#5A6066><bold>ᴄ</bold><#60666C><bold>ʜ</bold><#666C72><bold>+</bold><#6C7177><bold>ᴏ</bold><#72777D><bold>ꜰ</bold><#787D83><bold>ꜰ</bold><#7E8388><bold>ʜ</bold><#84898E><bold>ᴀ</bold><#8A8F94><bold>ɴ</bold><#909599><bold>ᴅ</bold><#969B9F><bold>)</bold>"),
            text("<#7F8799>Use the shadows to teleport across the skys."),
            text("<#7F8799>Rightclick mid teleport to teleport early."),
            Component.empty(),
            text("<#3C424A><bold>ᴘ</bold><#464E57><bold>ᴀ</bold><#515A64><bold>ꜱ</bold><#5B6671><bold>ꜱ</bold><#65717D><bold>ɪ</bold><#6F7D8A><bold>ᴠ</bold><#7A8997><bold>ᴇ</bold><#8495A4><bold>ꜱ</bold>"),
            text("<gray>- When backstabbing, you have a <white>30% <gray>chance to pull enemies"),
            text("<gray>- When held, gain permanent <#00FFB7>Speed II")
    );

    public static final List<Component> CUTLASS = List.of(
            text("<gray>A Legendary cutlass that hones your swordfighting"),
            text("<gray>abilities to a masterful degree."),
            Component.empty(),
            text("<#90BFFF><bold>ᴛ</bold><#98C4FF><bold>ʜ</bold><#A0C8FF><bold>ᴏ</bold><#A8CDFF><bold>ᴜ</bold><#AF32FF><bold>ꜱ</bold><#B7D6FF><bold>ᴀ</bold><#BFDBFF><bold>ɴ</bold><#C7E0FF><bold>ᴅ</bold> <#D7E9FF><bold>ᴄ</bold><#DEEEFF><bold>ᴜ</bold><#E6F2FF><bold>ᴛ</bold><#EEF7FF><bold>ꜱ</bold>"),
            text("<#6691CB><bold>(<#799FD2><bold>ᴏ</bold><#8CADD8><bold>ꜰ</bold><#9FBADF><bold>ꜰ</bold><#B3C8E5><bold>ʜ</bold><#C6D6EC><bold>ᴀ</bold><#D9E4F2><bold>ɴ</bold><#ECF1F9><bold>ᴅ</bold><#FFFFFF><bold>)</bold>"),
            text("<#92B8FF>Release multiple slashes dealing immense damage."),
            text("<#92B8FF>After the slashes are done, lunge forward in the direction you are looking."),
            text("<#92B8FF>On hit apply <#AD7AE9>Slowness II <#92B8FF>to the target for 3s."),
            text("<dark_gray>(15s cooldown.)"),
            Component.empty(),
            text("<#90BFFF><bold>ᴘ</bold><#A8CDFF><bold>ᴀ</bold><#BFDBFF><bold>ʀ</bold><#D7E9FF><bold>ʀ</bold><#EEF7FF><bold>ʏ</bold>"),
            text("<#6691CB><bold>(<#7098CE><bold>ᴄ</bold><#7AA0D2><bold>ʀ</bold><#85A7D5><bold>ᴏ</bold><#8FAED9><bold>ᴜ</bold><#99B6DC><bold>ᴄ</bold><#A3BDE0><bold>ʜ</bold><#ADC4E3><bold>+</bold><#B8CCE7><bold>ᴏ</bold><#C2D3EA><bold>ꜰ</bold><#CCDAEE><bold>ꜰ</bold><#D6E2F1><bold>ʜ</bold><#E0E9F5><bold>ᴀ</bold><#EBF0F8><bold>ɴ</bold><#F5F8FC><bold>ᴅ</bold><#FFFFFF><bold>)</bold>"),
            text("<#92B8FF>Once activated, block the next 3 hits that are applied."),
            text("<#92B8FF>The ability can last up to 7 seconds"),
            text("<#92B8FF>but during this state, you are slightly slowed down."),
            text("<dark_gray>(30s cooldown.)")
    );

    public static final List<Component> PALADIN_AXE = List.of(
            text("<gray>A magical battle axe made for someone"),
            text("<gray>with an indomitable fighting spirit."),
            Component.empty(),
            text("<dark_gray><italic>\"Never quench thy flame, noble one.\""),
            Component.empty(),
            text("<#D9A74B><bold>ᴇ</bold><#D9A74B><bold>ᴀ</bold><#D9A74B><bold>ʀ</bold><#D9A74B><bold>ᴛ</bold><#D9A74B><bold>ʜ</bold><#D9A74B><bold>ꜱ</bold><#DFB157><bold>ʜ</bold><#E6BB63><bold>ᴀ</bold><#ECC56F><bold>ᴛ</bold><#F2CE7A><bold>ᴛ</bold><#F9D886><bold>ᴇ</bold><#FFE292><bold>ʀ</bold>"),
            text("<#FFE0A7><bold>(<#FFE0A7><bold>ᴏ</bold><#FFE0A7><bold>ꜰ</bold><#FFE0A7><bold>ꜰ</bold><#FFE0A3><bold>ʜ</bold><#FFE19F><bold>ᴀ</bold><#FFE19A><bold>ɴ</bold><#FFE296><bold>ᴅ</bold><#FFE292><bold>)</bold>"),
            text("<#FFCF00>Summon a huge hologram of your axe."),
            text("<#FFCF00>Creates a strong shockwave which deals"),
            text("<#FFCF00>insane damage to people."),
            text("<dark_gray>(45s cooldown.)"),
            Component.empty(),
            text("<#D9A74B><bold>ꜱ</bold><#D9A74B><bold>ᴛ</bold><#D9A74B><bold>ᴀ</bold><#D9A74B><bold>ʟ</bold><#D9A74B><bold>ᴡ</bold><#D9A74B><bold>ᴀ</bold><#D9A74B><bold>ʀ</bold><#D9A74B><bold>ᴛ</bold> <#E0B258><bold>ᴀ</bold><#E3B75E><bold>ʙ</bold><#E7BC65><bold>ꜱ</bold><#EAC26B><bold>ᴏ</bold><#EEC772><bold>ʀ</bold><#F1CD78><bold>ᴘ</bold><#F5D27F><bold>ᴛ</bold><#F8D785><bold>ɪ</bold><#FCDD8C><bold>ᴏ</bold><#FFE292><bold>ɴ</bold>"),
            text("<#FFE0A7><bold>(<#FFE0A7><bold>ᴄ</bold><#FFE0A7><bold>ʀ</bold><#FFE0A7><bold>ᴏ</bold><#FFE0A7><bold>ᴜ</bold><#FFE0A7><bold>ᴄ</bold><#FFE0A7><bold>ʜ</bold><#FFE0A5><bold>+</bold><#FFE0A2><bold>ᴏ</bold><#FFE1A0><bold>ꜰ</bold><#FFE19E><bold>ꜰ</bold><#FFE19B><bold>ʜ</bold><#FFE199><bold>ᴀ</bold><#FFE297><bold>ɴ</bold><#FFE294><bold>ᴅ</bold><#FFE292><bold>)</bold>"),
            text("<#FFCF00>For five seconds, absorb all incoming damage."),
            text("<#FFCF00>Reflect all damage that is inflicted to nearby players."),
            text("<#FFCF00>Gain resistance while activated."),
            text("<dark_gray>(45s cooldown.)")
    );

    public static final List<Component> WINDWEAVER = List.of(
            text("<dark_gray>Forged from clouds themselves."),
            Component.empty(),
            text("<#60F1DF><bold>ᴡ</bold><#60F1DF><bold>ɪ</bold><#60F1DF><bold>ɴ</bold><#60F1DF><bold>ᴅ</bold> <#67E8DD><bold>ʟ</bold><#6DDFD1><bold>ᴇ</bold><#74D5D9><bold>ᴀ</bold><#7ACCD7><bold>ᴘ</bold>"),
            text("<#9FFFF3><bold>(<#9FFFF3><bold>ᴏ</bold><#9FFFF3><bold>ꜰ</bold><#9FFFF3><bold>ꜰ</bold><#9FFFF3><bold>ʜ</bold><#96F2EC><bold>ᴀ</bold><#8DE6E5><bold>ɴ</bold><#83D9DE><bold>ᴅ</bold><#7ACCD7><bold>)</bold>"),
            text("<#BCFFFF>Leap in the direction you´re looking."),
            text("<#BCFFFF>Briefly gain <#00FFB7>Speed IV"),
            text("<dark_gray>(15s cooldown.)"),
            Component.empty(),
            text("<#60F1DF><bold>ᴡ</bold><#60F1DF><bold>ɪ</bold><#60F1DF><bold>ɴ</bold><#60F1DF><bold>ᴅ</bold><#60F1DF><bold>ɢ</bold><#69E5DC><bold>ᴜ</bold><#71D8DA><bold>ꜱ</bold><#7ACCD7><bold>ᴛ</bold>"),
            text("<#9FFFF3><bold>(<#9FFFF3><bold>ᴄ</bold><#9FFFF3><bold>ʀ</bold><#9FFFF3><bold>ᴏ</bold><#9FFFF3><bold>ᴜ</bold><#9FFFF3><bold>ᴄ</bold><#9FFFF3><bold>ʜ</bold><#9FFFF3><bold>+</bold><#9AF8EF><bold>ᴏ</bold><#94F0EB><bold>ꜰ</bold><#8FE9E7><bold>ꜰ</bold><#8AE2E3><bold>ʜ</bold><#85DBDF><bold>ᴀ</bold><#7FD3DB><bold>ɴ</bold><#7ACCD7><bold>ᴅ</bold><#7ACCD7><bold>)</bold>"),
            text("<#BCFFFF>Hold crouch to charge a powerful"),
            text("<#BCFFFF>knockback burst. The longer you stay"),
            text("<#BCFFFF>crouched, the more powerful it gets."),
            text("<dark_gray>(15s-30s cooldown.)")
    );

    public static final List<Component> PALE_CANNON = List.of(
            text("<#8D8D8D>Found in the pale mansion."),
            text("<#8D8D8D>Forgotten to time."),
            Component.empty(),
            text("<#FF6700><bold>(ꜱʜᴏᴏᴛ)"),
            text("<#FFA845>Shoots resin which releases Pale Rot"),
            Component.empty(),
            text("<#9A9999><bold>ᴘ</bold><#A4928A><bold>ᴀ</bold><#AE8A7B><bold>ʟ</bold><#B8836C><bold>ᴇ</bold> <#CC744E><bold>ʀ</bold><#C07D61><bold>ᴏ</bold><#B38774><bold>ᴏ</bold><#A79086><bold>ᴛ</bold><#9A9999><bold>ꜱ</bold>"),
            text("<#FF6700><bold>(ᴏꜰꜰʜᴀɴᴅ)"),
            text("<#FFA845>Send pale roots that follow your the direction you aim dealing ")
    );

    public static final List<Component> ECHO = List.of(
            text("<dark_gray>A forgotten artifact from the Ancient Cities."),
            Component.empty(),
            text("<#00A9A8><bold>ꜱᴏɴɪᴄ ʙʟᴀꜱᴛ"),
            text("<#00FFB6><bold>(<#28FFB8><bold>ᴏ</bold><#50FFBA><bold>ꜰ</bold><#77FFBB><bold>ꜰ</bold><#9FFFFD><bold>ʜ</bold><#7FF9B3><bold>ᴀ</bold><#5EF2A9><bold>ɴ</bold><#3EEC9E><bold>ᴅ</bold><#1DE594><bold>)</bold>"),
            Component.empty(),
            text("<#00FFB6>After a short delay, throw your weapon"),
            text("<#00FFB6>where you look, destroying the environment"),
            text("<#00FFB6>and damaging players. Pierces through blocks."),
            text("<dark_gray>(40s cooldown.)"),
            Component.empty(),
            text("<#00A9A8><bold>ᴇᴄʜᴏ ꜱʜʀɪᴇᴋ"),
            text("<#00FFB6><bold>(<#14FFB7><bold>ᴄ</bold><#28FFB8><bold>ʀ</bold><#3CFFB9><bold>ᴏ</bold><#50FFBA><bold>ᴜ</bold><#63FFBA><bold>ᴄ</bold><#77FFBB><bold>ʜ</bold><#8BFFBC><bold>+</bold><#9FFFFD><bold>ᴏ</bold><#8FFCB8><bold>ꜰ</bold><#7FF9B3><bold>ꜰ</bold><#6EF5AE><bold>ʜ</bold><#5EF2A9><bold>ᴀ</bold><#4EEFA3><bold>ɴ</bold><#3EEC9E><bold>ᴅ</bold><#2DE899><bold>)</bold>"),
            Component.empty(),
            text("<#00FFB6>Release a powerful shriek, giving players"),
            text("<#00FFB6>Slowness & Darkness in a 7 block radius,"),
            text("<#00FFB6>and Revealing Players in a 16 block radius.")
    );

    public static Component text(String text, TagResolver... resolvers) {
        return miniMessage.deserialize(text, resolvers);
    }
}
