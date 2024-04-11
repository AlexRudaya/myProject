package com.aston.Lesson_7;

public class Factorial {

    private final int number;
    public Factorial(int number){
        this.number=number;
        }
    public int getFactorial(){
        int result=1;
        for (int i=1; i<number+1; i++){
            result *= i;
        }
        return result;
    }
}

