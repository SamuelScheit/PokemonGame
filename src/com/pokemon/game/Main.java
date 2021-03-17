package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;

public class Main {
    public static void main(String[] args) {
        Game.setInfo("assets/gameinfo.xml");
        Game.init(args);
        Resources.load("assets/game.litidata");
        GameStatus status = new GameStatus(true);
        Game.addGameListener(new Listener());
        Game.screens().add(new Pausescreen());
//        Game.screens().display("TEST");
        Game.world().loadEnvironment("map1");
        GameLogic.init();

        Game.start();
    }
}
