package com.example.TrainingGround;

import com.example.TrainingGround.utils.Mortal;

abstract public class Enemy implements Mortal {
    private int health;
    private int mana;

    public Enemy(int health, int mana) {
        this.health = health;
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        if(this.health >0)
            return true;
        else {
            deth();
            return false;
        }
    }

    public void attackHero(Hero hero){}

    public void takeDamage(int damage) {
        setHealth(this.health - damage);
    }

    public void deth(){
    }

    public void applyingAbility(Hero hero, Enum e){}
}
