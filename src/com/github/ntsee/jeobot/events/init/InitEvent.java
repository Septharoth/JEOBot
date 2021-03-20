package com.github.ntsee.jeobot.events.init;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.events.map.MapMutationEvent;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.HashMap;
import java.util.Map;

public class InitEvent extends Event {

    public static InitEvent fromReader(EOReader reader) {
        Status status = Status.valueOf(reader.readByte());
        switch (status) {
            case OUT_OF_DATE:
                return new InitOutdatedEvent(reader);
            case OK:
                return new InitSuccessEvent(reader);
            case BANNED:
                return new InitBannedEvent(reader);
            case INIT_FILE_EMF:
            case FILE_EMF:
                return new EMFFileEvent(reader);
            case FILE_EIF:
                return new EIFFileEvent(reader);
            case FILE_ENF:
                return new ENFFileEvent(reader);
            case FILE_ESF:
                return new ESFFileEvent(reader);
            case PLAYERS:
                break;
            case MAP_MUTATION:
                return new MapMutationEvent(reader);
            case FRIEND_LIST:
                break;
            case FILE_ECF:
                return new ECFFileEvent(reader);
        }

        return null;
    }

    public enum Status {

        UNKNOWN(0),
        OUT_OF_DATE(1),
        OK(2),
        BANNED(3),
        FILE_EMF(4),
        INIT_FILE_EMF(5),
        FILE_EIF(6),
        FILE_ENF(7),
        FILE_ESF(8),
        PLAYERS(9),
        MAP_MUTATION(10),
        FRIEND_LIST(11),
        FILE_ECF(12);

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

        public static Status valueOf(int code) {
            return TABLE.getOrDefault(code, UNKNOWN);
        }
    }
}
