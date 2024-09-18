package com.example.TrainingGround;

import com.example.TrainingGround.EnemyClasses.Lich;
import com.example.TrainingGround.EnemyClasses.Zombie;
import com.example.TrainingGround.EnumEnemyAbility.LichAbility;
import com.example.TrainingGround.EnumHeroAbilityClasses.WarriorAbility;
import com.example.TrainingGround.HeroClasses.Archer;
import com.example.TrainingGround.HeroClasses.Mage;
import com.example.TrainingGround.HeroClasses.Warrior;

import java.util.Random;
import java.util.Scanner;

public class BattleGround {
    public static void main(String[] args) {
        //Heroes
        Warrior warrior = new Warrior("BladeDeath", 2000, 300, 100, 50);
        Archer archer = new Archer("Ewqetsfa", 1000, 150, 150, 70);
        Mage mage = new Mage("Magician", 500, 500, 50, 40);

        //Enemies
        Lich lich = new Lich(1000, 1000);
        Zombie zombie = new Zombie(1000, 100);

        Enemy[] enemies = {lich, zombie};
        Hero[] heroes = {warrior, archer, mage};
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int i;
        String a;

        while((warrior.isAlive() || archer.isAlive() || mage.isAlive() ) && (lich.isAlive()|| zombie.isAlive())){
            System.out.println("В бой вступает ВАР");
            System.out.println("Кого ты будешь атаковать?");
            a = sc.next();
            System.out.println("Я атакую: " + a);
            i = sc.nextInt();
            if(a.equals("Zombie"))
                ActionHandler.warriorHandler(warrior,zombie,i);
            if(a.equals("Lich"))
                ActionHandler.warriorHandler(warrior,lich,i);
            System.out.println("В бой вступает Лучник");
            System.out.println("Кого ты будешь атаковать?");
            a = sc.next();
            System.out.println("Я атакую: " + a);
            i = sc.nextInt();
            if(a.equals("Zombie"))
                ActionHandler.warriorHandler(warrior,zombie,i);
            if(a.equals("Lich"))
                ActionHandler.warriorHandler(warrior,lich,i);
            System.out.println("В бой вступает Маг");
            System.out.println("Кого ты будешь атаковать?");
            a = sc.next();
            System.out.println("Я атакую: " + a);
            i = sc.nextInt();
            if(a.equals("Zombie"))
                ActionHandler.warriorHandler(warrior,zombie,i);
            if(a.equals("Lich"))
                ActionHandler.warriorHandler(warrior,lich,i);
            ActionHandler.zombieHandler(warrior,zombie, random.nextInt(3)+1);
            ActionHandler.lichHandler(warrior, lich, random.nextInt(2)+1);
            warrior.getInfo();
            archer.getInfo();
            mage.getInfo();
            zombie.getInfo();
            lich.getInfo();
        }
    }
}
