package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import java.awt.*;

public class Pausescreen extends GameScreen {
    public Pausescreen() {
        super("PAUSE");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);

        g.setColor(Color.red);
        Game.graphics().renderText(g, "Pause", 275,50);


        g.setColor(Color.yellow);
        Game.graphics().renderText(g, "Resume", 275,120);

        g.setColor(Color.yellow);
        Game.graphics().renderText(g, "Settings", 275,170);

        g.setColor(Color.yellow);
        Game.graphics().renderText(g, "Return to Home", 275,220);

        g.setColor(Color.yellow);
        Game.graphics().renderText(g, "Quit Game",275,270, getClickConsumer().add(System.exit(0)));




    }
}
