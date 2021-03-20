package com.github.ntsee.jeobot.events.jukebox;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class JukeboxFailedEvent extends Event {

    private final int track;

    public JukeboxFailedEvent(EOReader reader) {
        this.track = reader.readShort();
    }

    public int getTrack() {
        return this.track;
    }

    @Override
    public String toString() {
        return "JukeboxFailedEvent{" +
                "track=" + track +
                '}';
    }
}
