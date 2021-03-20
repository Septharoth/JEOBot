package com.github.ntsee.jeobot.events.talk;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class TalkPartyEvent extends Event {

    private final int uid;
    private final String message;

    public TalkPartyEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.message = reader.readEndString();
    }

    public int getUID() {
        return this.uid;
    }

    public String getMessage() {
        return this.message;
    }
}
