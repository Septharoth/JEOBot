package com.github.ntsee.jeobot.scripts;

import com.github.ntsee.jeobot.EOEngine;

public interface Script {

    void onStart(EOEngine engine);
    void update();
    void onEnd();
}
