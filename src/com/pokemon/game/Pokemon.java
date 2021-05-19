package com.pokemon.game;

import de.gurkenlabs.litiengine.graphics.Spritesheet;

public class Pokemon {
    public int id;
    public String name;
    public int HP;
    public int attack1;
    public int attack2;
    public Spritesheet sprite;

    public Pokemon(int id, String name, int HP, int attack1, int attack2, Spritesheet sprite) {
        this.id = id;
        this.name = name;
        this.HP = HP;
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.sprite = sprite;
    }
}

