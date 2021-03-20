package com.github.ntsee.jeobot;


import com.github.ntsee.jeobot.config.Config;
import com.github.ntsee.jeobot.events.Event;
import com.github.ntsee.jeobot.io.*;
import com.github.ntsee.jeobot.logging.Logger;
import com.github.ntsee.jeobot.world.EOMap;

import java.util.function.Consumer;

public interface EOEngine {

     Config getConfig();
     Pub<ECF> getECF();
     Pub<EIF> getEIF();
     Pub<ENF> getENF();
     Pub<ESF> getESF();
     EOMap getMap();

     <T extends Event> void register(Class<T> type, Consumer<T> handler);
     <T extends Event> void unregister(Class<T> type, Consumer<T> handler);
     void log(Logger.Type type, String text);
     void connect(String host, int port);
     void send(EOWriter packet);
     void stop();
}
