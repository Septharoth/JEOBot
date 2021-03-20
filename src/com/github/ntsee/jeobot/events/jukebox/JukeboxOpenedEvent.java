package com.github.ntsee.jeobot.events.jukebox;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class JukeboxOpenedEvent extends Event {

    private final int map;
    private final String characterName;

    public JukeboxOpenedEvent(EOReader reader) {
        this.map = reader.readShort();
        this.characterName = reader.readEndString();
    }

    public int getMap() {
        return this.map;
    }

    public String getCharacterName() {
        return this.characterName;
    }

    @Override
    public String toString() {
        return "JukeboxOpenedEvent{" +
                "map=" + map +
                ", characterName='" + characterName + '\'' +
                '}';
    }
}
