package com.github.ntsee.jeobot.events.character;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class CharacterDisappearEvent extends Event {

    private final int uid;
    private final Animation animation;

    public CharacterDisappearEvent(EOReader reader) {
        this.uid = reader.readShort();
        this.animation = Animation.valueOf(reader.readChar());
    }

    public int getUID() {
        return this.uid;
    }

    public Animation getAnimation() {
        return this.animation;
    }

    @Override
    public String toString() {
        return "CharacterDisappearEvent{" +
                "uid=" + uid +
                ", animation=" + animation +
                '}';
    }

    public enum Animation {

        NONE(0),
        SCROLL(1),
        ADMIN(2);

        private final int id;

        Animation(int id) {
            this.id = id;
        }

        public int getID() {
            return this.id;
        }

        public static Animation valueOf(int id) {
            return Animation.values()[id % Animation.values().length];
        }
    }
}
