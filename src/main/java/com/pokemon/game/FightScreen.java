package com.pokemon.game;

import de.gurkenlabs.litiengine.Game;
import de.gurkenlabs.litiengine.graphics.ImageRenderer;
import de.gurkenlabs.litiengine.graphics.ShapeRenderer;
import de.gurkenlabs.litiengine.graphics.TextRenderer;
import de.gurkenlabs.litiengine.gui.ImageComponent;
import de.gurkenlabs.litiengine.gui.screens.GameScreen;
import de.gurkenlabs.litiengine.resources.Resources;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class FightScreen extends GameScreen {
    ImageComponent infobackground1;
    LinkedList<ImageComponent> attackbuttons;
    Pokemon pokemon1;
    Pokemon pokemon2;
    Attack attack;
    Pokemon turn;
    AttackParticleEmitter particles;

    public final static String NAME = "fight";

    public FightScreen() {
        super(FightScreen.NAME);
        turn = pokemon1;
    }

    @Override
    public void render(final Graphics2D g) {
        super.render(g);

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Font font = new Font("Impact", Font.PLAIN, 24);
        g.setFont(font);

        GradientPaint hpGradient = new GradientPaint(0f, 0f, new Color(0, 179, 36), 0f, 10f, new Color(0, 237, 48));
        GradientPaint greyGradient = new GradientPaint(0f, 0f, new Color(112, 112, 112), 0f, 200f, new Color(56, 56, 56));

        // info background 1
        g.setPaint(greyGradient);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(-30, 100, 380, 100, 30, 30));
        // info background 2
        ShapeRenderer.render(g, new RoundRectangle2D.Double(740, 400, 350, 100, 30, 30));

        // pokemon name 1
        g.setColor(Color.WHITE);
        TextRenderer.render(g, pokemon1.name, 20, 130);
        // pokemon name 2
        TextRenderer.render(g, pokemon2.name, 760, 430);

        // pokemon Level 1
        FightScreen.drawRightString("Lvl. 1", 330, 130, g);
        // pokemon Level 2
        FightScreen.drawRightString("Lvl. 1", 1050, 430, g);

        // hp background 1
        g.setColor(new Color(41, 41, 41));
        ShapeRenderer.render(g, new RoundRectangle2D.Double(200, 160, 140, 30, 10, 10));
        // hp background 2
        ShapeRenderer.render(g, new RoundRectangle2D.Double(930, 460, 140, 30, 10, 10));

        // hp bar 1
        g.setPaint(hpGradient);
        ShapeRenderer.render(g, new Rectangle(235, 165, pokemon1.HP, 20));
        // hp bar 2
        ShapeRenderer.render(g, new Rectangle(965, 465, pokemon2.HP, 20));

        // HP Text 1
        g.setColor(new Color(255, 174, 0));
        TextRenderer.render(g, "HP", 205, 185);
        // HP Text 2
        TextRenderer.render(g, "HP", 935, 485);

        // lower background
//        g.setPaint(greyGradient);
//        ShapeRenderer.render(g, new Rectangle(0, 550, 1100, 500));

        // text box
        g.setColor(Color.WHITE);
        ShapeRenderer.render(g, new RoundRectangle2D.Double(20, 570, 500, 130, 20, 20));

        font = new Font("Arial", Font.PLAIN, 30);
        g.setFont(font);

        // text in textbox
        g.setColor(Color.BLACK);
        String text = "";
        if (turn != null) {
            if (attack != null) {
                text = turn.name + " setzt " + attack.name + " ein!";
            } else if (turn == pokemon1) {
                text = "Wähle eine Attacke aus!";
            } else {
                text = turn.name + " ist am Zug";
            }
        }
        if (pokemon2.HP <= 0) {
            text = "Du hast gewonnen!";
        }
        if (pokemon1.HP <= 0) {
            text = "Du hast verloren!";
        }

        TextRenderer.renderWithLinebreaks(g, text, 40, 600, 450, true);

        BufferedImage s1 = attack != null ? (turn == pokemon1 ? pokemon1.spriteAttack.getImage() : pokemon1.spriteDamage.getImage()) : pokemon1.sprite.getImage();
        BufferedImage s2 = attack != null ? (turn == pokemon2 ? pokemon2.spriteAttack.getImage() : pokemon2.spriteDamage.getImage()) : pokemon2.sprite.getImage();

        ImageRenderer.renderScaled(g, s1, 80, 340, 7);
        ImageRenderer.renderScaled(g, s2, 690, 100, 7);

        if (attack != null && particles != null) {
            particles.createNewParticle().render(g, new Point2D.Double(300, 300));
        }
    }

    @Override
    protected void initializeComponents() {
        attackbuttons = new LinkedList<>();

        infobackground1 = new ImageComponent(0, 0, 1100, 550);
        infobackground1.setSpriteSheet(Resources.spritesheets().get("battlescreen"));


        ImageComponent background = new ImageComponent(0, 550, 1100, 500);
        background.getAppearance().setBackgroundColor1(new Color(112, 112, 112));
        background.getAppearance().setBackgroundColor2(new Color(56, 56, 56));
        background.getAppearance().setTransparentBackground(false);
        background.onHovered((event) -> background.setHovered(false));
        this.getComponents().add(background);

        ImageComponent attack1 = new ImageComponent(580, 600, 200, 50);
        ImageComponent attack2 = new ImageComponent(800, 600, 200, 50);

        attackbuttons.add(attack1);
        attackbuttons.add(attack2);

        for (ImageComponent button : attackbuttons) {
            button.setFont(new Font("Arial", Font.PLAIN, 35));
            button.getAppearance().setTransparentBackground(false);
            button.getAppearance().setBackgroundColor1(new Color(61, 61, 61));
            button.getAppearance().setBorderRadius(10);
            button.getAppearanceHovered().setBackgroundColor1(new Color(51, 51, 51));
            button.getAppearanceHovered().setTransparentBackground(false);
            button.getAppearanceHovered().setBorderRadius(10);

            this.getComponents().add(button);
        }

        this.getComponents().add(infobackground1);

        this.initEvents();
    }

    private void initEvents() {
        for (ImageComponent button : attackbuttons) {
            button.onClicked(e -> {
                System.out.println(button);

                for (ImageComponent b : attackbuttons) {
                    b.setEnabled(false);
                }
                int i = attackbuttons.indexOf(button);

                if (i == 0) {
                    attack = pokemon1.attack1;
                } else {
                    attack = pokemon1.attack2;
                }

                handleAttack();

            });

        }
    }

    public void handleAttack() {
//        Game.world().environment().add();

        Pokemon attackedPokemon = turn == pokemon1 ? pokemon2 : pokemon1;
//        Game.world().camera().shake(10, 30, 1000);

        try {
            attackedPokemon.HP = Math.max(attackedPokemon.HP - attack.damage, 0);
            GameStatus.instance().db.updateHP(attackedPokemon.id, attackedPokemon.HP);

            Game.loop().perform(250, () -> {

                attack = null;
                if (attackedPokemon.HP <= 0) return;
                if (turn == pokemon1) {
                    turn = pokemon2;
                } else {
                    turn = pokemon1;
                    for (ImageComponent b : attackbuttons) {
                        b.setEnabled(true);
                    }
                }
            });

            Game.loop().perform(500, () -> {
                if (attackedPokemon.HP <= 0) {
                    Game.screens().display(InGameScreen.NAME);
                    return;
                }

                if (turn == pokemon2) {
                    if (Math.random() > 0.5) attack = turn.attack1;
                    else attack = turn.attack2;

                    this.handleAttack();
                }
            });
        } catch (Exception e) {
        }
    }

    public static void drawRightString(String s, int x, int y, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        x = (x - fm.stringWidth(s));
        g.drawString(s, x, y);
    }

    @Override
    public void prepare() {
        super.prepare();
        try {
            particles = new AttackParticleEmitter(Player.instance());
        } catch (Exception e) {
        }

        GameStatus.instance().setIngame(false);
        System.out.println("show fight screen");

        turn = pokemon1;

        attackbuttons.get(0).setText(pokemon1.attack1.name);
        System.out.println(pokemon1.attack1.name);
        attackbuttons.get(1).setText(pokemon1.attack2.name);
    }
}
