package com.example.TrainingGround.EnumHeroAbilityClasses;

public enum WarriorAbility {
    Hero_Strike ("Удар героя", 200, 30),
    Mortal_Strike("Смертельный удар", 350, 50);

    private final String title;
    private final int damage;
    private final int manaCost;

    WarriorAbility(String title, int damage, int manaCost) {
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

    public String getTitle() {
        return title;
    }
}
