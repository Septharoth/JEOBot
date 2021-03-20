package com.github.ntsee.jeobot;

import com.github.ntsee.jeobot.config.Config;
import com.github.ntsee.jeobot.config.TestConfig;
import com.github.ntsee.jeobot.events.*;
import com.github.ntsee.jeobot.events.connection.ConnectionHeartbeatEvent;
import com.github.ntsee.jeobot.events.init.InitSuccessEvent;
import com.github.ntsee.jeobot.io.*;
import com.github.ntsee.jeobot.logging.Logger;
import com.github.ntsee.jeobot.logging.SystemLogger;
import com.github.ntsee.jeobot.scripts.Script;
import com.github.ntsee.jeobot.world.EOMap;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class JEOBot implements EOEngine {

    private final Config config;
    private final Pub<ECF> ecf;
    private final Pub<EIF> eif;
    private final Pub<ENF> enf;
    private final Pub<ESF> esf;
    private final EOMap map;

    private final List<Script> scripts;
    private final EventDispatcher dispatcher;
    private final Queue<Event> events;
    private final Logger logger;
    private final NetworkService network;
    private boolean running;

    public JEOBot(Script... scripts) {
        this.config = new TestConfig();
        this.ecf = new ECFPub();
        this.eif = new EIFPub();
        this.enf = new ENFPub();
        this.esf = new ESFPub();
        this.map = new EOMap();
        this.scripts = new ArrayList<>();
        this.scripts.addAll(Arrays.asList(scripts));
        this.dispatcher = new EventDispatcher();
        this.events = new LinkedList<>();
        this.logger = new SystemLogger();
        this.network = new NetworkServiceImpl(event -> {
            synchronized (events) {
                events.add(event);
            }
        });
    }

    public void start() {
        this.dispatcher.register(InitSuccessEvent.class, this::onInitSuccess);
        this.dispatcher.register(ConnectionHeartbeatEvent.class, this::onConnectionHeartbeat);
        this.scripts.forEach(script -> script.onStart(this));
        this.running = true;
    }

    private void onInitSuccess(InitSuccessEvent event) {
        this.network.init(event.getS1(), event.getS2(), event.getEncode(), event.getDecode());
    }

    private void onConnectionHeartbeat(ConnectionHeartbeatEvent event) {
        this.network.setSequence(event.getS1(), event.getS2());
    }

    public void update() throws InterruptedException {
        synchronized (this.events) {
            while (!this.events.isEmpty()) {
                Event event = this.events.poll();
                this.logger.log(event);
                this.dispatcher.fire(event);
            }
        }


        Thread.sleep(1000/this.config.getFPS());
    }

    public boolean isRunning() {
        return this.running;
    }

    @Override
    public Config getConfig() {
        return this.config;
    }

    @Override
    public Pub<ECF> getECF() {
        return this.ecf;
    }

    @Override
    public Pub<EIF> getEIF() {
        return this.eif;
    }

    @Override
    public Pub<ENF> getENF() {
        return this.enf;
    }

    @Override
    public Pub<ESF> getESF() {
        return this.esf;
    }

    @Override
    public EOMap getMap() {
        return this.map;
    }

    @Override
    public <T extends Event> void register(Class<T> type, Consumer<T> handler) {
        this.dispatcher.register(type, handler);
    }

    @Override
    public <T extends Event> void unregister(Class<T> type, Consumer<T> handler) {
        this.dispatcher.unregister(type, handler);
    }

    @Override
    public void log(Logger.Type type, String text) {
        this.logger.log(type, text);
    }

    @Override
    public void connect(String host, int port) {
        this.network.connect(host, port);
    }

    @Override
    public void send(EOWriter packet) {
        this.network.send(packet);
    }

    @Override
    public void stop() {
        this.dispatcher.unregister(InitSuccessEvent.class, this::onInitSuccess);
        this.dispatcher.unregister(ConnectionHeartbeatEvent.class, this::onConnectionHeartbeat);
        this.scripts.forEach(Script::onEnd);
        try {
            this.network.close();
        } catch (IOException e) {
            this.logger.log(Logger.Type.ERROR, e.toString());
        } finally {
            this.running = false;
        }
    }
}