package com.github.ntsee.jeobot.events;

import com.github.ntsee.jeobot.io.EOReader;

import java.util.HashMap;
import java.util.Map;

public class AccountEvent extends Event {

    private final Status status;

    public AccountEvent(EOReader reader) {
        this.status = Status.valueOf(reader.readShort());
    }

    public Status getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "AccountEvent{" +
                "status=" + status +
                '}';
    }

    public enum Status {

        EXISTS(1),
        NOT_APPROVED(2),
        CREATED(3),
        PASSWORD_CHANGE_FAILED(5),
        PASSWORD_CHANGE_SUCCESS(6);

        private static final Map<Integer, Status> TABLE = new HashMap<>(Status.values().length);
        static {
            for (Status code : Status.values()) {
                TABLE.put(code.id, code);
            }
        }

        private final int id;

        Status(int id) {
            this.id = id;
        }

        public static Status valueOf(int id) {
            return TABLE.get(id);
        }
    }
}
