package com.example.TrainingGround.EnumEnemyAbility;

public enum LichAbility {
    Desecrate ("Осквернение", 70, 20),
    Frost_Arrow("Ледяная стрела", 50, 10);

    private final String title;
    private final int damage;
    private final int manaCost;

    LichAbility(String title, int damage, int manaCost) {
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
