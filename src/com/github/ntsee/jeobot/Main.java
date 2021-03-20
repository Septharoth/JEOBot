package com.github.ntsee.jeobot;

import com.github.ntsee.jeobot.scripts.ConnectionScript;
import com.github.ntsee.jeobot.scripts.EchoScript;
import com.github.ntsee.jeobot.scripts.LoginScript;

public class Main {

    public static void main(String[] args) throws Exception {
        JEOBot bot = new JEOBot(
                new ConnectionScript(),
                new LoginScript(),
                new EchoScript()
        );

        bot.start();
        while (bot.isRunning()) {
            bot.update();
        }
    }
}
