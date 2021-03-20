package com.github.ntsee.jeobot.events.talk;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class TalkGlobalEvent extends Event {

    private final String name;
    private final String message;

    public TalkGlobalEvent(EOReader reader) {
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
        return "TalkGlobalEvent{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
