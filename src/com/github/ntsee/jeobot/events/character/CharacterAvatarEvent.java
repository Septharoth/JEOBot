package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.HashMap;
import java.util.Map;

public class CharacterAvatarEvent extends Event {

    private final int uid;
    private final Slot slot;
    private int boots, armor, hat, weapon, shield;
    private int hairStyle, hairColor;

    public CharacterAvatarEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.slot = Slot.valueOf(reader.readChar());
        int sound = reader.readChar();
        switch (this.slot) {
            case CLOTHES:
                this.boots = reader.readShort();
                this.armor = reader.readShort();
                this.hat = reader.readShort();
                this.weapon = reader.readShort();
                this.shield = reader.readShort();
                break;
            case HAIR:
                this.hairStyle = reader.readChar();
                this.hairColor = reader.readChar();
                break;
            case HAIR_COLOR:
                this.hairColor = reader.readChar();
                break;
        }
    }

    public int getUID() {
        return this.uid;
    }

    public Slot getSlot() {
        return this.slot;
    }

    public int getBoots() {
        return boots;
    }

    public int getArmor() {
        return armor;
    }

    public int getHat() {
        return hat;
    }

    public int getWeapon() {
        return weapon;
    }

    public int getShield() {
        return shield;
    }

    public int getHairStyle() {
        return hairStyle;
    }

    public int getHairColor() {
        return hairColor;
    }

    @Override
    public String toString() {
        return "CharacterAvatarEvent{" +
                "uid=" + uid +
                ", slot=" + slot +
                ", boots=" + boots +
                ", armor=" + armor +
                ", hat=" + hat +
                ", weapon=" + weapon +
                ", offhand=" + shield +
                ", hairStyle=" + hairStyle +
                ", hairColor=" + hairColor +
                '}';
    }

    public enum Slot {

        UNKNOWN(0),
        CLOTHES(1),
        HAIR(2),
        HAIR_COLOR(3);

        private final int id;

        Slot(int id) {
            this.id = id;
        }

        private static final Map<Integer, Slot> TABLE = new HashMap<>(Slot.values().length);
        static {
            for (Slot slot : Slot.values()) {
                TABLE.put(slot.id, slot);
            }
        }

        public static Slot valueOf(int id) {
            return TABLE.getOrDefault(id, UNKNOWN);
        }
    }
}
