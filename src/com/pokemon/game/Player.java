package com.pokemon.game;

import de.gurkenlabs.litiengine.IUpdateable;
import de.gurkenlabs.litiengine.entities.*;
import de.gurkenlabs.litiengine.input.PlatformingMovementController;

@EntityInfo(width = 18, height = 18)
@MovementInfo(velocity = 70)
@CollisionInfo(collisionBoxWidth = 8, collisionBoxHeight = 16, collision = true)
public class Player extends Creature implements IUpdateable {

    private static Player instance;
    private int consecutiveJumps;

    public static Player instance() {
        if (instance == null) {
            instance = new Player();
        }

        return instance;
    }

    private Player() {
        super("gurknukem");
        // setup movement controller
        this.addController(new PlatformingMovementController<>(this));
    }

    @Override public void update() {

    }
}
