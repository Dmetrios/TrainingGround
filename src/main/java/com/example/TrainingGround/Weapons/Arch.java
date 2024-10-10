package com.example.TrainingGround.Weapons;

import com.example.TrainingGround.utils.RangeWeapons;

public class Arch implements RangeWeapons {

    private long id;
    private String name;
    private int damage;

    public Arch(long id, String name, int damage) {
        this.id = id;
        this.name = name;
        this.damage = damage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
