package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Direction;

public class CharacterSitEvent extends Event {

    private final int uid;
    private final int x;
    private final int y;
    private final Direction direction;

    public CharacterSitEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.x = reader.readChar();
        this.y = reader.readChar();
        this.direction = Direction.valueOf(reader.readChar());
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

    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
        return "CharacterSitEvent{" +
                "uid=" + uid +
                ", x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }
}
