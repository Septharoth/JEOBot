package com.github.ntsee.jeobot.events.warp;

import com.github.ntsee.jeobot.io.EOReader;

public class WarpMapEvent extends WarpEvent {

    private final int mapID;
    private final int mapHash;
    private final int mapFileSize;

    public WarpMapEvent(EOReader reader) {
        super(Type.MAP_SWITCH);
        this.mapID = reader.readShort();
        this.mapHash = reader.readInt();
        this.mapFileSize = reader.readThree();
    }

    public int getMapID() {
        return this.mapID;
    }

    public int getMapHash() {
        return this.mapHash;
    }

    public int getMapFileSize() {
        return this.mapFileSize;
    }

    @Override
    public String toString() {
        return "WarpMapEvent{" +
                "mapID=" + mapID +
                ", mapHash=" + mapHash +
                ", mapFileSize=" + mapFileSize +
                '}';
    }
}
