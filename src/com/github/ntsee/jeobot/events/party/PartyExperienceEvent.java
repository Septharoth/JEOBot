package com.github.ntsee.jeobot.events.party;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class PartyExperienceEvent extends Event {

    private final int uid;
    private final int amount;
    private final boolean leveled;

    public PartyExperienceEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.amount = reader.readInt();
        this.leveled = reader.readChar() > 0;
    }

    public int getUID() {
        return this.uid;
    }

    public int getAmount() {
        return this.amount;
    }

    public boolean isLeveled() {
        return this.leveled;
    }
}
