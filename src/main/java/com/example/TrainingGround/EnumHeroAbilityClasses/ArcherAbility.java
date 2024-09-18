package com.example.TrainingGround.EnumHeroAbilityClasses;

public enum ArcherAbility {
    Power_Shot ("Заряженный выстрел", 200, 30);

    private final String title;
    private final int damage;
    private final int manaCost;

    ArcherAbility(String title, int damage, int manaCost) {
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
