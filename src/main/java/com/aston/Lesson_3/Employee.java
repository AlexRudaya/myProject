package com.aston.Lesson_3;
/** *Создать класс &quot;Сотрудник&quot; с полями: ФИО, должность, email,
 телефон, зарплата, возраст.
 Конструктор класса должен заполнять эти поля при создании
 объекта.
 Внутри класса «Сотрудник» написать метод, который выводит
 информацию об объекте в консоль.
 2. Создать массив из 5 сотрудников.С помощью цикла вывести информацию только о сотрудниках
 старше 40 лет.
 *
 */

public class Employee {
    private final String fullName;
    private final String position;
    private final String email;
    private final String phone;
    private final int salary;
    private final int age;

    public Employee (String fullName, String position, String email, String phone, int salary, int age) {
        this.fullName=fullName;
        this.position=position;
        this.email=email;
        this.phone=phone;
        this.salary=salary;
        this.age=age;
    }

    public int getAge(){
        return age;
    }
    public void getInfo() {
        System.out.println ("Employee: " + fullName +" "+ position +" "+ email +" "+ phone +" "+ salary +" "+ age);
    }
}
