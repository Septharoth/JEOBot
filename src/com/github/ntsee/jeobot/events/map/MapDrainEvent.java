package com.github.ntsee.jeobot.events.map;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.ArrayList;
import java.util.List;

public class MapDrainEvent extends Event {

    private final int damage;
    private final int health;
    private final int maxHealth;
    private final List<Damage> damagedCharacters = new ArrayList<>();

    public MapDrainEvent(EOReader reader) {
        this.damage = reader.readShort();
        this.health = reader.readShort();
        this.maxHealth = reader.readShort();
        while (reader.available() > 0) {
            int uid = reader.readShort();
            int healthLeft = reader.readChar();
            int amount = reader.readShort();
            this.damagedCharacters.add(new Damage(uid, healthLeft, amount));
        }
    }

    @Override
    public String toString() {
        return "MapDrainEvent{" +
                "damage=" + damage +
                ", health=" + health +
                ", maxHealth=" + maxHealth +
                ", damagedCharacters=" + damagedCharacters +
                '}';
    }

    public static class Damage {

        private final int uid;
        private final int healthLeft;
        private final int amount;

        public Damage(int uid, int healthLeft, int amount) {
            this.uid = uid;
            this.healthLeft = healthLeft;
            this.amount = amount;
        }

        public int getUID() {
            return this.uid;
        }

        public int getHealthLeft() {
            return this.healthLeft;
        }

        public int getAmount() {
            return this.amount;
        }

        @Override
        public String toString() {
            return "Damage{" +
                    "uid=" + uid +
                    ", healthLeft=" + healthLeft +
                    ", amount=" + amount +
                    '}';
        }
    }
}
