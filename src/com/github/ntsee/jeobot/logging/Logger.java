package com.github.ntsee.jeobot.logging;

import com.github.ntsee.jeobot.events.Event;

public interface Logger {

    void log(Event event);
    void log(Type type, String text);

    enum Type { INFO, ERROR }
}
