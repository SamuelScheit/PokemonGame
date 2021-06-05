package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.resources.Resources;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        DbConnection.connect();
        Game.setInfo("assets/gameinfo.xml");
        Game.init(args);
        Resources.load("assets/game.litidata");
        Game.addGameListener(new Listener());
        Game.screens().add(new Pausescreen());
        Game.screens().add(new FightScreen());
        Game.screens().add(new InGameScreen());
        Game.screens().add(new InventoryScreen());
        Game.screens().add(new SelectPokemonScreen());
        Game.screens().add(new HealScreen());
        GameLogic.init();
        PlayerInput.init();
        Game.screens().display(InGameScreen.NAME);

        Game.start();
    }
}
