package com.github.ntsee.jeobot.events.warp;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.HashMap;
import java.util.Map;

public abstract class WarpEvent extends Event {

    private Type type;

    protected WarpEvent(Type type) {
        this.type = type;
    }

    public static WarpEvent fromReader(EOReader reader) {
        Type type = Type.valueOf(reader.readChar());
        switch (type) {
            case LOCAL:
                return WarpLocalEvent.fromReader(reader);
            case MAP_SWITCH:
                return new WarpMapEvent(reader);
        }

        return null;
    }

    public Type getType() {
        return this.type;
    }


    public enum Type {
        UNKNOWN(0),
        LOCAL(1),
        MAP_SWITCH(2);

        private final int id;

        Type(int id) {
            this.id = id;
        }

        private static final Map<Integer, Type> TABLE = new HashMap<>(Type.values().length);
        static {
            for (Type type : Type.values()) {
                TABLE.put(type.id, type);
            }
        }

        public static Type valueOf(int id) {
            return TABLE.getOrDefault(id, UNKNOWN);
        }
    }

}
