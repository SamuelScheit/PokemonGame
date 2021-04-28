package com.pokemon.game;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.graphics.ShapeRenderer;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

public class FightScreen extends GameScreen {
    public FightScreen() {
        super("fight");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int HPWidth = 100;

        Font font = new Font("Impact", Font.PLAIN, 24);
        g.setFont(font);

        GradientPaint hpGradient = new GradientPaint(0f, 0f, new Color(0, 179, 36), 0f, 10f, new Color(0, 237, 48));

        GradientPaint greyGradient = new GradientPaint(0f, 0f, new Color(112, 112, 112), 0f, 200f, new Color(56, 56, 56));

        // info background
        g.setPaint(greyGradient);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(-30, 100, 380, 100, 30, 30));

        // pokemon name
        g.setColor(Color.WHITE);
        TextRenderer.render(g, "Pokemonname", 20, 130);

        // Level
        FightScreen.drawRightString("Lvl. 1", 330, 130, g);

        // hp background
        g.setColor(new Color(41, 41, 41));
        ShapeRenderer.render(g, new RoundRectangle2D.Double(200, 160, 140, 30, 10, 10));

        // hp bar
        g.setPaint(hpGradient);
        ShapeRenderer.render(g, new Rectangle(235, 165, HPWidth, 20));

        // HP Text
        g.setColor(new Color(255, 174, 0));
        TextRenderer.render(g, "HP", 205, 185);

        // lower background
        g.setPaint(greyGradient);
        ShapeRenderer.render(g, new Rectangle(0, 550, 2000, 500));

        // text box
        g.setColor(Color.WHITE);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(20, 570, 500, 130, 20, 20));

        font = new Font("Arial", Font.PLAIN, 30);
        g.setFont(font);

        // text in textbox
        g.setColor(Color.BLACK);
        TextRenderer.renderWithLinebreaks(g, "What will Pikachu do?", 40, 600, 450, true);

        g.setColor(Color.RED);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(580, 570, 200,50,20,20));

        g.setColor(Color.BLUE);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(800, 570, 200,50,20,20));

        g.setColor(Color.GREEN);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(800, 650, 200,50,20,20));

        g.setColor(Color.YELLOW);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(580, 650, 200,50,20,20));
    }

    public static void drawRightString(String s, int w, int y, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        int x = (w - fm.stringWidth(s));
        g.drawString(s, x, y);
    }

    @Override
    public void prepare() {
        super.prepare();

        GameStatus.instance().setIngame(false);
        Game.world().unloadEnvironment();
        System.out.println("show fight screen");
    }
}
