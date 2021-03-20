package com.github.ntsee.jeobot.world;

import com.github.ntsee.jeobot.io.*;

import java.util.HashMap;
import java.util.Map;

public class World {

    private Player player = new Player();
    private Map<Integer, Item> items = new HashMap<>();
    private Map<Integer, Character> characters = new HashMap<>();
    private Map<Integer, NPC> npcs = new HashMap<>();
    private Pub<EIF> eif = new EIFPub();
    private Pub<ENF> enf = new ENFPub();
    private Pub<ESF> esf = new ESFPub();
    private Pub<ECF> ecf = new ECFPub();
    private EOMap map = new EOMap();

    public Player getPlayer() {
        return this.player;
    }

    public Character getMainCharacter() {
        return this.characters.get(this.player.getUID());
    }

    public Pub<EIF> getEIF() {
        return this.eif;
    }

    public Pub<ENF> getENF() {
        return this.enf;
    }

    public Pub<ESF> getESF() {
        return this.esf;
    }

    public Pub<ECF> getECF() {
        return this.ecf;
    }

    public EOMap getMap() {
        return this.map;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void addItem(Item item) {
        this.items.put(item.getUID(), item);
        this.map.getTile(item.getX(), item.getY()).add(item);
    }

    public void addCharacter(Character character) {
        this.characters.put(character.getUID(), character);
        this.map.getTile(character.getX(), character.getY()).add(character);
    }

    public void addNPC(NPC npc) {
        this.npcs.put(npc.getUID(), npc);
        this.map.getTile(npc.getX(), npc.getY()).add(npc);
    }

    public void removeItem(int uid) {
        this.items.remove(uid);
    }

    public void removeCharacter(int uid) {
        this.characters.remove(uid);
    }

    public void removeNPC(int uid) {
        this.npcs.remove(uid);
    }

    public void walkCharacter(int uid, Direction direction, int x, int y) {
        if (this.characters.containsKey(uid)) {
            Character character = this.characters.get(uid);
            this.map.getTile(character.getX(), character.getY()).remove(character);
            character.walk(direction, x, y);
            this.map.getTile(character.getX(), character.getY()).add(character);
        }
    }

    public void walkNPC(int uid, Direction direction, int x, int y) {
        if (this.npcs.containsKey(uid)) {
            NPC npc = this.npcs.get(uid);
            this.map.getTile(npc.getX(), npc.getY()).remove(npc);
            npc.walk(direction, x, y);
            if (this.map.isWithinBounds(npc.getX(), npc.getY())) {
                this.map.getTile(npc.getX(), npc.getY()).add(npc);
            }
        }
    }

    public void attackCharacter(int uid, Direction direction) {
        if (this.characters.containsKey(uid)) {
            Character character = this.characters.get(uid);
            character.attack(direction);
        }
    }

    public void attackNPC(int uid, Direction direction) {
        if (this.npcs.containsKey(uid)) {
            NPC npc = this.npcs.get(uid);
            npc.attack(direction);
        }
    }
}
