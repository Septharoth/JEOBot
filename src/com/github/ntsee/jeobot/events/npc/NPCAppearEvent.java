package com.github.ntsee.jeobot.events.npc;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.NPC;

public class NPCAppearEvent extends Event {

    private final NPC npc;

    public NPCAppearEvent(EOReader reader) {
        reader.readBreakString();
        this.npc = new NPC(reader);
    }

    /**
     *
     * @return the NPC that appeared
     */
    public NPC getNPC() {
        return this.npc;
    }

    @Override
    public String toString() {
        return "NPCAppearEvent{" +
                "npc=" + npc +
                '}';
    }
}
