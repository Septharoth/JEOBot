package com.github.ntsee.jeobot.world;

import com.github.ntsee.jeobot.io.EOReader;

public class Character {

    private final int uid;
    private int map, x, y;
    private Direction direction;
    private String name;
    private String guildTag;
    private Gender gender;
    private int skin;
    private int hairStyle, hairColor;
    private int boots, armor, hat, weapon, shield;
    private int level;
    private int classification;
    private int health, maxHealth;
    private int mana, maxMana;
    private boolean invisible;
    private State state;

    public Character(EOReader reader) {
        this.name = reader.readBreakString();
        this.uid = reader.readShort();
        this.map = reader.readShort();
        this.x = reader.readShort();
        this.y = reader.readShort();
        this.direction = Direction.valueOf(reader.readChar());
        this.classification = reader.readChar();
        this.guildTag = reader.readFixedString(3);
        this.level = reader.readChar();
        this.gender = Gender.valueOf(reader.readChar());
        this.hairStyle = reader.readChar();
        this.hairColor = reader.readChar();
        this.skin = reader.readChar();
        this.maxHealth = reader.readShort();
        this.health = reader.readShort();
        this.maxMana = reader.readShort();
        this.mana = reader.readShort();
        this.boots = reader.readShort(); reader.skip(6);
        this.armor = reader.readShort(); reader.skip(2);
        this.hat = reader.readShort();
        this.shield = reader.readShort();
        this.weapon = reader.readShort();
        this.state = State.valueOf(reader.readChar());
        this.invisible = reader.readChar() > 0;
        reader.readBreakString();
    }

    public int getUID() {
        return this.uid;
    }

    public int getMap() {
        return this.map;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return this.name;
    }

    public String getGuildTag() {
        return this.guildTag;
    }

    public int getLevel() {
        return this.level;
    }

    public int getClassification() {
        return this.classification;
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public int getMana() {
        return this.mana;
    }

    public int getMaxMana() {
        return this.maxMana;
    }

    public boolean isInvisible() {
        return this.invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
    }

    public void walk(Direction direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public void attack(Direction direction) {
        this.direction = direction;
    }

    public void face(Direction direction) {
        this.direction = direction;
    }

    @Override
    public int hashCode() {
        return this.uid;
    }

    public enum State {
        STAND,
        CHAIR,
        FLOOR;

        public static State valueOf(int id) {
            return State.values()[id % State.values().length];
        }
    }

}
