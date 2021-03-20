package com.github.ntsee.jeobot.world;

public enum  Gender {

    FEMALE,
    MALE;

    public static Gender valueOf(int id) {
        return Gender.values()[id % Gender.values().length];
    }
}
