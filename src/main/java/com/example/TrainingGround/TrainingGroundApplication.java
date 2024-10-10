package com.example.TrainingGround;

import com.example.TrainingGround.HeroClasses.Warrior;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


public class TrainingGroundApplication {

	public static void main(String[] args) {
		Callme target = new Callme();
		Caller ob1 = new Caller(target, "Dobro");
		Caller ob2 = new Caller(target, "v");
		Caller ob3 = new Caller(target, "world");

		try {
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		}catch (InterruptedException e){
			System.out.println("Prervan");
		}
		System.out.println("Glavniy zavershen");
	}

}

class NewThread extends Thread{
	Thread t;

	NewThread(){
		super("Demonstration");
		System.out.println("Docha: " + t);
		start();
	}

	public void run(){
		try {
			for (int i=5; i>0; i--){
				System.out.println("Docha: " + i);
				Thread.sleep(500);
			}
		}catch (InterruptedException e) {
			System.out.println("Docha prervana");
		}
		System.out.println("Zavershen");
	}
}

class Callme {
	synchronized void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException е) {
			System.out.println("Пpepвaнo");
			System.out.println("J ");
		}
		System.out.println("]");
	}
}

class Caller implements Runnable{
	String msg;
	final Callme target;
	Thread t;

	public Caller(Callme targ, String s){
		target = targ;
		msg = s;
		t = new Thread(this);
		t.start();
	}
	public void run(){
		synchronized (target){
			target.call(msg);
		}
	}
}