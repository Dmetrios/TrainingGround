package com.example.TrainingGround.HeroClasses;

import com.example.TrainingGround.Enemy;
import com.example.TrainingGround.EnumHeroAbilityClasses.MageAbility;
import com.example.TrainingGround.Hero;

public class Mage extends Hero {

    private int damage;
    private double criticalChance;

    public Mage(String name, int health, int mana, int damage, double criticalChance) {
        super(name, health, mana);
        this.damage = damage;
        this.criticalChance = criticalChance;
    }
    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()) {
            if (Math.random() * 100d > 100d - criticalChance)
                enemy.takeDamage(damage * 2);
            else enemy.takeDamage(damage);
        }
    }

    @Override
    public void death() {
        System.out.println("Умереть на поле боя = великая честь, За Ордуу...");
    }

    @Override
    public void applyingAbility(Enemy enemy, Enum e) {
        switch (e) {
            case MageAbility.Fire_Arrow:
                if (getMana() > MageAbility.Fire_Arrow.getManaCost()){
                    enemy.takeDamage(MageAbility.Fire_Arrow.getDamage());
                    setMana(getMana()-MageAbility.Fire_Arrow.getManaCost());
                }
                else System.out.println("Не могу применить способность, нету маны");
                break;
            case MageAbility.Fire_Bomb:
                if (getMana()>MageAbility.Fire_Bomb.getManaCost()){
                    enemy.takeDamage(MageAbility.Fire_Bomb.getDamage());
                    setMana(getMana()-MageAbility.Fire_Bomb.getManaCost());
                }
                else {
                    System.out.println("Не могу применить способность, нету маны");
                }
                break;
            default: System.out.println("Ты че придумал, Маг, у тебя такой способности нету");
        }
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }

    public void getInfo(){
        System.out.println(super.getName() + " Health: " + getHealth() + " Mana: " + getMana());
    }
}
