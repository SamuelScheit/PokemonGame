package com.pokemon.game;

import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.*;
import de.gurkenlabs.litiengine.input.KeyboardEntityController;
import de.gurkenlabs.litiengine.physics.IMovementController;

import java.awt.event.KeyEvent;

@EntityInfo(width = 32, height = 43)
@MovementInfo(velocity = 70)
@CollisionInfo(collisionBoxWidth = 32, collisionBoxHeight = 43, collision = true)
public class Player extends Creature implements IUpdateable {

    private static Player instance;

    public static Player instance() {
        if (instance == null) {
            instance = new Player();
        }

        return instance;
    }

    private Player() {
        super("character");
        // setup movement controller
        KeyboardEntityController<Player> movementController = new KeyboardEntityController<>(this);
        movementController.addUpKey(KeyEvent.VK_UP);
        movementController.addDownKey(KeyEvent.VK_DOWN);
        movementController.addLeftKey(KeyEvent.VK_LEFT);
        movementController.addRightKey(KeyEvent.VK_RIGHT);

        this.setController(IMovementController.class, movementController);
    }

    @Override public void update() {

    }
}
