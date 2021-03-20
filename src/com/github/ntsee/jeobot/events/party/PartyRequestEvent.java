package com.github.ntsee.jeobot.events.party;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class PartyRequestEvent extends Event {

    private final Type type;
    private final int uid;
    private final String name;

    public PartyRequestEvent(EOReader reader) {
        this.type = Type.valueOf(reader.readChar());
        this.uid = reader.readShort();
        this.name = reader.readEndString();
    }

    public Type getType() {
        return this.type;
    }

    public int getUID() {
        return this.uid;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "PartyRequestEvent{" +
                "type=" + type +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                '}';
    }

    public enum Type {
        JOIN, INVITE;

        public static Type valueOf(int id) {
            return Type.values()[id % Type.values().length];
        }
    }
}
