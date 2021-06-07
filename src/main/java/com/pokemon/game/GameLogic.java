package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.Spawnpoint;
import de.gurkenlabs.litiengine.entities.Trigger;
import de.gurkenlabs.litiengine.graphics.Camera;
import de.gurkenlabs.litiengine.graphics.PositionLockCamera;

import javax.swing.*;

public class GameLogic {


    public static void init() {
        // we'll use a camera in our game that is locked to the location of the player
        Camera camera = new PositionLockCamera(Player.instance());
        camera.setClampToMap(true);
        Game.world().setCamera(camera);
        Game.screens().setChangeCooldown(0);
        Game.graphics().setBaseRenderScale(4.001f);
        ((JFrame) Game.window().getHostControl()).setResizable(false);
        //GameStatus.instance().db.insertAttack(1, "Glut", 10);
        PokemonTriggerListener listener = new PokemonTriggerListener();

        // Game.world().setGravity(120);

        Game.world().onLoaded(e -> {
            Game.world().camera().updateFocus();
            System.out.println("world loaded: " + e.getMap().getName());
            // spawn the player instance on the spawn point with the name "enter"
            Spawnpoint enter = e.getSpawnpoint(GameStatus.instance().spawnpoint);
            if (enter != null) {
                enter.spawn(Player.instance());
            }

            for (Trigger t : Game.world().environment().getTriggers()) {
                t.removeTriggerListener(listener);
                t.addTriggerListener(listener);
            }
        });

        Game.world().loadEnvironment("StarterhausInnen");
    }
}
