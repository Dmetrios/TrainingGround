package com.example.TrainingGround.HeroClasses;

import com.example.TrainingGround.Enemy;
import com.example.TrainingGround.EnumHeroAbilityClasses.ArcherAbility;
import com.example.TrainingGround.Hero;

public class Archer extends Hero {

    private int damage;
    private double criticalChance;

    public Archer(String name, int health, int mana, int damage, double criticalChance) {
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
            case ArcherAbility.Power_Shot:
                if (getMana() > ArcherAbility.Power_Shot.getManaCost()){
                    enemy.takeDamage(ArcherAbility.Power_Shot.getDamage());
                    setMana(getMana()-ArcherAbility.Power_Shot.getManaCost());
                }
                else System.out.println("Не могу применить способность, нету маны");
                break;
            default: System.out.println("Ты че придумал, Вар, у тебя такой способности нету");
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
