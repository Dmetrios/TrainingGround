package com.example.TrainingGround;

abstract public class Hero implements Mortal {

    private String name;
    private int health;
    private int mana;

    public Hero(String name, int health, int mana) {
        this.name = name;
        this.health = health;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isAlive() {
        if(this.health >= 0)
            return true;
        else {
            death();
            return false;
        }
    }

    public void death(){
    }

    public void attackEnemy(Enemy enemy){
        System.out.println("Атакует противника");
    }

    public void applyingAbility(Enemy enemy, Enum e){
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage){
        setHealth(this.health-damage);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}
