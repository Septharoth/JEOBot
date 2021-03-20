package com.github.ntsee.jeobot.events.guild;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class GuildDescriptionEvent extends Event {

    private final String description;

    public GuildDescriptionEvent(EOReader reader) {
        this.description = reader.readEndString();
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "GuildDescriptionEvent{" +
                "description='" + description + '\'' +
                '}';
    }
}
