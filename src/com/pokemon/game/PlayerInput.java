package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.input.Input;

import java.awt.event.KeyEvent;

public class PlayerInput {
    public static void init() {
        // make the game exit upon pressing ESCAPE (by default there is no such key binding and the window needs to be shutdown otherwise, e.g. ALT-F4 on Windows)
        Input.keyboard().onKeyTyped(KeyEvent.VK_G, e -> Game.screens().display("ingame"));

        Input.keyboard().onKeyTyped(KeyEvent.VK_I, e -> GameStatus.instance().triggerDialog());

    }
}
