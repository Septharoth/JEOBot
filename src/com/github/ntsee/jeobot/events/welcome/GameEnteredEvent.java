package com.github.ntsee.jeobot.events.welcome;

import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Character;
import com.github.ntsee.jeobot.world.Item;
import com.github.ntsee.jeobot.world.NPC;
import com.github.ntsee.jeobot.world.Player;

import java.util.ArrayList;
import java.util.List;

public class GameEnteredEvent extends WelcomeEvent {

    private static final int NEWS_COUNT = 8;

    private final int weight, maxWeight;
    private final String welcomeMessage;
    private final List<String> news = new ArrayList<>(NEWS_COUNT);
    private final List<Player.Item> inventory = new ArrayList<>();
    private final List<Player.Spell> spells = new ArrayList<>();
    private final List<Item> items = new ArrayList<>();
    private final List<NPC> npcs = new ArrayList<>();
    private final List<Character> characters = new ArrayList<>();

    public GameEnteredEvent(EOReader reader) {
        reader.readBreakString();
        this.welcomeMessage = reader.readBreakString();
        for (int i=0; i<NEWS_COUNT; i++) {
            String post = reader.readBreakString();
            if (!post.isEmpty()) {
                this.news.add(post);
            }
        }

        this.weight = reader.readChar();
        this.maxWeight = reader.readChar();

        while(reader.available() > 0 && reader.peek() != 0xFF) {
            int id = reader.readShort();
            int amount = reader.readInt();
            this.inventory.add(new Player.Item(id, amount));
        }
        reader.readBreakString();

        while (reader.available() > 0 && reader.peek() != 0xFF) {
            int id = reader.readShort();
            int level = reader.readShort();
            this.spells.add(new Player.Spell(id, level));
        }
        reader.readBreakString();

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

    public int getWeight() {
        return this.weight;
    }

    public int getMaxWeight() {
        return this.maxWeight;
    }

    public String getWelcomeMessage() {
        return this.welcomeMessage;
    }

    public List<String> getNews() {
        return this.news;
    }

    public List<Player.Item> getInventory() {
        return this.inventory;
    }

    public List<Player.Spell> getSpells() {
        return this.spells;
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
        return "GameEnteredEvent{" +
                "weight=" + weight +
                ", maxWeight=" + maxWeight +
                ", welcomeMessage='" + welcomeMessage + '\'' +
                ", news=" + news +
                ", inventory=" + inventory +
                ", spells=" + spells +
                ", items=" + items +
                ", npcs=" + npcs +
                ", characters=" + characters +
                '}';
    }
}
