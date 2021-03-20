package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class CharacterSpikeEvent extends Event {

    private final int uid;
    private final int healthLeft;
    private final boolean killed;
    private final int damage;

    public CharacterSpikeEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.healthLeft = reader.readChar();
        this.killed = reader.readChar() > 0;
        this.damage = reader.readThree();
    }

    public int getUID() {
        return this.uid;
    }

    public int getHealthLeft() {
        return this.healthLeft;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public int getDamage() {
        return this.damage;
    }

    @Override
    public String toString() {
        return "CharacterSpikeEvent{" +
                "uid=" + uid +
                ", healthLeft=" + healthLeft +
                ", killed=" + killed +
                ", damage=" + damage +
                '}';
    }
}
