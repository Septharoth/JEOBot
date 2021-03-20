package com.github.ntsee.jeobot.events.player;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Player;

import java.util.EnumMap;
import java.util.Map;

public class PlayerStatsEvent extends Event {

    private final Map<Player.Stat, Integer> stats = new EnumMap<>(Player.Stat.class);

    private PlayerStatsEvent() {

    }

    public static PlayerStatsEvent fromReaderClassStats(EOReader reader) {
        PlayerStatsEvent event = new PlayerStatsEvent();
        event.stats.put(Player.Stat.CLASS, reader.readShort());
        event.readStats(reader);
        return event;
    }

    public static PlayerStatsEvent fromReaderLevelStats(EOReader reader) {
        PlayerStatsEvent event = new PlayerStatsEvent();
        event.stats.put(Player.Stat.STAT_POINTS, reader.readShort());
        event.readStats(reader);
        return event;
    }

    private void readStats(EOReader reader) {
        this.stats.put(Player.Stat.STRENGTH, reader.readShort());
        this.stats.put(Player.Stat.INTELLIGENCE, reader.readShort());
        this.stats.put(Player.Stat.WISDOM, reader.readShort());
        this.stats.put(Player.Stat.AGILITY, reader.readShort());
        this.stats.put(Player.Stat.CONSTITUTION, reader.readShort());
        this.stats.put(Player.Stat.CHARISMA, reader.readShort());
        this.stats.put(Player.Stat.MAX_HEALTH, reader.readShort());
        this.stats.put(Player.Stat.MAX_MANA, reader.readShort());
        this.stats.put(Player.Stat.MAX_STAMINA, reader.readShort());
        this.stats.put(Player.Stat.MAX_WEIGHT, reader.readShort());
        this.stats.put(Player.Stat.MIN_DAMAGE, reader.readShort());
        this.stats.put(Player.Stat.MAX_DAMAGE, reader.readShort());
        this.stats.put(Player.Stat.ACCURACY, reader.readShort());
        this.stats.put(Player.Stat.EVASION, reader.readShort());
        this.stats.put(Player.Stat.DEFENSE, reader.readShort());
    }

    public Map<Player.Stat, Integer> getStats() {
        return this.stats;
    }

    @Override
    public String toString() {
        return "PlayerStatsEvent{" +
                "stats=" + stats +
                '}';
    }
}
