package com.github.ntsee.jeobot.events.item;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Item;

public class ItemDroppedEvent extends Event {

    private final Item item;
    private final int weight;
    private final int maxWeight;

    public ItemDroppedEvent(EOReader reader) {
        int id = reader.readShort();
        int amount = reader.readThree();
        reader.readInt();
        int uid = reader.readShort();
        int x = reader.readChar();
        int y = reader.readChar();
        this.item = new Item(uid, id, x, y, amount);
        this.weight = reader.readChar();
        this.maxWeight = reader.readChar();
    }

    public Item getItem() {
        return this.item;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    @Override
    public String toString() {
        return "ItemDroppedEvent{" +
                "item=" + item +
                ", weight=" + weight +
                ", maxWeight=" + maxWeight +
                '}';
    }
}
