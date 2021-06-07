package com.pokemon.game;

import de.gurkenlabs.litiengine.graphics.Spritesheet;

public class Pokemon {
    public int id;
    public String name;
    public int HP;
    public Attack attack1;
    public Attack attack2;
    public Spritesheet sprite;
    public Spritesheet spriteAttack;
    public Spritesheet spriteDamage;

    public Pokemon(int id, String name, int HP, Attack attack1, Attack attack2, Spritesheet sprite, Spritesheet attackSprite, Spritesheet damageSprite) {
        this.id = id;
        this.name = name;
        this.HP = HP;
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.sprite = sprite;
        this.spriteAttack = attackSprite;
        this.spriteDamage = damageSprite;
    }
}

