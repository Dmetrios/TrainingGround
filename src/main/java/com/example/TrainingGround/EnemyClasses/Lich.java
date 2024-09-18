package com.example.TrainingGround.EnemyClasses;

import com.example.TrainingGround.Enemy;
import com.example.TrainingGround.EnumEnemyAbility.LichAbility;
import com.example.TrainingGround.EnumHeroAbilityClasses.WarriorAbility;
import com.example.TrainingGround.Hero;

public class Lich extends Enemy {

    private static final int BASIC_DAMAGE = 100;
    private static final double BASIC_CRITICAL_CHANCE = 0.4d;

    public Lich(int health, int mana) {
        super(health, mana);
    }


    @Override
    public void attackHero(Hero hero) {
        if (Math.random() * 100d > 100d - BASIC_CRITICAL_CHANCE*100d)
            hero.takeDamage(BASIC_DAMAGE * 2);
        else hero.takeDamage(BASIC_DAMAGE);
    }

    @Override
    public void applyingAbility(Hero hero, Enum e) {
        switch (e) {
            case LichAbility.Desecrate:
                if (getMana() > LichAbility.Desecrate.getManaCost()) {
                    hero.takeDamage(LichAbility.Desecrate.getDamage());
                    setMana(getMana() - LichAbility.Desecrate.getManaCost());
                } else System.out.println("Не могу применить способность, нету маны");
                break;
            case LichAbility.Frost_Arrow:
                if (getMana() > LichAbility.Frost_Arrow.getManaCost()) {
                    hero.takeDamage(LichAbility.Frost_Arrow.getDamage());
                    setMana(getMana() - LichAbility.Frost_Arrow.getManaCost());
                } else {
                    System.out.println("Не могу применить способность, нету маны");
                }
                break;
            default:
                System.out.println("Ты че придумал, Лич, у тебя такой способности нету");
        }
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    @Override
    public void deth() {
        System.out.println("На этот раз победа за тобой смертный.");
    }

    // Переписать
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }

    public void getInfo(){
        System.out.println("Health: " + getHealth() + " Mana: " + getMana());
    }
}
