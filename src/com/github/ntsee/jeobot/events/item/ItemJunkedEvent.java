package com.github.ntsee.jeobot.events.item;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class ItemJunkedEvent extends Event {

    private final int id;
    private final int amount;
    private final int remaining;
    private final int weight;
    private final int maxWeight;

    public ItemJunkedEvent(EOReader reader) {
        this.id = reader.readShort();
        this.amount = reader.readThree();
        this.remaining = reader.readInt();
        this.weight = reader.readChar();
        this.maxWeight = reader.readChar();
    }

    public int getID() {
        return this.id;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getRemaining() {
        return this.remaining;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    @Override
    public String toString() {
        return "ItemJunkedEvent{" +
                "id=" + id +
                ", amount=" + amount +
                ", remaining=" + remaining +
                ", weight=" + weight +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
