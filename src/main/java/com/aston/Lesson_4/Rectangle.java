package com.aston.Lesson_4;

public class Rectangle implements Calculations, Colors {
    int a, b;

    public Rectangle(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void setBodyColor(String bodyColor) {
        System.out.println("Body color of rectangle is " + bodyColor);
    }

    @Override
    public void setBorderColor(String borderColor) {
        System.out.println("Border color of rectangle is " + borderColor);

    }

    @Override
    public double calculateSquare() {
        return a * b;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (a + b);
    }
}
