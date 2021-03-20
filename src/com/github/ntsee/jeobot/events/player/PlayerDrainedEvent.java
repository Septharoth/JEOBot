package com.github.ntsee.jeobot.events.player;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class PlayerDrainedEvent extends Event {

    private final Type type;
    private final int damage;
    private final int current;
    private final int max;

    public PlayerDrainedEvent(EOReader reader) {
        this.type = Type.valueOf(reader.readChar());
        this.damage = reader.readShort();
        this.current = reader.readShort();
        this.max = reader.readShort();
    }

    public Type getType() {
        return this.type;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getCurrent() {
        return this.current;
    }

    public int getMax() {
        return this.max;
    }

    @Override
    public String toString() {
        return "PlayerDrainedEvent{" +
                "type=" + type +
                ", damage=" + damage +
                ", current=" + current +
                ", max=" + max +
                '}';
    }

    public enum Type {
        UNKNOWN(0),
        MANA_DRAIN(1),
        SPIKES(2);

        private final int id;

        Type(int id) {
            this.id = id;
        }

        public static Type valueOf(int id) {
            for(Type type : Type.values()) {
                if (id == type.id) {
                    return type;
                }
            }

            return UNKNOWN;
        }
    }
}
