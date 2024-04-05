package com.aston.Lesson_4;

public class Circle implements Calculations, Colors {

    int radius;
    double p = 3.14;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * p * radius;
    }

    @Override
    public double calculateSquare() {
        return p * Math.pow(radius, 2);
    }

    @Override
    public void setBodyColor(String bodyColor) {
        System.out.println("Body color of circle is " + bodyColor);

    }

    @Override
    public void setBorderColor(String borderColor) {
        System.out.println("Border color of circle is " + borderColor);

    }
}
