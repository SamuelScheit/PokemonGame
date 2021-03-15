package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import java.awt.*;

public class TestScreen extends GameScreen {
    public TestScreen() {
        super("test");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);

        g.setColor(Color.RED);

        Game.graphics().renderText(g, "my text", 250,250);
    }
}
