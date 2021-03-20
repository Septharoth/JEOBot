package com.github.ntsee.jeobot.events;

import com.github.ntsee.jeobot.io.EOReader;

public class SoundEvent extends Event {

    private final int id;

    public SoundEvent(EOReader reader) {
        this.id = reader.readChar();
    }

    public int getID() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SoundEvent{" +
                "id=" + id +
                '}';
    }
}
