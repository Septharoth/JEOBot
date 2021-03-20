package com.github.ntsee.jeobot.events.arena;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class ArenaVictoryEvent extends Event {

    private final String winnerName;
    private final int killStreak;
    private final String killerName;
    private final String victimName;

    public ArenaVictoryEvent(EOReader reader) {
        this.winnerName = reader.readBreakString();
        this.killStreak = reader.readInt();
        reader.readBreakString();

        this.killerName = reader.readBreakString();
        this.victimName = reader.readBreakString();
    }

    public String getWinnerName() {
        return this.killerName;
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
        return "ArenaVictoryEvent{" +
                "winnerName='" + winnerName + '\'' +
                ", killStreak=" + killStreak +
                ", killerName='" + killerName + '\'' +
                ", victimName='" + victimName + '\'' +
                '}';
    }
}
