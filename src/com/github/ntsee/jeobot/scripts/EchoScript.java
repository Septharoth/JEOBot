package com.github.ntsee.jeobot.scripts;

import com.github.ntsee.jeobot.EOEngine;
import com.github.ntsee.jeobot.events.talk.TalkLocalEvent;
import com.github.ntsee.jeobot.io.PacketFactory;

public class EchoScript implements Script {

    private EOEngine engine;

    @Override
    public void onStart(EOEngine engine) {
        this.engine = engine;
        this.engine.register(TalkLocalEvent.class, this::onTalkLocal);
    }

    private void onTalkLocal(TalkLocalEvent event) {
        this.engine.send(PacketFactory.talkLocal(event.getMessage()));
    }


    @Override
    public void update() {

    }

    @Override
    public void onEnd() {
        this.engine.unregister(TalkLocalEvent.class, this::onTalkLocal);
    }
}
