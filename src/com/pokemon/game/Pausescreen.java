package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.Menu;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Pausescreen extends GameScreen {
    KeyboardMenu menu;
    String[] menuEntries;

    public static String NAME = "Pausescreen";

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
        GameStatus.instance().setIngame(false);
        lastScreen = Game.screens().current();
        Game.screens().display(this);
        System.out.println("pause menu active");
    }

    @Override
    protected void initializeComponents() {
        // This method is called once by the Screen's constructor. Use it to initialize the GuiComponents that will be contained by this screen.
        // Don't forget to call this.getComponents().add(GuiComponent c) so that the components will actually be rendered.
        super.initializeComponents();

        final double centerX = Game.window().getResolution().getWidth() / 2.0;
        final double centerY = Game.window().getResolution().getHeight() * 1 / 2;
        final double buttonWidth = 450;
        menuEntries = new String[]{"Resume","Settings","Return to home", "Quit Game"};

        menu = new KeyboardMenu(centerX - buttonWidth / 2, centerY * 1.3, buttonWidth, centerY / 2, menuEntries);

        menu.onConfirm(index -> {
            System.out.println(index + " "+menuEntries[index]);
            switch (index) {
                case 0:
                    this.toggle();
                    return;
                case 1:
//                    TODO: settings screen
//                    Game.screens().display("settings");
                    return;
                case 2:
//                    TODO: home screen
                    return;
                case 3:
//                    TODO: save game
                    Game.exit();
                    return;
            }
        });

        Input.keyboard().onKeyTyped(KeyEvent.VK_ESCAPE, e -> {
            System.out.println("pause toggle");
            this.toggle();
        });

        this.getComponents().add(menu);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
