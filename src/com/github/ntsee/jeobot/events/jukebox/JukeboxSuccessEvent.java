package com.github.ntsee.jeobot.events.jukebox;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class JukeboxSuccessEvent extends Event {

    private final int cost;

    public JukeboxSuccessEvent(EOReader reader) {
        this.cost = reader.readInt();
    }

    public int getCost() {
        return this.cost;
    }

    @Override
    public String toString() {
        return "JukeboxSuccessEvent{" +
                "cost=" + cost +
                '}';
    }
}
