package com.pokemon.game;

import de.gurkenlabs.litiengine.Align;
import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.entities.EmitterInfo;
import de.gurkenlabs.litiengine.entities.EntityInfo;
import de.gurkenlabs.litiengine.entities.IEntity;
import de.gurkenlabs.litiengine.graphics.RenderType;
import de.gurkenlabs.litiengine.graphics.emitters.EntityEmitter;
import de.gurkenlabs.litiengine.graphics.emitters.particles.Particle;
import de.gurkenlabs.litiengine.graphics.emitters.particles.RectangleParticle;
import de.gurkenlabs.litiengine.physics.Collision;

import java.awt.*;

@EmitterInfo(originAlign = Align.LEFT, particleMinTTL = 200, particleMaxTTL = 500, spawnRate = 100, spawnAmount = 20, maxParticles = 80)
@EntityInfo(renderType = RenderType.OVERLAY)
public class AttackParticleEmitter extends EntityEmitter {
    public AttackParticleEmitter(IEntity entity) {
        super(entity);

        this.setWidth(Game.world().environment().getMap().getSizeInPixels().getWidth());
        this.setHeight(Game.world().environment().getMap().getSizeInPixels().getHeight());
    }

    @Override
    protected Particle createNewParticle() {
        final float x = Game.random().nextFloat(30, 100);
        final float y = Game.random().nextFloat(30, 100);
        final float width = 2;
        final float height = 10;
        final float dx = Game.random().nextFloat(-1, 1);
        final float dy = Game.random().nextFloat(-1, 1);
        final float gravityX = 0;
        final float gravityY = Game.random().nextFloat(-.1f, .2f);
        final float deltaWidth = Game.random().nextFloat(.2f);
        final float deltaHeight = Game.random().nextFloat(.2f);

        return new RectangleParticle(width, height)
                .setColor(new Color(0, 0, 0, 100))
                .setTimeToLive(1000)
                .setVelocityX(dx)
                .setVelocityY(dy)
                .setAccelerationX(gravityX)
                .setAccelerationY(gravityY)
                .setX(x)
                .setY(y)
                .setDeltaWidth(deltaWidth)
                .setDeltaHeight(deltaHeight)
                .setCollisionType(Collision.NONE);
    }
}
