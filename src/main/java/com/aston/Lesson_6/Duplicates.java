package com.aston.Lesson_6;

import java.util.*;

import static java.util.Collections.frequency;

public class Duplicates {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("one");
        arrayList.add("three");
        arrayList.add("four");
        arrayList.add("three");

       System.out.println("Initial list: " + arrayList);


        ArrayList<String> oneEntry = new ArrayList<>();
        for (int i=0;i<arrayList.size();i++){
            int count=0;
            for (int j=0;j<arrayList.size();j++)
                if (arrayList.get(i) == arrayList.get(j)) {
                    count = count + 1;
                }
            if (count==1) {
                oneEntry.add(arrayList.get(i));
           }
        }
        System.out.println("List of values met once: "+oneEntry);

        HashSet<String> uniqueValues = new HashSet<>(arrayList);
        System.out.println("Unique values from the arrayList: "+ uniqueValues);

        HashMap<String, Integer> list = new HashMap<String, Integer>();
        for (int i = 0; i < arrayList.size(); i++) {
            list.put(arrayList.get(i), frequency(arrayList, arrayList.get(i)));
        }
        System.out.println("Amount of every input: " + list);



    }
}
