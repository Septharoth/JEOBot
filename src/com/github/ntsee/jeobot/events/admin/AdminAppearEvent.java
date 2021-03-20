package com.github.ntsee.jeobot.events.admin;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class AdminAppearEvent extends Event {

    private final int uid;

    public AdminAppearEvent(EOReader reader) {
        this.uid = reader.readShort();
    }

    public int getUID() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "AdminAppearEvent{" +
                "uid=" + uid +
                '}';
    }
}
