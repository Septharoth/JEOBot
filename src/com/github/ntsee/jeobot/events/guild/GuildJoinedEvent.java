package com.github.ntsee.jeobot.events.guild;

import com.github.ntsee.jeobot.io.EOReader;

public class GuildJoinedEvent {

    private final int uid;
    private final String tag;
    private final String name;
    private final String rank;

    public GuildJoinedEvent(EOReader reader) {
        this.uid = reader.readShort();
        reader.readBreakString();
        this.tag = reader.readBreakString();
        this.name = reader.readBreakString();
        this.rank = reader.readBreakString();
    }

    public int getUID() {
        return this.uid;
    }

    public String getTag() {
        return this.tag;
    }

    public String getName() {
        return this.name;
    }

    public String getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return "GuildJoinedEvent{" +
                "uid=" + uid +
                ", tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
