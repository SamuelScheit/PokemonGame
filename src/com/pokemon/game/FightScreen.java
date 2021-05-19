package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.graphics.ShapeRenderer;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.GuiComponent;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.resources.Resources;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.util.LinkedList;

public class FightScreen extends GameScreen {
    ImageComponent infobackground1;
    LinkedList<GuiComponent> attackbuttons;
    Pokemon test1;

    public FightScreen() throws IOException {
        super("fight");
        attackbuttons = new LinkedList<>();
        test1 = GameStatus.instance().db.getPokemon("1");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


        int HPWidth = 100;

        // ImageRenderer.renderScaled(g, background, 0, 0, 4);

        Font font = new Font("Impact", Font.PLAIN, 24);
        g.setFont(font);

        GradientPaint hpGradient = new GradientPaint(0f, 0f, new Color(0, 179, 36), 0f, 10f, new Color(0, 237, 48));

        GradientPaint greyGradient = new GradientPaint(0f, 0f, new Color(112, 112, 112), 0f, 200f, new Color(56, 56, 56));

        // info background 1
        g.setPaint(greyGradient);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(-30, 100, 380, 100, 30, 30));

        // info background 2
        ShapeRenderer.render(g, new RoundRectangle2D.Double(740, 400, 350, 100, 30, 30));

        // pokemon name 1
        g.setColor(Color.WHITE);
        TextRenderer.render(g, "Pokemonname", 20, 130);
        // pokemon name 2
        TextRenderer.render(g, "Pokemonname", 760, 430);

        // pokemon Level 1
        FightScreen.drawRightString("Lvl. 1", 330, 130, g);
        // pokemon Level 2
        FightScreen.drawRightString("Lvl. 1", 1050, 430, g);

        // hp background 1
        g.setColor(new Color(41, 41, 41));
        ShapeRenderer.render(g, new RoundRectangle2D.Double(200, 160, 140, 30, 10, 10));
        // hp background 2
        ShapeRenderer.render(g, new RoundRectangle2D.Double(930, 460, 140, 30, 10, 10));

        // hp bar 1
        g.setPaint(hpGradient);
        ShapeRenderer.render(g, new Rectangle(235, 165, HPWidth, 20));
        // hp bar 2
        ShapeRenderer.render(g, new Rectangle(965, 465, HPWidth, 20));

        // HP Text 1
        g.setColor(new Color(255, 174, 0));
        TextRenderer.render(g, "HP", 205, 185);
        // HP Text 2
        TextRenderer.render(g, "HP", 935, 485);

        // lower background
        g.setPaint(greyGradient);
        // ShapeRenderer.render(g, new Rectangle(0, 550, 1100, 500));

        // text box
        g.setColor(Color.WHITE);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(20, 570, 500, 130, 20, 20));

        font = new Font("Arial", Font.PLAIN, 30);
        g.setFont(font);

        // text in textbox
        g.setColor(Color.BLACK);
        TextRenderer.renderWithLinebreaks(g, "What will Pikachu do?", 40, 600, 450, true);

        /*
        g.setColor(Color.RED);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(580, 570, 200, 50, 20, 20));

        g.setColor(Color.BLUE);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(800, 570, 200, 50, 20, 20));

        g.setColor(Color.GREEN);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(800, 650, 200, 50, 20, 20));

        g.setColor(Color.YELLOW);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(580, 650, 200, 50, 20, 20));
         */

        g.drawImage(test1.sprite.getImage(), 0, 0, null);
    }

    @Override
    protected void initializeComponents() {
        if (attackbuttons == null) attackbuttons = new LinkedList<>();

        infobackground1 = new ImageComponent(0, 0, 1100, 550);
        infobackground1.setSpriteSheet(Resources.spritesheets().get("fightscreen"));

        attackbuttons.add(new ImageComponent(580, 570, 200, 50));
        attackbuttons.add(new ImageComponent(800, 570, 200, 50));
        attackbuttons.add(new ImageComponent(800, 650, 200, 50));
        attackbuttons.add(new ImageComponent(580, 650, 200, 50));

        for (var button : attackbuttons) {
            button.setText("test");
            button.getAppearance().setBackgroundColor1(Color.GREEN);
            button.getAppearanceHovered().setBackgroundColor1(Color.BLUE);
            this.getComponents().add(button);
        }

        this.getComponents().add(infobackground1);

        this.initEvents();
    }

    private void initEvents() {
        for (var button : attackbuttons) {
            button.onClicked(e -> {
                button.setHovered(true);
            });
        }
    }

    public static void drawRightString(String s, int x, int y, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        x = (x - fm.stringWidth(s));
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
