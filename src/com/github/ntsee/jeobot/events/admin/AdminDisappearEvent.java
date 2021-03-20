package com.github.ntsee.jeobot.events.admin;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class AdminDisappearEvent extends Event {

    private final int uid;

    public AdminDisappearEvent(EOReader reader) {
        this.uid = reader.readShort();
    }

    public int getUID() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "AdminDisappearEvent{" +
                "uid=" + uid +
                '}';
    }
}
