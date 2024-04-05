package com.aston.Lesson_4;

public class Plate {
    int size;
    int amount;

    public Plate(int size) {
        this.size = size;
    }

    public void addFood(int currentAmount, int additionalFood, int max) {
        while (currentAmount <= max) {
            currentAmount = currentAmount + additionalFood;
        }
        ;
        if (currentAmount > max) {
            int extraFood = currentAmount - max;
            System.out.println("You've added food. Plate if full, there is " + extraFood + " extra food left");
        } else {
            System.out.println("You've added food. There is " + currentAmount + " amount of food in the plate");
        }


    }

    //variant just to add food by portions without achieving the full plate
    public void addFoodVersion2(int currentAmount, int additionalFood, int max) {
        while (currentAmount + additionalFood <= max) {
            currentAmount = currentAmount + additionalFood;
        }
        System.out.println("There is " + currentAmount + " amount of food in the plate");

    }

    public int decreaseFood(int portion, int food) {
        return portion - food;
    }


}
