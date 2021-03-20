package com.github.ntsee.jeobot.events.player;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Item;

import java.util.ArrayList;
import java.util.List;

public class PlayerWalkEvent extends Event {

    private final List<Item> items = new ArrayList<>();

    public PlayerWalkEvent(EOReader reader) {
        reader.readBreakString();
        reader.readBreakString();
        while (reader.available() > 0) {
            this.items.add(new Item(reader));
        }
    }

    public List<Item> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        return "PlayerWalkEvent{" +
                "items=" + items +
                '}';
    }
}
