package com.pokemon.game;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.Valign;
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

        g.setFont(new Font("Arial", Font.PLAIN, 35));

        g.setColor(Color.BLACK);

        String nextDialog = GameStatus.instance().getNextDialog();
        if (nextDialog != null) {
            ImageRenderer.renderScaled(g, Resources.spritesheets().get("chatbox").getImage(), 100, 420, 1);
            TextRenderer.renderWithLinebreaks(g, nextDialog, Align.LEFT, Valign.TOP, 160, 480, 800, 300, true);
        }
    }

    @Override
    public void prepare() {
        super.prepare();
        GameStatus.instance().setIngame(true);
    }



}
