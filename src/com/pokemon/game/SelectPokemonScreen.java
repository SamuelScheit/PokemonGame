package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.graphics.ShapeRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.input.Input;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;
import java.util.List;

public class SelectPokemonScreen extends GameScreen {
    Pokemon[] pokemons = new Pokemon[3];
    private int selected = 0;

    public static String NAME = "selectpokemon";

    public SelectPokemonScreen() {
        super(SelectPokemonScreen.NAME);

        pokemons[0] = GameStatus.instance().db.getPokemon("1");
        pokemons[1] = GameStatus.instance().db.getPokemon("2");
        pokemons[2] = GameStatus.instance().db.getPokemon("3");

        Input.keyboard().onKeyTyped(e -> {
            if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
            }
        });

        Input.keyboard().onKeyTyped(KeyEvent.VK_LEFT, e -> {
            selected--;
            if (selected < 0) selected = 2;
        });

        Input.keyboard().onKeyTyped(KeyEvent.VK_RIGHT, e -> {
            selected++;
            if (selected > 2) selected = 0;
        });
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);

        int x = 90;
        int i = 0;

        for (Pokemon pokemon : pokemons) {
            if (selected == i) g.setPaint(new Color(100, 100, 100));
            else g.setPaint(new Color(41, 41, 41));

            ShapeRenderer.render(g, new Ellipse2D.Double(x + 30, 570, 180, 40));

            BufferedImage image = pokemon.sprite.getImage();
            if (selected != i) {
                image = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null).filter(image, null);
            }
            ImageRenderer.renderScaled(g, image, x, 400, 7);

            x += 360;
            i++;
        }

    }

    @Override
    protected void initializeComponents() {
        super.initializeComponents();
    }

    @Override
    public void prepare() {
        super.prepare();

        GameStatus.instance().setIngame(false);
        Game.world().unloadEnvironment();
    }
}