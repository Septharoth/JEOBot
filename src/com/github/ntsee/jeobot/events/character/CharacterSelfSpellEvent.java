package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class CharacterSelfSpellEvent extends Event {

    private final int uid;
    private final int spell;
    private final int amount;
    private final int percentage;
    private final int health;
    private final int mana;
    private final boolean statsUpdated;

    public CharacterSelfSpellEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.spell = reader.readShort();
        this.amount = reader.readInt();
        this.percentage = reader.readChar();
        this.health = reader.readShort();
        this.mana = reader.readShort();
        this.statsUpdated = reader.readShort() == 1;
    }

    public int getUID() {
        return this.uid;
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

    public int getHealth() {
        return this.health;
    }

    public int getMana() {
        return this.mana;
    }

    public boolean isStatsUpdated() {
        return this.statsUpdated;
    }

    @Override
    public String toString() {
        return "CharacterSelfSpellEvent{" +
                "uid=" + uid +
                ", spell=" + spell +
                ", amount=" + amount +
                ", percentage=" + percentage +
                ", health=" + health +
                ", mana=" + mana +
                ", statsUpdated=" + statsUpdated +
                '}';
    }
}
