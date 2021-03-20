package com.github.ntsee.jeobot.events.init;

import com.github.ntsee.jeobot.io.EOReader;

public class ECFFileEvent extends InitEvent {

    private final int id;
    private final byte[] content;

    public ECFFileEvent(EOReader reader) {
        this.id = reader.readChar();
        this.content = reader.readEndBytes();
    }

    public int getID() {
        return this.id;
    }

    public byte[] getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return "ECFFileEvent{" +
                "id=" + id +
                '}';
    }
}
