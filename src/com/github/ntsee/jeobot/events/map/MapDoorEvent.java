package com.github.ntsee.jeobot.events.map;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class MapDoorEvent extends Event {

    private final int x;
    private final int y;

    public MapDoorEvent(EOReader reader) {
        this.x = reader.readChar();
        this.y = reader.readShort();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "MapDoorEvent{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
