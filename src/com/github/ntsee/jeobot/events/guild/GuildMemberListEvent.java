package com.github.ntsee.jeobot.events.guild;

import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.EOReader;

import java.util.ArrayList;
import java.util.Collection;

public class GuildMemberListEvent extends Event {

    private final Collection<Member> members;

    public GuildMemberListEvent(EOReader reader) {
        int count = reader.readShort();
        reader.readBreakString();
        this.members = new ArrayList<>(count);
        for (int i=0; i<count; i++) {
            int rank = reader.readChar();
            reader.readBreakString();
            String name = reader.readBreakString();
            String rankName = reader.readBreakString();
            this.members.add(new Member(rank, name, rankName));
        }
    }

    public Collection<Member> getMembers() {
        return this.members;
    }

    @Override
    public String toString() {
        return "GuildMemberListEvent{" +
                "members=" + members +
                '}';
    }

    public static class Member {

        private final int rank;
        private final String name;
        private final String rankName;

        public Member(int rank, String name, String rankName) {
            this.rank = rank;
            this.name = name;
            this.rankName = rankName;
        }

        public int getRank() {
            return this.rank;
        }

        public String getName() {
            return this.name;
        }

        public String getRankName() {
            return this.rankName;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "rank=" + rank +
                    ", name='" + name + '\'' +
                    ", rankName='" + rankName + '\'' +
                    '}';
        }
    }
}
