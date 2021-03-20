package com.github.ntsee.jeobot.events.npc;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class NPCBossKilledEvent extends Event {

    private final int childID;

    public NPCBossKilledEvent(EOReader reader) {
        this.childID = reader.readShort();
    }

    public int getChildID() {
        return this.childID;
    }

    @Override
    public String toString() {
        return "NPCBossKilledEvent{" +
                "childID=" + childID +
                '}';
    }
}
