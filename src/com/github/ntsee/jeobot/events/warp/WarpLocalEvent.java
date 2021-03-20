package com.github.ntsee.jeobot.events.warp;

import com.github.ntsee.jeobot.io.EOReader;

public class WarpLocalEvent extends WarpEvent {

    private int mapID;
    private int x;
    private int y;

    protected WarpLocalEvent() {
        super(Type.LOCAL);
    }

    public static WarpLocalEvent fromReader(EOReader reader) {
        WarpLocalEvent event = new WarpLocalEvent();
        event.mapID = reader.readShort();
        event.x = reader.readChar();
        event.y = reader.readChar();
        return event;
    }

    public int getMapID() {
        return this.mapID;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "WarpLocalEvent{" +
                "mapID=" + mapID +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
