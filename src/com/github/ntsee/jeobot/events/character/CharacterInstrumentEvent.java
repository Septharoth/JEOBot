package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Direction;

public class CharacterInstrumentEvent extends Event {

    private final int uid;
    private final Direction direction;
    private final int instrument;
    private final int note;

    public CharacterInstrumentEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.direction = Direction.valueOf(reader.readChar());
        this.instrument = reader.readChar();
        this.note = reader.readChar();
    }

    public int getUID() {
        return this.uid;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getInstrument() {
        return this.instrument;
    }

    public int getNote() {
        return this.note;
    }

    @Override
    public String toString() {
        return "CharacterInstrumentEvent{" +
                "uid=" + uid +
                ", direction=" + direction +
                ", instrument=" + instrument +
                ", note=" + note +
                '}';
    }
}
