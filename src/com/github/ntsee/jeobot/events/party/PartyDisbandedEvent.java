package com.github.ntsee.jeobot.events.party;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class PartyDisbandedEvent extends Event {

    public PartyDisbandedEvent(EOReader reader) {
        reader.readBreakString();
    }

    @Override
    public String toString() {
        return "PartyDisbandedEvent{}";
    }
}
