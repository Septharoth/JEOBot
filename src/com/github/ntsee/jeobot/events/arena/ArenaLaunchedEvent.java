package com.github.ntsee.jeobot.events.arena;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class ArenaLaunchedEvent extends Event {

    private final int amount;

    public ArenaLaunchedEvent(EOReader reader) {
        this.amount = reader.readChar();
    }

    public final int getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "ArenaLaunchedEvent{" +
                "amount=" + amount +
                '}';
    }
}
