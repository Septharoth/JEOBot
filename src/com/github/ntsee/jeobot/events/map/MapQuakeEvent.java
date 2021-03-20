package com.github.ntsee.jeobot.events.map;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class MapQuakeEvent extends Event {

    private final int strength;

    public MapQuakeEvent(EOReader reader) {
        reader.readChar();
        this.strength = reader.readChar();
    }

    public int getStrength() {
        return this.strength;
    }

    @Override
    public String toString() {
        return "MapQuakeEvent{" +
                "strength=" + strength +
                '}';
    }
}
