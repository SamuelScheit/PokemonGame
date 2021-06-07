package com.pokemon.game;

import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import java.awt.*;

public class SettingsScreen extends GameScreen {
    public static String NAME = "settings";

    public SettingsScreen() {
        super(SettingsScreen.NAME);
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
