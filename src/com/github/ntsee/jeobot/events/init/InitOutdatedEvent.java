package com.github.ntsee.jeobot.events.init;

import com.github.ntsee.jeobot.io.EOReader;

public class InitOutdatedEvent extends InitEvent {

    private final int minor;
    private final int major;
    private final int build;

    public InitOutdatedEvent(EOReader reader) {
        this.minor = reader.readChar();
        this.major = reader.readChar();
        this.build = reader.readByte();
    }

    public int getMinor() {
        return this.minor;
    }

    public int getMajor() {
        return this.major;
    }

    public int getBuild() {
        return this.build;
    }

    @Override
    public String toString() {
        return "InitOutdatedEvent{" +
                "minor=" + minor +
                ", major=" + major +
                ", build=" + build +
                '}';
    }
}
