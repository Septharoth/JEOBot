package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class CharacterChantEvent extends Event {

    private final int uid;
    private final int spell;

    public CharacterChantEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.spell = reader.readShort();
    }

    public int getUID() {
        return this.uid;
    }

    public int getSpell() {
        return this.spell;
    }

    @Override
    public String toString() {
        return "CharacterChantEvent{" +
                "uid=" + uid +
                ", spell=" + spell +
                '}';
    }
}
