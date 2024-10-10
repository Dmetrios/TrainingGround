package com.example.TrainingGround.HeroClasses;

import com.example.TrainingGround.Enemy;
import com.example.TrainingGround.EnumHeroAbilityClasses.ArcherAbility;
import com.example.TrainingGround.Hero;
import com.example.TrainingGround.utils.RangeWeapons;

public class Archer<E extends RangeWeapons> extends Hero {

    private int damage;
    private double criticalChance;
    private RangeWeapons rangeWeapons;

    public Archer(String name, int health, int mana, int damage, double criticalChance, RangeWeapons rangeWeapons) {
        super(name, health, mana);
        this.damage = damage;
        this.criticalChance = criticalChance;
        this.rangeWeapons = rangeWeapons;
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()) {
            if (Math.random() * 100d > 100d - criticalChance)
                enemy.takeDamage(damage+ rangeWeapons.getDamage() * 2);
            else enemy.takeDamage(damage+rangeWeapons.getDamage());
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
