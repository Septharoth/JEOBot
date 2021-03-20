package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class CharacterEffectEvent extends Event {

    private final int uid;
    private final int effect;

    public CharacterEffectEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.effect = reader.readThree();
    }

    public int getUID() {
        return this.uid;
    }

    public int getEffect() {
        return this.effect;
    }

    @Override
    public String toString() {
        return "CharacterEffectEvent{" +
                "uid=" + uid +
                ", effect=" + effect +
                '}';
    }
}