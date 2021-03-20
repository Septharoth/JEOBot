package com.github.ntsee.jeobot.events.player;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class PlayerRecoverEvent extends Event {

    private final int health;
    private final int mana;

    public PlayerRecoverEvent(EOReader reader) {
        this.health = reader.readShort();
        this.mana = reader.readShort();
    }

    public int getHealth() {
        return this.health;
    }

    public int getMana() {
        return this.mana;
    }

    @Override
    public String toString() {
        return "PlayerRecoverEvent{" +
                "health=" + health +
                ", mana=" + mana +
                '}';
    }
}
