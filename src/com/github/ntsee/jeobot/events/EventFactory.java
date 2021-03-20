package com.github.ntsee.jeobot.events;

import com.github.ntsee.jeobot.events.admin.AdminAppearEvent;
import com.github.ntsee.jeobot.events.admin.AdminDisappearEvent;
import com.github.ntsee.jeobot.events.character.*;
import com.github.ntsee.jeobot.events.connection.ConnectionHeartbeatEvent;
import com.github.ntsee.jeobot.events.init.InitEvent;
import com.github.ntsee.jeobot.events.item.*;
import com.github.ntsee.jeobot.events.jukebox.JukeboxFailedEvent;
import com.github.ntsee.jeobot.events.jukebox.JukeboxOpenedEvent;
import com.github.ntsee.jeobot.events.jukebox.JukeboxSuccessEvent;
import com.github.ntsee.jeobot.events.map.*;
import com.github.ntsee.jeobot.events.npc.NPCAppearEvent;
import com.github.ntsee.jeobot.events.npc.NPCAttackedEvent;
import com.github.ntsee.jeobot.events.npc.NPCBossKilledEvent;
import com.github.ntsee.jeobot.events.npc.NPCUpdateEvent;
import com.github.ntsee.jeobot.events.party.PartyDisbandedEvent;
import com.github.ntsee.jeobot.events.party.PartyExperienceEvent;
import com.github.ntsee.jeobot.events.player.*;
import com.github.ntsee.jeobot.events.talk.*;
import com.github.ntsee.jeobot.events.warp.WarpEvent;
import com.github.ntsee.jeobot.events.welcome.WelcomeEvent;
import com.github.ntsee.jeobot.io.EOAction;
import com.github.ntsee.jeobot.io.EOFamily;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public class EventFactory {

    private static EventFactory instance;

    private final Map<EOFamily, Map<EOAction, Function<EOReader, ? extends Event>>> functions;

    private EventFactory() {
        this.functions = new EnumMap<>(EOFamily.class);
        this.register(EOFamily.INIT, EOAction.INIT, InitEvent::fromReader);
        this.register(EOFamily.ACCOUNT, EOAction.REPLY, AccountEvent::new);
        this.register(EOFamily.LOGIN, EOAction.REPLY, LoginEvent::new);
        this.register(EOFamily.WELCOME, EOAction.REPLY, WelcomeEvent::fromReader);

        this.register(EOFamily.RECOVER, EOAction.PLAYER, PlayerRecoverEvent::new);
        this.register(EOFamily.RECOVER, EOAction.REPLY, PlayerLevelEvent::new);
        this.register(EOFamily.EFFECT, EOAction.SPEC, PlayerDrainedEvent::new);
        this.register(EOFamily.RECOVER, EOAction.LIST, PlayerStatsEvent::fromReaderClassStats);
        this.register(EOFamily.STAT_SKILL, EOAction.PLAYER, PlayerStatsEvent::fromReaderLevelStats);

        this.register(EOFamily.PLAYERS, EOAction.AGREE, CharacterAppearEvent::new);
        this.register(EOFamily.AVATAR, EOAction.REMOVE, CharacterDisappearEvent::new);
        this.register(EOFamily.CONNECTION, EOAction.PLAYER, ConnectionHeartbeatEvent::new);
        this.register(EOFamily.ATTACK, EOAction.PLAYER, CharacterAttackEvent::new);
        this.register(EOFamily.FACE, EOAction.PLAYER, CharacterFaceEvent::new);
        this.register(EOFamily.WALK, EOAction.PLAYER, CharacterWalkEvent::new);
        this.register(EOFamily.CHAIR, EOAction.PLAYER, CharacterSeatEvent::new);
        this.register(EOFamily.CHAIR, EOAction.CLOSE, CharacterStandEvent::new);
        this.register(EOFamily.SIT, EOAction.PLAYER, CharacterSitEvent::new);
        this.register(EOFamily.SIT, EOAction.CLOSE, CharacterStandEvent::new);
        this.register(EOFamily.SIT, EOAction.REMOVE, CharacterStandEvent::new);
        this.register(EOFamily.AVATAR, EOAction.AGREE, CharacterAvatarEvent::new);
        this.register(EOFamily.EMOTE, EOAction.PLAYER, CharacterEmoteEvent::new);
        this.register(EOFamily.EFFECT, EOAction.PLAYER, CharacterEffectEvent::new);
        this.register(EOFamily.EFFECT, EOAction.ADMIN, CharacterSpikeEvent::new);
        this.register(EOFamily.SPELL, EOAction.REQUEST, CharacterChantEvent::new);
        this.register(EOFamily.SPELL, EOAction.TARGET_SELF, CharacterSelfSpellEvent::new);
        this.register(EOFamily.SPELL, EOAction.TARGET_OTHER, CharacterOtherSpellEvent::new);
        this.register(EOFamily.SPELL, EOAction.TARGET_GROUP, CharacterGroupSpellEvent::new);

        this.register(EOFamily.ADMIN_INTERACT, EOAction.AGREE, AdminAppearEvent::new);
        this.register(EOFamily.ADMIN_INTERACT, EOAction.REMOVE, AdminDisappearEvent::new);

        this.register(EOFamily.ITEM, EOAction.ADD, ItemAppearEvent::new);
        this.register(EOFamily.ITEM, EOAction.DROP, ItemDroppedEvent::new);
        this.register(EOFamily.ITEM, EOAction.JUNK, ItemJunkedEvent::new);
        this.register(EOFamily.ITEM, EOAction.GET, ItemLootedEvent::new);
        this.register(EOFamily.ITEM, EOAction.KICK, ItemTakenEvent::new);
        this.register(EOFamily.ITEM, EOAction.OBTAIN, ItemGivenEvent::new);
        this.register(EOFamily.ITEM, EOAction.REMOVE, ItemDisappearEvent::new);
        this.register(EOFamily.WALK, EOAction.REPLY, PlayerWalkEvent::new);

        this.register(EOFamily.APPEAR, EOAction.REPLY, NPCAppearEvent::new);
        this.register(EOFamily.NPC, EOAction.PLAYER, NPCUpdateEvent::new);
        this.register(EOFamily.NPC, EOAction.REPLY, NPCAttackedEvent::fromReaderOnDamage);
        this.register(EOFamily.NPC, EOAction.SPEC, NPCAttackedEvent::fromReaderOnKilled);
        this.register(EOFamily.NPC, EOAction.ACCEPT, NPCAttackedEvent::fromReaderOnKilledLeveled);
        this.register(EOFamily.CAST, EOAction.REPLY, NPCAttackedEvent::fromReaderOnSpellDamage);
        this.register(EOFamily.CAST, EOAction.SPEC, NPCAttackedEvent::fromReaderOnSpellKilled);
        this.register(EOFamily.CAST, EOAction.ACCEPT, NPCAttackedEvent::fromReaderOnSpellKilledLevel);
        this.register(EOFamily.NPC, EOAction.JUNK, NPCBossKilledEvent::new);

        this.register(EOFamily.WARP, EOAction.REQUEST, WarpEvent::fromReader);
        this.register(EOFamily.WARP, EOAction.AGREE, MapEnterEvent::new);
        this.register(EOFamily.REFRESH, EOAction.REPLY, MapRefreshEvent::new);
        this.register(EOFamily.DOOR, EOAction.OPEN, MapDoorEvent::new);
        this.register(EOFamily.EFFECT, EOAction.REPORT, MapSpikeEvent::new);
        this.register(EOFamily.EFFECT, EOAction.AGREE, MapEffectEvent::new);
        this.register(EOFamily.EFFECT, EOAction.USE, MapQuakeEvent::new);
        this.register(EOFamily.EFFECT, EOAction.TARGET_OTHER, MapDrainEvent::new);

        this.register(EOFamily.TALK, EOAction.REQUEST, TalkGuildEvent::new);
        this.register(EOFamily.TALK, EOAction.OPEN, TalkPartyEvent::new);
        this.register(EOFamily.TALK, EOAction.MESSAGE, TalkGlobalEvent::new);
        this.register(EOFamily.TALK, EOAction.TELL, TalkPrivateEvent::new);
        this.register(EOFamily.TALK, EOAction.PLAYER, TalkLocalEvent::new);
        this.register(EOFamily.TALK, EOAction.ANNOUNCE, TalkAnnounceEvent::new);
        this.register(EOFamily.TALK, EOAction.SERVER, TalkServerEvent::new);


        this.register(EOFamily.PARTY, EOAction.TARGET_GROUP, PartyExperienceEvent::new);
        this.register(EOFamily.PARTY, EOAction.CLOSE, PartyDisbandedEvent::new);


        this.register(EOFamily.JUKEBOX, EOAction.OPEN, JukeboxOpenedEvent::new);
        this.register(EOFamily.JUKEBOX, EOAction.AGREE, JukeboxSuccessEvent::new);
        this.register(EOFamily.JUKEBOX, EOAction.USE, JukeboxFailedEvent::new);
        this.register(EOFamily.JUKEBOX, EOAction.MESSAGE, CharacterInstrumentEvent::new);
        this.register(EOFamily.MUSIC, EOAction.PLAYER, SoundEvent::new);
    }

    private void register(EOFamily family, EOAction action, Function<EOReader,Event> function) {
        if (!this.functions.containsKey(family)) {
            this.functions.put(family, new EnumMap<>(EOAction.class));
        }

        if (!this.functions.get(family).containsKey(action)) {
            this.functions.get(family).put(action, function);
        } else {
            throw new IllegalArgumentException(String.format("%s %s in use", family, action));
        }
    }

    public static Event fromReader(EOReader reader) {
        if (instance == null) {
            instance = new EventFactory();
        }

        if (instance.functions.containsKey(reader.getFamily())) {
            if (instance.functions.get(reader.getFamily()).containsKey(reader.getAction())) {
                return instance.functions.get(reader.getFamily()).get(reader.getAction()).apply(reader);
            }
        }

        return null;
    }
}