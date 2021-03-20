package com.github.ntsee.jeobot.events.guild;

import com.github.ntsee.jeobot.io.EOReader;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GuildInfoEvent {

    private static final int TOTAL_RANKS = 9;

    private final String name;
    private final String tag;
    private final String createDate;
    private final String description;
    private final String wealth;
    private final List<String> ranks;
    private final Collection<Staff> staff;

    public GuildInfoEvent(EOReader reader) {
        this.name = reader.readBreakString();
        this.tag = reader.readBreakString();
        this.createDate = reader.readBreakString();
        this.description = reader.readBreakString();
        this.wealth = reader.readBreakString();
        this.ranks = new ArrayList<>(TOTAL_RANKS);
        for (int i=0; i<TOTAL_RANKS; i++) {
            this.ranks.add(reader.readBreakString());
        }

        int count = reader.readShort();
        reader.readBreakString();
        this.staff = new ArrayList<>(count);
        for (int i=0; i<count; i++) {
            int rank = reader.readChar();
            reader.readBreakString();
            String name = reader.readBreakString();
            this.staff.add(new Staff(rank, name));
        }
    }

    public String getName() {
        return this.name;
    }

    public String getTag() {
        return this.tag;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public String getDescription() {
        return this.description;
    }

    public String getWealth() {
        return this.wealth;
    }

    public List<String> getRanks() {
        return this.ranks;
    }

    public Collection<Staff> getStaff() {
        return this.staff;
    }

    @Override
    public String toString() {
        return "GuildInfoEvent{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", createDate='" + createDate + '\'' +
                ", description='" + description + '\'' +
                ", wealth='" + wealth + '\'' +
                ", ranks=" + ranks +
                ", staff=" + staff +
                '}';
    }

    public static class Staff {

        private final int rank;
        private final String name;

        public Staff(int rank, String name) {
            this.rank = rank;
            this.name = name;
        }

        public int getRank() {
            return this.rank;
        }

        public String getName() {
            return this.name;
        }

        @Override
        public String toString() {
            return "Staff{" +
                    "rank=" + rank +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
