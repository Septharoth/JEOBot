package com.github.ntsee.jeobot.events.talk;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class TalkPrivateEvent extends Event {

    private final String name;
    private final String message;

    public TalkPrivateEvent(EOReader reader) {
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
        return "TalkPrivateEvent{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
