package com.example.TrainingGround.EnumEnemyAbility;

public enum ZombieAbility {
    Revival ("Возрождение", 0, 70),
    Power_Strike("Мощный удар", 200, 20);

    private String title;
    private int damage;
    private int manaCost;

    ZombieAbility(String title, int damage, int manaCost) {
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
