package com.github.ntsee.jeobot.scripts;

import com.github.ntsee.jeobot.EOEngine;
import com.github.ntsee.jeobot.events.connection.ConnectionFailedEvent;
import com.github.ntsee.jeobot.events.connection.ConnectionLostEvent;
import com.github.ntsee.jeobot.events.connection.ConnectionSuccessEvent;
import com.github.ntsee.jeobot.events.init.InitBannedEvent;
import com.github.ntsee.jeobot.events.init.InitOutdatedEvent;
import com.github.ntsee.jeobot.io.PacketFactory;
import com.github.ntsee.jeobot.logging.Logger;

public class ConnectionScript implements Script {

    private EOEngine engine;

    @Override
    public void onStart(EOEngine engine) {
        this.engine = engine;
        this.engine.register(ConnectionSuccessEvent.class, this::onConnectionSuccess);
        this.engine.register(ConnectionFailedEvent.class, this::onConnectionFailed);
        this.engine.register(ConnectionLostEvent.class, this::onConnectionLost);
        this.engine.register(InitBannedEvent.class, this::onInitBanned);
        this.engine.register(InitOutdatedEvent.class, this::onInitOutdated);
        this.engine.connect(this.engine.getConfig().getHost(), this.engine.getConfig().getPort());
    }

    private void onConnectionSuccess(ConnectionSuccessEvent event) {
        this.engine.send(PacketFactory.init(this.engine.getConfig().getVersion()));
    }

    private void onConnectionFailed(ConnectionFailedEvent event) {
        // attempt reconnects ?
    }

    private void onConnectionLost(ConnectionLostEvent event) {

    }

    private void onInitBanned(InitBannedEvent event) {
        this.engine.log(Logger.Type.ERROR, "You are banned from this server.");
        this.engine.stop();
    }

    private void onInitOutdated(InitOutdatedEvent event) {
        this.engine.log(Logger.Type.ERROR, String.format("Invalid Version - Expected %d.%d.%d", event.getBuild(), event.getMajor(), event.getMinor()));
        this.engine.stop();
    }

    @Override
    public void update() {

    }

    @Override
    public void onEnd() {
        this.engine.unregister(ConnectionSuccessEvent.class, this::onConnectionSuccess);
        this.engine.unregister(ConnectionFailedEvent.class, this::onConnectionFailed);
        this.engine.unregister(ConnectionLostEvent.class, this::onConnectionLost);
        this.engine.unregister(InitBannedEvent.class, this::onInitBanned);
        this.engine.unregister(InitOutdatedEvent.class, this::onInitOutdated);
    }
}
