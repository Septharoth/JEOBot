package com.github.ntsee.jeobot.events.guild;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class GuildDepositEvent extends Event {

    private final int amount;

    public GuildDepositEvent(EOReader reader) {
        this.amount = reader.readInt();
    }

    public int getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "GuildDepositEvent{" +
                "amount=" + amount +
                '}';
    }
}
