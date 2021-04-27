package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class FightScreen extends GameScreen {
    public FightScreen() {
        super("fight");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);

        Game.graphics().renderShape(g, new Rectangle2D.Double(50, 100, 50, 50));
    }

    @Override
    public void prepare() {
        super.prepare();
        GameStatus.instance().setIngame(false);
    }


}
