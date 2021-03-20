package com.github.ntsee.jeobot.events.welcome;

import com.github.ntsee.jeobot.io.EOReader;
import com.github.ntsee.jeobot.world.Player;

public class SelectedCharacterEvent extends WelcomeEvent {

    private final Player player;
    private final int selectedUID;
    private final int mapID, mapHash, mapFileSize;
    private final int eifHash, eifSize;
    private final int enfHash, enfSize;
    private final int esfHash, esfSize;
    private final int ecfHash, ecfSize;

    public SelectedCharacterEvent(EOReader reader) {
        this.player = new Player();
        this.player.setUID(reader.readShort());
        this.selectedUID = reader.readInt();
        this.mapID = reader.readShort();
        this.mapHash = reader.readInt();
        this.mapFileSize = reader.readThree();
        this.eifHash = reader.readInt();
        this.eifSize = reader.readShort();
        this.enfHash = reader.readInt();
        this.enfSize = reader.readShort();
        this.esfHash = reader.readInt();
        this.esfSize = reader.readShort();
        this.ecfHash = reader.readInt();
        this.ecfSize = reader.readShort();
        this.player.setName(reader.readBreakString());
        this.player.setTitle(reader.readBreakString());
        this.player.setGuildName(reader.readBreakString());
        this.player.setGuildRankName(reader.readBreakString());
        this.player.setStat(Player.Stat.CLASS, reader.readChar());
        this.player.setGuildTag(reader.readFixedString(3));
        this.player.setStat(Player.Stat.ADMIN, reader.readChar());
        this.player.setStat(Player.Stat.LEVEL, reader.readChar());
        this.player.setStat(Player.Stat.EXPERIENCE, reader.readInt());
        this.player.setStat(Player.Stat.USAGE, reader.readInt());
        this.player.setStat(Player.Stat.HEALTH, reader.readShort());
        this.player.setStat(Player.Stat.MAX_HEALTH, reader.readShort());
        this.player.setStat(Player.Stat.MANA, reader.readShort());
        this.player.setStat(Player.Stat.MAX_MANA, reader.readShort());
        this.player.setStat(Player.Stat.MAX_STAMINA, reader.readShort());
        this.player.setStat(Player.Stat.STAT_POINTS, reader.readShort());
        this.player.setStat(Player.Stat.SKILL_POINTS, reader.readShort());
        this.player.setStat(Player.Stat.KARMA, reader.readShort());
        this.player.setStat(Player.Stat.MIN_DAMAGE, reader.readShort());
        this.player.setStat(Player.Stat.MAX_DAMAGE, reader.readShort());
        this.player.setStat(Player.Stat.ACCURACY, reader.readShort());
        this.player.setStat(Player.Stat.EVASION, reader.readShort());
        this.player.setStat(Player.Stat.DEFENSE, reader.readShort());
        this.player.setStat(Player.Stat.STRENGTH, reader.readShort());
        this.player.setStat(Player.Stat.INTELLIGENCE, reader.readShort());
        this.player.setStat(Player.Stat.WISDOM, reader.readShort());
        this.player.setStat(Player.Stat.AGILITY, reader.readShort());
        this.player.setStat(Player.Stat.CONSTITUTION, reader.readShort());
        this.player.setStat(Player.Stat.CHARISMA, reader.readShort());
        // full paperdoll
        //this.player.setStat(Player.Stat.GUILD_RANK, reader.readChar());
        //this.player.setStat(Player.Stat.JAIL, reader.readShort());
        //reader.skip(12); // Server Settings
        //this.showLoginMessage = reader.readChar() == 2;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getSelectedUID() {
        return this.selectedUID;
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

    public int getEIFHash() {
        return this.eifHash;
    }

    public int getEIFSize() {
        return this.eifSize;
    }

    public int getENFHash() {
        return this.enfHash;
    }

    public int getENFSize() {
        return this.enfSize;
    }

    public int getESFHash() {
        return this.esfHash;
    }

    public int getESFSize() {
        return this.esfSize;
    }

    public int getECFHash() {
        return this.ecfHash;
    }

    public int getECFSize() {
        return this.ecfSize;
    }

    @Override
    public String toString() {
        return "SelectedCharacterEvent{" +
                "player=" + player +
                ", selectedUID=" + selectedUID +
                ", mapID=" + mapID +
                ", mapHash=" + mapHash +
                ", mapFileSize=" + mapFileSize +
                ", eifHash=" + eifHash +
                ", eifSize=" + eifSize +
                ", enfHash=" + enfHash +
                ", enfSize=" + enfSize +
                ", esfHash=" + esfHash +
                ", esfSize=" + esfSize +
                ", ecfHash=" + ecfHash +
                ", ecfSize=" + ecfSize +
                '}';
    }
}
