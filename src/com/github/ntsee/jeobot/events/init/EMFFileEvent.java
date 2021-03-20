package com.github.ntsee.jeobot.events.init;

import com.github.ntsee.jeobot.io.EOReader;

public class EMFFileEvent extends InitEvent {

    private final byte[] content;

    public EMFFileEvent(EOReader reader) {
        this.content = reader.readEndBytes();
    }

    public byte[] getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return "EMFFileEvent{}";
    }
}
