package com.example.TrainingGround.Weapons;

import com.example.TrainingGround.utils.AxeWeapons;

public class DoubleAxe implements AxeWeapons {
    private long id;
    private String name;
    private int damage;


    public DoubleAxe(long id, String name, int damage) {
        this.id = id;
        this.name = name;
        this.damage = damage;
    }


    @Override
    public int getDamage() {
        return this.damage;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
