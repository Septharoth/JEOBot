package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Emote;

public class CharacterEmoteEvent extends Event {

    private final int uid;
    private final Emote emote;

    public CharacterEmoteEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.emote = Emote.valueOf(reader.readChar());
    }

    public int getUID() {
        return this.uid;
    }

    public Emote getEmote() {
        return this.emote;
    }

    @Override
    public String toString() {
        return "CharacterEmoteEvent{" +
                "uid=" + uid +
                ", emote=" + emote +
                '}';
    }
}
