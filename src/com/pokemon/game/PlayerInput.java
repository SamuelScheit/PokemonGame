package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.input.Input;

import java.awt.event.KeyEvent;

public class PlayerInput {
    public static void init() {
        Input.keyboard().onKeyTyped(KeyEvent.VK_I, e -> GameStatus.instance().triggerDialog());
        Input.keyboard().onKeyTyped(KeyEvent.VK_G, e -> Game.screens().display(InGameScreen.NAME));
        Input.keyboard().onKeyTyped(KeyEvent.VK_O, e -> Game.screens().display(FightScreen.NAME));
        Input.keyboard().onKeyTyped(KeyEvent.VK_J, e -> Game.screens().display(SelectPokemonScreen.NAME));
        Input.keyboard().onKeyTyped(KeyEvent.VK_H, e -> Game.screens().display(HealScreen.NAME));
    }
}
