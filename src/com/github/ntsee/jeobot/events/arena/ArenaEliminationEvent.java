package com.github.ntsee.jeobot.events.arena;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class ArenaEliminationEvent extends Event {

    private final int killStreak;
    private final String killerName;
    private final String victimName;

    public ArenaEliminationEvent(EOReader reader) {
        reader.readBreakString();
        reader.readBreakString();

        this.killStreak = reader.readInt();
        reader.readBreakString();

        this.killerName = reader.readBreakString();
        this.victimName = reader.readBreakString();
    }

    public int getKillStreak() {
        return this.killStreak;
    }

    public String getKillerName() {
        return this.killerName;
    }

    public String getVictimName() {
        return this.victimName;
    }

    @Override
    public String toString() {
        return "ArenaEliminationEvent{" +
                "killStreak=" + killStreak +
                ", killerName='" + killerName + '\'' +
                ", victimName='" + victimName + '\'' +
                '}';
    }
}
