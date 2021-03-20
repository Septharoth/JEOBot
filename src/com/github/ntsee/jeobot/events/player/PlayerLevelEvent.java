package com.github.ntsee.jeobot.events.player;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

public class PlayerLevelEvent extends Event {

    private final int experience;
    private final int karma;
    private final int level;
    private final int statPoints;
    private final int skillPoints;

    public PlayerLevelEvent(EOReader reader) {
        this.experience = reader.readInt();
        this.karma = reader.readShort();
        this.level = reader.readChar();
        this.statPoints = reader.readShort();
        this.skillPoints = reader.readShort();
    }

    public int getExperience() {
        return this.experience;
    }

    public int getKarma() {
        return this.karma;
    }

    public int getLevel() {
        return this.level;
    }

    public int getStatPoints() {
        return this.statPoints;
    }

    public int getSkillPoints() {
        return this.skillPoints;
    }

    @Override
    public String toString() {
        return "PlayerLevelEvent{" +
                "experience=" + experience +
                ", karma=" + karma +
                ", level=" + level +
                ", statPoints=" + statPoints +
                ", skillPoints=" + skillPoints +
                '}';
    }
}
