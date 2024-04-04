package com.aston.Lesson_4;

public class Animals {
    String name;
    static int amountAnimals = 0;
    public Animals(String name) {
        this.name = name;
        amountAnimals++;
    }

    public void run(int distance){
        System.out.println("Animal run");
    }

    public void swim(int distance){
        System.out.println("Animal swim");
    }

    public static int getAmountAnimals(){ //почему статик????
        return amountAnimals;
    }
}
