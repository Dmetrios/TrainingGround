package com.example.TrainingGround.EnemyClasses;

import com.example.TrainingGround.Enemy;
import com.example.TrainingGround.EnumEnemyAbility.ZombieAbility;
import com.example.TrainingGround.Hero;

public class Zombie extends Enemy {

    private static final int BASIC_DAMAGE = 200;
    private static final double BASIC_CRITICAL_CHANCE = 0.5d;

    public Zombie(int health, int mana) {
        super(health, mana);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }

    @Override
    public void attackHero(Hero hero) {
        if (Math.random() * 100d > 100d - BASIC_CRITICAL_CHANCE*100d)
            hero.takeDamage(BASIC_DAMAGE * 2);
        else hero.takeDamage(BASIC_DAMAGE);
    }

    @Override
    public void deth() {
        System.out.println("На этот раз победа за тобой мешок с костями.");
    }

    @Override
    public void applyingAbility(Hero hero, Enum e) {
        switch (e) {
            case ZombieAbility.Revival:
                if (getMana() > ZombieAbility.Revival.getManaCost()) {
                    setHealth(1000);
                    setMana(getMana() - ZombieAbility.Revival.getManaCost());
                } else System.out.println("Не могу применить способность, нету маны");
                break;
            case ZombieAbility.Power_Strike:
                if (getMana() > ZombieAbility.Power_Strike.getManaCost()) {
                    hero.takeDamage(ZombieAbility.Power_Strike.getDamage());
                    setMana(getMana() - ZombieAbility.Power_Strike.getManaCost());
                } else {
                    System.out.println("Не могу применить способность, нету маны");
                }
                break;
            default:
                System.out.println("Ты че придумал, Зомбарь, у тебя такой способности нету");
        }
    }

    @Override
    public boolean isAlive() {
        return super.isAlive();
    }

    public void getInfo(){
        System.out.println("Health: " + getHealth() + " Mana: " + getMana());
    }
}
