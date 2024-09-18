package com.example.TrainingGround;

import com.example.TrainingGround.EnemyClasses.Lich;
import com.example.TrainingGround.EnumEnemyAbility.LichAbility;
import com.example.TrainingGround.EnumHeroAbilityClasses.WarriorAbility;
import com.example.TrainingGround.HeroClasses.Warrior;

public class BattleGround {
    public static void main(String[] args) {
        Warrior warrior = new Warrior("BladeDeath", 100, 100, 100, 50);
        Lich lich = new Lich(1000, 1000);
        warrior.getInfo();
        warrior.attackEnemy(lich);
        System.out.println(lich.getHealth());
        warrior.getInfo();
        warrior.applyingAbility(lich, WarriorAbility.Hero_Strike);
        lich.applyingAbility(warrior, LichAbility.Desecrate);
        System.out.println(lich.getHealth());
        warrior.getInfo();
        warrior.applyingAbility(lich, WarriorAbility.Mortal_Strike);
        System.out.println(lich.getHealth());
        warrior.getInfo();
        warrior.attackEnemy(lich);
        System.out.println(lich.getHealth());
        warrior.attackEnemy(lich);
        System.out.println(lich.getHealth());
        warrior.attackEnemy(lich);
        System.out.println(lich.getHealth());
        warrior.getInfo();
    }
}
