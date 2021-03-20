package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Character;

public class CharacterAppearEvent extends Event {

    private final Character character;

    public CharacterAppearEvent(EOReader reader) {
        reader.readBreakString();
        this.character = new Character(reader);
    }

    public Character getCharacter() {
        return this.character;
    }

    @Override
    public String toString() {
        return "CharacterAppearEvent{" +
                "character=" + character +
                '}';
    }
}
