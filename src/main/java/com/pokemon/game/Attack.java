package com.pokemon.game;

import de.gurkenlabs.litiengine.graphics.Spritesheet;

public class Attack {
    public int id;
    public int damage;
    public String name;
    public Spritesheet sprite;

    public Attack(int id, String attackName, int attackDMG) {
        this.name = attackName;
        this.id = id;
        this.damage = attackDMG;
    }
}


