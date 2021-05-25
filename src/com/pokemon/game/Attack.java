package com.pokemon.game;

import de.gurkenlabs.litiengine.graphics.Spritesheet;

public class Attack {
    public int id;
    public int damage;
    public String name;
     public Spritesheet sprite;

    public Attack(String name, int id, int damage, Spritesheet sprite){
        this.name = name;
        this.id = id;
        this.damage = damage;
        this.sprite = sprite;
    }

    public Attack(String attackName, int id, int attackDMG) {
    }

    public Attack(int id, String attackName, int attackDMG, Spritesheet spritesheet) {
    }
}


