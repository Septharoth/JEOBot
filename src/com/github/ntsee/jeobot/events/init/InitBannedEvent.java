package com.github.ntsee.jeobot.events.init;

import com.github.ntsee.jeobot.io.EOReader;

public class InitBannedEvent extends InitEvent {

    private static final int PERMANENT = -1;

    private final int duration;

    public InitBannedEvent(EOReader reader) {
        this.duration = reader.readByte() > 0 ? PERMANENT : reader.readByte();
    }

    public int getDuration() {
        return this.duration;
    }

    public boolean isPermanent() {
        return this.duration == PERMANENT;
    }

    @Override
    public String toString() {
        return "InitBannedEvent{" +
                "permanent=" + this.isPermanent() +
                ", duration=" + duration +
                '}';
    }
}
