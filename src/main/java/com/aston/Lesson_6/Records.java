package com.aston.Lesson_6;

import java.util.*;

public class Records {
    //для наглядности первой реализации оставлю эту часть закоменченной
//    private final HashMap<String, Set<String>> record;

//    public Records() {
//        this.record = new HashMap<>();
//    }
//
//    public void add(String name, String number) {
//        if (record.get(name) == null) {
//            record.put(name, new HashSet<>());
//        }
//        record.get(name).add(number);
//
//    }
//
//    public Set<String> get(String name) {
//        return record.get (name);
//    }

    private final HashMap<String, String> record;

    public Records() {
        this.record = new HashMap<>();
    }

    public void add(String number, String name) {
        record.put(number, name);
    }

    public List<String> get(String name) {
        List<String> phones = new ArrayList<>();
        for (Map.Entry<String, String> o : record.entrySet()) {
            if (o.getValue().equals(name)) {
                phones.add(o.getKey());
            }
        }
        return phones;
    }

}
