package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import javax.swing.*;
import java.awt.*;

public class Pausescreen extends GameScreen {
    public Pausescreen() {
        super("PAUSE");
    }

    public static class GUI {
        private JPanel panel1;
        private JButton quitGameButton;
        private JButton returnToHomeButton;
        private JButton settingsButton;
        private JButton resumeButton;
        private JTextField PAUSETextField;

        private void createUIComponents() {
            // TODO: place custom component creation code here
        }
    }
