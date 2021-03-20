package com.github.ntsee.jeobot.events.talk;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class TalkAdminEvent extends Event {

    private final String name;
    private final String message;

    public TalkAdminEvent(EOReader reader) {
        this.name = reader.readBreakString();
        this.message = reader.readBreakString();
    }

    public String getName() {
        return this.name;
    }

    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "TalkAdminEvent{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
