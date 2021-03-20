package com.github.ntsee.jeobot.events.map;

import com.github.ntsee.jeobot.events.init.InitEvent;
import com.github.ntsee.jeobot.io.EOReader;

public class MapMutationEvent extends InitEvent {

    private final byte[] content;

    public MapMutationEvent(EOReader reader) {
        this.content = reader.readEndBytes();
    }

    public byte[] getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return "MapMutationEvent{}";
    }
}
