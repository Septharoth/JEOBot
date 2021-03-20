package com.github.ntsee.jeobot.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class EventDispatcher {

    private final Map<Class<? extends Event>, List<Consumer<? extends Event>>> handlers = new HashMap<>();

    public synchronized <T extends Event> void register(Class<T> type, Consumer<T> handler) {
        if (!this.handlers.containsKey(type)) {
            this.handlers.put(type, new ArrayList<>());
        }

        this.handlers.get(type).add(handler);
    }

    public synchronized <T extends Event> void unregister(Class<T> type, Consumer<T> handler) {
        this.handlers.get(type).remove(handler);
    }

    public synchronized boolean fire(Event event) {
        if (this.handlers.containsKey(event.getClass())) {
            for (Consumer handler : this.handlers.get(event.getClass())) {
                handler.accept(event);
            }

            return true;
        }
        return false;
    }
}
