package com.github.ntsee.jeobot.events.talk;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class TalkServerEvent extends Event {

    private final String message;

    public TalkServerEvent(EOReader reader) {
        this.message = reader.readEndString();
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "TalkServerEvent{" +
                "message='" + message + '\'' +
                '}';
    }
}
