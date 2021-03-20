package com.github.ntsee.jeobot.events.board;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class BoardPostOpenEvent extends Event {

    private final int id;
    private final String message;

    public BoardPostOpenEvent(EOReader reader) {
        this.id = reader.readShort();
        this.message = reader.readEndString();
    }

    public int getID() {
        return this.id;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "BoardPostOpenedEvent{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
