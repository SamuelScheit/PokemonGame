package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;
import de.gurkenlabs.litiengine.resources.Resources;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Pausescreen extends GameScreen {
    KeyboardMenu menu;
    String[] menuEntries;

    public static final String NAME = "Pausescreen";

    public Pausescreen() {
        super(Pausescreen.NAME);
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }

    public Screen lastScreen;

    public void toggle() {
        if (Game.screens().current() == this && lastScreen != null) {
            Game.screens().display(lastScreen);
            return;
        }
        lastScreen = Game.screens().current();
        Game.screens().display(this);
        System.out.println("pause menu active");
    }

    @Override
    public void prepare() {
        super.prepare();
        GameStatus.instance().setIngame(false);
    }

    @Override
    protected void initializeComponents() {
        // This method is called once by the Screen's constructor. Use it to initialize the GuiComponents that will be contained by this screen.
        // Don't forget to call this.getComponents().add(GuiComponent c) so that the components will actually be rendered.
        super.initializeComponents();

        final double centerX = Game.window().getResolution().getWidth() / 2;
        final double centerY = Game.window().getResolution().getHeight() / 2;
        final double buttonWidth = 450;

        Color backdropColor = new Color(0, 0, 0, 100);
        ImageComponent backdrop = new ImageComponent(0, 0, Game.window().getWidth(), Game.window().getHeight());
        backdrop.getAppearance().setTransparentBackground(false);
        backdrop.getAppearance().setBackgroundColor1(backdropColor);
        backdrop.getAppearanceHovered().setTransparentBackground(false);
        backdrop.getAppearanceHovered().setBackgroundColor1(backdropColor);

        menuEntries = new String[]{"Fortsetzen", "Spiel beenden"};

        Image headlineImage = Resources.images().get("assets/headlines/pause.png");
        ImageComponent headline = new ImageComponent(0, 0, headlineImage);

        headline.setX(centerX - headline.getWidth() / 2);
        headline.setY(centerY - headline.getHeight() - 50);

        menu = new KeyboardMenu(centerX - buttonWidth / 2, centerY * 1, buttonWidth, centerY / 2, menuEntries);

        menu.onConfirm(index -> {
            System.out.println(index + " " + menuEntries[index]);
            switch (index) {
                case 0: // resume
                    this.toggle();
                    return;
                case 3: // quite game
//                    TODO: save game
                    Game.exit();
                    return;
            }
        });

        Input.keyboard().onKeyTyped(KeyEvent.VK_ESCAPE, e -> {
            System.out.println("pause toggle");
            this.toggle();
        });

        this.getComponents().add(backdrop);
        this.getComponents().add(menu);
        this.getComponents().add(headline);
    }

}
