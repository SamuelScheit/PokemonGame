package com.pokemon.game;

import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import java.awt.*;
import java.util.LinkedList;

public class InventoryScreen extends GameScreen {
    public static String NAME = "inventory";
    private LinkedList<String> items = new LinkedList<String>();

    public InventoryScreen() {
        super(InventoryScreen.NAME);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }

    @Override
    protected void initializeComponents() {

    }

    @Override
    public void prepare() {
        super.prepare();
        GameStatus.instance().setIngame(false);
    }
}
