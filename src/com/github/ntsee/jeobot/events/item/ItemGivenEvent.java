package com.github.ntsee.jeobot.events.item;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class ItemGivenEvent extends Event {

    private final int id;
    private final int amount;
    private final int weight;

    public ItemGivenEvent(EOReader reader) {
        this.id = reader.readShort();
        this.amount = reader.readThree();
        this.weight = reader.readChar();
    }

    public int getID() {
        return this.id;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return "ItemGivenEvent{" +
                "id=" + id +
                ", amount=" + amount +
                ", weight=" + weight +
                '}';
    }
}
