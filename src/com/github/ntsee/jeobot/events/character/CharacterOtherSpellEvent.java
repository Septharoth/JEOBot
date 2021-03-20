package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Direction;

public class CharacterOtherSpellEvent extends Event {

    private final int uid;
    private final int victim;
    private final Direction direction;
    private final int spell;
    private final int amount;
    private final int percentage;

    public CharacterOtherSpellEvent(EOReader reader) {
        this.victim = reader.readShort();
        this.uid = reader.readShort();
        this.direction = Direction.valueOf(reader.readChar());
        this.spell = reader.readShort();
        this.amount = reader.readShort();
        this.percentage = reader.readChar();
    }

    public int getUID() {
        return this.uid;
    }

    public int getVictim() {
        return this.victim;
    }

    public Direction getDirection() {
        return this.direction;
    }

    public int getSpell() {
        return this.spell;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getPercentage() {
        return this.percentage;
    }

    @Override
    public String toString() {
        return "CharacterOtherSpellEvent{" +
                "uid=" + uid +
                ", victim=" + victim +
                ", direction=" + direction +
                ", spell=" + spell +
                ", amount=" + amount +
                ", percentage=" + percentage +
                '}';
    }
}
