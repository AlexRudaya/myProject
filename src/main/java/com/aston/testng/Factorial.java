package com.aston.testng;

public class Factorial {

    public int getFactorial(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number can't be negative");
        }
        if (number > 31) {
            throw new IllegalArgumentException("Result is outOfBound");
        }
        int result = 1;
        for (int i = 1; i < number + 1; i++) {
            result *= i;
        }
        return result;
    }


}

