package com.aston.Lesson_3;

public class SearchPerson {
    public static void main(String[] args){
        Employee[] persons = new Employee[5];
        persons[0] = new Employee("Ivanov Ivan", "Developer", "ivan@mail.com", "111111", 3000, 40 );
        persons[1] = new Employee("Petrov Petr", "QA", "petr@mail.com", "222222", 2000, 30 );
        persons[2] = new Employee("Sergeev Serge", "BA", "serge@mail.com", "333333", 1800, 41 );
        persons[3] = new Employee("Alexandrov Alex", "PO", "alex@mail.com", "4444444", 2500, 55 );
        persons[4] = new Employee("Igorev Igor", "Team Lead", "igor@mail.com", "555555", 3500, 39 );
    }
}
