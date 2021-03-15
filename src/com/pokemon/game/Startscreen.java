package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.gui.screens.Resolution;

import java.awt.*;

public class Startscreen extends GameScreen {
    public Startscreen() {
        super("start");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);

        g.setColor(Color.RED);
        Game.graphics().renderText(g, "my text", 0,0);

    }


}