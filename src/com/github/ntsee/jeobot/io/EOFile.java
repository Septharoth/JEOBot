package com.github.ntsee.jeobot.io;

import java.io.File;

public enum EOFile {

    MAP(1, "maps/%05d.emf"),
    ITEM(2, "pub/dat%03d.eif"),
    NPC(3, "pub/dtn%03d.enf"),
    SPELL(4, "pub/dsl%03d.esf"),
    CLASS(5, "pub/dat%03d.ecf");

    private final int id;
    private final String path;

    EOFile(int id, String path) {
        this.id = id;
        this.path = path;
    }

    public int getID() {
        return this.id;
    }

    public String getPath(int id) {
        return String.format(this.path, id);
    }

    public File getFile(int id) {
        return new File(this.getPath(id));
    }
}