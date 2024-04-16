package com.aston.Lesson_6;


public class Phonebook {
    public static void main(String[] args) {
        Records records = new Records();
        records.add("1111111", "Ivanov");
        records.add("2222222", "Petrov");
        records.add("3333333", "Petrov");
        records.add("4444444", "Smirnof");
        records.add("5555555", "Ivanov");
        records.add("6666666", "Petrov");
        records.add("7777777", "Petrov");
        records.add("8888888", "Smirnof");

        System.out.println(records.get("Petrov"));
    }
}
