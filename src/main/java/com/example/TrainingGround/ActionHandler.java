package com.example.TrainingGround;

import com.example.TrainingGround.EnumEnemyAbility.LichAbility;
import com.example.TrainingGround.EnumEnemyAbility.ZombieAbility;
import com.example.TrainingGround.EnumHeroAbilityClasses.ArcherAbility;
import com.example.TrainingGround.EnumHeroAbilityClasses.MageAbility;
import com.example.TrainingGround.EnumHeroAbilityClasses.WarriorAbility;

public class ActionHandler {

    public static void warriorHandler(Hero h, Enemy e, int i){
        switch (i){
            case 1: h.attackEnemy(e); break;
            case 2: h.applyingAbility(e, WarriorAbility.Hero_Strike); break;
            case 3: h.applyingAbility(e, WarriorAbility.Mortal_Strike); break;
        }
    }

    public static void archerHandler(Hero h, Enemy e, int i){
        switch (i){
            case 1: h.attackEnemy(e); break;
            case 2: h.applyingAbility(e, ArcherAbility.Power_Shot); break;
        }
    }

    public static void magicianHandler(Hero h, Enemy e, int i){
        switch (i){
            case 1: h.attackEnemy(e); break;
            case 2: h.applyingAbility(e, MageAbility.Fire_Arrow); break;
            case 3: h.applyingAbility(e, MageAbility.Fire_Bomb); break;
        }
    }

    public static void zombieHandler(Hero h, Enemy e, int i){
        switch (i){
            case 1: e.attackHero(h); break;
            case 2: e.applyingAbility(h, ZombieAbility.Power_Strike); break;
            case 3: e.applyingAbility(h, ZombieAbility.Revival); break;
        }
    }

    public static void lichHandler(Hero h, Enemy e, int i){
        switch (i){
            case 1: e.attackHero(h); break;
            case 2: e.applyingAbility(h, LichAbility.Desecrate); break;
            case 3: e.applyingAbility(h, LichAbility.Frost_Arrow);break;
        }
    }
}
