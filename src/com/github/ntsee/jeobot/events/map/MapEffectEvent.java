package com.github.ntsee.jeobot.events.map;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class MapEffectEvent extends Event {

    private final int effect;
    private final int x;
    private final int y;

    public MapEffectEvent(EOReader reader) {
        this.effect = reader.readShort();
        this.x = reader.readChar();
        this.y = reader.readChar();
    }

    public int getEffect() {
        return this.effect;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "MapEffectEvent{" +
                "effect=" + effect +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
