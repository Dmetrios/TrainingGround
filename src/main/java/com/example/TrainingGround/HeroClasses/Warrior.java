package com.example.TrainingGround.HeroClasses;

import com.example.TrainingGround.Enemy;
import com.example.TrainingGround.EnumHeroAbilityClasses.WarriorAbility;
import com.example.TrainingGround.Hero;
import com.example.TrainingGround.utils.MeleeWeapons;

public class Warrior<E extends MeleeWeapons> extends Hero {

    private int damage;
    private double criticalChance;
    private MeleeWeapons meleeWeapons;

    public Warrior(String name, int health, int mana, int damage, double criticalChance, MeleeWeapons meleeWeapons) {
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
            else enemy.takeDamage(damage + meleeWeapons.getDamage());
        }
    }

    @Override
    public void death() {
        System.out.println("Умереть на поле боя = великая честь, За Ордуу...");
    }

    @Override
    public void applyingAbility(Enemy enemy, Enum e) {
        switch (e) {
            case WarriorAbility.Hero_Strike:
                if (getMana() > WarriorAbility.Hero_Strike.getManaCost()){
                    enemy.takeDamage(WarriorAbility.Hero_Strike.getDamage());
                    setMana(getMana()-WarriorAbility.Hero_Strike.getManaCost());
                }
                else System.out.println("Не могу применить способность, нету маны");
                break;
            case WarriorAbility.Mortal_Strike:
                if (getMana()>WarriorAbility.Mortal_Strike.getManaCost()){
                    enemy.takeDamage(WarriorAbility.Mortal_Strike.getDamage());
                    setMana(getMana()-WarriorAbility.Mortal_Strike.getManaCost());
                }
                else {
                    System.out.println("Не могу применить способность, нету маны");
                }
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
