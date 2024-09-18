package com.example.TrainingGround.EnumHeroAbilityClasses;

public enum MageAbility {
    Fire_Arrow ("Огненная стрела", 100, 10),
    Fire_Bomb("Огненная бомба",300, 30);

    private final String title;
    private final int damage;
    private final int manaCost;


    MageAbility(String title, int damage, int manaCost) {
        this.title = title;
        this.damage = damage;
        this.manaCost = manaCost;
    }

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }
}
