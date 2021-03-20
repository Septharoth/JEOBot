package com.github.ntsee.jeobot.events;

import com.github.ntsee.jeobot.io.EOReader;

public class UnknownEvent extends Event {

    private final EOReader reader;

    public UnknownEvent(EOReader reader) {
        this.reader = reader;
    }

    @Override
    public String toString() {
        return "UnknownEvent{" +
                "reader=" + reader +
                '}';
    }
}
