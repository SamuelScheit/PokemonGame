package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.tilemap.xml.Text;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.graphics.ShapeRenderer;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.TextFieldComponent;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.resources.Resource;
import de.gurkenlabs.litiengine.resources.Resources;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class InGameScreen extends GameScreen {
    public static String NAME = "ingame";

    public InGameScreen() {
        super(InGameScreen.NAME);
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);

        g.setFont(new Font("Arial", Font.PLAIN, 50));

        g.setColor(Color.BLACK);

        String nextDialog = GameStatus.instance().getNextDialog();
        if (nextDialog != null) {
            Rectangle2D rectangle = new Rectangle();
            rectangle.setRect(300, 140, 150, 50);
            Game.graphics().renderOutline(g, rectangle);
            TextRenderer.render(g, nextDialog, 100, 200);
            ImageRenderer.renderScaled(g, Resources.spritesheets().get("chatbox").getImage(), 100, 100, 0.5);
        }
    }

    @Override
    public void prepare() {
        super.prepare();
        GameStatus.instance().setIngame(true);
    }



}
