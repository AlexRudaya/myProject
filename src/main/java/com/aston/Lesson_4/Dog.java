package com.aston.Lesson_4;

public class Dog extends Animals {
    private static int amountDogs = 0;

    public Dog(String name) {
        super(name);
        amountDogs++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(getName() + " can run " + distance);
        } else {
            System.out.println("Distance " + distance + " is too much for " + getName() + ", can do just 500");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(getName() + " can swim " + distance);
        } else {
            System.out.println("Distance " + distance + " is too much for " + getName() + ", can do just 10");
        }
    }

    public static int getAmountDogs() {
        return amountDogs;
    }
}
