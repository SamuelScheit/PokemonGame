package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.GameListener;

public class Listener implements GameListener {
    @Override
    public void initialized(String... args) {
        // do sth when game is initialized
        System.out.println("initialized");

    }

    @Override
    public void started() {
        // do sth when game started
    }

    @Override
    public void terminated() {
        // do sth when game terminated
    }
}
