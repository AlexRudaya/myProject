package com.aston.Lesson_4;

public class Cat extends Animals {

    boolean hungryLevel = false;
    private int canEat;

    private static int amountCats = 0;

    public Cat(String name) {
        super(name);
        amountCats++;
    }

    public Cat(String name, int canEat){
        this(name);
        this.canEat=canEat;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(getName() + " can run " + distance);
        } else {
            System.out.println("Distance " + distance + " is too much for " + getName() + ", can do just 200");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " can't swim ");
    }

    public static int getAmountCats() {
        return amountCats;
    }

    public int getCanEat() {
        return canEat;
    }
}
