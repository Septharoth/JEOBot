package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class CharacterStandEvent extends Event {

    private final int uid;
    private final int x;
    private final int y;

    public CharacterStandEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.x = reader.readChar();
        this.y = reader.readChar();
    }

    public int getUID() {
        return this.uid;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "CharacterStandEvent{" +
                "uid=" + uid +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
