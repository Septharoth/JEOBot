package com.github.ntsee.jeobot.events.init;

import com.github.ntsee.jeobot.io.EOReader;

public class InitSuccessEvent extends InitEvent {

    private final int s1;
    private final int s2;
    private final int encode;
    private final int decode;

    public InitSuccessEvent(EOReader reader) {
        this.s1 = reader.readByte();
        this.s2 = reader.readByte();
        this.encode = reader.readByte();
        this.decode = reader.readByte();
    }

    public int getS1() {
        return this.s1;
    }

    public int getS2() {
        return this.s2;
    }

    public int getEncode() {
        return this.encode;
    }

    public int getDecode() {
        return this.decode;
    }

    @Override
    public String toString() {
        return "InitSuccessEvent{" +
                "s1=" + s1 +
                ", s2=" + s2 +
                ", encode=" + encode +
                ", decode=" + decode +
                '}';
    }
}
