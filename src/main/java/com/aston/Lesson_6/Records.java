package com.aston.Lesson_6;

import java.util.*;

public class Records {
    private final HashMap<String, Set<String>> record;

    public Records() {
        this.record = new HashMap<>();
    }
    public void add(String name, String number){
        if (record.get(name)==null){
            record.put(name, new HashSet<>());
        }
        record.get(name).add(number);

    }
    public Set<String> get(String name){
        return record.get(name);
    }

}
