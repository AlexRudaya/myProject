package com.aston.Lesson_4;

//** Применяя интерфейсы написать программу расчета периметра и площади геометрических фигур:
// круг, прямоугольник, треугольник.
//Задать для каждой фигуры цвет заливки и цвет границы.
//Результат полученных характеристик [ Периметр, площадь, цвет фона, цвет границ ] по каждой фигуре вывести в консоль. */
public class Figures {
    public static void main(String[] args) {

        Circle circle = new Circle(5);
        circle.setBodyColor("Red");
        circle.setBorderColor("Black");
        System.out.println("Circle perimeter is " + circle.calculatePerimeter());
        System.out.println("Circle square is " + circle.calculateSquare());
        System.out.println(); //как еще добавить пустую строку????
        Triangle triangle = new Triangle(5, 5, 5);
        triangle.setBodyColor("Yellow");
        triangle.setBorderColor("Blue");
        System.out.println("Triangle perimeter is " + triangle.calculatePerimeter());
        System.out.println("Triangle square is " + triangle.calculateSquare());
        System.out.println(); //как еще добавить пустую строку????
        Rectangle rectangle = new Rectangle(7, 9);
        rectangle.setBodyColor("Green");
        rectangle.setBorderColor("Purple");
        System.out.println("Rectangle perimeter is " + rectangle.calculatePerimeter());
        System.out.println("Rectangle square is " + rectangle.calculateSquare());
    }
}
