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

