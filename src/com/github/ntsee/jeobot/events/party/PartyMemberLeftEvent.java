package com.github.ntsee.jeobot.events.party;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class PartyMemberLeftEvent extends Event {

    private final int uid;

    public PartyMemberLeftEvent(EOReader reader) {
        this.uid = reader.readShort();
    }

    public int getUID() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "PartyMemberLeftEvent{" +
                "uid=" + uid +
                '}';
    }
}
