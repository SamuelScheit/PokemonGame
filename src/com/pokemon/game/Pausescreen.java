package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import java.awt.*;

public class Pausescreen extends GameScreen {
    public Pausescreen() {
        super("PAUSE");
    }



    public void toggle() {
        // TODO toggle
        Game.screens().display("PAUSE");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);


        g.setFont(new Font("Arial",Font.PLAIN,40));

        g.setColor(Color.red);
        TextRenderer.render(g, "Pause", 800,150);


        g.setColor(Color.yellow);
        TextRenderer.render(g, "Resume", 810,230);

        g.setColor(Color.yellow);
        TextRenderer.render(g, "Settings", 820,300);

        g.setColor(Color.yellow);
        TextRenderer.render(g, "Back to Title", 830,370);

        g.setColor(Color.yellow);
        TextRenderer.render(g, "Quit Game",840,440);

    }
}
