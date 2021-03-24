package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.tilemap.IMapImage;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.gui.screens.Resolution;

import javax.swing.*;
import java.awt.*;

public class Startscreen extends GameScreen {
    private JButton Start;

    public Startscreen() {
        super("SC");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);

        g.setFont(new Font("Arial",Font.PLAIN,50));

        g.setColor(Color.RED);
        TextRenderer.render(g, "Pokemon", 300,100);

        g.setColor(Color.BLUE);
        TextRenderer.render(g, "New Game", 500,150);

        g.setColor(Color.BLUE);
        TextRenderer.render(g, "Load Game", 500,200);

        g.setColor(Color.BLUE);
        TextRenderer.render(g, "Settings", 500,250);

        g.setColor(Color.BLUE);
        TextRenderer.render(g, "Quit Game", 500,300);
    }
}
