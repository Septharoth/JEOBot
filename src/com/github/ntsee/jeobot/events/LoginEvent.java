package com.github.ntsee.jeobot.events;

import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Gender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginEvent extends Event {

    private final Status status;
    private final List<Character> characters;

    public LoginEvent(EOReader reader) {
        this.status = Status.valueOf(reader.readShort());
        this.characters = new ArrayList<>();
        if (this.status == Status.OK) {
            int total = reader.readChar();
            reader.readBreakString();
            for (int i=0; i<total; i++) {
                this.characters.add(new Character(reader));
            }
        }
    }

    public Status getStatus() {
        return this.status;
    }

    public List<Character> getCharacters() {
        return this.characters;
    }

    @Override
    public String toString() {
        return "LoginEvent{" +
                "status=" + status +
                ", characters=" + characters +
                '}';
    }

    public enum Status {
        UNKNOWN(0),
        WRONG_USER(1),
        WRONG_USER_PASS(2),
        OK(3),
        LOGGED_IN(5),
        BUSY(6);

        private final int id;

        Status(int id) {
            this.id = id;
        }

        private static final Map<Integer, Status> TABLE = new HashMap<>(Status.values().length);
        static {
            for (Status status : Status.values()) {
                TABLE.put(status.id, status);
            }
        }

        public static Status valueOf(int id) {
            return TABLE.getOrDefault(id, UNKNOWN);
        }
    }

    public static class Character {

        private final int uid;
        private final int level;
        private final int admin;
        private final String name;
        private final Gender gender;
        private final int hairStyle, hairColor;
        private final int skin;
        private final int boots, armor, hat, shield, weapon;

        public Character(EOReader reader) {
            this.name = reader.readBreakString();
            this.uid = reader.readInt();
            this.level = reader.readChar();
            this.gender = Gender.valueOf(reader.readChar());
            this.hairStyle = reader.readChar();
            this.hairColor = reader.readChar();
            this.skin = reader.readChar();
            this.admin = reader.readChar();
            this.boots = reader.readShort();
            this.armor = reader.readShort();
            this.hat = reader.readShort();
            this.shield = reader.readShort();
            this.weapon = reader.readShort();
            reader.readBreakString();
        }

        public int getUID() {
            return this.uid;
        }

        public int getLevel() {
            return this.level;
        }

        public int getAdmin() {
            return this.admin;
        }

        public String getName() {
            return this.name;
        }

        public Gender getGender() {
            return this.gender;
        }

        public int getHairStyle() {
            return this.hairStyle;
        }

        public int getHairColor() {
            return this.hairColor;
        }

        public int getBoots() {
            return this.boots;
        }

        public int getArmor() {
            return this.armor;
        }

        public int getHat() {
            return this.hat;
        }

        public int getWeapon() {
            return this.weapon;
        }

        public int getShield() {
            return this.shield;
        }

        @Override
        public String toString() {
            return "Character{" +
                    "uid=" + uid +
                    ", level=" + level +
                    ", admin=" + admin +
                    ", name='" + name + '\'' +
                    ", gender=" + gender +
                    ", hairStyle=" + hairStyle +
                    ", hairColor=" + hairColor +
                    ", skin=" + skin +
                    ", boots=" + boots +
                    ", armor=" + armor +
                    ", hat=" + hat +
                    ", shield=" + shield +
                    ", weapon=" + weapon +
                    '}';
        }
    }
}
