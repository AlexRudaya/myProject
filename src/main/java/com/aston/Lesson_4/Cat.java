package com.aston.Lesson_4;

public class Cat extends Animals{

    boolean hungryLevel=false;
    int canEat;

    static int amountCats=0;
    public Cat(String name){
        super(name); /*почему без этого ошибка?????*/
        this.name=name;
        amountCats++;
    }

    @Override
    public void run(int distance) {
        if (distance<=200){
        System.out.println(name+ " can run "+ distance);
        }
        else {
            System.out.println("Distance " + distance+ " is too much for " + name+ ", can do just 200");
        }
    }

    @Override
    public void swim(int distance) {
          System.out.println(name+ " can't swim ");
    }

    public static int getAmountCats(){
        return amountCats;
    }
}
