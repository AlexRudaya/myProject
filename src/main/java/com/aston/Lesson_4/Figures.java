package com.aston.Lesson_4;
import java.text.DecimalFormat;

//** Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
// круг, прямоугольник, треугольник.
//Задать для каждой фигуры цвет заливки и цвет границы.
//Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль. */
public class Figures {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        Circle circle = new Circle(5);
        circle.setBodyColor("Red");
        circle.setBorderColor("Black");
        System.out.println("Circle perimeter is " + df.format(circle.calculatePerimeter()));
        System.out.println("Circle square is " + df.format(circle.calculateSquare()));
        System.out.println();
        Triangle triangle = new Triangle(5, 5, 5);
        triangle.setBodyColor("Yellow");
        triangle.setBorderColor("Blue");
        System.out.println("Triangle perimeter is " + df.format(triangle.calculatePerimeter()));
        System.out.println("Triangle square is " + df.format(triangle.calculateSquare()));
        System.out.println();
        Rectangle rectangle = new Rectangle(7, 9);
        rectangle.setBodyColor("Green");
        rectangle.setBorderColor("Purple");
        System.out.println("Rectangle perimeter is " + df.format(rectangle.calculatePerimeter()));
        System.out.println("Rectangle square is " + df.format(rectangle.calculateSquare()));
    }
}
