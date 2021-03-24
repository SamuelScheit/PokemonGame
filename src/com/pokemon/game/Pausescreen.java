package com.pokemon.game;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.Valign;
import de.gurkenlabs.litiengine.graphics.Spritesheet;
import de.gurkenlabs.litiengine.gui.GuiComponent;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.Menu;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.gui.screens.Screen;
import de.gurkenlabs.litiengine.input.Input;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;


public class Pausescreen extends GameScreen {
    GUI gui;

    public Pausescreen() {
        super("Pausescreen");
        lastScreen = Game.screens().current();
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
    }

    public Screen lastScreen;

    public void toggle() {
        if (Game.screens().current() == this) {
            Game.screens().display(lastScreen);
            return;
        }
        lastScreen = Game.screens().current();
        Game.screens().display(this);
        System.out.println("pause menu active");
    }

    @Override
    protected void initializeComponents() {
        // This method is called once by the Screen's constructor. Use it to initialize the GuiComponents that will be contained by this screen.
        // Don't forget to call this.getComponents().add(GuiComponent c) so that the components will actually be rendered.
        super.initializeComponents();
        gui = new GUI();

        final double centerX = Game.window().getResolution().getWidth() / 2.0;
        final double centerY = Game.window().getResolution().getHeight() * 1 / 2;
        final double buttonWidth = 450;

        Menu mainMenu = new Menu(centerX - buttonWidth / 2, centerY * 1.3, buttonWidth, centerY / 2, "Play", "Exit");

        Input.keyboard().onKeyTyped(KeyEvent.VK_ESCAPE, e -> {
            System.out.println("pause toggle");
            this.toggle();

        });

        this.getComponents().add(mainMenu);
    }

    private JPanel mainpanel;

    public class GUI {
        private JPanel panel1;
        private JButton quitGameButton;
        private JButton returnToHomeButton;
        private JButton settingsButton;
        private JButton resumeButton;
        private JButton pauseimage;

        public GUI() {
            quitGameButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Game.exit();
                }
            });
        }

        public JButton getQuitGameButton() {
            return quitGameButton;
        }

        public JPanel getPanel1() {
            return panel1;
        }

        public JButton getReturnToHomeButton() {
            return returnToHomeButton;
        }

        public JButton getResumeButton() {
            return resumeButton;
        }

        public JButton getSettingsButton() {
            return settingsButton;
        }

        public JTextField getpauseimage() {
            return pauseimage;
        }

        public boolean isModified(Pausescreen data) {
            return false;
        }
    }
}
