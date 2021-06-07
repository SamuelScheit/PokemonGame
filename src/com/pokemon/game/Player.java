package com.pokemon.game;

import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.*;
import de.gurkenlabs.litiengine.input.KeyboardEntityController;
import de.gurkenlabs.litiengine.physics.IMovementController;
import de.gurkenlabs.litiengine.physics.MovementController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

@EntityInfo(width = 16, height = 32)
@MovementInfo(velocity = 350)
@CollisionInfo(collisionBoxWidth = 16, collisionBoxHeight = 16, collision = true)
public class Player extends Creature implements IUpdateable {
    private static Player instance;
    public ArrayList<Pokemon> inventory;

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
        movementController.onMovementCheck(e -> GameStatus.instance().isIngame() && GameStatus.instance().isMovementAllowed());

        this.setController(IMovementController.class, movementController);
        inventory = GameStatus.instance().db.getInventory();
    }

    @Override
    public void update() {

    }
}


