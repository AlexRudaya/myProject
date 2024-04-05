package com.aston.Lesson_4;

public class Triangle implements Colors, Calculations {

    double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public void setBorderColor(String borderColor) {
        System.out.println("Border color of triangle is " + borderColor);
    }

    ;

    @Override
    public void setBodyColor(String bodyColor) {
        System.out.println("Body color of triangle is " + bodyColor);
    }

    ;

    @Override
    public double calculateSquare() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    @Override
    public double calculatePerimeter() {
        return a + b + c;
    }
}
