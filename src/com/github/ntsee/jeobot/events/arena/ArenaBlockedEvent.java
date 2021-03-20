package com.github.ntsee.jeobot.events.arena;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class ArenaBlockedEvent extends Event {

    public ArenaBlockedEvent(EOReader reader) {

    }

    @Override
    public String toString() {
        return "ArenaBlockedEvent{}";
    }
}
