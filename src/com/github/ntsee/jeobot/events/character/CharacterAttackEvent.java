package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Direction;

public class CharacterAttackEvent extends Event {

    private final int uid;
    private final Direction direction;

    public CharacterAttackEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.direction = Direction.valueOf(reader.readChar());
    }

    public int getUID() {
        return this.uid;
    }

    public Direction getDirection() {
        return this.direction;
    }

    @Override
    public String toString() {
        return "CharacterAttackEvent{" +
                "uid=" + uid +
                ", direction=" + direction +
                '}';
    }
}
