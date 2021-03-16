package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.environment.tilemap.IMapImage;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.gui.screens.Resolution;

import java.awt.*;



public class Startscreen extends GameScreen {
    public Startscreen() {
        super("SC");
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);

        g.setColor(Color.RED);
        Game.graphics().renderText(g, "Pokemon", 300,100);

        g.setColor(Color.BLUE);
        Game.graphics().renderText(g, "New Game", 500,150);

        g.setColor(Color.BLUE);
        Game.graphics().renderText(g, "Load Game", 510,200);

        g.setColor(Color.BLUE);
        Game.graphics().renderText(g, "Settings", 520,250);

        g.setColor(Color.BLUE);
        Game.graphics().renderText(g, "Quit Game", 530,300);


    }

    public void setFontSize(){
    }




}