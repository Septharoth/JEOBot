package com.github.ntsee.jeobot.events.welcome;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.HashMap;
import java.util.Map;

public class WelcomeEvent extends Event {

    public static WelcomeEvent fromReader(EOReader reader) {
        Status status = Status.valueOf(reader.readShort());
        switch (status) {
            case SELECTED_CHARACTER:
                return new SelectedCharacterEvent(reader);
            case GAME_ENTERED:
                return new GameEnteredEvent(reader);
        }

        return null;
    }

    public enum Status {

        UNKNOWN(0),
        SELECTED_CHARACTER(1),
        GAME_ENTERED(2);

        private final int id;

        Status(int id) {
            this.id = id;
        }

        private static final Map<Integer, Status> TABLE = new HashMap<>(Status.values().length);
        static {
            for (Status status : Status.values()) {
                TABLE.put(status.id, status);
            }
        }

        public static Status valueOf(int id) {
            return TABLE.getOrDefault(id, UNKNOWN);
        }
    }
}
