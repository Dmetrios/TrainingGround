package com.example.TrainingGround.HeroClasses;

import com.example.TrainingGround.Enemy;
import com.example.TrainingGround.EnumHeroAbilityClasses.MageAbility;
import com.example.TrainingGround.Hero;
import com.example.TrainingGround.utils.MeleeWeapons;
import com.example.TrainingGround.utils.Stick;

public class Mage<E extends MeleeWeapons> extends Hero {

    private int damage;
    private double criticalChance;
    private MeleeWeapons meleeWeapons;

    public Mage(String name, int health, int mana, int damage, double criticalChance, MeleeWeapons meleeWeapons) {
        super(name, health, mana);
        this.damage = damage;
        this.criticalChance = criticalChance;
        this.meleeWeapons = meleeWeapons;
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()) {
            if (Math.random() * 100d > 100d - criticalChance)
                enemy.takeDamage(damage+ meleeWeapons.getDamage() * 2);
            else enemy.takeDamage(damage+meleeWeapons.getDamage());
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
