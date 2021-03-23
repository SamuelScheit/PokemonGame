package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;

import javax.swing.*;
import java.awt.*;

public class Pausescreen extends GameScreen {
    public Pausescreen() {
        super("PAUSE");
    }

    private JPanel mainpanel;

        /*public Pausescreen(String title)

        {
            super(title);

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setContentPane(mainpanel);
            this.pack();
        }
*/
        public static void main(String[] args) {
            GameScreen frame = new Pausescreen("Pausescreen");
            frame.setVisible(true);
        }
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
