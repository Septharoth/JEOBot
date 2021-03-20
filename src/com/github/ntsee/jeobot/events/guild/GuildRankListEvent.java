package com.github.ntsee.jeobot.events.guild;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.ArrayList;
import java.util.List;

public class GuildRankListEvent extends Event {

    private final List<String> ranks;

    public GuildRankListEvent(EOReader reader) {
        this.ranks = new ArrayList<>();
        for (int i=0; i<9; i++) {
            this.ranks.add(reader.readBreakString());
        }
    }

    public List<String> getRanks() {
        return this.ranks;
    }

    @Override
    public String toString() {
        return "GuildRankListEvent{" +
                "ranks=" + ranks +
                '}';
    }
}
