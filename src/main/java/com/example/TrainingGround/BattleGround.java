package com.example.TrainingGround;

import com.example.TrainingGround.EnemyClasses.Lich;
import com.example.TrainingGround.EnemyClasses.Zombie;
import com.example.TrainingGround.EnumEnemyAbility.LichAbility;
import com.example.TrainingGround.EnumHeroAbilityClasses.WarriorAbility;
import com.example.TrainingGround.HeroClasses.Archer;
import com.example.TrainingGround.HeroClasses.Mage;
import com.example.TrainingGround.HeroClasses.Warrior;

import java.util.ArrayList;
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

        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(lich);
        enemies.add(zombie);


        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(warrior);
        heroes.add(archer);
        heroes.add(mage);

        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int i, hCount = heroes.size();
        String a;

        while((warrior.isAlive() || archer.isAlive() || mage.isAlive() ) && (lich.isAlive()|| zombie.isAlive())){
            if(warrior.isAlive()) {
                System.out.println("В бой вступает ВАР");
                System.out.println("Кого ты будешь атаковать?");
                a = sc.next();
                System.out.println("Я атакую: " + a);
                i = sc.nextInt();
                if (a.equals("Zombie") && zombie.isAlive())
                    ActionHandler.warriorHandler(warrior, zombie, i);
                if (a.equals("Lich") && lich.isAlive())
                    ActionHandler.warriorHandler(warrior, lich, i);
            }
            else {
                heroes.remove(warrior);
                hCount--;
            }
            if(archer.isAlive()) {
                System.out.println("В бой вступает Лучник");
                System.out.println("Кого ты будешь атаковать?");
                a = sc.next();
                System.out.println("Я атакую: " + a);
                i = sc.nextInt();
                if (a.equals("Zombie") && zombie.isAlive())
                    ActionHandler.warriorHandler(archer, zombie, i);
                if (a.equals("Lich") && lich.isAlive())
                    ActionHandler.warriorHandler(archer, lich, i);
            }
            else {
                heroes.remove(archer);
                hCount--;
            }
            if(mage.isAlive()) {
                System.out.println("В бой вступает Маг");
                System.out.println("Кого ты будешь атаковать?");
                a = sc.next();
                System.out.println("Я атакую: " + a);
                i = sc.nextInt();
                if (a.equals("Zombie") && zombie.isAlive())
                    ActionHandler.warriorHandler(mage, zombie, i);
                if (a.equals("Lich") && lich.isAlive())
                    ActionHandler.warriorHandler(mage, lich, i);
            }
            else {
                heroes.remove(mage);
                hCount--;
            }
            if(zombie.isAlive() )
                ActionHandler.zombieHandler(heroes.get(random.nextInt(hCount)),zombie, random.nextInt(3)+1);
            if(lich.isAlive())
                ActionHandler.lichHandler(heroes.get(random.nextInt(hCount)), lich, random.nextInt(2)+1);
            warrior.getInfo();
            archer.getInfo();
            mage.getInfo();
            zombie.getInfo();
            lich.getInfo();
        }
    }
}
