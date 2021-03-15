package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.tilemap.xml.Text;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.TextFieldComponent;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class InGameScreen extends GameScreen {
    private GameStatus gameStatus;
    public InGameScreen() {
        super("ingame");
        gameStatus = status;
    }


    @Override
    public void render(final Graphics2D g) {
        super.render(g);

        g.setColor(Color.RED);
        Game.graphics().renderText(g, "my text", 225, 140);
        if (gameStatus.isStartup()) {
            String nextDialog = gameStatus.getNextDialog();
            if(nextDialog != null) {
                Rectangle2D rectangle = new Rectangle();
                rectangle.setRect(300, 140, 150, 50);
                Game.graphics().renderOutline(g, rectangle);
                TextRenderer.render(g, nextDialog, 350, 140);
            }
        }
    }
}
