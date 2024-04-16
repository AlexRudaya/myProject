package com.aston.Lesson_6;


public class Phonebook {
    public static void main(String[] args) {
        Records records = new Records();
        records.add("11111", "Ivanov");
        records.add("22222", "Petrov");
        records.add("333333", "Petrov");
        records.add("333333", "Smirnof");
        records.add("444444", "Ivanov");
        records.add("555555", "Petrov");
        records.add("666666", "Petrov");
        records.add("111111", "Smirnof");

        System.out.println(records.get("Petrov"));
    }
}
