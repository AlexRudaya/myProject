package com.aston.Lesson_6;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    public static void main(String[] args) {
        Records records= new Records();
        records.add("Ivanov","33333");
        records.add("Petrov","222222");
        records.add("Ivanov","111111");
        records.add("Stepanov","222222");
        records.add("Ivanov","111111");
        records.add("Ivanov","555555");

        System.out.println(records.get("Ivanov"));
    }
}
