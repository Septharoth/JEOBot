package com.github.ntsee.jeobot.events.item;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class ItemLootedEvent extends Event {

    private final int uid;
    private final int id;
    private final int amount;
    private final int weight;
    private final int maxWeight;

    public ItemLootedEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.id = reader.readShort();
        this.amount = reader.readThree();
        this.weight = reader.readChar();
        this.maxWeight = reader.readChar();
    }

    public int getUID() {
        return this.uid;
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

    public int getMaxWeight() {
        return this.maxWeight;
    }

    @Override
    public String toString() {
        return "ItemLootedEvent{" +
                "uid=" + uid +
                ", id=" + id +
                ", amount=" + amount +
                ", weight=" + weight +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
