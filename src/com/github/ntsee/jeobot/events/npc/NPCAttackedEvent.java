package com.github.ntsee.jeobot.events.npc;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Direction;
import com.github.ntsee.jeobot.world.Item;

public class NPCAttackedEvent extends Event {

    private int uid; // npc
    private int damageTaken;
    private int healthLeft;
    private int characterUID;
    private Direction characterDirection;

    private int spell;
    private int manaLeft; // only valid if spell != 0

    private boolean killed;
    private int experience; // only valid if dead
    private Item item; // only valid if dead and itemUId > 0

    private int level;
    private int statPoints; // only valid if level != 0
    private int skillPoints; // only valid if level != 0
    private int maxHealth; // only valid if level != 0
    private int maxMana; // only valid if level != 0
    private int maxStamina; // only valid if level != 0

    public static NPCAttackedEvent fromReaderOnDamage(EOReader reader) {
        NPCAttackedEvent event = new NPCAttackedEvent();
        event.characterUID = reader.readShort();
        event.characterDirection = Direction.valueOf(reader.readChar());

        event.uid = reader.readShort();
        event.damageTaken = reader.readThree();
        event.healthLeft = reader.readShort();
        return event;
    }

    public static NPCAttackedEvent fromReaderOnKilled(EOReader reader) {
        NPCAttackedEvent event = new NPCAttackedEvent();
        event.killed = true;
        event.characterUID = reader.readShort();
        event.characterDirection = Direction.valueOf(reader.readChar());
        event.uid = reader.readShort();

        int itemUID = reader.readShort();
        int itemID = reader.readShort();
        int itemX = reader.readChar();
        int itemY = reader.readChar();
        int itemAmount = reader.readInt();
        if (itemUID > 0) {
            event.item = new Item(itemUID, itemID, itemX, itemY, itemAmount);
        }

        event.damageTaken = reader.readThree();
        event.experience = reader.readInt();
        return event;
    }

    public static NPCAttackedEvent fromReaderOnKilledLeveled(EOReader reader) {
        NPCAttackedEvent event = fromReaderOnKilled(reader);
        event.level = reader.readChar();
        event.statPoints = reader.readShort();
        event.skillPoints = reader.readShort();
        event.maxHealth = reader.readShort();
        event.maxMana = reader.readShort();
        event.maxStamina = reader.readShort();
        return event;
    }

    public static NPCAttackedEvent fromReaderOnSpellDamage(EOReader reader) {
        NPCAttackedEvent event = new NPCAttackedEvent();
        event.spell = reader.readShort();
        event.characterUID = reader.readShort();
        event.characterDirection = Direction.valueOf(reader.readChar());

        event.uid = reader.readShort();
        event.damageTaken = reader.readThree();
        event.healthLeft = reader.readShort();

        event.manaLeft = reader.readShort();
        return event;
    }

    public static NPCAttackedEvent fromReaderOnSpellKilled(EOReader reader) {
        NPCAttackedEvent event = new NPCAttackedEvent();
        event.killed = true;
        event.spell = reader.readShort();
        event.characterUID = reader.readShort();
        event.characterDirection = Direction.valueOf(reader.readChar());
        event.uid = reader.readShort();

        int itemUID = reader.readShort();
        int itemID = reader.readShort();
        int itemX = reader.readChar();
        int itemY = reader.readChar();
        int itemAmount = reader.readInt();
        if (itemUID > 0) {
            event.item = new Item(itemUID, itemID, itemX, itemY, itemAmount);
        }

        event.damageTaken = reader.readThree();
        event.manaLeft = reader.readShort();
        event.experience = reader.readInt();
        return event;
    }

    public static NPCAttackedEvent fromReaderOnSpellKilledLevel(EOReader reader) {
        NPCAttackedEvent event = fromReaderOnSpellKilled(reader);
        event.level = reader.readChar();
        event.statPoints = reader.readShort();
        event.skillPoints = reader.readShort();
        event.maxHealth = reader.readShort();
        event.maxMana = reader.readShort();
        event.maxStamina = reader.readShort();
        return event;
    }

    public int getUID() {
        return uid;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public int getHealthLeft() {
        return healthLeft;
    }

    public boolean isKilled() {
        return this.killed;
    }

    public int getCharacterUID() {
        return characterUID;
    }

    public Direction getCharacterDirection() {
        return characterDirection;
    }

    public int getSpell() {
        return spell;
    }

    public int getManaLeft() {
        return manaLeft;
    }

    public int getExperience() {
        return experience;
    }

    public Item getItem() {
        return item;
    }

    public int getLevel() {
        return level;
    }

    public int getStatPoints() {
        return statPoints;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    @Override
    public String toString() {
        String string = "NPCAttackedEvent{" +
                "uid=" + uid +
                ", damageTaken=" + damageTaken +
                ", healthLeft=" + healthLeft +
                ", killed=" + killed;

        if (this.characterUID != 0) {
            string += ", characterUID=" + characterUID +
                    ", characterDirection=" + characterDirection;
        }

        if (this.spell != 0) {
            string += ", spell=" + spell +
                      ", manaLeft=" + manaLeft;
        }

        if (this.killed) {
            string += ", experience=" + experience;

            if (this.item != null) {
                string += ", item=" + item;
            }

            if (this.level != 0) {
                string += ", level=" + level +
                          ", statPoints=" + statPoints +
                          ", skillPoints=" + skillPoints +
                          ", maxHealth=" + maxHealth +
                          ", maxMana=" + maxMana +
                          ", maxStamina=" + maxStamina +
                          '}';
            }
        }

        return string;
    }
}
