package com.aston.Lesson_5;

public class MyArrayDataException extends Exception{
    public MyArrayDataException (int i, int j, String value){
        super("Can't parse " + "'"+value +"'"+ " in cell " + i + "x" +j );
    }
}
