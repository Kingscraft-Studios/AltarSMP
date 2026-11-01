package net.kingscraft.zenixmc.altarsmp.messages;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;

import java.util.List;

public class SeasonTwoMessages {
    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    public static final List<Component> TIDE_BREAKER = List.of(
            text("<dark_gray>A Legendary Trident that channels the ocean within the wielder."),
            text("<gold>Sharpness <yellow>VII"),
            text("<gray>Looting III"),
            text("<gray>Sweeping Edge III"),
            Component.empty(),
            text("<white>Passive <gray>| Nautiluses gain <white>Resistance III <gray>& <white>Speed V <gray>while held."),
            text("<white>Passive <gray>| Gain permanent <white>Water Breathing <gray>while held."),
            Component.empty(),
            text("<aqua><bold>ꜱᴛᴏʀᴍᴄᴀʟʟ"),
            text("<dark_gray>⏱ <gray>40s <dark_aqua>▸ <dark_aqua>ᴏꜰꜰʜᴀɴᴅ"),
            text("<gray>Throw your Trident, summoning a Storm where it lands."),
            text("<gray>The storm damages two entities within a <white>6 block <gray>radius every <white>0.5s<gray>,"),
            text("<gray>always targeting the entities with the highest HP. Lasts <white>10s<gray>."),
            Component.empty(),
            text("<aqua><bold>ʀɪꜱɪɴɢ ᴛɪᴅᴇ"),
            text("<dark_gray>⏱ <gray>50s <dark_aqua>▸ <dark_aqua>ᴏꜰꜰʜᴀɴᴅ + ᴄʀᴏᴜᴄʜ"),
            text("<dark_aqua>Looking Up <gray>| Place a jet of water underneath yourself to blast"),
            text("<gray>up in the air, <white>breaking through webs <gray>in the process, followed by a"),
            text("<gray>tidal shockwave when landing, knocking enemies away."),
            text("<dark_aqua>Looking Down <gray>| Throw a long-lasting wave of water, which on hit,"),
            text("<gray>pulling players towards you on hit.")
    );

    public static List<Component> getAncientBladeLore(int kills) {
        var killsTag = Placeholder.parsed("kills", String.valueOf(kills));

        return List.of(
                text("<dark_gray>A Legendary sword carried by the Legendaries of the Deep Dark."),
                text("<red>Kills: <kills>", killsTag),
                Component.empty(),
                text("<gold>Sharpness <yellow>VII"),
                text("<gray>Looting III"),
                text("<gray>Sweeping Edge III"),
                Component.empty(),
                text("<aqua><bold>ᴅᴇᴇᴘ ᴄᴏɴɴᴇᴄᴛɪᴏɴ <gray>| <red>0 ᴋɪʟʟꜱ"),
                text("<gray>Gain <white>+25% Speed <gray>while standing on any Sculk block."),
                text("<dark_gray>Stacks with Speed Potions."),
                Component.empty(),
                text("<aqua><bold>ᴇᴄʜᴏʟᴏᴄᴀᴛɪᴏɴ <gray>| <red>1 ᴋɪʟʟ"),
                text("<dark_gray>⏱ <gray>3s <dark_aqua>▸ <dark_aqua>ᴄʀᴏᴜᴄʜ"),
                text("<gray>Crouch to listen for players. Players within <white>24 blocks"),
                text("<gray>of you will play a tendril sound at their location."),
                Component.empty(),
                text("<aqua><bold>ꜱʜɪꜰᴛ <gray>| <red>2 ᴋɪʟʟꜱ"),
                text("<gray>Gain <white>permanent Speed I <gray>while held."),
                Component.empty(),
                text("<aqua><bold>ᴘʀᴇꜱᴇɴᴄᴇ <gray>| <red>3 ᴋɪʟʟꜱ"),
                text("<dark_gray>⏱ <gray>45s <dark_aqua>▸ <dark_aqua>ᴏꜰꜰʜᴀɴᴅ"),
                text("<gray>After the shriek, you have <white>5s <gray>to hit a player."),
                text("<gray>Marked players receive <white>Darkness <gray>for <white>10s<gray>, and"),
                text("<gray>cannot have <white>Absorption<gray>."),
                Component.empty(),
                text("<aqua><bold>ᴛɪɢʜᴛᴇɴᴇᴅ ɢʀɪᴘ <gray>| <red>4 ᴋɪʟʟꜱ"),
                text("<gray>Gain <white>permanent Strength II <gray>while held."),
                Component.empty(),
                text("<aqua><bold>ᴜɴʏɪᴇʟᴅɪɴɢ ᴅᴀʀᴋɴᴇꜱꜱ <gray>| <red>5 ᴋɪʟʟꜱ"),
                text("<dark_gray>⏱ <gray>60s <dark_aqua>▸ <dark_aqua>ᴏꜰꜰʜᴀɴᴅ + ᴄʀᴏᴜᴄʜ"),
                text("<gray>Launch upward, pause, then throw a spinning <white>Sculk Catalyst<gray>."),
                text("<gray>On impact it spreads <white>Sculk <gray>and splits into"),
                text("<white>Sonic Boom <gray>bursts.")
        );
    }
    public static final List<Component> WITHER_SYMBIOTE = List.of(
            text("<gray>It's ready to latch on and take the shape of a weapon."),
            text("<gold>Sharpness <yellow>VII"),
            text("<gray>Looting III"),
            text("<gray>Sweeping Edge III"),
            Component.empty(),
            text("<white><bold>ꜱʏᴍʙɪᴏᴛᴇ ɪɴꜰᴇᴄᴛɪᴏɴ"),
            text("<dark_gray>⏱ <gray>40s <red>▸ <white>ᴏꜰꜰʜᴀɴᴅ"),
            text("<gray>Your next hit inflicts the target with an <white>infection"),
            text("<gray>which can they can also <white>pass <gray>to another target."),
            text("<gray>Once the infection ends, they get <white>damaged <gray>and <white>weakened."),
            text("<gray>The infection can be <white>remotely triggered <gray>to detonate."),
            Component.empty(),
            text("<white><bold>ꜱʏᴍʙɪᴏᴛᴇ ʀᴀᴍᴘᴀɢᴇ"),
            text("<dark_gray>⏱ <gray>120s <red>▸ <white>ᴏꜰꜰʜᴀɴᴅ + ᴄʀᴏᴜᴄʜ"),
            text("<gray>Go beyond the human's physical limit at the cost"),
            text("<gray>of <white>your own life<gray>. Rampage grants <white>multiple buffs,"),
            text("<gray>but needs to be <white>sustained <gray>by both <white>dealing damage <gray>and"),
            text("<white>not receiving damage<gray>, becoming <white>more difficult <gray>over time."),
            Component.empty(),
            text("<white>+ Increase your HP by 3"),
            text("<white>+ Heal your HP by 3"),
            text("<white>+ Instantly break nearby webs"),
            text("<white>+ 0.5 HP Lifesteal every hit"),
            text("<white>+ 50% Increased Speed"),
            text("<red>- You lose Saturation quicker."),
            text("<red>- You become Weak when exiting rampage."),
            text("<red>- You become Withered when exiting rampage."),
            text("<red>- Lose 3 HP when exiting rampage.")
    );

