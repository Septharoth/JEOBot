package com.github.ntsee.jeobot.events.item;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class ItemDisappearEvent extends Event {

    private final int uid;

    public ItemDisappearEvent(EOReader reader) {
        this.uid = reader.readShort();
    }

    public int getUID() {
        return this.uid;
    }

    @Override
    public String toString() {
        return "ItemDisappearEvent{" +
                "uid=" + uid +
                '}';
    }
}
