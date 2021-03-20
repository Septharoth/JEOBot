package com.github.ntsee.jeobot.events.npc;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Direction;

import java.util.ArrayList;
import java.util.List;

public class NPCUpdateEvent extends Event {

    private final List<Attack> attacks = new ArrayList<>();
    private final List<Movement> positions = new ArrayList<>();
    private final List<Chat> chats = new ArrayList<>();

    public NPCUpdateEvent(EOReader reader) {
        while (reader.available() > 0 && reader.peek() != 0xFF) {
            int uid = reader.readChar();
            int x = reader.readChar();
            int y = reader.readChar();
            Direction direction = Direction.valueOf(reader.readChar());
            this.positions.add(new Movement(uid, direction, x, y));
        }
        reader.readBreakString();

        while (reader.available() > 0 && reader.peek() != 0xFF) {
            int uid = reader.readChar();
            boolean targetKilled = reader.readChar() == 2;
            Direction direction = Direction.valueOf(reader.readChar());
            int targetPlayerID = reader.readShort();
            int damage = reader.readThree();
            int health = reader.readThree();
            this.attacks.add(new Attack(uid, targetKilled, direction, targetPlayerID, damage, health));
        }
        reader.readBreakString();

        while (reader.available() > 0 && reader.peek() != 0xFF) {
            int uid = reader.readShort();
            String message = reader.readFixedString(reader.readChar());
            this.chats.add(new Chat(uid, message));
        }
        reader.readBreakString();
    }

    public List<Attack> getAttacks() {
        return this.attacks;
    }

    public List<Movement> getMovements() {
        return this.positions;
    }

    public List<Chat> getChats() {
        return this.chats;
    }

    @Override
    public String toString() {
        return "NPCUpdateEvent{" +
                "attacks=" + attacks +
                ", positions=" + positions +
                ", chats=" + chats +
                '}';
    }

    public static class Movement {

        private final int uid;
        private final Direction direction;
        private final int x;
        private final int y;

        public Movement(int uid, Direction direction, int x, int y) {
            this.uid = uid;
            this.direction = direction;
            this.x = x;
            this.y = y;
        }

        public int getUID() {
            return this.uid;
        }

        public Direction getDirection() {
            return this.direction;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        @Override
        public String toString() {
            return "Movement{" +
                    "uid=" + uid +
                    ", direction=" + direction +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static class Attack {

        private final int uid;
        private final boolean killed;
        private final Direction direction;
        private final int characterUID;
        private final int damageTaken;
        private final int healthLeft;

        public Attack(int uid, boolean killed, Direction direction, int characterUID, int damageTaken, int healthLeft) {
            this.uid = uid;
            this.killed = killed;
            this.direction = direction;
            this.characterUID = characterUID;
            this.damageTaken = damageTaken;
            this.healthLeft = healthLeft;
        }

        public int getUID() {
            return this.uid;
        }

        public boolean isTargetDead() {
            return this.killed;
        }

        public Direction getDirection() {
            return this.direction;
        }

        public int getCharacterUID() {
            return this.characterUID;
        }

        public int getDamageTaken() {
            return this.damageTaken;
        }

        public int getHealthLeft() {
            return this.healthLeft;
        }

        @Override
        public String toString() {
            return "Attack{" +
                    "uid=" + uid +
                    ", killed=" + killed +
                    ", direction=" + direction +
                    ", characterUID=" + characterUID +
                    ", damageTaken=" + damageTaken +
                    ", healthLeft=" + healthLeft +
                    '}';
        }
    }

    public static class Chat {

        private final int uid;
        private final String message;

        public Chat(int uid, String message) {
            this.uid = uid;
            this.message = message;
        }

        public int getUID() {
            return this.uid;
        }

        public String getMessage() {
            return this.message;
        }

        @Override
        public String toString() {
            return "Chat{" +
                    "uid=" + uid +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
