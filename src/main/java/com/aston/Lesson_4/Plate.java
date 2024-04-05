package com.aston.Lesson_4;

public class Plate {
    private int size;
    int amount;

    public Plate(int size) {
        this.size = size;
        this.amount = size;
    }

    //variant to add food by portions and after achieving the full extra is calculated
    public void addFood(int additionalFood) {
        while (amount < size) {
            amount = amount + additionalFood;
        }
        if (amount > size) {
            int extraFood = amount - size;
            System.out.println("You've added food. Plate is full, there is " + extraFood + " extra food left");
        } else {
            System.out.println("You've added food. There is " + amount + " amount of food in the plate");
        }


    }

    //variant just to add food by portions without achieving the full plate
    public void addFoodVersion2(int additionalFood) {
        while (amount + additionalFood <= size) {
            amount = amount + additionalFood;
        }
        System.out.println("There is " + amount + " amount of food in the plate");

    }

    public boolean decreaseFood(int food) {
        if (amount >= food) {
            amount = amount - food;
            return true;
        }
        return false;
    }

    public int getAmount() {
        return amount;
    }
}
