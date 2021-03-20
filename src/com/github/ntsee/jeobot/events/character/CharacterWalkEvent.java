package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Direction;

public class CharacterWalkEvent extends Event {

    private final int uid;
    private final Direction direction;
    private final int x;
    private final int y;

    public CharacterWalkEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.direction = Direction.valueOf(reader.readChar());
        this.x = reader.readChar();
        this.y = reader.readChar();
    }

    public int getUID() {
        return this.uid;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "CharacterWalkEvent{" +
                "uid=" + uid +
                ", direction=" + direction +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
