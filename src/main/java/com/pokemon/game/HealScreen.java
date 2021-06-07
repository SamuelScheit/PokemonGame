package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.input.Input;

import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;

public class HealScreen extends GameScreen {
    public static String NAME = "heal";
    ArrayList<Pokemon> inventory;
    public int selected = 0;
    private boolean gettingHealed = false;

    private void heal(Pokemon pokemon) {
        pokemon.HP++;
        Game.loop().perform(25, () -> {
            if (Game.screens().current() == this && pokemon.HP < 100 && gettingHealed) {
                this.heal(pokemon);
            } else {
                gettingHealed = false;
            }
        });
    }

    public HealScreen() {
        super(HealScreen.NAME);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        Font impact = new Font("Impact", Font.PLAIN, 24);
        Font arial = new Font("Arial", Font.PLAIN, 30);
        g.setFont(arial);

        if (inventory.size() == 0) {
            TextRenderer.render(g, "Kehre zurück, wenn du ein Pokemon gefangen hast.", 220, 300);
            return;
        }

        TextRenderer.render(g, "Wähle das zu heilende Pokemon aus:", 330, 100);

        int y = 200;
        int i = 0;

        for (Pokemon pokemon : inventory) {
            g.setPaint(Color.WHITE);
            BufferedImage image = pokemon.sprite.getImage();
            if (selected != i) {
                image = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null).filter(image, null);
                g.setPaint(Color.GRAY);
            }

            g.setFont(impact);
            TextRenderer.render(g, pokemon.name, 100, y);

            ImageRenderer.renderScaled(g, image, 200, y - 50, 3);
            g.setFont(arial);
            if (gettingHealed && selected == i) g.setPaint(new Color(0, 201, 0));
            TextRenderer.render(g, "HP: " + pokemon.HP, 400, y);

            y += 100;
            i++;
        }
    }

    @Override
    protected void initializeComponents() {
        super.initializeComponents();
        inventory = GameStatus.instance().db.getInventory();

        Input.keyboard().onKeyTyped(e -> {
            if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                if (gettingHealed) {
                    gettingHealed = false;
                    return;
                }
                Pokemon pokemon = inventory.get(selected);
                gettingHealed = true;
                this.heal(pokemon);
            }
        });

        Input.keyboard().onKeyTyped(KeyEvent.VK_ESCAPE, e -> {
            gettingHealed = false;
            Game.screens().display(InGameScreen.NAME);
        });

        Input.keyboard().onKeyTyped(KeyEvent.VK_DOWN, e -> {
            if (gettingHealed || inventory == null) return;
            selected++;
            if (selected >= inventory.size()) selected = 0;
        });

        Input.keyboard().onKeyTyped(KeyEvent.VK_UP, e -> {
            if (gettingHealed || inventory == null) return;
            selected--;
            if (selected < 0) selected = inventory.size() - 1;
        });
    }

    @Override
    public void prepare() {
        super.prepare();
        inventory = GameStatus.instance().db.getInventory();

        GameStatus.instance().setIngame(false);
        Game.world().unloadEnvironment();
    }

    public void suspend() {
        for (Pokemon p : inventory) {
            GameStatus.instance().db.updateHP(p.id, p.HP);
        }
    }

}
