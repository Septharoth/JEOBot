package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.ArrayList;
import java.util.List;

public class CharacterGroupSpellEvent extends Event {

    private final int uid;
    private final int spell;
    private final int mana;
    private final int amount;
    private final List<Member> members;

    public CharacterGroupSpellEvent(EOReader reader) {
        this.spell = reader.readShort();
        this.uid = reader.readShort();
        this.mana = reader.readShort();
        this.amount = reader.readShort();
        this.members = new ArrayList<>();
        while (reader.available() > 0) {
            for (int i=0; i<5; i++) {
                reader.readBreakString();
            }

            int uid = reader.readShort();
            int percentage = reader.readChar();
            int amount = reader.readShort();
            this.members.add(new Member(uid, percentage, amount));
        }
    }

    public List<Member> getMembers() {
        return this.members;
    }

    @Override
    public String toString() {
        return "CharacterGroupSpellEvent{" +
                "uid=" + uid +
                ", spell=" + spell +
                ", mana=" + mana +
                ", amount=" + amount +
                ", members=" + members +
                '}';
    }

    public static class Member {

        private final int uid;
        private final int percentage;
        private final int amount;

        public Member(int uid, int percentage, int amount) {
            this.uid = uid;
            this.percentage = percentage;
            this.amount = amount;
        }

        public int getUID() {
            return this.uid;
        }

        public int getPercentage() {
            return this.percentage;
        }

        public int getAmount() {
            return this.amount;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "uid=" + uid +
                    ", percentage=" + percentage +
                    ", amount=" + amount +
                    '}';
        }
    }
}
