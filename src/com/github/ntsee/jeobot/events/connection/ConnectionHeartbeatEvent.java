package com.github.ntsee.jeobot.events.connection;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class ConnectionHeartbeatEvent extends Event {

    private final int s1;
    private final int s2;

    public ConnectionHeartbeatEvent(EOReader reader) {
        this.s1 = reader.readShort();
        this.s2 = reader.readChar();
    }

    public int getS1() {
        return this.s1;
    }

    public int getS2() {
        return this.s2;
    }

    @Override
    public String toString() {
        return "ConnectionHeartbeatEvent{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                '}';
    }
}
