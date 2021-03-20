package com.github.ntsee.jeobot.config;

public class TestConfig implements Config {

    @Override
    public int getFPS() {
        return 60;
    }

    @Override
    public String getHost() {
        return "localhost";
    }

    @Override
    public int getPort() {
        return 8078;
    }

    @Override
    public int getVersion() {
        return 28;
    }

    @Override
    public String getUsername() {
        return "test";
    }

    @Override
    public String getPassword() {
        return "test123";
    }

    @Override
    public String getCharacterName() {
        return "test";
    }
}
