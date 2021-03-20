package com.github.ntsee.jeobot.events.map;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Character;
import com.github.ntsee.jeobot.world.Item;
import com.github.ntsee.jeobot.world.NPC;

import java.util.ArrayList;
import java.util.List;

public class MapEnterEvent extends Event {

    private final int mapID;
    private final Transition transition;
    private final List<Character> characters = new ArrayList<>();
    private final List<NPC> npcs = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();

    public MapEnterEvent(EOReader reader) {
        reader.readChar();
        this.mapID = reader.readShort();
        this.transition = Transition.valueOf(reader.readChar());

        int totalCharacters = reader.readChar();
        reader.readBreakString();
        for (int i=0; i<totalCharacters; i++) {
            this.characters.add(new Character(reader));
        }

        while (reader.available() > 0 && reader.peek() != 0xFF) {
            this.npcs.add(new NPC(reader));
        }
        reader.readBreakString();

        while (reader.available() > 0) {
            this.items.add(new Item(reader));
        }
    }

    public int getMapID() {
        return this.mapID;
    }

    public Transition getTransition() {
        return this.transition;
    }

    public List<Character> getCharacters() {
        return this.characters;
    }

    public List<NPC> getNPCs() {
        return this.npcs;
    }

    public List<Item> getItems() {
        return this.items;
    }

    @Override
    public String toString() {
        return "MapEnterEvent{" +
                "mapID=" + mapID +
                ", transition=" + transition +
                ", characters=" + characters +
                ", npcs=" + npcs +
                ", items=" + items +
                '}';
    }

    public enum Transition {
        NONE,
        SCROLL,
        ADMIN;

        public static Transition valueOf(int id) {
            return Transition.values()[id % Transition.values().length];
        }
    }
}