    public static final List<Component> OMEN = List.of(
            text("<dark_gray>A Legendary Spear imbued with the powers of the Trial Chambers."),
            text("<gold>Sharpness <yellow>VII"),
            text("<gray>Looting III"),
            Component.empty(),
            text("<dark_aqua><bold>ᴠᴀᴜʟᴛ ᴏᴍᴇɴ"),
            text("<dark_gray>⏱ <gray>35s <gold>▸ <gold>ᴏꜰꜰʜᴀɴᴅ"),
            text("<gray>Throw a Vault Omen where you look lasting <white>7s<gray>,"),
            text("<gray>tethering players who enter within a <white>3 block <gray>radius."),
            text("<gray>Players are <white>Tethered <gray>until Vault Omen expires."),
            Component.empty(),
            text("<dark_aqua><bold>ᴏᴍɪɴᴏᴜꜱ ᴄᴏɴᴊᴜʀɪɴɢ"),
            text("<dark_gray>⏱ <gray>50s <gold>▸ <gold>ᴏꜰꜰʜᴀɴᴅ + ᴄʀᴏᴜᴄʜ"),
            text("<gray>Power your spear with Trial Omen, making your melee attacks"),
            text("<gray>throw <white>Ominous Projectiles <gray>for <white>10s<gray>, dealing AOE damage."),
            text("<gray>Players within a <white>16 block <gray>radius of you contribute to your <white>Spell Level<gray>."),
            text("<gray>Spell Level stacks <white>special properties <gray>and increases <white>spell distance<gray>."),
            Component.empty(),
            text("<aqua>Lv.1 <dark_gray>(0-1 Players) <gray>| <white>Direct Hits <gray>grant <white>+50% Speed <gray>for <white>1s<gray>."),
            text("<aqua>Lv.2 <dark_gray>(2-4 Players) <gray>| <white>Ominous Pro. <gray>ignores shields."),
            text("<aqua>Lv.3 <dark_gray>(5+ Players) <gray>| <white>Direct Hits <gray>pull you towards target. <dark_gray>(Uncrouched)")
    );

    public static final List<Component> DRAGONREND = List.of(
            text("<dark_gray>A Legendary Sword made from the Ender Dragon's heart"),
            text("<gold>Sharpness VII"),
            text("<gray>Looting III"),
            text("<gray>Sweeping Edge III"),
            Component.empty(),
            text("<light_purple><bold>ʜʏᴘᴇʀsᴏɴɪᴄ sʟᴀsʜ"),
            text("<dark_gray>⌚ 40s <dark_purple>▹ ᴏғғʜᴀɴᴅ"),
            text("<gray>After a short delay, <white>swing <gray>your weapon while <white>looking"),
            text("<gray>at a player <gray>within <white>16 blocks <gray>to <white>instantly teleport"),
            text("<gray>and deal damage to them. You are able to do this <white>mutiple times,"),
            text("<gray>but the window to do comsecutive slashes is <white>halved each time."),
            Component.empty(),
            text("<light_purple><bold>ɪɴғɪɴɪᴛᴇ ᴠᴏɪᴅ"),
            text("<dark_gray>⌚ 60s <dark_purple>▹ ᴏғғʜᴀɴᴅ+ᴄʀᴏᴜᴄʜ"),
            text("<gray>Place down a <white>Void Clock <gray>where you stand, drastically <white>slowing"),
            text("<white>down <gray>time for players in a <white>6 block <gray> radius. Last <white>10s."),
            text("<dark_gray>(60s cooldown.)")
    );

    public static Component text(String text, TagResolver... resolvers) {
        return miniMessage.deserialize(text, resolvers);
    }
}
