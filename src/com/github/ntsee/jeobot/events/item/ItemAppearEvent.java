package com.github.ntsee.jeobot.events.item;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Item;

public class ItemAppearEvent extends Event {

    private final Item item;

    public ItemAppearEvent(EOReader reader) {
        int id = reader.readShort();
        int uid = reader.readShort();
        int amount = reader.readThree();
        int x = reader.readChar();
        int y = reader.readChar();
        this.item = new Item(uid, id, x, y, amount);
    }

    public Item getItem() {
        return this.item;
    }

    @Override
    public String toString() {
        return "ItemAppearEvent{" +
                "item=" + item +
                '}';
    }
}
